# Write your MySQL query statement below
SELECT visited_on,
SUM(amount) OVER(
    ORDER BY visited_on
    ROWS BETWEEN 6 PRECEDING AND CURRENT ROW)as amount,
ROUND(AVG(amount) OVER(
    ORDER BY visited_on
    ROWS BETWEEN 6 PRECEDING AND CURRENT ROW),2)
as average_amount
-- The subquery is used because one date can have multiple customers/rows, but the window function should work on one total amount per day.
FROM (
SELECT visited_on,
SUM(amount) AS amount
FROM Customer
GROUP BY visited_on
) AS x
LIMIT 100 OFFSET 6;