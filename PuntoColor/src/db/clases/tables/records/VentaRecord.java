/**
 * This class is generated by jOOQ
 */
package db.clases.tables.records;


import db.clases.tables.Venta;

import java.math.BigDecimal;
import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class VentaRecord extends UpdatableRecordImpl<VentaRecord> implements Record8<Integer, String, Date, Integer, Integer, BigDecimal, String, String> {

    private static final long serialVersionUID = -1883388448;

    /**
     * Setter for <code>public.venta.idventa</code>.
     */
    public void setIdventa(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.venta.idventa</code>.
     */
    public Integer getIdventa() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.venta.numerofactura</code>.
     */
    public void setNumerofactura(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.venta.numerofactura</code>.
     */
    public String getNumerofactura() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.venta.fecha</code>.
     */
    public void setFecha(Date value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.venta.fecha</code>.
     */
    public Date getFecha() {
        return (Date) get(2);
    }

    /**
     * Setter for <code>public.venta.idcliente</code>.
     */
    public void setIdcliente(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.venta.idcliente</code>.
     */
    public Integer getIdcliente() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.venta.idempleado</code>.
     */
    public void setIdempleado(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.venta.idempleado</code>.
     */
    public Integer getIdempleado() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.venta.total</code>.
     */
    public void setTotal(BigDecimal value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.venta.total</code>.
     */
    public BigDecimal getTotal() {
        return (BigDecimal) get(5);
    }

    /**
     * Setter for <code>public.venta.enletras</code>.
     */
    public void setEnletras(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.venta.enletras</code>.
     */
    public String getEnletras() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.venta.tipodoc</code>.
     */
    public void setTipodoc(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.venta.tipodoc</code>.
     */
    public String getTipodoc() {
        return (String) get(7);
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
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, String, Date, Integer, Integer, BigDecimal, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, String, Date, Integer, Integer, BigDecimal, String, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Venta.VENTA.IDVENTA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Venta.VENTA.NUMEROFACTURA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field3() {
        return Venta.VENTA.FECHA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Venta.VENTA.IDCLIENTE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Venta.VENTA.IDEMPLEADO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field6() {
        return Venta.VENTA.TOTAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Venta.VENTA.ENLETRAS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Venta.VENTA.TIPODOC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdventa();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getNumerofactura();
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
    public Integer value5() {
        return getIdempleado();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value6() {
        return getTotal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getEnletras();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getTipodoc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VentaRecord value1(Integer value) {
        setIdventa(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VentaRecord value2(String value) {
        setNumerofactura(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VentaRecord value3(Date value) {
        setFecha(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VentaRecord value4(Integer value) {
        setIdcliente(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VentaRecord value5(Integer value) {
        setIdempleado(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VentaRecord value6(BigDecimal value) {
        setTotal(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VentaRecord value7(String value) {
        setEnletras(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VentaRecord value8(String value) {
        setTipodoc(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VentaRecord values(Integer value1, String value2, Date value3, Integer value4, Integer value5, BigDecimal value6, String value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VentaRecord
     */
    public VentaRecord() {
        super(Venta.VENTA);
    }

    /**
     * Create a detached, initialised VentaRecord
     */
    public VentaRecord(Integer idventa, String numerofactura, Date fecha, Integer idcliente, Integer idempleado, BigDecimal total, String enletras, String tipodoc) {
        super(Venta.VENTA);

        set(0, idventa);
        set(1, numerofactura);
        set(2, fecha);
        set(3, idcliente);
        set(4, idempleado);
        set(5, total);
        set(6, enletras);
        set(7, tipodoc);
    }
}