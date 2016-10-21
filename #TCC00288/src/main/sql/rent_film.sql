DROP FUNCTION IF EXISTS rent_film();
CREATE OR REPLACE FUNCTION rent_film(
    p_inventory_id integer,
    p_customer_id integer,
    p_staff_id integer)
  RETURNS boolean AS '
DECLARE
    c_rentals CURSOR (key integer) FOR SELECT t1.return_date, t2.payment_date
                                       FROM rental t1 NATURAL JOIN payment t2
                                       WHERE t1.customer_id = key
                                            AND return_date >= (current_date - INTERVAL $$6 months$$)
                                       FOR SHARE OF rental, payment;
    v_delay interval;

BEGIN
  SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;

  FOR r IN c_rentals(p_customer_id) LOOP
    v_delay = v_delay + (r.payment_date-r.return_date);
  END LOOP;

  IF v_delay > interval $$15 days$$ THEN
    RAISE EXCEPTION $$Erro: tolerancia no atraso de pagamento foi exedida!$$;
  ELSE
    INSERT INTO rental(rental_date,inventory_id,customer_id,staff_id) VALUES (current_date,p_inventory_id,p_customer_id,p_staff_id);
    COMMIT;
  END IF;
END;'
  LANGUAGE plpgsql