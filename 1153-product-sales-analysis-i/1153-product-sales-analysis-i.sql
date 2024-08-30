# Write your MySQL query statement below
SELECT p.product_name, s.year, s.price
From Sales s Left Join Product p
on s.product_id = p.product_id;