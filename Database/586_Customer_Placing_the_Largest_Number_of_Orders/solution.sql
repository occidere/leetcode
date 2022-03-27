/* Write your PL/SQL query statement below */
WITH tmp AS (
    SELECT customer_number, COUNT(customer_number) cnt
    FROM orders
    GROUP BY customer_number
    ORDER BY cnt DESC
)
SELECT a.customer_number
FROM (
    SELECT customer_number, cnt
    FROM tmp
    WHERE rownum = 1
) a, tmp b
WHERE a.cnt = b.cnt
;
