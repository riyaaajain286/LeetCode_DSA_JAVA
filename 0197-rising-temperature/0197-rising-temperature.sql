# Write your MySQL query statement below
SELECT currentDay.id
FROM Weather currentDay
JOIN Weather previousDay
ON DATEDIFF(currentDay.recordDate,previousDay.recordDate )=1
WHERE currentDay.temperature >previousDay.temperature
ORDER BY id;


-- Take currentDay
-- Join with previousDay
-- where currentDay is 1 day after previousDay
-- and currentDay temperature > previousDay temperature