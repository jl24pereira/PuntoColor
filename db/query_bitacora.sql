select
(select valor from bitacora_caja 
where movimiento = 'APERTURA' and fecha between '2016-09-22 00:00:00' and '2016-09-22 16:00:00') as saldoinicial,
(select sum(valor) from bitacora_caja where
movimiento LIKE '%PAGO%' and fecha between '2016-09-22 00:00:00' and '2016-09-22 16:00:00') as totalingresos,
(select valor from bitacora_caja 
where movimiento = 'EGRESOS' and fecha between '2016-09-22 00:00:00' and '2016-09-22 16:00:00') as egresos,
(select valor from bitacora_caja 
where movimiento = 'EFECTIVO' and fecha between '2016-09-22 00:00:00' and '2016-09-22 16:00:00') as efectivo,
valor as diferencia
from bitacora_caja
where movimiento = 'CIERRE' and
fecha between '2016-09-22 00:00:00' and '2016-09-22 16:00:00'