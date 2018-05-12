package panels.disenio;

import clases.Fechero;
import com.mrlonee.swing.animation.AnimatedPanel;
import static db.clases.Tables.DETALLE_PEDIDO;
import static db.clases.Tables.EMPRESA;
import static db.clases.Tables.INVENTARIO;
import static db.clases.Tables.PEDIDO;
import static db.clases.Tables.PEDIDO_DISENIO;
import static db.clases.Tables.PRODUCTO;
import static db.clases.Tables.RECETA;
import static db.clases.Tables.UNIDAD_MEDIDA;
import static db.clases.Tables.V_MEDIDAS;
import static db.clases.Tables.V_MIPEDIDO;
import static db.clases.Tables.V_PEDIDOS;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.lista.Proveedor;
import design.tabbedpane.TabbedPanelUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import static puntocolor.Principal.database;
import javax.swing.table.JTableHeader;
import org.jooq.Condition;
import static org.jooq.impl.DSL.count;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.permisos;
import static puntocolor.Principal.ue;

/*@author Jose Luis */
public class PanelPedidosDisenio extends AnimatedPanel implements Runnable {

    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    DefaultListModel<Proveedor> modelo = new DefaultListModel<>();

    DefaultTableModel dtmPedidos;
    DefaultTableModel dtmMisPedidos;

    boolean corriendo = false;
    boolean iniciar = true;
    Thread hilo;

