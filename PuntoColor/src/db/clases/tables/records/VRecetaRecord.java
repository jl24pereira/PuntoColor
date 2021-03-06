/**
 * This class is generated by jOOQ
 */
package db.clases.tables.records;


import db.clases.tables.VReceta;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class VRecetaRecord extends TableRecordImpl<VRecetaRecord> implements Record9<Integer, String, String, Double, Integer, String, Double, String, Integer> {

    private static final long serialVersionUID = -1123547763;

    /**
     * Setter for <code>public.v_receta.idinventario</code>.
     */
    public void setIdinventario(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.v_receta.idinventario</code>.
     */
    public Integer getIdinventario() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.v_receta.codigo</code>.
     */
    public void setCodigo(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.v_receta.codigo</code>.
     */
    public String getCodigo() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.v_receta.nombre</code>.
     */
    public void setNombre(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.v_receta.nombre</code>.
     */
    public String getNombre() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.v_receta.descargo</code>.
     */
    public void setDescargo(Double value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.v_receta.descargo</code>.
     */
    public Double getDescargo() {
        return (Double) get(3);
    }

    /**
     * Setter for <code>public.v_receta.idunidad</code>.
     */
    public void setIdunidad(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.v_receta.idunidad</code>.
     */
    public Integer getIdunidad() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.v_receta.detalle</code>.
     */
    public void setDetalle(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.v_receta.detalle</code>.
     */
    public String getDetalle() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.v_receta.equivalencia</code>.
     */
    public void setEquivalencia(Double value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.v_receta.equivalencia</code>.
     */
    public Double getEquivalencia() {
        return (Double) get(6);
    }

    /**
     * Setter for <code>public.v_receta.descontaren</code>.
     */
    public void setDescontaren(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.v_receta.descontaren</code>.
     */
    public String getDescontaren() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.v_receta.idproducto</code>.
     */
    public void setIdproducto(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.v_receta.idproducto</code>.
     */
    public Integer getIdproducto() {
        return (Integer) get(8);
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, String, String, Double, Integer, String, Double, String, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, String, String, Double, Integer, String, Double, String, Integer> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return VReceta.V_RECETA.IDINVENTARIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return VReceta.V_RECETA.CODIGO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return VReceta.V_RECETA.NOMBRE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field4() {
        return VReceta.V_RECETA.DESCARGO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return VReceta.V_RECETA.IDUNIDAD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return VReceta.V_RECETA.DETALLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field7() {
        return VReceta.V_RECETA.EQUIVALENCIA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return VReceta.V_RECETA.DESCONTAREN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return VReceta.V_RECETA.IDPRODUCTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdinventario();
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
        return getDescargo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getIdunidad();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getDetalle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value7() {
        return getEquivalencia();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getDescontaren();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getIdproducto();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VRecetaRecord value1(Integer value) {
        setIdinventario(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VRecetaRecord value2(String value) {
        setCodigo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VRecetaRecord value3(String value) {
        setNombre(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VRecetaRecord value4(Double value) {
        setDescargo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VRecetaRecord value5(Integer value) {
        setIdunidad(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VRecetaRecord value6(String value) {
        setDetalle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VRecetaRecord value7(Double value) {
        setEquivalencia(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VRecetaRecord value8(String value) {
        setDescontaren(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VRecetaRecord value9(Integer value) {
        setIdproducto(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VRecetaRecord values(Integer value1, String value2, String value3, Double value4, Integer value5, String value6, Double value7, String value8, Integer value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VRecetaRecord
     */
    public VRecetaRecord() {
        super(VReceta.V_RECETA);
    }

    /**
     * Create a detached, initialised VRecetaRecord
     */
    public VRecetaRecord(Integer idinventario, String codigo, String nombre, Double descargo, Integer idunidad, String detalle, Double equivalencia, String descontaren, Integer idproducto) {
        super(VReceta.V_RECETA);

        set(0, idinventario);
        set(1, codigo);
        set(2, nombre);
        set(3, descargo);
        set(4, idunidad);
        set(5, detalle);
        set(6, equivalencia);
        set(7, descontaren);
        set(8, idproducto);
    }
}
