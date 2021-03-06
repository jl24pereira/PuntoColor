/**
 * This class is generated by jOOQ
 */
package db.clases.tables.records;


import db.clases.tables.VCotizacion;

import java.math.BigDecimal;
import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record15;
import org.jooq.Row15;
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
public class VCotizacionRecord extends TableRecordImpl<VCotizacionRecord> implements Record15<Integer, String, Date, Integer, String, String, String, BigDecimal, String, Integer, String, byte[], byte[], Date, String> {

    private static final long serialVersionUID = -1025704438;

    /**
     * Setter for <code>public.v_cotizacion.idcotizacion</code>.
     */
    public void setIdcotizacion(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.idcotizacion</code>.
     */
    public Integer getIdcotizacion() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.v_cotizacion.numero</code>.
     */
    public void setNumero(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.numero</code>.
     */
    public String getNumero() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.v_cotizacion.fecha</code>.
     */
    public void setFecha(Date value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.fecha</code>.
     */
    public Date getFecha() {
        return (Date) get(2);
    }

    /**
     * Setter for <code>public.v_cotizacion.idcliente</code>.
     */
    public void setIdcliente(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.idcliente</code>.
     */
    public Integer getIdcliente() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.v_cotizacion.nombrecliente</code>.
     */
    public void setNombrecliente(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.nombrecliente</code>.
     */
    public String getNombrecliente() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.v_cotizacion.direccion</code>.
     */
    public void setDireccion(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.direccion</code>.
     */
    public String getDireccion() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.v_cotizacion.telefono</code>.
     */
    public void setTelefono(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.telefono</code>.
     */
    public String getTelefono() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.v_cotizacion.total</code>.
     */
    public void setTotal(BigDecimal value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.total</code>.
     */
    public BigDecimal getTotal() {
        return (BigDecimal) get(7);
    }

    /**
     * Setter for <code>public.v_cotizacion.enletras</code>.
     */
    public void setEnletras(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.enletras</code>.
     */
    public String getEnletras() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.v_cotizacion.validapor</code>.
     */
    public void setValidapor(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.validapor</code>.
     */
    public Integer getValidapor() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>public.v_cotizacion.propietario</code>.
     */
    public void setPropietario(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.propietario</code>.
     */
    public String getPropietario() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.v_cotizacion.firma</code>.
     */
    public void setFirma(byte[] value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.firma</code>.
     */
    public byte[] getFirma() {
        return (byte[]) get(11);
    }

    /**
     * Setter for <code>public.v_cotizacion.sello</code>.
     */
    public void setSello(byte[] value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.sello</code>.
     */
    public byte[] getSello() {
        return (byte[]) get(12);
    }

    /**
     * Setter for <code>public.v_cotizacion.vencimiento</code>.
     */
    public void setVencimiento(Date value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.vencimiento</code>.
     */
    public Date getVencimiento() {
        return (Date) get(13);
    }

    /**
     * Setter for <code>public.v_cotizacion.case</code>.
     */
    public void setCase(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.v_cotizacion.case</code>.
     */
    public String getCase() {
        return (String) get(14);
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row15<Integer, String, Date, Integer, String, String, String, BigDecimal, String, Integer, String, byte[], byte[], Date, String> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row15<Integer, String, Date, Integer, String, String, String, BigDecimal, String, Integer, String, byte[], byte[], Date, String> valuesRow() {
        return (Row15) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return VCotizacion.V_COTIZACION.IDCOTIZACION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return VCotizacion.V_COTIZACION.NUMERO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field3() {
        return VCotizacion.V_COTIZACION.FECHA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return VCotizacion.V_COTIZACION.IDCLIENTE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return VCotizacion.V_COTIZACION.NOMBRECLIENTE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return VCotizacion.V_COTIZACION.DIRECCION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return VCotizacion.V_COTIZACION.TELEFONO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field8() {
        return VCotizacion.V_COTIZACION.TOTAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return VCotizacion.V_COTIZACION.ENLETRAS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field10() {
        return VCotizacion.V_COTIZACION.VALIDAPOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return VCotizacion.V_COTIZACION.PROPIETARIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field12() {
        return VCotizacion.V_COTIZACION.FIRMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field13() {
        return VCotizacion.V_COTIZACION.SELLO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field14() {
        return VCotizacion.V_COTIZACION.VENCIMIENTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return VCotizacion.V_COTIZACION.CASE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdcotizacion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getNumero();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value3() {
        return getFecha();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getIdcliente();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getNombrecliente();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getDireccion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getTelefono();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value8() {
        return getTotal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getEnletras();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value10() {
        return getValidapor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getPropietario();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value12() {
        return getFirma();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value13() {
        return getSello();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value14() {
        return getVencimiento();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getCase();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value1(Integer value) {
        setIdcotizacion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value2(String value) {
        setNumero(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value3(Date value) {
        setFecha(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value4(Integer value) {
        setIdcliente(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value5(String value) {
        setNombrecliente(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value6(String value) {
        setDireccion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value7(String value) {
        setTelefono(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value8(BigDecimal value) {
        setTotal(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value9(String value) {
        setEnletras(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value10(Integer value) {
        setValidapor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value11(String value) {
        setPropietario(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value12(byte[] value) {
        setFirma(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value13(byte[] value) {
        setSello(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value14(Date value) {
        setVencimiento(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord value15(String value) {
        setCase(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VCotizacionRecord values(Integer value1, String value2, Date value3, Integer value4, String value5, String value6, String value7, BigDecimal value8, String value9, Integer value10, String value11, byte[] value12, byte[] value13, Date value14, String value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VCotizacionRecord
     */
    public VCotizacionRecord() {
        super(VCotizacion.V_COTIZACION);
    }

    /**
     * Create a detached, initialised VCotizacionRecord
     */
    public VCotizacionRecord(Integer idcotizacion, String numero, Date fecha, Integer idcliente, String nombrecliente, String direccion, String telefono, BigDecimal total, String enletras, Integer validapor, String propietario, byte[] firma, byte[] sello, Date vencimiento, String case_) {
        super(VCotizacion.V_COTIZACION);

        set(0, idcotizacion);
        set(1, numero);
        set(2, fecha);
        set(3, idcliente);
        set(4, nombrecliente);
        set(5, direccion);
        set(6, telefono);
        set(7, total);
        set(8, enletras);
        set(9, validapor);
        set(10, propietario);
        set(11, firma);
        set(12, sello);
        set(13, vencimiento);
        set(14, case_);
    }
}
