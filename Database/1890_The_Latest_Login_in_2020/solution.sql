/* Write your PL/SQL query statement below */
SELECT
    user_id,
    MAX(time_stamp) last_stamp
FROM logins
GROUP BY
    user_id,
    SUBSTR(time_stamp, 0, 4)
HAVING SUBSTR(time_stamp, 0, 4) = '2020'
;
