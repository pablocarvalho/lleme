DROP FUNCTION IF EXISTS rental_analysis(d1 date, d2 date);
CREATE OR REPLACE FUNCTION rental_analysis(d1 date, d2 date)
RETURNS TABLE (
    store_id smallint
    ,rating mpaa_rating
    ,film character varying(255)
    ,year_ smallint
    ,year_month integer
    ,rental_date date
    ,available double precision
    ,executed double precision) AS '
DECLARE
BEGIN
    LOCK TABLE inventory, film, film_category, category IN ROW EXCLUSIVE MODE;

    DROP TABLE IF EXISTS temp1;
    CREATE TEMP TABLE temp1 ON COMMIT DROP AS
    WITH
        RECURSIVE t1 AS (
            SELECT d1 AS rental_date
	    UNION
	    SELECT (t1.rental_date + $$1 day$$::interval)::date
            FROM t1
	    WHERE t1.rental_date < d2)
    SELECT * FROM t1;

    DROP TABLE IF EXISTS temp2;
    CREATE TEMP TABLE temp2 ON COMMIT DROP AS
    WITH
        t1 AS (SELECT
                    t11.store_id
                    , t12.rating
                    , t12.film_id
                    , SUM(t12.rental_rate/t12.rental_duration) AS rate
               FROM
                    inventory t11
                    INNER JOIN film t12 ON t11.film_id = t12.film_id
               GROUP BY t11.store_id, t12.rating, t12.film_id)
    SELECT
        t1.store_id
        , t1.rating
        , t1.film_id
        , temp1.rental_date
        , t1.rate
    FROM temp1, t1;

    DROP TABLE IF EXISTS temp3;
    CREATE TEMP TABLE temp3 ON COMMIT DROP AS
    SELECT
        t11.store_id
        , t12.rating
        , t12.film_id
        , t10.rental_date::date
        , MAX(COALESCE (t10.return_date,t15.payment_date)::date) AS return_date
        , SUM(t15.amount) / MAX(COALESCE (t10.return_date,t15.payment_date)::date - t10.rental_date::date + 1) AS rate
    FROM rental t10
        INNER JOIN inventory t11 ON t11.inventory_id = t10.inventory_id
        INNER JOIN film t12 ON t12.film_id = t11.film_id
        INNER JOIN payment t15 ON t15.rental_id = t10.rental_id
    GROUP BY t11.store_id, t12.rating, t12.film_id, t10.rental_date::date;


    RETURN
    QUERY
    SELECT
        t1.store_id
        , t1.rating
        , t4.title
        , EXTRACT(YEAR FROM t1.rental_date)::smallint
        , (EXTRACT(YEAR FROM t1.rental_date) * 100 + EXTRACT(MONTH FROM t1.rental_date))::integer
        , t1.rental_date
        , t1.rate::double precision AS available
        , t2.rate::double precision AS executed
    FROM temp2 t1
         INNER JOIN film t4 ON t4.film_id = t1.film_id
         LEFT JOIN temp3 t2 ON t1.store_id = t2.store_id
                                AND t1.rating = t2.rating
                                AND t1.film_id = t2.film_id
                                AND t1.rental_date BETWEEN t2.rental_date and t2.return_date;
    RETURN;
END;
' LANGUAGE plpgsql

/*
select store_id, year_month, sum(executed)/sum(available)*100 performance
from rental_analysis('2005-05-01'::date,'2007-12-31'::date)
group by store_id, year_month
order by store_id, year_month;

*/