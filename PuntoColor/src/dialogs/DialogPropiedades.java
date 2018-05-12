
package dialogs;

import clases.Mensajes;
import clases.Propiedades;
import conexion.Database;
import design.button.ButtonUI;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author Jose Luis */
public class DialogPropiedades extends javax.swing.JDialog {
    
    Propiedades p = new Propiedades();

    public DialogPropiedades(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btnGuardar.setUI(new ButtonUI(
                new Color(73, 190, 240), 
                new Color(35, 173, 232), 
                new Color(7, 154, 218)
        ));
        this.setLocationRelativeTo(null);
        cargarPropiedades();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pContenido = new javax.swing.JPanel();
        pTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pForm = new javax.swing.JPanel();
        lblServidor = new javax.swing.JLabel();
        txtServidor = new javax.swing.JTextField();
        lblPuerto = new javax.swing.JLabel();
        txtPuerto = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        lblDatabase = new javax.swing.JLabel();
        txtDatabase = new javax.swing.JTextField();
        pControles = new javax.swing.JPanel();
        btnTest = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 500));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pContenido.setBackground(new java.awt.Color(255, 255, 255));
        pContenido.setLayout(new java.awt.GridBagLayout());

        pTitulo.setOpaque(false);
        pTitulo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(73, 189, 240));
        jLabel1.setText("Propiedades");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/connection.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        pTitulo.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pContenido.add(pTitulo, gridBagConstraints);

        pForm.setOpaque(false);
        pForm.setLayout(new java.awt.GridBagLayout());

        lblServidor.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblServidor.setForeground(new java.awt.Color(73, 189, 240));
        lblServidor.setText("Servidor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 75, 5, 0);
        pForm.add(lblServidor, gridBagConstraints);

        txtServidor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtServidor.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 189, 240), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));
        txtServidor.setMinimumSize(new java.awt.Dimension(300, 40));
        txtServidor.setPreferredSize(new java.awt.Dimension(300, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 75, 10, 75);
        pForm.add(txtServidor, gridBagConstraints);

        lblPuerto.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblPuerto.setForeground(new java.awt.Color(73, 189, 240));
        lblPuerto.setText("Puerto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 75, 5, 0);
        pForm.add(lblPuerto, gridBagConstraints);

        txtPuerto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPuerto.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 189, 240), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));
        txtPuerto.setMinimumSize(new java.awt.Dimension(300, 40));
        txtPuerto.setPreferredSize(new java.awt.Dimension(300, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 75, 10, 75);
        pForm.add(txtPuerto, gridBagConstraints);

        lblUsuario.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(73, 189, 240));
        lblUsuario.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 75, 5, 0);
        pForm.add(lblUsuario, gridBagConstraints);

        txtUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 189, 240), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));
        txtUsuario.setMinimumSize(new java.awt.Dimension(300, 40));
        txtUsuario.setPreferredSize(new java.awt.Dimension(300, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 75, 10, 75);
        pForm.add(txtUsuario, gridBagConstraints);

        lblPass.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblPass.setForeground(new java.awt.Color(73, 189, 240));
        lblPass.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 75, 5, 0);
        pForm.add(lblPass, gridBagConstraints);

        txtPass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPass.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 189, 240), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));
        txtPass.setMinimumSize(new java.awt.Dimension(300, 40));
        txtPass.setPreferredSize(new java.awt.Dimension(300, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 75, 10, 75);
        pForm.add(txtPass, gridBagConstraints);

        lblDatabase.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblDatabase.setForeground(new java.awt.Color(73, 189, 240));
        lblDatabase.setText("Base de Datos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 75, 5, 0);
        pForm.add(lblDatabase, gridBagConstraints);

        txtDatabase.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDatabase.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 189, 240), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));
        txtDatabase.setMinimumSize(new java.awt.Dimension(300, 40));
        txtDatabase.setPreferredSize(new java.awt.Dimension(300, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 75, 10, 75);
        pForm.add(txtDatabase, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pContenido.add(pForm, gridBagConstraints);

        pControles.setOpaque(false);
        pControles.setLayout(new java.awt.GridBagLayout());

        btnTest.setBackground(new java.awt.Color(73, 189, 240));
        btnTest.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnTest.setForeground(new java.awt.Color(255, 255, 255));
        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Entypo_27f3(2)_48.png"))); // NOI18N
        btnTest.setText("<html><body>Probar<br>Conexion</body></html>");
        btnTest.setActionCommand("");
        btnTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTest.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTest.setMaximumSize(new java.awt.Dimension(150, 50));
        btnTest.setMinimumSize(new java.awt.Dimension(150, 50));
        btnTest.setPreferredSize(new java.awt.Dimension(150, 50));
        btnTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTestMouseExited(evt);
            }
        });
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pControles.add(btnTest, gridBagConstraints);
        btnTest.getAccessibleContext().setAccessibleName("");

        btnGuardar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Entypo_2713(1)_48.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setEnabled(false);
        btnGuardar.setMaximumSize(new java.awt.Dimension(150, 50));
        btnGuardar.setMinimumSize(new java.awt.Dimension(150, 50));
        btnGuardar.setPreferredSize(new java.awt.Dimension(150, 50));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pControles.add(btnGuardar, gridBagConstraints);

        btnCancelar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Entypo_2716(0)_48.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelar.setIconTextGap(1);
        btnCancelar.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancelar.setMaximumSize(new java.awt.Dimension(150, 50));
        btnCancelar.setMinimumSize(new java.awt.Dimension(150, 50));
        btnCancelar.setPreferredSize(new java.awt.Dimension(150, 50));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pControles.add(btnCancelar, gridBagConstraints);
        btnCancelar.setUI(new ButtonUI(
            new Color(73, 190, 240),
            new Color(35, 173, 232),
            new Color(7, 154, 218)
        ));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pContenido.add(pControles, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pContenido, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        p.setDatabase(txtDatabase.getText());
        p.setPort(txtPuerto.getText());
        p.setServer(txtServidor.getText());
        p.setUser(txtUsuario.getText());
        char passArray[] = txtPass.getPassword();
        String pass = new String(passArray);
        p.setPass(pass);
        try {
            p.escribirPropiedades();
            new Mensajes().mensajeInfo("Configuración Almacenada!");
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(DialogPropiedades.class.getName()).log(Level.SEVERE, null, ex);
            new Mensajes().mensajeError("Error, imposible acceder a archivo de configuración");
        }
        btnTest.setEnabled(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        // TODO add your handling code here:
        char passArray[] = txtPass.getPassword();
        String pass = new String(passArray);
        Database db;
        db = new Database(txtUsuario.getText(),
                pass,
                txtServidor.getText(),
                txtPuerto.getText(),
                txtDatabase.getText());
        db.conectar();
        if(db.getConexion()!=null){
            new Mensajes().mensajeInfo("Conexión exitosa");
            db.desconectar();
            btnGuardar.setEnabled(true);
        }     
    }//GEN-LAST:event_btnTestActionPerformed

    private void btnTestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTestMouseExited
        // TODO add your handling code here:
        btnTest.setBackground(new Color(73, 190, 240));
    }//GEN-LAST:event_btnTestMouseExited

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblDatabase;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPuerto;
    private javax.swing.JLabel lblServidor;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pContenido;
    private javax.swing.JPanel pControles;
    private javax.swing.JPanel pForm;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JTextField txtDatabase;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPuerto;
    private javax.swing.JTextField txtServidor;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void cargarPropiedades(){        
        p.leerPropiedades();
        txtServidor.setText(p.getServer());
        txtUsuario.setText(p.getUser());
        txtPass.setText(p.getPass());
        txtDatabase.setText(p.getDatabase());
        txtPuerto.setText(p.getPort());
    }
}
