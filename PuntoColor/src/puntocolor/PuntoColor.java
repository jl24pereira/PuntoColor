
package puntocolor;

import clases.Mensajero;
import conexion.Database;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author Jose Luis */
public class PuntoColor {
    //public static InicioSesion sesion = new InicioSesion();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //sesion.setVisible(true); 
        //System.out.println("test");
        new InicioSesion().setVisible(true);
    }
    
}
