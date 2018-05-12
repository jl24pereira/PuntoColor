/**
 * This class is generated by jOOQ
 */
package db.clases.tables;


import db.clases.Keys;
import db.clases.Public;
import db.clases.tables.records.DetallePedidoRecord;

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
public class DetallePedido extends TableImpl<DetallePedidoRecord> {

    private static final long serialVersionUID = -1271329681;

    /**
     * The reference instance of <code>public.detalle_pedido</code>
     */
    public static final DetallePedido DETALLE_PEDIDO = new DetallePedido();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DetallePedidoRecord> getRecordType() {
        return DetallePedidoRecord.class;
    }

    /**
     * The column <code>public.detalle_pedido.cantidad</code>.
     */
    public final TableField<DetallePedidoRecord, Float> CANTIDAD = createField("cantidad", org.jooq.impl.SQLDataType.REAL, this, "");

    /**
     * The column <code>public.detalle_pedido.precio</code>.
     */
    public final TableField<DetallePedidoRecord, BigDecimal> PRECIO = createField("precio", org.jooq.impl.SQLDataType.NUMERIC.precision(6, 2), this, "");

    /**
     * The column <code>public.detalle_pedido.idtamanio</code>.
     */
    public final TableField<DetallePedidoRecord, Integer> IDTAMANIO = createField("idtamanio", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.detalle_pedido.idpedido</code>.
     */
    public final TableField<DetallePedidoRecord, Integer> IDPEDIDO = createField("idpedido", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.detalle_pedido.idproducto</code>.
     */
    public final TableField<DetallePedidoRecord, Integer> IDPRODUCTO = createField("idproducto", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.detalle_pedido.especial</code>.
     */
    public final TableField<DetallePedidoRecord, Boolean> ESPECIAL = createField("especial", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.detalle_pedido.ancho</code>.
     */
    public final TableField<DetallePedidoRecord, Float> ANCHO = createField("ancho", org.jooq.impl.SQLDataType.REAL, this, "");

    /**
     * The column <code>public.detalle_pedido.largo</code>.
     */
    public final TableField<DetallePedidoRecord, Float> LARGO = createField("largo", org.jooq.impl.SQLDataType.REAL, this, "");

    /**
     * Create a <code>public.detalle_pedido</code> table reference
     */
    public DetallePedido() {
        this("detalle_pedido", null);
    }

    /**
     * Create an aliased <code>public.detalle_pedido</code> table reference
     */
    public DetallePedido(String alias) {
        this(alias, DETALLE_PEDIDO);
    }

    private DetallePedido(String alias, Table<DetallePedidoRecord> aliased) {
        this(alias, aliased, null);
    }

    private DetallePedido(String alias, Table<DetallePedidoRecord> aliased, Field<?>[] parameters) {
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
    public List<ForeignKey<DetallePedidoRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DetallePedidoRecord, ?>>asList(Keys.DETALLE_PEDIDO__FK_DETALLE_PEDIDO_TAMANIO, Keys.DETALLE_PEDIDO__FK_DETALLE_PEDIDO_PEDIDO, Keys.DETALLE_PEDIDO__FK_DETALLE_PEDIDO_PRODUCTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetallePedido as(String alias) {
        return new DetallePedido(alias, this);
    }

    /**
     * Rename this table
     */
    public DetallePedido rename(String name) {
        return new DetallePedido(name, null);
    }
}