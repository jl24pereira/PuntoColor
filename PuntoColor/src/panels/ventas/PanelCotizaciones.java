
package panels.ventas;

import clases.Fechero;
import com.mrlonee.swing.animation.AnimatedPanel;
import static db.clases.Tables.V_COTIZACION;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.lista.Proveedor;
import design.tabbedpane.TabbedPanelUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import dialogs.ventas.DialogCotizacion;
import dialogs.ventas.DialogCotizacionAPedido;
import java.awt.Color;
import java.awt.Point;
import java.sql.SQLException;
import java.util.Date;
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
import javax.swing.table.JTableHeader;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;

/*@author Jose Luis */
public class PanelCotizaciones extends AnimatedPanel {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    DefaultListModel<Proveedor> modelo = new DefaultListModel<>();
    
    DefaultTableModel dtmCotizaciones;
    DefaultTableModel dtmProductos;
    
    boolean nuevaCategoria = false;

    public PanelCotizaciones() {
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();
        dtmCotizaciones = (DefaultTableModel) tCotizaciones.getModel();
        dibujarTablas();
        cargarTablaCotizaciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMenu1 = new javax.swing.JMenu();
        itemCancelar = new javax.swing.JMenuItem();
        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        txtFiltroFecha = new com.toedter.calendar.JDateChooser();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnPasarPedido = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnEditar = new javax.swing.JButton();
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
        tCotizaciones = new javax.swing.JTable();

        jMenu1.setText("jMenu1");

        itemCancelar.setText("Cancelar");
        jMenu1.add(itemCancelar);

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
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar todo", "Numero", "Cliente", "Fecha" }));
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
        toolBarTabla1.add(jSeparator1);

        txtFiltroFecha.setDate(new Date());
        txtFiltroFecha.setDateFormatString("dd-MM-yyyy");
        txtFiltroFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFiltroFecha.setMaximumSize(new java.awt.Dimension(150, 40));
        txtFiltroFecha.setMinimumSize(new java.awt.Dimension(150, 40));
        txtFiltroFecha.setPreferredSize(new java.awt.Dimension(150, 40));
        txtFiltroFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFiltroFechaPropertyChange(evt);
            }
        });
        toolBarTabla1.add(txtFiltroFecha);
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

        btnPasarPedido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnPasarPedido.setForeground(colorTexto);
        btnPasarPedido.setText("Pasar a Pedido");
        btnPasarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPasarPedido.setFocusable(false);
        btnPasarPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPasarPedido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPasarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarPedidoActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnPasarPedido);
        btnPasarPedido.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));
        toolBarTabla1.add(jSeparator2);

        btnEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEditar.setForeground(colorTexto);
        btnEditar.setText("Imprimir");
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
        btnBaja.setText("Ver Digital");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(colorUI);
        jLabel1.setText("Cotizaciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/checklist64.png"))); // NOI18N
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

        tCotizaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "No.", "Fecha", "Cliente", "Total", "Valida Por", "Vence"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tCotizaciones.setRowHeight(30);
        tCotizaciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tCotizaciones.getTableHeader().setReorderingAllowed(false);
        tCotizaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tCotizacionesMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tCotizaciones);
        if (tCotizaciones.getColumnModel().getColumnCount() > 0) {
            tCotizaciones.getColumnModel().getColumn(0).setMinWidth(0);
            tCotizaciones.getColumnModel().getColumn(0).setPreferredWidth(0);
            tCotizaciones.getColumnModel().getColumn(0).setMaxWidth(0);
            tCotizaciones.getColumnModel().getColumn(1).setMinWidth(100);
            tCotizaciones.getColumnModel().getColumn(1).setPreferredWidth(100);
            tCotizaciones.getColumnModel().getColumn(1).setMaxWidth(100);
            tCotizaciones.getColumnModel().getColumn(2).setMinWidth(120);
            tCotizaciones.getColumnModel().getColumn(2).setPreferredWidth(120);
            tCotizaciones.getColumnModel().getColumn(2).setMaxWidth(120);
            tCotizaciones.getColumnModel().getColumn(4).setMinWidth(70);
            tCotizaciones.getColumnModel().getColumn(4).setPreferredWidth(70);
            tCotizaciones.getColumnModel().getColumn(4).setMaxWidth(70);
            tCotizaciones.getColumnModel().getColumn(5).setMinWidth(70);
            tCotizaciones.getColumnModel().getColumn(5).setPreferredWidth(70);
            tCotizaciones.getColumnModel().getColumn(5).setMaxWidth(70);
            tCotizaciones.getColumnModel().getColumn(6).setMinWidth(120);
            tCotizaciones.getColumnModel().getColumn(6).setPreferredWidth(120);
            tCotizaciones.getColumnModel().getColumn(6).setMaxWidth(120);
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

        tpInventario.addTab("<html><body align=\"center\">Gestión de<br>Cotizaciones</body></html>", pGestion);

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

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        // TODO add your handling code here:
        cargarTablaCotizaciones();
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        cargarTablaCotizaciones();
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        DialogCotizacion dialog = new DialogCotizacion(new javax.swing.JFrame(), true, "Nueva Cotización");
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            cargarTablaCotizaciones();            
        }
        try {  
            database.getConexion().setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(PanelPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tpInventarioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpInventarioStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tpInventarioStateChanged

    private void tCotizacionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tCotizacionesMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tCotizaciones.rowAtPoint(point);
        tCotizaciones.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tCotizacionesMousePressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int idcotizacion = (int) tCotizaciones.getValueAt(tCotizaciones.getSelectedRow(), 0);
        Reportes.Reportes.cotizacion(idcotizacion);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        // TODO add your handling code here:
        int idcotizacion = (int) tCotizaciones.getValueAt(tCotizaciones.getSelectedRow(), 0);
        Reportes.Reportes.cotizacionOnline(idcotizacion);
    }//GEN-LAST:event_btnBajaActionPerformed

    private void txtFiltroFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFiltroFechaPropertyChange
        // TODO add your handling code here:
        cargarTablaCotizaciones();
    }//GEN-LAST:event_txtFiltroFechaPropertyChange

    private void btnPasarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarPedidoActionPerformed
        // TODO add your handling code here:
        pasarAPedido();
    }//GEN-LAST:event_btnPasarPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPasarPedido;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JMenuItem itemCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
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
    private javax.swing.JTable tCotizaciones;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpInventario;
    private javax.swing.JTextField txtFiltro;
    private com.toedter.calendar.JDateChooser txtFiltroFecha;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaCotizaciones(){
        int numero = 0;
        for(int i=0; i<tCotizaciones.getRowCount(); i++){
            dtmCotizaciones.removeRow(i);
            i-=1;
        }
        
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(V_COTIZACION);
        Condition filtro;
        /*CONDICIONES DEL FILTRO DE LA COTIZACION*/
        switch(cbxFiltro.getSelectedIndex()){
            case 1:
                filtro = V_COTIZACION.NUMERO.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            case 2:
                filtro = V_COTIZACION.NOMBRECLIENTE.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            case 3:
                filtro = V_COTIZACION.FECHA.equal(new java.sql.Date(txtFiltroFecha.getDate().getTime()));
                break;
            default:
                filtro = V_COTIZACION.NOMBRECLIENTE.likeIgnoreCase("%"+txtFiltro.getText()+"%")
                        .or(V_COTIZACION.NUMERO.likeIgnoreCase("%"+txtFiltro.getText()+"%"))
                        .and(V_COTIZACION.FECHA.equal(new java.sql.Date(txtFiltroFecha.getDate().getTime())));
                break;
        }
        query.addConditions(filtro);
        query.addOrderBy(V_COTIZACION.FECHA.asc());
        Result<Record> result = query.fetch();
        for (Record r : result) {
            numero ++;
            Object[] row = {
                r.getValue(V_COTIZACION.IDCOTIZACION),
                r.getValue(V_COTIZACION.NUMERO),
                Fechero.baseToReal(r.getValue(V_COTIZACION.FECHA)),
                r.getValue(V_COTIZACION.NOMBRECLIENTE),
                r.getValue(V_COTIZACION.TOTAL),
                r.getValue(V_COTIZACION.VALIDAPOR),
                Fechero.baseToReal(r.getValue(V_COTIZACION.VENCIMIENTO))
            };
            dtmCotizaciones.addRow(row);
        }
        
        if(tCotizaciones.getRowCount()>0){
            tCotizaciones.changeSelection(0, 1, false, false);
        }
    }
    
    private void dibujarTablas(){
        tCotizaciones.setGridColor(colorUI);
        JTableHeader jtableHeader = tCotizaciones.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tCotizaciones.setTableHeader(  jtableHeader );        
        
        tCotizaciones.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tCotizaciones.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tCotizaciones.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tCotizaciones.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tCotizaciones.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("num",new Color(113, 205, 245)));
        tCotizaciones.getColumnModel().getColumn(6).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tCotizaciones.repaint();   
        
    }    

    private void pasarAPedido() {
        int idcotizacion = (int) tCotizaciones.getValueAt(tCotizaciones.getSelectedRow(), 0);
        DialogCotizacionAPedido dialog = new DialogCotizacionAPedido(new javax.swing.JFrame(), true, "Nuevo Producto",idcotizacion);
        dialog.setVisible(true);
    }
    
}
