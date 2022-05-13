/* Write your PL/SQL query statement below */
SELECT
    user_id,
    UPPER(SUBSTR(name, 0, 1)) || LOWER(SUBSTR(name, 2)) name
FROM users
ORDER BY user_id
;
