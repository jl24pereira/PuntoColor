package dialogs.ventas;

import clases.Mensajes;

import static db.clases.Tables.COTIZACION_PEDIDO;
import static db.clases.Tables.DETALLE_PEDIDO;
import static db.clases.Tables.EMPRESA;
import static db.clases.Tables.PAGOS_PEDIDO;
import static db.clases.Tables.PEDIDO;
import static db.clases.Tables.V_COTIZACION;
import static db.clases.Tables.V_DETALLE_COTIZACION;

import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.spinner.SpinnerUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.io.File;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;
import static puntocolor.Principal.mensajero;
import static puntocolor.Principal.ue;

/* @author Jose Luis */
public class DialogCotizacionAPedido extends javax.swing.JDialog {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    boolean nuevo = true;
    
    boolean pagado = false;
    
    int idCotizacion;
    int idCliente;
    int idPedido;
    
    private String codigo;
    
    DefaultTableModel dtmDetalle;
    
    public DialogCotizacionAPedido(java.awt.Frame parent, boolean modal, String titulo, int idCotizacion) {
        super(parent, modal);
        initComponents();
        dtmDetalle = (DefaultTableModel) tDetalle.getModel();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        this.idCotizacion = idCotizacion;
        dibujarTablaFacturas();
        iniciarTransaccion();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pBody = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCancelar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnCancelar1 = new javax.swing.JButton();
        pProveedor = new javax.swing.JPanel();
        lblProveedor = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        txtNumPedido = new javax.swing.JTextField();
        pDetalle = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDetalle = new javax.swing.JTable();
        pFoot = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sprAbono = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxMetodoPago = new javax.swing.JComboBox<>();
        sprRecibe = new javax.swing.JSpinner();
        txtCambio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(550, 600));
        setPreferredSize(new java.awt.Dimension(550, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pBody.setBackground(colorBG);
        pBody.setLayout(new java.awt.GridBagLayout());

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
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        toolBarTabla1.add(jSeparator3);

        btnCancelar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar1.setForeground(colorTexto);
        btnCancelar1.setText("Comentarios");
        btnCancelar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar1.setFocusable(false);
        btnCancelar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnCancelar1);
        btnCancelar1.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pBody.add(toolBarTabla1, gridBagConstraints);

        pProveedor.setOpaque(false);
        pProveedor.setLayout(new java.awt.GridBagLayout());

        lblProveedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblProveedor.setText("Pedido Numero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pProveedor.add(lblProveedor, gridBagConstraints);

        lblDocumento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDocumento.setText("Cliente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pProveedor.add(lblDocumento, gridBagConstraints);

        txtCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCliente.setText("fulano de tal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pProveedor.add(txtCliente, gridBagConstraints);

        txtNumPedido.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pProveedor.add(txtNumPedido, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pBody.add(pProveedor, gridBagConstraints);

        pDetalle.setOpaque(false);
        pDetalle.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Detalle de Pedido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pDetalle.add(jLabel2, gridBagConstraints);

        tDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "Codigo", "Detalle", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tDetalle.setRowHeight(30);
        jScrollPane1.setViewportView(tDetalle);
        if (tDetalle.getColumnModel().getColumnCount() > 0) {
            tDetalle.getColumnModel().getColumn(0).setMinWidth(0);
            tDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
            tDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
            tDetalle.getColumnModel().getColumn(1).setMinWidth(75);
            tDetalle.getColumnModel().getColumn(1).setPreferredWidth(75);
            tDetalle.getColumnModel().getColumn(1).setMaxWidth(75);
            tDetalle.getColumnModel().getColumn(3).setMinWidth(60);
            tDetalle.getColumnModel().getColumn(3).setPreferredWidth(60);
            tDetalle.getColumnModel().getColumn(3).setMaxWidth(60);
            tDetalle.getColumnModel().getColumn(4).setMinWidth(60);
            tDetalle.getColumnModel().getColumn(4).setPreferredWidth(60);
            tDetalle.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pDetalle.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pBody.add(pDetalle, gridBagConstraints);

        pFoot.setOpaque(false);
        pFoot.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Total:");
        jLabel3.setMaximumSize(new java.awt.Dimension(60, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(60, 30));
        jLabel3.setPreferredSize(new java.awt.Dimension(60, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFoot.add(jLabel3, gridBagConstraints);

        txtTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotal.setMaximumSize(new java.awt.Dimension(100, 30));
        txtTotal.setMinimumSize(new java.awt.Dimension(100, 30));
        txtTotal.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pFoot.add(txtTotal, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Abono:");
        jLabel4.setMaximumSize(new java.awt.Dimension(60, 30));
        jLabel4.setMinimumSize(new java.awt.Dimension(60, 30));
        jLabel4.setPreferredSize(new java.awt.Dimension(60, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFoot.add(jLabel4, gridBagConstraints);

        sprAbono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sprAbono.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        sprAbono.setMaximumSize(new java.awt.Dimension(100, 30));
        sprAbono.setMinimumSize(new java.awt.Dimension(100, 30));
        sprAbono.setPreferredSize(new java.awt.Dimension(100, 30));
        sprAbono.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sprAbonoStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pFoot.add(sprAbono, gridBagConstraints);
        sprAbono.setUI(new SpinnerUI(colorBG,colorUI));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Saldo:");
        jLabel5.setMaximumSize(new java.awt.Dimension(60, 30));
        jLabel5.setMinimumSize(new java.awt.Dimension(60, 30));
        jLabel5.setPreferredSize(new java.awt.Dimension(60, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFoot.add(jLabel5, gridBagConstraints);

        txtSaldo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSaldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtSaldo.setText("0.00");
        txtSaldo.setMaximumSize(new java.awt.Dimension(100, 30));
        txtSaldo.setMinimumSize(new java.awt.Dimension(100, 30));
        txtSaldo.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pFoot.add(txtSaldo, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Método de Pago:");
        jLabel7.setMaximumSize(new java.awt.Dimension(150, 30));
        jLabel7.setMinimumSize(new java.awt.Dimension(150, 30));
        jLabel7.setPreferredSize(new java.awt.Dimension(130, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFoot.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Recibe:");
        jLabel8.setMaximumSize(new java.awt.Dimension(150, 30));
        jLabel8.setMinimumSize(new java.awt.Dimension(150, 30));
        jLabel8.setPreferredSize(new java.awt.Dimension(130, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFoot.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Cambio:");
        jLabel9.setMaximumSize(new java.awt.Dimension(150, 30));
        jLabel9.setMinimumSize(new java.awt.Dimension(150, 30));
        jLabel9.setPreferredSize(new java.awt.Dimension(130, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFoot.add(jLabel9, gridBagConstraints);

        cbxMetodoPago.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "CHEQUE", "TARJETA DE CREDITO" }));
        cbxMetodoPago.setMaximumSize(new java.awt.Dimension(150, 30));
        cbxMetodoPago.setMinimumSize(new java.awt.Dimension(150, 30));
        cbxMetodoPago.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFoot.add(cbxMetodoPago, gridBagConstraints);
        cbxMetodoPago.setUI(new ComboUI(colorBG,colorUI));

        sprRecibe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sprRecibe.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        sprRecibe.setMaximumSize(new java.awt.Dimension(100, 30));
        sprRecibe.setMinimumSize(new java.awt.Dimension(100, 30));
        sprRecibe.setPreferredSize(new java.awt.Dimension(100, 30));
        sprRecibe.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sprRecibeStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFoot.add(sprRecibe, gridBagConstraints);
        sprRecibe.setUI(new SpinnerUI(colorBG,colorUI));

        txtCambio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCambio.setMaximumSize(new java.awt.Dimension(100, 30));
        txtCambio.setMinimumSize(new java.awt.Dimension(100, 30));
        txtCambio.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFoot.add(txtCambio, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pBody.add(pFoot, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pBody, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (isValidado()) {
            try {
                editarNumeroPedido();
                double abono = (double) sprAbono.getValue();
                guardarAbono(new BigDecimal(abono));
                guardarCotizacionPedido();
                database.getConexion().commit();
                Reportes.Reportes.pedido(this.idPedido);
                crearCarpeta();
                mensajero.enviarMensaje(ue.getNombre() + " Ha registrado nuevo pedido #" + txtNumPedido.getText(), DesktopNotify.SUCCESS, 2);
            } catch (SQLException ex) {
                try {
                    database.getConexion().rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(DialogCotizacionAPedido.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(DialogCotizacionAPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        } else {
            new Mensajes().mensajeAlert("Verificicar campos requeridos!");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void sprAbonoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sprAbonoStateChanged
        // TODO add your handling code here:
        calcularAbono();
        calcularCambio();
    }//GEN-LAST:event_sprAbonoStateChanged

    private void sprRecibeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sprRecibeStateChanged
        // TODO add your handling code here:
        calcularCambio();
    }//GEN-LAST:event_sprRecibeStateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            // TODO add your handling code here:
            database.getConexion().rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DialogCotizacionAPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        // TODO add your handling code here:
        DialogComentario dialog = new DialogComentario(new javax.swing.JFrame(), true, "Comentario", this.idPedido);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            System.out.println("CERRANDO TRANSACCION + ROLLBACK");
            database.getConexion().rollback();
            database.getConexion().setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(DialogPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxMetodoPago;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JPanel pBody;
    private javax.swing.JPanel pDetalle;
    private javax.swing.JPanel pFoot;
    private javax.swing.JPanel pProveedor;
    private javax.swing.JSpinner sprAbono;
    private javax.swing.JSpinner sprRecibe;
    private javax.swing.JTable tDetalle;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JLabel txtCambio;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JTextField txtNumPedido;
    private javax.swing.JLabel txtSaldo;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables

    private void cargarForm() {
        Record rCotizacion = create.select()
                .from(V_COTIZACION)
                .where(V_COTIZACION.IDCOTIZACION.equal(this.idCotizacion))
                .fetchOne();
        txtCliente.setText(rCotizacion.getValue(V_COTIZACION.NOMBRECLIENTE));
        this.idCliente = rCotizacion.getValue(V_COTIZACION.IDCLIENTE);
        txtTotal.setText(rCotizacion.getValue(V_COTIZACION.TOTAL).toString());
        sprAbono.setModel(new javax.swing.SpinnerNumberModel(0, 0, rCotizacion.getValue(V_COTIZACION.TOTAL).doubleValue(), 1.0d));
        guardarTransaccion();
        cargarTablaDetalle();
    }
    
    private void cargarTablaDetalle() {
        for (int i = 0; i < tDetalle.getRowCount(); i++) {
            dtmDetalle.removeRow(i);
            i -= 1;
        }
        
        Result<?> result = create.select().from(V_DETALLE_COTIZACION)
                .where(V_DETALLE_COTIZACION.IDCOTIZACION.equal(this.idCotizacion))
                .fetch();
        for (Record r : result) {
            Object[] row = {
                r.getValue(V_DETALLE_COTIZACION.IDPRODUCTO),
                r.getValue(V_DETALLE_COTIZACION.CODIGO),
                r.getValue(V_DETALLE_COTIZACION.NOMBRE),
                r.getValue(V_DETALLE_COTIZACION.CANTIDAD),
                r.getValue(V_DETALLE_COTIZACION.PRECIO)
            };
            dtmDetalle.addRow(row);
            create.insertInto(DETALLE_PEDIDO)
                    .set(DETALLE_PEDIDO.IDPEDIDO, this.idPedido)
                    .set(DETALLE_PEDIDO.IDPRODUCTO, r.getValue(V_DETALLE_COTIZACION.IDPRODUCTO))
                    .set(DETALLE_PEDIDO.CANTIDAD, r.getValue(V_DETALLE_COTIZACION.CANTIDAD))
                    .set(DETALLE_PEDIDO.PRECIO, r.getValue(V_DETALLE_COTIZACION.PRECIO))
                    .set(DETALLE_PEDIDO.IDTAMANIO, r.getValue(V_DETALLE_COTIZACION.IDTAMANIO))
                    .set(DETALLE_PEDIDO.ESPECIAL, r.getValue(V_DETALLE_COTIZACION.ESPECIAL))
                    .set(DETALLE_PEDIDO.ANCHO, r.getValue(V_DETALLE_COTIZACION.ANCHO))
                    .set(DETALLE_PEDIDO.LARGO, r.getValue(V_DETALLE_COTIZACION.LARGO))
                    .execute();
        }
    }
    
    private void dibujarTablaFacturas() {
        tDetalle.setGridColor(colorUI);
        
        JTableHeader jtableHeader = tDetalle.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tDetalle.setTableHeader(jtableHeader);
        
        tDetalle.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer("text center", new Color(113, 205, 245)));
        tDetalle.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center", new Color(113, 205, 245)));
        tDetalle.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));
        tDetalle.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("num", new Color(113, 205, 245)));
        tDetalle.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("precio", new Color(113, 205, 245)));
        tDetalle.repaint();
    }
    
    private void iniciarTransaccion() {
        try {
            database.getConexion().setAutoCommit(false);
            cargarForm();
        } catch (SQLException ex) {
            Logger.getLogger(DialogCotizacionAPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void calcularAbono() {
        double total = Double.parseDouble(txtTotal.getText());
        double abono = (double) sprAbono.getValue();
        double saldo = total - abono;
        txtSaldo.setText(String.format("%.2f", saldo));
        sprRecibe.setModel(new javax.swing.SpinnerNumberModel(abono, abono, null, 1.0d));
    }
    
    private void calcularCambio() {
        double recibe = (double) sprRecibe.getValue();
        double abono = (double) sprAbono.getValue();
        double cambio = recibe - abono;
        txtCambio.setText(String.format("%.2f", cambio));
    }
    
    private void guardarTransaccion() {
        java.util.Date date = new java.util.Date();
        java.sql.Date fecha = new java.sql.Date(date.getTime());
        this.idPedido = create.insertInto(PEDIDO)
                .set(PEDIDO.FECHA, fecha)
                .set(PEDIDO.IDCLIENTE, this.idCliente)
                .set(PEDIDO.IDEMPLEADO, ue.getIdempleado())
                .set(PEDIDO.TOTAL, new BigDecimal(txtTotal.getText()))
                .set(PEDIDO.ESTADO, "ESPERA")
                .set(PEDIDO.COMENTARIOS, "")
                .returning()
                .fetchOne().getValue(PEDIDO.IDPEDIDO);
    }
    
    private boolean isValidado() {
        return !(txtNumPedido.getText() == null || txtNumPedido.getText().equals(""));
    }
    
    private void editarNumeroPedido() {
        create.update(PEDIDO)
                .set(PEDIDO.NUMERO, txtNumPedido.getText())
                .where(PEDIDO.IDPEDIDO.equal(this.idPedido))
                .execute();
    }
    
    private void guardarAbono(BigDecimal abono) {
        java.util.Date date = new java.util.Date();
        java.sql.Date fecha = new java.sql.Date(date.getTime());
        create.insertInto(PAGOS_PEDIDO)
                .set(PAGOS_PEDIDO.FECHA, fecha)
                .set(PAGOS_PEDIDO.IDPEDIDO, this.idPedido)
                .set(PAGOS_PEDIDO.PAGO, abono)
                .execute();
    }
    
    private void crearCarpeta() {
        String path = create.select(EMPRESA.PATH)
                .from(EMPRESA)
                .fetchOne(EMPRESA.PATH, String.class);
        File folder = new File(path + "\\" + txtNumPedido + " - " + txtCliente.getText());
        folder.mkdir();
    }
    
    private void guardarCotizacionPedido() {
        create.insertInto(COTIZACION_PEDIDO)
                .set(COTIZACION_PEDIDO.IDCOTIZACION, this.idCotizacion)
                .set(COTIZACION_PEDIDO.IDPEDIDO, this.idPedido)
                .execute();
    }
    
}
