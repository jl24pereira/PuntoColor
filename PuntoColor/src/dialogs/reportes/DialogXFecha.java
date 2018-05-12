
package dialogs.reportes;

import clases.Mensajes;
import design.button.ButtonUI;
import java.util.Calendar;
import org.jooq.DSLContext;
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
public class DialogXFecha extends javax.swing.JDialog {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    boolean nuevo = true;
    
    int tRep;
    private String codigo;

    public DialogXFecha(java.awt.Frame parent, boolean modal, String titulo, int treporte) {
        super(parent, modal);  
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        this.tRep = treporte;
        pasarFechas();
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
        jLabel4 = new javax.swing.JLabel();
        txtFechaInicial = new com.toedter.calendar.JDateChooser();
        txtFechaFinal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(500, 250));
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
        btnGuardar.setText("Reporte");
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

        jLabel3.setText("Desde:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel5.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Hasta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel5.add(jLabel4, gridBagConstraints);

        txtFechaInicial.setDateFormatString("dd-MM-yyyy");
        txtFechaInicial.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtFechaInicial.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel5.add(txtFechaInicial, gridBagConstraints);

        txtFechaFinal.setDateFormatString("dd-MM-yyyy");
        txtFechaFinal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtFechaFinal.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel5.add(txtFechaFinal, gridBagConstraints);

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        java.util.Date dateInicio = txtFechaInicial.getDate();
        java.util.Date dateFinal = txtFechaFinal.getDate();
        java.sql.Date fechaInicio = new java.sql.Date (dateInicio.getTime());
        java.sql.Date fechaFinal = new java.sql.Date (dateFinal.getTime());
        this.dispose();
        switch(tRep){
            case 1:
                Calendar fecha1 = txtFechaInicial.getCalendar();
                fecha1.set(Calendar.HOUR_OF_DAY, 0);
                fecha1.set(Calendar.MINUTE, 0);
                fecha1.set(Calendar.SECOND, 0);
                java.sql.Timestamp timestampInicio = new java.sql.Timestamp(fecha1.getTime().getTime());
                Calendar fecha2 = txtFechaFinal.getCalendar();
                fecha2.set(Calendar.HOUR_OF_DAY, 23);
                fecha2.set(Calendar.MINUTE, 59);
                fecha2.set(Calendar.SECOND, 59);
                java.sql.Timestamp timestampFinal = new java.sql.Timestamp(fecha2.getTime().getTime());
                Reportes.Reportes.reporteCajasXRango(timestampInicio, timestampFinal);
                break;
            case 2:
                Reportes.Reportes.reporteComprasXRango(fechaInicio, fechaFinal);
                break;
            case 3:
                Reportes.Reportes.reporteCotizacionesXRango(fechaInicio, fechaFinal);
                break;
            case 4:
                Reportes.Reportes.reportePedidosXRango(fechaInicio, fechaFinal);
                break;
            case 5:
                Reportes.Reportes.reporteVentasXRango(fechaInicio, fechaFinal);
                break;
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPanel lblTitulo;
    private javax.swing.JToolBar toolBarTabla1;
    private com.toedter.calendar.JDateChooser txtFechaFinal;
    private com.toedter.calendar.JDateChooser txtFechaInicial;
    // End of variables declaration//GEN-END:variables
        
    private void pasarFechas() {
        Calendar fechaHoy = Calendar.getInstance();
        Calendar fechaInicio = Calendar.getInstance();
        Calendar fechaFinal = Calendar.getInstance();
        fechaInicio.set(Calendar.DAY_OF_MONTH, fechaHoy.getActualMinimum(Calendar.DAY_OF_MONTH));
        fechaFinal.set(Calendar.DAY_OF_MONTH, fechaHoy.getActualMaximum(Calendar.DAY_OF_MONTH));
        txtFechaInicial.setCalendar(fechaInicio);
        txtFechaFinal.setCalendar(fechaFinal);
    }

    private void verificarMenor() {
        if(txtFechaInicial.getCalendar().compareTo(txtFechaFinal.getCalendar())==1){
            new Mensajes().mensajeAlert("La fecha inicial no puede ser mayor que fecha final");
            Calendar fechaHoy = Calendar.getInstance();
            Calendar fechaInicio = Calendar.getInstance();
            fechaInicio.set(Calendar.DAY_OF_MONTH, fechaHoy.getActualMinimum(Calendar.DAY_OF_MONTH));
            txtFechaInicial.setCalendar(fechaInicio);
        }
    }

    private void verificarMayor() {
        if(txtFechaInicial.getCalendar().compareTo(txtFechaFinal.getCalendar())==1){
            new Mensajes().mensajeAlert("La fecha final no puede ser menor que fecha inicial");
            Calendar fechaHoy = Calendar.getInstance();
            Calendar fechaFinal = Calendar.getInstance();
            fechaFinal.set(Calendar.DAY_OF_MONTH, fechaHoy.getActualMaximum(Calendar.DAY_OF_MONTH));
            txtFechaFinal.setCalendar(fechaFinal);
        }
    }
}
