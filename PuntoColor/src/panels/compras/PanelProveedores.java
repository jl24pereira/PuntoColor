
package panels.compras;

import Reportes.Reportes;
import clases.Mensajes;
import com.mrlonee.swing.animation.AnimatedPanel;
import static db.clases.Tables.CONTACTO_PROVEEDOR;
import static db.clases.Tables.PROVEEDOR;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.lista.ContactoRenderer;
import design.lista.Proveedor;
import design.spinner.SpinnerUI;
import design.tabbedpane.TabbedPanelUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import dialogs.compras.DialogContactoProveedor;
import dialogs.compras.DialogProveedor;
import java.awt.Color;
import java.awt.Point;
import java.math.BigDecimal;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record3;
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
public class PanelProveedores extends AnimatedPanel {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    DefaultListModel<Proveedor> modelo = new DefaultListModel<>();
    boolean nuevo = false;
    
    DefaultTableModel dtmContactoProveedor;

    public PanelProveedores() {        
        this.setAnimationType(AnimatedPanel.AnimationType.SlideAnimationFromTop);
        initComponents();
        dtmContactoProveedor = (DefaultTableModel) tContactoProveedor.getModel();
        lProveedores.setCellRenderer(new ContactoRenderer(
                Color.WHITE,
                new Color(73, 190, 240)
        ));
        cargarListProveedores(false);
        dibujarTablaContactoProveedor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popContactos = new javax.swing.JPopupMenu();
        itemEditar = new javax.swing.JMenuItem();
        itemEliminar = new javax.swing.JMenuItem();
        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        chkInactivos = new javax.swing.JCheckBox();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        jSeparator19 = new javax.swing.JToolBar.Separator();
        btnEditar = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JToolBar.Separator();
        btnBaja = new javax.swing.JButton();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        lProveedores = new javax.swing.JList<>();
        pForm = new javax.swing.JPanel();
        tpGestionProveedor = new javax.swing.JTabbedPane();
        pInformacionGeneral = new javax.swing.JPanel();
        pFormulario = new javax.swing.JPanel();
        txtNombre = new javax.swing.JLabel();
        lblGiro = new javax.swing.JLabel();
        txtGiro = new javax.swing.JLabel();
        lblNIT = new javax.swing.JLabel();
        txtNIT = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        txtIVA = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        txtMail = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        lblRepresentante = new javax.swing.JLabel();
        txtRepresentante = new javax.swing.JLabel();
        lblCta = new javax.swing.JLabel();
        txtCta = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JLabel();
        lblPlazo = new javax.swing.JLabel();
        txtPlazo = new javax.swing.JLabel();
        lblLimite = new javax.swing.JLabel();
        txtLimite = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pContactos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tContactoProveedor = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        itemEditar.setText("Editar");
        itemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarActionPerformed(evt);
            }
        });
        popContactos.add(itemEditar);

        itemEliminar.setText("Eliminar");
        itemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarActionPerformed(evt);
            }
        });
        popContactos.add(itemEliminar);

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
        chkInactivos.setText("Ver Bajas");
        chkInactivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        chkInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkInactivosActionPerformed(evt);
            }
        });
        toolBarTabla1.add(chkInactivos);
        toolBarTabla1.add(jSeparator18);

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
        jLabel1.setText("Proveedores");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        pTitulo.add(jLabel1, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/transport_64x64.png"))); // NOI18N
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
        tpProveedores.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tpProveedoresStateChanged(evt);
            }
        });

        pGestion.setBackground(colorBG);
        pGestion.setLayout(new java.awt.GridBagLayout());

        pTabla.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        pTabla.setMinimumSize(new java.awt.Dimension(300, 100));
        pTabla.setOpaque(false);
        pTabla.setPreferredSize(new java.awt.Dimension(450, 100));
        pTabla.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pGestion.add(pTabla, gridBagConstraints);

        pForm.setOpaque(false);
        pForm.setLayout(new java.awt.GridBagLayout());

        tpGestionProveedor.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tpGestionProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        pInformacionGeneral.setBackground(colorBG);
        pInformacionGeneral.setLayout(new java.awt.GridBagLayout());

        pFormulario.setMinimumSize(new java.awt.Dimension(400, 600));
        pFormulario.setOpaque(false);
        pFormulario.setPreferredSize(new java.awt.Dimension(400, 300));
        pFormulario.setLayout(new java.awt.GridBagLayout());

        txtNombre.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtNombre.setForeground(colorUI);
        txtNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 5, 5);
        pFormulario.add(txtNombre, gridBagConstraints);

        lblGiro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGiro.setText("Giro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 10, 5);
        pFormulario.add(lblGiro, gridBagConstraints);

        txtGiro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 15);
        pFormulario.add(txtGiro, gridBagConstraints);

        lblNIT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNIT.setText("NIT:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        pFormulario.add(lblNIT, gridBagConstraints);

        txtNIT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNIT.setPreferredSize(new java.awt.Dimension(125, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pFormulario.add(txtNIT, gridBagConstraints);

        lblIVA.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblIVA.setText("IVA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 10, 5);
        pFormulario.add(lblIVA, gridBagConstraints);

        txtIVA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIVA.setPreferredSize(new java.awt.Dimension(125, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        pFormulario.add(txtIVA, gridBagConstraints);

        lblDireccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDireccion.setText("Direccion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        pFormulario.add(lblDireccion, gridBagConstraints);

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        pFormulario.add(txtDireccion, gridBagConstraints);

        lblTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTelefono.setText("Telefono:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        pFormulario.add(lblTelefono, gridBagConstraints);

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        pFormulario.add(txtTelefono, gridBagConstraints);

        lblMail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMail.setText("E-Mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        pFormulario.add(lblMail, gridBagConstraints);

        txtMail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        pFormulario.add(txtMail, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        pFormulario.add(jSeparator9, gridBagConstraints);

        lblRepresentante.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblRepresentante.setText("Representante:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        pFormulario.add(lblRepresentante, gridBagConstraints);

        txtRepresentante.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        pFormulario.add(txtRepresentante, gridBagConstraints);

        lblCta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCta.setText("Cta. Bancaria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        pFormulario.add(lblCta, gridBagConstraints);

        txtCta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        pFormulario.add(txtCta, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        pFormulario.add(jSeparator8, gridBagConstraints);

        lblTipo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTipo.setText("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        pFormulario.add(lblTipo, gridBagConstraints);

        txtTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        pFormulario.add(txtTipo, gridBagConstraints);

        lblPlazo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPlazo.setText("Plazo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        pFormulario.add(lblPlazo, gridBagConstraints);

        txtPlazo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPlazo.setPreferredSize(new java.awt.Dimension(125, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pFormulario.add(txtPlazo, gridBagConstraints);

        lblLimite.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblLimite.setText("Limite:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 10, 5);
        pFormulario.add(lblLimite, gridBagConstraints);

        txtLimite.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtLimite.setPreferredSize(new java.awt.Dimension(125, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        pFormulario.add(txtLimite, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/Distributor-report64.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        pFormulario.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pInformacionGeneral.add(pFormulario, gridBagConstraints);

        tpGestionProveedor.addTab("Información General", pInformacionGeneral);

        pContactos.setBackground(colorBG);
        pContactos.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(jPanel1, gridBagConstraints);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/Contact.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel3, gridBagConstraints);

        tContactoProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tContactoProveedor.setComponentPopupMenu(popContactos);
        tContactoProveedor.setRowHeight(30);
        tContactoProveedor.getTableHeader().setReorderingAllowed(false);
        tContactoProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tContactoProveedorMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tContactoProveedor);
        if (tContactoProveedor.getColumnModel().getColumnCount() > 0) {
            tContactoProveedor.getColumnModel().getColumn(0).setMinWidth(0);
            tContactoProveedor.getColumnModel().getColumn(0).setPreferredWidth(0);
            tContactoProveedor.getColumnModel().getColumn(0).setMaxWidth(0);
            tContactoProveedor.getColumnModel().getColumn(1).setResizable(false);
            tContactoProveedor.getColumnModel().getColumn(2).setMinWidth(200);
            tContactoProveedor.getColumnModel().getColumn(2).setPreferredWidth(200);
            tContactoProveedor.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jScrollPane1, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(colorUI);
        jLabel4.setText("Contactos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pContactos.add(jPanel3, gridBagConstraints);

        tpGestionProveedor.addTab("Contactos", pContactos);

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
            cargarSeleccion(lProveedores.getSelectedValue().getId()); 
            cargarTablaContactoProveedor();
        }
    }//GEN-LAST:event_lProveedoresValueChanged

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        /*if(btnActivos.isSelected()){
            cargarListProveedores(true);
        }else{
            cargarListProveedores(false);
        }*/
        cargarListProveedores(chkInactivos.isSelected());
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void tpProveedoresStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpProveedoresStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tpProveedoresStateChanged

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        if(chkInactivos.isSelected()){
            nuevoProveedor();
        }else{
            if(tpGestionProveedor.getSelectedIndex() == 0){
                nuevoProveedor();
            }else if(tpGestionProveedor.getSelectedIndex() == 1){
                nuevoContactoProvedor();
            }
        }        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(!chkInactivos.isSelected()){
            if(tpGestionProveedor.getSelectedIndex() == 0){
                editarProveedor();
            }else if(tpGestionProveedor.getSelectedIndex() == 1){
                if(tContactoProveedor.getRowCount()>0){
                    editarContactoProveedor();
                }else{
                    editarProveedor(); 
                } 
            }
        }        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        // TODO add your handling code here:
        if(lProveedores.getModel().getSize()>0){
            if(chkInactivos.isSelected()){ 
                altaProveedor();
            }else{
                bajaProveedor();
            }
            cargarListProveedores(chkInactivos.isSelected());
        }
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        Reportes.reporteProveedores();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void itemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarActionPerformed
        // TODO add your handling code here:
        editarContactoProveedor();
    }//GEN-LAST:event_itemEditarActionPerformed

    private void itemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarActionPerformed
        // TODO add your handling code here:
        int idContactoProveedor = (int) tContactoProveedor.getValueAt(tContactoProveedor.getSelectedRow(),0);
        create.delete(CONTACTO_PROVEEDOR)
                .where(CONTACTO_PROVEEDOR.IDCONTACTO.equal(idContactoProveedor))
                .execute();
        new Mensajes().mensajeInfo("Registro Eliminado Exitosamente");
        cargarTablaContactoProveedor();
    }//GEN-LAST:event_itemEliminarActionPerformed

    private void tContactoProveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tContactoProveedorMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tContactoProveedor.rowAtPoint(point);
        tContactoProveedor.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tContactoProveedorMousePressed

    private void chkInactivosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkInactivosItemStateChanged
        // TODO add your handling code here:
        if(chkInactivos.isSelected()){
            btnBaja.setText("Alta");
        }else{
            btnBaja.setText("Baja");
        }        
        cargarListProveedores(chkInactivos.isSelected());
    }//GEN-LAST:event_chkInactivosItemStateChanged

    private void chkInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkInactivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkInactivosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JCheckBox chkInactivos;
    private javax.swing.JMenuItem itemEditar;
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JToolBar.Separator jSeparator19;
    private javax.swing.JToolBar.Separator jSeparator20;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JList<Proveedor> lProveedores;
    private javax.swing.JLabel lblCta;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblGiro;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblLimite;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNIT;
    private javax.swing.JLabel lblPlazo;
    private javax.swing.JLabel lblRepresentante;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel pContactos;
    private javax.swing.JPanel pForm;
    private javax.swing.JPanel pFormulario;
    private javax.swing.JPanel pGestion;
    private javax.swing.JPanel pInformacionGeneral;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTabla;
    private javax.swing.JPanel pTabs;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JPopupMenu popContactos;
    private javax.swing.JTable tContactoProveedor;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpGestionProveedor;
    private javax.swing.JTabbedPane tpProveedores;
    private javax.swing.JLabel txtCta;
    private javax.swing.JLabel txtDireccion;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JLabel txtGiro;
    private javax.swing.JLabel txtIVA;
    private javax.swing.JLabel txtLimite;
    private javax.swing.JLabel txtMail;
    private javax.swing.JLabel txtNIT;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtPlazo;
    private javax.swing.JLabel txtRepresentante;
    private javax.swing.JLabel txtTelefono;
    private javax.swing.JLabel txtTipo;
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
    
    private void cargarSeleccion(int id){
        Record r = create.select()
                .from(PROVEEDOR)
                .where(PROVEEDOR.IDPROVEEDOR.equal(id))
                .fetchOne();
        txtNombre.setText(r.getValue(PROVEEDOR.NOMBRE));
        txtGiro.setText(r.getValue(PROVEEDOR.GIRO));
        txtNIT.setText(r.getValue(PROVEEDOR.NIT));
        txtIVA.setText(r.getValue(PROVEEDOR.IVA));
        txtDireccion.setText(r.getValue(PROVEEDOR.DIRECCION));
        txtTelefono.setText(r.getValue(PROVEEDOR.TELEFONO));
        txtMail.setText(r.getValue(PROVEEDOR.EMAIL));
        txtRepresentante.setText(r.getValue(PROVEEDOR.REPRESENTANTE));
        txtCta.setText(r.getValue(PROVEEDOR.CTABANCARIA));
        txtTipo.setText(r.getValue(PROVEEDOR.TIPOPROVEEDOR));
        txtPlazo.setText(r.getValue(PROVEEDOR.PLAZO)+" Días");
        txtLimite.setText("$ "+r.getValue(PROVEEDOR.LIMITE).doubleValue());
        cargarTablaContactoProveedor();
    }
    
    private void cargarTablaContactoProveedor(){
        for(int i=0; i<tContactoProveedor.getRowCount(); i++){
            dtmContactoProveedor.removeRow(i);
            i-=1;
        }
        Result<Record3<Integer, String, String>> result = create
                .select(CONTACTO_PROVEEDOR.IDCONTACTO,
                CONTACTO_PROVEEDOR.NOMBRE, CONTACTO_PROVEEDOR.TELEFONO)
                .from(CONTACTO_PROVEEDOR)
                .where(CONTACTO_PROVEEDOR.IDPROVEEDOR.equal(lProveedores.getSelectedValue().getId()))
                .orderBy(CONTACTO_PROVEEDOR.NOMBRE.asc())
                .fetch();
        for (Record r : result) {
            dtmContactoProveedor.addRow(r.intoArray());
        }
        if(tContactoProveedor.getRowCount()>0){
            tContactoProveedor.changeSelection(0, 1, false, false);
        }
    }
    
    private void dibujarTablaContactoProveedor(){        
        tContactoProveedor.setGridColor(colorUI);
        
        JTableHeader jtableHeader = tContactoProveedor.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tContactoProveedor.setTableHeader(  jtableHeader );
        
        
        tContactoProveedor.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tContactoProveedor.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tContactoProveedor.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tContactoProveedor.repaint();
    }
    
    private void nuevoProveedor(){
        DialogProveedor dialog = new DialogProveedor(new javax.swing.JFrame(), true, "Nuevo Proveedor");
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro Agregado Exitosamente");
            cargarListProveedores(false);
        }
        dialog.dispose();
    }
    
    private void editarProveedor(){
        DialogProveedor dialog = new DialogProveedor(new javax.swing.JFrame(), true, "Editar Proveedor",lProveedores.getSelectedValue().getId());
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro Editado Exitosamente");
            cargarListProveedores(false);
        }
        dialog.dispose();
    }
    
    private void bajaProveedor(){
        int r = new Mensajes().mensajeSiNo("Desea dar baja el registro?");
        if(r==0){
            create.update(PROVEEDOR)
                    .set(PROVEEDOR.BAJA, true)
                    .where(PROVEEDOR.IDPROVEEDOR.equal(lProveedores.getSelectedValue().getId()))
                    .execute();
            cargarListProveedores(true);
        }        
    }
    
    private void altaProveedor(){
        create.update(PROVEEDOR)
        .set(PROVEEDOR.BAJA, false)
        .where(PROVEEDOR.IDPROVEEDOR.equal(lProveedores.getSelectedValue().getId()))
        .execute();
        cargarListProveedores(true);
    }
    
    private void nuevoContactoProvedor(){
        DialogContactoProveedor dialog = new DialogContactoProveedor(
                new javax.swing.JFrame(), 
                true, 
                "Nuevo Contacto",
                lProveedores.getSelectedValue().getId() 
        );
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro Agregado Exitosamente");
            cargarTablaContactoProveedor();
        }
        dialog.dispose();
    }
    
    private void editarContactoProveedor(){
        DialogContactoProveedor dialog = new DialogContactoProveedor(
                new javax.swing.JFrame(), 
                true, 
                "Editar Contacto",
                lProveedores.getSelectedValue().getId(),
                (int) tContactoProveedor.getValueAt(tContactoProveedor.getSelectedRow(), 0)
        );
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            new Mensajes().mensajeInfo("Registro Editado Exitosamente");
            cargarTablaContactoProveedor();
        }
        dialog.dispose();
    }
    
}
