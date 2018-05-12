/**
 * This class is generated by jOOQ
 */
package db.clases.tables;


import db.clases.Keys;
import db.clases.Public;
import db.clases.tables.records.DetalleCompraRecord;

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
public class DetalleCompra extends TableImpl<DetalleCompraRecord> {

    private static final long serialVersionUID = 935690503;

    /**
     * The reference instance of <code>public.detalle_compra</code>
     */
    public static final DetalleCompra DETALLE_COMPRA = new DetalleCompra();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DetalleCompraRecord> getRecordType() {
        return DetalleCompraRecord.class;
    }

    /**
     * The column <code>public.detalle_compra.cantidad</code>.
     */
    public final TableField<DetalleCompraRecord, Double> CANTIDAD = createField("cantidad", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>public.detalle_compra.preciocompra</code>.
     */
    public final TableField<DetalleCompraRecord, BigDecimal> PRECIOCOMPRA = createField("preciocompra", org.jooq.impl.SQLDataType.NUMERIC.precision(6, 2), this, "");

    /**
     * The column <code>public.detalle_compra.idcompra</code>.
     */
    public final TableField<DetalleCompraRecord, Integer> IDCOMPRA = createField("idcompra", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.detalle_compra.idinventario</code>.
     */
    public final TableField<DetalleCompraRecord, Integer> IDINVENTARIO = createField("idinventario", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>public.detalle_compra</code> table reference
     */
    public DetalleCompra() {
        this("detalle_compra", null);
    }

    /**
     * Create an aliased <code>public.detalle_compra</code> table reference
     */
    public DetalleCompra(String alias) {
        this(alias, DETALLE_COMPRA);
    }

    private DetalleCompra(String alias, Table<DetalleCompraRecord> aliased) {
        this(alias, aliased, null);
    }

    private DetalleCompra(String alias, Table<DetalleCompraRecord> aliased, Field<?>[] parameters) {
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
    public List<ForeignKey<DetalleCompraRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DetalleCompraRecord, ?>>asList(Keys.DETALLE_COMPRA__FK_DETALLE_COMPRA_COMPRAS, Keys.DETALLE_COMPRA__FK_DETALLE_COMPRA_INVENTARIO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleCompra as(String alias) {
        return new DetalleCompra(alias, this);
    }

    /**
     * Rename this table
     */
    public DetalleCompra rename(String name) {
        return new DetalleCompra(name, null);
    }
}
