/* Write your PL/SQL query statement below */
SELECT
    SUBSTR(sale_date, 0, 10) sale_date,
    SUM(CASE fruit WHEN 'apples' THEN sold_num ELSE 0 END) - SUM(CASE fruit WHEN 'oranges' THEN sold_num ELSE 0 END) diff
FROM sales
GROUP BY sale_date
ORDER BY sale_date
;
