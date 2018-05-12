/**
 * This class is generated by jOOQ
 */
package db.clases.tables.records;


import db.clases.tables.Conexiones;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;


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
public class ConexionesRecord extends TableRecordImpl<ConexionesRecord> implements Record4<String, Integer, String, String> {

    private static final long serialVersionUID = 791334590;

    /**
     * Setter for <code>public.conexiones.empleado</code>.
     */
    public void setEmpleado(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.conexiones.empleado</code>.
     */
    public String getEmpleado() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.conexiones.idempleado</code>.
     */
    public void setIdempleado(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.conexiones.idempleado</code>.
     */
    public Integer getIdempleado() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.conexiones.puesto</code>.
     */
    public void setPuesto(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.conexiones.puesto</code>.
     */
    public String getPuesto() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.conexiones.ip</code>.
     */
    public void setIp(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.conexiones.ip</code>.
     */
    public String getIp() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, Integer, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, Integer, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Conexiones.CONEXIONES.EMPLEADO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Conexiones.CONEXIONES.IDEMPLEADO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Conexiones.CONEXIONES.PUESTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Conexiones.CONEXIONES.IP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getEmpleado();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getIdempleado();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPuesto();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getIp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConexionesRecord value1(String value) {
        setEmpleado(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConexionesRecord value2(Integer value) {
        setIdempleado(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConexionesRecord value3(String value) {
        setPuesto(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConexionesRecord value4(String value) {
        setIp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConexionesRecord values(String value1, Integer value2, String value3, String value4) {
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
     * Create a detached ConexionesRecord
     */
    public ConexionesRecord() {
        super(Conexiones.CONEXIONES);
    }

    /**
     * Create a detached, initialised ConexionesRecord
     */
    public ConexionesRecord(String empleado, Integer idempleado, String puesto, String ip) {
        super(Conexiones.CONEXIONES);

        set(0, empleado);
        set(1, idempleado);
        set(2, puesto);
        set(3, ip);
    }
}