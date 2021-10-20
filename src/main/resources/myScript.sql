select O.product_name
from ORDERS O
join CUSTOMERS C on O.customer_id = C.id
where lcase(C.name) = :name
GROUP BY O.product_name;