select
v.idventa,
v.numerofactura,
p.numero as numeropedido,
dv.codigo as codigoproducto,
prod.nombre as nombreproducto,
dv.cantidad,
dv.precio as preciounitario,
(dv.precio*dv.cantidad) as ventagravada
from detalle_venta as dv
join venta as v on v.idventa = dv.idventa
join producto as prod on prod.codigo = dv.codigo
join pedido_venta as pv on pv.idventa = v.idventa
join pedido as p on p.numero = pv.numero
join detalle_pedido as dp on dp.numero = p.numero
where dv.codigo = dp.codigo