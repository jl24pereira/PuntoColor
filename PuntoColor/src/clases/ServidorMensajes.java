
package clases;

import static db.clases.Tables.CONEXIONES;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static puntocolor.Principal.database;
import static puntocolor.Principal.ue;

/* @author JL Desk */
public class ServidorMensajes implements Runnable{
    private static final int PORT = 5000;
    int maximoConexiones = 10; // Maximo de conexiones simultaneas
    ServerSocket servidor = null; 
    Socket socket = null;
    
    boolean corriendo = false;
    boolean iniciar = true;
    
    Thread hilo;
    
    DSLContext create;
    
    public ServidorMensajes(){
        
    }
    
    @Override
    public void run(){
        try {
            // Se crea el serverSocket
            servidor = new ServerSocket(PORT, maximoConexiones);            
            // Bucle infinito para esperar conexiones
            while (!servidor.isClosed()) {
                System.out.println("Servidor a la espera de conexiones.");
                socket = servidor.accept();
                System.out.println("Cliente con la IP " + socket.getInetAddress().getHostName() + " conectado.");
                ConexionCliente cc = new ConexionCliente(socket);
                cc.start();                
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage()); 
            if(ex.getMessage().equals("Address already in use: JVM_Bind")){
                eliminarLogeo();
                new Mensajes().mensajeError("La aplicación ya esta corriendo con otra sesión!");
                System.exit(0);
            }            
        } finally{
            try {
                if(!servidor.isClosed()){
                    
                    if(!socket.isClosed()){
                        socket.close();
                    }
                }                
                servidor.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el servidor: " + ex.getMessage());
            }
        }
    }
    
    public void iniciarServer(){
        if(!corriendo){
            corriendo = true;
            iniciar = true;
            arrancarServer();
        }
    }
    
    public void finalizarServer(){
        try {
            corriendo = false;
            iniciar=false;
            servidor.close();
            Thread.currentThread().interrupt();
        } catch (IOException ex) {
            Logger.getLogger(ServidorMensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void arrancarServer() {
       if(iniciar){
           new Thread(this).start();
       }
    }
    
    private void eliminarLogeo(){
        create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
        create.deleteFrom(CONEXIONES)
                .where(CONEXIONES.IDEMPLEADO.equal(ue.getIdempleado()))
                .execute();
    }
}
