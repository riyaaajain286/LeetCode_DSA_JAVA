# Write your MySQL query statement below
SELECT score,
DENSE_RANK() OVER( order by score DESC ) as 'rank'
FROM Scores;