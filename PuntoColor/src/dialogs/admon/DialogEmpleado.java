package dialogs.admon;

import clases.CargoEmpleado;
import clases.Encrypt;
import clases.Mensajes;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.tabbedpane.TabbedPanelUI;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.UpdateQuery;
import org.jooq.impl.DSL;

import static db.clases.Tables.CARGO;
import static db.clases.Tables.EMPLEADO;
import static db.clases.Tables.PERMISOS;
import static db.clases.Tables.USUARIO;
import static org.jooq.impl.DSL.count;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;

/* @author Jose Luis */
public class DialogEmpleado extends javax.swing.JDialog {

    DefaultComboBoxModel dcmCargoEmpleado = new DefaultComboBoxModel ();

    DSLContext create = DSL.using ( database.getConexion () , SQLDialect.POSTGRES_9_5 );

    private boolean guardado = false;

    boolean nuevo = true;

    boolean hayCat = true;

    int idEmpleado;

    public DialogEmpleado ( java.awt.Frame parent , boolean modal , String titulo ) {
        super ( parent , modal );
        cargarCargos ();
        initComponents ();
        this.setLocationRelativeTo ( null );
        this.setTitle ( titulo );
    }

    public DialogEmpleado ( java.awt.Frame parent , boolean modal , String titulo , int idEmp ) {
        super ( parent , modal );
        this.nuevo = false;
        cargarCargos ();
        initComponents ();
        this.setLocationRelativeTo ( null );
        this.setTitle ( titulo );
        this.idEmpleado = idEmp;
        cargarForm ( idEmpleado );
        chkEditarUser.setVisible ( true );
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pMain = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCancelar = new javax.swing.JButton();
        pFormulario = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNIT = new javax.swing.JLabel();
        txtDUI = new javax.swing.JFormattedTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JFormattedTextField();
        lblMail = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cbxCargo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tpInventario = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        chkEditarUser = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        cbxRol = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        chkProductos = new javax.swing.JCheckBox();
        chkInventarios = new javax.swing.JCheckBox();
        chkFacturas = new javax.swing.JCheckBox();
        chkProveedores = new javax.swing.JCheckBox();
        chkPagos = new javax.swing.JCheckBox();
        chkEmpleados = new javax.swing.JCheckBox();
        chkInformacion = new javax.swing.JCheckBox();
        chkCostos = new javax.swing.JCheckBox();
        chkRespaldos = new javax.swing.JCheckBox();
        chkReportes = new javax.swing.JCheckBox();
        chkConfiguraciones = new javax.swing.JCheckBox();
        chkCajas = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        chkCatalogo = new javax.swing.JCheckBox();
        chkCotizaciones = new javax.swing.JCheckBox();
        chkPedidos = new javax.swing.JCheckBox();
        chkFacturacion = new javax.swing.JCheckBox();
        chkClientes = new javax.swing.JCheckBox();
        chkCobros = new javax.swing.JCheckBox();
        chkControlCajas = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        chkPedidosDisenio = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        chkPedidosProduccion = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pMain.setBackground(colorBG);
        pMain.setLayout(new java.awt.GridBagLayout());

        toolBarTabla1.setBackground(colorUI);
        toolBarTabla1.setBorder(null);
        toolBarTabla1.setFloatable(false);
        toolBarTabla1.setRollover(true);
        toolBarTabla1.setMaximumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setMinimumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setPreferredSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.add(jSeparator2);

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardar.setForeground(colorTexto);
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnGuardar);
        btnGuardar.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));
        toolBarTabla1.add(jSeparator1);

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setForeground(colorTexto);
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnCancelar);
        btnCancelar.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pMain.add(toolBarTabla1, gridBagConstraints);

        pFormulario.setBackground(new java.awt.Color(255, 255, 255));
        pFormulario.setMinimumSize(new java.awt.Dimension(350, 500));
        pFormulario.setOpaque(false);
        pFormulario.setPreferredSize(new java.awt.Dimension(350, 500));
        pFormulario.setLayout(new java.awt.GridBagLayout());

        lblNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNombre.setText("(*) Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblNombre, gridBagConstraints);

        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre.setMinimumSize(new java.awt.Dimension(6, 30));
        txtNombre.setPreferredSize(new java.awt.Dimension(6, 30));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtNombre, gridBagConstraints);

        lblNIT.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNIT.setText("DUI:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblNIT, gridBagConstraints);

        try {
            txtDUI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDUI.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDUI.setMinimumSize(new java.awt.Dimension(6, 30));
        txtDUI.setPreferredSize(new java.awt.Dimension(6, 30));
        txtDUI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDUIKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtDUI, gridBagConstraints);

        lblDireccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDireccion.setText("(*) Direccion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblDireccion, gridBagConstraints);

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDireccion.setMinimumSize(new java.awt.Dimension(6, 30));
        txtDireccion.setPreferredSize(new java.awt.Dimension(6, 30));
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtDireccion, gridBagConstraints);

        lblTelefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTelefono.setText("Telefono:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblTelefono, gridBagConstraints);

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTelefono.setMinimumSize(new java.awt.Dimension(6, 30));
        txtTelefono.setPreferredSize(new java.awt.Dimension(6, 30));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtTelefono, gridBagConstraints);

        lblMail.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblMail.setText("E-Mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblMail, gridBagConstraints);

        txtMail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMail.setMinimumSize(new java.awt.Dimension(6, 30));
        txtMail.setPreferredSize(new java.awt.Dimension(6, 30));
        txtMail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMailKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtMail, gridBagConstraints);

        lblTipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTipo.setText("Cargo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblTipo, gridBagConstraints);

        cbxCargo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbxCargo.setModel(dcmCargoEmpleado);
        cbxCargo.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        cbxCargo.setMinimumSize(new java.awt.Dimension(150, 30));
        cbxCargo.setPreferredSize(new java.awt.Dimension(150, 30));
        cbxCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbxCargoKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(cbxCargo, gridBagConstraints);
        cbxCargo.setUI(new ComboUI(colorBG,java.awt.Color.GRAY));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/256/Student-id256.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        pFormulario.add(jLabel9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pMain.add(pFormulario, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(471, 621));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        tpInventario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jPanel3.setBackground(colorBG);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("(*) Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(30, 10, 5, 10);
        jPanel5.add(jLabel1, gridBagConstraints);

        txtUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser.setMinimumSize(new java.awt.Dimension(200, 30));
        txtUser.setPreferredSize(new java.awt.Dimension(200, 40));
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel5.add(txtUser, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("(*) Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel5.add(jLabel2, gridBagConstraints);

        txtPass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPass.setMinimumSize(new java.awt.Dimension(200, 30));
        txtPass.setPreferredSize(new java.awt.Dimension(200, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel5.add(txtPass, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/256/Portrait256.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 20, 0);
        jPanel5.add(jLabel3, gridBagConstraints);

        chkEditarUser.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chkEditarUser.setText("Editar Usuario y Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 10);
        jPanel5.add(chkEditarUser, gridBagConstraints);
        chkEditarUser.setVisible(false);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jPanel5, gridBagConstraints);

        tpInventario.addTab("Cuenta de Usuario", jPanel3);

        jPanel4.setBackground(colorBG);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        cbxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libre", "Ventas", "Diseño", "Producción", "Administración" }));
        cbxRol.setPreferredSize(new java.awt.Dimension(150, 30));
        cbxRol.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxRolItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel4.add(cbxRol, gridBagConstraints);
        cbxRol.setUI(new ComboUI(colorBG,java.awt.Color.GRAY));

        jPanel1.setBorder(new javax.swing.border.LineBorder(colorUI, 1, true));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("ADMINISTRACION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        chkProductos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkProductos.setText("Productos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(chkProductos, gridBagConstraints);

        chkInventarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkInventarios.setText("Inventarios");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(chkInventarios, gridBagConstraints);

        chkFacturas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkFacturas.setText("Facturas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(chkFacturas, gridBagConstraints);

        chkProveedores.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkProveedores.setText("Proveedores");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(chkProveedores, gridBagConstraints);

        chkPagos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkPagos.setText("Pagos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(chkPagos, gridBagConstraints);

        chkEmpleados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkEmpleados.setText("Empleados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(chkEmpleados, gridBagConstraints);

        chkInformacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkInformacion.setText("Mi Información");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(chkInformacion, gridBagConstraints);

        chkCostos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkCostos.setText("Costos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(chkCostos, gridBagConstraints);

        chkRespaldos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkRespaldos.setText("Respaldos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(chkRespaldos, gridBagConstraints);

        chkReportes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkReportes.setText("Reportes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(chkReportes, gridBagConstraints);

        chkConfiguraciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkConfiguraciones.setText("Configuraciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(chkConfiguraciones, gridBagConstraints);

        chkCajas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkCajas.setText("Cajas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(chkCajas, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 20, 5);
        jPanel4.add(jPanel1, gridBagConstraints);

        jPanel6.setBorder(new javax.swing.border.LineBorder(colorUI, 1, true));
        jPanel6.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("VENTAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        jPanel6.add(jLabel5, gridBagConstraints);

        chkCatalogo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkCatalogo.setText("Catálogo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel6.add(chkCatalogo, gridBagConstraints);

        chkCotizaciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkCotizaciones.setText("Cotizaciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel6.add(chkCotizaciones, gridBagConstraints);

        chkPedidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkPedidos.setText("Pedidos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel6.add(chkPedidos, gridBagConstraints);

        chkFacturacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkFacturacion.setText("Facturación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel6.add(chkFacturacion, gridBagConstraints);

        chkClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkClientes.setText("Clientes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel6.add(chkClientes, gridBagConstraints);

        chkCobros.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkCobros.setText("Cobros");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel6.add(chkCobros, gridBagConstraints);

        chkControlCajas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkControlCajas.setText("Control de Cajas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel6.add(chkControlCajas, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 20, 5);
        jPanel4.add(jPanel6, gridBagConstraints);

        jPanel7.setBorder(new javax.swing.border.LineBorder(colorUI, 1, true));
        jPanel7.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("DISEÑO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        jPanel7.add(jLabel6, gridBagConstraints);

        chkPedidosDisenio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkPedidosDisenio.setText("<html><body>Pedidos en<br>Diseño</body></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel7.add(chkPedidosDisenio, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 20, 5);
        jPanel4.add(jPanel7, gridBagConstraints);

        jPanel8.setBorder(new javax.swing.border.LineBorder(colorUI, 1, true));
        jPanel8.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel8.setOpaque(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("PRODUCCION");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        jPanel8.add(jLabel7, gridBagConstraints);

        chkPedidosProduccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chkPedidosProduccion.setText("<html><body>Pedidos en<br>Producción</body></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel8.add(chkPedidosProduccion, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 20, 5);
        jPanel4.add(jPanel8, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("ROL:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel4.add(jLabel8, gridBagConstraints);

        tpInventario.addTab("Permisos", jPanel4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(tpInventario, gridBagConstraints);
        tpInventario.setUI(new TabbedPanelUI(colorUI,colorBG));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pMain.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pMain, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // TODO add your handling code here:
            database.getConexion ().setAutoCommit ( false );
            if ( nuevo ) {
                if ( isComplete () ) {
                    if ( isCuenta () ) {
                        new Mensajes ().mensajeAlert ( "Esa cuenta ya esta asignada a otro empleado" );
                        txtUser.setText ( "" );
                        txtPass.setText ( "" );
                    } else {
                        int idEmp = guardarEmpleado ();
                        int idUsuario = guardarUsuario ( idEmp );
                        guardarPermiso ( idUsuario );
                        setGuardado ( true );
                        database.getConexion ().commit ();
                        database.getConexion ().setAutoCommit ( true );
                        dispose ();
                    }
                } else {
                    new Mensajes ().mensajeError ( "Verificar los campos requeridos" );
                }
            } else {
                if ( chkEditarUser.isSelected () ) {
                    if ( isComplete () ) {
                        if ( isCuenta () ) {
                            new Mensajes ().mensajeAlert ( "Esa cuenta ya esta asignada a otro empleado" );
                            txtUser.setText ( "" );
                            txtPass.setText ( "" );
                        } else {
                            editarEmpleado ();
                            editarUsuario ();
                            editarPermisos ();
                            setGuardado ( true );
                            database.getConexion ().commit ();
                            database.getConexion ().setAutoCommit ( true );
                            dispose ();
                        }
                    } else {
                        new Mensajes ().mensajeError ( "Verificar los campos requeridos" );
                    }
                } else {
                    if ( isCompleteWOuser () ) {
                        editarEmpleado ();
                        editarPermisos ();
                        setGuardado ( true );
                        database.getConexion ().commit ();
                        database.getConexion ().setAutoCommit ( true );
                        dispose ();
                    } else {
                        new Mensajes ().mensajeError ( "Verificar los campos requeridos" );
                    }
                }
            }
        } catch ( SQLException ex ) {
            Logger.getLogger ( DialogEmpleado.class.getName () ).log ( Level.SEVERE , null , ex );
        } catch ( Exception ex ) {
            Logger.getLogger ( DialogEmpleado.class.getName () ).log ( Level.SEVERE , null , ex );
            new Mensajes ().mensajeError ( "Ha ocurrido error inesperado al guardar Registro" );
            try {
                database.getConexion ().rollback ();
            } catch ( SQLException ex1 ) {
                Logger.getLogger ( DialogEmpleado.class.getName () ).log ( Level.SEVERE , null , ex1 );
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose ();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxRolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxRolItemStateChanged
        // TODO add your handling code here:
        switch ( cbxRol.getSelectedIndex () ) {
            case 0:
                selectLibre ();
                break;
            case 1:
                selectVentas ();
                break;
            case 2:
                selectDisenio ();
                break;
            case 3:
                selectProduccion ();
                break;
            default:
                selectAdmin ();
                break;
        }
    }//GEN-LAST:event_cbxRolItemStateChanged

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        // TODO add your handling code here:
        if ( evt.getKeyCode () == KeyEvent.VK_ENTER ) {
            txtMail.requestFocus ();
        }
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        if ( evt.getKeyCode () == KeyEvent.VK_ENTER ) {
            txtDUI.requestFocus ();
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        // TODO add your handling code here:
        if ( evt.getKeyCode () == KeyEvent.VK_ENTER ) {
            txtTelefono.requestFocus ();
        }
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtMailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailKeyReleased
        // TODO add your handling code here:
        if ( evt.getKeyCode () == KeyEvent.VK_ENTER ) {
            cbxCargo.requestFocus ();
        }
    }//GEN-LAST:event_txtMailKeyReleased

    private void cbxCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxCargoKeyReleased
        // TODO add your handling code here:
        if ( evt.getKeyCode () == KeyEvent.VK_ENTER ) {
            txtUser.requestFocus ();
        }
    }//GEN-LAST:event_cbxCargoKeyReleased

    private void txtUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyReleased
        // TODO add your handling code here:
        if ( evt.getKeyCode () == KeyEvent.VK_ENTER ) {
            txtPass.requestFocus ();
        }
    }//GEN-LAST:event_txtUserKeyReleased

    private void txtDUIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDUIKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDUIKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxCargo;
    private javax.swing.JComboBox<String> cbxRol;
    private javax.swing.JCheckBox chkCajas;
    private javax.swing.JCheckBox chkCatalogo;
    private javax.swing.JCheckBox chkClientes;
    private javax.swing.JCheckBox chkCobros;
    private javax.swing.JCheckBox chkConfiguraciones;
    private javax.swing.JCheckBox chkControlCajas;
    private javax.swing.JCheckBox chkCostos;
    private javax.swing.JCheckBox chkCotizaciones;
    private javax.swing.JCheckBox chkEditarUser;
    private javax.swing.JCheckBox chkEmpleados;
    private javax.swing.JCheckBox chkFacturacion;
    private javax.swing.JCheckBox chkFacturas;
    private javax.swing.JCheckBox chkInformacion;
    private javax.swing.JCheckBox chkInventarios;
    private javax.swing.JCheckBox chkPagos;
    private javax.swing.JCheckBox chkPedidos;
    private javax.swing.JCheckBox chkPedidosDisenio;
    private javax.swing.JCheckBox chkPedidosProduccion;
    private javax.swing.JCheckBox chkProductos;
    private javax.swing.JCheckBox chkProveedores;
    private javax.swing.JCheckBox chkReportes;
    private javax.swing.JCheckBox chkRespaldos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNIT;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel pFormulario;
    private javax.swing.JPanel pMain;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTabbedPane tpInventario;
    private javax.swing.JFormattedTextField txtDUI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JFormattedTextField txtTelefono;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private void cargarForm ( int idEmpleado ) {
        Record r = create.select ()
                .from ( EMPLEADO )
                .where ( EMPLEADO.IDEMPLEADO.equal ( idEmpleado ) )
                .fetchOne ();
        txtNombre.setText ( r.getValue ( EMPLEADO.NOMBRE ) );
        txtDUI.setText ( r.getValue ( EMPLEADO.DUI ) );
        txtDireccion.setText ( r.getValue ( EMPLEADO.DIRECCION ) );
        txtTelefono.setText ( r.getValue ( EMPLEADO.TELEFONO ) );
        txtMail.setText ( r.getValue ( EMPLEADO.EMAIL ) );
        for ( int i = 0 ; i < cbxCargo.getItemCount () ; i++ ) {
            cbxCargo.setSelectedIndex ( i );
            CargoEmpleado cargo = ( CargoEmpleado ) cbxCargo.getSelectedItem ();
            if ( cargo.getIdCargo () == r.getValue ( EMPLEADO.IDCARGO ) ) {
                break;
            }
        }
        cargarPermisos ();
    }

    private void cargarCargos () {
        dcmCargoEmpleado.removeAllElements ();
        Result<Record> result = create.select ()
                .from ( CARGO )
                .fetch ();
        for ( Record r : result ) {
            dcmCargoEmpleado.addElement ( new CargoEmpleado (
                    r.getValue ( CARGO.IDCARGO ) ,
                    r.getValue ( CARGO.CARGO_ )
            ) );
        }
    }

    private int guardarEmpleado () throws Exception {
        int idEmpo = 0;
        CargoEmpleado ce = ( CargoEmpleado ) dcmCargoEmpleado.getSelectedItem ();
        idEmpo = create.insertInto ( EMPLEADO )
                .set ( EMPLEADO.NOMBRE , txtNombre.getText () )
                .set ( EMPLEADO.DIRECCION , txtDireccion.getText () )
                .set ( EMPLEADO.TELEFONO , txtTelefono.getText () )
                .set ( EMPLEADO.EMAIL , txtMail.getText () )
                .set ( EMPLEADO.DUI , txtDUI.getText () )
                .set ( EMPLEADO.IDCARGO , ce.getIdCargo () )
                .returning ( EMPLEADO.IDEMPLEADO )
                .fetchOne ()
                .getValue ( EMPLEADO.IDEMPLEADO );
        return idEmpo;
    }

    private int guardarUsuario ( int idEmpleado ) throws Exception {
        int idUsuario = 0;
        char passArray[] = txtPass.getPassword ();
        String pass = new String ( passArray );
        idUsuario = create.insertInto ( USUARIO )
                .set ( USUARIO.USUARIO_ , Encrypt.EncrypSHA ( Encrypt.EncrypMD5 ( txtUser.getText () ) ) )
                .set ( USUARIO.PASS , Encrypt.EncrypSHA ( Encrypt.EncrypMD5 ( pass ) ) )
                .set ( USUARIO.IDEMPLEADO , idEmpleado )
                .returning ( USUARIO.IDUSUARIO )
                .fetchOne ()
                .getValue ( USUARIO.IDUSUARIO );
        return idUsuario;
    }

    private void guardarPermiso ( int idusuario ) throws Exception {
        create.insertInto ( PERMISOS )
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 1 )
                .set ( PERMISOS.PERMISO , chkCatalogo.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 2 )
                .set ( PERMISOS.PERMISO , chkCotizaciones.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 3 )
                .set ( PERMISOS.PERMISO , chkPedidos.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 4 )
                .set ( PERMISOS.PERMISO , chkFacturacion.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 5 )
                .set ( PERMISOS.PERMISO , chkCobros.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 6 )
                .set ( PERMISOS.PERMISO , chkClientes.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 7 )
                .set ( PERMISOS.PERMISO , chkPedidosDisenio.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 8 )
                .set ( PERMISOS.PERMISO , chkPedidosProduccion.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 9 )
                .set ( PERMISOS.PERMISO , chkProductos.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 10 )
                .set ( PERMISOS.PERMISO , chkInventarios.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 11 )
                .set ( PERMISOS.PERMISO , chkFacturas.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 12 )
                .set ( PERMISOS.PERMISO , chkPagos.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 13 )
                .set ( PERMISOS.PERMISO , chkProveedores.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 14 )
                .set ( PERMISOS.PERMISO , chkEmpleados.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 15 )
                .set ( PERMISOS.PERMISO , chkInformacion.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 16 )
                .set ( PERMISOS.PERMISO , chkCostos.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 17 )
                .set ( PERMISOS.PERMISO , chkRespaldos.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 18 )
                .set ( PERMISOS.PERMISO , chkReportes.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 19 )
                .set ( PERMISOS.PERMISO , chkConfiguraciones.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 20 )
                .set ( PERMISOS.PERMISO , chkControlCajas.isSelected () )
                .newRecord ()
                .set ( PERMISOS.IDUSUARIO , idusuario )
                .set ( PERMISOS.IDROL , 21 )
                .set ( PERMISOS.PERMISO , chkCajas.isSelected () )
                .execute ();
    }

    private void selectAdmin () {
        /*esto es exclusivo de admin*/
        chkProductos.setSelected ( true );
        chkInventarios.setSelected ( true );
        chkFacturas.setSelected ( true );
        chkPagos.setSelected ( true );
        chkProveedores.setSelected ( true );
        chkEmpleados.setSelected ( true );
        chkInformacion.setSelected ( true );
        chkCostos.setSelected ( true );
        chkRespaldos.setSelected ( true );
        chkReportes.setSelected ( true );
        chkConfiguraciones.setSelected ( true );
        chkCajas.setSelected ( true );
        /*ventas*/
        chkCatalogo.setSelected ( true );
        chkPedidos.setSelected ( true );
        chkCotizaciones.setSelected ( true );
        chkFacturacion.setSelected ( true );
        chkCobros.setSelected ( true );
        chkClientes.setSelected ( true );
        chkControlCajas.setSelected ( true );
        /*disenio*/
        chkPedidosDisenio.setSelected ( true );
        /*produccion*/
        chkPedidosProduccion.setSelected ( true );
    }

    private void selectVentas () {
        /*esto es exclusivo de admin*/
        chkProductos.setSelected ( false );
        chkInventarios.setSelected ( false );
        chkFacturas.setSelected ( false );
        chkPagos.setSelected ( false );
        chkProveedores.setSelected ( false );
        chkEmpleados.setSelected ( false );
        chkInformacion.setSelected ( false );
        chkCostos.setSelected ( false );
        chkRespaldos.setSelected ( false );
        chkReportes.setSelected ( false );
        chkConfiguraciones.setSelected ( false );
        chkCajas.setSelected ( false );
        /*ventas*/
        chkCatalogo.setSelected ( true );
        chkPedidos.setSelected ( true );
        chkCotizaciones.setSelected ( true );
        chkFacturacion.setSelected ( true );
        chkCobros.setSelected ( true );
        chkClientes.setSelected ( true );
        chkControlCajas.setSelected ( true );
        /*disenio*/
        chkPedidosDisenio.setSelected ( false );
        /*produccion*/
        chkPedidosProduccion.setSelected ( false );
    }

    private void selectDisenio () {
        /*esto es exclusivo de admin*/
        chkProductos.setSelected ( false );
        chkInventarios.setSelected ( false );
        chkFacturas.setSelected ( false );
        chkPagos.setSelected ( false );
        chkProveedores.setSelected ( false );
        chkEmpleados.setSelected ( false );
        chkInformacion.setSelected ( false );
        chkCostos.setSelected ( false );
        chkRespaldos.setSelected ( false );
        chkReportes.setSelected ( false );
        chkConfiguraciones.setSelected ( false );
        chkCajas.setSelected ( false );
        /*ventas*/
        chkCatalogo.setSelected ( false );
        chkPedidos.setSelected ( false );
        chkCotizaciones.setSelected ( false );
        chkFacturacion.setSelected ( false );
        chkCobros.setSelected ( false );
        chkClientes.setSelected ( false );
        chkControlCajas.setSelected ( false );
        /*disenio*/
        chkPedidosDisenio.setSelected ( true );
        /*produccion*/
        chkPedidosProduccion.setSelected ( false );
    }

    private void selectProduccion () {
        /*esto es exclusivo de admin*/
        chkProductos.setSelected ( false );
        chkInventarios.setSelected ( false );
        chkFacturas.setSelected ( false );
        chkPagos.setSelected ( false );
        chkProveedores.setSelected ( false );
        chkEmpleados.setSelected ( false );
        chkInformacion.setSelected ( false );
        chkCostos.setSelected ( false );
        chkRespaldos.setSelected ( false );
        chkReportes.setSelected ( false );
        chkConfiguraciones.setSelected ( false );
        chkCajas.setSelected ( false );
        /*ventas*/
        chkCatalogo.setSelected ( false );
        chkPedidos.setSelected ( false );
        chkCotizaciones.setSelected ( false );
        chkFacturacion.setSelected ( false );
        chkCobros.setSelected ( false );
        chkClientes.setSelected ( false );
        chkControlCajas.setSelected ( false );
        /*disenio*/
        chkPedidosDisenio.setSelected ( false );
        /*produccion*/
        chkPedidosProduccion.setSelected ( true );
    }

    private void selectLibre () {
        /*esto es exclusivo de admin*/
        chkProductos.setSelected ( false );
        chkInventarios.setSelected ( false );
        chkFacturas.setSelected ( false );
        chkPagos.setSelected ( false );
        chkProveedores.setSelected ( false );
        chkEmpleados.setSelected ( false );
        chkInformacion.setSelected ( false );
        chkCostos.setSelected ( false );
        chkRespaldos.setSelected ( false );
        chkReportes.setSelected ( false );
        chkConfiguraciones.setSelected ( false );
        chkCajas.setSelected ( false );
        /*ventas*/
        chkCatalogo.setSelected ( false );
        chkPedidos.setSelected ( false );
        chkCotizaciones.setSelected ( false );
        chkFacturacion.setSelected ( false );
        chkCobros.setSelected ( false );
        chkClientes.setSelected ( false );
        chkControlCajas.setSelected ( false );
        /*disenio*/
        chkPedidosDisenio.setSelected ( false );
        /*produccion*/
        chkPedidosProduccion.setSelected ( false );
    }

    private boolean isCuenta () {
        int contador = 0;
        contador = create.select ( count () )
                .from ( USUARIO )
                .where ( USUARIO.USUARIO_.endsWith ( Encrypt.EncrypSHA ( Encrypt.EncrypMD5 ( txtUser.getText () ) ) ) )
                .fetchOne ( count () );
        return contador > 0;
    }

    private boolean isComplete () {
        if ( txtNombre.getText () == null || txtNombre.getText ().equals ( "" ) ) {
            return false;
        } else if ( txtDireccion.getText () == null || txtDireccion.getText ().equals ( "" ) ) {
            return false;
        } else if ( txtUser.getText () == null || txtUser.getText ().equals ( "" ) ) {
            return false;
        } else {
            return txtPass.getPassword ().length > 0;
        }
    }

    /**
     * @return the guardado
     */
    public boolean isGuardado () {
        return guardado;
    }

    /**
     * @param guardado the guardado to set
     */
    public void setGuardado ( boolean guardado ) {
        this.guardado = guardado;
    }

    private void cargarPermisos () {
        Result<Record2<Integer , Boolean>> result = create
                .select ( PERMISOS.IDROL , PERMISOS.PERMISO )
                .from ( PERMISOS )
                .innerJoin ( USUARIO ).on ( USUARIO.IDUSUARIO.equal ( PERMISOS.IDUSUARIO ) )
                .innerJoin ( EMPLEADO ).on ( EMPLEADO.IDEMPLEADO.equal ( USUARIO.IDEMPLEADO ) )
                .where ( EMPLEADO.IDEMPLEADO.equal ( idEmpleado ) )
                .fetch ();
        for ( Record r : result ) {
            switch ( r.getValue ( PERMISOS.IDROL ) ) {
                case 1:
                    chkCatalogo.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 2:
                    chkCotizaciones.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 3:
                    chkPedidos.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 4:
                    chkFacturacion.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 5:
                    chkCobros.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 6:
                    chkClientes.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 7:
                    chkPedidosDisenio.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 8:
                    chkPedidosProduccion.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 9:
                    chkProductos.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 10:
                    chkInventarios.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 11:
                    chkFacturas.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 12:
                    chkPagos.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 13:
                    chkProveedores.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 14:
                    chkEmpleados.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 15:
                    chkInformacion.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 16:
                    chkCostos.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 17:
                    chkRespaldos.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 18:
                    chkReportes.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 19:
                    chkConfiguraciones.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 20:
                    chkControlCajas.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
                case 21:
                    chkCajas.setSelected ( r.getValue ( PERMISOS.PERMISO ) );
                    break;
            }
        }
    }

    private void editarUsuario () throws Exception {
        char passArray[] = txtPass.getPassword ();
        String pass = new String ( passArray );
        create.update ( USUARIO )
                .set ( USUARIO.USUARIO_ , Encrypt.EncrypSHA ( Encrypt.EncrypMD5 ( txtUser.getText () ) ) )
                .set ( USUARIO.PASS , Encrypt.EncrypSHA ( Encrypt.EncrypMD5 ( pass ) ) )
                .where ( USUARIO.IDEMPLEADO.equal ( this.idEmpleado ) )
                .execute ();

    }

    private void editarEmpleado () throws Exception {
        CargoEmpleado ce = ( CargoEmpleado ) dcmCargoEmpleado.getSelectedItem ();
        create.update ( EMPLEADO )
                .set ( EMPLEADO.NOMBRE , txtNombre.getText () )
                .set ( EMPLEADO.DIRECCION , txtDireccion.getText () )
                .set ( EMPLEADO.TELEFONO , txtTelefono.getText () )
                .set ( EMPLEADO.EMAIL , txtMail.getText () )
                .set ( EMPLEADO.DUI , txtDUI.getText () )
                .set ( EMPLEADO.IDCARGO , ce.getIdCargo () )
                .where ( EMPLEADO.IDEMPLEADO.equal ( idEmpleado ) )
                .execute ();
    }

    private void editarPermisos () {
        int idUser = create.select ( USUARIO.IDUSUARIO )
                .from ( USUARIO )
                .where ( USUARIO.IDEMPLEADO.equal ( this.idEmpleado ) )
                .fetchOne ( USUARIO.IDUSUARIO );
        Result<Record2<Integer , Boolean>> result = create
                .select ( PERMISOS.IDROL , PERMISOS.PERMISO )
                .from ( PERMISOS )
                .innerJoin ( USUARIO ).on ( USUARIO.IDUSUARIO.equal ( PERMISOS.IDUSUARIO ) )
                .innerJoin ( EMPLEADO ).on ( EMPLEADO.IDEMPLEADO.equal ( USUARIO.IDEMPLEADO ) )
                .where ( EMPLEADO.IDEMPLEADO.equal ( idEmpleado ) )
                .fetch ();
        for ( Record r : result ) {
            UpdateQuery query = create.updateQuery ( PERMISOS );
            switch ( r.getValue ( PERMISOS.IDROL ) ) {
                case 1:
                    query.addValue ( PERMISOS.PERMISO , chkCatalogo.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 2:
                    query.addValue ( PERMISOS.PERMISO , chkCotizaciones.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 3:
                    query.addValue ( PERMISOS.PERMISO , chkPedidos.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );

                    break;
                case 4:
                    query.addValue ( PERMISOS.PERMISO , chkFacturacion.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 5:
                    query.addValue ( PERMISOS.PERMISO , chkCobros.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 6:
                    query.addValue ( PERMISOS.PERMISO , chkClientes.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 7:
                    query.addValue ( PERMISOS.PERMISO , chkPedidosDisenio.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 8:
                    query.addValue ( PERMISOS.PERMISO , chkPedidosProduccion.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 9:
                    query.addValue ( PERMISOS.PERMISO , chkProductos.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 10:
                    query.addValue ( PERMISOS.PERMISO , chkInventarios.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 11:
                    query.addValue ( PERMISOS.PERMISO , chkFacturas.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 12:
                    query.addValue ( PERMISOS.PERMISO , chkPagos.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 13:
                    query.addValue ( PERMISOS.PERMISO , chkProveedores.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 14:
                    query.addValue ( PERMISOS.PERMISO , chkEmpleados.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 15:
                    query.addValue ( PERMISOS.PERMISO , chkInformacion.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 16:
                    query.addValue ( PERMISOS.PERMISO , chkCostos.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 17:
                    query.addValue ( PERMISOS.PERMISO , chkRespaldos.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 18:
                    query.addValue ( PERMISOS.PERMISO , chkReportes.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 19:
                    query.addValue ( PERMISOS.PERMISO , chkConfiguraciones.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 20:
                    query.addValue ( PERMISOS.PERMISO , chkControlCajas.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
                case 21:
                    query.addValue ( PERMISOS.PERMISO , chkCajas.isSelected () );
                    query.addConditions ( ( PERMISOS.IDROL.equal ( r.getValue ( PERMISOS.IDROL ) ) )
                            .and ( PERMISOS.IDUSUARIO.equal ( idUser ) ) );
                    break;
            }
            query.execute ();
        }
    }

    private boolean isCompleteWOuser () {
        if ( txtNombre.getText () == null || txtNombre.getText ().equals ( "" ) ) {
            return false;
        } else {
            return !( txtDireccion.getText () == null || txtDireccion.getText ().equals ( "" ) );
        }
    }
}
