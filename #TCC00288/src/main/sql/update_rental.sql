DROP FUNCTION IF EXISTS update_rental();
CREATE OR REPLACE FUNCTION update_rental(
    p_rental_id integer,
    p_rental_date timestamp without time zone,
    p_inventory_id integer,
    p_customer_id smallint,
    p_return_date timestamp without time zone,
    p_staff_id smallint)
    RETURNS void AS '
DECLARE
    c_rental CURSOR (key integer) FOR SELECT *
                                  FROM rental
                                  WHERE rental_id = key
                                  FOR UPDATE OF rental;
    v_rental rental%ROWTYPE;
BEGIN
    OPEN c_rental(p_rental_id);
    FETCH c_rental INTO v_rental;

    IF NOT FOUND THEN
        RAISE EXCEPTION $$Erro: aluguel não existe!$$;
    END IF;

    IF NOT EXISTS (SELECT staff_id
                   FROM staff
                   WHERE staff_id = p_staff_id
                         AND active
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
                     AND rental_id <> p_rental_id
                     AND (rental_date BETWEEN p_rental_date AND COALESCE(p_return_date, $$infinity$$::TIMESTAMP)
                          OR return_date BETWEEN p_rental_date AND COALESCE(p_return_date, $$infinity$$::TIMESTAMP))
               FOR SHARE OF rental) THEN
        RAISE EXCEPTION $$Erro: midia já alugada!$$;
    END IF;

    IF (WITH
            t1 AS (SELECT
                        COALESCE (p_return_date,$$infinity$$::TIMESTAMP) -
                        (p_rental_date + t3.rental_duration * $$1 day$$::INTERVAL) as delay
                   FROM rental t1
                        INNER JOIN inventory t2 ON t2.inventory_id = t1.inventory_id
                        INNER JOIN film t3 ON t3.film_id = t2.film_id
                   WHERE t1.customer_id = p_customer_id
                         AND t1.rental_id <> p_rental_id
                         AND t1.rental_date >= (p_rental_date - $$6 months$$::INTERVAL)
                   FOR SHARE OF t1, t2, t3)
        SELECT SUM(delay) FROM t1 WHERE delay > $$0 microseconds$$::INTERVAL) > INTERVAL $$15 days$$ THEN
        RAISE EXCEPTION $$Erro: atraso acumulado excedido!$$;
    END IF;

    IF EXISTS (WITH
                    rt AS (SELECT
                                p_rental_id AS rental_id,
                                p_rental_date AS rental_date,
                                p_inventory_id AS inventory_id,
                                p_customer_id AS customer_id,
                                p_return_date AS return_date,
                                p_staff_id AS staff_id),
                    t1 AS (SELECT rental_date AS target_date
                           FROM rental
                           WHERE rental_id <> p_rental_id
                                 AND customer_id = p_customer_id
                                 AND rental_date > p_rental_date
                           FOR SHARE OF rental),
                    t2 AS (SELECT
                                t1.target_date,
                                COALESCE (t21.return_date,$$infinity$$::TIMESTAMP) -
                                (t21.rental_date + t23.rental_duration * $$1 day$$::INTERVAL) as delay
                           FROM t1
                                INNER JOIN rental t21 ON t21.rental_date >= t1.target_date - $$6 months$$::INTERVAL
                                                         AND t21.customer_id = p_customer_id
                                                         AND t21.rental_id <> p_rental_id
                                INNER JOIN inventory t22 ON t22.inventory_id = t21.inventory_id
                                INNER JOIN film t23 ON t23.film_id = t22.film_id
                           FOR SHARE OF t21, t22, t23),
                    t3 AS (SELECT
                                t1.target_date,
                                COALESCE (rt.return_date,$$infinity$$::TIMESTAMP) -
                                (rt.rental_date + t33.rental_duration * $$1 day$$::INTERVAL) as delay
                           FROM t1
                                INNER JOIN rt ON trt.rental_date >= t1.target_date - $$6 months$$::INTERVAL
                                                 AND rt.customer_id = p_customer_id
                                INNER JOIN inventory t32 ON t32.inventory_id = rt.inventory_id
                                INNER JOIN film t33 ON t33.film_id = t32.film_id
                           WHERE rt.customer_id = p_customer_id
                                 AND rt.rental_id <> p_rental_id
                                 AND rt.rental_date >= p_rental_date - $$6 months$$::INTERVAL)
               SELECT t4.target_date, SUM(t4.delay) AS delay
               FROM (SELECT * FROM t2 UNION SELECT * FROM t3) t4
               WHERE t4.delay > $$0 microseconds$$::INTERVAL
               GROUP BY t4.target_date
               HAVING SUM(t4.delay) > INTERVAL $$15 days$$) THEN
        RAISE EXCEPTION $$Erro: atraso acumulado excedido no futuro!$$;
    END IF;

    UPDATE rental
    SET
        rental_date = p_rental_date,
        inventory_id = p_inventory_id,
        customer_id = p_customer_id,
        return_date = p_return_date,
        staff_id = p_staff_id
    WHERE CURRENT OF c_rental;
    CLOSE c_rental;
END;
' LANGUAGE plpgsql