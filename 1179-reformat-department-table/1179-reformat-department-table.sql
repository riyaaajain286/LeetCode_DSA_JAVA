# Write your MySQL query statement below
SELECT id,
   SUM(Case WHEN month='Jan' THEN revenue END) AS Jan_Revenue,
   SUM(Case WHEN month='Feb' THEN revenue END) AS Feb_Revenue,
   SUM(Case WHEN month='Mar' THEN revenue END) AS Mar_Revenue,
   SUM(Case WHEN month="Apr" THEN revenue END) AS Apr_Revenue,
   SUM(Case WHEN month="May" THEN revenue END) AS May_Revenue,
   SUM(Case WHEN month="Jun" THEN revenue END) AS Jun_Revenue,
   SUM(Case WHEN month="Jul" THEN revenue END) AS Jul_Revenue,
   SUM(Case WHEN month="Aug" THEN revenue END) AS Aug_Revenue,
   SUM(Case WHEN month="Sep" THEN revenue END) AS Sep_Revenue,
   SUM(Case WHEN month="Oct" THEN revenue END) AS Oct_Revenue,
   SUM(Case WHEN month="Nov" THEN revenue END) AS Nov_Revenue,
   SUM(Case WHEN month="Dec" THEN revenue END) AS Dec_Revenue
From Department
Group by id;