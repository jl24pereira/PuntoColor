select 1 as n,'Enero' as mes, COALESCE(SUM(total),0) AS total from venta where fecha between '2016-01-01' and '2016-01-31'
union
select 2,'Febrero',COALESCE(SUM(total),0) AS total from venta where fecha between '2016-02-01' and '2016-02-28'
union
select 3,'Marzo', COALESCE(SUM(total),0) AS total from venta where fecha between '2016-03-01' and '2016-03-31'
union
select 4,'Abril', COALESCE(SUM(total),0) AS total from venta where fecha between '2016-04-01' and '2016-04-30'
union
select 5,'Mayo',COALESCE(SUM(total),0) AS total from venta where fecha between '2016-05-01' and '2016-05-31'
union
select 6,'Junio',COALESCE(SUM(total),0) AS total from venta where fecha between '2016-06-01' and '2016-06-30'
union
select 7,'Julio',COALESCE(SUM(total),0) AS total from venta where fecha between '2016-07-01' and '2016-07-31'
union
select 8,'Agosto',COALESCE(SUM(total),0) AS total from venta where fecha between '2016-08-01' and '2016-08-31'
union
select 9,'Septiembre',COALESCE(SUM(total),0) AS total from venta where fecha between '2016-09-01' and '2016-09-30'
union
select 10,'Octubre',COALESCE(SUM(total),0) AS total from venta where fecha between '2016-10-01' and '2016-10-31'
union
select 11,'Noviembre',COALESCE(SUM(total),0) AS total from venta where fecha between '2016-11-01' and '2016-11-30'
union
select 12,'Diciembre',COALESCE(SUM(total),0) AS total from venta where fecha between '2016-12-01' and '2016-12-31'
order by n