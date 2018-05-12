
package panels.compras;

import Reportes.Reportes;
import clases.Mensajes;
import com.mrlonee.swing.animation.AnimatedPanel;
//import static db.clases.Tables.CATEGORIA_INVENTARIO;
import static db.clases.Tables.CATEGORIA_INVENTARIO;
import static db.clases.Tables.INVENTARIO;
import static db.clases.Tables.RECETA;
import static db.clases.Tables.V_INVENTARIO;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.lista.Proveedor;
import design.tabbedpane.TabbedPanelUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import dialogs.compras.DialogCategoriaMaterial;
import dialogs.compras.DialogMateriaPrima;
import dialogs.compras.DialogProductosAsociados;
import java.awt.Color;
import java.awt.Point;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
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
public class PanelInventario extends AnimatedPanel {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    DefaultListModel<Proveedor> modelo = new DefaultListModel<>();
    
    DefaultTableModel dtmCategorias;
    DefaultTableModel dtmInventario;
    
    boolean nuevaCategoria = false;

    public PanelInventario() {
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();
        dtmCategorias = (DefaultTableModel) tCategorias.getModel();
        dtmInventario = (DefaultTableModel) tInventario.getModel();
        dibujarTablas();
        cargarTablaCategorias();
        cargarTablaInventario();
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
        itemEliminarCat = new javax.swing.JMenuItem();
        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        chkBajoStock = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        chkBajas = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnEditar = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnBaja = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnReportes = new javax.swing.JButton();
        pTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pTabs = new javax.swing.JPanel();
        tpInventario = new javax.swing.JTabbedPane();
        pGestion = new javax.swing.JPanel();
        pTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tInventario = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCategorias = new javax.swing.JTable();

        itemEditar.setText("Editar Material");
        itemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarActionPerformed(evt);
            }
        });
        popInventario.add(itemEditar);

        itemBaja.setText("Baja Material");
        itemBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBajaActionPerformed(evt);
            }
        });
        popInventario.add(itemBaja);

        itemEditarCat.setText("Editar Categoria");
        itemEditarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarCatActionPerformed(evt);
            }
        });
        popCategoria.add(itemEditarCat);

        itemEliminarCat.setText("Eliminar Categoria");
        itemEliminarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarCatActionPerformed(evt);
            }
        });
        popCategoria.add(itemEliminarCat);

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

        chkBajoStock.setBackground(cBtnNormal);
        chkBajoStock.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chkBajoStock.setForeground(colorBG);
        chkBajoStock.setText(" Bajo Stock");
        chkBajoStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkBajoStock.setFocusable(false);
        chkBajoStock.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chkBajoStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Typicons_e0a8(1)_32.png"))); // NOI18N
        chkBajoStock.setMaximumSize(new java.awt.Dimension(120, 25));
        chkBajoStock.setMinimumSize(new java.awt.Dimension(120, 25));
        chkBajoStock.setPreferredSize(new java.awt.Dimension(120, 25));
        chkBajoStock.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Typicons_e08b(0)_32.png"))); // NOI18N
        chkBajoStock.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBajoStockItemStateChanged(evt);
            }
        });
        toolBarTabla1.add(chkBajoStock);
        toolBarTabla1.add(jSeparator1);

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
        toolBarTabla1.add(chkBajas);
        toolBarTabla1.add(jSeparator3);

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
        toolBarTabla1.add(jSeparator2);

        btnReportes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnReportes.setForeground(colorBG);
        btnReportes.setText("Reportes");
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pMain.add(toolBarTabla1, gridBagConstraints);

        pTitulo.setOpaque(false);
        pTitulo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(colorUI);
        jLabel1.setText("Inventario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/Inventory-maintenance64.png"))); // NOI18N
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

        tInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idinventario", "Codigo", "Nombre", "Categoria", "P. Compra", "Min", "Max", "Stock", "Medida", "Unidad", "baja"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tInventario.setComponentPopupMenu(popInventario);
        tInventario.setRowHeight(30);
        tInventario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tInventario.getTableHeader().setReorderingAllowed(false);
        tInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tInventarioMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tInventario);
        if (tInventario.getColumnModel().getColumnCount() > 0) {
            tInventario.getColumnModel().getColumn(0).setMinWidth(0);
            tInventario.getColumnModel().getColumn(0).setPreferredWidth(0);
            tInventario.getColumnModel().getColumn(0).setMaxWidth(0);
            tInventario.getColumnModel().getColumn(1).setMinWidth(65);
            tInventario.getColumnModel().getColumn(1).setPreferredWidth(65);
            tInventario.getColumnModel().getColumn(1).setMaxWidth(65);
            tInventario.getColumnModel().getColumn(3).setMinWidth(125);
            tInventario.getColumnModel().getColumn(3).setPreferredWidth(125);
            tInventario.getColumnModel().getColumn(3).setMaxWidth(125);
            tInventario.getColumnModel().getColumn(4).setMinWidth(100);
            tInventario.getColumnModel().getColumn(4).setPreferredWidth(100);
            tInventario.getColumnModel().getColumn(4).setMaxWidth(100);
            tInventario.getColumnModel().getColumn(5).setMinWidth(60);
            tInventario.getColumnModel().getColumn(5).setPreferredWidth(60);
            tInventario.getColumnModel().getColumn(5).setMaxWidth(60);
            tInventario.getColumnModel().getColumn(6).setMinWidth(60);
            tInventario.getColumnModel().getColumn(6).setPreferredWidth(60);
            tInventario.getColumnModel().getColumn(6).setMaxWidth(60);
            tInventario.getColumnModel().getColumn(7).setMinWidth(75);
            tInventario.getColumnModel().getColumn(7).setPreferredWidth(75);
            tInventario.getColumnModel().getColumn(7).setMaxWidth(75);
            tInventario.getColumnModel().getColumn(8).setMinWidth(85);
            tInventario.getColumnModel().getColumn(8).setPreferredWidth(85);
            tInventario.getColumnModel().getColumn(8).setMaxWidth(85);
            tInventario.getColumnModel().getColumn(9).setMinWidth(85);
            tInventario.getColumnModel().getColumn(9).setPreferredWidth(85);
            tInventario.getColumnModel().getColumn(9).setMaxWidth(85);
            tInventario.getColumnModel().getColumn(10).setMinWidth(0);
            tInventario.getColumnModel().getColumn(10).setPreferredWidth(0);
            tInventario.getColumnModel().getColumn(10).setMaxWidth(0);
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

        tpInventario.addTab("<html><body align=\\u005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005c\"center\\u005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005cu005c\">Gestión de<br>Inventario</body></html>", pGestion);

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
                "ID", "No.", "Categoria de Materia Prima", "Código de Categoria"
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

        tpInventario.addTab("<html><body align=\"center\">Gestión de<br>Categorias</body></html>", jPanel3);

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
            if(!chkBajas.isSelected()){
                if(tInventario.getRowCount()>0){
                    editarMaterial();
                }               
            }else{
                new Mensajes().mensajeAlert("No se pueden editar registros con baja!");
            }         
        }else{
            editarCategoria();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tInventarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tInventarioMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tInventario.rowAtPoint(point);
        tInventario.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tInventarioMousePressed

    private void itemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarActionPerformed
        // TODO add your handling code here:
        editarMaterial();
    }//GEN-LAST:event_itemEditarActionPerformed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        // TODO add your handling code here:
        switch(tpInventario.getSelectedIndex()){
            case 0:
                cargarTablaInventario();
                break;
            case 1:
                cargarTablaCategorias();
                break;
        }
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        switch(tpInventario.getSelectedIndex()){
            case 0:
                cargarTablaInventario();
                break;
            case 1:
                cargarTablaCategorias();
                break;
        }
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        if(tpInventario.getSelectedIndex() == 0){
            cargarDialogMaterial();
        }else{
            cargarDialogCategoria();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tpInventarioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpInventarioStateChanged
        // TODO add your handling code here: 
        cbxFiltro.removeAllItems();
        switch(tpInventario.getSelectedIndex()){
            case 0:
                cbxFiltro.addItem("Buscar todo");
                cbxFiltro.addItem("Codigo");
                cbxFiltro.addItem( "Nombre");
                cbxFiltro.addItem("Categoria");
                if(chkBajas.isSelected()){
                    btnBaja.setText("Alta");
                }else{
                    btnBaja.setText("Baja");
                }
                break;
            case 1:
                cbxFiltro.addItem("Buscar todo");
                cbxFiltro.addItem("Materia Prima");
                cbxFiltro.addItem( "Codigo");
                btnBaja.setText("Eliminar");
                break;
        }
    }//GEN-LAST:event_tpInventarioStateChanged

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        // TODO add your handling code here:
        if(tpInventario.getSelectedIndex()==0){
            if(chkBajas.isSelected()){
                altaMaterial();
            }else{
                bajaMaterial();
            }
        }else{
            eliminarCategoria();
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

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
        if(chkBajoStock.isSelected()){
            Reportes.reporteInventariosBajoStock();
        }else{
           Reportes.reporteInventarios(); 
        }        
    }//GEN-LAST:event_btnReportesActionPerformed

    private void chkBajoStockItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBajoStockItemStateChanged
        // TODO add your handling code here:
        cargarTablaInventario();
    }//GEN-LAST:event_chkBajoStockItemStateChanged

    private void itemBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBajaActionPerformed
        // TODO add your handling code here:
        if(chkBajas.isSelected()){
            altaMaterial();
        }else{
            bajaMaterial();
        }
    }//GEN-LAST:event_itemBajaActionPerformed

    private void chkBajasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBajasItemStateChanged
        // TODO add your handling code here:
        if(tpInventario.getSelectedIndex()==0){
            if(chkBajas.isSelected()){
                btnBaja.setText("Alta");
                itemBaja.setText("Alta Material");
            }else{
                btnBaja.setText("Baja");
                itemBaja.setText("Baja Material");
            }
        }
        cargarTablaInventario();
    }//GEN-LAST:event_chkBajasItemStateChanged

    private void itemEliminarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarCatActionPerformed
        // TODO add your handling code here:
        eliminarCategoria();
    }//GEN-LAST:event_itemEliminarCatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReportes;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JCheckBox chkBajas;
    private javax.swing.JCheckBox chkBajoStock;
    private javax.swing.JMenuItem itemBaja;
    private javax.swing.JMenuItem itemEditar;
    private javax.swing.JMenuItem itemEditarCat;
    private javax.swing.JMenuItem itemEliminarCat;
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
    private javax.swing.JToolBar.Separator jSeparator3;
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
    private javax.swing.JTable tInventario;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpInventario;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaCategorias(){
        int numero = 0;
        for(int i=0; i<tCategorias.getRowCount(); i++){
            dtmCategorias.removeRow(i);
            i-=1;
        }
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(CATEGORIA_INVENTARIO);
        Condition filtro;
        Condition conditionBajoStock;
        switch(cbxFiltro.getSelectedIndex()){
            case 1:
                filtro = CATEGORIA_INVENTARIO.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            case 2:
                filtro = CATEGORIA_INVENTARIO.DESCRIPCION.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            default:
                filtro = CATEGORIA_INVENTARIO.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%")
                        .or(CATEGORIA_INVENTARIO.DESCRIPCION.likeIgnoreCase("%"+txtFiltro.getText()+"%"));
                break;
        }
        query.addConditions(filtro);
        query.addOrderBy(CATEGORIA_INVENTARIO.NOMBRE.asc());
        Result<Record> result = query.fetch();
        for (Record r : result) {
            numero ++;
            Object[] row = {
                r.getValue(CATEGORIA_INVENTARIO.IDCATEGORIA),
                numero,
                r.getValue(CATEGORIA_INVENTARIO.NOMBRE),
                r.getValue(CATEGORIA_INVENTARIO.DESCRIPCION)
            };
            dtmCategorias.addRow(row);
        }
        
        if(tCategorias.getRowCount()>0){
            tCategorias.changeSelection(0, 1, false, false);
        }
    }
    
    private void cargarTablaInventario(){        
        try{
            for(int i=0; i<tInventario.getRowCount(); i++){
                dtmInventario.removeRow(i);
                i-=1;
            }
            SelectQuery<Record> query = create.selectQuery();
            query.addFrom(V_INVENTARIO);
            Condition filtro;
            Condition conditionBajoStock;
            Condition baja ;
            Condition conditionFinal;
            switch(cbxFiltro.getSelectedIndex()){
                case 1: 
                    filtro = V_INVENTARIO.CODIGO.likeIgnoreCase("%"+txtFiltro.getText()+"%"); 
                    break;
                case 2:
                    filtro = V_INVENTARIO.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                    break;
                case 3:
                    filtro = V_INVENTARIO.CATEGORIA.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                    break;
                default:
                    filtro = V_INVENTARIO.CATEGORIA.likeIgnoreCase("%"+txtFiltro.getText()+"%")
                            .or(V_INVENTARIO.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%"))
                            .or(V_INVENTARIO.CODIGO.likeIgnoreCase("%"+txtFiltro.getText()+"%"));
                    break;
            }
            if(chkBajoStock.isSelected()){
                conditionBajoStock = V_INVENTARIO.EXISTENCIA.lessThan(V_INVENTARIO.MINIMO);
                conditionFinal = conditionBajoStock.and(filtro);
            }else{
                conditionFinal = filtro;
            }
            if(chkBajas.isSelected()){
                baja = V_INVENTARIO.BAJA.equal(true);
            }else{
                baja = V_INVENTARIO.BAJA.equal(false);
            }
            query.addConditions(conditionFinal.and(baja));
            query.addOrderBy(V_INVENTARIO.CODIGO.asc());
            Result<Record> result = query.fetch();
            for (Record r : result){
                Object[] row = r.intoArray();
                dtmInventario.addRow(row);
            }
            if(tInventario.getRowCount()>0){
                tInventario.changeSelection(0, 1, false, false);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void limpiarFormCategoria(){
        /*txtNombreCategoria.setText("");
        txtCodigoCategoria.setText("");*/
    }
    
    private void dibujarTablas(){
        tInventario.setGridColor(colorUI);
        JTableHeader jtableHeader = tInventario.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tInventario.setTableHeader(  jtableHeader );
        
        
        tInventario.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tInventario.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tInventario.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tInventario.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tInventario.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("num",new Color(113, 205, 245)));
        tInventario.getColumnModel().getColumn(6).setCellRenderer(new CellRenderer("num",new Color(113, 205, 245)));
        tInventario.getColumnModel().getColumn(7).setCellRenderer(new CellRenderer("num",new Color(113, 205, 245)));
        tInventario.getColumnModel().getColumn(8).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tInventario.getColumnModel().getColumn(9).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tInventario.repaint();
        
        tCategorias.setGridColor(colorUI);
        JTableHeader headerCat = tCategorias.getTableHeader();
        headerCat.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tCategorias.setTableHeader(  headerCat );
        
        tCategorias.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tCategorias.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tCategorias.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        
        tCategorias.repaint();
    }
    
    private void cargarDialogMaterial(){
        DialogMateriaPrima dialog = new DialogMateriaPrima(new javax.swing.JFrame(), true, "inventario", "Nuevo Material");
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro agregado exitosamente");
            cargarTablaInventario();
        }
        dialog.dispose();
    }
    
    private void editarMaterial(){
        int idmaterial = (int)tInventario.getValueAt(tInventario.getSelectedRow(), 0);
        String categoria = (String)tInventario.getValueAt(tInventario.getSelectedRow(), 2);
        DialogMateriaPrima dialog = new DialogMateriaPrima(new javax.swing.JFrame(), true,"Editar Material",idmaterial,categoria);
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            cargarTablaInventario();          
            new Mensajes().mensajeInfo("Registro editado exitosamente");
        }
        dialog.dispose();
    }
    
    private void bajaMaterial(){
        int idmaterial = (int)tInventario.getValueAt(tInventario.getSelectedRow(), 0);
        double stock = (double) tInventario.getValueAt(tInventario.getSelectedRow(), 7);
        if(stock == 0){
            int r = new Mensajes().mensajeSiNo("Desea dar baja registro?");
            if(r==0){
                int numProductosAsociados = create.select(count())
                        .from(RECETA)
                        .where(RECETA.IDINVENTARIO.equal(idmaterial))
                        .fetchOne().getValue(count());
                if(numProductosAsociados>0){
                    /*mostrarLista*/
                    DialogProductosAsociados dialog = new DialogProductosAsociados(new javax.swing.JFrame(), true, "Productos Asociados", idmaterial);
                    dialog.setVisible(true);
                }else{
                    create.update(INVENTARIO)
                            .set(INVENTARIO.BAJA,true)
                            .where(INVENTARIO.IDINVENTARIO.equal(idmaterial))
                            .execute();
                    cargarTablaInventario();
                    eliminarReceta();
                }                
            }
        }else{
            new Mensajes().mensajeError("No se puede dar baja a material con Stock!");        
        }
    }
    
    private void altaMaterial(){
        int idmaterial = (int)tInventario.getValueAt(tInventario.getSelectedRow(), 0);
        create.update(INVENTARIO)
                    .set(INVENTARIO.BAJA,false)
                    .where(INVENTARIO.IDINVENTARIO.equal(idmaterial))
                    .execute();
        cargarTablaInventario();        

    }
    
    private void cargarDialogCategoria(){
        DialogCategoriaMaterial dialog = new DialogCategoriaMaterial(new javax.swing.JFrame(), true, "Nueva Categoria");
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro agregado exitosamente");
            cargarTablaCategorias();
        }
        dialog.dispose();
    }
    
    private void editarCategoria(){
        int idCat = (int) tCategorias.getValueAt(tCategorias.getSelectedRow(), 0);
        DialogCategoriaMaterial dialog = new DialogCategoriaMaterial(new javax.swing.JFrame(), true, "Editar Categoria", idCat);
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro editado exitosamente");
            cargarTablaCategorias();
        }
        dialog.dispose();
    }
    
    private void eliminarCategoria(){
        int idCat = (int) tCategorias.getValueAt(tCategorias.getSelectedRow(), 0);
        if(isVacia(idCat)){
            int r = new Mensajes().mensajeSiNo("Desea eliminar el registro?");
            if(r==0){
                create.delete(CATEGORIA_INVENTARIO)
                        .where(CATEGORIA_INVENTARIO.IDCATEGORIA.equal(idCat))
                        .execute();
                cargarTablaCategorias();
            } 
        }else{  
            new Mensajes().mensajeError("No se puede eliminar categoria con Materiales asignados!");
        }
    }
    
    private boolean isVacia(int id){
        int contador = 0;
        contador = create.select(count())
                .from(INVENTARIO)
                .where(INVENTARIO.IDCATEGORIA.equal(id))
                .fetchOne().getValue(count());
        return contador <= 0;
    }
    
    private void eliminarReceta(){
        /*String codigo = (String)tInventario.getValueAt(tInventario.getSelectedRow(), 0);
        create.delete(RECETA)
                .where(RECETA.CODIGO_INVENTARIO.equal(codigo))
                .execute();*/
    }
    
}
