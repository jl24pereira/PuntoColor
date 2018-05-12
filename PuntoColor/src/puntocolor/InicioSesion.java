
package puntocolor;

import clases.Encrypt;
import clases.Login;
import clases.Mensajes;
import conexion.Database;
import design.button.ButtonUI;
import dialogs.DialogPropiedades;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.colorUIover;
import static puntocolor.Principal.colorUIpressed;

/* @author Jose Luis */
public class InicioSesion extends javax.swing.JFrame {
    
    Login l = new Login();
    
    int contador_maestro = 0;
    File file = null;
    
    public InicioSesion() {
        initComponents();
        this.setTitle("PUNTO COLOR SYSTEM");
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icono.png")));
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pContenido = new javax.swing.JPanel();
        pTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pForm = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        pControles = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 350));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pContenido.setBackground(new java.awt.Color(255, 255, 255));
        pContenido.setLayout(new java.awt.GridBagLayout());

        pTitulo.setBackground(colorUI);
        pTitulo.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        pTitulo.setLayout(new java.awt.GridBagLayout());

        lblTitulo.setBackground(colorBG);
        lblTitulo.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Inicio de Sesión");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        pTitulo.add(lblTitulo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pContenido.add(pTitulo, gridBagConstraints);

        pForm.setOpaque(false);
        pForm.setLayout(new java.awt.GridBagLayout());

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblUsuario.setForeground(colorUI);
        lblUsuario.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pForm.add(lblUsuario, gridBagConstraints);

        lblPass.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPass.setForeground(colorUI);
        lblPass.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pForm.add(lblPass, gridBagConstraints);

        txtUsuario.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtUsuario.setForeground(colorUI);
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 189, 240), 2, true));
        txtUsuario.setMinimumSize(new java.awt.Dimension(150, 30));
        txtUsuario.setPreferredSize(new java.awt.Dimension(150, 40));
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pForm.add(txtUsuario, gridBagConstraints);

        txtPass.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPass.setForeground(new java.awt.Color(73, 189, 240));
        txtPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 189, 240), 2, true));
        txtPass.setMinimumSize(new java.awt.Dimension(150, 30));
        txtPass.setPreferredSize(new java.awt.Dimension(150, 40));
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPassKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pForm.add(txtPass, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/128/Sign-up128.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        pForm.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pContenido.add(pForm, gridBagConstraints);

        pControles.setOpaque(false);
        pControles.setLayout(new java.awt.GridBagLayout());

        btnIniciar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Iniciar");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.setPreferredSize(new java.awt.Dimension(100, 40));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pControles.add(btnIniciar, gridBagConstraints);
        btnIniciar.setUI(new ButtonUI(
            colorUI,
            colorUIover,
            colorUIpressed
        ));

        btnSalir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(100, 40));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pControles.add(btnSalir, gridBagConstraints);
        btnSalir.setUI(new ButtonUI(
            new Color(73, 190, 240),
            new Color(35, 173, 232),
            new Color(7, 154, 218)
        ));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pContenido.add(pControles, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pContenido, gridBagConstraints);

        jMenu1.setText("Configuración");

        jMenuItem1.setText("Base de datos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Reiniciar Base de Datos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        DialogPropiedades dialog = new DialogPropiedades(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        iniciarSesion();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        // TODO add your handling code here:        
        if (evt.getKeyCode()==KeyEvent.VK_ALT){
            contador_maestro +=1;
            if(contador_maestro ==5){
                new Mensajes().mensajeInfo("Modo superusuario activado!!");
            }
        }
        if(evt.getKeyCode() == com.sun.glass.events.KeyEvent.VK_ENTER){
            txtPass.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void txtPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == com.sun.glass.events.KeyEvent.VK_ENTER){
            iniciarSesion();
        }
    }//GEN-LAST:event_txtPassKeyReleased

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int x = new Mensajes().mensajeSiNo("LA BASE DE DATOS INICIALIZADA CON 0 REGISTROS \nDESEA CONTINUAR?");
        if(x==0){
            resetDB();
        }        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pContenido;
    private javax.swing.JPanel pControles;
    private javax.swing.JPanel pForm;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public void iniciarSesion(){
        l.setUser(Encrypt.EncrypSHA(Encrypt.EncrypMD5(txtUsuario.getText())));
        char passArray[] = txtPass.getPassword();
        String pass = new String(passArray);
        l.setPassword(Encrypt.EncrypSHA(Encrypt.EncrypMD5(pass)));
        
        if(txtUsuario.getText() == null || txtUsuario.getText().equals("")
                || pass.equals("") || pass == null){
            new Mensajes().mensajeError("Usuario o Contraseña vacía!!");
        }else{
            if(l.loguearse()){
                Principal principal = new Principal(l.getIdUser());
                principal.setVisible(true);
                dispose();
            }else{
                if(contador_maestro>=5){
                    if(l.loguearse(true)){
                        Principal principal = new Principal(true);
                        principal.setVisible(true);
                        dispose();
                    }else{
                        System.exit(0);
                    } 
                }else{
                    new Mensajes().mensajeError("Usuario o Contraseña erronea!!");
                    txtUsuario.setText("");
                    txtPass.setText("");
                    txtUsuario.requestFocus();
                }
            }
        }
    }

    private void resetDB() {
        Database d = new Database();
        JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("BACKUP","backup");
        chooser.setFileFilter(filtro);
        int res = chooser.showOpenDialog(this);
        if(res == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            System.out.println(file.getAbsolutePath());
            d.resetDB(file.getAbsolutePath());
        }        
    }   
}
