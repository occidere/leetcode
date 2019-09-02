-- OracleSQL
WITH oct AS (  
    SELECT request_at, status
    FROM trips
    WHERE 
        client_id NOT IN (SELECT DISTINCT users_id FROM users WHERE banned = 'Yes') AND
        driver_id NOT IN (SELECT DISTINCT users_id FROM users WHERE banned = 'Yes') AND
        request_at BETWEEN '2013-10-01' AND '2013-10-03'
)
SELECT
    total.request_at day,
    ROUND(COALESCE(cancel.cnt / total.cnt, 0.0f), 2) "Cancellation Rate"
FROM
    (
        SELECT request_at, COUNT(1) cnt
        FROM oct
        GROUP BY request_at
    ) total 
    FULL OUTER JOIN
    (
        SELECT request_at, COUNT(1) cnt
        FROM oct
        WHERE status != 'completed'
        GROUP BY request_at
    ) cancel
ON total.request_at = cancel.request_at
ORDER BY total.request_at
;

