# Write your MySQL query statement below
SELECT a.product_name,b.year,b.price
FROM Sales as b
LEFT JOIN Product as a
ON b.product_id = a.product_id;