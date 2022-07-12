/* Write your PL/SQL query statement below */
SELECT
    a.name,
    SUM(
        CASE
            WHEN b.distance IS NULL THEN 0
            ELSE b.distance
        END
    ) travelled_distance
FROM users a
    LEFT JOIN rides b ON a.id = b.user_id
GROUP BY a.id, a.name
ORDER BY
    travelled_distance DESC,
    a.name ASC
;
