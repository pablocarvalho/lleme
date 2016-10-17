DROP FUNCTION update_rental_rate();
CREATE OR REPLACE FUNCTION update_rental_rate(p_rating mpaa_rating, p_factor real) RETURNS VOID AS '
DECLARE
    c_film CURSOR (k_rating mpaa_rating) FOR SELECT *
                                             FROM film
                                             WHERE rating = k_rating
                                             FOR UPDATE OF film;
BEGIN
    FOR r IN c_film(p_rating) LOOP
      UPDATE film SET rental_rate = rental_rate * p_factor WHERE CURRENT OF c_film;
    END LOOP;

    RAISE NOTICE $$Precos atualizados.$$;
END;
' LANGUAGE plpgsql

