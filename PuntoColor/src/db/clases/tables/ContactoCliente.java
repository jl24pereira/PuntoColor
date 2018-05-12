/**
 * This class is generated by jOOQ
 */
package db.clases.tables;


import db.clases.Keys;
import db.clases.Public;
import db.clases.tables.records.ContactoClienteRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class ContactoCliente extends TableImpl<ContactoClienteRecord> {

    private static final long serialVersionUID = 1806682217;

    /**
     * The reference instance of <code>public.contacto_cliente</code>
     */
    public static final ContactoCliente CONTACTO_CLIENTE = new ContactoCliente();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ContactoClienteRecord> getRecordType() {
        return ContactoClienteRecord.class;
    }

    /**
     * The column <code>public.contacto_cliente.idcontacto</code>.
     */
    public final TableField<ContactoClienteRecord, Integer> IDCONTACTO = createField("idcontacto", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval(('\"contacto_cliente_idcontacto_seq\"'::text)::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.contacto_cliente.nombre</code>.
     */
    public final TableField<ContactoClienteRecord, String> NOMBRE = createField("nombre", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.contacto_cliente.telefono</code>.
     */
    public final TableField<ContactoClienteRecord, String> TELEFONO = createField("telefono", org.jooq.impl.SQLDataType.VARCHAR.length(9), this, "");

    /**
     * The column <code>public.contacto_cliente.idcliente</code>.
     */
    public final TableField<ContactoClienteRecord, Integer> IDCLIENTE = createField("idcliente", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>public.contacto_cliente</code> table reference
     */
    public ContactoCliente() {
        this("contacto_cliente", null);
    }

    /**
     * Create an aliased <code>public.contacto_cliente</code> table reference
     */
    public ContactoCliente(String alias) {
        this(alias, CONTACTO_CLIENTE);
    }

    private ContactoCliente(String alias, Table<ContactoClienteRecord> aliased) {
        this(alias, aliased, null);
    }

    private ContactoCliente(String alias, Table<ContactoClienteRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ContactoClienteRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CONTACTO_CLIENTE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ContactoClienteRecord> getPrimaryKey() {
        return Keys.PK_CONTACTO_CLIENTE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ContactoClienteRecord>> getKeys() {
        return Arrays.<UniqueKey<ContactoClienteRecord>>asList(Keys.PK_CONTACTO_CLIENTE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ContactoClienteRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ContactoClienteRecord, ?>>asList(Keys.CONTACTO_CLIENTE__FK_CONTACTO_CLIENTE_CLIENTE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContactoCliente as(String alias) {
        return new ContactoCliente(alias, this);
    }

    /**
     * Rename this table
     */
    public ContactoCliente rename(String name) {
        return new ContactoCliente(name, null);
    }
}
