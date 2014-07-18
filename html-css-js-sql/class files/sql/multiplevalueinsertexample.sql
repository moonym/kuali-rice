use bookstore17

insert titles
output inserted.*
select '59906', 'VC++ 6.0 Made Easy', null, 50, '2008-06-01'
union all
select '59907', 'History of the Internet', null, 25, '2008-06-01'
union all
select '59908', 'Flash Tips and Tricks', null, 35, '2008-06-01'
union all
select '59909', 'eCommerce: The Future of the Internet', 19000, 30, '2008-06-01'
