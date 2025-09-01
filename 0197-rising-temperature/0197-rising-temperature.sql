-- Write your PostgreSQL query statement below
-- Approach 1: Using sub-query
-- SELECT w1.id 
-- from weather w1
-- where exists (select 1 from weather w2 where w1.recordDate = w2.recordDate+1 and w1.temperature > w2.temperature);

-- Approach 2: Using Joins
select w1.id from weather w1
join weather w2
on w1.recordDate = w2.recordDate+1
where w1.temperature > w2.temperature;