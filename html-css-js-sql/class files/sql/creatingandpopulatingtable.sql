use bookstore17


/*
create table potential_customers1
(
	custnum varchar(10) constraint custkey primary key,
	referredby varchar(20),
	custname varchar(20) not null,
	address varchar(40) not null,
	mobileno varchar(10) check (len(mobileno) >=10),
	repid varchar(6) not null
)

insert potential_customers1
select '001','117','Adam','123 whatever dr','9899801963','56789'
union all
select '002','117','Bob','456 anywhere dr','9899801964','98765'
*/

insert potential_customers1
select '003','117','Dummy', '789 notreal rd', '9899801986','98743'

select * from potential_customers1