/* Write your PL/SQL query statement below */
SELECT
    SUBSTR(event_day, 0, 10) day,
    emp_id,
    SUM(out_time - in_time) total_time
FROM employees
GROUP BY event_day, emp_id
;
