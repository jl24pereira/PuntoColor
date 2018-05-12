
package dialogs.compras;

import dialogs.ventas.*;
import clases.CostoPromedio;
import clases.Mensajes;
import com.sun.glass.events.KeyEvent;
import static db.clases.Tables.COMPRAS;
import static db.clases.Tables.DETALLE_COMPRA;
import static db.clases.Tables.INVENTARIO;
import static db.clases.Tables.PAGOS_COMPRAS;
import static db.clases.Tables.PROVEEDOR;
import static db.clases.Tables.UNIDAD_MEDIDA;
import static db.clases.Tables.V_INVENTARIO;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.spinner.SpinnerUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.io.File;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import static org.jooq.impl.DSL.count;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;

/* @author JL Desk */
public class DialogFactura extends javax.swing.JDialog {

    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    DefaultTableModel dtmDetalleFactura;
    DefaultTableModel dtmMateriales;
    DefaultTableModel dtmAbonos;
    
    File file;
    
    boolean nuevo = true;
    boolean hayCat = true;
    
    String CODIGOP;
    String CATEGORIAP;
    
    private final JFXPanel jfxPanel = new JFXPanel(); 
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart bc = new BarChart(xAxis,yAxis);    
    ObservableList<XYChart.Series<String,Double>> data2d = FXCollections.observableArrayList();
    
    JPanel[] panels;
    int position = 0;
    
    GridBagConstraints  gbcWizard = new GridBagConstraints();
    
    String TRANSACCION = "0000";
    boolean ISINICIADA = false;
    
    int idproveedor;
    int idfactura = 0;
    boolean avanzar = false;

