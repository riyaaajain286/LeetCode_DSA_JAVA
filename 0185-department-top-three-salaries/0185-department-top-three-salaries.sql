# Write your MySQL query statement below
SELECT d.name AS Department,
       x.name AS Employee,
       x.salary AS Salary
FROM Department d
JOIN (
    SELECT *,
    DENSE_RANK() OVER(PARTITION BY departmentId ORDER by salary DESC) AS rnk
    from Employee
) x
ON x.departmentId=d.id
WHERE x.rnk<4;