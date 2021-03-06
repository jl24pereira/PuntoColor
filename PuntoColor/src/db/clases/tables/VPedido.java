/**
 * This class is generated by jOOQ
 */
package db.clases.tables;


import db.clases.Public;
import db.clases.tables.records.VPedidoRecord;

import java.math.BigDecimal;
import java.sql.Date;

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
public class VPedido extends TableImpl<VPedidoRecord> {

    private static final long serialVersionUID = 701616994;

    /**
     * The reference instance of <code>public.v_pedido</code>
     */
    public static final VPedido V_PEDIDO = new VPedido();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VPedidoRecord> getRecordType() {
        return VPedidoRecord.class;
    }

    /**
     * The column <code>public.v_pedido.idpedido</code>.
     */
    public final TableField<VPedidoRecord, Integer> IDPEDIDO = createField("idpedido", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.v_pedido.numero</code>.
     */
    public final TableField<VPedidoRecord, String> NUMERO = createField("numero", org.jooq.impl.SQLDataType.VARCHAR.length(10), this, "");

    /**
     * The column <code>public.v_pedido.fecha</code>.
     */
    public final TableField<VPedidoRecord, Date> FECHA = createField("fecha", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>public.v_pedido.idcliente</code>.
     */
    public final TableField<VPedidoRecord, Integer> IDCLIENTE = createField("idcliente", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.v_pedido.nombrecliente</code>.
     */
    public final TableField<VPedidoRecord, String> NOMBRECLIENTE = createField("nombrecliente", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.v_pedido.direccion</code>.
     */
    public final TableField<VPedidoRecord, String> DIRECCION = createField("direccion", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.v_pedido.telefono</code>.
     */
    public final TableField<VPedidoRecord, String> TELEFONO = createField("telefono", org.jooq.impl.SQLDataType.VARCHAR.length(9), this, "");

    /**
     * The column <code>public.v_pedido.categoria</code>.
     */
    public final TableField<VPedidoRecord, String> CATEGORIA = createField("categoria", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.v_pedido.pagado</code>.
     */
    public final TableField<VPedidoRecord, BigDecimal> PAGADO = createField("pagado", org.jooq.impl.SQLDataType.NUMERIC, this, "");

    /**
     * The column <code>public.v_pedido.debe</code>.
     */
    public final TableField<VPedidoRecord, BigDecimal> DEBE = createField("debe", org.jooq.impl.SQLDataType.NUMERIC, this, "");

    /**
     * The column <code>public.v_pedido.total</code>.
     */
    public final TableField<VPedidoRecord, BigDecimal> TOTAL = createField("total", org.jooq.impl.SQLDataType.NUMERIC.precision(6, 2), this, "");

    /**
     * The column <code>public.v_pedido.idempleado</code>.
     */
    public final TableField<VPedidoRecord, Integer> IDEMPLEADO = createField("idempleado", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.v_pedido.nombreempleado</code>.
     */
    public final TableField<VPedidoRecord, String> NOMBREEMPLEADO = createField("nombreempleado", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.v_pedido.estado</code>.
     */
    public final TableField<VPedidoRecord, String> ESTADO = createField("estado", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.v_pedido.comentarios</code>.
     */
    public final TableField<VPedidoRecord, String> COMENTARIOS = createField("comentarios", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.v_pedido</code> table reference
     */
    public VPedido() {
        this("v_pedido", null);
    }

    /**
     * Create an aliased <code>public.v_pedido</code> table reference
     */
    public VPedido(String alias) {
        this(alias, V_PEDIDO);
    }

    private VPedido(String alias, Table<VPedidoRecord> aliased) {
        this(alias, aliased, null);
    }

    private VPedido(String alias, Table<VPedidoRecord> aliased, Field<?>[] parameters) {
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
    public VPedido as(String alias) {
        return new VPedido(alias, this);
    }

    /**
     * Rename this table
     */
    public VPedido rename(String name) {
        return new VPedido(name, null);
    }
}
