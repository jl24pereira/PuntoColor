
package panels.admon;

import clases.Mensajes;
import com.mrlonee.swing.animation.AnimatedPanel;
import static db.clases.Tables.EMPLEADO;
import static db.clases.Tables.V_EMPLEADOS;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.lista.Empleado;
import design.lista.EmpleadoListRenderer;
import design.tabbedpane.TabbedPanelUI;
import design.textfield.TextFieldUI;
import dialogs.admon.DialogEmpleado;
import dialogs.compras.DialogProveedor;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
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
public class PanelEmpleados extends AnimatedPanel {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    DefaultListModel<Empleado> modelo = new DefaultListModel<>();
    boolean nuevo = false;
    
    DefaultTableModel dtmContactoProveedor;

    public PanelEmpleados() {        
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();
        lEmpleados.setCellRenderer(new EmpleadoListRenderer(
                Color.WHITE,
                new Color(73, 190, 240)
        ));
        cargarListEmpleados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        chkBajas = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        jSeparator19 = new javax.swing.JToolBar.Separator();
        btnEditar = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JToolBar.Separator();
        btnBaja = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        lEmpleados = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        pFormulario = new javax.swing.JPanel();
        txtNombre = new javax.swing.JLabel();
        lblNIT = new javax.swing.JLabel();
        txtDUI = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        txtMail = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
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
        toolBarTabla1.add(jSeparator16);

        cbxFiltro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar todo", "Nombre", "Direccion", "Cargo" }));
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
        toolBarTabla1.add(jSeparator18);

        chkBajas.setBackground(cBtnNormal);
        chkBajas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chkBajas.setForeground(colorBG);
        chkBajas.setText("Ver Bajas");
        chkBajas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkBajas.setFocusable(false);
        chkBajas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chkBajas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chkBajas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Typicons_e0a8(1)_32.png"))); // NOI18N
        chkBajas.setMaximumSize(new java.awt.Dimension(115, 25));
        chkBajas.setMinimumSize(new java.awt.Dimension(115, 25));
        chkBajas.setPreferredSize(new java.awt.Dimension(115, 25));
        chkBajas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Typicons_e08b(0)_32.png"))); // NOI18N
        chkBajas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBajasItemStateChanged(evt);
            }
        });
        toolBarTabla1.add(chkBajas);
        toolBarTabla1.add(jSeparator1);

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
        toolBarTabla1.add(jSeparator19);

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
        toolBarTabla1.add(jSeparator20);

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
        jLabel1.setText("Empleados");
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
        pTabla.setMinimumSize(new java.awt.Dimension(450, 100));
        pTabla.setOpaque(false);
        pTabla.setPreferredSize(new java.awt.Dimension(450, 100));
        pTabla.setLayout(new java.awt.GridBagLayout());

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setMinimumSize(new java.awt.Dimension(10, 10));
        jScrollPane3.setOpaque(false);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(10, 10));

        lEmpleados.setBackground(colorBG);
        lEmpleados.setModel(modelo);
        lEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lEmpleados.setSelectionBackground(new java.awt.Color(73, 189, 240));
        lEmpleados.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lEmpleadosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lEmpleados);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pTabla.add(jScrollPane3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pGestion.add(pTabla, gridBagConstraints);

        jPanel1.setBackground(colorBG);
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 365));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 365));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        pFormulario.setBackground(new java.awt.Color(255, 255, 255));
        pFormulario.setOpaque(false);
        pFormulario.setLayout(new java.awt.GridBagLayout());

        txtNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtNombre.setForeground(colorUI);
        txtNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombre.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 20, 30, 20);
        pFormulario.add(txtNombre, gridBagConstraints);

        lblNIT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNIT.setText("DUI:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 10);
        pFormulario.add(lblNIT, gridBagConstraints);

        txtDUI.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDUI.setPreferredSize(new java.awt.Dimension(120, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 20);
        pFormulario.add(txtDUI, gridBagConstraints);

        lblDireccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDireccion.setText("Direccion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 10);
        pFormulario.add(lblDireccion, gridBagConstraints);

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 20);
        pFormulario.add(txtDireccion, gridBagConstraints);

        lblTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTelefono.setText("Telefono:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 10);
        pFormulario.add(lblTelefono, gridBagConstraints);

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 20);
        pFormulario.add(txtTelefono, gridBagConstraints);

        lblMail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMail.setText("E-Mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 10);
        pFormulario.add(lblMail, gridBagConstraints);

        txtMail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 20);
        pFormulario.add(txtMail, gridBagConstraints);

        lblTipo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTipo.setText("Cargo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 10);
        pFormulario.add(lblTipo, gridBagConstraints);

        txtCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 20);
        pFormulario.add(txtCargo, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/Personal-information.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pFormulario.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(pFormulario, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        pGestion.add(jPanel1, gridBagConstraints);

        tpProveedores.addTab("<html><body>Gestión de<br>Empleados</body></html>", pGestion);

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
        cargarListEmpleados();
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void lEmpleadosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lEmpleadosValueChanged
        if(lEmpleados.getSelectedIndex()>=0){
            cargarSeleccion(); 
        }
    }//GEN-LAST:event_lEmpleadosValueChanged

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        cargarListEmpleados();
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        DialogEmpleado dialog = new DialogEmpleado(new javax.swing.JFrame(), true, "Nuevo Empleado");
        dialog.setVisible(true);
        cargarListEmpleados();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(chkBajas.isSelected()){
            new Mensajes().mensajeAlert("No se puede editar una baja de registro");
        }else{
            if(modelo.getSize()>0){
                editarEmpleado();
            }else{
                new Mensajes().mensajeAlert("No hay empleados a editar");
            }
        }        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        if(chkBajas.isSelected()){
            altaEmpleado();
        }else{
            bajaEmpleado();
        }        
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        Reportes.Reportes.reporteEmpleados();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void chkBajasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBajasItemStateChanged
        // TODO add your handling code here:
        if(chkBajas.isSelected()){
            btnBaja.setText("Alta");
        }else{
            btnBaja.setText("Baja");
        }
        cargarListEmpleados();
    }//GEN-LAST:event_chkBajasItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JCheckBox chkBajas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JToolBar.Separator jSeparator19;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator20;
    private javax.swing.JList<Empleado> lEmpleados;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNIT;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel pFormulario;
    private javax.swing.JPanel pGestion;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTabla;
    private javax.swing.JPanel pTabs;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpProveedores;
    private javax.swing.JLabel txtCargo;
    private javax.swing.JLabel txtDUI;
    private javax.swing.JLabel txtDireccion;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JLabel txtMail;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void cargarListEmpleados(){
        modelo.clear();
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(V_EMPLEADOS);
        Condition filtro;
        Condition baja = V_EMPLEADOS.BAJA.eq(chkBajas.isSelected()) ;
        switch(cbxFiltro.getSelectedIndex()){
            case 1:
                filtro = V_EMPLEADOS.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            case 2:
                filtro = V_EMPLEADOS.DIRECCION.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            case 3:
                filtro = V_EMPLEADOS.CARGO.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            default:
                filtro = V_EMPLEADOS.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%")
                        .or(V_EMPLEADOS.DIRECCION.likeIgnoreCase("%"+txtFiltro.getText()+"%"))
                        .or(V_EMPLEADOS.CARGO.likeIgnoreCase("%"+txtFiltro.getText()+"%"));
                break;
        }
        query.addConditions(filtro.and(baja));
        query.addOrderBy(V_EMPLEADOS.NOMBRE.asc());
        Result<Record> result = query.fetch();
        for (Record r : result) {
            ImageIcon imagen = null;
            switch(r.getValue(V_EMPLEADOS.IDCARGO)){
                case 1:
                    imagen = new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/48/user-blue.png"));
                    break;
                case 2:
                    imagen = new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/48/user-red.png"));
                    break;
                case 3:
                    imagen = new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/48/user-yellow.png"));
                    break;
                case 4:
                    imagen = new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/48/user-green.png"));
                    break;
            }
            modelo.addElement(new design.lista.Empleado(
                    r.getValue(V_EMPLEADOS.IDEMPLEADO), 
                    r.getValue(V_EMPLEADOS.NOMBRE), 
                    r.getValue(V_EMPLEADOS.DIRECCION),
                    r.getValue(V_EMPLEADOS.TELEFONO),
                    r.getValue(V_EMPLEADOS.EMAIL),
                    r.getValue(V_EMPLEADOS.DUI),
                    r.getValue(V_EMPLEADOS.CARGO),
                    r.getValue(V_EMPLEADOS.IDCARGO),
                    imagen));
        }    
        if(modelo.getSize()>0){
            lEmpleados.setSelectedIndex(0);
        }
    }
    
    private void cargarSeleccion(){
        txtNombre.setText(lEmpleados.getSelectedValue().getNombre());
        txtDUI.setText(lEmpleados.getSelectedValue().getDui());
        txtDUI.setText(lEmpleados.getSelectedValue().getDui());
        txtDireccion.setText(lEmpleados.getSelectedValue().getDireccion());
        txtTelefono.setText(lEmpleados.getSelectedValue().getTelefono());
        txtMail.setText(lEmpleados.getSelectedValue().getEmail());
        txtCargo.setText(lEmpleados.getSelectedValue().getCargo());
    }
    
    private void nuevoEmpleado(){
        DialogProveedor dialog = new DialogProveedor(new javax.swing.JFrame(), true, "Nuevo Proveedor");
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro Agregado Exitosamente");
            cargarListEmpleados();
        }
        dialog.dispose();
    }
    
    private void editarEmpleado(){
        DialogEmpleado dialog = new DialogEmpleado(new javax.swing.JFrame(), true, "Editar Empleado",lEmpleados.getSelectedValue().getId());
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro Editado Exitosamente");
            cargarListEmpleados();
        }
        dialog.dispose();
    }
    
    private void bajaEmpleado(){
        int r = new Mensajes().mensajeSiNo("Desea dar baja al registro?");
        if(r==0){
            create.update(EMPLEADO)
                    .set(EMPLEADO.BAJA, true)
                    .where(EMPLEADO.IDEMPLEADO.equal(lEmpleados.getSelectedValue().getId()))
                    .execute();
            cargarListEmpleados();
        }
    }
    
    private void altaEmpleado(){
        int r = new Mensajes().mensajeSiNo("Desea dar alta al registro?");
        if(r==0){
            create.update(EMPLEADO)
                    .set(EMPLEADO.BAJA, false)
                    .where(EMPLEADO.IDEMPLEADO.equal(lEmpleados.getSelectedValue().getId()))
                    .execute();
            cargarListEmpleados();
        }
    }
    
}
