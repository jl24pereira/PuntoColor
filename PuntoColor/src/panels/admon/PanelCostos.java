
package panels.admon;

import clases.Mensajes;
import com.mrlonee.swing.animation.AnimatedPanel;
import static db.clases.Tables.CATEGORIA_INVENTARIO;
import static db.clases.Tables.GASTOS;
import static db.clases.Tables.V_COSTOS_EMPRESA;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.lista.Proveedor;
import design.tabbedpane.TabbedPanelUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import dialogs.admon.DialogCostos;
import dialogs.admon.DialogHorasTrabajo;
import java.awt.Color;
import java.awt.Point;
import java.math.BigDecimal;
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
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;

/*@author Jose Luis */
public class PanelCostos extends AnimatedPanel {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    DefaultListModel<Proveedor> modelo = new DefaultListModel<>();
    
    DefaultTableModel dtmCostos;
    
    boolean nuevaCategoria = false;

    public PanelCostos() {
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();
        dtmCostos = (DefaultTableModel) tCostos.getModel();
        dibujarTablas();
        cargarTablaCostos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popCosto = new javax.swing.JPopupMenu();
        itemAplicarCosto = new javax.swing.JMenuItem();
        itemEditarCat = new javax.swing.JMenuItem();
        itemEliminar = new javax.swing.JMenuItem();
        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        cbxFiltroCategoria = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltroCategoria = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnEditar = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnHorasTrabajo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnReporte = new javax.swing.JButton();
        pTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pTabs = new javax.swing.JPanel();
        tpInventario = new javax.swing.JTabbedPane();
        pGestion = new javax.swing.JPanel();
        pTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCostos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        itemAplicarCosto.setText("Aplicar a Producción");
        itemAplicarCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAplicarCostoActionPerformed(evt);
            }
        });
        popCosto.add(itemAplicarCosto);

        itemEditarCat.setText("Editar Costo");
        itemEditarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarCatActionPerformed(evt);
            }
        });
        popCosto.add(itemEditarCat);

        itemEliminar.setText("Eliminar Costo");
        itemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarActionPerformed(evt);
            }
        });
        popCosto.add(itemEliminar);

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

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setForeground(colorTexto);
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnEliminar);
        btnEliminar.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));
        toolBarTabla1.add(jSeparator1);

        btnHorasTrabajo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnHorasTrabajo.setForeground(colorTexto);
        btnHorasTrabajo.setText("Horas de Trabajo");
        btnHorasTrabajo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHorasTrabajo.setFocusable(false);
        btnHorasTrabajo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHorasTrabajo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHorasTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorasTrabajoActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnHorasTrabajo);
        btnHorasTrabajo.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));
        toolBarTabla1.add(jSeparator2);

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
        jLabel1.setText("Costos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/wallet.png"))); // NOI18N
        jLabel6.setRequestFocusEnabled(false);
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

        pGestion.setBackground(colorBG);
        pGestion.setForeground(new java.awt.Color(153, 153, 0));
        pGestion.setLayout(new java.awt.GridBagLayout());

        pTabla.setMinimumSize(new java.awt.Dimension(300, 100));
        pTabla.setOpaque(false);
        pTabla.setPreferredSize(new java.awt.Dimension(450, 100));
        pTabla.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setOpaque(false);

        tCostos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "No.", "Rubro", "Costo", "Aplica Prod"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tCostos.setComponentPopupMenu(popCosto);
        tCostos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tCostos.setRowHeight(30);
        tCostos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tCostos.getTableHeader().setReorderingAllowed(false);
        tCostos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tCostosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tCostos);
        if (tCostos.getColumnModel().getColumnCount() > 0) {
            tCostos.getColumnModel().getColumn(0).setMinWidth(0);
            tCostos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tCostos.getColumnModel().getColumn(0).setMaxWidth(0);
            tCostos.getColumnModel().getColumn(1).setMinWidth(100);
            tCostos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tCostos.getColumnModel().getColumn(1).setMaxWidth(100);
            tCostos.getColumnModel().getColumn(3).setMinWidth(100);
            tCostos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tCostos.getColumnModel().getColumn(3).setMaxWidth(100);
            tCostos.getColumnModel().getColumn(4).setMinWidth(150);
            tCostos.getColumnModel().getColumn(4).setPreferredWidth(150);
            tCostos.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pTabla.add(jScrollPane1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("TOTAL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pTabla.add(jLabel2, gridBagConstraints);

        lblTotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTotal.setText("0.00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 15);
        pTabla.add(lblTotal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pGestion.add(pTabla, gridBagConstraints);

        tpInventario.addTab("<html><body align=\"center\">Gestión de<br>Costos</body></html>", pGestion);

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
            editarCosto();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void cbxFiltroCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroCategoriaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroCategoriaItemStateChanged

    private void txtFiltroCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroCategoriaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroCategoriaKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        if(tpInventario.getSelectedIndex() == 0){
            nuevoCosto();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:        
        eliminarCosto();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void itemEditarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarCatActionPerformed
        // TODO add your handling code here:
        editarCosto();
    }//GEN-LAST:event_itemEditarCatActionPerformed

    private void tCostosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tCostosMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tCostos.rowAtPoint(point);
        tCostos.setRowSelectionInterval(currentRow, currentRow);
        if((boolean) tCostos.getValueAt(tCostos.getSelectedRow(), 4)){
            itemAplicarCosto.setText("Quitar Costo");
        }else{
            itemAplicarCosto.setText("Aplicar Costo");
        }
    }//GEN-LAST:event_tCostosMousePressed

    private void itemAplicarCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAplicarCostoActionPerformed
        // TODO add your handling code here:
        aplicarCosto();
    }//GEN-LAST:event_itemAplicarCostoActionPerformed

    private void btnHorasTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorasTrabajoActionPerformed
        // TODO add your handling code here:
        DialogHorasTrabajo dialog = new DialogHorasTrabajo(new javax.swing.JFrame(), true, "Horas de Trabajo Semanaless");
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro editado exitosamente");
            cargarTablaCostos();
        }
        dialog.dispose();
    }//GEN-LAST:event_btnHorasTrabajoActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        Reportes.Reportes.reporteCostos();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void itemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarActionPerformed
        // TODO add your handling code here:
        eliminarCosto();
    }//GEN-LAST:event_itemEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnHorasTrabajo;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbxFiltroCategoria;
    private javax.swing.JMenuItem itemAplicarCosto;
    private javax.swing.JMenuItem itemEditarCat;
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pGestion;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTabla;
    private javax.swing.JPanel pTabs;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JPopupMenu popCosto;
    private javax.swing.JTable tCostos;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpInventario;
    private javax.swing.JTextField txtFiltroCategoria;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaCostos(){
        int numero = 0;
        double sumatoria = 0.00;
        for(int i=0; i<tCostos.getRowCount(); i++){
            dtmCostos.removeRow(i);
            i-=1;
        }
        
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(V_COSTOS_EMPRESA);
        Condition filtro;
        switch(cbxFiltroCategoria.getSelectedIndex()){
            case 1:
                filtro = CATEGORIA_INVENTARIO.NOMBRE.like("%"+txtFiltroCategoria.getText()+"%");
                break;
            case 2:
                break;
            default:
                break;
        }
        //query.addConditions(filtro);
        query.addOrderBy(V_COSTOS_EMPRESA.DETALLE.asc());
        Result<Record> result = query.fetch();
        for (Record r : result) {
            numero ++;
            Object[] row = {
                r.getValue(V_COSTOS_EMPRESA.IDGASTO),
                numero,
                r.getValue(V_COSTOS_EMPRESA.DETALLE),
                r.getValue(V_COSTOS_EMPRESA.GASTO),
                r.getValue(V_COSTOS_EMPRESA.APLICA)
            };
            BigDecimal costeo = r.getValue(V_COSTOS_EMPRESA.GASTO);
            double costo = costeo.doubleValue();
            sumatoria = sumatoria+costo;
            dtmCostos.addRow(row);
        }
        String total = String.format("%.2f", sumatoria);
        lblTotal.setText("$ "+total);
        
        if(tCostos.getRowCount()>0){
            tCostos.changeSelection(0, 1, false, false);
        }
    } 
    
    private void dibujarTablas(){
        tCostos.setGridColor(colorUI);
        
        JTableHeader jtableHeader = tCostos.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tCostos.setTableHeader(  jtableHeader );
        
        
        tCostos.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tCostos.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tCostos.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tCostos.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tCostos.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("booleano",new Color(113, 205, 245)));
        tCostos.repaint();
        
    }
    
    private void nuevoCosto(){
        DialogCostos dialog = new DialogCostos(new javax.swing.JFrame(), true, "Nuevo Costo");
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro agregado exitosamente");
            cargarTablaCostos();
        }
        dialog.dispose();
    }
    
    private void editarCosto(){
        int idCosto = (int) tCostos.getValueAt(tCostos.getSelectedRow(), 0);
        DialogCostos dialog = new DialogCostos(new javax.swing.JFrame(), true, "Editar Categoria", idCosto);
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro editado exitosamente");
            cargarTablaCostos();
        }
        dialog.dispose();
    }
    
    private void aplicarCosto(){
        int idCosto = (int) tCostos.getValueAt(tCostos.getSelectedRow(), 0);
        BigDecimal costo = (BigDecimal) tCostos.getValueAt(tCostos.getSelectedRow(), 3);
        if(costo.doubleValue()>=15){
            if((boolean) tCostos.getValueAt(tCostos.getSelectedRow(), 4)){
                create.update(GASTOS)
                        .set(GASTOS.APLICA,false)
                        .where(GASTOS.IDGASTO.equal(idCosto))
                        .execute();
            }else{
                create.update(GASTOS)
                        .set(GASTOS.APLICA,true)
                        .where(GASTOS.IDGASTO.equal(idCosto))
                        .execute();
            }
            cargarTablaCostos();
        }else{
            JOptionPane.showMessageDialog(null, "Costo demasiado bajo para aplicar a producción");
        }
    }

    private void eliminarCosto() {
        int r = new Mensajes().mensajeSiNo("Desea eliminar el registro?");
        int idCosto = (int) tCostos.getValueAt(tCostos.getSelectedRow(), 0);        
        if(r==0){
            create.delete(GASTOS)
                    .where(GASTOS.IDGASTO.equal(idCosto))
                    .execute();
            cargarTablaCostos();
        }
    }
    
}
