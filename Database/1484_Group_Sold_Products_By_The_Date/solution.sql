/* Write your PL/SQL query statement below */
SELECT
    SUBSTR(sell_date, 0, 10) sell_date,
    COUNT(DISTINCT product) num_sold, LISTAGG(product, ',') WITHIN GROUP (ORDER BY product) products
FROM (
    SELECT DISTINCT sell_date, product
    FROM activities
) a
GROUP BY sell_date
ORDER BY sell_date
;
