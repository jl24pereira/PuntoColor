/**
 * This class is generated by jOOQ
 */
package db.clases.tables.records;


import db.clases.tables.Usuario;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class UsuarioRecord extends UpdatableRecordImpl<UsuarioRecord> implements Record4<Integer, String, String, Integer> {

    private static final long serialVersionUID = -1575703257;

    /**
     * Setter for <code>public.usuario.idusuario</code>.
     */
    public void setIdusuario(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.usuario.idusuario</code>.
     */
    public Integer getIdusuario() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.usuario.usuario</code>.
     */
    public void setUsuario(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.usuario.usuario</code>.
     */
    public String getUsuario() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.usuario.pass</code>.
     */
    public void setPass(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.usuario.pass</code>.
     */
    public String getPass() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.usuario.idempleado</code>.
     */
    public void setIdempleado(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.usuario.idempleado</code>.
     */
    public Integer getIdempleado() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Usuario.USUARIO.IDUSUARIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Usuario.USUARIO.USUARIO_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Usuario.USUARIO.PASS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Usuario.USUARIO.IDEMPLEADO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdusuario();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getUsuario();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getIdempleado();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioRecord value1(Integer value) {
        setIdusuario(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioRecord value2(String value) {
        setUsuario(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioRecord value3(String value) {
        setPass(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioRecord value4(Integer value) {
        setIdempleado(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioRecord values(Integer value1, String value2, String value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsuarioRecord
     */
    public UsuarioRecord() {
        super(Usuario.USUARIO);
    }

    /**
     * Create a detached, initialised UsuarioRecord
     */
    public UsuarioRecord(Integer idusuario, String usuario, String pass, Integer idempleado) {
        super(Usuario.USUARIO);

        set(0, idusuario);
        set(1, usuario);
        set(2, pass);
        set(3, idempleado);
    }
}