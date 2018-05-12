
package dialogs.ventas;

import com.pereiracomputerservices.milancho.Reloj;
import static db.clases.Tables.BITACORA_CAJA;
import static db.clases.Tables.CAJA;
import design.button.ButtonUI;
import design.spinner.SpinnerUI;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static org.jooq.impl.DSL.sum;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;
import static puntocolor.Principal.ue;

/* @author Jose Luis */
public class DialogCaja extends javax.swing.JDialog {
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    int idProv;
    String IP;
    int idCaja;
    String cajaNombre;
    boolean activa;

    public DialogCaja(java.awt.Frame parent, boolean modal, String titulo, String IP) {
        super(parent, modal);       
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);
        this.IP = IP;
        new Reloj(lblFecha, false, true, true, false);
        new Reloj(lblDia, true,false,false,false);
        new Reloj(lblReloj, false, false, false, true);
        validarForm();
        cargarForm();        
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
        jSeparator6 = new javax.swing.JToolBar.Separator();
        pFormulario = new javax.swing.JPanel();
        pCalendario = new javax.swing.JPanel();
        lblReloj = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JLabel();
        lblMovimiento = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sprInicial = new javax.swing.JSpinner();
        txtVentas = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtTotalIngresos = new javax.swing.JTextField();
        sprEgresos = new javax.swing.JSpinner();
        jSeparator4 = new javax.swing.JSeparator();
        txtTotalCaja = new javax.swing.JTextField();
        sprEfectivo = new javax.swing.JSpinner();
        jSeparator5 = new javax.swing.JSeparator();
        txtDiferencia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(400, 600));
        setPreferredSize(new java.awt.Dimension(400, 600));
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
        toolBarTabla1.add(jSeparator6);

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

        pCalendario.setMinimumSize(new java.awt.Dimension(130, 130));
        pCalendario.setOpaque(false);
        pCalendario.setPreferredSize(new java.awt.Dimension(130, 130));
        pCalendario.setLayout(new java.awt.GridBagLayout());

        lblReloj.setBackground(new java.awt.Color(255, 204, 51));
        lblReloj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblReloj.setForeground(new java.awt.Color(255, 255, 255));
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("08 : 00 pm");
        lblReloj.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        lblReloj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblReloj.setMaximumSize(new java.awt.Dimension(80, 20));
        lblReloj.setMinimumSize(new java.awt.Dimension(80, 20));
        lblReloj.setPreferredSize(new java.awt.Dimension(70, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(80, 0, 0, 0);
        pCalendario.add(lblReloj, gridBagConstraints);

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("DATE");
        lblFecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        pCalendario.add(lblFecha, gridBagConstraints);

        lblDia.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDia.setForeground(new java.awt.Color(255, 255, 255));
        lblDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDia.setText("DIA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        pCalendario.add(lblDia, gridBagConstraints);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/themify_e6b6(0)_128.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        pCalendario.add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pFormulario.add(pCalendario, gridBagConstraints);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Caja:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel1.add(jLabel3, gridBagConstraints);

        txtCaja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCaja.setText("txtCaja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel1.add(txtCaja, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Cajero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel1.add(jLabel5, gridBagConstraints);

        txtEmpleado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmpleado.setText("txtEmpleado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel1.add(txtEmpleado, gridBagConstraints);

        lblMovimiento.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMovimiento.setText("Movimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jPanel1.add(lblMovimiento, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        pFormulario.add(jPanel1, gridBagConstraints);

        jPanel2.setMinimumSize(new java.awt.Dimension(250, 0));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 0));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Saldo Inicial");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel2.add(jLabel7, gridBagConstraints);
        jLabel7.getAccessibleContext().setAccessibleName("");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Ventas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel2.add(jLabel8, gridBagConstraints);
        jLabel8.getAccessibleContext().setAccessibleName("");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("<html><body>Total de<br>Ingresos</body></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel2.add(jLabel9, gridBagConstraints);
        jLabel9.getAccessibleContext().setAccessibleName("");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("<html><body>Total de<br>Egresos</body></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel2.add(jLabel10, gridBagConstraints);
        jLabel10.getAccessibleContext().setAccessibleName("");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("<html><body>Total<br>en Caja</body></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel2.add(jLabel11, gridBagConstraints);
        jLabel11.getAccessibleContext().setAccessibleName("");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("<html><body>Efectivo<br>en Caja</body></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel2.add(jLabel12, gridBagConstraints);
        jLabel12.getAccessibleContext().setAccessibleName("");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("<html><body>Diferencia de<br>Efectivo</body></html>");
        jLabel13.setMinimumSize(new java.awt.Dimension(94, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel2.add(jLabel13, gridBagConstraints);
        jLabel13.getAccessibleContext().setAccessibleName("");

        sprInicial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sprInicial.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 10.0d));
        sprInicial.setMinimumSize(new java.awt.Dimension(60, 40));
        sprInicial.setPreferredSize(new java.awt.Dimension(60, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel2.add(sprInicial, gridBagConstraints);
        sprInicial.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        txtVentas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtVentas.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtVentas.setEnabled(false);
        txtVentas.setMinimumSize(new java.awt.Dimension(60, 40));
        txtVentas.setPreferredSize(new java.awt.Dimension(60, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel2.add(txtVentas, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel2.add(jSeparator3, gridBagConstraints);

        txtTotalIngresos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTotalIngresos.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtTotalIngresos.setEnabled(false);
        txtTotalIngresos.setMinimumSize(new java.awt.Dimension(60, 40));
        txtTotalIngresos.setPreferredSize(new java.awt.Dimension(60, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel2.add(txtTotalIngresos, gridBagConstraints);

        sprEgresos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sprEgresos.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 10.0d));
        sprEgresos.setMinimumSize(new java.awt.Dimension(60, 40));
        sprEgresos.setPreferredSize(new java.awt.Dimension(60, 40));
        sprEgresos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sprEgresosStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel2.add(sprEgresos, gridBagConstraints);
        sprEgresos.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel2.add(jSeparator4, gridBagConstraints);

        txtTotalCaja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTotalCaja.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtTotalCaja.setEnabled(false);
        txtTotalCaja.setMinimumSize(new java.awt.Dimension(60, 40));
        txtTotalCaja.setPreferredSize(new java.awt.Dimension(60, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel2.add(txtTotalCaja, gridBagConstraints);

        sprEfectivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sprEfectivo.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 10.0d));
        sprEfectivo.setMinimumSize(new java.awt.Dimension(60, 40));
        sprEfectivo.setPreferredSize(new java.awt.Dimension(60, 40));
        sprEfectivo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sprEfectivoStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel2.add(sprEfectivo, gridBagConstraints);
        sprEfectivo.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel2.add(jSeparator5, gridBagConstraints);

        txtDiferencia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDiferencia.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtDiferencia.setEnabled(false);
        txtDiferencia.setMinimumSize(new java.awt.Dimension(60, 40));
        txtDiferencia.setPreferredSize(new java.awt.Dimension(60, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel2.add(txtDiferencia, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pFormulario.add(jPanel2, gridBagConstraints);

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
        if(isActiva()){
            registrarCierre();
            create.update(CAJA).set(CAJA.ESTADO,false).where(CAJA.IDCAJA.equal(idCaja)).execute();
            enviarImpresionCierre();
        }else{
            registrarApertura();
            create.update(CAJA).set(CAJA.ESTADO,true).where(CAJA.IDCAJA.equal(idCaja)).execute();
        }
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void sprEgresosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sprEgresosStateChanged
        // TODO add your handling code here:
        txtTotalCaja.setText(""+totalCaja());
        txtDiferencia.setText(""+carlcularDiferencia());
    }//GEN-LAST:event_sprEgresosStateChanged

    private void sprEfectivoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sprEfectivoStateChanged
        // TODO add your handling code here:
        txtDiferencia.setText(""+carlcularDiferencia());
    }//GEN-LAST:event_sprEfectivoStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMovimiento;
    private javax.swing.JLabel lblReloj;
    private javax.swing.JPanel lblTitulo;
    private javax.swing.JPanel pCalendario;
    private javax.swing.JPanel pFormulario;
    private javax.swing.JSpinner sprEfectivo;
    private javax.swing.JSpinner sprEgresos;
    private javax.swing.JSpinner sprInicial;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JLabel txtCaja;
    private javax.swing.JTextField txtDiferencia;
    private javax.swing.JLabel txtEmpleado;
    private javax.swing.JTextField txtTotalCaja;
    private javax.swing.JTextField txtTotalIngresos;
    private javax.swing.JTextField txtVentas;
    // End of variables declaration//GEN-END:variables
    
    private boolean isActiva(){
        Record r = create.select()
                .from(CAJA)
                .where(CAJA.IPCAJA.eq(IP))
                .fetchOne();        
        boolean estado = r.getValue(CAJA.ESTADO);
        activa = estado;
        cajaNombre = r.getValue(CAJA.DETALLE);
        idCaja = r.getValue(CAJA.IDCAJA);
        return estado;
    }
    
    private void cargarForm(){
        validarForm();        
        txtEmpleado.setText(ue.getNombre());
        if(activa){
            lblMovimiento.setText("CIERRE DE CAJA");
            cargarCierre();
        }else{
            cargarApertura();
            lblMovimiento.setText("APERTURA DE CAJA");
        }
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Hora: "+hourFormat.format(date));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtCaja.setText(cajaNombre);
    }
    
    private double consultarVentas(){
        return 0;
    }
    
    private void validarForm(){
        if(isActiva()){
            sprInicial.setEnabled(false);
            sprEfectivo.setEnabled(true);
            sprEgresos.setEnabled(true);
        }else{
            sprInicial.setEnabled(true);
            sprEfectivo.setEnabled(false);
            sprEgresos.setEnabled(false);
        }
    }
    
    private void registrarApertura(){
        double inicial = (double) sprInicial.getValue();
        BigDecimal inicio = new BigDecimal(inicial);
        java.sql.Timestamp fecha = clases.Fechero.realToBase(new Date());
        registrarMovimiento(fecha,inicio,"APERTURA");
        Reportes.Reportes.aperturaCaja(ue.getNombre(), inicio);
    }
    
    private void registrarCierre() {
        java.sql.Timestamp fecha = clases.Fechero.realToBase(new Date());
        double egresos = (double) sprEgresos.getValue();
        registrarMovimiento(fecha,new BigDecimal(egresos),"EGRESOS");
        double efectivo = (double) sprEfectivo.getValue();
        registrarMovimiento(fecha,new BigDecimal(efectivo),"EFECTIVO");
        double cierre = Double.parseDouble(txtDiferencia.getText());
        registrarMovimiento(fecha,new BigDecimal(cierre),"CIERRE");
    }
    
    public void registrarMovimiento(java.sql.Timestamp fecha, BigDecimal valor, String movimiento){
        create.insertInto(BITACORA_CAJA)
                .set(BITACORA_CAJA.IDCAJA,idCaja)
                .set(BITACORA_CAJA.FECHA,fecha)
                .set(BITACORA_CAJA.EMPLEADO, ue.getNombre())
                .set(BITACORA_CAJA.VALOR,valor)
                .set(BITACORA_CAJA.MOVIMIENTO,movimiento)
                .execute();
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

    private void cargarApertura() {
    }

    private void cargarCierre() {
        Record r = create.select(BITACORA_CAJA.VALOR, BITACORA_CAJA.FECHA)
                .from(BITACORA_CAJA)
                .where(BITACORA_CAJA.MOVIMIENTO.equal("APERTURA"))
                .orderBy(BITACORA_CAJA.FECHA.desc())
                .limit(1)
                .fetchOne();
        double inicial = r.getValue(BITACORA_CAJA.VALOR).doubleValue();
        sprInicial.setValue(inicial);
        java.sql.Timestamp fecha = clases.Fechero.realToBase(new Date());
        BigDecimal ventas = create.select(sum(BITACORA_CAJA.VALOR))
                .from(BITACORA_CAJA)
                .where(BITACORA_CAJA.MOVIMIENTO.like("%PAGO%"))
                .and(BITACORA_CAJA.FECHA.between(r.getValue(BITACORA_CAJA.FECHA), fecha))
                .fetchOne(sum(BITACORA_CAJA.VALOR),BigDecimal.class);
        if(ventas==null){
            ventas = new BigDecimal(0.00);
        }
        txtVentas.setText(""+ventas);
        txtTotalIngresos.setText(""+totalIngresos());
        txtTotalCaja.setText(""+totalCaja());
        txtDiferencia.setText(""+carlcularDiferencia());
    }

    private double totalIngresos() {
        double inicial = (double) sprInicial.getValue();
        double ventas = Double.parseDouble(txtVentas.getText());
        return inicial+ventas;
    }

    private double totalCaja() {
        double egresos = (double) sprEgresos.getValue();
        return totalIngresos()-egresos;
    }

    private double carlcularDiferencia() {
        double efectivo = (double) sprEfectivo.getValue();
        return efectivo-totalCaja();
    }

    private void enviarImpresionCierre() {
        java.sql.Timestamp fInicio = create.select(BITACORA_CAJA.FECHA)
                .from(BITACORA_CAJA)
                .where(BITACORA_CAJA.MOVIMIENTO.equal("APERTURA"))
                .orderBy(BITACORA_CAJA.FECHA.desc())
                .limit(1)
                .fetchOne(BITACORA_CAJA.FECHA,java.sql.Timestamp.class);
        java.sql.Timestamp fFinal = create.select(BITACORA_CAJA.FECHA)
                .from(BITACORA_CAJA)
                .where(BITACORA_CAJA.MOVIMIENTO.equal("CIERRE"))
                .orderBy(BITACORA_CAJA.FECHA.desc())
                .limit(1)
                .fetchOne(BITACORA_CAJA.FECHA,java.sql.Timestamp.class);
        System.out.println(fInicio);
        System.out.println(fFinal);
        if(fInicio.before(fFinal)){
            Reportes.Reportes.cierreCaja(ue.getNombre(), fInicio, fFinal);
        }else{
            JOptionPane.showMessageDialog(null, "Error con los cierres");
        }
    }

}
