/**
 * This class is generated by jOOQ
 */
package db.clases.tables.records;


import db.clases.tables.DetallePedido;

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
public class DetallePedidoRecord extends TableRecordImpl<DetallePedidoRecord> implements Record8<Float, BigDecimal, Integer, Integer, Integer, Boolean, Float, Float> {

    private static final long serialVersionUID = -1139156502;

    /**
     * Setter for <code>public.detalle_pedido.cantidad</code>.
     */
    public void setCantidad(Float value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.detalle_pedido.cantidad</code>.
     */
    public Float getCantidad() {
        return (Float) get(0);
    }

    /**
     * Setter for <code>public.detalle_pedido.precio</code>.
     */
    public void setPrecio(BigDecimal value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.detalle_pedido.precio</code>.
     */
    public BigDecimal getPrecio() {
        return (BigDecimal) get(1);
    }

    /**
     * Setter for <code>public.detalle_pedido.idtamanio</code>.
     */
    public void setIdtamanio(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.detalle_pedido.idtamanio</code>.
     */
    public Integer getIdtamanio() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.detalle_pedido.idpedido</code>.
     */
    public void setIdpedido(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.detalle_pedido.idpedido</code>.
     */
    public Integer getIdpedido() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.detalle_pedido.idproducto</code>.
     */
    public void setIdproducto(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.detalle_pedido.idproducto</code>.
     */
    public Integer getIdproducto() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.detalle_pedido.especial</code>.
     */
    public void setEspecial(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.detalle_pedido.especial</code>.
     */
    public Boolean getEspecial() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>public.detalle_pedido.ancho</code>.
     */
    public void setAncho(Float value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.detalle_pedido.ancho</code>.
     */
    public Float getAncho() {
        return (Float) get(6);
    }

    /**
     * Setter for <code>public.detalle_pedido.largo</code>.
     */
    public void setLargo(Float value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.detalle_pedido.largo</code>.
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
    public Row8<Float, BigDecimal, Integer, Integer, Integer, Boolean, Float, Float> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Float, BigDecimal, Integer, Integer, Integer, Boolean, Float, Float> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Float> field1() {
        return DetallePedido.DETALLE_PEDIDO.CANTIDAD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field2() {
        return DetallePedido.DETALLE_PEDIDO.PRECIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return DetallePedido.DETALLE_PEDIDO.IDTAMANIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return DetallePedido.DETALLE_PEDIDO.IDPEDIDO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return DetallePedido.DETALLE_PEDIDO.IDPRODUCTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field6() {
        return DetallePedido.DETALLE_PEDIDO.ESPECIAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Float> field7() {
        return DetallePedido.DETALLE_PEDIDO.ANCHO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Float> field8() {
        return DetallePedido.DETALLE_PEDIDO.LARGO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float value1() {
        return getCantidad();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value2() {
        return getPrecio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getIdtamanio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getIdpedido();
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
    public DetallePedidoRecord value1(Float value) {
        setCantidad(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetallePedidoRecord value2(BigDecimal value) {
        setPrecio(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetallePedidoRecord value3(Integer value) {
        setIdtamanio(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetallePedidoRecord value4(Integer value) {
        setIdpedido(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetallePedidoRecord value5(Integer value) {
        setIdproducto(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetallePedidoRecord value6(Boolean value) {
        setEspecial(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetallePedidoRecord value7(Float value) {
        setAncho(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetallePedidoRecord value8(Float value) {
        setLargo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetallePedidoRecord values(Float value1, BigDecimal value2, Integer value3, Integer value4, Integer value5, Boolean value6, Float value7, Float value8) {
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
     * Create a detached DetallePedidoRecord
     */
    public DetallePedidoRecord() {
        super(DetallePedido.DETALLE_PEDIDO);
    }

    /**
     * Create a detached, initialised DetallePedidoRecord
     */
    public DetallePedidoRecord(Float cantidad, BigDecimal precio, Integer idtamanio, Integer idpedido, Integer idproducto, Boolean especial, Float ancho, Float largo) {
        super(DetallePedido.DETALLE_PEDIDO);

        set(0, cantidad);
        set(1, precio);
        set(2, idtamanio);
        set(3, idpedido);
        set(4, idproducto);
        set(5, especial);
        set(6, ancho);
        set(7, largo);
    }
}
