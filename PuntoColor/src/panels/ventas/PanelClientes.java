package panels.ventas;

import clases.Mensajes;
import com.mrlonee.swing.animation.AnimatedPanel;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.tabbedpane.TabbedPanelUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import dialogs.admon.DialogCajas;
import dialogs.ventas.DialogCliente;
import java.awt.Color;
import java.awt.Point;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;

import static db.clases.Tables.CLIENTE;
import static db.clases.Tables.V_CLIENTES;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;

/*@author Jose Luis */
public class PanelClientes extends AnimatedPanel {

    DSLContext create = DSL.using ( database.getConexion () , SQLDialect.POSTGRES_9_5 );

    DefaultTableModel dtmClientes;

    boolean nuevaCategoria = false;

    public PanelClientes () {
        this.setAnimationType ( AnimatedPanel.AnimationType.SlideAnimationFromTop );
        initComponents ();
        dtmClientes = ( DefaultTableModel ) tClientes.getModel ();
        dibujarTablas ();
        cargarTablaClientes ();
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnEditar = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        cbxTipoCliente = new javax.swing.JComboBox<>();
        pTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pTabs = new javax.swing.JPanel();
        tpInventario = new javax.swing.JTabbedPane();
        pGestion = new javax.swing.JPanel();
        pTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tClientes = new javax.swing.JTable();

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
        btnEditar.setText("Eliminar");
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

        cbxFiltro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar todos", "Nombre", "Dirección", "Teléfono" }));
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

        cbxTipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo Cliente", "Consumidor Final", "Crédito Fiscal" }));
        cbxTipoCliente.setMaximumSize(new java.awt.Dimension(150, 40));
        cbxTipoCliente.setMinimumSize(new java.awt.Dimension(150, 40));
        cbxTipoCliente.setPreferredSize(new java.awt.Dimension(150, 40));
        cbxTipoCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoClienteItemStateChanged(evt);
            }
        });
        toolBarTabla1.add(cbxTipoCliente);
        cbxTipoCliente.setUI(new ComboUI(colorBG,cBtnNormal));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pMain.add(toolBarTabla1, gridBagConstraints);

        pTitulo.setOpaque(false);
        pTitulo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(colorUI);
        jLabel1.setText("Clientes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/users.png"))); // NOI18N
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

        tClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Direccion", "Telefono", "Tipo", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tClientes.setRowHeight(30);
        tClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tClientes.getTableHeader().setReorderingAllowed(false);
        tClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tClientesMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tClientes);
        if (tClientes.getColumnModel().getColumnCount() > 0) {
            tClientes.getColumnModel().getColumn(0).setMinWidth(0);
            tClientes.getColumnModel().getColumn(0).setPreferredWidth(0);
            tClientes.getColumnModel().getColumn(0).setMaxWidth(0);
            tClientes.getColumnModel().getColumn(1).setMinWidth(100);
            tClientes.getColumnModel().getColumn(1).setPreferredWidth(100);
            tClientes.getColumnModel().getColumn(1).setMaxWidth(100);
            tClientes.getColumnModel().getColumn(3).setMinWidth(200);
            tClientes.getColumnModel().getColumn(3).setPreferredWidth(200);
            tClientes.getColumnModel().getColumn(3).setMaxWidth(200);
            tClientes.getColumnModel().getColumn(4).setMinWidth(200);
            tClientes.getColumnModel().getColumn(4).setPreferredWidth(200);
            tClientes.getColumnModel().getColumn(4).setMaxWidth(200);
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
        tpInventario.getAccessibleContext().setAccessibleName("<html><body align=\"center\">Gestión de<br>Clientes</body></html>");

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
        eliminarCliente ();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tClientesMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint ();
        int currentRow = tClientes.rowAtPoint ( point );
        tClientes.setRowSelectionInterval ( currentRow , currentRow );
    }//GEN-LAST:event_tClientesMousePressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        DialogCliente dialog = new DialogCliente ( new javax.swing.JFrame () , true , "Nuevo Pedido" );
        dialog.setVisible ( true );
        if ( dialog.isGuardado () ) {
            cargarTablaClientes ();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tpInventarioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpInventarioStateChanged
        // TODO add your handling code here:
        if ( tpInventario.getSelectedIndex () == 0 ) {

            //cargarDialogMaterial();
        } else {
            //cargarDialogCategoria();
        }
    }//GEN-LAST:event_tpInventarioStateChanged

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        // TODO add your handling code here:
        cargarTablaClientes ();
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        cargarTablaClientes ();
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void cbxTipoClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoClienteItemStateChanged
        // TODO add your handling code here:
        cargarTablaClientes ();
    }//GEN-LAST:event_cbxTipoClienteItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JComboBox<String> cbxTipoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JPanel pGestion;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTabla;
    private javax.swing.JPanel pTabs;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JTable tClientes;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpInventario;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaClientes () {
        for ( int i = 0 ; i < tClientes.getRowCount () ; i++ ) {
            dtmClientes.removeRow ( i );
            i -= 1;
        }
        SelectQuery<Record> query = create.selectQuery ();
        query.addSelect ( V_CLIENTES.IDCLIENTE ,
                          V_CLIENTES.NOMBRE ,
                          V_CLIENTES.DIRECCION ,
                          V_CLIENTES.TELEFONO ,
                          V_CLIENTES.TIPO ,
                          V_CLIENTES.CATEGORIA );
        query.addFrom ( V_CLIENTES );
        Condition baja = V_CLIENTES.BAJA.equal ( false );
        Condition filtro;
        switch ( cbxFiltro.getSelectedIndex () ) {
            case 1:
                filtro = V_CLIENTES.NOMBRE.likeIgnoreCase ( "%" + txtFiltro.getText () + "%" );
                break;
            case 2:
                filtro = V_CLIENTES.DIRECCION.likeIgnoreCase ( "%" + txtFiltro.getText () + "%" );
                break;
            case 3:
                filtro = V_CLIENTES.TELEFONO.likeIgnoreCase ( "%" + txtFiltro.getText () + "%" );
                break;
            default:
                filtro = V_CLIENTES.NOMBRE.likeIgnoreCase ( "%" + txtFiltro.getText () + "%" )
                        .or ( V_CLIENTES.DIRECCION.likeIgnoreCase ( "%" + txtFiltro.getText () + "%" ) )
                        .or ( V_CLIENTES.TELEFONO.likeIgnoreCase ( "%" + txtFiltro.getText () + "%" ) );
                break;
        }
        Condition tipo;
        switch ( cbxTipoCliente.getSelectedIndex () ) {
            case 1:
                tipo = V_CLIENTES.TIPO.equalIgnoreCase ( "CONSUMIDOR FINAL" );
                break;
            case 2:
                tipo = V_CLIENTES.TIPO.equalIgnoreCase ( "CREDITO FISCAL" );
                break;
            default:
                tipo = V_CLIENTES.TIPO.notEqual ( "" );
                break;
        }
        query.addConditions ( baja.and ( filtro ).and ( tipo ) );
        query.addOrderBy ( V_CLIENTES.NOMBRE.asc () );
        Result<Record> result = query.fetch ();
        result.stream ().forEach ( ( r ) -> {
            dtmClientes.addRow ( r.intoArray () );
        } );
        if ( tClientes.getRowCount () > 0 ) {
            tClientes.changeSelection ( 0 , 1 , false , false );
        }
    }

    private void dibujarTablas () {
        tClientes.setGridColor ( colorUI );
        JTableHeader headerDetalle = tClientes.getTableHeader ();
        headerDetalle.setDefaultRenderer ( new HeaderCellRenderer ( colorUI ) );
        tClientes.setTableHeader ( headerDetalle );

        tClientes.getColumnModel ().getColumn ( 1 ).setCellRenderer ( new CellRenderer ( "text" , new Color ( 113 , 205 , 245 ) ) );
        tClientes.getColumnModel ().getColumn ( 2 ).setCellRenderer ( new CellRenderer ( "text" , new Color ( 113 , 205 , 245 ) ) );
        tClientes.getColumnModel ().getColumn ( 3 ).setCellRenderer ( new CellRenderer ( "text center" , new Color ( 113 , 205 , 245 ) ) );
        tClientes.getColumnModel ().getColumn ( 4 ).setCellRenderer ( new CellRenderer ( "text center" , new Color ( 113 , 205 , 245 ) ) );
        tClientes.getColumnModel ().getColumn ( 5 ).setCellRenderer ( new CellRenderer ( "text center" , new Color ( 113 , 205 , 245 ) ) );

        tClientes.repaint ();

    }

    private void nuevaCaja () {
        DialogCajas dialog = new DialogCajas ( new javax.swing.JFrame () , true , "Nueva Caja" );
        dialog.setVisible ( true );
        if ( dialog.isGuardado () ) {
            new Mensajes ().mensajeInfo ( "Registro agregado exitosamente" );
            cargarTablaClientes ();
        }
        dialog.dispose ();
    }

    private void eliminarCliente () {
        if ( tClientes.getRowCount () > 0 ) {
            int idcliente = ( int ) tClientes.getValueAt ( tClientes.getSelectedRow () , 0 );
            create.delete ( CLIENTE ).where ( CLIENTE.IDCLIENTE.eq ( idcliente ) ).execute ();
            cargarTablaClientes ();
        }
    }

}
