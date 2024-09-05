# Write your MySQL query statement below
SELECT contest_id, Round(count(user_id) * 100.0 / (Select count(user_id) from Users), 2) as percentage
From Register 
Group by contest_id
order by percentage desc, contest_id;