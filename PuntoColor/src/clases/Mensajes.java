
package clases;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/* @author JL Vaio */
public class Mensajes {
    //private String Mensaje;
    
    public void mensajeInfo(String Mensaje){
        JOptionPane.showMessageDialog(
                null,                                                               //componente
                Mensaje,                                                            //mensaje
                "PUNTO COLOR SYSTEM",                                               //titulo
                JOptionPane.INFORMATION_MESSAGE,                                    //tipo de mensaje
                new ImageIcon(getClass().getResource("/images/Info-64.png")));      //icono
    }
    
    public void mensajeOk(String Mensaje){
        JOptionPane.showMessageDialog(
                null,                                                               //componente
                Mensaje,                                                            //mensaje
                "PUNTO COLOR SYSTEM",                                               //titulo
                JOptionPane.INFORMATION_MESSAGE,                                    //tipo de mensaje
                new ImageIcon(getClass().getResource("/images/Ok-64.png")));      //icono
    }
    
    public void mensajeError(String Mensaje){
        JOptionPane.showMessageDialog(
                null,                                                               //componente
                Mensaje,                                                            //mensaje
                "PUNTO COLOR SYSTEM",                                               //titulo
                JOptionPane.ERROR_MESSAGE,                                          //tipo de mensaje
                new ImageIcon(getClass().getResource("/images/Error-64.png")));     //icono
    }
    
    public void mensajeAlert(String Mensaje){
        JOptionPane.showMessageDialog(
                null,                                                               //componente
                Mensaje,                                                            //mensaje
                "PUNTO COLOR SYSTEM",                                               //titulo
                JOptionPane.ERROR_MESSAGE,                                          //tipo de mensaje
                new ImageIcon(getClass().getResource("/images/Attention-64.png")));     //icono
    }
    
    public int mensajeSiNo(String Mensaje){
        int confirmado = JOptionPane.showOptionDialog(
                    null,                                                               //componente
                    Mensaje,                                                            //mensaje
                    "PUNTO COLOR SYSTEM",                                               //titulo
                    JOptionPane.YES_NO_OPTION,                                          //tipo de mensaje
                    JOptionPane.WARNING_MESSAGE,                                        //tipo de mensaje
                    new ImageIcon(getClass().getResource("/images/Question Mark-64.png")),   // icono
                    null,                                                               // null para YES, NO y CANCEL
                    null);
        return confirmado;
    }
}
