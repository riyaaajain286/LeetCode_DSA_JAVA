# Write your MySQL query statement below
SELECT d.name as Department ,x.name as Employee,x.salary as Salary
FROM  
(
SELECT *,
DENSE_RANK() OVER(PARTITION BY departmentId ORDER BY salary DESC) AS rnk
FROM Employee
) x
JOIN Department d
ON d.id=x.departmentId 
WHERE x.rnk<=3;