/* Write your PL/SQL query statement below */
SELECT actor_id, director_id
FROM actordirector
GROUP BY actor_id, director_id
HAVING COUNT(1) >= 3
;
