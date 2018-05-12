create or replace view v_pedidos
as
select 
p.numero,
p.fecha,
c.idcliente,
c.nombre as nombrecliente,
cc.categoria,
(select sum(pago) from pagos_pedido as pp where pp.numero=p.numero) as pagado,
total - (select sum(pago) from pagos_pedido as pp where pp.numero=p.numero) as debe,
p.total,
e.idempleado,
e.nombre as nombreempleado,
p.estado
from pedido as p
inner join cliente as c on c.idcliente = p.idcliente
inner join empleado as e on e.idempleado = p.idempleado
inner join categoria_cliente as cc on cc.idcategoria = c.idcategoria