
package design.tabla;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/*@author jlpereira */
public class HeaderCellRenderer implements TableCellRenderer{
    Color fondo;
    private Font bold = new Font( "Arial",Font.BOLD ,12 );
    
    public HeaderCellRenderer(Color fondo){
        this.fondo = fondo;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent jcomponent = null;
        if( value instanceof String ) {
            jcomponent = new JLabel((String) value);
            ((JLabel)jcomponent).setHorizontalAlignment( SwingConstants.CENTER );
            ((JLabel)jcomponent).setSize( 30, jcomponent.getWidth() );   
            ((JLabel)jcomponent).setPreferredSize( new Dimension(6, jcomponent.getWidth())  );
            ((JLabel)jcomponent).setFont(bold) ;
        }         
   
        jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(221, 211, 211)));
        jcomponent.setOpaque(true);
        jcomponent.setBackground( fondo );
        jcomponent.setForeground(Color.white);
        jcomponent.setToolTipText("");
        return jcomponent;
    }
    
}
