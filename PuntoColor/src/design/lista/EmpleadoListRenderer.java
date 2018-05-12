
package design.lista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/* @author JL Desk */
public class EmpleadoListRenderer extends JPanel implements ListCellRenderer<Empleado> {

    Font fuente=new Font("Monospaced", Font.BOLD, 18);
    panelListaEmpleados panel;
    Color conFocus, sinFocus;
    
    public EmpleadoListRenderer(Color conFocus, Color sinFocus) {
        setLayout(new BorderLayout(5, 5));
        panel = new panelListaEmpleados();
        add(panel, BorderLayout.CENTER);
        this.conFocus = conFocus;
        this.sinFocus = sinFocus;
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Empleado> jlist, Empleado e, int i, boolean isSelected, boolean bln1) {
        panel.lblIcon.setIcon(e.getImagen());
        panel.lblNombre.setText(e.getNombre());
        panel.lblDireccion.setText(e.getDireccion());
        panel.lblCargo.setText(e.getCargo());
        
        panel.lblNombre.setOpaque(true);
        panel.lblDireccion.setOpaque(true);
        
        if (isSelected) {
            panel.lblNombre.setBackground(jlist.getSelectionBackground());
            panel.lblNombre.setForeground(conFocus);
            panel.lblDireccion.setBackground(jlist.getSelectionBackground());
            //panel.lblTelefono.setBackground(jlist.getSelectionBackground());
            setBackground(jlist.getSelectionBackground());
        } else { 
            panel.lblNombre.setBackground(jlist.getBackground());
            panel.lblNombre.setForeground(sinFocus);
            panel.lblDireccion.setBackground(jlist.getBackground());
            //panel.lblTelefono.setBackground(jlist.getBackground());
            setBackground(jlist.getBackground());
        }
        return this;
    }    
}
