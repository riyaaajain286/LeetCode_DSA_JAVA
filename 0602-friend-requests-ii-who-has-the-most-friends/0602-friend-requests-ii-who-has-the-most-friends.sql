# Write your MySQL query statement below
SELECT x.total_id as id,
COUNT(*) AS num
FROM(
SELECT requester_id AS total_id FROM RequestAccepted
UNION ALL
SELECT accepter_id  AS total_id FROM RequestAccepted
) x

GROUP BY x.total_id
ORDER BY num DESC
limit 1;