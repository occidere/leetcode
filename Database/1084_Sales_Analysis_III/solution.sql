/* Write your PL/SQL query statement below */
SELECT product_id, product_name
FROM product
WHERE product_id NOT IN (
    SELECT product_id
    FROM sales
    WHERE
        SUBSTR(sale_date, 0, 10) < '2019-01-01'
        OR SUBSTR(sale_date, 0, 10) > '2019-03-31'
)
;
