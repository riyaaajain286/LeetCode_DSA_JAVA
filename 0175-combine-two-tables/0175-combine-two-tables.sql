# Write your MySQL query statement below
SELECT
-- p is short name for person table and a for address table
    p.firstName,
    p.lastName,
    a.city,
    a.state
FROM Person p
LEFT JOIN Address a
ON p.personId=a.personId;
