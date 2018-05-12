
package panels;

import com.mrlonee.swing.animation.AnimatedPanel;
import static db.clases.Tables.CONEXIONES;
import design.lista.LogeoListRenderer;
import design.lista.Logeos;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;

/*@author JL Desk */
public class PanelInicio extends AnimatedPanel implements Runnable{  
    
    DefaultListModel<Logeos> modelo = new DefaultListModel<>();
    
    boolean corriendo = false;
    boolean iniciar = true;
    Thread hilo;
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);

    public PanelInicio() {
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();   
        cargarListaLogeos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lLogeos = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 0, 0));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                formAncestorRemoved(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(colorBG);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 60)); // NOI18N
        jLabel5.setForeground(colorUI);
        jLabel5.setText("Punto Color System");
        jLabel5.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(colorUI, 4, true), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        jPanel2.add(jLabel5, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jPanel2, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(new javax.swing.border.LineBorder(colorUI, 2, true));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 14));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 461));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Usuarios Conectados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jLabel4, gridBagConstraints);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setMinimumSize(new java.awt.Dimension(10, 10));
        jScrollPane3.setOpaque(false);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(10, 10));

        lLogeos.setBackground(colorBG);
        lLogeos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lLogeos.setEnabled(false);
        lLogeos.setFocusable(false);
        lLogeos.setSelectionBackground(new java.awt.Color(73, 189, 240));
        lLogeos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lLogeosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lLogeos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jScrollPane3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(jPanel1, gridBagConstraints);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-adelmype.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("<html><body align=\"center\">Desarrollado con la<br><br>Cooperación de:</body></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jLabel3, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-pereira.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void lLogeosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lLogeosValueChanged
        /*if(lLogeos.getSelectedIndex()>=0){
           JOptionPane.showMessageDialog(null,lLogeos.getSelectedValue().getNombre());
        }*/
    }//GEN-LAST:event_lLogeosValueChanged

    private void formAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorRemoved
        // TODO add your handling code here:
        finalizarBusqueda();
    }//GEN-LAST:event_formAncestorRemoved

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
        iniciarBusqueda();
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Logeos> lLogeos;
    // End of variables declaration//GEN-END:variables

    private void cargarListaLogeos(){
        modelo.clear();
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(CONEXIONES);
        Result<Record> result = query.fetch();
        for (Record r : result) {
            ImageIcon imagen = null;
            switch(r.getValue(CONEXIONES.PUESTO)){
                case "Administrador":
                    imagen = new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/48/User-blue48.png"));
                    break;
                case "Ventas":
                    imagen = new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/48/User-red48.png"));
                    break;
                case "Diseño":
                    imagen = new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/48/User-yellow48.png"));
                    break;
                case "Producción":
                    imagen = new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/48/User-green48.png"));
                    break;
            }
            modelo.addElement(new Logeos(
                    r.getValue(CONEXIONES.IDEMPLEADO),
                    r.getValue(CONEXIONES.EMPLEADO),
                    r.getValue(CONEXIONES.PUESTO),
                    r.getValue(CONEXIONES.IP),
                    imagen
            ));
        }
        lLogeos.setCellRenderer(new LogeoListRenderer(
                Color.WHITE,
                new Color(73, 190, 240)
        ));
        lLogeos.setModel(modelo);
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Busqueda Logeos");
        System.out.println("Inicia Hilo: "+Thread.currentThread().getName());
        while(corriendo){
            try {
                Thread.sleep(1000*15);
                    if(!corriendo){
                        break;
                    }
                    System.out.println("Hilo: " + Thread.currentThread().getName() + " Buscando...");
                    cargarListaLogeos(); 
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("finaliza hilo");
    }
    
    private void iniciarBusqueda(){
        if(!corriendo){
            corriendo = true;
            iniciar = true;
            arrancarBusqueda();
        }
    }
    
    private void finalizarBusqueda(){
        corriendo = false;
        iniciar=false;
        Thread.currentThread().interrupt();
    }

    private void arrancarBusqueda() {
       if(iniciar){
           new Thread(this).start();
       }
    }

}
