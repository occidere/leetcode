-- OracleSQL
SELECT DISTINCT(Num) ConsecutiveNums
FROM (
    SELECT Num, Id, ROW_NUMBER() OVER (PARTITION BY Num ORDER BY Id) row_num
    FROM Logs
) a
GROUP BY Num, Id - row_num
HAVING COUNT(1) > 2
;
