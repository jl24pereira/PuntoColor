/**
 * This class is generated by jOOQ
 */
package db.clases.tables;


import db.clases.Keys;
import db.clases.Public;
import db.clases.tables.records.GastosEmpresaRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


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
public class GastosEmpresa extends TableImpl<GastosEmpresaRecord> {

    private static final long serialVersionUID = 1260339131;

    /**
     * The reference instance of <code>public.gastos_empresa</code>
     */
    public static final GastosEmpresa GASTOS_EMPRESA = new GastosEmpresa();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GastosEmpresaRecord> getRecordType() {
        return GastosEmpresaRecord.class;
    }

    /**
     * The column <code>public.gastos_empresa.nit</code>.
     */
    public final TableField<GastosEmpresaRecord, String> NIT = createField("nit", org.jooq.impl.SQLDataType.VARCHAR.length(25), this, "");

    /**
     * The column <code>public.gastos_empresa.idgasto</code>.
     */
    public final TableField<GastosEmpresaRecord, Integer> IDGASTO = createField("idgasto", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.gastos_empresa.gasto</code>.
     */
    public final TableField<GastosEmpresaRecord, BigDecimal> GASTO = createField("gasto", org.jooq.impl.SQLDataType.NUMERIC.precision(6, 2), this, "");

    /**
     * Create a <code>public.gastos_empresa</code> table reference
     */
    public GastosEmpresa() {
        this("gastos_empresa", null);
    }

    /**
     * Create an aliased <code>public.gastos_empresa</code> table reference
     */
    public GastosEmpresa(String alias) {
        this(alias, GASTOS_EMPRESA);
    }

    private GastosEmpresa(String alias, Table<GastosEmpresaRecord> aliased) {
        this(alias, aliased, null);
    }

    private GastosEmpresa(String alias, Table<GastosEmpresaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<GastosEmpresaRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<GastosEmpresaRecord, ?>>asList(Keys.GASTOS_EMPRESA__FK_GASTOS_EMPRESA_EMPRESA, Keys.GASTOS_EMPRESA__FK_GASTOS_EMPRESA_GASTOS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GastosEmpresa as(String alias) {
        return new GastosEmpresa(alias, this);
    }

    /**
     * Rename this table
     */
    public GastosEmpresa rename(String name) {
        return new GastosEmpresa(name, null);
    }
}
