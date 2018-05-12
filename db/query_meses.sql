select 
case 
when extract(month from date_trunc('month',fecha))=1 then 'Enero'
when extract(month from date_trunc('month',fecha))=2 then 'Febrero'
when extract(month from date_trunc('month',fecha))=3 then 'Marzo'
when extract(month from date_trunc('month',fecha))=4 then 'Abril'
when extract(month from date_trunc('month',fecha))=5 then 'Mayo'
when extract(month from date_trunc('month',fecha))=6 then 'Junio'
when extract(month from date_trunc('month',fecha))=7 then 'Julio'
when extract(month from date_trunc('month',fecha))=8 then 'Agosto'
when extract(month from date_trunc('month',fecha))=9 then 'Septiembre'
when extract(month from date_trunc('month',fecha))=10 then 'Octubre'
when extract(month from date_trunc('month',fecha))=11 then 'Noviembre'
when extract(month from date_trunc('month',fecha))=12 then 'Diciembre'
else 'Otro'
end as mes,
(select sum(total) from venta where fecha between '2016-02-01' and '2016-02-29')
from venta
where fecha between '2016-01-01' and '2016-12-31'
group by date_trunc('month',fecha)
order by date_trunc('month',fecha)