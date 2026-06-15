# Write your MySQL query statement below
SELECT 
   d.name AS Department,
   x.name AS Employee,
   x.salary AS Salary
   FROM(
    SELECT
      e.*,
     DENSE_RANK() OVER(partition by departmentId ORDER BY salary DESC) as rnk
     FROM  Employee e
)as x
JOIN Department d
ON x.departmentId=d.id
where x.rnk=1;