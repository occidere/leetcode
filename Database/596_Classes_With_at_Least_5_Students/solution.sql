-- Write your PostgreSQL query statement below
SELECT class
FROM courses
GROUP BY class
HAVING COUNT(1) >= 5
;
