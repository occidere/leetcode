/* Write your PL/SQL query statement below */
WITH cte1 AS (
    SELECT employee_id
    FROM employees
    WHERE manager_id = 1 AND employee_id != 1;
), cte2 AS (
    SELECT b.employee_id
    FROM cte1 a, employees b
    WHERE a.employee_id = b.manager_id
), cte3 AS (
    SELECT b.employee_id
    FROM cte2 a, employees b
    WHERE a.employee_id = b.manager_id
)
SELECT employee_id
FROM cte1
UNION
SELECT employee_id
FROM cte2
UNION
SELECT employee_id
FROM cte3
;
