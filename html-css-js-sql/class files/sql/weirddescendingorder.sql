use Bookstore17

select 
	repid,
	rtrim(fname) + ' ' + ltrim(lname) as Name
	
	
from slspers

select
	rtrim(custnum) as Customer_ID,
	len(custnum) as ID_Length,
	custname as Customer,
	rtrim(address) +', '+rtrim(city)+', '+rtrim(state)+', '+rtrim(zipcode) as Address
from customers
order by custnum desc

