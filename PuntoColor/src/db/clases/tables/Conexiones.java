/**
 * This class is generated by jOOQ
 */
package db.clases.tables;


import db.clases.Public;
import db.clases.tables.records.ConexionesRecord;

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
public class Conexiones extends TableImpl<ConexionesRecord> {

    private static final long serialVersionUID = -157970061;

    /**
     * The reference instance of <code>public.conexiones</code>
     */
    public static final Conexiones CONEXIONES = new Conexiones();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ConexionesRecord> getRecordType() {
        return ConexionesRecord.class;
    }

    /**
     * The column <code>public.conexiones.empleado</code>.
     */
    public final TableField<ConexionesRecord, String> EMPLEADO = createField("empleado", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.conexiones.idempleado</code>.
     */
    public final TableField<ConexionesRecord, Integer> IDEMPLEADO = createField("idempleado", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.conexiones.puesto</code>.
     */
    public final TableField<ConexionesRecord, String> PUESTO = createField("puesto", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.conexiones.ip</code>.
     */
    public final TableField<ConexionesRecord, String> IP = createField("ip", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.conexiones</code> table reference
     */
    public Conexiones() {
        this("conexiones", null);
    }

    /**
     * Create an aliased <code>public.conexiones</code> table reference
     */
    public Conexiones(String alias) {
        this(alias, CONEXIONES);
    }

    private Conexiones(String alias, Table<ConexionesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Conexiones(String alias, Table<ConexionesRecord> aliased, Field<?>[] parameters) {
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
    public Conexiones as(String alias) {
        return new Conexiones(alias, this);
    }

    /**
     * Rename this table
     */
    public Conexiones rename(String name) {
        return new Conexiones(name, null);
    }
}
