-- Oracle (pl/sql)
WITH tmp AS (
	    SELECT activity, COUNT(1) cnt
	        FROM friends
		    GROUP BY activity
	)
SELECT activity
FROM tmp
WHERE (SELECT MIN(cnt) FROM tmp) < cnt
  AND cnt < (SELECT MAX(cnt) FROM tmp)
;