    public PanelPedidosDisenio() {
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();
        dtmPedidos = (DefaultTableModel) tPedidos.getModel();
        dtmMisPedidos = (DefaultTableModel) tMisPedidos.getModel();
        dibujarTablas();
        cargarTablaPedidos();
        cargarMisPedidos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popPedidos = new javax.swing.JPopupMenu();
        itemAsignarme = new javax.swing.JMenuItem();
        popMisPedidos = new javax.swing.JPopupMenu();
        itemAbrir = new javax.swing.JMenuItem();
        itemFinalizar = new javax.swing.JMenuItem();
        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnActualizar = new javax.swing.JButton();
        pTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pTabs = new javax.swing.JPanel();
        tpPedidos = new javax.swing.JTabbedPane();
        pGestion = new javax.swing.JPanel();
        pTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tPedidos = new javax.swing.JTable();
        pGestion1 = new javax.swing.JPanel();
        pTabla1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tMisPedidos = new javax.swing.JTable();

        itemAsignarme.setText("Asignarme Pedido");
        itemAsignarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAsignarmeActionPerformed(evt);
            }
        });
        popPedidos.add(itemAsignarme);

        itemAbrir.setText("Abrir Carpeta de Diseño");
        itemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirActionPerformed(evt);
            }
        });
        popMisPedidos.add(itemAbrir);

        itemFinalizar.setText("Finalizar Pedido");
        itemFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFinalizarActionPerformed(evt);
            }
        });
        popMisPedidos.add(itemFinalizar);

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                formAncestorRemoved(evt);
            }
        });
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
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar todo", "Número", "Fecha" }));
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

        btnActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnActualizar.setForeground(colorTexto);
        btnActualizar.setText("Actualizar Pedidos");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setFocusable(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnActualizar);
        btnActualizar.setUI(new ButtonUI(
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
        jLabel1.setText("Pedidos en Diseño");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/Tools2-64.png"))); // NOI18N
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

        tpPedidos.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tpPedidos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tpPedidos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tpPedidosStateChanged(evt);
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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "No.", "Fecha", "Detalle", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tPedidos.setComponentPopupMenu(popPedidos);
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
            tPedidos.getColumnModel().getColumn(0).setMinWidth(0);
            tPedidos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tPedidos.getColumnModel().getColumn(0).setMaxWidth(0);
            tPedidos.getColumnModel().getColumn(1).setMinWidth(100);
            tPedidos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tPedidos.getColumnModel().getColumn(1).setMaxWidth(100);
            tPedidos.getColumnModel().getColumn(2).setMinWidth(100);
            tPedidos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tPedidos.getColumnModel().getColumn(2).setMaxWidth(100);
            tPedidos.getColumnModel().getColumn(4).setMinWidth(150);
            tPedidos.getColumnModel().getColumn(4).setPreferredWidth(150);
            tPedidos.getColumnModel().getColumn(4).setMaxWidth(150);
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

        tpPedidos.addTab("<html><body align=\"center\">Gestión de<br>Pedidos</body></html>", pGestion);

        pGestion1.setBackground(colorBG);
        pGestion1.setForeground(new java.awt.Color(153, 153, 0));
        pGestion1.setLayout(new java.awt.GridBagLayout());

        pTabla1.setMinimumSize(new java.awt.Dimension(300, 100));
        pTabla1.setOpaque(false);
        pTabla1.setPreferredSize(new java.awt.Dimension(450, 100));
        pTabla1.setLayout(new java.awt.GridBagLayout());

        tMisPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "No.", "Fecha", "Detalle"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tMisPedidos.setComponentPopupMenu(popMisPedidos);
        tMisPedidos.setRowHeight(30);
        tMisPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tMisPedidos.getTableHeader().setReorderingAllowed(false);
        tMisPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tMisPedidosMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tMisPedidos);
        if (tMisPedidos.getColumnModel().getColumnCount() > 0) {
            tMisPedidos.getColumnModel().getColumn(0).setMinWidth(0);
            tMisPedidos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tMisPedidos.getColumnModel().getColumn(0).setMaxWidth(0);
            tMisPedidos.getColumnModel().getColumn(1).setMinWidth(100);
            tMisPedidos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tMisPedidos.getColumnModel().getColumn(1).setMaxWidth(100);
            tMisPedidos.getColumnModel().getColumn(2).setMinWidth(100);
            tMisPedidos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tMisPedidos.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pTabla1.add(jScrollPane3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pGestion1.add(pTabla1, gridBagConstraints);

        tpPedidos.addTab("<html><body align=\"center\">Mis Pedidos<br>en Diseño</body></html>", pGestion1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pTabs.add(tpPedidos, gridBagConstraints);
        tpPedidos.setUI(new TabbedPanelUI(colorUI,colorBG));

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
        //itemAsignarPedido.setEnabled(permisos.isCONFIGURACIONES());
        String estado = (String) tPedidos.getValueAt(tPedidos.getSelectedRow(), 4);
        if (estado.equals("DISEÑO")) {
            itemAsignarme.setEnabled(false);
        } else {
            itemAsignarme.setEnabled(true);
        }
    }//GEN-LAST:event_tPedidosMousePressed

    private void itemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirActionPerformed
        // TODO add your handling code here:
        //editarProducto();\
        Runtime r = Runtime.getRuntime();
        Process p = null;
        String pedido = (String) tMisPedidos.getValueAt(tMisPedidos.getSelectedRow(), 1);
        String nombre = create
                .select(V_PEDIDOS.NOMBRECLIENTE)
                .from(V_PEDIDOS)
                .where(V_PEDIDOS.NUMERO.equal(pedido))
                .fetchOne(V_PEDIDOS.NOMBRECLIENTE, String.class);
        String path = create.select(EMPRESA.PATH)
                .from(EMPRESA)
                .fetchOne(EMPRESA.PATH, String.class);
        try {
            p = r.exec("explorer.exe " + path + "\\" + pedido + " - " + nombre);
        } catch (IOException ex) {
            Logger.getLogger(PanelPedidosDisenio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemAbrirActionPerformed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        cargarTablaPedidos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tpPedidosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpPedidosStateChanged
        // TODO add your handling code here:
        if (tpPedidos.getSelectedIndex() == 0) {

            //cargarDialogMaterial();
        } else {
            //cargarDialogCategoria();
        }
    }//GEN-LAST:event_tpPedidosStateChanged

    private void itemAsignarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAsignarmeActionPerformed
        // TODO add your handling code here:
        int idpedido = (int) tPedidos.getValueAt(tPedidos.getSelectedRow(), 0);
        create.insertInto(PEDIDO_DISENIO)
                .set(PEDIDO_DISENIO.IDEMPLEADO, ue.getIdempleado())
                .set(PEDIDO_DISENIO.IDPEDIDO, idpedido)
                .execute();
        create.update(PEDIDO)
                .set(PEDIDO.ESTADO, "DISEÑO")
                .where(PEDIDO.IDPEDIDO.equal(idpedido))
                .execute();
        cargarTablaPedidos();
        cargarMisPedidos();
    }//GEN-LAST:event_itemAsignarmeActionPerformed

    private void tMisPedidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMisPedidosMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tMisPedidosMousePressed

    private void itemFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFinalizarActionPerformed
        // TODO add your handling code here:
        int idpedido = (int) tMisPedidos.getValueAt(tMisPedidos.getSelectedRow(), 0);
        create.update(PEDIDO)
                .set(PEDIDO.ESTADO, "PRODUCCION")
                .where(PEDIDO.IDPEDIDO.equal(idpedido))
                .execute();
        descontarInventario();
        cargarTablaPedidos();
        cargarMisPedidos();
    }//GEN-LAST:event_itemFinalizarActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
        iniciarBusqueda();
    }//GEN-LAST:event_formAncestorAdded

    private void formAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorRemoved
        // TODO add your handling code here:
        finalizarBusqueda();
    }//GEN-LAST:event_formAncestorRemoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JMenuItem itemAbrir;
    private javax.swing.JMenuItem itemAsignarme;
    private javax.swing.JMenuItem itemFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JPanel pGestion;
    private javax.swing.JPanel pGestion1;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTabla;
    private javax.swing.JPanel pTabla1;
    private javax.swing.JPanel pTabs;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JPopupMenu popMisPedidos;
    private javax.swing.JPopupMenu popPedidos;
    private javax.swing.JTable tMisPedidos;
    private javax.swing.JTable tPedidos;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpPedidos;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaPedidos() {
        for (int i = 0; i < tPedidos.getRowCount(); i++) {
            dtmPedidos.removeRow(i);
            i -= 1;
        }
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(V_PEDIDOS);
        query.addConditions(V_PEDIDOS.ESTADO.equal("ESPERA").or(V_PEDIDOS.ESTADO.equal("DISEÑO")));
        Condition filtro;
        if (tpPedidos.getSelectedIndex() == 0) {

        }
        query.addOrderBy(V_PEDIDOS.FECHA.asc());
        query.addOrderBy(V_PEDIDOS.NUMERO.asc());
        Result<Record> result = query.fetch();
        for (Record r : result) {
            Object[] row = {
                r.getValue(V_PEDIDOS.IDPEDIDO),
                r.getValue(V_PEDIDOS.NUMERO),
                Fechero.baseToReal(r.getValue(V_PEDIDOS.FECHA)),
                r.getValue(V_PEDIDOS.COMENTARIOS),
                r.getValue(V_PEDIDOS.ESTADO)
            };
            dtmPedidos.addRow(row);
        }
        if (tPedidos.getRowCount() > 0) {
            tPedidos.changeSelection(0, 1, false, false);
        }
    }

    private void cargarMisPedidos() {
        for (int i = 0; i < tMisPedidos.getRowCount(); i++) {
            dtmMisPedidos.removeRow(i);
            i -= 1;
        }
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(V_MIPEDIDO);
        query.addConditions((V_MIPEDIDO.ESTADO.equal("DISEÑO")).and(V_MIPEDIDO.IDEMPLEADO.eq(ue.getIdempleado())));
        query.addOrderBy(V_MIPEDIDO.FECHA.asc());
        query.addOrderBy(V_MIPEDIDO.NUMERO.asc());
        Result<Record> result = query.fetch();
        for (Record r : result) {
            Object[] row = {
                r.getValue(V_MIPEDIDO.IDPEDIDO),
                r.getValue(V_MIPEDIDO.NUMERO),
                Fechero.baseToReal(r.getValue(V_MIPEDIDO.FECHA)),
                r.getValue(V_MIPEDIDO.COMENTARIOS)
            };
            dtmMisPedidos.addRow(row);
        }
        if (tMisPedidos.getRowCount() > 0) {
            tMisPedidos.changeSelection(0, 1, false, false);
        }
    }

    private void dibujarTablas() {
        tPedidos.setGridColor(colorUI);
        JTableHeader jtableHeader = tPedidos.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tPedidos.setTableHeader(jtableHeader);

        tPedidos.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center", new Color(113, 205, 245)));
        tPedidos.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text center", new Color(113, 205, 245)));
        tPedidos.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));
        tPedidos.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("pedido", new Color(113, 205, 245)));
        tPedidos.repaint();

        tMisPedidos.setGridColor(colorUI);
        JTableHeader hMiPedido = tMisPedidos.getTableHeader();
        hMiPedido.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tMisPedidos.setTableHeader(hMiPedido);

        tMisPedidos.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center", new Color(113, 205, 245)));
        tMisPedidos.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text center", new Color(113, 205, 245)));
        tMisPedidos.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));
        tMisPedidos.repaint();

    }

    @Override
    public void run() {
        Thread.currentThread().setName("Busqueda Disenios");
        System.out.println("Inicia Hilo: " + Thread.currentThread().getName());
        while (corriendo) {
            try {
                Thread.sleep(1000 * 60 * 3);
                if (!corriendo) {
                    break;
                }
                System.out.println("Hilo: " + Thread.currentThread().getName() + " Buscando...");
                cargarTablaPedidos();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("finaliza Hilo: " + Thread.currentThread().getName());
    }

    private void iniciarBusqueda() {
        if (!corriendo) {
            corriendo = true;
            iniciar = true;
            arrancarBusqueda();
        }
    }

    private void finalizarBusqueda() {
        corriendo = false;
        iniciar = false;
        hilo.interrupt();
    }

    private void arrancarBusqueda() {
        if (iniciar) {
            hilo = new Thread(this);
            hilo.start();
        }
    }

    private void descontarInventario() {
        int idpedido = (int) tMisPedidos.getValueAt(tMisPedidos.getSelectedRow(), 0);
        int contadorMinimos = 0;
        ArrayList<String> enMinimos = new ArrayList<String>();
        /*int contadorProductos = create.select(count()).
                from(DETALLE_PEDIDO).
                where(DETALLE_PEDIDO.IDPEDIDO.equal(idpedido)).
                fetchOne().getValue(count());*/
        int productosDescontado = 0;
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(DETALLE_PEDIDO);
        query.addConditions(DETALLE_PEDIDO.IDPEDIDO.equal(idpedido));
        Result<Record> resPedido = query.fetch();
        System.out.println("El pedido es: " + idpedido);
        for (Record recPedido : resPedido) {
            SelectQuery<Record> queryProducto = create.selectQuery();
            queryProducto.addFrom(PRODUCTO);
            queryProducto.addConditions(PRODUCTO.IDPRODUCTO.equal(recPedido.getValue(DETALLE_PEDIDO.IDPRODUCTO)));
            Result<Record> resProducto = queryProducto.fetch();
            System.out.println("EL PEDIDO TIENE: " + recPedido.getValue(DETALLE_PEDIDO.IDPRODUCTO));
            for (Record recProducto : resProducto) {
                if (recProducto.getValue(PRODUCTO.TERMINA).equals("Diseño")) {
                    System.out.println("EL PRODUCTO TERMINA EN DISENIO");
                    /*descontar de inventario todos los materiales*/
                    SelectQuery<Record> queryReceta = create.selectQuery();
                    queryReceta.addFrom(RECETA);
                    queryReceta.addConditions(RECETA.IDPRODUCTO.equal(recProducto.getValue(PRODUCTO.IDPRODUCTO)));
                    Result<Record> resReceta = queryReceta.fetch();
                    for (Record recReceta : resReceta) {
                        System.out.println("MATERIAL ES: " + recReceta.getValue(RECETA.IDINVENTARIO));
                        System.out.println("Cantidad de producto = " + recPedido.getValue(DETALLE_PEDIDO.CANTIDAD));

                        SelectQuery<Record> queryMaterial;
                        System.out.println("Descuento de receta es: " + recReceta.getValue(RECETA.DESCARGO));
                        System.out.println("UN. MEDIDA EN DESCUENTO ES: " + recReceta.getValue(RECETA.IDUNIDAD));
                        double descuento = transformarMaterial(recReceta.getValue(RECETA.IDINVENTARIO), recReceta.getValue(RECETA.IDUNIDAD), recReceta.getValue(RECETA.DESCARGO));
                        Record material = create.select()
                                .from(INVENTARIO)
                                .where(INVENTARIO.IDINVENTARIO.equal(recReceta.getValue(RECETA.IDINVENTARIO)))
                                .fetchOne();
                        double enInventario = material.getValue(INVENTARIO.EXISTENCIA);
                        double minimos = material.getValue(INVENTARIO.MINIMO);
                        double descuentoInventario = 0;
                        if (recPedido.getValue(DETALLE_PEDIDO.ESPECIAL)) {
                            System.out.println("QUIERO DESCONTAR: " + (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD) * (recPedido.getValue(DETALLE_PEDIDO.ANCHO)
                                    * recPedido.getValue(DETALLE_PEDIDO.LARGO))));
                            descuentoInventario = (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD) * (recPedido.getValue(DETALLE_PEDIDO.ANCHO)
                                    * recPedido.getValue(DETALLE_PEDIDO.LARGO)));
                        } else {
                            System.out.println("QUIERO DESCONTAR: " + (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD)));
                            descuentoInventario = (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD));
                        }
                        System.out.println("EN INVENTARIO TENGO: " + enInventario);

                        System.out.println("QUEDARA: " + (enInventario - (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD))));

                        //descuentoInventario = (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD));
                        double existencia = enInventario - descuentoInventario;
                        create.update(INVENTARIO)
                                .set(INVENTARIO.EXISTENCIA, existencia)
                                .where(INVENTARIO.IDINVENTARIO.equal(recReceta.getValue(RECETA.IDINVENTARIO)))
                                .execute();
                        if (existencia < minimos) {
                            enMinimos.add(material.getValue(INVENTARIO.NOMBRE));
                            contadorMinimos++;
                        }
                    }
                    productosDescontado++;
                } else {
                    System.out.println("EL PRODUCTO TERMINA EN PRODUCCION");
                    /*descontar los materiales que van en diseño*/
                    SelectQuery<Record> queryReceta = create.selectQuery();
                    queryReceta.addFrom(RECETA);
                    queryReceta.addConditions(RECETA.IDPRODUCTO.equal(recProducto.getValue(PRODUCTO.IDPRODUCTO))
                            .and(RECETA.DESCONTAREN.equal("DISEÑO")));
                    Result<Record> resReceta = queryReceta.fetch();
                    for (Record recReceta : resReceta) {
                        System.out.println("MATERIAL ES: " + recReceta.getValue(RECETA.IDINVENTARIO));
                        System.out.println("Cantidad de producto = " + recPedido.getValue(DETALLE_PEDIDO.CANTIDAD));
                        SelectQuery<Record> queryMaterial;
                        System.out.println("Descuento de receta es: " + recReceta.getValue(RECETA.DESCARGO));
                        System.out.println("UN. MEDIDA EN DESCUENTO ES: " + recReceta.getValue(RECETA.IDUNIDAD));
                        double descuento = transformarMaterial(recReceta.getValue(RECETA.IDINVENTARIO), recReceta.getValue(RECETA.IDUNIDAD), recReceta.getValue(RECETA.DESCARGO));
                        Record material = create.select()
                                .from(INVENTARIO)
                                .where(INVENTARIO.IDINVENTARIO.equal(recReceta.getValue(RECETA.IDINVENTARIO)))
                                .fetchOne();
                        double enInventario = material.getValue(INVENTARIO.EXISTENCIA);
                        double minimos = material.getValue(INVENTARIO.MINIMO);
                        System.out.println("EN INVENTARIO TENGO: " + enInventario);
                        System.out.println("QUIERO DESCONTAR: " + (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD)));
                        System.out.println("QUEDARA: " + (enInventario - (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD))));
                        double descuentoInventario = 0;
                        if (recPedido.getValue(DETALLE_PEDIDO.ESPECIAL)) {
                            System.out.println("QUIERO DESCONTAR: " + (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD) * (recPedido.getValue(DETALLE_PEDIDO.ANCHO)
                                    * recPedido.getValue(DETALLE_PEDIDO.LARGO))));
                            descuentoInventario = (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD) * (recPedido.getValue(DETALLE_PEDIDO.ANCHO)
                                    * recPedido.getValue(DETALLE_PEDIDO.LARGO)));
                        } else {
                            System.out.println("QUIERO DESCONTAR: " + (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD)));
                            descuentoInventario = (descuento * recPedido.getValue(DETALLE_PEDIDO.CANTIDAD));
                        }
                        double existencia = enInventario - descuentoInventario;
                        create.update(INVENTARIO)
                                .set(INVENTARIO.EXISTENCIA, existencia)
                                .where(INVENTARIO.IDINVENTARIO.equal(recReceta.getValue(RECETA.IDINVENTARIO)))
                                .execute();
                        if (existencia < minimos) {
                            enMinimos.add(material.getValue(INVENTARIO.NOMBRE));
                            contadorMinimos++;
                        }
                    }
                }
            }
        }
        int cantidadProductosEnPedido = create.select(count())
                .from(DETALLE_PEDIDO)
                .where(DETALLE_PEDIDO.IDPEDIDO.equal(idpedido))
                .fetchOne().getValue(count());
        if (cantidadProductosEnPedido == productosDescontado) {

            create.update(PEDIDO)
                    .set(PEDIDO.ESTADO, "FINALIZADO")
                    .where(PEDIDO.IDPEDIDO.equal(idpedido))
                    .execute();
        }
        /*if(!enMinimos.isEmpty()){
            JList list = new JList(enMinimos.toArray());
            JPanel panelx = new JPanel();
            panelx.add(list);
            JOptionPane.showMessageDialog(null, panelx);
        }*/
    }

    private double transformarMaterial(int idmaterial, int unMedidaReceta, double descargoReceta) {

        Record r = create
                .select(INVENTARIO.IDUNIDAD)
                .from(INVENTARIO)
                .where(INVENTARIO.IDINVENTARIO.equal(idmaterial))
                .fetchOne();

        int unMedidaMaterial = r.getValue(INVENTARIO.IDUNIDAD);

        Record medidasMaterial = create
                .select()
                .from(V_MEDIDAS)
                .where(V_MEDIDAS.IDUNIDAD.equal(unMedidaMaterial))
                .fetchOne();

        double eqHijoMaterial = medidasMaterial.getValue(V_MEDIDAS.EQUIVALENCIA);
        double eqPadreMaterial = medidasMaterial.getValue(V_MEDIDAS.EQUIVALENCIAPADRE);
        int idHijoMaterial = medidasMaterial.getValue(V_MEDIDAS.IDUNIDAD);
        int idPadreMaterial = medidasMaterial.getValue(V_MEDIDAS.UNIDADPADRE);

        Record medidasReceta = create
                .select()
                .from(V_MEDIDAS)
                .where(V_MEDIDAS.IDUNIDAD.equal(unMedidaReceta))
                .fetchOne();

        double eqHijoReceta = medidasReceta.getValue(V_MEDIDAS.EQUIVALENCIA);
        double eqPadreReceta = medidasReceta.getValue(V_MEDIDAS.EQUIVALENCIAPADRE);
        int idHijoReceta = medidasReceta.getValue(V_MEDIDAS.IDUNIDAD);
        int idPadreReceta = medidasReceta.getValue(V_MEDIDAS.UNIDADPADRE);

        if (unMedidaMaterial == unMedidaReceta) {
            System.out.println("DESCUENTA LO MISMO: " + descargoReceta);
            return descargoReceta;
        } else {
            if (idPadreMaterial == idHijoReceta) {
                return eqHijoMaterial;
            } else if (idPadreReceta == idHijoMaterial) {
                return eqHijoReceta;
            } else {
                return (descargoReceta * eqHijoReceta) / eqHijoMaterial;
            }
        }
    }
}
