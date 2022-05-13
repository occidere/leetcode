/* Write your PL/SQL query statement below */
SELECT employee_id
FROM (
    SELECT
        NVL(a.employee_id, b.employee_id) employee_id
    FROM employees a
        FULL OUTER JOIN salaries b ON a.employee_id = b.employee_id
    WHERE a.name IS NULL OR b.salary IS NULL
) a
ORDER BY employee_id
;
