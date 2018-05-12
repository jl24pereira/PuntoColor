
package panels.admon;

import clases.Mensajes;
import com.mrlonee.swing.animation.AnimatedPanel;
import static db.clases.Tables.CAJA;
import design.button.ButtonUI;
import design.tabbedpane.TabbedPanelUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import dialogs.admon.DialogCajas;
import java.awt.Color;
import java.awt.Point;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
public class PanelCajas extends AnimatedPanel {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    DefaultTableModel dtmCajas;
    
    boolean nuevaCategoria = false;

    public PanelCajas() {
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();
        dtmCajas = (DefaultTableModel) tCajas.getModel();
        dibujarTablas();
        cargarTablaCajas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popCaja = new javax.swing.JPopupMenu();
        itemEditarCaja = new javax.swing.JMenuItem();
        itemAltaCaja = new javax.swing.JMenuItem();
        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnEditar = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        pTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pTabs = new javax.swing.JPanel();
        tpInventario = new javax.swing.JTabbedPane();
        pGestion = new javax.swing.JPanel();
        pTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tCajas = new javax.swing.JTable();

        itemEditarCaja.setText("Editar Caja");
        itemEditarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarCajaActionPerformed(evt);
            }
        });
        popCaja.add(itemEditarCaja);

        itemAltaCaja.setText("Alta de Caja");
        itemAltaCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAltaCajaActionPerformed(evt);
            }
        });
        popCaja.add(itemAltaCaja);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pMain.add(toolBarTabla1, gridBagConstraints);

        pTitulo.setOpaque(false);
        pTitulo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(colorUI);
        jLabel1.setText("Cajas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/monitor.png"))); // NOI18N
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

        tCajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "No.", "Descripcion", "IP", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tCajas.setComponentPopupMenu(popCaja);
        tCajas.setRowHeight(30);
        tCajas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tCajas.getTableHeader().setReorderingAllowed(false);
        tCajas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tCajasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tCajas);
        if (tCajas.getColumnModel().getColumnCount() > 0) {
            tCajas.getColumnModel().getColumn(0).setMinWidth(0);
            tCajas.getColumnModel().getColumn(0).setPreferredWidth(0);
            tCajas.getColumnModel().getColumn(0).setMaxWidth(0);
            tCajas.getColumnModel().getColumn(1).setMinWidth(100);
            tCajas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tCajas.getColumnModel().getColumn(1).setMaxWidth(100);
            tCajas.getColumnModel().getColumn(3).setMinWidth(200);
            tCajas.getColumnModel().getColumn(3).setPreferredWidth(200);
            tCajas.getColumnModel().getColumn(3).setMaxWidth(200);
            tCajas.getColumnModel().getColumn(4).setMinWidth(200);
            tCajas.getColumnModel().getColumn(4).setPreferredWidth(200);
            tCajas.getColumnModel().getColumn(4).setMaxWidth(200);
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

        tpInventario.addTab("<html><body align=\"center\">Gestión de<br>Cajas</body></html>", pGestion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pTabs.add(tpInventario, gridBagConstraints);
        tpInventario.setUI(new TabbedPanelUI(colorUI,colorBG));
        tpInventario.getAccessibleContext().setAccessibleName("<html><body align=\"center\">Gestión de<br>Cajas</body></html>");

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
        editarCaja();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tCajasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tCajasMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tCajas.rowAtPoint(point);
        tCajas.setRowSelectionInterval(currentRow, currentRow);
        if((boolean) tCajas.getValueAt(tCajas.getSelectedRow(), 4)){
            itemAltaCaja.setText("Desactivar Caja");
        }else{
            itemAltaCaja.setText("Activar Caja");
        }
    }//GEN-LAST:event_tCajasMousePressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        nuevaCaja();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tpInventarioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpInventarioStateChanged
        // TODO add your handling code here:
        if(tpInventario.getSelectedIndex() == 0){
            
            //cargarDialogMaterial();
        }else{
            //cargarDialogCategoria();
        }
    }//GEN-LAST:event_tpInventarioStateChanged

    private void itemEditarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarCajaActionPerformed
        // TODO add your handling code here:
        editarCaja();
    }//GEN-LAST:event_itemEditarCajaActionPerformed

    private void itemAltaCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAltaCajaActionPerformed
        // TODO add your handling code here:
        cambiarEstadoCaja();
    }//GEN-LAST:event_itemAltaCajaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JMenuItem itemAltaCaja;
    private javax.swing.JMenuItem itemEditarCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JPanel pGestion;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTabla;
    private javax.swing.JPanel pTabs;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JPopupMenu popCaja;
    private javax.swing.JTable tCajas;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpInventario;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaCajas(){
        int numero = 0;
        for(int i=0; i<tCajas.getRowCount(); i++){
            dtmCajas.removeRow(i);
            i-=1;
        }
        
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(CAJA);
        //query.addConditions(filtro);
        query.addOrderBy(CAJA.DETALLE.asc());
        Result<Record> result = query.fetch();
        for (Record r : result) {
            numero ++;
            Object[] row = {
                r.getValue(CAJA.IDCAJA),
                numero,
                r.getValue(CAJA.DETALLE),
                r.getValue(CAJA.IPCAJA),
                r.getValue(CAJA.BAJA)
            };
            dtmCajas.addRow(row);
        }        
        if(tCajas.getRowCount()>0){
            tCajas.changeSelection(0, 1, false, false);
        }
    }
        
    private void dibujarTablas(){
        tCajas.setGridColor(colorUI);
        JTableHeader jtableHeader = tCajas.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tCajas.setTableHeader(  jtableHeader );
        
        
        tCajas.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tCajas.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tCajas.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tCajas.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tCajas.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("caja",new Color(113, 205, 245)));
        tCajas.repaint();
        
    }
    
    private void nuevaCaja(){
        DialogCajas dialog = new DialogCajas(new javax.swing.JFrame(), true, "Nueva Caja");
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro agregado exitosamente");
            cargarTablaCajas();
        }
        dialog.dispose();
    }
    
    private void editarCaja(){
        if(tCajas.getRowCount()>0){
            String ipcaja = (String)tCajas.getValueAt(tCajas.getSelectedRow(), 3);
            DialogCajas dialog = new DialogCajas(new javax.swing.JFrame(), true,"Editar Caja",ipcaja);
            dialog.setVisible(true);
            if(dialog.isGuardado()){
                cargarTablaCajas();    
                new Mensajes().mensajeInfo("Registro editado exitosamente");
            }
            dialog.dispose();
        }
    }
        
    private void cambiarEstadoCaja(){
        int idcaja = (int) tCajas.getValueAt(tCajas.getSelectedRow(), 0);
        if((boolean) tCajas.getValueAt(tCajas.getSelectedRow(), 4)){
            if(isOpen()){
                new Mensajes().mensajeAlert("No se puede desactivar, Caja abierta!");
            }else{
                create.update(CAJA)
                        .set(CAJA.BAJA,false)
                        .where(CAJA.IDCAJA.equal(idcaja))
                        .execute();
                cargarTablaCajas();
            }
        }else{
            create.update(CAJA)
                    .set(CAJA.BAJA,true)
                    .where(CAJA.IDCAJA.equal(idcaja))
                    .execute();  
            cargarTablaCajas();
        }
    }
    
    private boolean isOpen(){
        String ip = (String)tCajas.getValueAt(tCajas.getSelectedRow(), 3);
        boolean conectada = create.select(CAJA.ESTADO)
                .from(CAJA)
                .where(CAJA.IPCAJA.eq(ip))
                .fetchOne(CAJA.ESTADO,boolean.class);
        return conectada;
    }
    
}
