/**
 * This class is generated by jOOQ
 */
package db.clases.tables;


import db.clases.Keys;
import db.clases.Public;
import db.clases.tables.records.UsuarioRecord;

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
public class Usuario extends TableImpl<UsuarioRecord> {

    private static final long serialVersionUID = -71015608;

    /**
     * The reference instance of <code>public.usuario</code>
     */
    public static final Usuario USUARIO = new Usuario();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsuarioRecord> getRecordType() {
        return UsuarioRecord.class;
    }

    /**
     * The column <code>public.usuario.idusuario</code>.
     */
    public final TableField<UsuarioRecord, Integer> IDUSUARIO = createField("idusuario", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval(('\"usuario_idusuario_seq\"'::text)::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.usuario.usuario</code>.
     */
    public final TableField<UsuarioRecord, String> USUARIO_ = createField("usuario", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.usuario.pass</code>.
     */
    public final TableField<UsuarioRecord, String> PASS = createField("pass", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.usuario.idempleado</code>.
     */
    public final TableField<UsuarioRecord, Integer> IDEMPLEADO = createField("idempleado", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>public.usuario</code> table reference
     */
    public Usuario() {
        this("usuario", null);
    }

    /**
     * Create an aliased <code>public.usuario</code> table reference
     */
    public Usuario(String alias) {
        this(alias, USUARIO);
    }

    private Usuario(String alias, Table<UsuarioRecord> aliased) {
        this(alias, aliased, null);
    }

    private Usuario(String alias, Table<UsuarioRecord> aliased, Field<?>[] parameters) {
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
    public Identity<UsuarioRecord, Integer> getIdentity() {
        return Keys.IDENTITY_USUARIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UsuarioRecord> getPrimaryKey() {
        return Keys.PK_USUARIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UsuarioRecord>> getKeys() {
        return Arrays.<UniqueKey<UsuarioRecord>>asList(Keys.PK_USUARIO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<UsuarioRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UsuarioRecord, ?>>asList(Keys.USUARIO__FK_USUARIO_EMPLEADO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario as(String alias) {
        return new Usuario(alias, this);
    }

    /**
     * Rename this table
     */
    public Usuario rename(String name) {
        return new Usuario(name, null);
    }
}