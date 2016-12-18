DROP FUNCTION IF EXISTS rent_film_2();
CREATE OR REPLACE FUNCTION public.rent_film_2(
    p_inventory_id integer,
    p_customer_id integer,
    p_staff_id integer)
    RETURNS void AS '
DECLARE
    v_now timestamp := now()::timestamp;
BEGIN
    IF NOT EXISTS (SELECT staff_id
                   FROM staff
                   WHERE staff_id = p_staff_id
                         AND acive
                         AND store_id = (SELECT store_id
                                         FROM inventory
                                         WHERE inventory_id = p_inventory_id
                                         FOR SHARE OF inventory)
                   FOR SHARE OF staff) THEN
        RAISE EXCEPTION $$Erro: staff nao habilitado!$$;
    END IF;

    IF EXISTS (SELECT rental_id
               FROM rental
               WHERE inventory_id = p_inventory_id
                     AND (rental_date BETWEEN v_now AND $$infinity$$::TIMESTAMP
                          OR return_date BETWEEN v_now AND $$infinity$$::TIMESTAMP)
               FOR SHARE OF rental) THEN
        RAISE EXCEPTION $$Erro: midia já alugada!$$;
    END IF;

    IF (WITH
            t1 AS (SELECT t2.payment_date - t1.return_date AS delay
                   FROM rental t1 INNER JOIN payment t2 ON t1.rental_id = t2.rental_id
                   WHERE t1.customer_id = p_customer_id
                         AND rental_date >= (v_now - INTERVAL $$6 months$$)
                   FOR SHARE OF t1, t2)
        SELECT SUM(delay) FROM t1) > INTERVAL $$15 days$$ THEN
        RAISE EXCEPTION $$Erro: atraso acumulado excedido!$$;
    END IF;


    INSERT INTO rental(rental_date,inventory_id,customer_id,staff_id)
    VALUES (v_now,p_inventory_id,p_customer_id,p_staff_id);

    --PERFORM pg_sleep(30);

    RAISE NOTICE $$Aluguel registrado$$;
END;
' LANGUAGE plpgsql ;
