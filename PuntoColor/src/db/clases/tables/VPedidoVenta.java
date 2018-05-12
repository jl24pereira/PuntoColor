/**
 * This class is generated by jOOQ
 */
package db.clases.tables;


import db.clases.Public;
import db.clases.tables.records.VPedidoVentaRecord;

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
public class VPedidoVenta extends TableImpl<VPedidoVentaRecord> {

    private static final long serialVersionUID = 1498070889;

    /**
     * The reference instance of <code>public.v_pedido_venta</code>
     */
    public static final VPedidoVenta V_PEDIDO_VENTA = new VPedidoVenta();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VPedidoVentaRecord> getRecordType() {
        return VPedidoVentaRecord.class;
    }

    /**
     * The column <code>public.v_pedido_venta.idventa</code>.
     */
    public final TableField<VPedidoVentaRecord, Integer> IDVENTA = createField("idventa", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.v_pedido_venta.idpedido</code>.
     */
    public final TableField<VPedidoVentaRecord, Integer> IDPEDIDO = createField("idpedido", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.v_pedido_venta.texto</code>.
     */
    public final TableField<VPedidoVentaRecord, String> TEXTO = createField("texto", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.v_pedido_venta</code> table reference
     */
    public VPedidoVenta() {
        this("v_pedido_venta", null);
    }

    /**
     * Create an aliased <code>public.v_pedido_venta</code> table reference
     */
    public VPedidoVenta(String alias) {
        this(alias, V_PEDIDO_VENTA);
    }

    private VPedidoVenta(String alias, Table<VPedidoVentaRecord> aliased) {
        this(alias, aliased, null);
    }

    private VPedidoVenta(String alias, Table<VPedidoVentaRecord> aliased, Field<?>[] parameters) {
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
    public VPedidoVenta as(String alias) {
        return new VPedidoVenta(alias, this);
    }

    /**
     * Rename this table
     */
    public VPedidoVenta rename(String name) {
        return new VPedidoVenta(name, null);
    }
}
