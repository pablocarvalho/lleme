CREATE OR REPLACE FUNCTION public.rent_film2(
    p_inventory_id integer,
    p_customer_id integer,
    p_staff_id integer)
  RETURNS void AS '
DECLARE
    v_delay interval;
BEGIN
  SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;

  WITH
    t1 AS (SELECT t2.payment_date - t1.return_date AS delay
           FROM rental t1 NATURAL JOIN payment t2
           WHERE t1.customer_id = key
                 AND return_date >= (current_date - INTERVAL $$6 months$$)
                 FOR SHARE OF rental, payment)
  SELECT SUM(delay) INTO v_delay FROM t1;

  IF v_delay > interval $$15 days$$ THEN
    RAISE EXCEPTION $$Erro: tolerancia no atraso de pagamento foi exedida!$$;
  ELSE
    INSERT INTO rental(rental_date,inventory_id,customer_id,staff_id) VALUES (current_date,p_inventory_id,p_customer_id,p_staff_id);
    COMMIT;
  END IF;
END; '
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.rent_film2(integer, integer, integer)
  OWNER TO postgres;
