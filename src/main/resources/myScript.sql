select o.productName
from Orders o
join o.customers p
where p.name = :name
group by o.productName