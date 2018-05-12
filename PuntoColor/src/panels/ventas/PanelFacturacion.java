
package panels.ventas;

import clases.Fechero;
import com.mrlonee.swing.animation.AnimatedPanel;
import static db.clases.Tables.EMPRESA;
import static db.clases.Tables.V_PEDIDOS;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.lista.Proveedor;
import design.tabbedpane.TabbedPanelUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import dialogs.ventas.DialogPedido;
import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import static puntocolor.Principal.database;
import javax.swing.table.JTableHeader;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;

/*@author Jose Luis */
public class PanelFacturacion extends AnimatedPanel {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    DefaultListModel<Proveedor> modelo = new DefaultListModel<>();

    DefaultTableModel dtmPedidos;
    
    boolean nuevaCategoria = false;

    public PanelFacturacion() {
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();
        dtmPedidos = (DefaultTableModel) tPedidos.getModel();
        dibujarTablas();
        cargarTablaPedidos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popInventario = new javax.swing.JPopupMenu();
        itemEditar = new javax.swing.JMenuItem();
        itemBaja = new javax.swing.JMenuItem();
        popCategoria = new javax.swing.JPopupMenu();
        itemEditarCat = new javax.swing.JMenuItem();
        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        cbxFiltroCategoria = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltroCategoria = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnBaja = new javax.swing.JButton();
        pTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pTabs = new javax.swing.JPanel();
        tpInventario = new javax.swing.JTabbedPane();
        pGestion = new javax.swing.JPanel();
        pTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tPedidos = new javax.swing.JTable();

        itemEditar.setText("Editar");
        itemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarActionPerformed(evt);
            }
        });
        popInventario.add(itemEditar);

        itemBaja.setText("Baja");
        popInventario.add(itemBaja);

        itemEditarCat.setText("Editar");
        itemEditarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarCatActionPerformed(evt);
            }
        });
        popCategoria.add(itemEditarCat);

        setLayout(new java.awt.GridBagLayout());

        pMain.setBackground(new java.awt.Color(102, 102, 102));
        pMain.setOpaque(false);
        pMain.setLayout(new java.awt.GridBagLayout());

        toolBarTabla1.setBackground(colorUI);
        toolBarTabla1.setBorder(null);
        toolBarTabla1.setFloatable(false);
        toolBarTabla1.setRollover(true);
        toolBarTabla1.setMaximumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setMinimumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setPreferredSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.add(jSeparator9);

        cbxFiltroCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxFiltroCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar todo", "Categoria", "Codigo Categoria" }));
        cbxFiltroCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        cbxFiltroCategoria.setMaximumSize(new java.awt.Dimension(150, 40));
        cbxFiltroCategoria.setMinimumSize(new java.awt.Dimension(150, 40));
        cbxFiltroCategoria.setPreferredSize(new java.awt.Dimension(150, 40));
        cbxFiltroCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFiltroCategoriaItemStateChanged(evt);
            }
        });
        toolBarTabla1.add(cbxFiltroCategoria);
        cbxFiltroCategoria.setUI(new ComboUI(colorBG,cBtnNormal));
        toolBarTabla1.add(jSeparator7);

        txtFiltroCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtFiltroCategoria.setMaximumSize(new java.awt.Dimension(150, 40));
        txtFiltroCategoria.setMinimumSize(new java.awt.Dimension(150, 40));
        txtFiltroCategoria.setPreferredSize(new java.awt.Dimension(150, 40));
        txtFiltroCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroCategoriaKeyReleased(evt);
            }
        });
        toolBarTabla1.add(txtFiltroCategoria);
        txtFiltroCategoria.setUI(new TextFieldUI(
            "Buscar...", colorUI, cBtnNormal, colorBG
        ));
        toolBarTabla1.add(jSeparator8);

        btnNuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNuevo.setForeground(colorTexto);
        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnNuevo);
        btnNuevo.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));
        toolBarTabla1.add(jSeparator11);

        btnBaja.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBaja.setForeground(colorTexto);
        btnBaja.setText("Baja");
        btnBaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBaja.setFocusable(false);
        btnBaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnBaja);
        btnBaja.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pMain.add(toolBarTabla1, gridBagConstraints);

        pTitulo.setOpaque(false);
        pTitulo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(colorUI);
        jLabel1.setText("Facturación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Entypo_e738(0)_48.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pTitulo.add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pMain.add(pTitulo, gridBagConstraints);

        pTabs.setOpaque(false);
        pTabs.setLayout(new java.awt.GridBagLayout());

        tpInventario.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tpInventario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tpInventario.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tpInventarioStateChanged(evt);
            }
        });

        pGestion.setBackground(colorBG);
        pGestion.setForeground(new java.awt.Color(153, 153, 0));
        pGestion.setLayout(new java.awt.GridBagLayout());

        pTabla.setMinimumSize(new java.awt.Dimension(300, 100));
        pTabla.setOpaque(false);
        pTabla.setPreferredSize(new java.awt.Dimension(450, 100));
        pTabla.setLayout(new java.awt.GridBagLayout());

        tPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Fecha", "Cliente", "Pagos", "Debe", "Total", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tPedidos.setComponentPopupMenu(popInventario);
        tPedidos.setRowHeight(30);
        tPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tPedidos.getTableHeader().setReorderingAllowed(false);
        tPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tPedidosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tPedidos);
        if (tPedidos.getColumnModel().getColumnCount() > 0) {
            tPedidos.getColumnModel().getColumn(0).setMinWidth(100);
            tPedidos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tPedidos.getColumnModel().getColumn(0).setMaxWidth(100);
            tPedidos.getColumnModel().getColumn(1).setMinWidth(100);
            tPedidos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tPedidos.getColumnModel().getColumn(1).setMaxWidth(100);
            tPedidos.getColumnModel().getColumn(3).setMinWidth(80);
            tPedidos.getColumnModel().getColumn(3).setPreferredWidth(80);
            tPedidos.getColumnModel().getColumn(3).setMaxWidth(80);
            tPedidos.getColumnModel().getColumn(4).setMinWidth(80);
            tPedidos.getColumnModel().getColumn(4).setPreferredWidth(10);
            tPedidos.getColumnModel().getColumn(4).setMaxWidth(80);
            tPedidos.getColumnModel().getColumn(5).setMinWidth(80);
            tPedidos.getColumnModel().getColumn(5).setPreferredWidth(80);
            tPedidos.getColumnModel().getColumn(5).setMaxWidth(80);
            tPedidos.getColumnModel().getColumn(6).setMinWidth(150);
            tPedidos.getColumnModel().getColumn(6).setPreferredWidth(150);
            tPedidos.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pTabla.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pGestion.add(pTabla, gridBagConstraints);

        tpInventario.addTab("<html><body align=\"center\">Gestión de<br>Pedidos</body></html>", pGestion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pTabs.add(tpInventario, gridBagConstraints);
        tpInventario.setUI(new TabbedPanelUI(colorUI,colorBG));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pMain.add(pTabs, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(pMain, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tPedidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPedidosMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tPedidos.rowAtPoint(point);
        tPedidos.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tPedidosMousePressed

    private void itemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarActionPerformed
        // TODO add your handling code here:
        //editarProducto();\
        Runtime r = Runtime.getRuntime();
        Process p = null;
        String pedido = (String) tPedidos.getValueAt(tPedidos.getSelectedRow(), 0);
        String nombre = (String) tPedidos.getValueAt(tPedidos.getSelectedRow(), 2);
        String path = create.select(EMPRESA.PATH)
                .from(EMPRESA)
                .fetchOne(EMPRESA.PATH,String.class);
        try {
            p = r.exec("explorer.exe "+path+"\\"+pedido+" - "+nombre);
        } catch (IOException ex) {
            Logger.getLogger(PanelFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemEditarActionPerformed

    private void cbxFiltroCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroCategoriaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroCategoriaItemStateChanged

    private void txtFiltroCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroCategoriaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroCategoriaKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        DialogPedido dialog = new DialogPedido(new javax.swing.JFrame(), true, "Nuevo Pedido");
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            cargarTablaPedidos();            
        }
        try {  
            database.getConexion().setAutoCommit(true);
            System.out.println("CERRANDO TRANSACCION");
        } catch (SQLException ex) {
            Logger.getLogger(PanelFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tpInventarioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpInventarioStateChanged
        // TODO add your handling code here:
        if(tpInventario.getSelectedIndex() == 0){
            
            //cargarDialogMaterial();
        }else{
            //cargarDialogCategoria();
        }
    }//GEN-LAST:event_tpInventarioStateChanged

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBajaActionPerformed

    private void itemEditarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarCatActionPerformed
        // TODO add your handling code here:
        //editarCategoria();
    }//GEN-LAST:event_itemEditarCatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbxFiltroCategoria;
    private javax.swing.JMenuItem itemBaja;
    private javax.swing.JMenuItem itemEditar;
    private javax.swing.JMenuItem itemEditarCat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JPanel pGestion;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTabla;
    private javax.swing.JPanel pTabs;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JPopupMenu popCategoria;
    private javax.swing.JPopupMenu popInventario;
    private javax.swing.JTable tPedidos;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpInventario;
    private javax.swing.JTextField txtFiltroCategoria;
    // End of variables declaration//GEN-END:variables
    
    private void cargarTablaPedidos(){
        for(int i=0; i<tPedidos.getRowCount(); i++){
            dtmPedidos.removeRow(i);
            i-=1;
        }
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(V_PEDIDOS);
        query.addOrderBy(V_PEDIDOS.FECHA.asc());
        query.addOrderBy(V_PEDIDOS.NUMERO.asc());
        Result<Record> result = query.fetch();
        for (Record r : result){
            Object[] row = {
                r.getValue(V_PEDIDOS.NUMERO),
                Fechero.baseToReal(r.getValue(V_PEDIDOS.FECHA)),
                r.getValue(V_PEDIDOS.NOMBRECLIENTE),
                r.getValue(V_PEDIDOS.PAGADO),
                r.getValue(V_PEDIDOS.DEBE),
                r.getValue(V_PEDIDOS.TOTAL),
                r.getValue(V_PEDIDOS.ESTADO)
            };
            dtmPedidos.addRow(row);
        }
        /*if(tPedidos.getRowCount()>0){
            tPedidos.changeSelection(0, 1, false, false);
        }*/
    }
    
    private void dibujarTablas(){
        tPedidos.setGridColor(colorUI);
        JTableHeader jtableHeader = tPedidos.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tPedidos.setTableHeader(  jtableHeader );        
        
        tPedidos.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tPedidos.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tPedidos.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tPedidos.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tPedidos.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tPedidos.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tPedidos.getColumnModel().getColumn(6).setCellRenderer(new CellRenderer("pedido",new Color(113, 205, 245)));
        tPedidos.repaint();
        
    }
    
}
