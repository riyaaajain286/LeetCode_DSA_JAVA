# Write your MySQL query statement below
SELECT c.*
FROM Cinema c
WHERE (id%2)!=0 AND description!="boring"
ORDER BY rating DESC;