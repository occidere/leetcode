/* Write your PL/SQL query statement below */
SELECT
    a.user_id buyer_id,
    SUBSTR(a.join_date, 0, 10) join_date,
    SUM(
        CASE
            WHEN b.order_date IS NULL THEN 0
            ELSE 1
        END
    ) orders_in_2019
FROM users a
    LEFT JOIN (
        SELECT
            buyer_id,
            order_date
        FROM orders
        WHERE SUBSTR(order_date, 0, 4) = '2019'
    ) b
    ON a.user_id = b.buyer_id
GROUP BY a.user_id, a.join_date
;
