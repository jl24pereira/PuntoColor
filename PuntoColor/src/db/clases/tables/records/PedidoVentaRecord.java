/**
 * This class is generated by jOOQ
 */
package db.clases.tables.records;


import db.clases.tables.PedidoVenta;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class PedidoVentaRecord extends TableRecordImpl<PedidoVentaRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = -825502251;

    /**
     * Setter for <code>public.pedido_venta.idventa</code>.
     */
    public void setIdventa(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.pedido_venta.idventa</code>.
     */
    public Integer getIdventa() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.pedido_venta.idpedido</code>.
     */
    public void setIdpedido(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.pedido_venta.idpedido</code>.
     */
    public Integer getIdpedido() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return PedidoVenta.PEDIDO_VENTA.IDVENTA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return PedidoVenta.PEDIDO_VENTA.IDPEDIDO;
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
    public Integer value2() {
        return getIdpedido();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PedidoVentaRecord value1(Integer value) {
        setIdventa(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PedidoVentaRecord value2(Integer value) {
        setIdpedido(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PedidoVentaRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PedidoVentaRecord
     */
    public PedidoVentaRecord() {
        super(PedidoVenta.PEDIDO_VENTA);
    }

    /**
     * Create a detached, initialised PedidoVentaRecord
     */
    public PedidoVentaRecord(Integer idventa, Integer idpedido) {
        super(PedidoVenta.PEDIDO_VENTA);

        set(0, idventa);
        set(1, idpedido);
    }
}
