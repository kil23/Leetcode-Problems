# Write your MySQL query statement below
SELECT query_name, ROUND(AVG(rating/position), 2) as quality,
Round(Avg(if(rating<3, 1, 0) * 100),2) as poor_query_percentage
from Queries
WHere query_name is not null
Group by query_name;