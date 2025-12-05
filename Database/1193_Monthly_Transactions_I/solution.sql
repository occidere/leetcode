/* Write your PL/SQL query statement below */
WITH tmp AS (
  SELECT
    TO_CHAR(trans_date, 'YYYY-MM') month,
    CASE
        WHEN country IS NULL THEN 'null'
        ELSE country
    END AS country,
    state,
    amount
  FROM transactions
)
SELECT
  total.month,
  CASE
    WHEN total.country = 'null' THEN null
    ELSE total.country
  END AS country,
  total.cnt trans_count,
  COALESCE(approved.cnt, 0) approved_count,
  total.amount trans_total_amount,
  COALESCE(approved.amount, 0) approved_total_amount
FROM (
  SELECT month, country, COUNT(1) cnt, SUM(amount) amount
  FROM tmp
  GROUP BY month, country
) total LEFT JOIN (
  SELECT month, country, COUNT(1) cnt, SUM(amount) amount
  FROM tmp
  WHERE state = 'approved'
  GROUP BY month, country
) approved ON (total.month = approved.month AND total.country = approved.country)
ORDER BY month, country
;
