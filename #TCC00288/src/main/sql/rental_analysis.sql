DROP FUNCTION IF EXISTS rental_analysis();
CREATE OR REPLACE FUNCTION rental_analysis()
RETURNS TABLE (
  rental_id integer,
  rental_date timestamp without time zone,
  due_date timestamp without time zone,
  replacement_date timestamp without time zone,
  return_date timestamp without time zone,
  target_date timestamp without time zone,
  rental_rate numeric(4,2),
  late_fee double precision,
  replacement_cost numeric(5,2),
  payment_date timestamp without time zone,
  paid_amount numeric,
  due_amount double precision,
  balance double precision) AS '
DECLARE
BEGIN

    RETURN;
END;
' LANGUAGE plpgsql
