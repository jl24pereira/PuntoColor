/**
 * This class is generated by jOOQ
 */
package db.clases.tables;


import db.clases.Public;
import db.clases.tables.records.VDetalleFacturaRecord;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VDetalleFactura extends TableImpl<VDetalleFacturaRecord> {

    private static final long serialVersionUID = -1320458913;

    /**
     * The reference instance of <code>public.v_detalle_factura</code>
     */
    public static final VDetalleFactura V_DETALLE_FACTURA = new VDetalleFactura();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VDetalleFacturaRecord> getRecordType() {
        return VDetalleFacturaRecord.class;
    }

    /**
     * The column <code>public.v_detalle_factura.idventa</code>.
     */
    public final TableField<VDetalleFacturaRecord, Integer> IDVENTA = createField("idventa", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.v_detalle_factura.numerofactura</code>.
     */
    public final TableField<VDetalleFacturaRecord, String> NUMEROFACTURA = createField("numerofactura", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.v_detalle_factura.codigoproducto</code>.
     */
    public final TableField<VDetalleFacturaRecord, String> CODIGOPRODUCTO = createField("codigoproducto", org.jooq.impl.SQLDataType.VARCHAR.length(7), this, "");

    /**
     * The column <code>public.v_detalle_factura.nombreproducto</code>.
     */
    public final TableField<VDetalleFacturaRecord, String> NOMBREPRODUCTO = createField("nombreproducto", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.v_detalle_factura.cantidad</code>.
     */
    public final TableField<VDetalleFacturaRecord, Float> CANTIDAD = createField("cantidad", org.jooq.impl.SQLDataType.REAL, this, "");

    /**
     * The column <code>public.v_detalle_factura.preciounitario</code>.
     */
    public final TableField<VDetalleFacturaRecord, BigDecimal> PRECIOUNITARIO = createField("preciounitario", org.jooq.impl.SQLDataType.NUMERIC.precision(8, 4), this, "");

    /**
     * The column <code>public.v_detalle_factura.ventagravada</code>.
     */
    public final TableField<VDetalleFacturaRecord, BigDecimal> VENTAGRAVADA = createField("ventagravada", org.jooq.impl.SQLDataType.NUMERIC, this, "");

    /**
     * Create a <code>public.v_detalle_factura</code> table reference
     */
    public VDetalleFactura() {
        this("v_detalle_factura", null);
    }

    /**
     * Create an aliased <code>public.v_detalle_factura</code> table reference
     */
    public VDetalleFactura(String alias) {
        this(alias, V_DETALLE_FACTURA);
    }

    private VDetalleFactura(String alias, Table<VDetalleFacturaRecord> aliased) {
        this(alias, aliased, null);
    }

    private VDetalleFactura(String alias, Table<VDetalleFacturaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VDetalleFactura as(String alias) {
        return new VDetalleFactura(alias, this);
    }

    /**
     * Rename this table
     */
    public VDetalleFactura rename(String name) {
        return new VDetalleFactura(name, null);
    }
}
