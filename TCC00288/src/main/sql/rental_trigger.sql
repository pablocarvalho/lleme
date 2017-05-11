DROP FUNCTION IF EXISTS rental_restriction_checking() CASCADE;
CREATE OR REPLACE FUNCTION rental_restriction_checking() RETURNS trigger AS '
    BEGIN
        IF NOT EXISTS (SELECT staff_id
                       FROM staff
                       WHERE staff_id = NEW.staff_id
                             AND active
                             AND store_id = (SELECT store_id
                                             FROM inventory
                                             WHERE inventory_id = NEW.inventory_id
                                             FOR SHARE OF inventory)
                       FOR SHARE OF staff) THEN
            RAISE EXCEPTION $$Erro: staff nao habilitado!$$;
        END IF;

        IF EXISTS (SELECT rental_id
               FROM rental
               WHERE inventory_id = NEW.inventory_id
                     AND rental_id <> COALESCE(OLD.rental_id,NEW.rental_id)
                     AND (rental_date BETWEEN NEW.rental_date AND COALESCE(NEW.return_date, $$infinity$$::TIMESTAMP)
                          OR return_date BETWEEN NEW.rental_date AND COALESCE(NEW.return_date, $$infinity$$::TIMESTAMP))
               FOR SHARE OF rental) THEN
            RAISE EXCEPTION $$Erro: midia já alugada!$$;
        END IF;

        IF (WITH
                t1 AS (SELECT
                           COALESCE (t1.return_date,current_timestamp) -
                           (t1.rental_date + t3.rental_duration * $$1 day$$::INTERVAL) as delay
                       FROM rental t1
                            INNER JOIN inventory t2 ON t2.inventory_id = t1.inventory_id
                            INNER JOIN film t3 ON t3.film_id = t2.film_id
                       WHERE t1.customer_id = NEW.customer_id
                             AND t1.rental_id <> COALESCE(OLD.rental_id,NEW.rental_id)
                             AND t1.rental_date >= (NEW.rental_date - $$6 months$$::INTERVAL)
                       FOR SHARE OF t1, t2, t3)
            SELECT SUM(delay) FROM t1 WHERE delay > $$0 microseconds$$::INTERVAL) > INTERVAL $$15 days$$ THEN
            RAISE EXCEPTION $$Erro: atraso acumulado excedido!$$;
        END IF;

        IF EXISTS (WITH
                        rt AS (SELECT
                                   NEW.rental_id AS rental_id,
                                   NEW.rental_date AS rental_date,
                                   NEW.inventory_id AS inventory_id,
                                   NEW.customer_id AS customer_id,
                                   NEW.return_date AS return_date,
                                   NEW.staff_id AS staff_id),
                        t1 AS (SELECT
                                   rental_date AS target_date
                               FROM rental
                               WHERE rental_id <> OLD.rental_id
                                     AND customer_id = NEW.customer_id
                                     AND rental_date > NEW.rental_date
                               FOR SHARE OF rental),
                        t2 AS (SELECT
                                   t1.target_date,
                                   COALESCE (t21.return_date,$$infinity$$::TIMESTAMP) -
                                   (t21.rental_date + t23.rental_duration * $$1 day$$::INTERVAL) as delay
                           FROM t1
                                INNER JOIN rental t21 ON t21.rental_date >= t1.target_date - $$6 months$$::INTERVAL
                                                         AND t21.customer_id = NEW.customer_id
                                                         AND t21.rental_id <> COALESCE(OLD.rental_id,NEW.rental_id)
                                INNER JOIN inventory t22 ON t22.inventory_id = t21.inventory_id
                                INNER JOIN film t23 ON t23.film_id = t22.film_id
                           FOR SHARE OF t21, t22, t23),
                        t3 AS (SELECT
                                   t1.target_date,
                                   COALESCE (rt.return_date,$$infinity$$::TIMESTAMP) -
                                   (rt.rental_date + t33.rental_duration * $$1 day$$::INTERVAL) as delay
                               FROM t1
                                    INNER JOIN rt ON trt.rental_date >= t1.target_date - $$6 months$$::INTERVAL
                                                     AND rt.customer_id = NEW.customer_id
                                    INNER JOIN inventory t32 ON t32.inventory_id = rt.inventory_id
                                    INNER JOIN film t33 ON t33.film_id = t32.film_id
                               WHERE rt.customer_id = NEW.customer_id
                                     AND rt.rental_id <> NEW.rental_id
                                     AND rt.rental_date >= NEW.rental_date - $$6 months$$::INTERVAL)
                   SELECT t4.target_date, SUM(t4.delay) AS delay
                   FROM (SELECT * FROM t2 UNION SELECT * FROM t3) t4
                   WHERE t4.delay > $$0 microseconds$$::INTERVAL
                   GROUP BY t4.target_date
                   HAVING SUM(t4.delay) > INTERVAL $$15 days$$) THEN
            RAISE EXCEPTION $$Erro: atraso acumulado excedido no futuro!$$;
        END IF;


        RETURN NEW;
    END;' LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS rental_update ON rental;
CREATE TRIGGER rental_update BEFORE INSERT OR UPDATE ON rental
    FOR EACH ROW EXECUTE PROCEDURE rental_restriction_checking();



























