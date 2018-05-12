
package clases;

import java.awt.GridBagConstraints;
import javax.swing.JPanel;

/* @author JL Desk */
public class AgregarPanel {
    
    GridBagConstraints  gbcMain = new GridBagConstraints();
    
    public AgregarPanel(){
        gbcMain.fill = java.awt.GridBagConstraints.BOTH;
        gbcMain.anchor = java.awt.GridBagConstraints.CENTER;
        gbcMain.weightx = 1.0;
        gbcMain.weighty = 1.0;
    }
        
    public void insertarPanelMain(JPanel padre, JPanel hijo){
        if(padre.getComponentCount()>0){
            if(!padre.getComponent(0).getClass().getName().equals(hijo.getClass().getName())){
                padre.removeAll();
                padre.add(hijo,gbcMain);
                padre.updateUI();
                padre.repaint();
                hijo.setVisible(true);
            }
        }else{
            padre.removeAll();
            padre.add(hijo,gbcMain);
            padre.updateUI();
            padre.repaint();
            hijo.setVisible(true);
        }        
    } 
}
