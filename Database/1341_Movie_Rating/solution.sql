/* Write your PL/SQL query statement below */
SELECT name results
FROM (
  SELECT name, cnt
  FROM (
    SELECT u.name, COUNT(1) cnt
    FROM users u JOIN movierating mr ON u.user_id = mr.user_id
    GROUP BY u.name
  ) a
  ORDER BY cnt DESC, name ASC
)
WHERE ROWNUM = 1
UNION ALL
SELECT title results
FROM (
  SELECT title, max_rating
  FROM (
    SELECT m.title, AVG(mr.rating) max_rating
    FROM movies m JOIN movierating mr ON m.movie_id = mr.movie_id
    WHERE TO_CHAR(mr.created_at, 'YYYY-MM') = '2020-02'
    GROUP BY m.title
  ) a
  ORDER BY max_rating DESC, title ASC
)
WHERE ROWNUM = 1
