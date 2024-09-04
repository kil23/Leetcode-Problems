# Write your MySQL query statement below
SELECT name 
from Employee
where id in (
    select managerId
    from Employee
    Group By managerId
    Having Count(*) >=5
)