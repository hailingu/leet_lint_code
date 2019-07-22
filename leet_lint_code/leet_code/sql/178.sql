SELECT a.Score as Score,
       (SELECT COUNT(DISTINCT b.Score) FROM Scores b WHERE b.Score >= a.Score) as Rank
FROM Scores a ORDER BY Score DESC