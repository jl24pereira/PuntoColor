
package design.lista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/* @author JL Desk */
public class LogeoListRenderer extends JPanel implements ListCellRenderer<Logeos> {

    Font fuente=new Font("Monospaced", Font.BOLD, 18);
    panelListaLogeo panel;
    Color conFocus, sinFocus;
    
    public LogeoListRenderer(Color conFocus, Color sinFocus) {
        setLayout(new BorderLayout(5, 5));
        panel = new panelListaLogeo();
        add(panel, BorderLayout.CENTER);
        this.conFocus = conFocus;
        this.sinFocus = sinFocus;
    }   

    @Override
    public Component getListCellRendererComponent(JList<? extends Logeos> jlist, Logeos e, int i, boolean isSelected, boolean bln1) {
        panel.lblIcon.setIcon(e.getImagen());
        panel.lblNombre.setText(e.getNombre());
        panel.lblCargo.setText(e.getCargo());
        
        panel.lblNombre.setOpaque(true);
        
        if (isSelected) {
            panel.lblNombre.setBackground(jlist.getSelectionBackground());
            panel.lblNombre.setForeground(conFocus);
            //panel.lblTelefono.setBackground(jlist.getSelectionBackground());
            setBackground(jlist.getSelectionBackground());
        } else { 
            panel.lblNombre.setBackground(jlist.getBackground());
            panel.lblNombre.setForeground(sinFocus);
            //panel.lblTelefono.setBackground(jlist.getBackground());
            setBackground(jlist.getBackground());
        }
        return this;
    }
}
