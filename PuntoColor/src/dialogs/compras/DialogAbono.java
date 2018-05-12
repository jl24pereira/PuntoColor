
package dialogs.compras;

import clases.Mensajes;
import static db.clases.Tables.COMPRAS;
import static db.clases.Tables.PAGOS_COMPRAS;
import design.button.ButtonUI;
import design.spinner.SpinnerUI;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.SpinnerNumberModel;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static org.jooq.impl.DSL.sum;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;

/* @author Jose Luis */
public class DialogAbono extends javax.swing.JDialog {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    boolean nuevo = true;
    
    boolean pagado = false;
    
    int idCompra;
    
    private String codigo;

    public DialogAbono(java.awt.Frame parent, boolean modal, String titulo, int idCompra) {
        super(parent, modal);  
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        this.idCompra = idCompra;
        cargarForm();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        spAbono = new javax.swing.JSpinner();
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

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Fecha de Compra:");
        jLabel4.setMaximumSize(new java.awt.Dimension(135, 30));
        jLabel4.setMinimumSize(new java.awt.Dimension(135, 30));
        jLabel4.setPreferredSize(new java.awt.Dimension(135, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(jLabel4, gridBagConstraints);

        txtFecha.setDate(new Date());
        txtFecha.setDateFormatString("dd-MM-yyyy");
        txtFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFecha.setMaximumSize(new java.awt.Dimension(200, 30));
        txtFecha.setMinimumSize(new java.awt.Dimension(200, 30));
        txtFecha.setName("[150, 50]"); // NOI18N
        txtFecha.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel1.add(txtFecha, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Pago($):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(jLabel5, gridBagConstraints);

        spAbono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spAbono.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 5.0d));
        spAbono.setMaximumSize(new java.awt.Dimension(200, 30));
        spAbono.setMinimumSize(new java.awt.Dimension(200, 30));
        spAbono.setName("[150, 50]"); // NOI18N
        spAbono.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel1.add(spAbono, gridBagConstraints);
        spAbono.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/128/Earning-statement.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel1.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        lblTitulo.add(jPanel1, gridBagConstraints);

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
        if(nuevo){
            nuevoAbono();
        }else{
        }        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPanel lblTitulo;
    private javax.swing.JSpinner spAbono;
    private javax.swing.JToolBar toolBarTabla1;
    private com.toedter.calendar.JDateChooser txtFecha;
    // End of variables declaration//GEN-END:variables
    
    public BigDecimal consultarSumaPagos(){
        BigDecimal suma = new BigDecimal(0);
        suma = create.select(sum(PAGOS_COMPRAS.PAGO))
                .from(PAGOS_COMPRAS)
                .where(PAGOS_COMPRAS.IDCOMPRA.equal(idCompra))
                .fetchOne().getValue(sum(PAGOS_COMPRAS.PAGO));
        if(suma == null){
            return new BigDecimal(0.00);
        }else{
            return suma;
        }        
    }
    
    public double consultarFaltante(){
        BigDecimal total = new BigDecimal(0);
        total = create.select(COMPRAS.TOTAL)
                .from(COMPRAS)
                .where(COMPRAS.IDCOMPRA.equal(idCompra))
                .fetchOne().getValue(COMPRAS.TOTAL);
        double faltante = total.doubleValue() - consultarSumaPagos().doubleValue();
        return faltante;
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

    private void nuevoAbono() {
        Date date = txtFecha.getDate();
        java.sql.Date fecha = new java.sql.Date (date.getTime());
        double abono = (double) spAbono.getValue();
        if(pagado){
            new Mensajes().mensajeAlert("Ya esta cancelada la factura!");
        }else{
            create.insertInto(PAGOS_COMPRAS)
                    .set(PAGOS_COMPRAS.FECHA,fecha)
                    .set(PAGOS_COMPRAS.PAGO, new BigDecimal(abono))
                    .set(PAGOS_COMPRAS.IDCOMPRA,idCompra)
                    .execute();
            setGuardado(true);
            dispose();
        }        
    }

    private void editarAbono() {
        /*create.update(CAJA)
                .set(CAJA.DETALLE,txtCaja.getText())
                .set(CAJA.IPCAJA,txtIPcaja.getText())
                .where(CAJA.IPCAJA.equal(IPcaja))
                .execute();*/
    }

    private void cargarForm() {
        double faltante = consultarFaltante();
        if(faltante > 0){
            spAbono.setModel(new SpinnerNumberModel(faltante, 0, faltante, 5));
            spAbono.setValue(faltante);
        }else{
            new Mensajes().mensajeAlert("Ya esta cancelada la factura!");
            spAbono.setModel(new SpinnerNumberModel(faltante, 0, faltante, 5));
            pagado = true;
            this.dispose();
        }
    }
    
}
