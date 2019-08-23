-- OracleSQL
SELECT
    ROW_NUMBER() OVER (ORDER BY id) id,
    student
FROM (
    SELECT 
        CASE
            WHEN (MOD(id, 2) = 0) THEN id - 1
            ELSE id + 1
        END AS id,
    student
    FROM seat
) a
ORDER BY id
;
