# Write your MySQL query statement below
SELECT p.product_name,
SUM(o.unit) AS unit
FROM Products p
INNER JOIN Orders o
ON p.product_id=o.product_id
WHERE YEAR(order_date)='2020' AND MONTH(order_date)='02'
-- WHERE o.order_date BETWEEN '2020-02-01' AND '2020-02-28'
GROUP BY p.product_id
HAVING SUM(o.unit)>=100;