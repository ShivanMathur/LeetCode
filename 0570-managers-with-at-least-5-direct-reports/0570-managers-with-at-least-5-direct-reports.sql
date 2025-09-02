-- Write your PostgreSQL query statement below

select e.name
from employee e
join employee m
on e.id = m.managerId
group by e.name, m.managerId
having count(m.managerId) >= 5;