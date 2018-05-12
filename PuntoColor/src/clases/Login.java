
package clases;

import conexion.Database;
import static db.clases.Tables.USUARIO;
import static db.clases.Tables.V_USUARIO_EMPLEADO;
import javax.swing.JOptionPane;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

/* @author Jose Luis */
public class Login {
    private String user;
    private String password;
    private int idUser;
    //public static Database db;
    DSLContext create; 
    
    
    public boolean loguearse(){
        Database db = new Database();
        db.conectar();
        create = DSL.using(db.getConexion(), SQLDialect.POSTGRES_9_5);
        int iduser = 0;
        try{
            iduser=create.select()
                    .from(V_USUARIO_EMPLEADO)
                    .where(V_USUARIO_EMPLEADO.USUARIO.equal(this.getUser())
                    .and(V_USUARIO_EMPLEADO.PASS.equal(this.getPassword()))
                    .and(V_USUARIO_EMPLEADO.BAJA.equal(false)))
                    .fetchOne(V_USUARIO_EMPLEADO.IDUSUARIO);                    
            if(iduser!=0){
                this.setIdUser(iduser);
                db.desconectar();
                return true;
            }else{
                db.desconectar();
                return false;
            }
        }catch(Exception e){
            db.desconectar();
            return false;
        }
    }
    
    public boolean loguearse(boolean superuser){
        if(superuser){
            if(getUser().equals("249092089c76fbc4e3e5fc707a713acc191d34aa0801c880563b2f0f4c151903")
                    && getPassword().equals("83320fc9da399f4173c0485ac183c6bdc08a2a378d0854e0bb3d86e9e4aa839b")){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    
}
