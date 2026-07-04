# Write your MySQL query statement below
SELECT pw.id
FROM Weather pw
JOIN Weather nw
ON DATEDIFF(pw.recordDate,nw.recordDate )=1
WHERE pw.temperature >nw.temperature
ORDER BY id;