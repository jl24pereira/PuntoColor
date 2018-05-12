CREATE OR REPLACE FUNCTION actualizar_costos_producto() 
RETURNS TRIGGER AS $actualizar_costos_producto$
DECLARE
	rec producto;
	ge gastos_empresa;
	e empresa;
	tiempo INTEGER;
	horas INTEGER;
	horasmes INTEGER;
	minutosmes INTEGER;
	gasto DOUBLE PRECISION;
	costo DOUBLE PRECISION;
BEGIN
	IF(NEW.aplica = FALSE) THEN
		DELETE FROM gasto_producto AS gp
		WHERE gp.idgasto = NEW.idgasto;
	ELSE
		FOR ge IN SELECT * FROM gastos_empresa WHERE idgasto = NEW.idgasto
		LOOP
			gasto := ge.gasto;
		END LOOP;
		
		FOR e IN SELECT * FROM empresa LIMIT 1			
		LOOP
			horas :=e.horassemana;
		END LOOP;
		
		FOR rec IN SELECT * FROM producto as p		
		LOOP	
			horasmes := horas*4;
			minutosmes := horasmes*60;			
			costo :=(gasto/minutosmes)*rec.tiempofabrica;
			INSERT INTO gasto_producto VALUES(rec.codigo, NEW.idgasto, costo);
		END LOOP;
	END IF;
	RETURN NEW;
END;
$actualizar_costos_producto$ LANGUAGE plpgsql;