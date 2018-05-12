
package clases;

import conexion.Database;
import static db.clases.Tables.V_USUARIO_EMPLEADO;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static puntocolor.Principal.database;

/* @author Jose Luis */
public class UsuarioEmpleado {
    private String nombre;
    private int idempleado;
    private int idusuario;
    private String cargo;
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);    
    
    public UsuarioEmpleado(int idusuario){
        this.idusuario = idusuario;
        cargarInfoUsuario(idusuario);
    }
    
    public UsuarioEmpleado(String superuser){
        this.nombre = superuser;
    }
    
    private void cargarInfoUsuario(int id){        
        Record r = create.select()
                .from(V_USUARIO_EMPLEADO)
                .where(V_USUARIO_EMPLEADO.IDUSUARIO.equal(id))
                .fetchOne();
        this.setIdempleado(r.getValue(V_USUARIO_EMPLEADO.IDEMPLEADO));
        this.setIdusuario(r.getValue(V_USUARIO_EMPLEADO.IDUSUARIO));
        this.setNombre(r.getValue(V_USUARIO_EMPLEADO.NOMBRE));
        this.setCargo(r.getValue(V_USUARIO_EMPLEADO.CARGO));
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
     * @return the idempleado
     */
    public int getIdempleado() {
        return idempleado;
    }

    /**
     * @param idempleado the idempleado to set
     */
    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    /**
     * @return the idusuario
     */
    public int getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
