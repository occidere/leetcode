/* Write your PL/SQL query statement below */
SELECT name
FROM salesperson 
WHERE sales_id NOT IN (
    SELECT sales_id
    FROM orders a
        JOIN (SELECT com_id FROM company WHERE name = 'RED') b
        ON a.com_id = b.com_id
)
;
