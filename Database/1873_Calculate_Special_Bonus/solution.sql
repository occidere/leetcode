/* Write your PL/SQL query statement below */
SELECT employee_id, salary bonus
FROM (
    SELECT employee_id, salary
    FROM employees
    WHERE MOD(employee_id, 2) = 1 AND SUBSTR(name, 0, 1) != 'M'
    UNION
    SELECT employee_id, 0
    FROM employees
    WHERE MOD(employee_id, 2) = 0 OR SUBSTR(name, 0, 1) = 'M'
)
ORDER BY employee_id
;
