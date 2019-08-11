WITH Rank AS (
    SELECT a.Score, row_number() over (ORDER BY Score DESC) Rank
    FROM (
             SELECT DISTINCT ROUND(Score, 2) Score
             FROM Scores
             ORDER BY Score DESC
         ) a
)
SELECT ROUND(a.Score, 2) Score, b.Rank
FROM Scores a
         JOIN Rank b ON a.Score = b.Score
ORDER BY b.Rank
;
