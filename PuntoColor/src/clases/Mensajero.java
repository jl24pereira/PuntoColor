
package clases;
import conexion.Database;
import static db.clases.Tables.CONEXIONES;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import message.Message;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import static puntocolor.Principal.database;

/* @author Jose Luis */
public class Mensajero{
    
    private static final int PORT = 5000;
    ServerSocket serverSocket = null;
    
    private Socket socket;   
    
    
    
    public Mensajero(){
        
    }
    
    public String[] seleccionarDestinatarios(int destinos){ 
        Database d = new Database();
        d.conectar();
        DSLContext create = DSL.using(d.getConexion(), SQLDialect.POSTGRES_9_5);
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(CONEXIONES);
        Condition miIP = null;
        try {
            miIP = CONEXIONES.IP.notEqual(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mensajero.class.getName()).log(Level.SEVERE, null, ex);
        }    
        query.addConditions(miIP);
        //Result<Record> result = query.fetch();
        String [] ips = query.fetchArray(CONEXIONES.IP,String.class);
        d.desconectar();
        return ips;
    }
    
    public void enviarMensaje(String mensaje,int tipoMsg, int destino){ 
        //seleccionarDestinatarios(destino,d);
        try {
            System.out.println("Connected");            
            String [] IPS = seleccionarDestinatarios(destino);
            for (String IPS1 : IPS) {
                System.out.println(IPS1);
                socket = new Socket(IPS1, PORT);
                ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
                Message msg = new Message(tipoMsg,mensaje,destino);
                salida.writeObject(msg);
                salida.flush();
                salida.close();
            }            
        } catch (IOException ex) {
            Logger.getLogger(Mensajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
