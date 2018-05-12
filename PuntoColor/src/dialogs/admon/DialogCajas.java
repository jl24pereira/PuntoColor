
package dialogs.admon;

import clases.Mensajes;
import static db.clases.Tables.CAJA;
import design.button.ButtonUI;
import design.textfield.TextFieldUI;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static org.jooq.impl.DSL.count;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.colorUIover;
import static puntocolor.Principal.colorUIpressed;
import static puntocolor.Principal.database;

/* @author Jose Luis */
public class DialogCajas extends javax.swing.JDialog {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    boolean nuevo = true;
    
    String IPcaja;
    
    private String codigo;

    public DialogCajas(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);  
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
    }
    
    public DialogCajas(java.awt.Frame parent, boolean modal, String titulo, String IPCaja){
        super(parent, modal);
        this.nuevo = false;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        this.IPcaja = IPCaja;
        cargarForm(IPCaja);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblTitulo = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCancelar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIPcaja = new javax.swing.JTextField();
        btnCaja = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(450, 250));
        setPreferredSize(new java.awt.Dimension(450, 250));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTitulo.setBackground(colorBG);
        lblTitulo.setLayout(new java.awt.GridBagLayout());

        toolBarTabla1.setBackground(colorUI);
        toolBarTabla1.setBorder(null);
        toolBarTabla1.setFloatable(false);
        toolBarTabla1.setRollover(true);
        toolBarTabla1.setMaximumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setMinimumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setPreferredSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.add(jSeparator2);

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardar.setForeground(colorTexto);
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnGuardar);
        btnGuardar.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));
        toolBarTabla1.add(jSeparator1);

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setForeground(colorTexto);
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnCancelar);
        btnCancelar.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        lblTitulo.add(toolBarTabla1, gridBagConstraints);

        jPanel5.setMinimumSize(new java.awt.Dimension(400, 201));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(286, 200));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("(*) Detalle de Caja:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(jLabel3, gridBagConstraints);

        txtCaja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCaja.setMinimumSize(new java.awt.Dimension(200, 30));
        txtCaja.setPreferredSize(new java.awt.Dimension(200, 30));
        txtCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCajaKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(txtCaja, gridBagConstraints);
        txtCaja.setUI(new TextFieldUI(colorUI,colorBG));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("(*) IP de Caja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(jLabel4, gridBagConstraints);

        txtIPcaja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIPcaja.setMinimumSize(new java.awt.Dimension(200, 30));
        txtIPcaja.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(txtIPcaja, gridBagConstraints);
        txtIPcaja.setUI(new TextFieldUI(colorUI,colorBG));

        btnCaja.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCaja.setForeground(colorBG);
        btnCaja.setText("Ver mi IP");
        btnCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCaja.setMaximumSize(new java.awt.Dimension(100, 30));
        btnCaja.setMinimumSize(new java.awt.Dimension(100, 30));
        btnCaja.setPreferredSize(new java.awt.Dimension(100, 30));
        btnCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCajaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(btnCaja, gridBagConstraints);
        btnCaja.setUI(new ButtonUI(
            colorUI,
            colorUIover,
            colorUIpressed
        ));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/128/monitor.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel5.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        lblTitulo.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(lblTitulo, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(isComplete()){
            if(nuevo){
                if(isCaja(txtIPcaja.getText())){
                    new Mensajes().mensajeAlert("Esta IP esta registrada como caja");
                }else{
                    nuevaCaja();   
                    setGuardado(true);
                    dispose();
                }
            }else{
                if(IPcaja.equals(txtIPcaja.getText())){
                    editarCaja();
                    setGuardado(true);
                    dispose();
                }else{
                    if(isCaja(txtIPcaja.getText())){
                        new Mensajes().mensajeAlert("Esta IP esta registrada como caja");
                    }else{   
                        editarCaja();
                        setGuardado(true);
                        dispose();
                    }
                }                
            }            
        }else{
            new Mensajes().mensajeAlert("Verificar los campos requeridos");
        }        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajaActionPerformed
        try {
            if(isCaja(InetAddress.getLocalHost().getHostAddress())){
                new Mensajes().mensajeAlert("Esta IP esta registrada como caja");
            }else{
                txtIPcaja.setText(InetAddress.getLocalHost().getHostAddress());
            }            
        } catch (UnknownHostException ex) {
            Logger.getLogger(DialogCajas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCajaActionPerformed

    private void txtCajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCajaKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtIPcaja.requestFocus();
        }
    }//GEN-LAST:event_txtCajaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaja;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPanel lblTitulo;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTextField txtCaja;
    private javax.swing.JTextField txtIPcaja;
    // End of variables declaration//GEN-END:variables
    
    private boolean isCaja(String ip){
        int contador = 0;
        try{
            contador = create.select(count())
                    .from(CAJA)
                    .where(CAJA.IPCAJA.equal(ip))
                    .fetchOne(count());
        }catch (Exception e){
            
        }
        return contador != 0;
    }
    
    private void cargarForm(String ipcaja){
        Record r = create.select()
                .from(CAJA)
                .where(CAJA.IPCAJA.equal(ipcaja))
                .fetchOne();
        txtCaja.setText(r.getValue(CAJA.DETALLE));
        txtIPcaja.setText(r.getValue(CAJA.IPCAJA));
    }
    
    private boolean isComplete(){
        if(txtCaja.getText() == null || txtCaja.getText().equals("")){
            return false;
        }else return !(txtIPcaja.getText() == null || txtIPcaja.getText().equals(""));
    }

    /**
     * @return the guardado
     */
    public boolean isGuardado() {
        return guardado;
    }

    /**
     * @param guardado the guardado to set
     */
    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    private void nuevaCaja() {
        create.insertInto(CAJA)
                .set(CAJA.DETALLE,txtCaja.getText())
                .set(CAJA.IPCAJA, txtIPcaja.getText())
                .execute();
    }

    private void editarCaja() {
        create.update(CAJA)
                .set(CAJA.DETALLE,txtCaja.getText())
                .set(CAJA.IPCAJA,txtIPcaja.getText())
                .where(CAJA.IPCAJA.equal(IPcaja))
                .execute();
    }
    
}
