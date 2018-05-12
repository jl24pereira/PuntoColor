
package panels.ventas;

import clases.Mensajes;
import com.mrlonee.swing.animation.AnimatedPanel;
import static db.clases.Tables.CATEGORIA_PRODUCTO;
import static db.clases.Tables.PRODUCTO;
import static db.clases.Tables.V_PRODUCTOS;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.lista.Proveedor;
import design.tabbedpane.TabbedPanelUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import dialogs.produccion.DialogCategoriaProducto;
import dialogs.produccion.DialogProductos;
import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import static puntocolor.Principal.database;
import javax.swing.table.JTableHeader;
import static org.jooq.impl.DSL.count;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;

/*@author Jose Luis */
public class PanelCatalogo extends AnimatedPanel {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    DefaultListModel<Proveedor> modelo = new DefaultListModel<>();
    
    DefaultTableModel dtmCategorias;
    DefaultTableModel dtmProductos;
    
    boolean nuevaCategoria = false;

    public PanelCatalogo() {
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();
        dtmProductos = (DefaultTableModel) tProductos.getModel();
        dibujarTablas();
        try {
            cargarTablaProductos();
        } catch (Exception ex) {
            Logger.getLogger(PanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popInventario = new javax.swing.JPopupMenu();
        itemDetalle = new javax.swing.JMenuItem();
        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnReporte = new javax.swing.JButton();
        pTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pTabs = new javax.swing.JPanel();
        tpInventario = new javax.swing.JTabbedPane();
        pGestion = new javax.swing.JPanel();
        pTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tProductos = new javax.swing.JTable();

        itemDetalle.setText("Ver Detalle");
        popInventario.add(itemDetalle);

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

        cbxFiltro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar todo", "Codigo", "Nombre", "Categoria" }));
        cbxFiltro.setSelectedIndex(-1);
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

        btnReporte.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnReporte.setForeground(colorBG);
        btnReporte.setText("Reporte");
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.setFocusable(false);
        btnReporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReporte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnReporte);
        btnReporte.setUI(new ButtonUI(
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(colorUI);
        jLabel1.setText("Catálogo de Productos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/Product-sale-report64.png"))); // NOI18N
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

        tProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "Codigo", "Nombre", "Color", "Categoria", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tProductos.setComponentPopupMenu(popInventario);
        tProductos.setRowHeight(30);
        tProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tProductos.getTableHeader().setReorderingAllowed(false);
        tProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tProductosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tProductos);
        if (tProductos.getColumnModel().getColumnCount() > 0) {
            tProductos.getColumnModel().getColumn(0).setMinWidth(0);
            tProductos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tProductos.getColumnModel().getColumn(0).setMaxWidth(0);
            tProductos.getColumnModel().getColumn(1).setMinWidth(100);
            tProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tProductos.getColumnModel().getColumn(1).setMaxWidth(100);
            tProductos.getColumnModel().getColumn(3).setMinWidth(120);
            tProductos.getColumnModel().getColumn(3).setPreferredWidth(120);
            tProductos.getColumnModel().getColumn(3).setMaxWidth(120);
            tProductos.getColumnModel().getColumn(4).setMinWidth(150);
            tProductos.getColumnModel().getColumn(4).setPreferredWidth(150);
            tProductos.getColumnModel().getColumn(4).setMaxWidth(150);
            tProductos.getColumnModel().getColumn(5).setMinWidth(100);
            tProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tProductos.getColumnModel().getColumn(5).setMaxWidth(100);
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

        tpInventario.addTab("<html><body align=\"center\">Gestión de<br>Productos</body></html>", pGestion);

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

    private void tProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tProductosMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tProductos.rowAtPoint(point);
        tProductos.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tProductosMousePressed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        try {
            if(dtmProductos!=null){
                cargarTablaProductos();
            }            
        } catch (Exception ex) {
            Logger.getLogger(PanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        try {
            cargarTablaProductos();
        } catch (Exception ex) {
            Logger.getLogger(PanelCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void tpInventarioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpInventarioStateChanged
        // TODO add your handling code here:
        cbxFiltro.removeAllItems();
        cbxFiltro.addItem("Buscar todo");
        cbxFiltro.addItem("Codigo");
        cbxFiltro.addItem("Nombre");
        cbxFiltro.addItem("Categoria");
    }//GEN-LAST:event_tpInventarioStateChanged

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        switch(cbxFiltro.getSelectedIndex()){
            case 1:
                Reportes.Reportes.reporteCatalogoXCodigo(txtFiltro.getText());
                break;
            case 2:
                Reportes.Reportes.reporteCatalogoXNombre(txtFiltro.getText());
                break;
            case 3:
                Reportes.Reportes.reporteCatalogoXCategoria(txtFiltro.getText());
                break;
            default:
                Reportes.Reportes.reporteCatalogo();
                break;
        }
    }//GEN-LAST:event_btnReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JMenuItem itemDetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JPanel pGestion;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTabla;
    private javax.swing.JPanel pTabs;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JPopupMenu popInventario;
    private javax.swing.JTable tProductos;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpInventario;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
 
    private void cargarTablaProductos()throws Exception{
        for(int i=0; i<tProductos.getRowCount(); i++){
            dtmProductos.removeRow(i);
            i-=1;
        }
        SelectQuery<Record> query = create.selectQuery();
        query.addSelect(
                V_PRODUCTOS.IDPRODUCTO,
                V_PRODUCTOS.CODIGO,
                V_PRODUCTOS.NOMBRE,
                V_PRODUCTOS.COLOR,
                V_PRODUCTOS.CATEGORIA,
                V_PRODUCTOS.P_NORMAL
        );
        query.addFrom(V_PRODUCTOS);
        Condition filtro;
        switch(cbxFiltro.getSelectedIndex()){
            case 1: 
                    filtro = V_PRODUCTOS.CODIGO.likeIgnoreCase("%"+txtFiltro.getText()+"%"); 
                    break;
                case 2:
                    filtro = V_PRODUCTOS.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                    break;
                case 3:
                    filtro = V_PRODUCTOS.CATEGORIA.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                    break;
                default:
                    filtro = V_PRODUCTOS.CATEGORIA.likeIgnoreCase("%"+txtFiltro.getText()+"%")
                            .or(V_PRODUCTOS.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%"))
                            .or(V_PRODUCTOS.CODIGO.likeIgnoreCase("%"+txtFiltro.getText()+"%"));
                    break;
        }
        query.addConditions(filtro);
        query.addOrderBy(V_PRODUCTOS.CODIGO.asc());
        Result<Record> result = query.fetch();
        for (Record r : result){
            Object[] row = r.intoArray();
            dtmProductos.addRow(row);
        }
        if(tProductos.getRowCount()>0){
            tProductos.changeSelection(0, 1, false, false);
        }
    }
    
    private void limpiarFormCategoria(){
        /*txtNombreCategoria.setText("");
        txtCodigoCategoria.setText("");*/
    }
    
    private void dibujarTablas(){
        tProductos.setGridColor(colorUI);
        JTableHeader jtableHeader = tProductos.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tProductos.setTableHeader(  jtableHeader );
        
        
        tProductos.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tProductos.repaint();
    }
    
}
