
package clases;

import ds.desktop.notify.DesktopNotify;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import message.Message;
import static puntocolor.Principal.permisos;

public class ConexionCliente extends Thread{
    
    //private Logger log = Logger.getLogger(ConexionCliente.class);
    private Socket socket; 
    //private MensajesChat mensajes;
    private ObjectInputStream inData;
    
    public ConexionCliente (Socket socket){
        this.socket = socket;        
        try {
            inData = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.out.println("Error al crear los stream de entrada y salida : " + ex.getMessage());
        }
    }
    
    @Override
    public void run(){
        String mensajeRecibido;
        boolean conectado = true;
        // Se apunta a la lista de observadores de mensajes
        //mensajes.addObserver(this);
        
        while (conectado) {
            
            try {
                // Lee un mensaje enviado por el cliente
                boolean permiso = false;
                Message msg = (Message) inData.readObject();
                switch(msg.getDestino()){
                    case 0://Solo administrador
                        if(permisos.isINFORMACION()){
                            permiso = true;
                        }
                        break;
                    case 1://Si tiene ventas
                        if(permisos.isCONTROL_CAJA()){
                            permiso = true;
                        }
                        break;
                    case 2://Si tiene Diseño
                        if(permisos.isPEDIDOS_DISENIO()){
                            permiso = true;
                        }
                        break;
                    case 3://Si tiene Produccion
                        if(permisos.isPEDIDOS_PRODUCCION()){
                            permiso = true;
                        }
                        break;
                    case 4://Todos
                        permiso = true;
                        break;
                }
                System.out.println(msg.toString());
                if(permiso){
                    DesktopNotify.showDesktopMessage("Punto Color System", //Titulo
                            msg.getMessage(), //Mensaje
                            msg.getTipo(), 
                            14000L);
                }
                
            } catch (IOException ex) {
                System.out.println("Cliente con la IP " + socket.getInetAddress().getHostName() + " desconectado.");
                conectado = false; 
                // Si se ha producido un error al recibir datos del cliente se cierra la conexion con el.
                try {
                    inData.close();
                } catch (IOException ex2) {
                    System.out.println("Error al cerrar los stream de entrada y salida :" + ex2.getMessage());
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
}
