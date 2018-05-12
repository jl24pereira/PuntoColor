/**
 * This class is generated by jOOQ
 */
package db.clases;


import db.clases.routines.ActualizarCostosProduccionEmpresa;
import db.clases.routines.ActualizarCostosProduccionProducto;
import db.clases.routines.ActualizarCostosProducto;
import db.clases.routines.AgregarTamanioDefaultFromNewProducto;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.Field;


/**
 * Convenience access to all stored procedures and functions in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

    /**
     * Call <code>public.actualizar_costos_produccion_empresa</code>
     */
    public static Object actualizarCostosProduccionEmpresa(Configuration configuration) {
        ActualizarCostosProduccionEmpresa f = new ActualizarCostosProduccionEmpresa();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.actualizar_costos_produccion_empresa</code> as a field.
     */
    public static Field<Object> actualizarCostosProduccionEmpresa() {
        ActualizarCostosProduccionEmpresa f = new ActualizarCostosProduccionEmpresa();

        return f.asField();
    }

    /**
     * Call <code>public.actualizar_costos_produccion_producto</code>
     */
    public static Object actualizarCostosProduccionProducto(Configuration configuration) {
        ActualizarCostosProduccionProducto f = new ActualizarCostosProduccionProducto();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.actualizar_costos_produccion_producto</code> as a field.
     */
    public static Field<Object> actualizarCostosProduccionProducto() {
        ActualizarCostosProduccionProducto f = new ActualizarCostosProduccionProducto();

        return f.asField();
    }

    /**
     * Call <code>public.actualizar_costos_producto</code>
     */
    public static Object actualizarCostosProducto(Configuration configuration) {
        ActualizarCostosProducto f = new ActualizarCostosProducto();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.actualizar_costos_producto</code> as a field.
     */
    public static Field<Object> actualizarCostosProducto() {
        ActualizarCostosProducto f = new ActualizarCostosProducto();

        return f.asField();
    }

    /**
     * Call <code>public.agregar_tamanio_default_from_new_producto</code>
     */
    public static Object agregarTamanioDefaultFromNewProducto(Configuration configuration) {
        AgregarTamanioDefaultFromNewProducto f = new AgregarTamanioDefaultFromNewProducto();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.agregar_tamanio_default_from_new_producto</code> as a field.
     */
    public static Field<Object> agregarTamanioDefaultFromNewProducto() {
        AgregarTamanioDefaultFromNewProducto f = new AgregarTamanioDefaultFromNewProducto();

        return f.asField();
    }
}
