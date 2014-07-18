use bookstore17

select
	e.fname,
	e.lname,
	e.repid,
	e.supervisor,
	s.fname,
	s.lname,
	m.fname,
	m.lname,
	b.fname,
	b.lname
from slspers as e
inner join slspers as s on e.supervisor = s.repid
inner join slspers as m on s.supervisor = m.repid
inner join slspers as b on m.supervisor = b.repid