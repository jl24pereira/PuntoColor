CREATE OR REPLACE VIEW v_productos AS 
SELECT 
p.codigo,
p.nombre,
p.color,
p.tiempofabrica,
cp.nombre AS categoria,
sum(gp.gasto) AS costo_administrativo,
(select sum(r.descargo*i.preciocompra)
	FROM receta AS r  
	INNER JOIN inventario AS i ON r.codigo_inventario = i.codigo 
	WHERE r.codigo_catalogo = p.codigo 
	GROUP BY r.codigo_catalogo) AS costo_inventario,
(SELECT price.precio 
	FROM precios AS price 
	WHERE price.idcategoria = 1 AND price.codigo=p.codigo) AS p_normal,
(SELECT price.precio 
	FROM precios AS price 
	WHERE price.idcategoria = 2 AND price.codigo=p.codigo) AS p_vip,
(SELECT price.precio 
	FROM precios AS price 
	WHERE price.idcategoria = 3 AND price.codigo=p.codigo) AS p_dist
FROM producto AS p 
JOIN categoria_producto AS cp ON p.idcategoria = cp.idcategoria
JOIN gasto_producto AS gp on p.codigo = gp.codigo
GROUP BY p.codigo, cp.idcategoria