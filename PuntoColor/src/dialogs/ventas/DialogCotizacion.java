package dialogs.ventas;

import clases.Mensajes;
import clases.PrecioProducto;
import clases.TamanioProducto;
import com.sun.glass.events.KeyEvent;
import design.button.ButtonUI;
import design.combobox.ComboUI;
import design.spinner.SpinnerUI;
import design.tabla.CellRenderer;
import design.tabla.HeaderCellRenderer;
import design.textfield.TextFieldUI;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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
import javax.swing.text.JTextComponent;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;

import static db.clases.Tables.COTIZACION;
import static db.clases.Tables.DETALLE_COTIZACION;
import static db.clases.Tables.PRECIOS;
import static db.clases.Tables.TAMANIO;
import static db.clases.Tables.V_CLIENTES;
import static db.clases.Tables.V_PRECIOS;
import static db.clases.Tables.V_PRODUCTOS;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import static org.jooq.impl.DSL.count;
import static puntocolor.Principal.cBtnNormal;
import static puntocolor.Principal.cBtnOver;
import static puntocolor.Principal.cBtnPress;
import static puntocolor.Principal.colorBG;
import static puntocolor.Principal.colorTexto;
import static puntocolor.Principal.colorUI;
import static puntocolor.Principal.database;
import static puntocolor.Principal.mensajero;
import static puntocolor.Principal.ue;

