# Write your MySQL query statement below
SELECT s.machine_id,
round(AVG(e.timestamp-s.timestamp),3) as processing_time 
FROM Activity s
JOIN Activity e
ON s.machine_id=e.machine_id 
AND s.process_id =e.process_id 
AND s.activity_type ='start'
AND e.activity_type ='end'
GROUP BY machine_id ;

-- Take Activity as s (start)
-- Join Activity as e (end)

-- Match:
-- same machine
-- same process
-- s must be start
-- e must be end

-- Then:
-- end timestamp - start timestamp

-- Then:
-- average per machine