/**
 * This class is generated by jOOQ
 */
package db.clases.tables.records;


import db.clases.tables.VDetalleCompra;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class VDetalleCompraRecord extends TableRecordImpl<VDetalleCompraRecord> implements Record6<Integer, String, String, Double, BigDecimal, BigDecimal> {

    private static final long serialVersionUID = -1191788807;

    /**
     * Setter for <code>public.v_detalle_compra.idcompra</code>.
     */
    public void setIdcompra(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.v_detalle_compra.idcompra</code>.
     */
    public Integer getIdcompra() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.v_detalle_compra.codigo</code>.
     */
    public void setCodigo(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.v_detalle_compra.codigo</code>.
     */
    public String getCodigo() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.v_detalle_compra.nombre</code>.
     */
    public void setNombre(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.v_detalle_compra.nombre</code>.
     */
    public String getNombre() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.v_detalle_compra.cantidad</code>.
     */
    public void setCantidad(Double value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.v_detalle_compra.cantidad</code>.
     */
    public Double getCantidad() {
        return (Double) get(3);
    }

    /**
     * Setter for <code>public.v_detalle_compra.preciocompra</code>.
     */
    public void setPreciocompra(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.v_detalle_compra.preciocompra</code>.
     */
    public BigDecimal getPreciocompra() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>public.v_detalle_compra.ventagravada</code>.
     */
    public void setVentagravada(BigDecimal value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.v_detalle_compra.ventagravada</code>.
     */
    public BigDecimal getVentagravada() {
        return (BigDecimal) get(5);
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, String, Double, BigDecimal, BigDecimal> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, String, Double, BigDecimal, BigDecimal> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return VDetalleCompra.V_DETALLE_COMPRA.IDCOMPRA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return VDetalleCompra.V_DETALLE_COMPRA.CODIGO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return VDetalleCompra.V_DETALLE_COMPRA.NOMBRE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field4() {
        return VDetalleCompra.V_DETALLE_COMPRA.CANTIDAD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field5() {
        return VDetalleCompra.V_DETALLE_COMPRA.PRECIOCOMPRA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field6() {
        return VDetalleCompra.V_DETALLE_COMPRA.VENTAGRAVADA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdcompra();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getCodigo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getNombre();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value4() {
        return getCantidad();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value5() {
        return getPreciocompra();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value6() {
        return getVentagravada();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VDetalleCompraRecord value1(Integer value) {
        setIdcompra(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VDetalleCompraRecord value2(String value) {
        setCodigo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VDetalleCompraRecord value3(String value) {
        setNombre(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VDetalleCompraRecord value4(Double value) {
        setCantidad(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VDetalleCompraRecord value5(BigDecimal value) {
        setPreciocompra(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VDetalleCompraRecord value6(BigDecimal value) {
        setVentagravada(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VDetalleCompraRecord values(Integer value1, String value2, String value3, Double value4, BigDecimal value5, BigDecimal value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VDetalleCompraRecord
     */
    public VDetalleCompraRecord() {
        super(VDetalleCompra.V_DETALLE_COMPRA);
    }

    /**
     * Create a detached, initialised VDetalleCompraRecord
     */
    public VDetalleCompraRecord(Integer idcompra, String codigo, String nombre, Double cantidad, BigDecimal preciocompra, BigDecimal ventagravada) {
        super(VDetalleCompra.V_DETALLE_COMPRA);

        set(0, idcompra);
        set(1, codigo);
        set(2, nombre);
        set(3, cantidad);
        set(4, preciocompra);
        set(5, ventagravada);
    }
}