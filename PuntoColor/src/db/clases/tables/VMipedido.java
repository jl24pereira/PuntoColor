/**
 * This class is generated by jOOQ
 */
package db.clases.tables;


import db.clases.Public;
import db.clases.tables.records.VMipedidoRecord;

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
public class VMipedido extends TableImpl<VMipedidoRecord> {

    private static final long serialVersionUID = 36787331;

    /**
     * The reference instance of <code>public.v_mipedido</code>
     */
    public static final VMipedido V_MIPEDIDO = new VMipedido();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VMipedidoRecord> getRecordType() {
        return VMipedidoRecord.class;
    }

    /**
     * The column <code>public.v_mipedido.idpedido</code>.
     */
    public final TableField<VMipedidoRecord, Integer> IDPEDIDO = createField("idpedido", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.v_mipedido.numero</code>.
     */
    public final TableField<VMipedidoRecord, String> NUMERO = createField("numero", org.jooq.impl.SQLDataType.VARCHAR.length(10), this, "");

    /**
     * The column <code>public.v_mipedido.fecha</code>.
     */
    public final TableField<VMipedidoRecord, Date> FECHA = createField("fecha", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>public.v_mipedido.comentarios</code>.
     */
    public final TableField<VMipedidoRecord, String> COMENTARIOS = createField("comentarios", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.v_mipedido.idempleado</code>.
     */
    public final TableField<VMipedidoRecord, Integer> IDEMPLEADO = createField("idempleado", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.v_mipedido.nombre</code>.
     */
    public final TableField<VMipedidoRecord, String> NOMBRE = createField("nombre", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.v_mipedido.estado</code>.
     */
    public final TableField<VMipedidoRecord, String> ESTADO = createField("estado", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.v_mipedido</code> table reference
     */
    public VMipedido() {
        this("v_mipedido", null);
    }

    /**
     * Create an aliased <code>public.v_mipedido</code> table reference
     */
    public VMipedido(String alias) {
        this(alias, V_MIPEDIDO);
    }

    private VMipedido(String alias, Table<VMipedidoRecord> aliased) {
        this(alias, aliased, null);
    }

    private VMipedido(String alias, Table<VMipedidoRecord> aliased, Field<?>[] parameters) {
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
    public VMipedido as(String alias) {
        return new VMipedido(alias, this);
    }

    /**
     * Rename this table
     */
    public VMipedido rename(String name) {
        return new VMipedido(name, null);
    }
}
