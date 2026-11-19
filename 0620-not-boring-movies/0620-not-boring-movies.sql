# Write your MySQL query statement below
SELECT c.*
FROM Cinema c
WHERE id%2=1 && description <> "boring" 
ORDER BY rating DESC;
