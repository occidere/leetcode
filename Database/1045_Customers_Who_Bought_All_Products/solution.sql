/* Write your PL/SQL query statement below */
WITH tmp AS (
  SELECT COUNT(product_key) cnt
  FROM product
)
SELECT a.customer_id
FROM (
  SELECT c.customer_id, COUNT(DISTINCT c.product_key) cnt
  FROM customer c
  GROUP BY c.customer_id
) a JOIN tmp t ON a.cnt = t.cnt
