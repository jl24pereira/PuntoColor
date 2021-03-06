/**
 * This class is generated by jOOQ
 */
package db.clases.tables.records;


import db.clases.tables.DetalleCompra;

import java.math.BigDecimal;

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
public class DetalleCompraRecord extends TableRecordImpl<DetalleCompraRecord> implements Record4<Double, BigDecimal, Integer, Integer> {

    private static final long serialVersionUID = -1874887619;

    /**
     * Setter for <code>public.detalle_compra.cantidad</code>.
     */
    public void setCantidad(Double value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.detalle_compra.cantidad</code>.
     */
    public Double getCantidad() {
        return (Double) get(0);
    }

    /**
     * Setter for <code>public.detalle_compra.preciocompra</code>.
     */
    public void setPreciocompra(BigDecimal value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.detalle_compra.preciocompra</code>.
     */
    public BigDecimal getPreciocompra() {
        return (BigDecimal) get(1);
    }

    /**
     * Setter for <code>public.detalle_compra.idcompra</code>.
     */
    public void setIdcompra(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.detalle_compra.idcompra</code>.
     */
    public Integer getIdcompra() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.detalle_compra.idinventario</code>.
     */
    public void setIdinventario(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.detalle_compra.idinventario</code>.
     */
    public Integer getIdinventario() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Double, BigDecimal, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Double, BigDecimal, Integer, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field1() {
        return DetalleCompra.DETALLE_COMPRA.CANTIDAD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field2() {
        return DetalleCompra.DETALLE_COMPRA.PRECIOCOMPRA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return DetalleCompra.DETALLE_COMPRA.IDCOMPRA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return DetalleCompra.DETALLE_COMPRA.IDINVENTARIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value1() {
        return getCantidad();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value2() {
        return getPreciocompra();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getIdcompra();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getIdinventario();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleCompraRecord value1(Double value) {
        setCantidad(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleCompraRecord value2(BigDecimal value) {
        setPreciocompra(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleCompraRecord value3(Integer value) {
        setIdcompra(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleCompraRecord value4(Integer value) {
        setIdinventario(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleCompraRecord values(Double value1, BigDecimal value2, Integer value3, Integer value4) {
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
     * Create a detached DetalleCompraRecord
     */
    public DetalleCompraRecord() {
        super(DetalleCompra.DETALLE_COMPRA);
    }

    /**
     * Create a detached, initialised DetalleCompraRecord
     */
    public DetalleCompraRecord(Double cantidad, BigDecimal preciocompra, Integer idcompra, Integer idinventario) {
        super(DetalleCompra.DETALLE_COMPRA);

        set(0, cantidad);
        set(1, preciocompra);
        set(2, idcompra);
        set(3, idinventario);
    }
}
