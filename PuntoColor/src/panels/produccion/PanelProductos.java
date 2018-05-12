
package panels.produccion;

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
import dialogs.compras.DialogMateriaPrima;
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
public class PanelProductos extends AnimatedPanel {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    DefaultListModel<Proveedor> modelo = new DefaultListModel<>();
    
    DefaultTableModel dtmCategorias;
    DefaultTableModel dtmProductos;
    
    boolean nuevaCategoria = false;

    public PanelProductos() {
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();
        dtmCategorias = (DefaultTableModel) tCategorias.getModel();
        dtmProductos = (DefaultTableModel) tProductos.getModel();
        dibujarTablas();
        try {
            cargarTablaCategorias();
            cargarTablaProductos();
        } catch (Exception ex) {
            Logger.getLogger(PanelProductos.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popInventario = new javax.swing.JPopupMenu();
        itemEditar = new javax.swing.JMenuItem();
        itemBaja = new javax.swing.JMenuItem();
        itemDetalle = new javax.swing.JMenuItem();
        popCategoria = new javax.swing.JPopupMenu();
        itemEditarCat = new javax.swing.JMenuItem();
        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        chkBajas = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnEditar = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnBaja = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCategorias = new javax.swing.JTable();

        itemEditar.setText("Editar");
        itemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarActionPerformed(evt);
            }
        });
        popInventario.add(itemEditar);

