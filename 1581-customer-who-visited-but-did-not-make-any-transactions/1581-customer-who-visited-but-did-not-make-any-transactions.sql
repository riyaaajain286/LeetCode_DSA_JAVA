# Write your MySQL query statement below
SELECT v.customer_id,COUNT(*) AS count_no_trans
FROM Visits as v
WHERE v.visit_id NOT IN(SELECT visit_id FROM Transactions)
GROUP BY customer_id;