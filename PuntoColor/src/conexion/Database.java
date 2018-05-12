
package conexion;

import clases.Mensajes;
import clases.Propiedades;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author JL Desk */
public final class Database {
    /* DATOS PARA LA CONEXION */
    /** usuario */
    private String user;
    /** contraseña de MySql*/
    private String password;
    /** Cadena de conexion */
    private String url;
    /** Servidor */
    private String servidor;
    /** Puerto del servidor*/
    private String puerto;
    /** base de datos por defecto es test*/
    private String db;
    /** variable para trabajar con la conexion a la base de datos */
    private Connection conexion;
    /** variable para capturar el error*/
    private String error;
    
    private static final Propiedades prop = new Propiedades();
    
    /** Constructor de clase */ 
    public Database(){
        prop.leerPropiedades();
        setUser(prop.getUser());
        setPassword(prop.getPass());
        setServidor(prop.getServer());
        setPuerto(prop.getPort());
        setDb(prop.getDatabase());
    }
    
    public Database(String user, String pass, String servidor, String puerto, String database){
        setUser(user);
        setPassword(pass);
        setServidor(servidor);
        setPuerto(puerto);
        setDb(database);
    }
    
    public Connection getConexion(){
        return this.conexion;
    }
    
    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
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
     * @return the servidor
     */
    public String getServidor() {
        return servidor;
    }

    /**
     * @param servidor the servidor to set
     */
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    /**
     * @return the puerto
     */
    public String getPuerto() {
        return puerto;
    }

    /**
     * @param puerto the puerto to set
     */
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    /**
     * @return the db
     */
    public String getDb() {
        return db;
    }

    /**
     * @param db the db to set
     */
    public void setDb(String db) {
        this.db = db;
    }
    
    public void conectar(){
        setUrl("jdbc:postgresql://"+getServidor()+":"+getPuerto()+"/"+getDb());
        try{
            //obtenemos el driver de para mysql
            Class.forName("org.postgresql.Driver");
            //obtenemos la conexión
            setConexion(DriverManager.getConnection(getUrl(), getUser() , getPassword() )); 
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            new Mensajes().mensajeError("Error de conexión a base de datos");
            setConexion(null);
        }
    }
    
    public void desconectar(){
        try {
            getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }
    
    public void resetDB(String respaldo){
        System.out.println("CREANDO DB");
        Runtime runTime;
        Process p = null;
        ProcessBuilder pb;
        String rutaServidor = "C:\\Program Files\\PostgreSQL\\9.5\\bin\\psql.exe";
        String source = "Reportes\\crearDB.sql";
        
        try {
            String[] atato = {rutaServidor,"-d", this.getDb(), "-f", source};
            pb = new ProcessBuilder(atato);
            runTime = Runtime.getRuntime();
            
            //Se asignan valores a las variables de PostgreSQL
            pb.environment().put("PGHOST", this.getServidor());
            pb.environment().put("PGPORT", this.getPuerto());
            pb.environment().put("PGUSER", this.getUser());
            pb.environment().put("PGPASSWORD", this.getPassword());
            pb.redirectErrorStream(true);    
            p = pb.start();
            if(p.waitFor()==0){
                System.out.println("RESTAURANDO DB");
                Runtime r = Runtime.getRuntime();
                String rutaServidor2 = "C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_restore.exe";
                Process p2;
                ProcessBuilder pb2;
                String[] atato2 = {rutaServidor2, "-d", "puntocolordb", "-v", respaldo};
                pb2 = new ProcessBuilder(atato2);       
                r = Runtime.getRuntime();
                //Se asignan valores a las variables de PostgreSQL
                pb2.environment().put("PGHOST", this.getServidor());
                pb2.environment().put("PGPORT", this.getPuerto());
                pb2.environment().put("PGUSER", this.getUser());
                pb2.environment().put("PGPASSWORD", this.getPassword());
                pb2.redirectErrorStream(true);
                p2 = pb2.start();
                InputStream is = p2.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String ll;
                while ((ll = br.readLine()) != null){
                    System.out.println(ll);
                }
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void backup(String ruta){
        prop.leerPropiedades();
        try {
            Calendar cal = GregorianCalendar.getInstance();
            String file = "backup"+cal.get(Calendar.DAY_OF_MONTH)+cal.get(Calendar.MONTH+1)+cal.get(Calendar.YEAR)+
                    cal.get(Calendar.HOUR_OF_DAY)+cal.get(Calendar.MINUTE)+cal.get(Calendar.SECOND)+".backup";
            String path = ruta+"\\"+file;
            Runtime r = Runtime.getRuntime();
            Process p;
            ProcessBuilder pb;
            r = Runtime.getRuntime();
            pb = new ProcessBuilder("C:/Program Files/PostgreSQL/9.5/bin\\pg_dump.exe","--format","custom","--blobs","--verbose","-f", path);
            pb.environment().put("PGHOST", this.getServidor());  
            pb.environment().put("PGPORT", this.getPuerto());
            pb.environment().put("PGUSER", this.getUser());
            pb.environment().put("PGPASSWORD", this.getPassword());
            pb.environment().put("PGDATABASE", this.getDb());
            pb.redirectErrorStream(true);
            pb.start();
            System.out.print("terminado backup "+path+"\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