        itemBaja.setText("Baja");
        itemBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBajaActionPerformed(evt);
            }
        });
        popInventario.add(itemBaja);

        itemDetalle.setText("Ver Detalle");
        popInventario.add(itemDetalle);

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

        cbxFiltro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar todo", "Categoria", "Codigo Categoria" }));
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

        chkBajas.setBackground(cBtnNormal);
        chkBajas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chkBajas.setForeground(colorBG);
        chkBajas.setText("Ver Bajas");
        chkBajas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkBajas.setFocusable(false);
        chkBajas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chkBajas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Typicons_e0a8(1)_32.png"))); // NOI18N
        chkBajas.setMaximumSize(new java.awt.Dimension(110, 25));
        chkBajas.setMinimumSize(new java.awt.Dimension(110, 25));
        chkBajas.setPreferredSize(new java.awt.Dimension(110, 25));
        chkBajas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Typicons_e08b(0)_32.png"))); // NOI18N
        chkBajas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBajasItemStateChanged(evt);
            }
        });
        chkBajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBajasActionPerformed(evt);
            }
        });
        toolBarTabla1.add(chkBajas);
        toolBarTabla1.add(jSeparator2);

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
        toolBarTabla1.add(jSeparator10);

        btnEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEditar.setForeground(colorTexto);
        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnEditar);
        btnEditar.setUI(new ButtonUI(
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
        toolBarTabla1.add(jSeparator1);

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
        jLabel1.setText("Productos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/product64.png"))); // NOI18N
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
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Codigo", "Nombre", "Color", "T. Fab.", "Categoria", "C. Admin", "C. Inv.", "PV#1", "PV#2", "PV#3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
            tProductos.getColumnModel().getColumn(1).setMinWidth(65);
            tProductos.getColumnModel().getColumn(1).setPreferredWidth(65);
            tProductos.getColumnModel().getColumn(1).setMaxWidth(65);
            tProductos.getColumnModel().getColumn(3).setMinWidth(80);
            tProductos.getColumnModel().getColumn(3).setPreferredWidth(80);
            tProductos.getColumnModel().getColumn(3).setMaxWidth(80);
            tProductos.getColumnModel().getColumn(4).setMinWidth(80);
            tProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tProductos.getColumnModel().getColumn(4).setMaxWidth(80);
            tProductos.getColumnModel().getColumn(5).setMinWidth(90);
            tProductos.getColumnModel().getColumn(5).setPreferredWidth(90);
            tProductos.getColumnModel().getColumn(5).setMaxWidth(90);
            tProductos.getColumnModel().getColumn(6).setMinWidth(80);
            tProductos.getColumnModel().getColumn(6).setPreferredWidth(80);
            tProductos.getColumnModel().getColumn(6).setMaxWidth(80);
            tProductos.getColumnModel().getColumn(7).setMinWidth(80);
            tProductos.getColumnModel().getColumn(7).setPreferredWidth(80);
            tProductos.getColumnModel().getColumn(7).setMaxWidth(80);
            tProductos.getColumnModel().getColumn(8).setMinWidth(50);
            tProductos.getColumnModel().getColumn(8).setPreferredWidth(50);
            tProductos.getColumnModel().getColumn(8).setMaxWidth(50);
            tProductos.getColumnModel().getColumn(9).setMinWidth(50);
            tProductos.getColumnModel().getColumn(9).setPreferredWidth(50);
            tProductos.getColumnModel().getColumn(9).setMaxWidth(50);
            tProductos.getColumnModel().getColumn(10).setMinWidth(50);
            tProductos.getColumnModel().getColumn(10).setPreferredWidth(50);
            tProductos.getColumnModel().getColumn(10).setMaxWidth(50);
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

        jPanel3.setBackground(colorBG);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setOpaque(false);

        tCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "No.", "Categoria de Producto", "Código de Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tCategorias.setComponentPopupMenu(popCategoria);
        tCategorias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tCategorias.setRowHeight(30);
        tCategorias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tCategorias.getTableHeader().setReorderingAllowed(false);
        tCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tCategoriasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tCategorias);
        if (tCategorias.getColumnModel().getColumnCount() > 0) {
            tCategorias.getColumnModel().getColumn(0).setMinWidth(0);
            tCategorias.getColumnModel().getColumn(0).setPreferredWidth(0);
            tCategorias.getColumnModel().getColumn(0).setMaxWidth(0);
            tCategorias.getColumnModel().getColumn(1).setMinWidth(100);
            tCategorias.getColumnModel().getColumn(1).setPreferredWidth(100);
            tCategorias.getColumnModel().getColumn(1).setMaxWidth(100);
            tCategorias.getColumnModel().getColumn(3).setMinWidth(200);
            tCategorias.getColumnModel().getColumn(3).setPreferredWidth(200);
            tCategorias.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel3.add(jPanel4, gridBagConstraints);

        tpInventario.addTab("<html><body align=\\u005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005c\"center\\u005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005c\">Gestión de<br>Categorias</body></html>", jPanel3);

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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tpInventario.getSelectedIndex() == 0){
            editarProducto();
        }else{
            editarCategoria();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tProductosMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tProductos.rowAtPoint(point);
        tProductos.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tProductosMousePressed

    private void itemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarActionPerformed
        // TODO add your handling code here:
        editarProducto();
    }//GEN-LAST:event_itemEditarActionPerformed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        // TODO add your handling code here:
        try{
            switch(tpInventario.getSelectedIndex()){
                case 0:
                    cargarTablaProductos();
                    break;
                case 1:
                    cargarTablaCategorias();
                    break;
            }
        }catch (Exception ex){
            //new Mensajes().mensajeError("Ha ocurrido un error en la transacción");
        }        
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        try{
            switch(tpInventario.getSelectedIndex()){
                case 0:
                    cargarTablaProductos();
                    break;
                case 1:
                    cargarTablaCategorias();
                    break;
            }
        }catch (Exception ex){
            new Mensajes().mensajeError("Ha ocurrido un error en la transacción");
        }
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        if(tpInventario.getSelectedIndex() == 0){
            nuevoProducto();
        }else{
            nuevoCategoria();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tpInventarioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpInventarioStateChanged
        // TODO add your handling code here:
        cbxFiltro.removeAllItems();
        if(tpInventario.getSelectedIndex() == 0){
            cbxFiltro.addItem("Buscar todo");
            cbxFiltro.addItem("Codigo");
            cbxFiltro.addItem( "Nombre");
            cbxFiltro.addItem("Categoria");
            if(chkBajas.isSelected()){
                btnBaja.setText("Alta");
            }else{
                btnBaja.setText("Baja");
            }
        }else{
            cbxFiltro.addItem("Buscar todo");
            cbxFiltro.addItem("Nombre");
            cbxFiltro.addItem( "Codigo");
            btnBaja.setText("Eliminar");
        }
    }//GEN-LAST:event_tpInventarioStateChanged

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        // TODO add your handling code here:
        try{
            if(tpInventario.getSelectedIndex()==0){
                if(chkBajas.isSelected()){
                    altaProducto();
                }else{
                    bajaProducto();
                }
            }else{
                eliminarCategoria();
            }
        }catch(Exception ex){
            
        }        
    }//GEN-LAST:event_btnBajaActionPerformed

    private void itemEditarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarCatActionPerformed
        // TODO add your handling code here:
        editarCategoria();
    }//GEN-LAST:event_itemEditarCatActionPerformed

    private void tCategoriasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tCategoriasMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tCategorias.rowAtPoint(point);
        tCategorias.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tCategoriasMousePressed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        Reportes.Reportes.reporteCostosProducto();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void chkBajasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBajasItemStateChanged
        try {
            if(tpInventario.getSelectedIndex()==0){
                if(chkBajas.isSelected()){
                    btnBaja.setText("Alta");
                    itemBaja.setText("Alta Producto");
                }else{
                    btnBaja.setText("Baja");
                    itemBaja.setText("Baja Producto");
                }
            }
            cargarTablaProductos();
        } catch (Exception ex) {
            Logger.getLogger(PanelProductos.class.getName()).log(Level.SEVERE, null, ex);
            new Mensajes().mensajeError("Ha ocurrido un error en la transacción");
        }
    }//GEN-LAST:event_chkBajasItemStateChanged

    private void chkBajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBajasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBajasActionPerformed

    private void itemBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBajaActionPerformed
        // TODO add your handling code here:
        try{
            if(tpInventario.getSelectedIndex()==0){
                if(chkBajas.isSelected()){
                    altaProducto();
                }else{
                    bajaProducto();
                }
            }else{
                eliminarCategoria();
            }
        }catch(Exception ex){
            
        }
    }//GEN-LAST:event_itemBajaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JCheckBox chkBajas;
    private javax.swing.JMenuItem itemBaja;
    private javax.swing.JMenuItem itemDetalle;
    private javax.swing.JMenuItem itemEditar;
    private javax.swing.JMenuItem itemEditarCat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator2;
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
    private javax.swing.JTable tCategorias;
    private javax.swing.JTable tProductos;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpInventario;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaCategorias() throws Exception{
        int numero = 0;
        for(int i=0; i<tCategorias.getRowCount(); i++){
            dtmCategorias.removeRow(i);
            i-=1;
        }
        
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(CATEGORIA_PRODUCTO);
        Condition filtro;
        switch(cbxFiltro.getSelectedIndex()){
            case 1:
                filtro = CATEGORIA_PRODUCTO.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            case 2:
                filtro = CATEGORIA_PRODUCTO.CODIGOCATEGORIA.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            default:
                filtro = CATEGORIA_PRODUCTO.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%")
                        .or(CATEGORIA_PRODUCTO.CODIGOCATEGORIA.likeIgnoreCase("%"+txtFiltro.getText()+"%"));
                break;
        }
        query.addConditions(filtro);
        query.addOrderBy(CATEGORIA_PRODUCTO.NOMBRE.asc());
        Result<Record> result = query.fetch();
        for (Record r : result) {
            numero ++;
            Object[] row = {
                r.getValue(CATEGORIA_PRODUCTO.IDCATEGORIA),
                numero,
                r.getValue(CATEGORIA_PRODUCTO.NOMBRE),
                r.getValue(CATEGORIA_PRODUCTO.CODIGOCATEGORIA)
            };
            dtmCategorias.addRow(row);
        }
        
        if(tCategorias.getRowCount()>0){
            tCategorias.changeSelection(0, 1, false, false);
        }
    }
    
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
                V_PRODUCTOS.TIEMPOFABRICA,
                V_PRODUCTOS.CATEGORIA,
                V_PRODUCTOS.COSTO_ADMINISTRATIVO,
                V_PRODUCTOS.COSTO_INVENTARIO,
                V_PRODUCTOS.P_NORMAL,
                V_PRODUCTOS.P_VIP,
                V_PRODUCTOS.P_DIST);
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
        Condition baja = V_PRODUCTOS.BAJA.equal(chkBajas.isSelected());
        query.addConditions(filtro.and(baja));
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
        tProductos.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("num",new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(6).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(7).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(8).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(9).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(10).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tProductos.repaint();
        
        tCategorias.setGridColor(colorUI);
        JTableHeader headerCat = tCategorias.getTableHeader();
        headerCat.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tCategorias.setTableHeader(  headerCat );
        
        tCategorias.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tCategorias.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tCategorias.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        
        tCategorias.repaint();
    }
    
    private void nuevoProducto(){
        DialogProductos dialog = new DialogProductos(new javax.swing.JFrame(), true, "Nuevo Producto");
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro agregado exitosamente");
            try {
                cargarTablaProductos();
            } catch (Exception ex) {
                Logger.getLogger(PanelProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dialog.dispose();
    }
    
    private void editarProducto(){
        int idproducto = (int)tProductos.getValueAt(tProductos.getSelectedRow(), 0);
        String codigo = (String) tProductos.getValueAt(tProductos.getSelectedRow(), 1);
        String categoria = (String)tProductos.getValueAt(tProductos.getSelectedRow(), 5);
        DialogProductos dialog = new DialogProductos(new javax.swing.JFrame(), true,"Editar Producto",idproducto,codigo,categoria);
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            try {          
                cargarTablaProductos();
            } catch (Exception ex) {
                Logger.getLogger(PanelProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
            new Mensajes().mensajeInfo("Registro editado exitosamente");
        }
        dialog.dispose();
    }
    
    private void nuevoCategoria(){
        DialogCategoriaProducto dialog = new DialogCategoriaProducto(new javax.swing.JFrame(), true, "Nueva Categoria");
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro agregado exitosamente");
            //cargarTablaCategorias();
        }
        dialog.dispose();
    }
    
    private void editarCategoria(){
        int idCat = (int) tCategorias.getValueAt(tCategorias.getSelectedRow(), 0);
        DialogCategoriaProducto dialog = new DialogCategoriaProducto(new javax.swing.JFrame(), true, "Editar Categoria", idCat);
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro editado exitosamente");
            //cargarTablaCategorias();
        }
        dialog.dispose();
    }

    private void altaProducto() throws Exception {
        int idproducto = (int)tProductos.getValueAt(tProductos.getSelectedRow(), 0);
        create.update(PRODUCTO)
                .set(PRODUCTO.BAJA,false)
                .where(PRODUCTO.IDPRODUCTO.equal(idproducto))
                .execute();
        cargarTablaProductos(); 
    }

    private void bajaProducto() throws Exception {
        int idproducto = (int)tProductos.getValueAt(tProductos.getSelectedRow(), 0);
        int r = new Mensajes().mensajeSiNo("Desea dar baja registro?");
        if(r==0){  
            create.update(PRODUCTO)
                    .set(PRODUCTO.BAJA,true)
                    .where(PRODUCTO.IDPRODUCTO.equal(idproducto))
                    .execute();
            cargarTablaProductos();
        }
    }

    private void eliminarCategoria() throws Exception {
        int idCat = (int) tCategorias.getValueAt(tCategorias.getSelectedRow(), 0);
        if(isVacia(idCat)){
            int r = new Mensajes().mensajeSiNo("Desea eliminar el registro?");
            if(r==0){
                create.delete(CATEGORIA_PRODUCTO)
                        .where(CATEGORIA_PRODUCTO.IDCATEGORIA.equal(idCat))
                        .execute();
                cargarTablaCategorias();
            } 
        }else{  
            new Mensajes().mensajeError("No se puede eliminar categoria con Productos asignados!");
        }
    }
    
    private boolean isVacia(int id)throws Exception{
        int contador = 0;
        contador = create.select(count())
                .from(PRODUCTO)
                .where(PRODUCTO.IDCATEGORIA.equal(id))
                .fetchOne().getValue(count());
        return contador <= 0;
    }   
    
}
