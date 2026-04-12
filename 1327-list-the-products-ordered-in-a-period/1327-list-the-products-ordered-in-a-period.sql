# Write your MySQL query statement below
select p.product_name, sum(o.unit) as unit from products p
join orders o on p.product_id=o.product_id
where year(order_date)='2020' and month(order_date)='02'
group by p.product_name
having sum(o.unit)>=100;