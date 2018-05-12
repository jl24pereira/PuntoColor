/**
 * This class is generated by jOOQ
 */
package db.clases.tables;


import db.clases.Keys;
import db.clases.Public;
import db.clases.tables.records.PedidoRecord;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class Pedido extends TableImpl<PedidoRecord> {

    private static final long serialVersionUID = 1916885776;

    /**
     * The reference instance of <code>public.pedido</code>
     */
    public static final Pedido PEDIDO = new Pedido();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PedidoRecord> getRecordType() {
        return PedidoRecord.class;
    }

    /**
     * The column <code>public.pedido.idpedido</code>.
     */
    public final TableField<PedidoRecord, Integer> IDPEDIDO = createField("idpedido", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval(('\"pedido_idpedido_seq\"'::text)::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.pedido.numero</code>.
     */
    public final TableField<PedidoRecord, String> NUMERO = createField("numero", org.jooq.impl.SQLDataType.VARCHAR.length(10), this, "");

    /**
     * The column <code>public.pedido.fecha</code>.
     */
    public final TableField<PedidoRecord, Date> FECHA = createField("fecha", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>public.pedido.idcliente</code>.
     */
    public final TableField<PedidoRecord, Integer> IDCLIENTE = createField("idcliente", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.pedido.idempleado</code>.
     */
    public final TableField<PedidoRecord, Integer> IDEMPLEADO = createField("idempleado", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.pedido.estado</code>.
     */
    public final TableField<PedidoRecord, String> ESTADO = createField("estado", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.pedido.total</code>.
     */
    public final TableField<PedidoRecord, BigDecimal> TOTAL = createField("total", org.jooq.impl.SQLDataType.NUMERIC.precision(6, 2), this, "");

    /**
     * The column <code>public.pedido.comentarios</code>.
     */
    public final TableField<PedidoRecord, String> COMENTARIOS = createField("comentarios", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.pedido</code> table reference
     */
    public Pedido() {
        this("pedido", null);
    }

    /**
     * Create an aliased <code>public.pedido</code> table reference
     */
    public Pedido(String alias) {
        this(alias, PEDIDO);
    }

    private Pedido(String alias, Table<PedidoRecord> aliased) {
        this(alias, aliased, null);
    }

    private Pedido(String alias, Table<PedidoRecord> aliased, Field<?>[] parameters) {
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
    public Identity<PedidoRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PEDIDO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PedidoRecord> getPrimaryKey() {
        return Keys.PK_PEDIDO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PedidoRecord>> getKeys() {
        return Arrays.<UniqueKey<PedidoRecord>>asList(Keys.PK_PEDIDO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<PedidoRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PedidoRecord, ?>>asList(Keys.PEDIDO__FK_PEDIDO_CLIENTE, Keys.PEDIDO__FK_PEDIDO_EMPLEADO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pedido as(String alias) {
        return new Pedido(alias, this);
    }

    /**
     * Rename this table
     */
    public Pedido rename(String name) {
        return new Pedido(name, null);
    }
}
