-- Write your PostgreSQL query statement below
SELECT eu.unique_id, e.name
from employees e
left join employeeuni eu
on e.id = eu.id;