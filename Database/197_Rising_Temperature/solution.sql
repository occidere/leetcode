-- OracleSQL
SELECT a.Id
FROM
    Weather a,
    Weather b
WHERE
    a.RecordDate - b.RecordDate = 1 AND
    a.Temperature > b.Temperature
ORDER BY a.Id
;
