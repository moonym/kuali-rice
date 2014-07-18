use bookstore17

select
	partnum,
	repid,
	sum(qty) as 'Total'
from sales
where qty is not null
group by partnum,repid
having sum(qty) >= 500
order by 2,'total'