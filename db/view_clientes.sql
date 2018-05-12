create or replace view v_clientes
as
select 
c.idcliente,
c.nombre,
c.direccion,
c.telefono,
c.tipo,
cc.categoria,
c.baja
from cliente as c
inner join categoria_cliente as cc on cc.idcategoria = c.idcategoria
