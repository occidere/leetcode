/* Write your PL/SQL query statement below */
SELECT
    a.customer_id,
    COUNT(1) count_no_trans
FROM visits a
    LEFT JOIN transactions b ON a.visit_id = b.visit_id
WHERE b.transaction_id IS NULL
GROUP BY a.customer_id
;
