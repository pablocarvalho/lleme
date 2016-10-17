CREATE OR REPLACE FUNCTION public.rent_film2(
    p_inventory_id integer,
    p_customer_id integer,
    p_staff_id integer)
  RETURNS void AS '
DECLARE
    v_now timestamp := current_timestamp AT TIME ZONE $$2:00$$;
    v_delay interval;
    v_rented boolean := FALSE;
    v_staff_allowed boolean := FALSE;
BEGIN
    IF (WITH
            t1 AS (SELECT t2.payment_date - t1.return_date AS delay
                   FROM rental t1 NATURAL JOIN payment t2
                   WHERE t1.customer_id = p_customer_id
                         AND return_date >= (v_now - INTERVAL $$6 months$$)
                   FOR SHARE OF t1, t2)
        SELECT SUM(delay) FROM t1) > INTERVAL $$15 days$$ THEN
        RAISE EXCEPTION $$Erro: atraso excedido!$$;
    END IF;

    IF EXISTS (SELECT rental_id
               FROM rental
               WHERE inventory_id = p_inventory_id
                     AND v_now BETWEEN rental_date AND COALESCE(return_date, v_now)
               FOR SHARE OF rental) THEN
        RAISE EXCEPTION $$Erro: midia já alugada!$$;
    END IF;

    IF NOT EXISTS (SELECT staff_id
                   FROM staff
                   WHERE staff_id = p_staff_id
                         AND store_id = (SELECT store_id
                                         FROM inventory
                                         WHERE inventory_id = p_inventory_id
                                         FOR SHARE OF inventory)
                   FOR SHARE OF staff) THEN
        RAISE EXCEPTION $$Erro: staff nao permitido!$$;
    END IF;

    INSERT INTO rental(rental_date,inventory_id,customer_id,staff_id)
    VALUES (current_date,p_inventory_id,p_customer_id,p_staff_id);

    RAISE NOTICE $$Aluguel registrado$$;

    --EXCEPTION WHEN OTHERS THEN RAISE NOTICE $$Error: INSERT rolled back!$$;
END; '
  LANGUAGE plpgsql ;
