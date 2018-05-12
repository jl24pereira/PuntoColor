
package dialogs.admon;

import clases.Mensajes;
import static db.clases.Tables.EMPRESA;
import static db.clases.Tables.GASTOS;
import static db.clases.Tables.GASTOS_EMPRESA;
import static db.clases.Tables.V_COSTOS_EMPRESA;
import design.button.ButtonUI;
import design.spinner.SpinnerUI;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;

/* @author Jose Luis */
public class DialogCostos extends javax.swing.JDialog {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    boolean nuevo = true;
    
    int idCosto;
    
    String nit_empresa;

    public DialogCostos(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);  
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        nit_empresa = create.select()
                .from(EMPRESA)
                .fetchOne()
                .getValue(EMPRESA.NIT);
    }
    
    public DialogCostos(java.awt.Frame parent, boolean modal, String titulo, int idCosto){
        super(parent, modal);
        this.nuevo = false;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        this.idCosto = idCosto;
        cargarForm(idCosto);
        nit_empresa = create.select()
                .from(EMPRESA)
                .fetchOne()
                .getValue(EMPRESA.NIT);
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
        txtRubro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        spCosto = new javax.swing.JSpinner();
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
        jLabel3.setText("(*) Rubro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(jLabel3, gridBagConstraints);

        txtRubro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtRubro.setMinimumSize(new java.awt.Dimension(200, 30));
        txtRubro.setPreferredSize(new java.awt.Dimension(200, 30));
        txtRubro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRubroKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(txtRubro, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Costo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(jLabel4, gridBagConstraints);

        spCosto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        spCosto.setModel(new javax.swing.SpinnerNumberModel(5.0d, 5.0d, 999.99d, 5.0d));
        spCosto.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        spCosto.setMinimumSize(new java.awt.Dimension(100, 50));
        spCosto.setPreferredSize(new java.awt.Dimension(100, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(spCosto, gridBagConstraints);
        spCosto.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/128/coin-us-dollar.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
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
                guardarNuevo();
            }else{
                editarCosto();
            }
            setGuardado(true);
            dispose();
        }else{
            new Mensajes().mensajeError("Verificar los campos requeridos");
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtRubroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRubroKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            spCosto.requestFocus();
        }
    }//GEN-LAST:event_txtRubroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPanel lblTitulo;
    private javax.swing.JSpinner spCosto;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTextField txtRubro;
    // End of variables declaration//GEN-END:variables
    
    private void cargarForm(int idCosto){
        Record r = create.select()
                .from(V_COSTOS_EMPRESA)
                .where(V_COSTOS_EMPRESA.IDGASTO.equal(idCosto))
                .fetchOne();
        txtRubro.setText(r.getValue(V_COSTOS_EMPRESA.DETALLE));
        BigDecimal costeo = r.getValue(V_COSTOS_EMPRESA.GASTO);
        double costo = costeo.doubleValue();
        spCosto.setValue(costo);
    }
    
    private boolean isComplete(){
        if(txtRubro.getText()==null || txtRubro.getText().equals("")){
            return false;
        }else{
            return true;
        }
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

    private void guardarNuevo() {
        double costeo = (double) spCosto.getValue();
        BigDecimal costo = BigDecimal.valueOf(costeo);
        idCosto = create.insertInto(GASTOS)
                .set(GASTOS.DETALLE,txtRubro.getText())
                .returning(GASTOS.IDGASTO)
                .fetchOne()
                .getValue(GASTOS.IDGASTO);
        create.insertInto(GASTOS_EMPRESA)
                .set(GASTOS_EMPRESA.NIT,nit_empresa)
                .set(GASTOS_EMPRESA.IDGASTO,idCosto)
                .set(GASTOS_EMPRESA.GASTO,costo)
                .execute();
    }

    private void editarCosto() {
        double costeo = (double) spCosto.getValue();
        BigDecimal costo = BigDecimal.valueOf(costeo);
        create.update(GASTOS)
                .set(GASTOS.DETALLE,txtRubro.getText())
                .where(GASTOS.IDGASTO.equal(idCosto))
                .execute();
        create.update(GASTOS_EMPRESA)
                .set(GASTOS_EMPRESA.GASTO,costo)
                .where(GASTOS_EMPRESA.IDGASTO.equal(idCosto))
                .execute();
    }
    
}
