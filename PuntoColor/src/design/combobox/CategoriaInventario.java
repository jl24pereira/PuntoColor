
package design.combobox;

import static db.clases.Tables.INVENTARIO;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static org.jooq.impl.DSL.count;
import static puntocolor.Principal.database;

/* @author Jose Luis */
public class CategoriaInventario {
    
    private int id;
    private String nombre;
    private String detalle;
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    public CategoriaInventario(int id, String nombre, String detalle){
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
    }
    
    public String generarCodigo(){
        String codigo = this.detalle;
        int count = create.select(count())
                .from(INVENTARIO)
                .where(INVENTARIO.CODIGO.like("%"+codigo+"%")).fetchOne(0, int.class);
        if(count == 0){
            codigo = codigo + "0001";
        }else{
            String ultimo = create.select(INVENTARIO.CODIGO)
                    .from(INVENTARIO)
                    .where(INVENTARIO.CODIGO.like("%"+codigo+"%"))
                    .orderBy(INVENTARIO.IDINVENTARIO.desc())
                    .limit(1)
                    .fetchOne(0,String.class);
            String toInteger = "";
            for (int i = 3; i < ultimo.length(); i++){
                toInteger = toInteger+ultimo.charAt(i);
            }
            int correlativo = Integer.parseInt(toInteger);
            correlativo++;
            if(correlativo < 10){
                codigo = codigo + "000" + correlativo;
            }else if(correlativo <100){
                codigo = codigo + "00" + correlativo;
            }else if(correlativo <1000){
                codigo = codigo + "0" + correlativo;
            }else{
                codigo = codigo + correlativo;
            }
        }
        return codigo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the detalle
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
}
