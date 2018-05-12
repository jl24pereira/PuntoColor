create or replace view v_detalle_pedido
as
select
dp.numero,
p.nombre,
dp.cantidad,
t.tamanio
from detalle_pedido as dp
inner join producto as p on p.codigo = dp.codigo
inner join tamanio as t on t.idtamanio = dp.idtamanio