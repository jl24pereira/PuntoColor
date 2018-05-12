
package design.lista;

/* @author JL Desk */
public class panelListaLogeo extends javax.swing.JPanel {

    public panelListaLogeo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblIcon = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        lblIcon.setMaximumSize(new java.awt.Dimension(48, 48));
        lblIcon.setMinimumSize(new java.awt.Dimension(48, 48));
        lblIcon.setPreferredSize(new java.awt.Dimension(48, 48));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblIcon, gridBagConstraints);

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(73, 189, 240));
        lblNombre.setText("NombreEmpleado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 5);
        add(lblNombre, gridBagConstraints);

        lblCargo.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblCargo.setText("Cargo del Empleado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 10, 10);
        add(lblCargo, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lblCargo;
    public static javax.swing.JLabel lblIcon;
    public javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
