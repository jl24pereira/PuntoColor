/**
 * This class is generated by jOOQ
 */
package db.clases.tables.records;


import db.clases.tables.DetalleVenta;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class DetalleVentaRecord extends TableRecordImpl<DetalleVentaRecord> implements Record8<Integer, Float, BigDecimal, Integer, Integer, Boolean, Float, Float> {

    private static final long serialVersionUID = 248143911;

    /**
     * Setter for <code>public.detalle_venta.idventa</code>.
     */
    public void setIdventa(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.detalle_venta.idventa</code>.
     */
    public Integer getIdventa() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.detalle_venta.cantidad</code>.
     */
    public void setCantidad(Float value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.detalle_venta.cantidad</code>.
     */
    public Float getCantidad() {
        return (Float) get(1);
    }

    /**
     * Setter for <code>public.detalle_venta.precio</code>.
     */
    public void setPrecio(BigDecimal value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.detalle_venta.precio</code>.
     */
    public BigDecimal getPrecio() {
        return (BigDecimal) get(2);
    }

    /**
     * Setter for <code>public.detalle_venta.idtamanio</code>.
     */
    public void setIdtamanio(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.detalle_venta.idtamanio</code>.
     */
    public Integer getIdtamanio() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.detalle_venta.idproducto</code>.
     */
    public void setIdproducto(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.detalle_venta.idproducto</code>.
     */
    public Integer getIdproducto() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.detalle_venta.especial</code>.
     */
    public void setEspecial(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.detalle_venta.especial</code>.
     */
    public Boolean getEspecial() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>public.detalle_venta.ancho</code>.
     */
    public void setAncho(Float value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.detalle_venta.ancho</code>.
     */
    public Float getAncho() {
        return (Float) get(6);
    }

    /**
     * Setter for <code>public.detalle_venta.largo</code>.
     */
    public void setLargo(Float value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.detalle_venta.largo</code>.
     */
    public Float getLargo() {
        return (Float) get(7);
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, Float, BigDecimal, Integer, Integer, Boolean, Float, Float> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, Float, BigDecimal, Integer, Integer, Boolean, Float, Float> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return DetalleVenta.DETALLE_VENTA.IDVENTA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Float> field2() {
        return DetalleVenta.DETALLE_VENTA.CANTIDAD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field3() {
        return DetalleVenta.DETALLE_VENTA.PRECIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return DetalleVenta.DETALLE_VENTA.IDTAMANIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return DetalleVenta.DETALLE_VENTA.IDPRODUCTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field6() {
        return DetalleVenta.DETALLE_VENTA.ESPECIAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Float> field7() {
        return DetalleVenta.DETALLE_VENTA.ANCHO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Float> field8() {
        return DetalleVenta.DETALLE_VENTA.LARGO;
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
    public Float value2() {
        return getCantidad();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value3() {
        return getPrecio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getIdtamanio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getIdproducto();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value6() {
        return getEspecial();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float value7() {
        return getAncho();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float value8() {
        return getLargo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleVentaRecord value1(Integer value) {
        setIdventa(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleVentaRecord value2(Float value) {
        setCantidad(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleVentaRecord value3(BigDecimal value) {
        setPrecio(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleVentaRecord value4(Integer value) {
        setIdtamanio(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleVentaRecord value5(Integer value) {
        setIdproducto(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleVentaRecord value6(Boolean value) {
        setEspecial(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleVentaRecord value7(Float value) {
        setAncho(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleVentaRecord value8(Float value) {
        setLargo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetalleVentaRecord values(Integer value1, Float value2, BigDecimal value3, Integer value4, Integer value5, Boolean value6, Float value7, Float value8) {
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
     * Create a detached DetalleVentaRecord
     */
    public DetalleVentaRecord() {
        super(DetalleVenta.DETALLE_VENTA);
    }

    /**
     * Create a detached, initialised DetalleVentaRecord
     */
    public DetalleVentaRecord(Integer idventa, Float cantidad, BigDecimal precio, Integer idtamanio, Integer idproducto, Boolean especial, Float ancho, Float largo) {
        super(DetalleVenta.DETALLE_VENTA);

        set(0, idventa);
        set(1, cantidad);
        set(2, precio);
        set(3, idtamanio);
        set(4, idproducto);
        set(5, especial);
        set(6, ancho);
        set(7, largo);
    }
}