/* @author JL Desk */
public class DialogCotizacion extends javax.swing.JDialog {

    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);

    private boolean guardado = false;

    DefaultTableModel dtmDetalleFactura;
    DefaultTableModel dtmProductos;
    DefaultTableModel dtmClientes;

    DefaultComboBoxModel dcmMedida = new DefaultComboBoxModel();
    DefaultComboBoxModel dcmUnidad = new DefaultComboBoxModel();
    DefaultComboBoxModel dcmCategoria = new DefaultComboBoxModel();

    File file;

    boolean nuevo = true;
    boolean hayCat = true;

    String CODIGOP;
    String CATEGORIAP;

    JPanel[] panels;
    int position = 0;

    GridBagConstraints gbcWizard = new GridBagConstraints();

    String TRANSACCION = "0000";
    boolean ISINICIADA = false;

    int idcotizacion;

    boolean avanzar = false;

    public DialogCotizacion(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);
        this.setTitle(titulo);
        initComponents();
        this.setLocationRelativeTo(null);
        /**/
        dtmClientes = (DefaultTableModel) tClientes.getModel();
        dtmProductos = (DefaultTableModel) tProductos.getModel();
        dtmDetalleFactura = (DefaultTableModel) tDetalleFactura.getModel();
        dtmDetalleFactura.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column == 7) {
                    TableModel model = (TableModel) e.getSource();
                    String columnName = model.getColumnName(column);
                    Boolean checked = (Boolean) model.getValueAt(row, column);
                    if (checked) {
                        System.out.println(e.getFirstRow() + " row: " + true);
                        SpinnerEditor spinner1 = (SpinnerEditor) tDetalleFactura.getCellEditor(row, 2);
                        spinner1.spinner.setEnabled(true);
                        SpinnerEditor spinner2 = (SpinnerEditor) tDetalleFactura.getCellEditor(row, 3);
                        spinner2.spinner.setEnabled(true);
                    } else {
                        System.out.println(columnName + ": " + false);
                        SpinnerEditor spinner = (SpinnerEditor) tDetalleFactura.getCellEditor(row, 2);
                        spinner.spinner.setEnabled(false);
                        SpinnerNumberModel modelo1 = (SpinnerNumberModel) model.getValueAt(row, 2);
                        modelo1.setValue(0);
                        SpinnerNumberModel modelo2 = (SpinnerNumberModel) model.getValueAt(row, 3);
                        modelo2.setValue(0);
                    }
                }
            }
        });
        tDetalleFactura.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getLastIndex() == tDetalleFactura.getSelectedRow()) {
                    if ((boolean) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 7)) {
                        SpinnerEditor spinner1 = (SpinnerEditor) tDetalleFactura.getCellEditor(tDetalleFactura.getSelectedRow(), 2);
                        SpinnerEditor spinner2 = (SpinnerEditor) tDetalleFactura.getCellEditor(tDetalleFactura.getSelectedRow(), 3);
                        spinner1.spinner.setEnabled(true);
                        spinner2.spinner.setEnabled(true);
                    } else {
                        SpinnerEditor spinner1 = (SpinnerEditor) tDetalleFactura.getCellEditor(tDetalleFactura.getSelectedRow(), 2);
                        SpinnerEditor spinner2 = (SpinnerEditor) tDetalleFactura.getCellEditor(tDetalleFactura.getSelectedRow(), 3);
                        spinner1.spinner.setEnabled(false);
                        spinner2.spinner.setEnabled(false);
                    }
                }

            }
        });
        /**/
        gbcWizard.fill = java.awt.GridBagConstraints.BOTH;
        gbcWizard.anchor = java.awt.GridBagConstraints.CENTER;
        gbcWizard.weightx = 1.0;
        gbcWizard.weighty = 1.0;
        gbcWizard.insets = new Insets(10, 10, 10, 10);
        panels = new JPanel[]{panel1, panel2, panel3};
        seleccionPanel();
        dibujarTablas();
        cargarTablaClientes();
        cargarTablaProductos();
        fechaValidacion();
        iniciaTransaccion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popProductos = new javax.swing.JPopupMenu();
        itemVerDetalleProducto = new javax.swing.JMenuItem();
        itemAgregarProducto = new javax.swing.JMenuItem();
        popDetallePedido = new javax.swing.JPopupMenu();
        itemQuitarMaterial = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new com.mrlonee.swing.animation.AnimatedPanel();
        toolBarTabla2 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        cbxFiltro = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtFiltro = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        cbxTipoCliente = new javax.swing.JComboBox<>();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNumeroOrden = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        lblCliente1 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tClientes = new javax.swing.JTable();
        panel2 = new com.mrlonee.swing.animation.AnimatedPanel();
        toolBarTabla3 = new javax.swing.JToolBar();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        cbxFiltroProducto = new javax.swing.JComboBox<>();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        txtFiltroProducto = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        jPanel14 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tProductos = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDetalleFactura = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        panel3 = new com.mrlonee.swing.animation.AnimatedPanel();
        toolBarTabla4 = new javax.swing.JToolBar();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        jPanel18 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtOrden3 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        spValidaPor = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        lblVencimiento = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        pMov = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        itemVerDetalleProducto.setText("Ver Detalle de Producto");
        itemVerDetalleProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerDetalleProductoActionPerformed(evt);
            }
        });
        popProductos.add(itemVerDetalleProducto);

        itemAgregarProducto.setText("Agregar a Detalle");
        itemAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarProductoActionPerformed(evt);
            }
        });
        popProductos.add(itemAgregarProducto);

        itemQuitarMaterial.setText("Eliminar de Detalle");
        itemQuitarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQuitarMaterialActionPerformed(evt);
            }
        });
        popDetallePedido.add(itemQuitarMaterial);

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
        toolBarTabla2.add(cbxFiltro);
        cbxFiltro.setUI(new ComboUI(colorBG,cBtnNormal));
        toolBarTabla2.add(jSeparator7);

        txtFiltro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtFiltro.setMaximumSize(new java.awt.Dimension(150, 40));
        txtFiltro.setMinimumSize(new java.awt.Dimension(150, 40));
        txtFiltro.setPreferredSize(new java.awt.Dimension(150, 40));
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });
        toolBarTabla2.add(txtFiltro);
        txtFiltro.setUI(new TextFieldUI(
            "Buscar...", colorUI, cBtnNormal, colorBG
        ));
        toolBarTabla2.add(jSeparator8);

        cbxTipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo Cliente", "Consumidor Final", "Crédito Fiscal" }));
        cbxTipoCliente.setMaximumSize(new java.awt.Dimension(150, 40));
        cbxTipoCliente.setMinimumSize(new java.awt.Dimension(150, 40));
        cbxTipoCliente.setPreferredSize(new java.awt.Dimension(150, 40));
        cbxTipoCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoClienteItemStateChanged(evt);
            }
        });
        toolBarTabla2.add(cbxTipoCliente);
        cbxTipoCliente.setUI(new ComboUI(colorBG,cBtnNormal));
        toolBarTabla2.add(jSeparator10);

        btnNuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNuevo.setForeground(colorTexto);
        btnNuevo.setText("Nuevo Cliente");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        toolBarTabla2.add(btnNuevo);
        btnNuevo.setUI(new ButtonUI(
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

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setText("Orden y Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel9.add(jLabel11, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel16.setText("Cotización #:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel9.add(jLabel16, gridBagConstraints);

        txtNumeroOrden.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtNumeroOrden.setMinimumSize(new java.awt.Dimension(91, 30));
        txtNumeroOrden.setPreferredSize(new java.awt.Dimension(91, 30));
        txtNumeroOrden.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroOrdenFocusLost(evt);
            }
        });
        txtNumeroOrden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroOrdenKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroOrdenKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel9.add(txtNumeroOrden, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel1.add(jPanel9, gridBagConstraints);

        jPanel12.setMinimumSize(new java.awt.Dimension(300, 17));
        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.GridBagLayout());

        lblCliente1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCliente1.setText("Fecha:");
        lblCliente1.setMaximumSize(new java.awt.Dimension(0, 30));
        lblCliente1.setMinimumSize(new java.awt.Dimension(0, 30));
        lblCliente1.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 5, 10);
        jPanel12.add(lblCliente1, gridBagConstraints);

        txtFecha.setDate(new Date());
        txtFecha.setDateFormatString("dd-MM-yyyy");
        txtFecha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtFecha.setMinimumSize(new java.awt.Dimension(150, 30));
        txtFecha.setPreferredSize(new java.awt.Dimension(150, 30));
        txtFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFechaPropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 15, 10);
        jPanel12.add(txtFecha, gridBagConstraints);

        lblCliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCliente.setText("Cliente:");
        lblCliente.setMaximumSize(new java.awt.Dimension(0, 30));
        lblCliente.setMinimumSize(new java.awt.Dimension(0, 30));
        lblCliente.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 5, 10);
        jPanel12.add(lblCliente, gridBagConstraints);

        txtCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCliente.setMaximumSize(new java.awt.Dimension(0, 30));
        txtCliente.setMinimumSize(new java.awt.Dimension(0, 30));
        txtCliente.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 15, 10);
        jPanel12.add(txtCliente, gridBagConstraints);

        lblDireccion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblDireccion.setText("Dirección:");
        lblDireccion.setMaximumSize(new java.awt.Dimension(0, 30));
        lblDireccion.setMinimumSize(new java.awt.Dimension(0, 30));
        lblDireccion.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 5, 10);
        jPanel12.add(lblDireccion, gridBagConstraints);

        txtDireccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtDireccion.setMaximumSize(new java.awt.Dimension(0, 30));
        txtDireccion.setMinimumSize(new java.awt.Dimension(0, 30));
        txtDireccion.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 15, 10);
        jPanel12.add(txtDireccion, gridBagConstraints);

        lblTelefono.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTelefono.setText("Teléfono:");
        lblTelefono.setMaximumSize(new java.awt.Dimension(0, 30));
        lblTelefono.setMinimumSize(new java.awt.Dimension(0, 30));
        lblTelefono.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 5, 10);
        jPanel12.add(lblTelefono, gridBagConstraints);

        txtTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTelefono.setMaximumSize(new java.awt.Dimension(0, 30));
        txtTelefono.setMinimumSize(new java.awt.Dimension(0, 30));
        txtTelefono.setPreferredSize(new java.awt.Dimension(0, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 15, 10);
        jPanel12.add(txtTelefono, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel1.add(jPanel12, gridBagConstraints);

        jPanel13.setLayout(new java.awt.GridBagLayout());

        tClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "idcliente", "Nombre", "Dirección", "Teléfono", "Tipo", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tClientes.setRowHeight(30);
        tClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tClientesMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tClientes);
        if (tClientes.getColumnModel().getColumnCount() > 0) {
            tClientes.getColumnModel().getColumn(0).setMinWidth(0);
            tClientes.getColumnModel().getColumn(0).setPreferredWidth(0);
            tClientes.getColumnModel().getColumn(0).setMaxWidth(0);
            tClientes.getColumnModel().getColumn(1).setResizable(false);
            tClientes.getColumnModel().getColumn(2).setResizable(false);
            tClientes.getColumnModel().getColumn(3).setMinWidth(70);
            tClientes.getColumnModel().getColumn(3).setPreferredWidth(70);
            tClientes.getColumnModel().getColumn(3).setMaxWidth(70);
            tClientes.getColumnModel().getColumn(4).setMinWidth(130);
            tClientes.getColumnModel().getColumn(4).setPreferredWidth(130);
            tClientes.getColumnModel().getColumn(4).setMaxWidth(130);
            tClientes.getColumnModel().getColumn(5).setMinWidth(80);
            tClientes.getColumnModel().getColumn(5).setPreferredWidth(80);
            tClientes.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel13.add(jScrollPane4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel1.add(jPanel13, gridBagConstraints);

        panel2.setBorder(new javax.swing.border.LineBorder(colorUI, 3, true));
        panel2.setAnimationType(com.mrlonee.swing.animation.AnimatedPanel.AnimationType.SlideAnimationFromRight);
        panel2.setLayout(new java.awt.GridBagLayout());

        toolBarTabla3.setBackground(colorUI);
        toolBarTabla3.setBorder(null);
        toolBarTabla3.setFloatable(false);
        toolBarTabla3.setRollover(true);
        toolBarTabla3.setMaximumSize(new java.awt.Dimension(100, 60));
        toolBarTabla3.setMinimumSize(new java.awt.Dimension(100, 60));
        toolBarTabla3.setPreferredSize(new java.awt.Dimension(100, 60));
        toolBarTabla3.add(jSeparator11);

        cbxFiltroProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxFiltroProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar todos", "Codigo", "Nombre", "Categoria" }));
        cbxFiltroProducto.setBorder(javax.swing.BorderFactory.createLineBorder(colorUI, 2));
        cbxFiltroProducto.setMaximumSize(new java.awt.Dimension(150, 40));
        cbxFiltroProducto.setMinimumSize(new java.awt.Dimension(150, 40));
        cbxFiltroProducto.setPreferredSize(new java.awt.Dimension(150, 40));
        cbxFiltroProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFiltroProductoItemStateChanged(evt);
            }
        });
        toolBarTabla3.add(cbxFiltroProducto);
        cbxFiltroProducto.setUI(new ComboUI(colorBG,cBtnNormal));
        toolBarTabla3.add(jSeparator12);

        txtFiltroProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtFiltroProducto.setMaximumSize(new java.awt.Dimension(150, 40));
        txtFiltroProducto.setMinimumSize(new java.awt.Dimension(150, 40));
        txtFiltroProducto.setPreferredSize(new java.awt.Dimension(150, 40));
        txtFiltroProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroProductoKeyReleased(evt);
            }
        });
        toolBarTabla3.add(txtFiltroProducto);
        txtFiltro.setUI(new TextFieldUI(
            "Buscar...", colorUI, cBtnNormal, colorBG
        ));
        toolBarTabla3.add(jSeparator13);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel2.add(toolBarTabla3, gridBagConstraints);

        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.GridBagLayout());

        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setText("Detalle de Pedido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel14.add(jLabel17, gridBagConstraints);

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

        tProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Codigo", "Nombre", "Color", "Categoria", "T. Fab."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tProductos.setComponentPopupMenu(popProductos);
        tProductos.setRowHeight(30);
        tProductos.getTableHeader().setReorderingAllowed(false);
        tProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tProductosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tProductos);
        if (tProductos.getColumnModel().getColumnCount() > 0) {
            tProductos.getColumnModel().getColumn(0).setMinWidth(0);
            tProductos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tProductos.getColumnModel().getColumn(0).setMaxWidth(0);
            tProductos.getColumnModel().getColumn(1).setMinWidth(60);
            tProductos.getColumnModel().getColumn(1).setPreferredWidth(60);
            tProductos.getColumnModel().getColumn(1).setMaxWidth(60);
            tProductos.getColumnModel().getColumn(3).setMinWidth(80);
            tProductos.getColumnModel().getColumn(3).setPreferredWidth(80);
            tProductos.getColumnModel().getColumn(3).setMaxWidth(80);
            tProductos.getColumnModel().getColumn(4).setMinWidth(75);
            tProductos.getColumnModel().getColumn(4).setPreferredWidth(75);
            tProductos.getColumnModel().getColumn(4).setMaxWidth(75);
            tProductos.getColumnModel().getColumn(5).setMinWidth(50);
            tProductos.getColumnModel().getColumn(5).setPreferredWidth(50);
            tProductos.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel2.add(jPanel15, gridBagConstraints);

        jPanel16.setOpaque(false);
        jPanel16.setLayout(new java.awt.GridBagLayout());

        tDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Producto", "Ancho", "Alto", "Cantidad", "Tamaño", "Precio", "Editar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tDetalleFactura.setComponentPopupMenu(popDetallePedido);
        tDetalleFactura.setRowHeight(30);
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
            tDetalleFactura.getColumnModel().getColumn(2).setMinWidth(75);
            tDetalleFactura.getColumnModel().getColumn(2).setPreferredWidth(75);
            tDetalleFactura.getColumnModel().getColumn(2).setMaxWidth(75);
            tDetalleFactura.getColumnModel().getColumn(2).setCellEditor(new SpinnerEditor());
            tDetalleFactura.getColumnModel().getColumn(2).setCellRenderer(new SpinnerRenderer());
            tDetalleFactura.getColumnModel().getColumn(3).setMinWidth(75);
            tDetalleFactura.getColumnModel().getColumn(3).setPreferredWidth(75);
            tDetalleFactura.getColumnModel().getColumn(3).setMaxWidth(75);
            tDetalleFactura.getColumnModel().getColumn(3).setCellEditor(new SpinnerEditor());
            tDetalleFactura.getColumnModel().getColumn(3).setCellRenderer(new SpinnerRenderer());
            tDetalleFactura.getColumnModel().getColumn(4).setMinWidth(90);
            tDetalleFactura.getColumnModel().getColumn(4).setPreferredWidth(90);
            tDetalleFactura.getColumnModel().getColumn(4).setMaxWidth(90);
            tDetalleFactura.getColumnModel().getColumn(4).setCellEditor(new SpinnerEditor());
            tDetalleFactura.getColumnModel().getColumn(4).setCellRenderer(new SpinnerRenderer());
            tDetalleFactura.getColumnModel().getColumn(5).setMinWidth(110);
            tDetalleFactura.getColumnModel().getColumn(5).setPreferredWidth(110);
            tDetalleFactura.getColumnModel().getColumn(5).setMaxWidth(100);
            tDetalleFactura.getColumnModel().getColumn(5).setCellEditor(new ComboEditor());
            tDetalleFactura.getColumnModel().getColumn(5).setCellRenderer(new ComboRenderer());
            tDetalleFactura.getColumnModel().getColumn(6).setMinWidth(90);
            tDetalleFactura.getColumnModel().getColumn(6).setPreferredWidth(90);
            tDetalleFactura.getColumnModel().getColumn(6).setMaxWidth(90);
            tDetalleFactura.getColumnModel().getColumn(6).setCellEditor(new ComboEditor());
            tDetalleFactura.getColumnModel().getColumn(6).setCellRenderer(new ComboRenderer());
            tDetalleFactura.getColumnModel().getColumn(7).setMinWidth(50);
            tDetalleFactura.getColumnModel().getColumn(7).setPreferredWidth(50);
            tDetalleFactura.getColumnModel().getColumn(7).setMaxWidth(50);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel16.add(jScrollPane1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel16.add(jLabel1, gridBagConstraints);

        lblTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTotal.setText("0.00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel16.add(lblTotal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel2.add(jPanel16, gridBagConstraints);

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
        toolBarTabla4.add(jSeparator16);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel3.add(toolBarTabla4, gridBagConstraints);

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.GridBagLayout());

        jLabel21.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel21.setText("Orden #:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel18.add(jLabel21, gridBagConstraints);

        txtOrden3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtOrden3.setText(TRANSACCION);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel18.add(txtOrden3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panel3.add(jPanel18, gridBagConstraints);

        jPanel19.setOpaque(false);
        jPanel19.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(colorUI, 2, true), "Validación", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 18), colorUI)); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Válida por:");
        jLabel4.setMaximumSize(new java.awt.Dimension(150, 30));
        jLabel4.setMinimumSize(new java.awt.Dimension(150, 30));
        jLabel4.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jPanel1.add(jLabel4, gridBagConstraints);

        spValidaPor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        spValidaPor.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spValidaPor.setMaximumSize(new java.awt.Dimension(150, 30));
        spValidaPor.setMinimumSize(new java.awt.Dimension(150, 30));
        spValidaPor.setPreferredSize(new java.awt.Dimension(150, 50));
        spValidaPor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spValidaPorStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 20);
        jPanel1.add(spValidaPor, gridBagConstraints);
        spValidaPor.setUI(new SpinnerUI(colorBG,colorUI));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Vence:");
        jLabel5.setMaximumSize(new java.awt.Dimension(150, 30));
        jLabel5.setMinimumSize(new java.awt.Dimension(150, 30));
        jLabel5.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jPanel1.add(jLabel5, gridBagConstraints);

        lblVencimiento.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblVencimiento.setText("Vence:");
        lblVencimiento.setMaximumSize(new java.awt.Dimension(150, 30));
        lblVencimiento.setMinimumSize(new java.awt.Dimension(150, 30));
        lblVencimiento.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        jPanel1.add(lblVencimiento, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 25, 10, 25);
        jPanel19.add(jPanel1, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1475675469_product-sales-report.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel19.add(jLabel2, gridBagConstraints);

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
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setPreferredSize(new java.awt.Dimension(1200, 600));
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

    private void tProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tProductosMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tProductos.rowAtPoint(point);
        tProductos.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tProductosMousePressed

    private void itemAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarProductoActionPerformed
        // TODO add your handling code here:
        if (isOnDetalle((int) tProductos.getValueAt(tProductos.getSelectedRow(), 0))) {
            JOptionPane.showMessageDialog(null, "Ya esta agregado el producto");
        } else {
            pasarProductoADetalle();
        }

    }//GEN-LAST:event_itemAgregarProductoActionPerformed

    private void tDetalleFacturaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDetalleFacturaMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tDetalleFactura.rowAtPoint(point);
        tDetalleFactura.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tDetalleFacturaMousePressed

    private void itemQuitarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQuitarMaterialActionPerformed
        // TODO add your handling code here:
        dtmDetalleFactura.removeRow(tDetalleFactura.getSelectedRow());
    }//GEN-LAST:event_itemQuitarMaterialActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        if (position != (panels.length - 1)) {
            verificarPosition();
            if (avanzar) {
                position++;
                seleccionPanel();
            }
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        if (position > 0) {
            position--;
            seleccionPanel();
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        // TODO add your handling code here:
        cargarTablaClientes();
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        cargarTablaClientes();
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        DialogCliente dialog = new DialogCliente(new javax.swing.JFrame(), true, "Nuevo Pedido");
        dialog.setVisible(true);
        if (dialog.isGuardado()) {
            cargarTablaClientes();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cbxTipoClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoClienteItemStateChanged
        // TODO add your handling code here:
        cargarTablaClientes();
    }//GEN-LAST:event_cbxTipoClienteItemStateChanged

    private void tClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tClientesMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int currentRow = tClientes.rowAtPoint(point);
        tClientes.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_tClientesMousePressed

    private void txtNumeroOrdenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroOrdenKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroOrdenKeyReleased

    private void cbxFiltroProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroProductoItemStateChanged
        // TODO add your handling code here:
        cargarTablaProductos();
    }//GEN-LAST:event_cbxFiltroProductoItemStateChanged

    private void txtFiltroProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroProductoKeyReleased
        // TODO add your handling code here:
        cargarTablaProductos();
    }//GEN-LAST:event_txtFiltroProductoKeyReleased

    private void itemVerDetalleProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerDetalleProductoActionPerformed
        // TODO add your handling code here:
        DialogDetalleProducto dialog = new DialogDetalleProducto(new javax.swing.JFrame(),
                true,
                (int) tProductos.getValueAt(tProductos.getSelectedRow(), 0));
        dialog.setVisible(true);
    }//GEN-LAST:event_itemVerDetalleProductoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            database.getConexion().rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DialogCotizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void spValidaPorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spValidaPorStateChanged
        // TODO add your handling code here:
        fechaValidacion();
    }//GEN-LAST:event_spValidaPorStateChanged

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        try {
            guardarDias();
            database.getConexion().commit();
            //Reportes.Reportes.cotizacion(this.idcotizacion);
            mensajero.enviarMensaje(ue.getNombre() + " Ha registrado nueva cotización #" + TRANSACCION, DesktopNotify.SUCCESS, 1);
            this.setGuardado(true);
        } catch (SQLException ex) {
            Logger.getLogger(DialogCotizacion.class.getName()).log(Level.SEVERE, null, ex);
            this.setGuardado(false);
        }
        dispose();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            System.out.println("CERRANDO TRANSACCION ROLLBACK");
            database.getConexion().rollback();
            database.getConexion().setAutoCommit(true);
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

    private void txtNumeroOrdenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroOrdenFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroOrdenFocusLost

    private void txtNumeroOrdenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroOrdenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroOrdenKeyPressed

    private void txtFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFechaPropertyChange
        // TODO add your handling code here:
        fechaValidacion();
    }//GEN-LAST:event_txtFechaPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JComboBox<String> cbxFiltroProducto;
    private javax.swing.JComboBox<String> cbxTipoCliente;
    private javax.swing.JMenuItem itemAgregarProducto;
    private javax.swing.JMenuItem itemQuitarMaterial;
    private javax.swing.JMenuItem itemVerDetalleProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCliente1;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVencimiento;
    private javax.swing.JPanel pMov;
    private com.mrlonee.swing.animation.AnimatedPanel panel1;
    private com.mrlonee.swing.animation.AnimatedPanel panel2;
    private com.mrlonee.swing.animation.AnimatedPanel panel3;
    private javax.swing.JPopupMenu popDetallePedido;
    private javax.swing.JPopupMenu popProductos;
    private javax.swing.JSpinner spValidaPor;
    private javax.swing.JTable tClientes;
    private static javax.swing.JTable tDetalleFactura;
    private javax.swing.JTable tProductos;
    private javax.swing.JToolBar toolBarTabla2;
    private javax.swing.JToolBar toolBarTabla3;
    private javax.swing.JToolBar toolBarTabla4;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtDireccion;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtFiltroProducto;
    private javax.swing.JTextField txtNumeroOrden;
    private javax.swing.JLabel txtOrden3;
    private javax.swing.JLabel txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void seleccionPanel() {
        for (int i = 0; i < panels.length; i++) {
            if (i == position) {
                pMov.removeAll();
                pMov.repaint();
                pMov.add(panels[i], gbcWizard);
                panels[i].setVisible(true);
            } else {
                panels[i].setVisible(false);
            }
            if (position == 0) {
                btnAnterior.setEnabled(false);
                btnFinalizar.setEnabled(false);
            }
            if (position == 1) {
                btnAnterior.setEnabled(true);
                btnSiguiente.setEnabled(true);
                btnFinalizar.setEnabled(false);
            }
            if (position == 2) {
                btnSiguiente.setEnabled(false);
                btnFinalizar.setEnabled(true);
            }
        }
    }

    private void cargarTablaClientes() {
        for (int i = 0; i < tClientes.getRowCount(); i++) {
            dtmClientes.removeRow(i);
            i -= 1;
        }
        SelectQuery<Record> query = create.selectQuery();
        query.addSelect(V_CLIENTES.IDCLIENTE,
                V_CLIENTES.NOMBRE,
                V_CLIENTES.DIRECCION,
                V_CLIENTES.TELEFONO,
                V_CLIENTES.TIPO,
                V_CLIENTES.CATEGORIA);
        query.addFrom(V_CLIENTES);
        Condition baja = V_CLIENTES.BAJA.equal(false);
        Condition filtro;
        switch (cbxFiltro.getSelectedIndex()) {
            case 1:
                filtro = V_CLIENTES.NOMBRE.likeIgnoreCase("%" + txtFiltro.getText() + "%");
                break;
            case 2:
                filtro = V_CLIENTES.DIRECCION.likeIgnoreCase("%" + txtFiltro.getText() + "%");
                break;
            case 3:
                filtro = V_CLIENTES.TELEFONO.likeIgnoreCase("%" + txtFiltro.getText() + "%");
                break;
            default:
                filtro = V_CLIENTES.NOMBRE.likeIgnoreCase("%" + txtFiltro.getText() + "%")
                        .or(V_CLIENTES.DIRECCION.likeIgnoreCase("%" + txtFiltro.getText() + "%"))
                        .or(V_CLIENTES.TELEFONO.likeIgnoreCase("%" + txtFiltro.getText() + "%"));
                break;
        }
        Condition tipo;
        switch (cbxTipoCliente.getSelectedIndex()) {
            case 1:
                tipo = V_CLIENTES.TIPO.equalIgnoreCase("CONSUMIDOR FINAL");
                break;
            case 2:
                tipo = V_CLIENTES.TIPO.equalIgnoreCase("CREDITO FISCAL");
                break;
            default:
                tipo = V_CLIENTES.TIPO.notEqual("");
                break;
        }
        query.addConditions(baja.and(filtro).and(tipo));
        query.addOrderBy(V_CLIENTES.NOMBRE.asc());
        Result<Record> result = query.fetch();
        result.stream().forEach((r) -> {
            dtmClientes.addRow(r.intoArray());
        });

        if (tClientes.getRowCount() > 0) {
            tClientes.changeSelection(0, 1, false, false);
            seleccionarCliente();
        }
    }

    private void cargarTablaProductos() {
        for (int i = 0; i < tProductos.getRowCount(); i++) {
            dtmProductos.removeRow(i);
            i -= 1;
        }
        SelectQuery<Record> query = create.selectQuery();
        query.addSelect(
                V_PRODUCTOS.IDPRODUCTO,
                V_PRODUCTOS.CODIGO,
                V_PRODUCTOS.NOMBRE,
                V_PRODUCTOS.COLOR,
                V_PRODUCTOS.CATEGORIA,
                V_PRODUCTOS.TIEMPOFABRICA);
        query.addFrom(V_PRODUCTOS);
        Condition filtro;
        switch (cbxFiltroProducto.getSelectedIndex()) {
            case 1:
                filtro = V_PRODUCTOS.CODIGO.likeIgnoreCase("%" + txtFiltroProducto.getText() + "%");
                break;
            case 2:
                filtro = V_PRODUCTOS.NOMBRE.likeIgnoreCase("%" + txtFiltroProducto.getText() + "%");
                break;
            case 3:
                filtro = V_PRODUCTOS.CATEGORIA.likeIgnoreCase("%" + txtFiltroProducto.getText() + "%");
                break;
            default:
                filtro = V_PRODUCTOS.CATEGORIA.likeIgnoreCase("%" + txtFiltroProducto.getText() + "%")
                        .or(V_PRODUCTOS.NOMBRE.likeIgnoreCase("%" + txtFiltroProducto.getText() + "%"))
                        .or(V_PRODUCTOS.CODIGO.likeIgnoreCase("%" + txtFiltroProducto.getText() + "%"));
                break;
        }
        Condition baja = V_PRODUCTOS.BAJA.equal(false);
        query.addConditions(filtro.and(baja));
        query.addOrderBy(V_PRODUCTOS.CODIGO.asc());
        Result<Record> result = query.fetch();
        result.stream().forEach((r) -> {
            dtmProductos.addRow(r.intoArray());
        });

        if (tProductos.getRowCount() > 0) {
            tProductos.changeSelection(0, 1, false, false);
            seleccionarCliente();
        }
    }

    private void dibujarTablas() {
        tClientes.setGridColor(colorUI);
        JTableHeader headerDetalle = tClientes.getTableHeader();
        headerDetalle.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tClientes.setTableHeader(headerDetalle);

        tClientes.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));
        tClientes.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));
        tClientes.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text center", new Color(113, 205, 245)));
        tClientes.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("text center", new Color(113, 205, 245)));
        tClientes.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("text center", new Color(113, 205, 245)));

        tClientes.repaint();

        tDetalleFactura.setGridColor(colorUI);
        JTableHeader headerDetallePedido = tDetalleFactura.getTableHeader();
        headerDetallePedido.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tDetalleFactura.setTableHeader(headerDetallePedido);

        tDetalleFactura.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));
        tDetalleFactura.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));

        tDetalleFactura.repaint();

        tProductos.setGridColor(colorUI);
        JTableHeader headerProducto = tProductos.getTableHeader();
        headerProducto.setDefaultRenderer(new HeaderCellRenderer(colorUI));
        tProductos.setTableHeader(headerProducto);

        tProductos.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));
        tProductos.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("text", new Color(113, 205, 245)));

        tProductos.repaint();
    }

    private boolean isOnDetalle(int idproducto) {
        boolean encuentra = false;
        for (int i = 0; i < tDetalleFactura.getRowCount(); i++) {
            int enTabla = (int) tDetalleFactura.getValueAt(i, 0);
            boolean especial = (boolean) tDetalleFactura.getValueAt(i, 7);
            if (enTabla == idproducto) {
                if (!especial) {
                    encuentra = true;
                }
            }
        }
        return encuentra;
    }

    private ComboBoxModel cbmTamanio(int idproducto) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Result<Record> result = create.select()
                .from(TAMANIO)
                .where(TAMANIO.IDPRODUCTO.equal(idproducto))
                .fetch();
        for (Record r : result) {
            modelo.addElement(
                    new TamanioProducto(
                            r.getValue(TAMANIO.IDTAMANIO),
                            r.getValue(TAMANIO.TAMANIO_)
                    )
            );
        }
        return modelo;
    }

    private ComboBoxModel cbmPrecio(int idproducto) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Result<Record> result = create.select()
                .from(V_PRECIOS)
                .where(V_PRECIOS.IDPRODUCTO.equal(idproducto))
                .fetch();
        for (Record r : result) {
            modelo.addElement(
                    new PrecioProducto(
                            r.getValue(V_PRECIOS.IDPRECIO),
                            r.getValue(V_PRECIOS.IDPRODUCTO),
                            r.getValue(V_PRECIOS.CATEGORIA),
                            r.getValue(V_PRECIOS.PRECIO)
                    )
            );
        }
        return modelo;
    }

    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

    private void seleccionarCliente() {
        if (tClientes.getRowCount() > 0) {
            txtCliente.setText((String) tClientes.getValueAt(tClientes.getSelectedRow(), 1));
            txtDireccion.setText((String) tClientes.getValueAt(tClientes.getSelectedRow(), 2));
            txtTelefono.setText((String) tClientes.getValueAt(tClientes.getSelectedRow(), 3));
            if (ISINICIADA) {
                create.update(COTIZACION)
                        .set(COTIZACION.IDCLIENTE, (int) tClientes.getValueAt(tClientes.getSelectedRow(), 0))
                        .where(COTIZACION.IDCOTIZACION.equal(this.idcotizacion))
                        .execute();
            }
        }

    }

    private void iniciaTransaccion() {
        System.out.println("INICIANDO TRANSACCION");
        try {
            database.getConexion().setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DialogCotizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.util.Date date = txtFecha.getDate();
        java.sql.Date fecha = new java.sql.Date(date.getTime());
        this.idcotizacion = create.insertInto(COTIZACION)
                .set(COTIZACION.NUMERO, "0000")
                .set(COTIZACION.FECHA, fecha)
                .set(COTIZACION.IDEMPLEADO, ue.getIdempleado())
                .set(COTIZACION.TOTAL, BigDecimal.valueOf(0.00))
                .returning().fetchOne().getValue(COTIZACION.IDCOTIZACION);
        ISINICIADA = true;
    }

    private void ingresarPedido() {
        if (isCotizacionRepetida()) {
            int n = new Mensajes().mensajeSiNo("Existen cotizaciones con el mismo número, desea continuar?");
            if (n == 0) {
                editarNumeroCotizacion();
                seleccionarCliente();
            } else {
                avanzar = false;
                txtNumeroOrden.setText("");
            }
        } else {
            editarNumeroCotizacion();
            seleccionarCliente();
        }
    }

    private void editarNumeroCotizacion() {
        btnSiguiente.setEnabled(true);
        create.update(COTIZACION)
                .set(COTIZACION.NUMERO, txtNumeroOrden.getText())
                .where(COTIZACION.IDCOTIZACION.equal(this.idcotizacion))
                .execute();
        TRANSACCION = txtNumeroOrden.getText();
        txtOrden3.setText(TRANSACCION);
    }

    private boolean isCotizacionRepetida() {
        if (!TRANSACCION.equals(txtNumeroOrden.getText())) {
            int existe = create.select(count())
                    .from(COTIZACION)
                    .where(COTIZACION.NUMERO.equal(txtNumeroOrden.getText()))
                    .fetchOne(count(), int.class);
            System.out.println("pedidos: " + existe);
            return existe != 0;
        } else {
            return false;
        }
    }

    private void pasarProductoADetalle() {
        ingresarProductoADetalle((int) tProductos.getValueAt(tProductos.getSelectedRow(), 0));
        Object[] row = {
            (int) tProductos.getValueAt(tProductos.getSelectedRow(), 0),
            (String) tProductos.getValueAt(tProductos.getSelectedRow(), 1),
            new SpinnerNumberModel((float) 0, (float) 0.0000, (float) 999.9999, (float) 1.0),
            new SpinnerNumberModel((float) 0, (float) 0.0000, (float) 999.9999, (float) 1.0),
            new SpinnerNumberModel((float) 1.0, (float) 0.0000, (float) 999.9999, (float) 1.0),
            cbmTamanio((int) tProductos.getValueAt(tProductos.getSelectedRow(), 0)),
            cbmPrecio((int) tProductos.getValueAt(tProductos.getSelectedRow(), 0)),
            false
        };
        dtmDetalleFactura.addRow(row);
        actualizarTotal();
    }

    private void ingresarProductoADetalle(int idproducto) {
        BigDecimal precio = create.select(PRECIOS.PRECIO)
                .from(PRECIOS)
                .where(PRECIOS.IDCATEGORIA.eq(1)
                        .and(PRECIOS.IDPRODUCTO.equal(idproducto)))
                .fetchOne().getValue(PRECIOS.PRECIO);
        int tamanio = create.select(TAMANIO.IDTAMANIO)
                .from(TAMANIO)
                .where(TAMANIO.IDPRODUCTO.equal(idproducto))
                .limit(1)
                .fetchOne().getValue(TAMANIO.IDTAMANIO);
        create.insertInto(DETALLE_COTIZACION)
                .set(DETALLE_COTIZACION.IDCOTIZACION, this.idcotizacion)
                .set(DETALLE_COTIZACION.IDPRODUCTO, idproducto)
                .set(DETALLE_COTIZACION.CANTIDAD, (float) 1.0)
                .set(DETALLE_COTIZACION.PRECIO, precio)
                .set(DETALLE_COTIZACION.IDTAMANIO, tamanio)
                .set(DETALLE_COTIZACION.ESPECIAL, false)
                .set(DETALLE_COTIZACION.ANCHO, (float) 0)
                .set(DETALLE_COTIZACION.LARGO, (float) 0)
                .execute();
    }

    private void actualizarDetallePedido() {
        int idproducto = (int) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 0);
        SpinnerNumberModel cantidad = (SpinnerNumberModel) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 4);
        SpinnerNumberModel anchom = (SpinnerNumberModel) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 2);
        SpinnerNumberModel largom = (SpinnerNumberModel) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 3);
        float nuevaCantidad = Double.valueOf((double) cantidad.getValue()).floatValue();
        ComboBoxModel cbmPrecio = (ComboBoxModel) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 6);
        boolean especial = (boolean) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 7);
        float ancho = Double.valueOf((double) anchom.getValue()).floatValue();
        float largo = Double.valueOf((double) largom.getValue()).floatValue();
        double precioU = 0;
        if (especial) {
            precioU = Double.parseDouble(cbmPrecio.getSelectedItem().toString()) * (ancho * largo);
        } else {
            precioU = Double.parseDouble(cbmPrecio.getSelectedItem().toString());
        }
        BigDecimal precioNuevo = new BigDecimal(precioU);
        create.update(DETALLE_COTIZACION)
                .set(DETALLE_COTIZACION.CANTIDAD, nuevaCantidad)
                .set(DETALLE_COTIZACION.PRECIO, precioNuevo)
                .set(DETALLE_COTIZACION.ESPECIAL, especial)
                .set(DETALLE_COTIZACION.ANCHO, ancho)
                .set(DETALLE_COTIZACION.LARGO, largo)
                .where(DETALLE_COTIZACION.IDPRODUCTO.equal(idproducto))
                .and(DETALLE_COTIZACION.IDCOTIZACION.equal(this.idcotizacion))
                .execute();
        System.out.println("Nueva Cantidad: " + nuevaCantidad);
        System.out.println("Nuevo Precio: " + precioU);
        actualizarTotal();
    }

    private void actualizarTamanio() {
        int idproducto = (int) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 0);
        ComboBoxModel cbmTamanio = (ComboBoxModel) tDetalleFactura.getValueAt(tDetalleFactura.getSelectedRow(), 3);
        TamanioProducto tamanio = (TamanioProducto) cbmTamanio.getSelectedItem();
        create.update(DETALLE_COTIZACION)
                .set(DETALLE_COTIZACION.IDTAMANIO, tamanio.getIdTamanio())
                .where(DETALLE_COTIZACION.IDPRODUCTO.equal(idproducto))
                .and(DETALLE_COTIZACION.IDCOTIZACION.equal(this.idcotizacion))
                .execute();
    }

    private void actualizarTotal() {
        double cantUnit = 0;
        double precioUnit = 0;
        double sumatoria = 0;
        double ancho = 0;
        double largo = 0;
        for (int i = 0; i < tDetalleFactura.getRowCount(); i++) {
            SpinnerNumberModel cantidad = (SpinnerNumberModel) tDetalleFactura.getValueAt(i, 4);
            SpinnerNumberModel anchom = (SpinnerNumberModel) tDetalleFactura.getValueAt(i, 2);
            SpinnerNumberModel largom = (SpinnerNumberModel) tDetalleFactura.getValueAt(i, 3);
            ancho = (double) anchom.getValue();
            largo = (double) largom.getValue();
            boolean especial = (boolean) tDetalleFactura.getValueAt(i, 7);
            cantUnit = (double) cantidad.getValue();
            ComboBoxModel cbmPrecio = (ComboBoxModel) tDetalleFactura.getValueAt(i, 6);
            System.out.println("Precio: " + cbmPrecio.getSelectedItem());
            precioUnit = Double.parseDouble(cbmPrecio.getSelectedItem().toString());
            if (especial) {
                sumatoria = sumatoria + ((ancho * largo * precioUnit) * cantUnit);
            } else {
                sumatoria = sumatoria + (cantUnit * precioUnit);
            }
        }
        String total = String.format("%.2f", sumatoria);
        lblTotal.setText(total);
        guardarTotal(new BigDecimal(sumatoria));
    }

    private void guardarTotal(BigDecimal total) {
        String enletras = clases.NumerosLetras.convertNumberToLetter(total.doubleValue());
        create.update(COTIZACION)
                .set(COTIZACION.TOTAL, total)
                .set(COTIZACION.ENLETRAS, enletras)
                .where(COTIZACION.IDCOTIZACION.equal(this.idcotizacion))
                .execute();
    }

    private void guardarDias() {
        Date date = clases.Fechero.stringToDate(lblVencimiento.getText());
        java.sql.Date fecha = new java.sql.Date(date.getTime());
        int dias = (int) spValidaPor.getValue();
        create.update(COTIZACION)
                .set(COTIZACION.VALIDAPOR, dias)
                .set(COTIZACION.VENCIMIENTO, fecha)
                .where(COTIZACION.IDCOTIZACION.equal(this.idcotizacion))
                .execute();
    }

    private void verificarPosition() {
        switch (position) {
            case 0:
                if (isPanel1Valido()) {
                    avanzar = true;
                    ingresarPedido();
                } else {
                    new Mensajes().mensajeAlert("Ingrese numero de cotización y seleccione cliente");
                    avanzar = false;
                }
                break;
            case 1:
                if (isPanel2Valido()) {
                    avanzar = true;
                } else {
                    new Mensajes().mensajeAlert("Agregue productos a detalle");
                    avanzar = false;
                }
                break;
        }
    }

    private boolean isPanel1Valido() {
        if (txtNumeroOrden.getText() == null || txtNumeroOrden.getText().equals("")) {
            return false;
        } else {
            return tClientes.getRowCount() > 0;
        }
    }

    private boolean isPanel2Valido() {
        return tDetalleFactura.getRowCount() > 0;
    }

    private void fechaValidacion() {
        Calendar cal = clases.Fechero.DateToCalendar(txtFecha.getDate());
        int dias = (int) spValidaPor.getValue();
        cal.add(Calendar.DAY_OF_YEAR, dias);
        Date date = cal.getTime();
        lblVencimiento.setText(clases.Fechero.dateToString(date));
    }

    public class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {

        protected JSpinner spinner;

        public SpinnerEditor() {
            spinner = new JSpinner();
            spinner.setUI(new SpinnerUI(colorBG, cBtnNormal));
            spinner.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent ce) {
                    /*aca las acciones del spinner */
                    actualizarDetallePedido();
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
            setUI(new SpinnerUI(colorBG, cBtnNormal));
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int i, int i1) {
            setModel((SpinnerModel) value);
            return this;
        }
    }

    private class ComboEditor extends AbstractCellEditor implements TableCellEditor {

        int idUnidad;
        protected JComboBox cbx;

        public ComboEditor() {
            cbx = new JComboBox();
            cbx.setUI(new ComboUI(colorBG, cBtnNormal));
            cbx.addItemListener(
                    new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    if (cbx.getModel().getSelectedItem().getClass().getName().equals("clases.PrecioProducto")) {
                        actualizarDetallePedido();
                    } else {
                        actualizarTamanio();
                    }
                }
            }
            );
            JTextComponent editor = (JTextComponent) cbx.getEditor().getEditorComponent();
            editor.addKeyListener(
                    new KeyListener() {
                @Override
                public void keyTyped(java.awt.event.KeyEvent ke) {
                }

                @Override
                public void keyPressed(java.awt.event.KeyEvent ke) {
                }

                @Override
                public void keyReleased(java.awt.event.KeyEvent ke) {
                    if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                        actualizarDetallePedido();
                    }
                }
            }
            );
        }

        @Override
        public Object getCellEditorValue() {
            ComboBoxModel cm = cbx.getModel();
            return cm;
        }

        @Override
        public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
            cbx.setModel((ComboBoxModel) o);
            if (cbx.getModel().getSelectedItem().getClass().getName().equals("clases.PrecioProducto")) {
                cbx.setEditable(true);
            } else {
            }
            return cbx;
        }
    }

    private class ComboRenderer extends JComboBox implements TableCellRenderer {

        public ComboRenderer() {
            setUI(new ComboUI(colorBG, cBtnNormal));
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            setModel((ComboBoxModel) o);
            return this;
        }

    }

}
