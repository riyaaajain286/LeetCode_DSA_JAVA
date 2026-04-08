CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE val INT;
  SET val=N-1;
  RETURN (
      # Write your MySQL query statement below.
     SELECT DISTINCT salary
     FROM Employee
     ORDER  BY salary DESC
     LIMIT val,1
  );
END