
package dialogs.produccion;

import clases.CategoriaProducto;
import dialogs.ventas.*;
import clases.ImageConverter;
import clases.Mensajes;
import com.sun.glass.events.KeyEvent;
import static db.clases.Tables.CATEGORIA_PRODUCTO;
import static db.clases.Tables.EMPRESA;
import static db.clases.Tables.GASTOS;
import static db.clases.Tables.GASTOS_EMPRESA;
import static db.clases.Tables.INVENTARIO;
import static db.clases.Tables.PRECIOS;
import static db.clases.Tables.PRODUCTO;
import static db.clases.Tables.RECETA;
import static db.clases.Tables.TAMANIO;
import static db.clases.Tables.UNIDAD_MEDIDA;
import static db.clases.Tables.V_INVENTARIO;
import static db.clases.Tables.V_MEDIDAS;
import static db.clases.Tables.V_RECETA;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.combobox.Unidad;
import design.spinner.SpinnerUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javax.swing.AbstractCellEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
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

/* @author JL Desk */
public class DialogProductos extends javax.swing.JDialog {

    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);
    
    private boolean guardado = false;
    
    DefaultTableModel dtmDetalleFactura;
    DefaultTableModel dtmMateriales;
    DefaultTableModel dtmTamanios;
    DefaultTableModel dtmReceta;
    
    DefaultComboBoxModel dcmMedida = new DefaultComboBoxModel();
    DefaultComboBoxModel dcmUnidad = new DefaultComboBoxModel();
    DefaultComboBoxModel dcmCategoria = new DefaultComboBoxModel();
    
    File file;
    
    boolean nuevo = true;
    boolean hayCat = true;
    
    String CODIGOP;
    String CATEGORIAP;
    
    private final JFXPanel jfxPanel = new JFXPanel(); 
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final StackedBarChart bc = new StackedBarChart<String, Number>(xAxis, yAxis);   
    ObservableList<XYChart.Series<String,Double>> data2d = FXCollections.observableArrayList();
    
    double costosTotales = 0;
    
    JPanel[] panels;
    int position = 0;
    
    GridBagConstraints  gbcWizard = new GridBagConstraints();
    
    String CODIGOPRODUCTO;
    boolean ISINICIADA = false;
    boolean TAMANIONUEVO = false;
    
    int idproducto;

    public DialogProductos(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);
        this.setTitle(titulo);
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            dtmDetalleFactura = (DefaultTableModel) tReceta.getModel();
            dtmMateriales = (DefaultTableModel) tMateriales.getModel();
            dtmTamanios = (DefaultTableModel) tTamanios.getModel(); 
            dtmReceta= (DefaultTableModel) tReceta.getModel(); 
            cargarCategoria();
        } catch (Exception ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        gbcWizard.fill = java.awt.GridBagConstraints.BOTH;
        gbcWizard.anchor = java.awt.GridBagConstraints.CENTER;
        gbcWizard.weightx = 1.0;
        gbcWizard.weighty = 1.0;
        gbcWizard.insets = new Insets(10,10,10,10);
        panels = new JPanel[] {panel1, panel2, panel3, panel4};
        seleccionPanel();
        cargarFotoNoImage();
        dibujarTablas();
        try {
            cargarTablaMateriales();
            
        } catch (Exception ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        Platform.setImplicitExit(false);
        Platform.runLater(this::createScene);
        GridBagConstraints  gbcChart = new GridBagConstraints();
        gbcChart.fill = java.awt.GridBagConstraints.BOTH;
        gbcChart.weightx = 1.0;
        gbcChart.weighty = 1.0;
        pCostos.add(jfxPanel,gbcChart); 
        iniciaTransaccion();
        try {
            cargarTablaTamanios();
        } catch (Exception ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DialogProductos(java.awt.Frame parent, boolean modal, String titulo, int idproducto, String codigoproducto, String categoria) {
        super(parent, modal);
        this.setTitle(titulo);
        nuevo=false;
        initComponents();
        this.setLocationRelativeTo(null);
        this.CATEGORIAP = categoria;
        this.CODIGOPRODUCTO = codigoproducto;
        this.CODIGOP = CODIGOPRODUCTO;
        this.idproducto = idproducto;
        lblCodigo.setText(CODIGOP);
        try {
            dtmDetalleFactura = (DefaultTableModel) tReceta.getModel();
            dtmMateriales = (DefaultTableModel) tMateriales.getModel();
            dtmTamanios = (DefaultTableModel) tTamanios.getModel();
            dtmReceta= (DefaultTableModel) tReceta.getModel();
            cargarCategoria();
        } catch (Exception ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        gbcWizard.fill = java.awt.GridBagConstraints.BOTH;
        gbcWizard.anchor = java.awt.GridBagConstraints.CENTER;
        gbcWizard.weightx = 1.0;
        gbcWizard.weighty = 1.0;
        gbcWizard.insets = new Insets(10,10,10,10);
        panels = new JPanel[] {panel1, panel2, panel3, panel4};
        seleccionPanel();
        dibujarTablas();
        try {
            cargarTablaMateriales();
        } catch (Exception ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        Platform.setImplicitExit(false);
        Platform.runLater(this::createScene);
        GridBagConstraints  gbcChart = new GridBagConstraints();
        gbcChart.fill = java.awt.GridBagConstraints.BOTH;
        gbcChart.weightx = 1.0;
        gbcChart.weighty = 1.0;
        pCostos.add(jfxPanel,gbcChart); 
        editarTransaccion();
        cargarForm(CODIGOP);
        try {
            cargarTablaTamanios();
            cargarTablaReceta();
            cargarPrecios();
        } catch (Exception ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnCargarFoto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxTermina = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel2 = new com.mrlonee.swing.animation.AnimatedPanel();
        toolBarTabla1 = new javax.swing.JToolBar();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel17 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jPanel15 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tMateriales = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tReceta = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        spTiempo = new javax.swing.JSpinner();
        pCostos = new javax.swing.JPanel();
        panel3 = new com.mrlonee.swing.animation.AnimatedPanel();
        toolBarTabla4 = new javax.swing.JToolBar();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        jLabel20 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnNuevoT = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnEditarT = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnGuardarT = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnCancelarT = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTamanio = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tTamanios = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        panel4 = new com.mrlonee.swing.animation.AnimatedPanel();
        toolBarTabla5 = new javax.swing.JToolBar();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        jLabel21 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        spGananciaNormal = new javax.swing.JSpinner();
        spGananciaVIP = new javax.swing.JSpinner();
        spGananciaDist = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        chkPrecioManual = new javax.swing.JCheckBox();
        spPrecioDist = new javax.swing.JSpinner();
        spPrecioVIP = new javax.swing.JSpinner();
        spPrecioNormal = new javax.swing.JSpinner();
        lblCostosTotales = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
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
        panel1.setPreferredSize(new java.awt.Dimension(718, 351));
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
        jLabel11.setText("Información de Producto");
        toolBarTabla2.add(jLabel11);
        toolBarTabla2.add(jSeparator10);

        btnCargarFoto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCargarFoto.setForeground(colorBG);
        btnCargarFoto.setText("Cargar Foto");
        btnCargarFoto.setFocusable(false);
        btnCargarFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCargarFoto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });
        toolBarTabla2.add(btnCargarFoto);
        btnCargarFoto.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel1.add(toolBarTabla2, gridBagConstraints);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 10));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 10));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lblCodigo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblCodigo.setForeground(colorUI);
        lblCodigo.setMinimumSize(new java.awt.Dimension(200, 43));
        lblCodigo.setPreferredSize(new java.awt.Dimension(200, 43));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(lblCodigo, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("(*) Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel2, gridBagConstraints);

        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre.setMinimumSize(new java.awt.Dimension(200, 30));
        txtNombre.setPreferredSize(new java.awt.Dimension(200, 30));
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel2.add(txtNombre, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Descripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel3, gridBagConstraints);

        jScrollPane3.setMinimumSize(new java.awt.Dimension(166, 100));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(166, 100));

        txtDetalle.setBackground(colorBG);
        txtDetalle.setColumns(20);
        txtDetalle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDetalle.setLineWrap(true);
        txtDetalle.setRows(5);
        txtDetalle.setWrapStyleWord(true);
        txtDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDetalleKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(txtDetalle);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel2.add(jScrollPane3, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Color:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel6, gridBagConstraints);

        txtColor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtColor.setMinimumSize(new java.awt.Dimension(200, 30));
        txtColor.setPreferredSize(new java.awt.Dimension(200, 30));
        txtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorActionPerformed(evt);
            }
        });
        txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtColorKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel2.add(txtColor, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("(*) Categoria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel4, gridBagConstraints);

        cbxCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxCategoria.setModel(dcmCategoria);
        cbxCategoria.setSelectedIndex(-1);
        cbxCategoria.setMinimumSize(new java.awt.Dimension(200, 30));
        cbxCategoria.setPreferredSize(new java.awt.Dimension(200, 30));
        cbxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCategoriaItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel2.add(cbxCategoria, gridBagConstraints);
        cbxCategoria.setUI(new ComboUI(colorBG,java.awt.Color.GRAY));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Finaliza");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel2.add(jLabel5, gridBagConstraints);

        cbxTermina.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxTermina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diseño", "Producción" }));
        cbxTermina.setMinimumSize(new java.awt.Dimension(150, 30));
        cbxTermina.setPreferredSize(new java.awt.Dimension(150, 30));
        cbxTermina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTerminaItemStateChanged(evt);
            }
        });
        cbxTermina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbxTerminaKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel2.add(cbxTermina, gridBagConstraints);
        cbxTermina.setUI(new ComboUI(colorBG,java.awt.Color.GRAY));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel4.setBackground(colorBG);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        lblFoto.setMaximumSize(new java.awt.Dimension(250, 250));
        lblFoto.setMinimumSize(new java.awt.Dimension(250, 250));
        lblFoto.setPreferredSize(new java.awt.Dimension(250, 250));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 10);
        jPanel4.add(lblFoto, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Imagen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 10);
        jPanel4.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 30);
        jPanel1.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panel1.add(jPanel1, gridBagConstraints);

        panel2.setBorder(new javax.swing.border.LineBorder(colorUI, 3, true));
        panel2.setAnimationType(com.mrlonee.swing.animation.AnimatedPanel.AnimationType.SlideAnimationFromRight);
        panel2.setLayout(new java.awt.GridBagLayout());

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
        jLabel17.setText("Producción y Costos");
        toolBarTabla1.add(jLabel17);
        toolBarTabla1.add(jSeparator8);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel2.add(toolBarTabla1, gridBagConstraints);

        jPanel15.setBackground(new java.awt.Color(0, 51, 255));
        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        tMateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Codigo", "Nombre", "Categoria", "P.Compra", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
            tMateriales.getColumnModel().getColumn(1).setMinWidth(65);
            tMateriales.getColumnModel().getColumn(1).setPreferredWidth(65);
            tMateriales.getColumnModel().getColumn(1).setMaxWidth(65);
            tMateriales.getColumnModel().getColumn(3).setMinWidth(100);
            tMateriales.getColumnModel().getColumn(3).setPreferredWidth(100);
            tMateriales.getColumnModel().getColumn(3).setMaxWidth(100);
            tMateriales.getColumnModel().getColumn(4).setMinWidth(60);
            tMateriales.getColumnModel().getColumn(4).setPreferredWidth(60);
            tMateriales.getColumnModel().getColumn(4).setMaxWidth(60);
            tMateriales.getColumnModel().getColumn(5).setMinWidth(50);
            tMateriales.getColumnModel().getColumn(5).setPreferredWidth(50);
            tMateriales.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel15.add(jPanel3, gridBagConstraints);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridBagLayout());

        tReceta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Codigo", "Detalle", "Desc. en Inv.", "Un.Medida", "Finaliza en"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tReceta.setComponentPopupMenu(popDetalleFact);
        tReceta.setRowHeight(30);
        tReceta.getTableHeader().setReorderingAllowed(false);
        tReceta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tRecetaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tReceta);
        if (tReceta.getColumnModel().getColumnCount() > 0) {
            tReceta.getColumnModel().getColumn(0).setMinWidth(0);
            tReceta.getColumnModel().getColumn(0).setPreferredWidth(0);
            tReceta.getColumnModel().getColumn(0).setMaxWidth(0);
            tReceta.getColumnModel().getColumn(1).setMinWidth(65);
            tReceta.getColumnModel().getColumn(1).setPreferredWidth(65);
            tReceta.getColumnModel().getColumn(1).setMaxWidth(65);
            tReceta.getColumnModel().getColumn(3).setMinWidth(100);
            tReceta.getColumnModel().getColumn(3).setPreferredWidth(100);
            tReceta.getColumnModel().getColumn(3).setMaxWidth(100);
            tReceta.getColumnModel().getColumn(3).setCellEditor(new SpinnerEditor());
            tReceta.getColumnModel().getColumn(3).setCellRenderer(new SpinnerRenderer());
            tReceta.getColumnModel().getColumn(4).setMinWidth(100);
            tReceta.getColumnModel().getColumn(4).setPreferredWidth(100);
            tReceta.getColumnModel().getColumn(4).setMaxWidth(100);
            tReceta.getColumnModel().getColumn(4).setCellEditor(new ComboEditor());
            tReceta.getColumnModel().getColumn(4).setCellRenderer(new ComboRenderer());
            tReceta.getColumnModel().getColumn(5).setMinWidth(120);
            tReceta.getColumnModel().getColumn(5).setPreferredWidth(120);
            tReceta.getColumnModel().getColumn(5).setMaxWidth(120);
            tReceta.getColumnModel().getColumn(5).setCellEditor(new ComboEditor());
            tReceta.getColumnModel().getColumn(5).setCellRenderer(new ComboRenderer());
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel15.add(jPanel6, gridBagConstraints);

        jPanel5.setMinimumSize(new java.awt.Dimension(400, 50));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("<html><body >Tiempo de<br>Facricación (min)</body></html>");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel7.setMinimumSize(new java.awt.Dimension(98, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel5.add(jLabel7, gridBagConstraints);

        spTiempo.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spTiempo.setMinimumSize(new java.awt.Dimension(100, 30));
        spTiempo.setPreferredSize(new java.awt.Dimension(100, 30));
        spTiempo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spTiempoStateChanged(evt);
            }
        });
        spTiempo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                spTiempoPropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel5.add(spTiempo, gridBagConstraints);
        spTiempo.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        pCostos.setBackground(colorBG);
        pCostos.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(pCostos, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel2.add(jPanel15, gridBagConstraints);

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
        jLabel20.setText("Tamaños");
        toolBarTabla4.add(jLabel20);
        toolBarTabla4.add(jSeparator11);

        btnNuevoT.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNuevoT.setForeground(colorBG);
        btnNuevoT.setText("Nuevo");
        btnNuevoT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoTActionPerformed(evt);
            }
        });
        toolBarTabla4.add(btnNuevoT);
        btnNuevoT.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));
        toolBarTabla4.add(jSeparator1);

        btnEditarT.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEditarT.setForeground(colorBG);
        btnEditarT.setText("Editar");
        btnEditarT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarT.setFocusable(false);
        btnEditarT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTActionPerformed(evt);
            }
        });
        toolBarTabla4.add(btnEditarT);
        btnEditarT.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));
        toolBarTabla4.add(jSeparator2);

        btnGuardarT.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardarT.setForeground(colorBG);
        btnGuardarT.setText("Guardar");
        btnGuardarT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarT.setEnabled(false);
        btnGuardarT.setFocusable(false);
        btnGuardarT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTActionPerformed(evt);
            }
        });
        toolBarTabla4.add(btnGuardarT);
        btnGuardarT.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));
        toolBarTabla4.add(jSeparator4);

        btnCancelarT.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelarT.setForeground(colorBG);
        btnCancelarT.setText("Cancelar");
        btnCancelarT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarT.setEnabled(false);
        btnCancelarT.setFocusable(false);
        btnCancelarT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTActionPerformed(evt);
            }
        });
        toolBarTabla4.add(btnCancelarT);
        btnCancelarT.setUI(new ButtonUI(
            cBtnNormal,
            cBtnOver,
            cBtnPress
        ));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel3.add(toolBarTabla4, gridBagConstraints);

        jPanel19.setOpaque(false);
        jPanel19.setLayout(new java.awt.GridBagLayout());

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("(*) Tamaño");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel7.add(jLabel8, gridBagConstraints);

        txtTamanio.setMinimumSize(new java.awt.Dimension(250, 30));
        txtTamanio.setPreferredSize(new java.awt.Dimension(250, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel7.add(txtTamanio, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel19.add(jPanel7, gridBagConstraints);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jScrollPane4.setMinimumSize(new java.awt.Dimension(452, 402));

        tTamanios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "idtamanio", "No.", "Tamanio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tTamanios.setRowHeight(30);
        tTamanios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tTamaniosMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tTamanios);
        if (tTamanios.getColumnModel().getColumnCount() > 0) {
            tTamanios.getColumnModel().getColumn(0).setMinWidth(0);
            tTamanios.getColumnModel().getColumn(0).setPreferredWidth(0);
            tTamanios.getColumnModel().getColumn(0).setMaxWidth(0);
            tTamanios.getColumnModel().getColumn(1).setMinWidth(50);
            tTamanios.getColumnModel().getColumn(1).setPreferredWidth(50);
            tTamanios.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jScrollPane4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel19.add(jPanel8, gridBagConstraints);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/512/pallet_512x512.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.weightx = 1.0;
        jPanel19.add(jLabel9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel3.add(jPanel19, gridBagConstraints);

        panel4.setBorder(new javax.swing.border.LineBorder(colorUI, 3, true));
        panel4.setAnimationType(com.mrlonee.swing.animation.AnimatedPanel.AnimationType.SlideAnimationFromRight);
        panel4.setLayout(new java.awt.GridBagLayout());

        toolBarTabla5.setBackground(colorUI);
        toolBarTabla5.setBorder(null);
        toolBarTabla5.setFloatable(false);
        toolBarTabla5.setRollover(true);
        toolBarTabla5.setMaximumSize(new java.awt.Dimension(100, 60));
        toolBarTabla5.setMinimumSize(new java.awt.Dimension(100, 60));
        toolBarTabla5.setPreferredSize(new java.awt.Dimension(100, 60));
        toolBarTabla5.add(jSeparator16);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel21.setForeground(colorBG);
        jLabel21.setText("Precios de Venta");
        toolBarTabla5.add(jLabel21);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel4.add(toolBarTabla5, gridBagConstraints);

        jPanel22.setOpaque(false);
        jPanel22.setLayout(new java.awt.GridBagLayout());

        jPanel10.setBackground(colorBG);
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Costos Totales: $");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel10.add(jLabel10, gridBagConstraints);

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Normal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel12.add(jLabel12, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("V.I.P");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(jLabel13, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Distribuidor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(jLabel14, gridBagConstraints);

        jSeparator6.setBackground(colorUI);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel12.add(jSeparator6, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setText("% Ganancia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel12.add(jLabel15, gridBagConstraints);

        spGananciaNormal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        spGananciaNormal.setModel(new javax.swing.SpinnerNumberModel(100.0d, 0.0d, 900.0d, 10.0d));
        spGananciaNormal.setMinimumSize(new java.awt.Dimension(100, 30));
        spGananciaNormal.setPreferredSize(new java.awt.Dimension(100, 50));
        spGananciaNormal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spGananciaNormalStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel12.add(spGananciaNormal, gridBagConstraints);
        spGananciaNormal.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        spGananciaVIP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        spGananciaVIP.setModel(new javax.swing.SpinnerNumberModel(75.0d, 0.0d, 900.0d, 10.0d));
        spGananciaVIP.setMinimumSize(new java.awt.Dimension(100, 30));
        spGananciaVIP.setPreferredSize(new java.awt.Dimension(100, 50));
        spGananciaVIP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spGananciaVIPStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(spGananciaVIP, gridBagConstraints);
        spGananciaVIP.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        spGananciaDist.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        spGananciaDist.setModel(new javax.swing.SpinnerNumberModel(50.0d, 0.0d, 900.0d, 10.0d));
        spGananciaDist.setMinimumSize(new java.awt.Dimension(100, 30));
        spGananciaDist.setPreferredSize(new java.awt.Dimension(100, 50));
        spGananciaDist.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spGananciaDistStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(spGananciaDist, gridBagConstraints);
        spGananciaDist.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setText("Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel12.add(jLabel16, gridBagConstraints);

        chkPrecioManual.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        chkPrecioManual.setText("Precio Manual");
        chkPrecioManual.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chkPrecioManual.setOpaque(false);
        chkPrecioManual.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkPrecioManualItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel12.add(chkPrecioManual, gridBagConstraints);

        spPrecioDist.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        spPrecioDist.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 0.5d));
        spPrecioDist.setEnabled(false);
        spPrecioDist.setMinimumSize(new java.awt.Dimension(100, 30));
        spPrecioDist.setPreferredSize(new java.awt.Dimension(100, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(spPrecioDist, gridBagConstraints);
        spPrecioDist.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        spPrecioVIP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        spPrecioVIP.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 0.5d));
        spPrecioVIP.setEnabled(false);
        spPrecioVIP.setMinimumSize(new java.awt.Dimension(100, 30));
        spPrecioVIP.setPreferredSize(new java.awt.Dimension(100, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(spPrecioVIP, gridBagConstraints);
        spPrecioVIP.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        spPrecioNormal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        spPrecioNormal.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 0.5d));
        spPrecioNormal.setEnabled(false);
        spPrecioNormal.setMinimumSize(new java.awt.Dimension(100, 30));
        spPrecioNormal.setPreferredSize(new java.awt.Dimension(100, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel12.add(spPrecioNormal, gridBagConstraints);
        spPrecioNormal.setUI(new SpinnerUI(colorBG,java.awt.Color.GRAY));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        jPanel10.add(jPanel12, gridBagConstraints);

        lblCostosTotales.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCostosTotales.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel10.add(lblCostosTotales, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel22.add(jPanel10, gridBagConstraints);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Simple Icon Pack/png/512/sale.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        jPanel22.add(jLabel18, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel4.add(jPanel22, gridBagConstraints);

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diseño", "Producción" }));
        combo.setSelectedIndex(0);
        combo.setUI(new ComboUI(colorBG,cBtnNormal));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(colorUI);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));
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
            position++;
            seleccionPanel();
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
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
       try {
           if(nuevo){
               editarProducto();
               crearReceta();
               guardarPrecios();
           }else{
               editarProducto();
               crearReceta();
               editarPrecios();
           }
           database.getConexion().commit();
           this.setGuardado(true);
           dispose();
        } catch (SQLException ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
            this.setGuardado(false);
        } catch (Exception ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
            new Mensajes().mensajeError("Ha ocurrido un error con la transacción!");
        }
        
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formComponentRemoved

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
       try {
           database.getConexion().rollback();
           database.getConexion().setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(DialogPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        try {
            // TODO add your handling code here:
            cargarTablaMateriales();
        } catch (Exception ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        try {
            // TODO add your handling code here:
            cargarTablaMateriales();
        } catch (Exception ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void itemAgregarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarMaterialActionPerformed
        try {
            int idmaterial = (int) tMateriales.getValueAt(tMateriales.getSelectedRow(), 0);
            String codigo = (String) tMateriales.getValueAt(tMateriales.getSelectedRow(), 1);
            String detalle = (String) tMateriales.getValueAt(tMateriales.getSelectedRow(), 2);
            BigDecimal precio = (BigDecimal) tMateriales.getValueAt(tMateriales.getSelectedRow(), 4);
            Object [] row = {
                idmaterial,
                codigo,
                detalle,
                new SpinnerNumberModel(0.5, 0.0000, 999.9999, 0.5),
                modelocbx(cargarID(idmaterial)),
                modeloFinaliza(),
            };
            if(isOnDetalle(idmaterial)){
                new Mensajes().mensajeAlert("El material ya se encuentra dentro de lista!");
            }else{
                dtmDetalleFactura.addRow(row);
                setChartData();
            }
        } catch (Exception ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemAgregarMaterialActionPerformed

    private void itemEliminarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarMaterialActionPerformed
        dtmDetalleFactura.removeRow(tReceta.getSelectedRow());
        setChartData();
    }//GEN-LAST:event_itemEliminarMaterialActionPerformed

    private void btnNuevoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoTActionPerformed
        // TODO add your handling code here:
        TAMANIONUEVO = true;
        txtTamanio.setText("");
        btnNuevoT.setEnabled(false);
        btnEditarT.setEnabled(false);
        tTamanios.setEnabled(false);
        btnGuardarT.setEnabled(true);
        btnCancelarT.setEnabled(true);
    }//GEN-LAST:event_btnNuevoTActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed

    private void cbxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCategoriaItemStateChanged
        // TODO add your handling code here:
        CategoriaProducto cat = (CategoriaProducto) cbxCategoria.getSelectedItem();
        if(nuevo){
            if(cat.getId()>0){
                lblCodigo.setText(cat.generarCodigo());
                if(ISINICIADA){
                    try {
                        editarCodigoProducto();
                        cargarTablaTamanios();
                    } catch (Exception ex) {
                        Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
                        new Mensajes().mensajeAlert("Ha ocurrido un problema con la transacción!");
                    }
                }else{
                    CODIGOPRODUCTO = CODIGOP;
                }
                btnSiguiente.setEnabled(true);
            }else{
                lblCodigo.setText("");
                btnSiguiente.setEnabled(false);
            }
        }else{
            if(CATEGORIAP.equals(cat.getNombre())){
                lblCodigo.setText(CODIGOP);
            }else{
                lblCodigo.setText(cat.generarCodigo());
            }
        }
    }//GEN-LAST:event_cbxCategoriaItemStateChanged

    private void cbxTerminaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTerminaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTerminaItemStateChanged

    private void spTiempoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spTiempoStateChanged
        // TODO add your handling code here:
        setChartData();
    }//GEN-LAST:event_spTiempoStateChanged

    private void spTiempoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_spTiempoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_spTiempoPropertyChange

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG","jpg");
        chooser.setFileFilter(filtro);
        int res = chooser.showOpenDialog(DialogProductos.this);
        if(res == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            ImageIcon image = new ImageIcon(file.getAbsolutePath());

            Rectangle rect = lblFoto.getBounds();
            Image scaledImage = image.getImage().getScaledInstance(rect.width, rect.height, Image.SCALE_DEFAULT);
            image = new ImageIcon(scaledImage);
            lblFoto.setIcon(image);
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getName());
        }
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtDetalle.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtDetalleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDetalleKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtColor.requestFocus();
        }
    }//GEN-LAST:event_txtDetalleKeyReleased

    private void txtColorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            cbxTermina.requestFocus();
        }
    }//GEN-LAST:event_txtColorKeyReleased

    private void cbxTerminaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxTerminaKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            spTiempo.requestFocus();
        }
    }//GEN-LAST:event_cbxTerminaKeyReleased

    private void tMaterialesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMaterialesMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tMateriales.rowAtPoint(point);
        tMateriales.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tMaterialesMousePressed

    private void tRecetaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tRecetaMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tReceta.rowAtPoint(point);
        tReceta.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tRecetaMousePressed

    private void btnGuardarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTActionPerformed
        try {
            if(txtTamanio.getText()==null || txtTamanio.getText().equals("")){
                new Mensajes().mensajeAlert("NO PUEDE QUEDAR VACIO");
            }else{
                if(TAMANIONUEVO){
                    nuevoTamanio();
                }else{
                    int id = (int) tTamanios.getValueAt(tTamanios.getSelectedRow(), 0);
                    editarTamanio(id);
                }
                txtTamanio.setText("");
                btnNuevoT.setEnabled(true);
                btnEditarT.setEnabled(true);
                tTamanios.setEnabled(true);
                btnGuardarT.setEnabled(false);
                btnCancelarT.setEnabled(false);
                cargarTablaTamanios();
            }
        } catch (Exception ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarTActionPerformed

    private void btnCancelarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTActionPerformed
        // TODO add your handling code here:
        txtTamanio.setText("");
        btnNuevoT.setEnabled(true);
        btnEditarT.setEnabled(true);
        tTamanios.setEnabled(true);
        btnGuardarT.setEnabled(false);
        btnCancelarT.setEnabled(false);
    }//GEN-LAST:event_btnCancelarTActionPerformed

    private void btnEditarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTActionPerformed
        // TODO add your handling code here:
        TAMANIONUEVO=false;
        String tama = (String) tTamanios.getValueAt(tTamanios.getSelectedRow(), 2);
        txtTamanio.setText(tama);
        btnNuevoT.setEnabled(false);
        btnEditarT.setEnabled(false);
        tTamanios.setEnabled(false);
        btnGuardarT.setEnabled(true);
        btnCancelarT.setEnabled(true);
    }//GEN-LAST:event_btnEditarTActionPerformed

    private void tTamaniosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTamaniosMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tTamanios.rowAtPoint(point);
        tTamanios.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tTamaniosMousePressed

    private void spGananciaNormalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spGananciaNormalStateChanged
        // TODO add your handling code here:
        calcularPrecioNormal();
    }//GEN-LAST:event_spGananciaNormalStateChanged

    private void spGananciaVIPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spGananciaVIPStateChanged
        // TODO add your handling code here:
        calcularPrecioVIP();
    }//GEN-LAST:event_spGananciaVIPStateChanged

    private void spGananciaDistStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spGananciaDistStateChanged
        // TODO add your handling code here:
        calcularPrecioDist();
    }//GEN-LAST:event_spGananciaDistStateChanged

    private void chkPrecioManualItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkPrecioManualItemStateChanged
        // TODO add your handling code here:
        if(chkPrecioManual.isSelected()){
            spPrecioNormal.setEnabled(true);
            spPrecioVIP.setEnabled(true);
            spPrecioDist.setEnabled(true);
        }else{
            spPrecioNormal.setEnabled(false);
            spPrecioVIP.setEnabled(false);
            spPrecioDist.setEnabled(false);
            calcularPrecioNormal();
            calcularPrecioVIP();
            calcularPrecioDist();
        }
    }//GEN-LAST:event_chkPrecioManualItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarT;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnEditarT;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnGuardarT;
    private javax.swing.JButton btnNuevoT;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JComboBox<String> cbxTermina;
    private javax.swing.JCheckBox chkPrecioManual;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JMenuItem itemAgregarMaterial;
    private javax.swing.JMenuItem itemEliminarMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCostosTotales;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JPanel pCostos;
    private javax.swing.JPanel pMov;
    private com.mrlonee.swing.animation.AnimatedPanel panel1;
    private com.mrlonee.swing.animation.AnimatedPanel panel2;
    private com.mrlonee.swing.animation.AnimatedPanel panel3;
    private com.mrlonee.swing.animation.AnimatedPanel panel4;
    private javax.swing.JPopupMenu popDetalleFact;
    private javax.swing.JPopupMenu popMateriales;
    private javax.swing.JSpinner spGananciaDist;
    private javax.swing.JSpinner spGananciaNormal;
    private javax.swing.JSpinner spGananciaVIP;
    private javax.swing.JSpinner spPrecioDist;
    private javax.swing.JSpinner spPrecioNormal;
    private javax.swing.JSpinner spPrecioVIP;
    private javax.swing.JSpinner spTiempo;
    private javax.swing.JTable tMateriales;
    private static javax.swing.JTable tReceta;
    private javax.swing.JTable tTamanios;
    private javax.swing.JToolBar toolBarTabla1;
    private javax.swing.JToolBar toolBarTabla2;
    private javax.swing.JToolBar toolBarTabla4;
    private javax.swing.JToolBar toolBarTabla5;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextArea txtDetalle;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTamanio;
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
                if(ISINICIADA){
                    btnAnterior.setEnabled(true);
                    btnSiguiente.setEnabled(true);
                    btnFinalizar.setEnabled(false);
                }            
            }
            if(position == 2){
                if(ISINICIADA){
                    btnAnterior.setEnabled(true);
                    btnSiguiente.setEnabled(true);
                    btnFinalizar.setEnabled(false);
                }            
            }
            if(position == 3){
                btnSiguiente.setEnabled(false);
                btnFinalizar.setEnabled(true);
            }
        }
    }
    
    private void cargarTablaMateriales() throws Exception{
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
        Condition baja = V_INVENTARIO.BAJA.equal(false);
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
        query.addConditions(filtro.and(baja));
        query.addOrderBy(V_INVENTARIO.CODIGO.asc());
        Object [][] registros = query.fetchArrays();
        for (Object[] row : registros) {
            dtmMateriales.addRow(row);
        }
    }
    
    private void cargarTablaTamanios() throws Exception{
        for(int i=0; i<tTamanios.getRowCount(); i++){
            dtmTamanios.removeRow(i);
            i-=1;
        }
        
        SelectQuery<Record> query = create.selectQuery();
        query.addSelect(TAMANIO.IDTAMANIO,TAMANIO.TAMANIO_);
        query.addFrom(TAMANIO);
        query.addConditions(TAMANIO.IDPRODUCTO.equal(this.idproducto));
        Result<Record> result = query.fetch();
        int n = 0;
        for (Record r : result) {
            n++;
            Object[] row = {
                r.getValue(TAMANIO.IDTAMANIO),
                n,
                r.getValue(TAMANIO.TAMANIO_)
            };
            dtmTamanios.addRow(row);
        }
        
        if(tTamanios.getRowCount()>0){
            tTamanios.changeSelection(0, 1, false, false);
        } 
    }
    
    private void cargarCategoria() throws Exception{
        dcmCategoria.removeAllElements();
        Result<Record> result = create.select()
                .from(CATEGORIA_PRODUCTO)
                .orderBy(CATEGORIA_PRODUCTO.NOMBRE.asc())
                .fetch();
        dcmCategoria.addElement(new CategoriaProducto(0,"SELECCIONE CATEGORIA",""));
        if(result.size()>0){
            for (Record r : result) {
                dcmCategoria.addElement(new CategoriaProducto(
                        r.getValue(CATEGORIA_PRODUCTO.IDCATEGORIA)
                        ,r.getValue(CATEGORIA_PRODUCTO.NOMBRE)
                        ,r.getValue(CATEGORIA_PRODUCTO.CODIGOCATEGORIA)));
            }
        }else{
            new Mensajes().mensajeAlert("Se necesita crear categorias");
            hayCat = false;
        }        
    }    
        
    private void dibujarTablas(){
        tReceta.setGridColor(colorUI);
        JTableHeader headerDetalle = tReceta.getTableHeader();
        headerDetalle.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tReceta.setTableHeader(  headerDetalle );
        
        tMateriales.setGridColor(colorUI);
        JTableHeader headerMateriales = tMateriales.getTableHeader();
        headerMateriales.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tMateriales.setTableHeader(  headerMateriales );
        
        tReceta.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tReceta.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        
        tMateriales.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tMateriales.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tMateriales.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tMateriales.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("num",new Color(113, 205, 245)));
        tMateriales.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("num",new Color(113, 205, 245)));
        
        tReceta.repaint();
        tMateriales.repaint();
        
        tTamanios.setGridColor(colorUI);
        JTableHeader headerTamanio = tTamanios.getTableHeader();
        headerTamanio.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tTamanios.setTableHeader(  headerTamanio );
        
        tTamanios.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center",new Color(113, 205, 245)));
        tTamanios.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text",new Color(113, 205, 245)));
        tTamanios.repaint();
    }
        
    private boolean isOnDetalle(int idmaterial){
        boolean encuentra = false;
        for(int i=0; i<tReceta.getRowCount(); i++){
            int enTabla = (int) tReceta.getValueAt(i, 0);
            if(enTabla == idmaterial){
                encuentra = true;
            }
        }
        return encuentra;
    }
    
    private int cargarID(int idInventario) throws Exception{
        int idmedida = create.select(INVENTARIO.IDUNIDAD)
                .from(INVENTARIO)
                .where(INVENTARIO.IDINVENTARIO.equal(idInventario))
                .fetchOne().getValue(INVENTARIO.IDUNIDAD);
        return idmedida;
    }
    
    private ComboBoxModel modelocbx(int idunidad){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Result<Record> result = create.select()
                .from(UNIDAD_MEDIDA)
                .where(
                        UNIDAD_MEDIDA.IDUNIDAD.equal(idunidad)
                                .or(UNIDAD_MEDIDA.UNIDADPADRE.equal(idunidad))
                                .or(UNIDAD_MEDIDA.IDUNIDAD.equal(
                                        create.select(UNIDAD_MEDIDA.UNIDADPADRE)
                                                .from(UNIDAD_MEDIDA)
                                                .where(UNIDAD_MEDIDA.IDUNIDAD.equal(idunidad))
                                                .fetchOne().getValue(UNIDAD_MEDIDA.UNIDADPADRE)
                                ))
                                .or(UNIDAD_MEDIDA.UNIDADPADRE.equal(
                                        create.select(UNIDAD_MEDIDA.UNIDADPADRE)
                                                .from(UNIDAD_MEDIDA)
                                                .where(UNIDAD_MEDIDA.IDUNIDAD.equal(idunidad))
                                                .fetchOne().getValue(UNIDAD_MEDIDA.UNIDADPADRE)))
                )
                .fetch();
        for (Record r: result){
            modelo.addElement(new Unidad(
                    r.getValue(UNIDAD_MEDIDA.IDUNIDAD),
                    r.getValue(UNIDAD_MEDIDA.DETALLE),
                    r.getValue(UNIDAD_MEDIDA.EQUIVALENCIA)
            ));
        }
        return modelo;
    }
    
    private ComboBoxModel modeloFinaliza(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("DISEÑO");
        modelo.addElement("PRODUCCION");
        return modelo;
    }
    
    private double obtenerCostoAdmin(){
        double sumatoria = 0;
        int tiempo = (int) spTiempo.getValue();
        int hTrabajo = create.select(EMPRESA.HORASSEMANA)
                .from(EMPRESA)
                .fetchOne().getValue(EMPRESA.HORASSEMANA);
        int hMensuales = hTrabajo*4;
        int mMensuales = hMensuales*60;
        Result<Record1<BigDecimal>> result= create.select(GASTOS_EMPRESA.GASTO)
                .from(GASTOS_EMPRESA)
                .innerJoin(GASTOS).on(GASTOS_EMPRESA.IDGASTO.equal(GASTOS.IDGASTO))
                .where(GASTOS.APLICA.equal(true))
                .fetch();
        for (Record r : result) {
            BigDecimal costo = r.getValue(GASTOS_EMPRESA.GASTO);            
            double costoxmin = ((costo.doubleValue())/mMensuales)*tiempo;  
            sumatoria = sumatoria+costoxmin;
        }
        return sumatoria;
    }
    
    private double obtenerCostoInventario(){
        double sumatoria =0;
        if(tReceta.getRowCount()>0){
            for(int i=0; i<tReceta.getRowCount();i++){
                int idmaterial = (int) tReceta.getValueAt(i, 0);
                SpinnerNumberModel cantidad = (SpinnerNumberModel) tReceta.getValueAt(i, 3); 
                DefaultComboBoxModel un = (DefaultComboBoxModel) tReceta.getValueAt(i,4);
                Unidad u = (Unidad) un.getSelectedItem();
                //JOptionPane.showMessageDialog(null, u.getEquivalencia());
                double descargo = (double) cantidad.getValue();
                BigDecimal precio = new BigDecimal(transformarPrecio(idmaterial,u));
                sumatoria = sumatoria+((precio).doubleValue()*descargo);
            }
        }
        return sumatoria;
    } 
    
    private double transformarPrecio(int idmaterial, Unidad u){
       
        Record r = create
                .select(INVENTARIO.PRECIOCOMPRA, INVENTARIO.IDUNIDAD)
                .from(INVENTARIO)
                .where(INVENTARIO.IDINVENTARIO.equal(idmaterial))
                .fetchOne();
        
        BigDecimal precio = r.getValue(INVENTARIO.PRECIOCOMPRA);
        
        int unidadmedida = r.getValue(INVENTARIO.IDUNIDAD);
        
        Record medidas = create
                .select()
                .from(V_MEDIDAS)
                .where(V_MEDIDAS.IDUNIDAD.equal(unidadmedida))
                .fetchOne();
        double eqHijo = medidas.getValue(V_MEDIDAS.EQUIVALENCIA);
        double eqPadre = medidas.getValue(V_MEDIDAS.EQUIVALENCIAPADRE);
        
        double conversion = (u.getEquivalencia()*eqHijo)/eqPadre;
        
        double precioreal = conversion*precio.doubleValue();
        if(unidadmedida == u.getId()){
            return precio.doubleValue();
        }else{
            return precioreal;
        }        
    }
    
    public void calcularPrecioNormal(){
        double precioNormal = 0;
        double porcentajeNormal = 0;
        double porcentaje = (double) spGananciaNormal.getValue();
        porcentaje = porcentaje/100;
        porcentajeNormal = porcentaje * costosTotales;
        precioNormal = porcentajeNormal+costosTotales;
        spPrecioNormal.setValue(precioNormal);
    }
    
    public void calcularPrecioVIP(){
        double precioVIP = 0;
        double porcentajeVIP = 0;
        double porcentaje = (double) spGananciaVIP.getValue();
        porcentaje = porcentaje/100;
        porcentajeVIP = porcentaje * costosTotales;
        precioVIP = porcentajeVIP+costosTotales;
        spPrecioVIP.setValue(precioVIP);
    }
    
    public void calcularPrecioDist(){
        double precioDist = 0;
        double porcentajeDist = 0;
        double porcentaje = (double) spGananciaDist.getValue();
        porcentaje = porcentaje/100;
        porcentajeDist = porcentaje * costosTotales;
        precioDist = porcentajeDist+costosTotales;
        spPrecioDist.setValue(precioDist);
    }
    
    private void createScene(){
        bc.setTitle("Costos por Producto");
        xAxis.setLabel("Costo");
        yAxis.setLabel("Valor ($)");
        yAxis.setAutoRanging(false);
        Scene scene  = new Scene(bc,10,10);
        bc.setData(getChartData());
        bc.setStyle("-fx-background-color: rgb(255, 255, 250);");
        jfxPanel.setScene(scene);
    }   
    
    private ObservableList<XYChart.Series<String, Double>> getChartData() {  
        Number n = 65.00;
        Series<String, Double> aSeries = new Series<String, Double>();
        Series<String, Double> bSeries = new Series<String, Double>();
        aSeries.setName("Costo Administrativo");
        bSeries.setName("Costo Costo Inventario");
        String costoadm = String.format("%.2f", obtenerCostoAdmin());
        String costoInv = String.format("%.2f", obtenerCostoInventario());
        aSeries.getData().add(new XYChart.Data("$ " + costoadm, obtenerCostoAdmin()));
        bSeries.getData().add(new XYChart.Data("$ " + costoInv, obtenerCostoInventario()));
        if(obtenerCostoAdmin()>obtenerCostoInventario()){  
            yAxis.setUpperBound(Math.floor(obtenerCostoAdmin()+1));
        }else{
            yAxis.setUpperBound(Math.floor(obtenerCostoInventario()+1));
        }
        yAxis.setTickUnit(0.1);
        data2d.addAll(aSeries,bSeries); 
        costosTotales = obtenerCostoAdmin() + obtenerCostoInventario();
        lblCostosTotales.setText(String.format("%.2f",costosTotales));
        if(!chkPrecioManual.isSelected()){
            spPrecioNormal.setEnabled(false);
            spPrecioVIP.setEnabled(false);
            spPrecioDist.setEnabled(false);
            calcularPrecioNormal();
            calcularPrecioVIP();
            calcularPrecioDist();
        }
        return data2d;
        
    }
    
    private void setChartData(){ 
        if(obtenerCostoAdmin()>obtenerCostoInventario()){  
            yAxis.setUpperBound(Math.floor(obtenerCostoAdmin()+1));
        }else{
            yAxis.setUpperBound(Math.floor(obtenerCostoInventario()+1));
        }
        yAxis.setTickUnit(0.1);
        Platform.runLater(() -> {
            data2d.clear();
            XYChart.Series<String, Double> aSeries = new XYChart.Series<>();
            XYChart.Series<String, Double> bSeries = new XYChart.Series<>();
            aSeries.setName("Costo Administrativo");
            bSeries.setName("Costo Costo Inventario");
            String costoadm = String.format("%.2f", obtenerCostoAdmin());
            String costoInv = String.format("%.2f", obtenerCostoInventario());
            aSeries.getData().add(new XYChart.Data("$ " + costoadm, obtenerCostoAdmin()));
            bSeries.getData().add(new XYChart.Data("$ " + costoInv, obtenerCostoInventario()));
            data2d.addAll(aSeries,bSeries);
        });
        costosTotales = obtenerCostoAdmin() + obtenerCostoInventario();
        lblCostosTotales.setText(String.format("%.2f",costosTotales));
        if(!chkPrecioManual.isSelected()){
            spPrecioNormal.setEnabled(false);
            spPrecioVIP.setEnabled(false);
            spPrecioDist.setEnabled(false);
            calcularPrecioNormal();
            calcularPrecioVIP();
            calcularPrecioDist();
        }
    }        
    
    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

    private void iniciaTransaccion() {       
        try {
            database.getConexion().setAutoCommit(false);
            byte[] array = null;
            if(file!=null){
                array = ImageConverter.imageToByte(file);
            }
            cbxCategoria.setSelectedIndex(1);
            CategoriaProducto categoria = (CategoriaProducto) cbxCategoria.getSelectedItem();
            this.idproducto = create.insertInto(PRODUCTO)
                    .set(PRODUCTO.CODIGO,lblCodigo.getText())
                    .set(PRODUCTO.NOMBRE,txtNombre.getText())
                    .set(PRODUCTO.DETALLE,txtDetalle.getText())
                    .set(PRODUCTO.COLOR, txtColor.getText())
                    .set(PRODUCTO.IMAGEN,array)
                    .set(PRODUCTO.IDCATEGORIA,categoria.getId())
                    .set(PRODUCTO.TIEMPOFABRICA,(int) spTiempo.getValue())
                    .set(PRODUCTO.TERMINA,(String) cbxTermina.getSelectedItem())
                    .returning(PRODUCTO.IDPRODUCTO).fetchOne().getValue(PRODUCTO.IDPRODUCTO);
            cbxCategoria.setSelectedIndex(0);
            ISINICIADA=true;
            System.out.println("INICIANDO TRANSACCION"); 
        } catch (SQLException | IOException ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private void editarTransaccion() {
        try {
            database.getConexion().setAutoCommit(false);
            ISINICIADA = true;
        } catch (SQLException ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarFotoNoImage() {
        file = new File("Reportes\\noimage.jpg");
            ImageIcon image = new ImageIcon(file.getAbsolutePath());
            Rectangle rect = lblFoto.getBounds();
            Image scaledImage = image.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
            image = new ImageIcon(scaledImage);
            lblFoto.setIcon(image);
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getName());
    }

    private void editarCodigoProducto() throws Exception{
        create.update(PRODUCTO)
                .set(PRODUCTO.CODIGO,lblCodigo.getText())
                .where(PRODUCTO.CODIGO.equal(CODIGOPRODUCTO))
                .execute();
        CODIGOPRODUCTO=lblCodigo.getText();
    }

    private void nuevoTamanio() throws Exception{
        create.insertInto(TAMANIO)
                .set(TAMANIO.IDPRODUCTO,this.idproducto)
                .set(TAMANIO.TAMANIO_,txtTamanio.getText())
                .execute();
    }
    
    private void editarTamanio(int idtamanio)throws Exception{
        create.update(TAMANIO)
                .set(TAMANIO.TAMANIO_,txtTamanio.getText())
                .where(TAMANIO.IDTAMANIO.equal(idtamanio))
                .execute();
    }

    private void editarProducto() throws IOException {
        byte[] array = null;
        CategoriaProducto categoria = (CategoriaProducto) cbxCategoria.getSelectedItem();
        if(file!=null){
            array = ImageConverter.imageToByte(file);
            create.update(PRODUCTO)
                    .set(PRODUCTO.IMAGEN,array)
                    .where(PRODUCTO.IDPRODUCTO.equal(this.idproducto))
                    .execute();
        }   
        create.update(PRODUCTO)
                .set(PRODUCTO.CODIGO,lblCodigo.getText())
                .set(PRODUCTO.NOMBRE,txtNombre.getText())
                .set(PRODUCTO.DETALLE,txtDetalle.getText())
                .set(PRODUCTO.COLOR, txtColor.getText())                
                .set(PRODUCTO.IDCATEGORIA,categoria.getId())
                .set(PRODUCTO.TIEMPOFABRICA,(int) spTiempo.getValue())
                .set(PRODUCTO.TERMINA,(String) cbxTermina.getSelectedItem())
                .set(PRODUCTO.COSTOADMIN,new BigDecimal(obtenerCostoAdmin()))
                .set(PRODUCTO.COSTOINV,new BigDecimal(obtenerCostoInventario()))
                .where(PRODUCTO.IDPRODUCTO.equal(this.idproducto))
                .execute();
    }
    
    private void crearReceta() throws Exception{
        eliminarRecetaAnterior();
        for(int i = 0; i<tReceta.getRowCount(); i++){
            int idinventario = (int) tReceta.getValueAt(i, 0);
            SpinnerNumberModel cantidad = (SpinnerNumberModel) tReceta.getValueAt(i, 3); 
            double descargo = (double) cantidad.getValue();
            DefaultComboBoxModel un = (DefaultComboBoxModel) tReceta.getValueAt(i,4);
            Unidad u = (Unidad) un.getSelectedItem();
            DefaultComboBoxModel desc = (DefaultComboBoxModel) tReceta.getValueAt(i,5);
            String descontaren = desc.getSelectedItem().toString();
            create.insertInto(RECETA)
                    .set(RECETA.IDPRODUCTO,this.idproducto)
                    .set(RECETA.IDINVENTARIO,idinventario)
                    .set(RECETA.DESCARGO,descargo)
                    .set(RECETA.IDUNIDAD,u.getId())
                    .set(RECETA.DESCONTAREN,descontaren)
                    .execute();
        }
    }

    private void eliminarRecetaAnterior() throws Exception{
        create.deleteFrom(RECETA)
                .where(RECETA.IDPRODUCTO.equal(this.idproducto))
                .execute();
    }
    
    private void guardarPrecios() throws Exception{
        //eliminarPreciosAnteriores();
        BigDecimal precioNormal = new BigDecimal((double) spPrecioNormal.getValue());
        BigDecimal precioVIP = new BigDecimal((double) spPrecioVIP.getValue());
        BigDecimal precioDist = new BigDecimal((double) spPrecioDist.getValue());
        create.insertInto(PRECIOS)
                .set(PRECIOS.IDPRODUCTO,this.idproducto)
                .set(PRECIOS.IDCATEGORIA,1)
                .set(PRECIOS.PRECIO,precioNormal)
                .newRecord()
                .set(PRECIOS.IDPRODUCTO,this.idproducto)
                .set(PRECIOS.IDCATEGORIA,2)
                .set(PRECIOS.PRECIO,precioVIP)
                .newRecord()
                .set(PRECIOS.IDPRODUCTO,this.idproducto)
                .set(PRECIOS.IDCATEGORIA,3)
                .set(PRECIOS.PRECIO,precioDist)
                .execute();
    }
    
    private void editarPrecios() throws Exception{
        BigDecimal precioNormal = new BigDecimal((double) spPrecioNormal.getValue());
        BigDecimal precioVIP = new BigDecimal((double) spPrecioVIP.getValue());
        BigDecimal precioDist = new BigDecimal((double) spPrecioDist.getValue());
        create.update(PRECIOS)
                .set(PRECIOS.PRECIO,precioNormal)
                .where(PRECIOS.IDCATEGORIA.equal(1).and(PRECIOS.IDPRODUCTO.equal(this.idproducto))).execute();
        create.update(PRECIOS)
                .set(PRECIOS.PRECIO,precioVIP)
                .where(PRECIOS.IDCATEGORIA.equal(2).and(PRECIOS.IDPRODUCTO.equal(this.idproducto))).execute();
        create.update(PRECIOS)
                .set(PRECIOS.PRECIO,precioDist)
                .where(PRECIOS.IDCATEGORIA.equal(3).and(PRECIOS.IDPRODUCTO.equal(this.idproducto))).execute();
    }

    private void cargarForm(String codigo) {
        try {
            Record r = create.select()
                    .from(PRODUCTO)
                    .where(PRODUCTO.CODIGO.equal(codigo))
                    .fetchOne();
            txtNombre.setText(r.getValue(PRODUCTO.NOMBRE));
            txtDetalle.setText(r.getValue(PRODUCTO.DETALLE));
            for(int i=0; i<cbxCategoria.getItemCount(); i++){
                cbxCategoria.setSelectedIndex(i);
                CategoriaProducto cat = (CategoriaProducto) cbxCategoria.getSelectedItem();
                if(cat.getId() == r.getValue(PRODUCTO.IDCATEGORIA)){
                    break;            
                }
            }
            txtColor.setText(r.getValue(PRODUCTO.COLOR));
            cbxTermina.setSelectedItem(r.getValue(PRODUCTO.TERMINA));
            spTiempo.setValue(r.getValue(PRODUCTO.TIEMPOFABRICA));
            Image img = ImageConverter.byteToImage(r.getValue(PRODUCTO.IMAGEN));
            Rectangle rect = lblFoto.getBounds();
            Icon icon = new ImageIcon(img.getScaledInstance(250, 250, Image.SCALE_DEFAULT));
            lblFoto.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarTablaReceta(){
        for(int i=0; i<tReceta.getRowCount(); i++){
            dtmReceta.removeRow(i);
            i-=1;
        }
        
        SelectQuery<Record> query = create.selectQuery();
        query.addSelect(
                V_RECETA.IDINVENTARIO,
                V_RECETA.CODIGO,
                V_RECETA.NOMBRE,
                V_RECETA.DESCARGO,
                V_RECETA.IDUNIDAD,
                V_RECETA.DETALLE,
                V_RECETA.EQUIVALENCIA,
                V_RECETA.DESCONTAREN);
        query.addFrom(V_RECETA);
        query.addConditions(V_RECETA.IDPRODUCTO.equal(this.idproducto));
        Result<Record> result = query.fetch();
        for (Record r : result) {
            int idinventario = r.getValue(V_RECETA.IDINVENTARIO);
            double desc = r.getValue(V_RECETA.DESCARGO);
            DefaultComboBoxModel unidad = null;
            try {
                 unidad = (DefaultComboBoxModel) modelocbx(cargarID(idinventario));
                 //System.out.println();
                 Unidad u = new Unidad(r.getValue(V_RECETA.IDUNIDAD),r.getValue(V_RECETA.DETALLE),r.getValue(V_RECETA.EQUIVALENCIA));
                 unidad.setSelectedItem(u);
            } catch (Exception ex) {
                Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Object[] row = {
                    r.getValue(V_RECETA.IDINVENTARIO),
                    r.getValue(V_RECETA.CODIGO),
                    r.getValue(V_RECETA.NOMBRE),
                    new SpinnerNumberModel(desc,0, 999.9999, 0.5),
                    unidad,
                    modeloFinaliza() 
                };
                dtmReceta.addRow(row);
            } catch (Exception ex) {
                Logger.getLogger(DialogProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setChartData();
    }
    
    private void cargarPrecios(){
        SelectQuery<Record> query = create.selectQuery();        
        query.addFrom(PRECIOS);
        query.addConditions(PRECIOS.IDPRODUCTO.equal(this.idproducto));
        Result<Record> result = query.fetch();
        for (Record r : result) {
            switch(r.getValue(PRECIOS.IDCATEGORIA)){
                case 1:
                    spPrecioNormal.setValue(r.getValue(PRECIOS.PRECIO).doubleValue());
                    break;
                case 2:
                    spPrecioVIP.setValue(r.getValue(PRECIOS.PRECIO).doubleValue());
                    break;
                case 3:
                    spPrecioDist.setValue(r.getValue(PRECIOS.PRECIO).doubleValue());
                    break;
            }
        }
        chkPrecioManual.setSelected(true);
    }
    
   public class SpinnerEditor extends AbstractCellEditor implements TableCellEditor{
        protected JSpinner spinner;
        
        public SpinnerEditor() {
            spinner = new JSpinner();
            spinner.setUI(new SpinnerUI(colorBG,cBtnNormal));
            spinner.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent ce) {
                        setChartData();            
                }
            });
        }
        
        @Override
        public Object getCellEditorValue() {
            SpinnerModel sm = spinner.getModel();        
            return sm;
        }

       @Override
       public Component getTableCellEditorComponent(JTable jtable, Object value, boolean bln, int i, int i1) {
           spinner.setModel((SpinnerModel) value);
           spinner.setEditor(new JSpinner.NumberEditor(spinner, "0.0000"));
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
    
    private class ComboEditor extends AbstractCellEditor implements TableCellEditor{
        
        int idUnidad;
        protected JComboBox cbx;
        
        public ComboEditor(){
            cbx = new JComboBox();
            cbx.setUI(new ComboUI(colorBG,cBtnNormal));
            cbx.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    setChartData();
                }
            });
        }

        @Override
        public Object getCellEditorValue() {
            ComboBoxModel cm = cbx.getModel();
            return cm;
        }

        @Override
        public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
            cbx.setModel((ComboBoxModel) o);
            return cbx;
        }
    }
    
    private class ComboRenderer extends JComboBox implements TableCellRenderer{
        
        public ComboRenderer(){
            setUI(new ComboUI(colorBG,cBtnNormal));
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            setModel((ComboBoxModel) o);
            return this;
        }
        
    }

}