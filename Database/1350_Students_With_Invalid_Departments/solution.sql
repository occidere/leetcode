/* Write your PL/SQL query statement below */
SELECT a.id, a.name
FROM students a 
  LEFT OUTER JOIN departments b
  ON a.department_id = b.id
WHERE b.id IS NULL
;
