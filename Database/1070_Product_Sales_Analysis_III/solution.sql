/* Write your PL/SQL query statement below */
SELECT s.product_id, f.first_year, s.quantity, s.price
FROM sales s JOIN (
  SELECT product_id, MIN(year) first_year
  FROM sales
  GROUP BY product_id
) f ON s.product_id = f.product_id AND s.year = f.first_year
