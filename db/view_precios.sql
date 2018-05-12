create or replace view v_precios
as
select
p.idprecio,
p.codigo,
cc.categoria,
p.precio
from precios as p
inner join categoria_cliente as cc on cc.idcategoria = p.idcategoria