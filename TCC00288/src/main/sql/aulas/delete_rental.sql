ALTER TABLE payment
DROP CONSTRAINT IF EXISTS payment_rental_id_fkey;

ALTER TABLE payment
ADD CONSTRAINT payment_rental_id_fkey
    FOREIGN KEY (rental_id)
    REFERENCES public.rental (rental_id) MATCH SIMPLE
    ON UPDATE CASCADE ON DELETE RESTRICT;

DROP FUNCTION IF EXISTS delete_rental();
CREATE OR REPLACE FUNCTION delete_rental(
    p_rental_id integer)
  RETURNS void AS '
DECLARE
BEGIN
    DELETE FROM rental WHERE rental_id = p_rental_id;
END;'
  LANGUAGE plpgsql