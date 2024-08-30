# Write your MySQL query statement below
Select u.unique_id, e.name
from EmployeeUNI u RIGHT JOIN Employees e
on u.id = e.id;