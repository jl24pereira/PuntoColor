
package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*@author PereiraHP */
public class Propiedades {
    private String server;
    private String user;
    private String pass;
    private String port;
    private String database;
    
    
    
    public Propiedades(){
        
    }
    
    public void leerPropiedades(){
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("Propiedades\\config.properties"));
            setServer(""+prop.getProperty("server"));
            setUser(""+prop.getProperty("user"));
            setPass(""+prop.getProperty("pass"));
            setPort(""+prop.getProperty("port"));
            setDatabase(""+prop.getProperty("database"));
        } catch (FileNotFoundException e) {
            System.out.println("Error, El archivo no exite");
        } catch (IOException ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error, No se puede leer el archivo");
        }
    }
    
    public void escribirPropiedades() throws FileNotFoundException, IOException{
        
            Properties props = new Properties();
            props.setProperty("server", getServer());
            props.setProperty("user", getUser());
            props.setProperty("pass", getPass());
            props.setProperty("port", getPort());
            props.setProperty("database", getDatabase());
            File f = new File("Propiedades\\config.properties");
            OutputStream out = new FileOutputStream( f );
            props.store(out, "This is an optional header comment string");
    }

    /**
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(String server) {
        this.server = server;
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
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * @param database the database to set
     */
    public void setDatabase(String database) {
        this.database = database;
    }

}
