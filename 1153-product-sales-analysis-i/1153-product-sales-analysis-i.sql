# Write your MySQL query statement below
SELECT p.product_name, s.year, s.price
From Sales s, Product p
where s.product_id = p.product_id;