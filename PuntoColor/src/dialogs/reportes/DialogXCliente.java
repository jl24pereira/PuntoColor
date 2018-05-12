
package dialogs.reportes;

import static db.clases.Tables.CLIENTE;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;

/* @author Jose Luis */
public class DialogXCliente extends javax.swing.JDialog {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);

    DefaultTableModel dtmCliente;
    
    int tRep;

    public DialogXCliente(java.awt.Frame parent, boolean modal, String titulo, int trep ) {
        super(parent, modal);  
        initComponents();
        dtmCliente = (DefaultTableModel) tClientes.getModel();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        this.tRep = trep;
        dibujarTablaClientes();
        cargarTablaClientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pBody = new javax.swing.JPanel();
        pDetalle = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tClientes = new javax.swing.JTable();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnReportes = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(700, 600));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pBody.setBackground(colorBG);
        pBody.setLayout(new java.awt.GridBagLayout());

        pDetalle.setOpaque(false);
        pDetalle.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Clientes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pDetalle.add(jLabel2, gridBagConstraints);

        tClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "Nombre", "Direccion", "Telefono", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tClientes.setRowHeight(30);
        jScrollPane1.setViewportView(tClientes);
        if (tClientes.getColumnModel().getColumnCount() > 0) {
            tClientes.getColumnModel().getColumn(0).setMinWidth(0);
            tClientes.getColumnModel().getColumn(0).setPreferredWidth(0);
            tClientes.getColumnModel().getColumn(0).setMaxWidth(0);
            tClientes.getColumnModel().getColumn(3).setMinWidth(100);
            tClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
            tClientes.getColumnModel().getColumn(3).setMaxWidth(100);
            tClientes.getColumnModel().getColumn(4).setMinWidth(150);
            tClientes.getColumnModel().getColumn(4).setPreferredWidth(150);
            tClientes.getColumnModel().getColumn(4).setMaxWidth(150);
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

        toolBarTabla1.setBackground(colorUI);
        toolBarTabla1.setBorder(null);
        toolBarTabla1.setFloatable(false);
        toolBarTabla1.setRollover(true);
        toolBarTabla1.setMaximumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setMinimumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setPreferredSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.add(jSeparator9);

        cbxFiltro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar todo", "Nombre", "Direccion", "Telefono" }));
        cbxFiltro.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        cbxFiltro.setMaximumSize(new java.awt.Dimension(150, 40));
        cbxFiltro.setMinimumSize(new java.awt.Dimension(150, 40));
        cbxFiltro.setPreferredSize(new java.awt.Dimension(150, 40));
        cbxFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFiltroItemStateChanged(evt);
            }
        });
        toolBarTabla1.add(cbxFiltro);
        cbxFiltro.setUI(new ComboUI(colorBG,cBtnNormal));
        toolBarTabla1.add(jSeparator7);

        txtFiltro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtFiltro.setMaximumSize(new java.awt.Dimension(150, 40));
        txtFiltro.setMinimumSize(new java.awt.Dimension(150, 40));
        txtFiltro.setPreferredSize(new java.awt.Dimension(150, 40));
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });
        toolBarTabla1.add(txtFiltro);
        txtFiltro.setUI(new TextFieldUI(
            "Buscar...", colorUI, cBtnNormal, colorBG
        ));
        toolBarTabla1.add(jSeparator8);

        btnReportes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnReportes.setForeground(colorBG);
        btnReportes.setText("Reporte");
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setFocusable(false);
        btnReportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnReportes);
        btnReportes.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));
        toolBarTabla1.add(jSeparator10);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pBody.add(toolBarTabla1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pBody, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        // TODO add your handling code here:
        cargarTablaClientes();
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        cargarTablaClientes();
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
        if(tClientes.getRowCount()>0){
            int idcliente = (int) tClientes.getValueAt(tClientes.getSelectedRow(), 0);
            this.dispose();
            //
            switch(tRep){
            case 1:
                Reportes.Reportes.reporteCotizacionesXCliente(idcliente);
                break;
            case 2:
                Reportes.Reportes.reportePedidoXCliente(idcliente);
                break;
            case 3:
                Reportes.Reportes.reporteVentaXCliente(idcliente);
                break;
        }
        }else{
            JOptionPane.showMessageDialog(null, "No se encuentran clientes");
        }
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JPanel pBody;
    private javax.swing.JPanel pDetalle;
    private javax.swing.JTable tClientes;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
        
    private void cargarTablaClientes(){
        for(int i=0; i<tClientes.getRowCount(); i++){
            dtmCliente.removeRow(i);
            i-=1;
        }
        
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(CLIENTE);
        Condition filtro;
        switch(cbxFiltro.getSelectedIndex()){
            case 1: 
                filtro = CLIENTE.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%"); 
                break;
            case 2:
                filtro = CLIENTE.DIRECCION.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            case 3:
                filtro = CLIENTE.TELEFONO.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            default:
                filtro = CLIENTE.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%")
                        .or(CLIENTE.DIRECCION.likeIgnoreCase("%"+txtFiltro.getText()+"%"))
                        .or(CLIENTE.TELEFONO.likeIgnoreCase("%"+txtFiltro.getText()+"%"));
                break;
        }
        query.addConditions(filtro.and(CLIENTE.BAJA.equal(false)));
        query.addOrderBy(CLIENTE.NOMBRE.asc());
        Result<Record> result = query.fetch();
        for (Record r : result){
            Object[] row = {
                r.getValue(CLIENTE.IDCLIENTE),
                r.getValue(CLIENTE.NOMBRE),
                r.getValue(CLIENTE.DIRECCION),
                r.getValue(CLIENTE.TELEFONO),
                r.getValue(CLIENTE.TIPO)
            };
            dtmCliente.addRow(row);
        }
        if(tClientes.getRowCount()>0){
            tClientes.changeSelection(0, 1, false, false);
        }
    }
    
    private void dibujarTablaClientes(){
         tClientes.setGridColor(colorUI);
        
        JTableHeader jtableHeader = tClientes.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tClientes.setTableHeader(  jtableHeader );
        
        tClientes.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tClientes.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tClientes.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tClientes.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tClientes.repaint();
    }
    
}
