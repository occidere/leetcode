/* Write your PL/SQL query statement below */
SELECT
    SUBSTR(activity_date, 0, 10) day,
    COUNT(DISTINCT user_id) active_users
FROM activity
WHERE
    activity_date > TO_DATE('2019-07-27', 'YYYY-MM-DD') - 30
    AND activity_date < TO_DATE('2019-07-28', 'YYYY-MM-DD')
GROUP BY activity_date
;
