# Write your MySQL query statement below
SELECT c.name AS Customers
FROM Customers c
WHERE c.id NOT IN(
SELECT c.id
FROM Customers c
INNER JOIN Orders o
WHERE c.id=o.customerId);