CREATE OR REPLACE VIEW public.v_compras AS 
select 
p.idproveedor,
p.nombre,
c.fecha,
c.tipodocumento,
c.numerodocumento,
(select sum(pago) from pagos_compras where idcompra = c.idcompra) as pagos,
c.total,
case
	when (total - (select sum(pago) from pagos_compras where idcompra = c.idcompra) ) = 0
	then true
	else false
end as pagado
from proveedor as p
inner join compras as c on c.idproveedor = p.idproveedor
order by c.fecha asc