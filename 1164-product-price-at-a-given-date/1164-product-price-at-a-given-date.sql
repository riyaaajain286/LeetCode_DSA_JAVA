# Write your MySQL query statement below
SELECT r.product_id,
      COALESCE(t.new_price,10) AS price
FROM
(SELECT DISTINCT product_id
FROM Products) r
LEFT JOIN
(
    SELECT product_id,
    new_price
    FROM Products
    WHERE(product_id,change_date) in
    (
        SELECT product_id,
        MAX(change_date) AS latest_date
        FROM Products 
        WHERE change_date<='2019-08-16'
        GROUP BY product_id
    )
)t
ON r.product_id=t.product_id;

