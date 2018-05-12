/**
 * This class is generated by jOOQ
 */
package db.clases.tables;


import db.clases.Keys;
import db.clases.Public;
import db.clases.tables.records.DetalleVentaRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class DetalleVenta extends TableImpl<DetalleVentaRecord> {

    private static final long serialVersionUID = -55619390;

    /**
     * The reference instance of <code>public.detalle_venta</code>
     */
    public static final DetalleVenta DETALLE_VENTA = new DetalleVenta();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DetalleVentaRecord> getRecordType() {
        return DetalleVentaRecord.class;
    }

    /**
     * The column <code>public.detalle_venta.idventa</code>.
     */
    public final TableField<DetalleVentaRecord, Integer> IDVENTA = createField("idventa", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.detalle_venta.cantidad</code>.
     */
    public final TableField<DetalleVentaRecord, Float> CANTIDAD = createField("cantidad", org.jooq.impl.SQLDataType.REAL, this, "");

    /**
     * The column <code>public.detalle_venta.precio</code>.
     */
    public final TableField<DetalleVentaRecord, BigDecimal> PRECIO = createField("precio", org.jooq.impl.SQLDataType.NUMERIC.precision(8, 4), this, "");

    /**
     * The column <code>public.detalle_venta.idtamanio</code>.
     */
    public final TableField<DetalleVentaRecord, Integer> IDTAMANIO = createField("idtamanio", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.detalle_venta.idproducto</code>.
     */
    public final TableField<DetalleVentaRecord, Integer> IDPRODUCTO = createField("idproducto", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.detalle_venta.especial</code>.
     */
    public final TableField<DetalleVentaRecord, Boolean> ESPECIAL = createField("especial", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.detalle_venta.ancho</code>.
     */
    public final TableField<DetalleVentaRecord, Float> ANCHO = createField("ancho", org.jooq.impl.SQLDataType.REAL, this, "");

    /**
     * The column <code>public.detalle_venta.largo</code>.
     */
    public final TableField<DetalleVentaRecord, Float> LARGO = createField("largo", org.jooq.impl.SQLDataType.REAL, this, "");

    /**
     * Create a <code>public.detalle_venta</code> table reference
     */
    public DetalleVenta() {
        this("detalle_venta", null);
    }

    /**
     * Create an aliased <code>public.detalle_venta</code> table reference
     */
    public DetalleVenta(String alias) {
        this(alias, DETALLE_VENTA);
    }

    private DetalleVenta(String alias, Table<DetalleVentaRecord> aliased) {
        this(alias, aliased, null);
    }

    private DetalleVenta(String alias, Table<DetalleVentaRecord> aliased, Field<?>[] parameters) {
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
    public List<ForeignKey<DetalleVentaRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DetalleVentaRecord, ?>>asList(Keys.DETALLE_VENTA__FK_DETALLE_VENTA_VENTA, Keys.DETALLE_VENTA__FK_DETALLE_VENTA_TAMANIO, Keys.DETALLE_VENTA__FK_DETALLE_VENTA_PRODUCTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleVenta as(String alias) {
        return new DetalleVenta(alias, this);
    }

    /**
     * Rename this table
     */
    public DetalleVenta rename(String name) {
        return new DetalleVenta(name, null);
    }
}