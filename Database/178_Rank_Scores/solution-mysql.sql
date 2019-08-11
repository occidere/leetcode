SELECT a.Score,
       (
           SELECT COUNT(DISTINCT b.Score) + 1
           FROM Scores b
           WHERE a.Score < b.Score
       ) Rank
FROM Scores a
ORDER BY a.Score DESC
;
