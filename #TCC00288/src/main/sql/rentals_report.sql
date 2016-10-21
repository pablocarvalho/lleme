DROP FUNCTION IF EXISTS rentals_report();
CREATE OR REPLACE FUNCTION rentals_report()
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
  --#OK, WE NEED TO CALCULATE THE CURRENT BALANCE GIVEN A CUSTOMER_ID AND A DATE
  --#THAT WE WANT THE BALANCE TO BE EFFECTIVE FOR. THE BALANCE IS:
  --#   1) RENTAL FEES FOR ALL PREVIOUS RENTALS
  --#   2) ONE DOLLAR FOR EVERY DAY THE PREVIOUS RENTALS ARE OVERDUE
  --#   3) IF A FILM IS MORE THAN RENTAL_DURATION * 2 OVERDUE, CHARGE THE REPLACEMENT_COST
  --#   4) SUBTRACT ALL PAYMENTS MADE BEFORE THE DATE SPECIFIED
  RETURN QUERY WITH
    t1 AS (SELECT t1.rental_id,
                  t1.rental_date,
                  t1.rental_date + t3.rental_duration * $$1 day$$::interval due_date,
                  t1.rental_date + 2 * t3.rental_duration * $$1 day$$::interval replacement_date,
                  t1.return_date,
                  COALESCE (t1.return_date,current_date) target_date,
                  t3.rental_rate,
                  (EXTRACT (EPOCH FROM t1.return_date)-EXTRACT (EPOCH FROM (t1.rental_date + t3.rental_duration * $$1 day$$::interval)))/(24*60*60) late_fee,
                  t3.replacement_cost,
                  t4.payment_date,
                  COALESCE (t4.amount,0) paid_amount
           FROM rental t1
                INNER JOIN inventory t2 ON t2.inventory_id = t1.inventory_id
                INNER JOIN film t3 ON t3.film_id = t2.film_id
                LEFT JOIN payment t4 ON t4.rental_id = t1.rental_id
           WHERE t4.rental_id IS NULL
           FOR SHARE OF t1, t2, t3, t4),
    t2 AS (SELECT t1.*,
                  CASE
                    WHEN t1.target_date <= t1.due_date THEN t1.rental_rate
                    WHEN t1.target_date <= t1.replacement_date THEN t1.rental_rate + t1.late_fee
                    ELSE t1.replacement_cost
                  END due_amount
           FROM t1)
  SELECT *, (t2.paid_amount - t2.due_amount) balance
  FROM t2
  ORDER BY t2.due_amount DESC;
  -- If FOR UPDATE, FOR NO KEY UPDATE, FOR SHARE or FOR KEY SHARE is specified,
  -- the SELECT statement locks the selected rows against concurrent updates.

  RETURN;
END;
' LANGUAGE plpgsql
