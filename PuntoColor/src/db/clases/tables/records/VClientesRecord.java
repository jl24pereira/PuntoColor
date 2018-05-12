/**
 * This class is generated by jOOQ
 */
package db.clases.tables.records;


import db.clases.tables.VClientes;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class VClientesRecord extends TableRecordImpl<VClientesRecord> implements Record7<Integer, String, String, String, String, String, Boolean> {

    private static final long serialVersionUID = 1704223978;

    /**
     * Setter for <code>public.v_clientes.idcliente</code>.
     */
    public void setIdcliente(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.v_clientes.idcliente</code>.
     */
    public Integer getIdcliente() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.v_clientes.nombre</code>.
     */
    public void setNombre(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.v_clientes.nombre</code>.
     */
    public String getNombre() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.v_clientes.direccion</code>.
     */
    public void setDireccion(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.v_clientes.direccion</code>.
     */
    public String getDireccion() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.v_clientes.telefono</code>.
     */
    public void setTelefono(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.v_clientes.telefono</code>.
     */
    public String getTelefono() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.v_clientes.tipo</code>.
     */
    public void setTipo(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.v_clientes.tipo</code>.
     */
    public String getTipo() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.v_clientes.categoria</code>.
     */
    public void setCategoria(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.v_clientes.categoria</code>.
     */
    public String getCategoria() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.v_clientes.baja</code>.
     */
    public void setBaja(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.v_clientes.baja</code>.
     */
    public Boolean getBaja() {
        return (Boolean) get(6);
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, String, String, String, Boolean> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, String, String, String, Boolean> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return VClientes.V_CLIENTES.IDCLIENTE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return VClientes.V_CLIENTES.NOMBRE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return VClientes.V_CLIENTES.DIRECCION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return VClientes.V_CLIENTES.TELEFONO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return VClientes.V_CLIENTES.TIPO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return VClientes.V_CLIENTES.CATEGORIA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field7() {
        return VClientes.V_CLIENTES.BAJA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdcliente();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getNombre();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDireccion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getTelefono();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getTipo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getCategoria();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value7() {
        return getBaja();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VClientesRecord value1(Integer value) {
        setIdcliente(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VClientesRecord value2(String value) {
        setNombre(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VClientesRecord value3(String value) {
        setDireccion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VClientesRecord value4(String value) {
        setTelefono(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VClientesRecord value5(String value) {
        setTipo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VClientesRecord value6(String value) {
        setCategoria(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VClientesRecord value7(Boolean value) {
        setBaja(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VClientesRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, Boolean value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VClientesRecord
     */
    public VClientesRecord() {
        super(VClientes.V_CLIENTES);
    }

    /**
     * Create a detached, initialised VClientesRecord
     */
    public VClientesRecord(Integer idcliente, String nombre, String direccion, String telefono, String tipo, String categoria, Boolean baja) {
        super(VClientes.V_CLIENTES);

        set(0, idcliente);
        set(1, nombre);
        set(2, direccion);
        set(3, telefono);
        set(4, tipo);
        set(5, categoria);
        set(6, baja);
    }
}
