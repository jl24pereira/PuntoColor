
package dialogs.compras;

import clases.Fechero;
import static db.clases.Tables.COMPRAS;
import static db.clases.Tables.PAGOS_COMPRAS;
import static db.clases.Tables.V_COMPRAS;
import static db.clases.Tables.V_DETALLE_COMPRA;
import design.button.ButtonUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import java.awt.Color;
import java.math.BigDecimal;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record5;
import org.jooq.Result;
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
public class DialogDetalleFactura extends javax.swing.JDialog {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    boolean nuevo = true;
    
    boolean pagado = false;
    
    int idCompra;
    
    private String codigo;
    
    DefaultTableModel dtmDetalle;

    public DialogDetalleFactura(java.awt.Frame parent, boolean modal, String titulo, int idCompra) {
        super(parent, modal);  
        initComponents();
        dtmDetalle = (DefaultTableModel) tDetalle.getModel();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        this.idCompra = idCompra;
        dibujarTablaFacturas();
        cargarForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pBody = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnCancelar = new javax.swing.JButton();
        pProveedor = new javax.swing.JPanel();
        lblProveedor = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        lblCondicion = new javax.swing.JLabel();
        txtCondicion = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        txtDoc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pDetalle = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDetalle = new javax.swing.JTable();
        pFoot = new javax.swing.JPanel();
        lblTotalFactura = new javax.swing.JLabel();
        txtTotalFactura = new javax.swing.JLabel();
        lblTotalPagos = new javax.swing.JLabel();
        txtTotalPagos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblPendiente = new javax.swing.JLabel();
        txtPendiente = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(560, 700));
        setPreferredSize(new java.awt.Dimension(560, 700));
        setResizable(false);
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

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setForeground(colorTexto);
        btnCancelar.setText("Salir");
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
        pBody.add(toolBarTabla1, gridBagConstraints);

        pProveedor.setOpaque(false);
        pProveedor.setLayout(new java.awt.GridBagLayout());

        lblProveedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblProveedor.setText("Proveedor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pProveedor.add(lblProveedor, gridBagConstraints);

        txtProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProveedor.setText("nombre del proveedor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pProveedor.add(txtProveedor, gridBagConstraints);

        lblFecha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblFecha.setText("Fecha compra:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pProveedor.add(lblFecha, gridBagConstraints);

        txtFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFecha.setText("fecha de compra");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pProveedor.add(txtFecha, gridBagConstraints);

        lblCondicion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCondicion.setText("Condicion de pago:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pProveedor.add(lblCondicion, gridBagConstraints);

        txtCondicion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCondicion.setText("credito o contado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pProveedor.add(txtCondicion, gridBagConstraints);

        lblDocumento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDocumento.setText("Documento #:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pProveedor.add(lblDocumento, gridBagConstraints);

        txtDoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDoc.setText("000000000x");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pProveedor.add(txtDoc, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/128/play-an-order128.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pProveedor.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pBody.add(pProveedor, gridBagConstraints);

        pDetalle.setOpaque(false);
        pDetalle.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Detalle de Factura");
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
                "Codigo", "Detalle", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tDetalle.setRowHeight(30);
        jScrollPane1.setViewportView(tDetalle);
        if (tDetalle.getColumnModel().getColumnCount() > 0) {
            tDetalle.getColumnModel().getColumn(0).setMinWidth(80);
            tDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
            tDetalle.getColumnModel().getColumn(0).setMaxWidth(80);
            tDetalle.getColumnModel().getColumn(2).setMinWidth(70);
            tDetalle.getColumnModel().getColumn(2).setPreferredWidth(70);
            tDetalle.getColumnModel().getColumn(2).setMaxWidth(70);
            tDetalle.getColumnModel().getColumn(3).setMinWidth(70);
            tDetalle.getColumnModel().getColumn(3).setPreferredWidth(70);
            tDetalle.getColumnModel().getColumn(3).setMaxWidth(70);
            tDetalle.getColumnModel().getColumn(4).setMinWidth(70);
            tDetalle.getColumnModel().getColumn(4).setPreferredWidth(70);
            tDetalle.getColumnModel().getColumn(4).setMaxWidth(70);
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

        lblTotalFactura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotalFactura.setText("Total en Factura:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pFoot.add(lblTotalFactura, gridBagConstraints);

        txtTotalFactura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTotalFactura.setText("$.....");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pFoot.add(txtTotalFactura, gridBagConstraints);

        lblTotalPagos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotalPagos.setText("Total en Pagos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pFoot.add(lblTotalPagos, gridBagConstraints);

        txtTotalPagos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTotalPagos.setText("$......");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pFoot.add(txtTotalPagos, gridBagConstraints);

        jSeparator1.setMinimumSize(new java.awt.Dimension(200, 1));
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        pFoot.add(jSeparator1, gridBagConstraints);

        lblPendiente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPendiente.setText("Pendiente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pFoot.add(lblPendiente, gridBagConstraints);

        txtPendiente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPendiente.setText("$........");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pFoot.add(txtPendiente, gridBagConstraints);

        txtEstado.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtEstado.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(30, 10, 10, 10);
        pFoot.add(txtEstado, gridBagConstraints);

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JLabel lblCondicion;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblPendiente;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblTotalFactura;
    private javax.swing.JLabel lblTotalPagos;
    private javax.swing.JPanel pBody;
    private javax.swing.JPanel pDetalle;
    private javax.swing.JPanel pFoot;
    private javax.swing.JPanel pProveedor;
    private javax.swing.JTable tDetalle;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JLabel txtCondicion;
    private javax.swing.JLabel txtDoc;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtPendiente;
    private javax.swing.JLabel txtProveedor;
    private javax.swing.JLabel txtTotalFactura;
    private javax.swing.JLabel txtTotalPagos;
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
    
    private void cargarForm() {
        Record r = create.select()
                .from(V_COMPRAS)
                .where(V_COMPRAS.IDCOMPRA.equal(idCompra))
                .fetchOne();
        txtProveedor.setText(r.getValue(V_COMPRAS.NOMBRE));
        txtDoc.setText(r.getValue(V_COMPRAS.NUMERODOCUMENTO));
        txtFecha.setText(Fechero.baseToReal(r.getValue(V_COMPRAS.FECHA)));
        txtCondicion.setText(r.getValue(V_COMPRAS.TIPODOCUMENTO));
        txtTotalFactura.setText(r.getValue(V_COMPRAS.TOTAL).toString());
        txtTotalPagos.setText(r.getValue(V_COMPRAS.PAGOS).toString());
        txtPendiente.setText(r.getValue(V_COMPRAS.PENDIENTE).toString());
        if(r.getValue(V_COMPRAS.PAGADO)){
            txtEstado.setForeground(java.awt.Color.GREEN);
            txtEstado.setText("CANCELADA");
        }else{
            txtEstado.setForeground(java.awt.Color.RED);
            txtEstado.setText("PENDIENTE");
        }
        cargarTablaDetalle();
    }
    
    private void cargarTablaDetalle(){
        for(int i=0; i<tDetalle.getRowCount(); i++){
            dtmDetalle.removeRow(i);
            i-=1;
        }
        Result<Record5<String, String, Double, BigDecimal, BigDecimal>> result = create.select(
                V_DETALLE_COMPRA.CODIGO,
                V_DETALLE_COMPRA.NOMBRE,
                V_DETALLE_COMPRA.CANTIDAD,
                V_DETALLE_COMPRA.PRECIOCOMPRA,
                V_DETALLE_COMPRA.VENTAGRAVADA)
                .from(V_DETALLE_COMPRA)
                .where(V_DETALLE_COMPRA.IDCOMPRA.equal(idCompra))
                .fetch();
        for (Record r : result){
            Object[] row = r.intoArray();
            dtmDetalle.addRow(row);
        }
        
    }
    
    private void dibujarTablaFacturas(){
         tDetalle.setGridColor(colorUI);
        
        JTableHeader jtableHeader = tDetalle.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tDetalle.setTableHeader(  jtableHeader );
        
        tDetalle.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tDetalle.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tDetalle.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("num",new Color(113, 205, 245)));
        tDetalle.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tDetalle.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tDetalle.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tDetalle.repaint();
    }
    
}
