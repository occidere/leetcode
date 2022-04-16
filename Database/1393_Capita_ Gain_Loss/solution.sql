/* Write your PL/SQL query statement below */
SELECT stock_name, SUM(price) capital_gain_loss
FROM (
    SELECT
        stock_name,
        CASE
            WHEN operation = 'Buy' THEN -price
            ELSE price
        END AS price
    FROM stocks
) a
GROUP BY stock_name
;
