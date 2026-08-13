# Write your MySQL query statement below
UPDATE Salary set sex=
CASE WHEN sex='m' THEN 'f'
ELSE 'm'
END;