package design.combobox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;

/*@author JL Desk */
public class ComboUI extends BasicComboBoxUI{
    
    private Color fondo = new Color(245,79,41);
    private Color colorUI;
    
    public ComboUI(Color fondo, Color colorUI){
        this.fondo = fondo;
        this.colorUI = colorUI;
    }

    
    @Override 
    protected JButton createArrowButton() {   
        BasicArrowButton basicArrowButton = new BasicArrowButton(
                BasicArrowButton.SOUTH, //Direccion de la flecha
                colorUI, //Color de fondo
                fondo,//sombra
                fondo,//darkShadow
                fondo //highlight
        ); 
        basicArrowButton.setBorder(BorderFactory.createLineBorder(colorUI,2));
        basicArrowButton.setContentAreaFilled(false); 
        return basicArrowButton;
    }
    
    @Override
    public void paintCurrentValueBackground(Graphics g,
            Rectangle bounds,
            boolean hasFocus){
        g.setColor( fondo );
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
    
    @Override
    protected ListCellRenderer createRenderer(){
        return new DefaultListCellRenderer() { 
            @Override
            public Component getListCellRendererComponent(JList list,Object value,int index,
                    boolean isSelected,boolean cellHasFocus) {
                super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
                list.setSelectionBackground(fondo);
                if (isSelected){
                    setBackground( colorUI );
                    setForeground(fondo);
                }else{
                    setBackground( fondo );
                    setForeground( new Color(70,70,70));
                }
                if (index!=-1) {
                    //setIcon( espacio );
                }
                return this;
            }
        };
    }
   
    @Override
    public void installUI(JComponent c){
        super.installUI(c);
        if (c instanceof JComboBox){
            comboBox = (JComboBox) c;
            comboBox.setOpaque(true);
            comboBox.setLayout(createLayoutManager());
            comboBox.setBorder(new javax.swing.border.LineBorder(colorUI, 2, true));
            installDefaults();
            installComponents();
            installListeners();
            installKeyboardActions();
        }
    }
}