    public DialogFactura(java.awt.Frame parent, boolean modal, String titulo, int idproveedor) {
        super(parent, modal);
        this.setTitle(titulo);
        initComponents();
        this.setLocationRelativeTo(null);
        this.idproveedor = idproveedor;
        dtmDetalleFactura = (DefaultTableModel) tDetalleFactura.getModel();
        dtmMateriales = (DefaultTableModel) tMateriales.getModel();
        dtmAbonos = (DefaultTableModel) tAbonos.getModel();
        gbcWizard.fill = java.awt.GridBagConstraints.BOTH;
        gbcWizard.anchor = java.awt.GridBagConstraints.CENTER;
        gbcWizard.weightx = 1.0;
        gbcWizard.weighty = 1.0;
        gbcWizard.insets = new Insets(10,10,10,10);
        panels = new JPanel[] {panel1, panel2, panel3};
        seleccionPanel();
        try {
            cargarInfoProveedor();
        } catch (Exception ex) {
            Logger.getLogger(DialogFactura.class.getName()).log(Level.SEVERE, null, ex);
            new Mensajes().mensajeError("Ha ocurrido un error con la transacción!");
        }
        dibujarTablas();
        cargarTablaMateriales();
        iniciaTransaccion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popMateriales = new javax.swing.JPopupMenu();
        itemAgregarMaterial = new javax.swing.JMenuItem();
        popDetalleFact = new javax.swing.JPopupMenu();
        itemEliminarMaterial = new javax.swing.JMenuItem();
        panel1 = new com.mrlonee.swing.animation.AnimatedPanel();
        toolBarTabla2 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        lblTelefono1 = new javax.swing.JLabel();
        txtNit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        lblTipoDoc = new javax.swing.JLabel();
        cbxTipoDoc = new javax.swing.JComboBox<>();
        lblNumDoc = new javax.swing.JLabel();
        txtNumDoc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panel2 = new com.mrlonee.swing.animation.AnimatedPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDetalleFactura = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tMateriales = new javax.swing.JTable();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnNuevoMaterial = new javax.swing.JButton();
        panel3 = new com.mrlonee.swing.animation.AnimatedPanel();
        toolBarTabla4 = new javax.swing.JToolBar();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        jLabel20 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnNuevoAbono = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tAbonos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblTotalFactura = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTotalPagos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        pMov = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        itemAgregarMaterial.setText("Agregar a Detalle");
        itemAgregarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarMaterialActionPerformed(evt);
            }
        });
        popMateriales.add(itemAgregarMaterial);

        itemEliminarMaterial.setText("Eliminar de Detalle");
        itemEliminarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarMaterialActionPerformed(evt);
            }
        });
        popDetalleFact.add(itemEliminarMaterial);

        panel1.setBorder(new javax.swing.border.LineBorder(colorUI, 3, true));
        panel1.setAnimationType(com.mrlonee.swing.animation.AnimatedPanel.AnimationType.SlideAnimationFromRight);
        panel1.setLayout(new java.awt.GridBagLayout());

        toolBarTabla2.setBackground(colorUI);
        toolBarTabla2.setBorder(null);
        toolBarTabla2.setFloatable(false);
        toolBarTabla2.setRollover(true);
        toolBarTabla2.setMaximumSize(new java.awt.Dimension(100, 60));
        toolBarTabla2.setMinimumSize(new java.awt.Dimension(100, 60));
        toolBarTabla2.setPreferredSize(new java.awt.Dimension(100, 60));
        toolBarTabla2.add(jSeparator9);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel11.setForeground(colorBG);
        jLabel11.setText("Información de Factura");
        toolBarTabla2.add(jLabel11);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel1.add(toolBarTabla2, gridBagConstraints);

        jPanel12.setMinimumSize(new java.awt.Dimension(300, 17));
        jPanel12.setOpaque(false);
        jPanel12.setPreferredSize(new java.awt.Dimension(300, 17));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        lblCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCliente.setText("Proveedor:");
        lblCliente.setMaximumSize(new java.awt.Dimension(0, 30));
        lblCliente.setMinimumSize(new java.awt.Dimension(0, 30));
        lblCliente.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel12.add(lblCliente, gridBagConstraints);

        txtNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNombre.setText("Pereira Computer Services SA de CV");
        txtNombre.setMaximumSize(new java.awt.Dimension(0, 30));
        txtNombre.setMinimumSize(new java.awt.Dimension(0, 30));
        txtNombre.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel12.add(txtNombre, gridBagConstraints);

        lblDireccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDireccion.setText("Dirección:");
        lblDireccion.setMaximumSize(new java.awt.Dimension(0, 30));
        lblDireccion.setMinimumSize(new java.awt.Dimension(0, 30));
        lblDireccion.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel12.add(lblDireccion, gridBagConstraints);

        txtDireccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtDireccion.setText("Direccion del cliente");
        txtDireccion.setMaximumSize(new java.awt.Dimension(0, 30));
        txtDireccion.setMinimumSize(new java.awt.Dimension(0, 30));
        txtDireccion.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel12.add(txtDireccion, gridBagConstraints);

        lblTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTelefono.setText("Teléfono:");
        lblTelefono.setMaximumSize(new java.awt.Dimension(0, 30));
        lblTelefono.setMinimumSize(new java.awt.Dimension(0, 30));
        lblTelefono.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel12.add(lblTelefono, gridBagConstraints);

        txtTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTelefono.setText("Telefono del cliente");
        txtTelefono.setMaximumSize(new java.awt.Dimension(0, 30));
        txtTelefono.setMinimumSize(new java.awt.Dimension(0, 30));
        txtTelefono.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel12.add(txtTelefono, gridBagConstraints);

        lblTelefono1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTelefono1.setText("NIT:");
        lblTelefono1.setMaximumSize(new java.awt.Dimension(0, 30));
        lblTelefono1.setMinimumSize(new java.awt.Dimension(0, 30));
        lblTelefono1.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel12.add(lblTelefono1, gridBagConstraints);

        txtNit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNit.setText("Telefono del cliente");
        txtNit.setMaximumSize(new java.awt.Dimension(0, 30));
        txtNit.setMinimumSize(new java.awt.Dimension(0, 30));
        txtNit.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel12.add(txtNit, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel1.add(jPanel12, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Fecha de Compra:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 10);
        jPanel3.add(jLabel3, gridBagConstraints);

        txtFecha.setDate(new Date());
        txtFecha.setDateFormatString("dd-MM-yyyy");
        txtFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFecha.setMinimumSize(new java.awt.Dimension(150, 30));
        txtFecha.setPreferredSize(new java.awt.Dimension(150, 50));
        txtFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFechaPropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 15, 15);
        jPanel3.add(txtFecha, gridBagConstraints);

        lblTipoDoc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTipoDoc.setText("Documento Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 10);
        jPanel3.add(lblTipoDoc, gridBagConstraints);

        cbxTipoDoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));
        cbxTipoDoc.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        cbxTipoDoc.setMinimumSize(new java.awt.Dimension(66, 30));
        cbxTipoDoc.setPreferredSize(new java.awt.Dimension(150, 50));
        cbxTipoDoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoDocItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 15, 15);
        jPanel3.add(cbxTipoDoc, gridBagConstraints);
        cbxTipoDoc.setUI(new ComboUI(colorBG,java.awt.Color.GRAY));

        lblNumDoc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNumDoc.setText("(*) Documento #:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 10);
        jPanel3.add(lblNumDoc, gridBagConstraints);

        txtNumDoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNumDoc.setMinimumSize(new java.awt.Dimension(150, 30));
        txtNumDoc.setPreferredSize(new java.awt.Dimension(150, 50));
        txtNumDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumDocKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 15, 15);
        jPanel3.add(txtNumDoc, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel1.add(jPanel3, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/256/surveys256.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panel1.add(jLabel2, gridBagConstraints);

        panel2.setBorder(new javax.swing.border.LineBorder(colorUI, 3, true));
        panel2.setAnimationType(com.mrlonee.swing.animation.AnimatedPanel.AnimationType.SlideAnimationFromRight);
        panel2.setLayout(new java.awt.GridBagLayout());

        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel2.add(jPanel14, gridBagConstraints);

        jPanel15.setBackground(new java.awt.Color(0, 51, 255));
        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.GridBagLayout());

        jPanel4.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        tDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Codigo", "Detalle", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tDetalleFactura.setComponentPopupMenu(popDetalleFact);
        tDetalleFactura.setRowHeight(30);
        tDetalleFactura.getTableHeader().setReorderingAllowed(false);
        tDetalleFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tDetalleFacturaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tDetalleFactura);
        if (tDetalleFactura.getColumnModel().getColumnCount() > 0) {
            tDetalleFactura.getColumnModel().getColumn(0).setMinWidth(0);
            tDetalleFactura.getColumnModel().getColumn(0).setPreferredWidth(0);
            tDetalleFactura.getColumnModel().getColumn(0).setMaxWidth(0);
            tDetalleFactura.getColumnModel().getColumn(1).setMinWidth(65);
            tDetalleFactura.getColumnModel().getColumn(1).setPreferredWidth(65);
            tDetalleFactura.getColumnModel().getColumn(1).setMaxWidth(65);
            tDetalleFactura.getColumnModel().getColumn(3).setMinWidth(100);
            tDetalleFactura.getColumnModel().getColumn(3).setPreferredWidth(100);
            tDetalleFactura.getColumnModel().getColumn(3).setMaxWidth(100);
            tDetalleFactura.getColumnModel().getColumn(3).setCellEditor(new SpinnerEditor());
            tDetalleFactura.getColumnModel().getColumn(3).setCellRenderer(new SpinnerRenderer());
            tDetalleFactura.getColumnModel().getColumn(4).setMinWidth(100);
            tDetalleFactura.getColumnModel().getColumn(4).setPreferredWidth(100);
            tDetalleFactura.getColumnModel().getColumn(4).setMaxWidth(100);
            tDetalleFactura.getColumnModel().getColumn(4).setCellEditor(new SpinnerEditor());
            tDetalleFactura.getColumnModel().getColumn(4).setCellRenderer(new SpinnerRenderer());
            tDetalleFactura.getColumnModel().getColumn(5).setMinWidth(100);
            tDetalleFactura.getColumnModel().getColumn(5).setPreferredWidth(100);
            tDetalleFactura.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jScrollPane1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jLabel1, gridBagConstraints);

        lblTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTotal.setText("0.00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(lblTotal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel15.add(jPanel4, gridBagConstraints);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setMinimumSize(new java.awt.Dimension(1, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel15.add(jSeparator4, gridBagConstraints);

        jPanel5.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel18.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel18.setText("Inventario de Materiales");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel5.add(jLabel18, gridBagConstraints);

        tMateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Codigo", "Nombre", "Categoria", "P.Compra", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tMateriales.setComponentPopupMenu(popMateriales);
        tMateriales.setRowHeight(30);
        tMateriales.getTableHeader().setReorderingAllowed(false);
        tMateriales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tMaterialesMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tMateriales);
        if (tMateriales.getColumnModel().getColumnCount() > 0) {
            tMateriales.getColumnModel().getColumn(0).setMinWidth(0);
            tMateriales.getColumnModel().getColumn(0).setPreferredWidth(0);
            tMateriales.getColumnModel().getColumn(0).setMaxWidth(0);
            tMateriales.getColumnModel().getColumn(1).setMinWidth(70);
            tMateriales.getColumnModel().getColumn(1).setPreferredWidth(70);
            tMateriales.getColumnModel().getColumn(1).setMaxWidth(70);
            tMateriales.getColumnModel().getColumn(3).setMinWidth(100);
            tMateriales.getColumnModel().getColumn(3).setPreferredWidth(100);
            tMateriales.getColumnModel().getColumn(3).setMaxWidth(100);
            tMateriales.getColumnModel().getColumn(4).setMinWidth(75);
            tMateriales.getColumnModel().getColumn(4).setPreferredWidth(75);
            tMateriales.getColumnModel().getColumn(4).setMaxWidth(75);
            tMateriales.getColumnModel().getColumn(5).setMinWidth(50);
            tMateriales.getColumnModel().getColumn(5).setPreferredWidth(50);
            tMateriales.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel15.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel2.add(jPanel15, gridBagConstraints);

        toolBarTabla1.setBackground(colorUI);
        toolBarTabla1.setBorder(null);
        toolBarTabla1.setFloatable(false);
        toolBarTabla1.setRollover(true);
        toolBarTabla1.setMaximumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setMinimumSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.setPreferredSize(new java.awt.Dimension(100, 60));
        toolBarTabla1.add(jSeparator3);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel17.setForeground(colorBG);
        jLabel17.setText("Detalle de Factura");
        toolBarTabla1.add(jLabel17);
        toolBarTabla1.add(jSeparator1);

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar Todo", "Codigo", "Nombre", "Categoria" }));
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
        toolBarTabla1.add(jSeparator5);

        btnNuevoMaterial.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNuevoMaterial.setForeground(colorTexto);
        btnNuevoMaterial.setText("Nuevo Material");
        btnNuevoMaterial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoMaterial.setFocusable(false);
        btnNuevoMaterial.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoMaterial.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMaterialActionPerformed(evt);
            }
        });
        toolBarTabla1.add(btnNuevoMaterial);
        btnNuevoMaterial.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel2.add(toolBarTabla1, gridBagConstraints);

        panel3.setBorder(new javax.swing.border.LineBorder(colorUI, 3, true));
        panel3.setAnimationType(com.mrlonee.swing.animation.AnimatedPanel.AnimationType.SlideAnimationFromRight);
        panel3.setLayout(new java.awt.GridBagLayout());

        toolBarTabla4.setBackground(colorUI);
        toolBarTabla4.setBorder(null);
        toolBarTabla4.setFloatable(false);
        toolBarTabla4.setRollover(true);
        toolBarTabla4.setMaximumSize(new java.awt.Dimension(100, 60));
        toolBarTabla4.setMinimumSize(new java.awt.Dimension(100, 60));
        toolBarTabla4.setPreferredSize(new java.awt.Dimension(100, 60));
        toolBarTabla4.add(jSeparator15);

        jLabel20.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel20.setForeground(colorBG);
        jLabel20.setText("Abonos");
        toolBarTabla4.add(jLabel20);
        toolBarTabla4.add(jSeparator2);

        btnNuevoAbono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNuevoAbono.setForeground(colorBG);
        btnNuevoAbono.setText("Ingresar Pago");
        btnNuevoAbono.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAbonoActionPerformed(evt);
            }
        });
        toolBarTabla4.add(btnNuevoAbono);
        btnNuevoAbono.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel3.add(toolBarTabla4, gridBagConstraints);

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel3.add(jPanel18, gridBagConstraints);

        jPanel19.setOpaque(false);
        jPanel19.setLayout(new java.awt.GridBagLayout());

        jPanel6.setBackground(colorBG);
        jPanel6.setLayout(new java.awt.GridBagLayout());

        tAbonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "No.", "Fecha", "Pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tAbonos);
        if (tAbonos.getColumnModel().getColumnCount() > 0) {
            tAbonos.getColumnModel().getColumn(0).setMinWidth(0);
            tAbonos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tAbonos.getColumnModel().getColumn(0).setMaxWidth(0);
            tAbonos.getColumnModel().getColumn(2).setMinWidth(200);
            tAbonos.getColumnModel().getColumn(2).setPreferredWidth(200);
            tAbonos.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(jScrollPane3, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Total en Factura:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel6.add(jLabel7, gridBagConstraints);

        lblTotalFactura.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTotalFactura.setText("0.00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(lblTotalFactura, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Total en Pagos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel6.add(jLabel6, gridBagConstraints);

        lblTotalPagos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTotalPagos.setText("0.00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(lblTotalPagos, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 60, 0, 0);
        jPanel19.add(jPanel6, gridBagConstraints);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/256/Earning-statement.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        jPanel19.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel3.add(jPanel19, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(colorUI);
        setMinimumSize(new java.awt.Dimension(1100, 600));
        setPreferredSize(new java.awt.Dimension(1100, 600));
        setResizable(false);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                formComponentRemoved(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel20.setBackground(colorBG);
        jPanel20.setLayout(new java.awt.GridBagLayout());

        pMov.setOpaque(false);
        pMov.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel20.add(pMov, gridBagConstraints);

        jPanel11.setOpaque(false);
        jPanel11.setLayout(new java.awt.GridBagLayout());

        btnAnterior.setText("Anterior");
        btnAnterior.setEnabled(false);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        jPanel11.add(btnAnterior, gridBagConstraints);

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        jPanel11.add(btnSiguiente, gridBagConstraints);

        btnFinalizar.setText("Finalizar");
        btnFinalizar.setEnabled(false);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        jPanel11.add(btnFinalizar, gridBagConstraints);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        jPanel11.add(btnCancelar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(jPanel11, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel20, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        if(position!=(panels.length-1)){
            try {
                verificarPosition();
            } catch (Exception ex) {
                Logger.getLogger(DialogFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(avanzar){
                position++;
                seleccionPanel();
            }
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        if(position>0){
            position --;
            seleccionPanel();
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            database.getConexion().rollback();            
        } catch (SQLException ex) {
            Logger.getLogger(DialogFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        try {
            actualizarInventario();
            database.getConexion().commit();
            this.setGuardado(true);
        } catch (SQLException ex) {
            Logger.getLogger(DialogFactura.class.getName()).log(Level.SEVERE, null, ex);
            this.setGuardado(false);
        } catch (Exception ex) {
            Logger.getLogger(DialogFactura.class.getName()).log(Level.SEVERE, null, ex);
            new Mensajes().mensajeError("Ha ocurrido un error con la transacción!");
        }
        dispose();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
           database.getConexion().rollback();
           database.getConexion().setAutoCommit(true);
           System.out.println("FINALIZANDO TRANSACCION");
        } catch (SQLException ex) {
            Logger.getLogger(DialogPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formComponentRemoved

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:       
    }//GEN-LAST:event_formWindowClosed

    private void txtNumDocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumDocKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumDocKeyReleased

    private void txtFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFechaPropertyChange
        try {
            actualizarFechaCompra();
            //txtFechaPago.setDate(txtFecha.getDate());
        } catch (Exception ex) {
            Logger.getLogger(DialogFactura.class.getName()).log(Level.SEVERE, null, ex);
            new Mensajes().mensajeError("Ha ocurrido un error con la transacción!");
        }
    }//GEN-LAST:event_txtFechaPropertyChange

    private void cbxTipoDocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoDocItemStateChanged
        try {
            // TODO add your handling code here:
            actualizarTipoDocumento();
        } catch (Exception ex) {
            Logger.getLogger(DialogFactura.class.getName()).log(Level.SEVERE, null, ex);
            new Mensajes().mensajeError("Ha ocurrido un error con la transacción!");
        }
    }//GEN-LAST:event_cbxTipoDocItemStateChanged

    private void tMaterialesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMaterialesMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tMateriales.rowAtPoint(point);
        tMateriales.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tMaterialesMousePressed

    private void tDetalleFacturaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDetalleFacturaMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tDetalleFactura.rowAtPoint(point);
        tDetalleFactura.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tDetalleFacturaMousePressed

    private void btnNuevoMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMaterialActionPerformed
        // TODO add your handling code here:
        DialogMateriaPrima dialog = new DialogMateriaPrima(new javax.swing.JFrame(), true,"compras","Agregar Materia Prima");
        dialog.setVisible(true);
        if(dialog.isGuardado()){
            try {
                cargarTablaMateriales();
                pasarNuevoMaterial(dialog.getIdInventario());
            } catch (Exception ex) {
                Logger.getLogger(DialogFactura.class.getName()).log(Level.SEVERE, null, ex);
                new Mensajes().mensajeError("Ha ocurrido un error con la transacción!");
            }
        }

        //SpinnerNumberModel spm = (SpinnerNumberModel) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(),0);
        //System.out.println(dialog.getCodigo());
    }//GEN-LAST:event_btnNuevoMaterialActionPerformed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        // TODO add your handling code here:
        cargarTablaMateriales();
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        cargarTablaMateriales();
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void itemAgregarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarMaterialActionPerformed
        // TODO add your handling code here:
        int idmaterial = (int) tMateriales.getValueAt(tMateriales.getSelectedRow(), 0);
        String codigo = (String) tMateriales.getValueAt(tMateriales.getSelectedRow(), 1);
        String detalle = (String) tMateriales.getValueAt(tMateriales.getSelectedRow(), 2);
        BigDecimal precio = (BigDecimal) tMateriales.getValueAt(tMateriales.getSelectedRow(), 4);
        Object [] row = {
            idmaterial,
            codigo,
            detalle,
            new SpinnerNumberModel(1, 1, 999.99, 1),
            new SpinnerNumberModel(precio.doubleValue(), 0.00, 9999.99, .1)};
        if(isOnDetalle(idmaterial)){
            new Mensajes().mensajeAlert("El material ya se encuentra en detalle de factura!");
        }else{            
            try {
                dtmDetalleFactura.addRow(row);
                agregarMaterialADetalle(idmaterial,precio);                                
            } catch (Exception ex) {
                Logger.getLogger(DialogFactura.class.getName()).log(Level.SEVERE, null, ex);
                new Mensajes().mensajeError("Ha ocurrido un error con la transacción!");
            }
        }
    }//GEN-LAST:event_itemAgregarMaterialActionPerformed

    private void itemEliminarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarMaterialActionPerformed
        try {
            // TODO add your handling code here:
            eliminarMaterialADetalle();            
        } catch (Exception ex) {
            Logger.getLogger(DialogFactura.class.getName()).log(Level.SEVERE, null, ex);
            new Mensajes().mensajeError("Ha ocurrido un error con la transacción!");
        }
    }//GEN-LAST:event_itemEliminarMaterialActionPerformed

    private void btnNuevoAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAbonoActionPerformed
        // TODO add your handling code here:
        if(tDetalleFactura.getRowCount()>0){
            DialogAbono dialog = new DialogAbono(new javax.swing.JFrame(), true,"Nuevo Abono",idfactura);
            dialog.setVisible(true);
            if(dialog.isGuardado()){
                cargarTablaAbonos();
                calcularAbonos();
            }            
        }else{
            new Mensajes().mensajeAlert("Agregue materiales a detalle de factura");
        }
    }//GEN-LAST:event_btnNuevoAbonoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnNuevoAbono;
    private javax.swing.JButton btnNuevoMaterial;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JComboBox<String> cbxTipoDoc;
    private javax.swing.JMenuItem itemAgregarMaterial;
    private javax.swing.JMenuItem itemEliminarMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNumDoc;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JLabel lblTipoDoc;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalFactura;
    private javax.swing.JLabel lblTotalPagos;
    private javax.swing.JPanel pMov;
    private com.mrlonee.swing.animation.AnimatedPanel panel1;
    private com.mrlonee.swing.animation.AnimatedPanel panel2;
    private com.mrlonee.swing.animation.AnimatedPanel panel3;
    private javax.swing.JPopupMenu popDetalleFact;
    private javax.swing.JPopupMenu popMateriales;
    private javax.swing.JTable tAbonos;
    private static javax.swing.JTable tDetalleFactura;
    private javax.swing.JTable tMateriales;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JToolBar toolBarTabla2;
    private javax.swing.JToolBar toolBarTabla4;
    private javax.swing.JLabel txtDireccion;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JLabel txtNit;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JTextField txtNumDoc;
    private javax.swing.JLabel txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void seleccionPanel(){
        for(int i = 0; i<panels.length; i++){
            if(i == position){
                pMov.removeAll();
                pMov.repaint();
                pMov.add(panels[i],gbcWizard);
                panels[i].setVisible(true);
            }else{
                panels[i].setVisible(false);
            } 
            if(position == 0){
                btnAnterior.setEnabled(false);
                btnFinalizar.setEnabled(false);
            }
            if(position == 1){
                btnAnterior.setEnabled(true);
                btnSiguiente.setEnabled(true);
                btnFinalizar.setEnabled(false);
            }
            if(position == 2){
                btnSiguiente.setEnabled(false);
                btnFinalizar.setEnabled(true);
            }
        }
    }
    
    private void cargarTablaMateriales(){
        for(int i=0; i<tMateriales.getRowCount(); i++){
            dtmMateriales.removeRow(i);
            i-=1;
        }
        SelectQuery<Record> query = create.selectQuery();
        query.addSelect(
                V_INVENTARIO.IDINVENTARIO,
                V_INVENTARIO.CODIGO, 
                V_INVENTARIO.NOMBRE,
                V_INVENTARIO.CATEGORIA,
                V_INVENTARIO.PRECIOCOMPRA,
                V_INVENTARIO.EXISTENCIA);
        query.addFrom(V_INVENTARIO);
        Condition filtro;
        switch(cbxFiltro.getSelectedIndex()){
            case 1: 
                filtro = V_INVENTARIO.CODIGO.likeIgnoreCase("%"+txtFiltro.getText()+"%");                
                break;
            case 2:
                filtro = V_INVENTARIO.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            case 3:
                filtro = V_INVENTARIO.CATEGORIA.likeIgnoreCase("%"+txtFiltro.getText()+"%");
                break;
            default:
                filtro = V_INVENTARIO.CATEGORIA.likeIgnoreCase("%"+txtFiltro.getText()+"%")
                        .or(V_INVENTARIO.NOMBRE.likeIgnoreCase("%"+txtFiltro.getText()+"%"))
                        .or(V_INVENTARIO.CODIGO.likeIgnoreCase("%"+txtFiltro.getText()+"%"));
                break;
        }
        query.addConditions(filtro.and(V_INVENTARIO.BAJA.equal(false)));
        query.addOrderBy(V_INVENTARIO.CODIGO.asc());
        Object [][] registros = query.fetchArrays();
        for (Object[] row : registros) {
            dtmMateriales.addRow(row);
        }
    }
    
    private void cargarTablaAbonos(){
        for(int i=0; i<tAbonos.getRowCount(); i++){
            dtmAbonos.removeRow(i);
            i-=1;
        }
        
        SelectQuery<Record> query = create.selectQuery();
        query.addFrom(PAGOS_COMPRAS);
        query.addConditions(PAGOS_COMPRAS.IDCOMPRA.equal(idfactura));
        query.addOrderBy(PAGOS_COMPRAS.FECHA.asc());
        Result<Record> result = query.fetch();
        int n = 0;
        for (Record r : result){
            n++;
            Object[] row = {r.getValue(PAGOS_COMPRAS.IDCOMPRA),n,r.getValue(PAGOS_COMPRAS.FECHA),r.getValue(PAGOS_COMPRAS.PAGO)};
            dtmAbonos.addRow(row);
        }
        
        if(tAbonos.getRowCount()>0){
            tAbonos.changeSelection(0, 1, false, false);
        }  
    }
    
    private void dibujarTablas(){
        tMateriales.setGridColor(colorUI);
        JTableHeader headerMateriales = tMateriales.getTableHeader();
        headerMateriales.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tMateriales.setTableHeader(  headerMateriales );
        
        tMateriales.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tMateriales.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tMateriales.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tMateriales.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("num",new Color(113, 205, 245)));
        tMateriales.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("num",new Color(113, 205, 245)));
        
        tMateriales.repaint();
        
        tDetalleFactura.setGridColor(colorUI);
        JTableHeader headerDetalle = tDetalleFactura.getTableHeader();
        headerDetalle.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tDetalleFactura.setTableHeader(  headerDetalle );
        
        tDetalleFactura.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tDetalleFactura.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tDetalleFactura.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        
        tDetalleFactura.repaint();
        
        tAbonos.setGridColor(colorUI);
        JTableHeader headerAbonos = tAbonos.getTableHeader();
        headerAbonos.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tAbonos.setTableHeader(  headerAbonos );
        
        tAbonos.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tAbonos.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tAbonos.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("precio",new Color(113, 205, 245)));
        
    }
    
    private void pasarNuevoMaterial(int idinventario) throws Exception{
        Record record = create.select(
                INVENTARIO.IDINVENTARIO,
                INVENTARIO.CODIGO,
                INVENTARIO.NOMBRE, 
                INVENTARIO.PRECIOCOMPRA,
                INVENTARIO.EXISTENCIA)
                .from(INVENTARIO)
                .where(INVENTARIO.IDINVENTARIO.equal(idinventario))
                .fetchOne();
        BigDecimal precio = (BigDecimal) record.getValue(INVENTARIO.PRECIOCOMPRA);
        Object [] row = {
            record.getValue(INVENTARIO.IDINVENTARIO),
            record.getValue(INVENTARIO.CODIGO),
            record.getValue(INVENTARIO.NOMBRE),
            new SpinnerNumberModel(1, 1, 999.99, 1),
            new SpinnerNumberModel(precio.doubleValue(), 0.00, 9999.99, .1)};
        if(isOnDetalle(idinventario)){
            new Mensajes().mensajeAlert("El material ya se encuentra en detalle de factura!");
        }else{
            dtmDetalleFactura.addRow(row);
            agregarMaterialADetalle(idinventario,new BigDecimal(0.00)); 
        }
    }
    
    private boolean isOnDetalle(int idmaterial){
        boolean encuentra = false;
        for(int i=0; i<tDetalleFactura.getRowCount(); i++){
            int enTabla = (int) tDetalleFactura.getValueAt(i, 0);
            if(enTabla == idmaterial){
                encuentra = true;
            }
        }
        return encuentra;
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

    private void iniciaTransaccion() {
        System.out.println("INICIANDO TRANSACCION");        
        Date date = txtFecha.getDate();
        java.sql.Date fecha = new java.sql.Date (date.getTime());
        BigDecimal total = BigDecimal.valueOf(0.00);
        try {
            database.getConexion().setAutoCommit(false);
            idfactura = create.insertInto(COMPRAS)
                .set(COMPRAS.IDPROVEEDOR,idproveedor)
                .set(COMPRAS.FECHA,fecha)
                .set(COMPRAS.TIPODOCUMENTO,cbxTipoDoc.getSelectedItem().toString())
                .set(COMPRAS.NUMERODOCUMENTO,txtNumDoc.getText())
                .set(COMPRAS.TOTAL,total)
                .returning(COMPRAS.IDCOMPRA)
                .fetchOne().getValue(COMPRAS.IDCOMPRA);
            ISINICIADA = true;
        } catch (SQLException ex) {
            Logger.getLogger(DialogFactura.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    private void actualizarDocumentoCompra() throws Exception{
        create.update(COMPRAS)
                .set(COMPRAS.NUMERODOCUMENTO,txtNumDoc.getText())
                    .where(COMPRAS.IDCOMPRA.equal(idfactura))
                    .execute();
        TRANSACCION = txtNumDoc.getText();
    }

    private void actualizarFechaCompra() throws Exception{
        Date date = txtFecha.getDate();
        java.sql.Date fecha = new java.sql.Date (date.getTime());
        create.update(COMPRAS)
                .set(COMPRAS.FECHA,fecha)
                .where(COMPRAS.IDCOMPRA.equal(idfactura))
                .execute();
    }

    private void actualizarTipoDocumento() throws Exception{
        create.update(COMPRAS)
                .set(COMPRAS.TIPODOCUMENTO,cbxTipoDoc.getSelectedItem().toString())
                .where(COMPRAS.IDCOMPRA.equal(idfactura))
                .execute();
    }

    private void cargarInfoProveedor() throws Exception{
        Record r = create.select()
                .from(PROVEEDOR)
                .where(PROVEEDOR.IDPROVEEDOR.equal(idproveedor))
                .fetchOne();
        txtNombre.setText(r.getValue(PROVEEDOR.NOMBRE));
        txtDireccion.setText(r.getValue(PROVEEDOR.DIRECCION));
        txtNit.setText(r.getValue(PROVEEDOR.NIT));
        txtTelefono.setText(r.getValue(PROVEEDOR.TELEFONO));
    }

    private void agregarMaterialADetalle(int idinventario,BigDecimal precio) throws Exception{
        create.insertInto(DETALLE_COMPRA)
                .set(DETALLE_COMPRA.IDINVENTARIO,idinventario)
                .set(DETALLE_COMPRA.IDCOMPRA,idfactura)
                .set(DETALLE_COMPRA.CANTIDAD,1.00)
                .set(DETALLE_COMPRA.PRECIOCOMPRA,precio)
                .execute();
        calcularTotal();
    }   
    
    private void actualizarMaterialADetalle() throws Exception{
        int idmaterial = (int) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 0);
        SpinnerNumberModel cantidad = (SpinnerNumberModel) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 3);
        SpinnerNumberModel precio = (SpinnerNumberModel) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 4);
        double cant = (double) cantidad.getValue();
        double pUnitario = (double) precio.getValue();
        create.update(DETALLE_COMPRA)
                .set(DETALLE_COMPRA.CANTIDAD,cant)
                .set(DETALLE_COMPRA.PRECIOCOMPRA, new BigDecimal(pUnitario))
                .where((DETALLE_COMPRA.IDCOMPRA.equal(idfactura)).and(DETALLE_COMPRA.IDINVENTARIO.equal(idmaterial)))
                .execute();
        calcularTotal();
    }
    
    private void eliminarMaterialADetalle() throws Exception{
        int idmaterial = (int) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 0);
        create.delete(DETALLE_COMPRA)
                .where((DETALLE_COMPRA.IDCOMPRA.equal(idfactura)).and(DETALLE_COMPRA.IDINVENTARIO.equal(idmaterial)))
                .execute();
        dtmDetalleFactura.removeRow(tDetalleFactura.getSelectedRow());
        calcularTotal();
    }
    
    private void actualizarInventario() throws Exception{
        double cantidad = 0;
        BigDecimal precio;
        for(int i=0; i< tDetalleFactura.getRowCount(); i++){
            int idmaterial = (int) tDetalleFactura.getValueAt(i, 0);
            SpinnerNumberModel cantidadUnit = (SpinnerNumberModel) tDetalleFactura.getValueAt(i, 3);
            SpinnerNumberModel precioUnit = (SpinnerNumberModel) tDetalleFactura.getValueAt(i, 4);
            cantidad = (double) cantidadUnit.getValue();
            precio = BigDecimal.valueOf((double) precioUnit.getValue());
            actualizarCosto(idmaterial,cantidad,precio);
        }
    }
    
    private void actualizarCosto(int idinventario,double entrada, BigDecimal nuevoCosto) throws Exception{
        Record r = create.select(INVENTARIO.EXISTENCIA,INVENTARIO.PRECIOCOMPRA)
                .from(INVENTARIO)
                .where(INVENTARIO.IDINVENTARIO.equal(idinventario))
                .fetchOne();
        
        CostoPromedio cp = new CostoPromedio(entrada,
                nuevoCosto.doubleValue(),
                r.getValue(INVENTARIO.EXISTENCIA),
                r.getValue(INVENTARIO.PRECIOCOMPRA).doubleValue());
        double costo = cp.calcularCosto();
        double stock = cp.getTotalStock();
        BigDecimal preciocompra = BigDecimal.valueOf(costo);
        create.update(INVENTARIO)
                .set(INVENTARIO.PRECIOCOMPRA, preciocompra)
                .set(INVENTARIO.EXISTENCIA, stock)
                .where(INVENTARIO.IDINVENTARIO.equal(idinventario))
                .execute();
    }

    private void actualizarTotal(BigDecimal total) throws Exception{
        create.update(COMPRAS)
                .set(COMPRAS.TOTAL,total)
                .where(COMPRAS.IDCOMPRA.equal(idfactura))
                .execute();
    }

    private void calcularTotal() throws Exception{
        double cantUnit = 0;
        double precioUnit = 0;
        double sumatoria = 0.00;
        for(int i=0; i<tDetalleFactura.getRowCount(); i++){
            SpinnerNumberModel cantidad = (SpinnerNumberModel) tDetalleFactura.getValueAt(i, 3);
            SpinnerNumberModel precio = (SpinnerNumberModel) tDetalleFactura.getValueAt(i, 4);
            cantUnit = (double) cantidad.getValue();
            precioUnit = (double) precio.getValue();
            dtmDetalleFactura.setValueAt((String.format("%.2f",(cantUnit*precioUnit))) , i, 5);
            sumatoria = sumatoria + (cantUnit*precioUnit);
        }
        String total = String.format("%.2f", sumatoria);
        lblTotal.setText(total);
        lblTotalFactura.setText(total);
        actualizarTotal(new BigDecimal(total));
    }
    
    private void calcularAbonos(){
        double total = 0;
        for(int i=0; i<tAbonos.getRowCount(); i++){
            BigDecimal pago = (BigDecimal) tAbonos.getValueAt(i, 3);
            total = total + pago.doubleValue();
        }
        lblTotalPagos.setText(String.format("%.2f", total));
    }
    
    private void verificarPosition() throws Exception {
        switch(position){
            case 0:
                if(isPanel1Valido()){
                    avanzar = true;
                    ingresarFactura();                    
                }else{
                    new Mensajes().mensajeAlert("Se necesita número de Factura");
                    avanzar = false;
                }
                break;
            case 1:
                if(isPanel2Valido()){
                    avanzar = true;
                }else{
                    new Mensajes().mensajeAlert("Agregue productos a detalle");
                    avanzar = false;
                }
                break;
        }
    }

    private boolean isPanel1Valido() {
        return !(txtNumDoc.getText()==null || txtNumDoc.getText().equals(""));
    }

    private void ingresarFactura() throws Exception {
        if(isFacturaRepetida()){
            int n = new Mensajes().mensajeSiNo("Número de factura repetida para este proveedor, desea continuar?");
            if(n == 0){
                actualizarDocumentoCompra();
            }else{
                avanzar = false;
                txtNumDoc.setText("");
            }
        }
    }

    private boolean isFacturaRepetida() {
        if(!TRANSACCION.equals(txtNumDoc.getText())){
            int existe = create.select(count())
                    .from(COMPRAS)
                    .where(COMPRAS.NUMERODOCUMENTO.equal(txtNumDoc.getText()).and(COMPRAS.IDPROVEEDOR.equal(this.idproveedor)))
                    .fetchOne(count(),int.class);
            System.out.println("pedidos: "+existe);
            return existe != 0;
        }else{
            return false;
        }
    }

    private boolean isPanel2Valido() {
        return tDetalleFactura.getRowCount()>0;
    }
    
    public class SpinnerEditor extends AbstractCellEditor implements TableCellEditor{

    protected JSpinner spinner;
    
    public SpinnerEditor() {
        spinner = new JSpinner();
        spinner.setUI(new SpinnerUI(colorBG,cBtnNormal));
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                try {
                    actualizarMaterialADetalle();
                } catch (Exception ex) {
                    Logger.getLogger(DialogFactura.class.getName()).log(Level.SEVERE, null, ex);
                    new Mensajes().mensajeError("Ha ocurrido un error con la transacción!");
                }
            }
        } );
    }
    
    @Override
    public Object getCellEditorValue() {
        SpinnerModel sm = spinner.getModel();        
        return sm;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object value, boolean bln, int i, int i1) {
        spinner.setModel((SpinnerModel) value);
        return spinner;
    }
    
}
    
    public class SpinnerRenderer extends JSpinner implements TableCellRenderer {
    
    public SpinnerRenderer() {
        setUI(new SpinnerUI(colorBG,cBtnNormal));
    }

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int i, int i1) {
        setModel((SpinnerModel) value); 
        return this;
    }
    
}

}