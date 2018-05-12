
package dialogs.compras;

import clases.Mensajes;
import static db.clases.Tables.PROVEEDOR;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.spinner.SpinnerUI;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.DefaultComboBoxModel;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;

/* @author Jose Luis */
public class DialogProveedor extends javax.swing.JDialog {
    
    DefaultComboBoxModel dcmMedida = new DefaultComboBoxModel();
    DefaultComboBoxModel dcmUnidad = new DefaultComboBoxModel();
    DefaultComboBoxModel dcmCategoria = new DefaultComboBoxModel();
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    boolean nuevo = true;
    
    boolean hayCat = true;
    
    int idProv;

    public DialogProveedor(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);       
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
    }
    
    public DialogProveedor(java.awt.Frame parent, boolean modal, String titulo, int idProv){
        super(parent, modal);
        this.nuevo = false;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        this.idProv = idProv;
        cargarForm(idProv);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblTitulo = new javax.swing.JPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCancelar = new javax.swing.JButton();
        pFormulario = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblGiro = new javax.swing.JLabel();
        txtGiro = new javax.swing.JTextField();
        lblNIT = new javax.swing.JLabel();
        txtNIT = new javax.swing.JFormattedTextField();
        lblIVA = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JFormattedTextField();
        lblMail = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        lblRepresentante = new javax.swing.JLabel();
        txtRepresentante = new javax.swing.JTextField();
        lblCta = new javax.swing.JLabel();
        txtCta = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        lblTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        lblLimite = new javax.swing.JLabel();
        spPlazo = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spLimite = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(450, 650));
        setPreferredSize(new java.awt.Dimension(450, 650));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTitulo.setBackground(colorBG);
        lblTitulo.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        lblTitulo.add(toolBarTabla1, gridBagConstraints);

        pFormulario.setBackground(new java.awt.Color(255, 255, 255));
        pFormulario.setMinimumSize(new java.awt.Dimension(400, 600));
        pFormulario.setOpaque(false);
        pFormulario.setPreferredSize(new java.awt.Dimension(400, 600));
        pFormulario.setLayout(new java.awt.GridBagLayout());

        lblNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNombre.setText("(*) Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtNombre, gridBagConstraints);

        lblGiro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblGiro.setText("Giro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblGiro, gridBagConstraints);

        txtGiro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtGiro.setMinimumSize(new java.awt.Dimension(6, 30));
        txtGiro.setPreferredSize(new java.awt.Dimension(6, 30));
        txtGiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiroKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtGiro, gridBagConstraints);

        lblNIT.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNIT.setText("NIT:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblNIT, gridBagConstraints);

        try {
            txtNIT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-######-###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNIT.setMinimumSize(new java.awt.Dimension(100, 30));
        txtNIT.setPreferredSize(new java.awt.Dimension(100, 30));
        txtNIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNITKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtNIT, gridBagConstraints);

        lblIVA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblIVA.setText("NRC:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblIVA, gridBagConstraints);

        txtIVA.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtIVA.setMinimumSize(new java.awt.Dimension(100, 30));
        txtIVA.setPreferredSize(new java.awt.Dimension(100, 30));
        txtIVA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIVAKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtIVA, gridBagConstraints);

        lblDireccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDireccion.setText("(*) Direccion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtDireccion, gridBagConstraints);

        lblTelefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTelefono.setText("Telefono:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblTelefono, gridBagConstraints);

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.setMinimumSize(new java.awt.Dimension(100, 30));
        txtTelefono.setPreferredSize(new java.awt.Dimension(100, 30));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtTelefono, gridBagConstraints);

        lblMail.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblMail.setText("E-Mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
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
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtMail, gridBagConstraints);

        jSeparator5.setMinimumSize(new java.awt.Dimension(0, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        pFormulario.add(jSeparator5, gridBagConstraints);

        lblRepresentante.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblRepresentante.setText("(*) Representante:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblRepresentante, gridBagConstraints);

        txtRepresentante.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtRepresentante.setMinimumSize(new java.awt.Dimension(6, 30));
        txtRepresentante.setPreferredSize(new java.awt.Dimension(6, 30));
        txtRepresentante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRepresentanteKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtRepresentante, gridBagConstraints);

        lblCta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCta.setText("Cta. Bancaria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblCta, gridBagConstraints);

        txtCta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCta.setMinimumSize(new java.awt.Dimension(6, 30));
        txtCta.setPreferredSize(new java.awt.Dimension(6, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(txtCta, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        pFormulario.add(jSeparator8, gridBagConstraints);

        lblTipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTipo.setText("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblTipo, gridBagConstraints);

        cbxTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));
        cbxTipo.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        cbxTipo.setMinimumSize(new java.awt.Dimension(150, 30));
        cbxTipo.setPreferredSize(new java.awt.Dimension(150, 30));
        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(cbxTipo, gridBagConstraints);
        cbxTipo.setUI(new ComboUI(colorBG,java.awt.Color.GRAY));

        lblLimite.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblLimite.setText("Plazo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(lblLimite, gridBagConstraints);

        spPlazo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        spPlazo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 5));
        spPlazo.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        spPlazo.setEnabled(false);
        spPlazo.setMinimumSize(new java.awt.Dimension(150, 30));
        spPlazo.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(spPlazo, gridBagConstraints);
        spPlazo.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Limite:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        pFormulario.add(jLabel5, gridBagConstraints);

        spLimite.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        spLimite.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 9999.0d, 50.0d));
        spLimite.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        spLimite.setEnabled(false);
        spLimite.setMinimumSize(new java.awt.Dimension(150, 30));
        spLimite.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        pFormulario.add(spLimite, gridBagConstraints);
        spLimite.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/64/delivery_64x64.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        pFormulario.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        lblTitulo.add(pFormulario, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(lblTitulo, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try{
            if(isComplete()){
                if(nuevo){
                    nuevoProveedor();
                }else{
                    editarProveedor();
                }
                setGuardado(true);
                dispose();
            }else{
                new Mensajes().mensajeError("Verificar los campos requeridos!");
            }            
        }catch(Exception e){
            new Mensajes().mensajeError("ha ocurrido un error con la transacción");
            setGuardado(false);
        }        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtGiro.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtGiroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiroKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtNIT.requestFocus();
        }
    }//GEN-LAST:event_txtGiroKeyReleased

    private void txtNITKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNITKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtIVA.requestFocus();
        }
    }//GEN-LAST:event_txtNITKeyReleased

    private void txtIVAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIVAKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtDireccion.requestFocus();
        }
    }//GEN-LAST:event_txtIVAKeyReleased

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtTelefono.requestFocus();
        }
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtMail.requestFocus();
        }
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        // TODO add your handling code here:
        if(cbxTipo.getSelectedIndex()==0){
            spPlazo.setValue(0.0);
            spLimite.setValue(0.0);
            spPlazo.setEnabled(false);
            spLimite.setEnabled(false);
        }else{
            spPlazo.setEnabled(true);
            spLimite.setEnabled(true);
        }
    }//GEN-LAST:event_cbxTipoItemStateChanged

    private void txtMailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtRepresentante.requestFocus();
        }
    }//GEN-LAST:event_txtMailKeyReleased

    private void txtRepresentanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepresentanteKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtCta.requestFocus();
        }
    }//GEN-LAST:event_txtRepresentanteKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblCta;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblGiro;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblLimite;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNIT;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRepresentante;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel lblTitulo;
    private javax.swing.JPanel pFormulario;
    private javax.swing.JSpinner spLimite;
    private javax.swing.JSpinner spPlazo;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JTextField txtCta;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtGiro;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtMail;
    private javax.swing.JFormattedTextField txtNIT;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRepresentante;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
    
    private void cargarForm(int idProveedor){
        Record r = create.select()
                .from(PROVEEDOR)
                .where(PROVEEDOR.IDPROVEEDOR.equal(idProv))
                .fetchOne();
        txtNombre.setText(r.getValue(PROVEEDOR.NOMBRE));
        txtNombre.setText(r.getValue(PROVEEDOR.NOMBRE));
        txtGiro.setText(r.getValue(PROVEEDOR.GIRO));
        txtNIT.setText(r.getValue(PROVEEDOR.NIT));
        txtIVA.setText(r.getValue(PROVEEDOR.IVA));
        txtDireccion.setText(r.getValue(PROVEEDOR.DIRECCION));
        txtTelefono.setText(r.getValue(PROVEEDOR.TELEFONO));
        txtMail.setText(r.getValue(PROVEEDOR.EMAIL));
        txtRepresentante.setText(r.getValue(PROVEEDOR.REPRESENTANTE));
        txtCta.setText(r.getValue(PROVEEDOR.CTABANCARIA));
        cbxTipo.setSelectedItem(r.getValue(PROVEEDOR.TIPOPROVEEDOR));
        spPlazo.setValue(r.getValue(PROVEEDOR.PLAZO));
        spLimite.setValue(r.getValue(PROVEEDOR.LIMITE).doubleValue());
    }
    
    private boolean isComplete(){
        if(txtNombre.getText()==null || txtNombre.getText().equals("")){
            return false;
        }else if(txtDireccion.getText()==null || txtNombre.getText().equals("")){
            return false;
        }else return !(txtRepresentante.getText()==null || txtRepresentante.getText().equals(""));
    }

    /**
     * @return the guardado
     */
    public boolean isGuardado() {
        return guardado;
    }

    /**
     * @param guardado the guardado to set
     */
    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

    private void nuevoProveedor() throws Exception{
        create.insertInto(PROVEEDOR)
                .set(PROVEEDOR.NOMBRE,txtNombre.getText())
                .set(PROVEEDOR.GIRO,txtGiro.getText())
                .set(PROVEEDOR.NIT,txtNIT.getText())
                .set(PROVEEDOR.IVA,txtIVA.getText())
                .set(PROVEEDOR.DIRECCION, txtDireccion.getText())
                .set(PROVEEDOR.TELEFONO,txtTelefono.getText())
                .set(PROVEEDOR.EMAIL,txtMail.getText())
                .set(PROVEEDOR.REPRESENTANTE,txtRepresentante.getText())
                .set(PROVEEDOR.CTABANCARIA,txtCta.getText())
                .set(PROVEEDOR.TIPOPROVEEDOR,cbxTipo.getSelectedItem().toString())
                .set(PROVEEDOR.PLAZO,(int) spPlazo.getValue())
                .set(PROVEEDOR.LIMITE, new BigDecimal((double) spLimite.getValue()))
                .execute();
    }

    private void editarProveedor() throws Exception {
        create.update(PROVEEDOR)
                .set(PROVEEDOR.NOMBRE,txtNombre.getText())
                .set(PROVEEDOR.GIRO,txtGiro.getText())
                .set(PROVEEDOR.NIT,txtNIT.getText())
                .set(PROVEEDOR.IVA,txtIVA.getText())
                .set(PROVEEDOR.DIRECCION, txtDireccion.getText())
                .set(PROVEEDOR.TELEFONO,txtTelefono.getText())
                .set(PROVEEDOR.EMAIL,txtMail.getText())
                .set(PROVEEDOR.REPRESENTANTE,txtRepresentante.getText())
                .set(PROVEEDOR.CTABANCARIA,txtCta.getText())
                .set(PROVEEDOR.TIPOPROVEEDOR,cbxTipo.getSelectedItem().toString())
                .set(PROVEEDOR.PLAZO,(int) spPlazo.getValue())
                .set(PROVEEDOR.LIMITE, new BigDecimal((double) spLimite.getValue()))
                .where(PROVEEDOR.IDPROVEEDOR.equal(idProv))
                .execute();
    }
    
}
