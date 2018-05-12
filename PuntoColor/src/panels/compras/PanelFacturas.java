
package panels.compras;

import Reportes.Reportes;
import clases.Mensajes;
import com.mrlonee.swing.animation.AnimatedPanel;
import static db.clases.Tables.PROVEEDOR;
import static db.clases.Tables.V_COMPRAS;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.lista.ContactoRenderer;
import design.lista.Proveedor;
import design.tabbedpane.TabbedPanelUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import dialogs.compras.DialogAbono;
import dialogs.compras.DialogDetalleFactura;
import dialogs.compras.DialogFactura;
import java.awt.Color;
import java.awt.Point;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
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
public class PanelFacturas extends AnimatedPanel {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    DefaultListModel<Proveedor> modelo = new DefaultListModel<>();
    boolean nuevo = false;
    
    DefaultTableModel dtmFacturas;

    public PanelFacturas() {        
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();
        dtmFacturas = (DefaultTableModel) tFacturas.getModel();
        lProveedores.setCellRenderer(new ContactoRenderer(
                Color.WHITE,
                new Color(73, 190, 240)
        ));
        cargarListProveedores(false);
        dibujarTablaFacturas();
        pasarFechas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popFacturas = new javax.swing.JPopupMenu();
        itemVerDetalle = new javax.swing.JMenuItem();
        itemPago = new javax.swing.JMenuItem();
        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        chkInactivos = new javax.swing.JCheckBox();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        txtFechaInicial = new com.toedter.calendar.JDateChooser();
        jSeparator19 = new javax.swing.JToolBar.Separator();
        jLabel4 = new javax.swing.JLabel();
        txtFechaFinal = new com.toedter.calendar.JDateChooser();
        jSeparator20 = new javax.swing.JToolBar.Separator();
        btnAgregarFactura = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnReporte = new javax.swing.JButton();
        pTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pTabs = new javax.swing.JPanel();
        tpProveedores = new javax.swing.JTabbedPane(){
            public Color setForegroundAt(int index){
                if(getSelectedIndex() == index) return Color.BLACK;
                return Color.WHITE;
            }
        };
        pGestion = new javax.swing.JPanel();
        pTabla = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lProveedores = new javax.swing.JList<>();
        pForm = new javax.swing.JPanel();
        tpGestionProveedor = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tFacturas = new javax.swing.JTable();

        itemVerDetalle.setText("Ver Detalle");
        itemVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerDetalleActionPerformed(evt);
            }
        });
        popFacturas.add(itemVerDetalle);

        itemPago.setText("Agregar Pago");
        itemPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPagoActionPerformed(evt);
            }
        });
        popFacturas.add(itemPago);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        pMain.setBackground(new java.awt.Color(102, 102, 102));
        pMain.setMinimumSize(new java.awt.Dimension(859, 600));
        pMain.setOpaque(false);
        pMain.setPreferredSize(new java.awt.Dimension(859, 600));
        pMain.setLayout(new java.awt.GridBagLayout());

        toolBarTabla1.setBackground(colorUI);
        toolBarTabla1.setBorder(null);
        toolBarTabla1.setFloatable(false);
        toolBarTabla1.setRollover(true);
        toolBarTabla1.setMaximumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setMinimumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setPreferredSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.add(jSeparator16);

        cbxFiltro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar todo", "Nombre", "Direccion", "Telefono" }));
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
        toolBarTabla1.add(jSeparator17);

        txtFiltro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtFiltro.setMargin(new java.awt.Insets(2, 10, 2, 2));
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

        chkInactivos.setBackground(cBtnNormal);
        chkInactivos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chkInactivos.setForeground(colorBG);
        chkInactivos.setText("Ver bajas");
        chkInactivos.setFocusable(false);
        chkInactivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chkInactivos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chkInactivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Typicons_e0a8(1)_32.png"))); // NOI18N
        chkInactivos.setIconTextGap(0);
        chkInactivos.setMaximumSize(new java.awt.Dimension(100, 25));
        chkInactivos.setMinimumSize(new java.awt.Dimension(100, 25));
        chkInactivos.setPreferredSize(new java.awt.Dimension(100, 25));
        chkInactivos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Typicons_e08b(0)_32.png"))); // NOI18N
        chkInactivos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkInactivosItemStateChanged(evt);
            }
        });
        toolBarTabla1.add(chkInactivos);
        toolBarTabla1.add(jSeparator18);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(colorBG);
        jLabel3.setText("Fecha Inicial: ");
        toolBarTabla1.add(jLabel3);

        txtFechaInicial.setDate(new Date());
        txtFechaInicial.setDateFormatString("dd-MM-yyyy");
        txtFechaInicial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFechaInicial.setMaximumSize(new java.awt.Dimension(120, 40));
        txtFechaInicial.setMinimumSize(new java.awt.Dimension(120, 40));
        txtFechaInicial.setPreferredSize(new java.awt.Dimension(120, 40));
        txtFechaInicial.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFechaInicialPropertyChange(evt);
            }
        });
        toolBarTabla1.add(txtFechaInicial);
        toolBarTabla1.add(jSeparator19);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(colorBG);
        jLabel4.setText("Fecha Final: ");
        toolBarTabla1.add(jLabel4);

        txtFechaFinal.setDate(new Date());
        txtFechaFinal.setDateFormatString("dd-MM-yyyy");
        txtFechaFinal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFechaFinal.setMaximumSize(new java.awt.Dimension(120, 40));
        txtFechaFinal.setMinimumSize(new java.awt.Dimension(120, 40));
        txtFechaFinal.setPreferredSize(new java.awt.Dimension(120, 40));
        txtFechaFinal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFechaFinalPropertyChange(evt);
            }
        });
        toolBarTabla1.add(txtFechaFinal);
        toolBarTabla1.add(jSeparator20);

        btnAgregarFactura.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAgregarFactura.setForeground(colorTexto);
        btnAgregarFactura.setText("Agregar Factura");
        btnAgregarFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarFactura.setFocusable(false);
        btnAgregarFactura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarFactura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFacturaActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnAgregarFactura);
        btnAgregarFactura.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));
        toolBarTabla1.add(jSeparator3);

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
        jLabel1.setText("Facturas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/Product-documentation64.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pTitulo.add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pMain.add(pTitulo, gridBagConstraints);

        pTabs.setOpaque(false);
        pTabs.setLayout(new java.awt.GridBagLayout());

        tpProveedores.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tpProveedores.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        pGestion.setBackground(colorBG);
        pGestion.setLayout(new java.awt.GridBagLayout());

        pTabla.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        pTabla.setMinimumSize(new java.awt.Dimension(250, 10));
        pTabla.setOpaque(false);
        pTabla.setPreferredSize(new java.awt.Dimension(250, 10));
        pTabla.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Proveedores");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pTabla.add(jLabel2, gridBagConstraints);

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setOpaque(false);

        lProveedores.setBackground(colorBG);
        lProveedores.setModel(modelo);
        lProveedores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lProveedores.setSelectionBackground(new java.awt.Color(73, 189, 240));
        lProveedores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lProveedoresValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lProveedores);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pTabla.add(jScrollPane3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pGestion.add(pTabla, gridBagConstraints);

        pForm.setOpaque(false);
        pForm.setLayout(new java.awt.GridBagLayout());

        tpGestionProveedor.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tpGestionProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        tFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Documento #", "Fecha", "Total", "Pendiente", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tFacturas.setComponentPopupMenu(popFacturas);
        tFacturas.setRowHeight(30);
        tFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tFacturasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tFacturas);
        if (tFacturas.getColumnModel().getColumnCount() > 0) {
            tFacturas.getColumnModel().getColumn(0).setMinWidth(0);
            tFacturas.getColumnModel().getColumn(0).setPreferredWidth(0);
            tFacturas.getColumnModel().getColumn(0).setMaxWidth(0);
            tFacturas.getColumnModel().getColumn(2).setMinWidth(125);
            tFacturas.getColumnModel().getColumn(2).setPreferredWidth(125);
            tFacturas.getColumnModel().getColumn(2).setMaxWidth(125);
            tFacturas.getColumnModel().getColumn(3).setMinWidth(100);
            tFacturas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tFacturas.getColumnModel().getColumn(3).setMaxWidth(100);
            tFacturas.getColumnModel().getColumn(4).setMinWidth(100);
            tFacturas.getColumnModel().getColumn(4).setPreferredWidth(100);
            tFacturas.getColumnModel().getColumn(4).setMaxWidth(100);
            tFacturas.getColumnModel().getColumn(5).setMinWidth(150);
            tFacturas.getColumnModel().getColumn(5).setPreferredWidth(150);
            tFacturas.getColumnModel().getColumn(5).setMaxWidth(150);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        tpGestionProveedor.addTab("Resumen de Facturas", jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pForm.add(tpGestionProveedor, gridBagConstraints);
        tpGestionProveedor.setUI(new TabbedPanelUI(colorUI,Color.WHITE));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pGestion.add(pForm, gridBagConstraints);

        tpProveedores.addTab("<html><body>Gestión de<br>Proveedores</body></html>", pGestion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pTabs.add(tpProveedores, gridBagConstraints);
        tpProveedores.setUI(new TabbedPanelUI(colorUI,Color.WHITE));

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

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        cargarListProveedores(chkInactivos.isSelected());
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void lProveedoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lProveedoresValueChanged
        if(lProveedores.getSelectedIndex()>=0){
            cargarTablaFacturas();
        }
    }//GEN-LAST:event_lProveedoresValueChanged

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        cargarListProveedores(chkInactivos.isSelected());
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void btnAgregarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFacturaActionPerformed
        try {
            DialogFactura dialog = new DialogFactura(new javax.swing.JFrame(), true,"Nueva Factura",lProveedores.getSelectedValue().getId());
            dialog.setVisible(true);
            if(dialog.isGuardado()){
                new Mensajes().mensajeInfo("Registro agregado exitosamente");
                cargarTablaFacturas();
            }else{
                database.getConexion().rollback();
            }
            database.getConexion().setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(PanelFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarFacturaActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        Date dateInicio = txtFechaInicial.getDate();
        java.sql.Date fechaInicio = new java.sql.Date (dateInicio.getTime());
        Date dateFin = txtFechaFinal.getDate();
        java.sql.Date fechaFin = new java.sql.Date (dateFin.getTime());
        Reportes.reporteFacturasProveedor(lProveedores.getSelectedValue().getId(), lProveedores.getSelectedValue().getNombre(),dateInicio, dateFin);
    }//GEN-LAST:event_btnReporteActionPerformed

    private void itemVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerDetalleActionPerformed
        // TODO add your handling code here:
        int idcompra = (int) tFacturas.getValueAt(tFacturas.getSelectedRow(), 0);
        DialogDetalleFactura dialog = new DialogDetalleFactura(new javax.swing.JFrame(), true,"Detalle de Factura",idcompra);
        dialog.setVisible(true);
    }//GEN-LAST:event_itemVerDetalleActionPerformed

    private void chkInactivosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkInactivosItemStateChanged
        // TODO add your handling code here:
        cargarListProveedores(chkInactivos.isSelected());
    }//GEN-LAST:event_chkInactivosItemStateChanged

    private void itemPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPagoActionPerformed
        // TODO add your handling code here:
        if(tFacturas.getRowCount()>0){
            int idfactura = (int) tFacturas.getValueAt(tFacturas.getSelectedRow(), 0);
            DialogAbono dialog = new DialogAbono(new javax.swing.JFrame(), true,"Nuevo Abono",idfactura);
            dialog.setVisible(true);
        }        
    }//GEN-LAST:event_itemPagoActionPerformed

    private void txtFechaInicialPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFechaInicialPropertyChange
        // TODO add your handling code here:
        verificarMenor();
        cargarTablaFacturas();
    }//GEN-LAST:event_txtFechaInicialPropertyChange

    private void txtFechaFinalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFechaFinalPropertyChange
        // TODO add your handling code here:
        verificarMayor();
        cargarTablaFacturas();
    }//GEN-LAST:event_txtFechaFinalPropertyChange

    private void tFacturasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tFacturasMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tFacturas.rowAtPoint(point);
        tFacturas.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tFacturasMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFactura;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JCheckBox chkInactivos;
    private javax.swing.JMenuItem itemPago;
    private javax.swing.JMenuItem itemVerDetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JToolBar.Separator jSeparator19;
    private javax.swing.JToolBar.Separator jSeparator20;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JList<Proveedor> lProveedores;
    private javax.swing.JPanel pForm;
    private javax.swing.JPanel pGestion;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTabla;
    private javax.swing.JPanel pTabs;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JPopupMenu popFacturas;
    private javax.swing.JTable tFacturas;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpGestionProveedor;
    private javax.swing.JTabbedPane tpProveedores;
    private com.toedter.calendar.JDateChooser txtFechaFinal;
    private com.toedter.calendar.JDateChooser txtFechaInicial;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    private void cargarListProveedores(boolean inactivos){
        modelo.clear();
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(PROVEEDOR);
        Condition filtro;
        Condition baja;
        switch(cbxFiltro.getSelectedIndex()){
            case 1:
                filtro = PROVEEDOR.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            case 2:
                filtro = PROVEEDOR.DIRECCION.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            case 3:
                filtro = PROVEEDOR.TELEFONO.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            default:
                filtro = PROVEEDOR.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%")
                        .or(PROVEEDOR.DIRECCION.likeIgnoreCase("%"+txtFiltro.getText()+"%"))
                        .or(PROVEEDOR.TELEFONO.likeIgnoreCase("%"+txtFiltro.getText()+"%"));
                break;
        }
        if(inactivos){
            baja = PROVEEDOR.BAJA.eq(true);
        }else{
            baja = PROVEEDOR.BAJA.eq(false);
        }        
        query.addConditions(filtro.and(baja));
        query.addOrderBy(PROVEEDOR.NOMBRE.asc());
        Result<Record> result = query.fetch();
        for (Record r : result) {
            modelo.addElement(new Proveedor(r.getValue(PROVEEDOR.IDPROVEEDOR),
                    r.getValue(PROVEEDOR.NOMBRE),
                    r.getValue(PROVEEDOR.DIRECCION),
                    r.getValue(PROVEEDOR.TELEFONO)));
        }    
        if(modelo.getSize()>0){
            lProveedores.setSelectedIndex(0);
        }
    }
    
    private void cargarTablaFacturas(){
        for(int i=0; i<tFacturas.getRowCount(); i++){
            dtmFacturas.removeRow(i);
            i-=1;
        }
        
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(V_COMPRAS);
        query.addSelect(
                V_COMPRAS.IDCOMPRA,
                V_COMPRAS.NUMERODOCUMENTO,
                V_COMPRAS.FECHA, 
                V_COMPRAS.TOTAL, 
                V_COMPRAS.PENDIENTE,
                V_COMPRAS.PAGADO);
        Condition rangoFecha;
        Condition proveedor = V_COMPRAS.IDPROVEEDOR.equal(lProveedores.getSelectedValue().getId());
        Date dateInicio = txtFechaInicial.getDate();
        java.sql.Date fechaInicio = new java.sql.Date (dateInicio.getTime());
        Date dateFin = txtFechaFinal.getDate();
        java.sql.Date fechaFin = new java.sql.Date (dateFin.getTime());
        rangoFecha = V_COMPRAS.FECHA.between(fechaInicio, fechaFin);
        query.addConditions(proveedor.and(rangoFecha));
        Result<Record> result = query.fetch();
        for (Record r : result){
            Object[] row = r.intoArray();
            dtmFacturas.addRow(row);
        }        
        
        if(tFacturas.getRowCount()>0){
            tFacturas.changeSelection(0, 1, false, false);
        }
    }
    
    private void dibujarTablaFacturas(){        
        tFacturas.setGridColor(colorUI);
        
        JTableHeader jtableHeader = tFacturas.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tFacturas.setTableHeader(  jtableHeader );
        
        
        tFacturas.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tFacturas.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tFacturas.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tFacturas.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        tFacturas.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("pago",new Color(113, 205, 245)));
        tFacturas.repaint();
    }

    private void pasarFechas() {
        Calendar fechaHoy = Calendar.getInstance();
        Calendar fechaInicio = Calendar.getInstance();
        Calendar fechaFinal = Calendar.getInstance();
        fechaInicio.set(Calendar.DAY_OF_MONTH, fechaHoy.getActualMinimum(Calendar.DAY_OF_MONTH));
        fechaFinal.set(Calendar.DAY_OF_MONTH, fechaHoy.getActualMaximum(Calendar.DAY_OF_MONTH));
        txtFechaInicial.setCalendar(fechaInicio);
        txtFechaFinal.setCalendar(fechaFinal);
    }

    private void verificarMenor() {
        if(txtFechaInicial.getCalendar().compareTo(txtFechaFinal.getCalendar())==1){
            new Mensajes().mensajeAlert("La fecha inicial no puede ser mayor que fecha final");
            Calendar fechaHoy = Calendar.getInstance();
            Calendar fechaInicio = Calendar.getInstance();
            fechaInicio.set(Calendar.DAY_OF_MONTH, fechaHoy.getActualMinimum(Calendar.DAY_OF_MONTH));
            txtFechaInicial.setCalendar(fechaInicio);
        }
    }

    private void verificarMayor() {
        if(txtFechaInicial.getCalendar().compareTo(txtFechaFinal.getCalendar())==1){
            new Mensajes().mensajeAlert("La fecha final no puede ser menor que fecha inicial");
            Calendar fechaHoy = Calendar.getInstance();
            Calendar fechaFinal = Calendar.getInstance();
            fechaFinal.set(Calendar.DAY_OF_MONTH, fechaHoy.getActualMaximum(Calendar.DAY_OF_MONTH));
            txtFechaFinal.setCalendar(fechaFinal);
        }
    }
    
}
