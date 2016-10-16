CREATE OR REPLACE FUNCTION public.rent_film2(
    p_inventory_id integer,
    p_customer_id integer,
    p_staff_id integer)
  RETURNS void AS '
DECLARE
    v_now timestamp := clock_timestamp();
    v_delay interval;
    v_rented boolean := FALSE;
    v_staff_allowed boolean := FALSE;
BEGIN
  --SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;

  WITH
    t1 AS (SELECT t2.payment_date - t1.return_date AS delay
           FROM rental t1 NATURAL JOIN payment t2
           WHERE t1.customer_id = p_customer_id
                 AND return_date >= (current_date - INTERVAL $$6 months$$)
           FOR SHARE OF t1, t2)
  SELECT SUM(delay) INTO v_delay FROM t1;

  IF v_delay > interval $$15 days$$ THEN
    RAISE EXCEPTION $$Erro: atraso excedido!$$;
  END IF;

  IF EXISTS (SELECT t1.rental_id
             FROM rental t1
             WHERE t1.inventory_id = p_inventory_id
                   AND v_now BETWEEN t1.rental_date AND COALESCE(t1.return_date, v_now)
             FOR SHARE OF t1) THEN
    v_rented := TRUE;
  ELSE
    v_rented := FALSE;
  END IF;

  IF v_rented THEN
    RAISE EXCEPTION $$Erro: midia já alugada!$$;
  END IF;

  IF EXISTS (SELECT t1.rental_id
             FROM rental t1
             WHERE t1.inventory_id = p_inventory_id
                   AND v_now BETWEEN t1.rental_date AND COALESCE(t1.return_date, v_now)
             FOR SHARE OF t1) THEN
    v_staff_allowed := TRUE;
  ELSE
    v_staff_allowed := FALSE;
  END IF;

  IF NOT v_staff_allowed THEN
    RAISE EXCEPTION $$Erro: staff nao permitido!$$;
  END IF;

  INSERT INTO rental(rental_date,inventory_id,customer_id,staff_id)
  VALUES (current_date,p_inventory_id,p_customer_id,p_staff_id);

  EXCEPTION
    WHEN OTHERS THEN
      ROLLBACK;
      RAISE NOTICE $$Error rolled back!$$;
END; '
  LANGUAGE plpgsql ;
