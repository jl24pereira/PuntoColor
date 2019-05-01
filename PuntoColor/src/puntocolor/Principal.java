package puntocolor;

import clases.AgregarPanel;
import clases.Mensajero;
import clases.Mensajes;
import clases.Permisos;
import clases.ServidorMensajes;
import clases.UsuarioEmpleado;
import conexion.Database;
import dialogs.admon.DialogConfiguraciones;
import dialogs.admon.DialogImpuestos;
import dialogs.admon.DialogMiEmpresa;
import dialogs.reportes.DialogXCliente;
import dialogs.reportes.DialogXFecha;
import dialogs.ventas.DialogCaja;
import dialogs.ventas.DialogFacturacion;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import panels.PanelInicio;
import panels.admon.PanelCajas;
import panels.admon.PanelCostos;
import panels.admon.PanelEmpleados;
import panels.compras.PanelInventario;
import panels.compras.PanelProveedores;
import panels.produccion.PanelPedidosProduccion;
import panels.produccion.PanelProductos;
import panels.ventas.PanelClientes;
import panels.ventas.PanelCotizaciones;
import panels.ventas.PanelPedidos;

import static db.clases.Tables.CAJA;
import static db.clases.Tables.CONEXIONES;
import static org.jooq.impl.DSL.count;

/* @author Jose Luis */
public class Principal extends javax.swing.JFrame {

    AgregarPanel agregar = new AgregarPanel ();

    public static Color colorUI = new Color ( 73 , 190 , 240 );
    public static Color colorUIover = new Color ( 35 , 173 , 232 );
    public static Color colorUIpressed = new Color ( 7 , 154 , 218 );
    public static Color colorBG = new Color ( 255 , 255 , 250 );
    public static Color colorTexto = new Color ( 255 , 255 , 245 );
    public static Color textoTabbed = new Color ( 255 , 135 , 0 );
    public static Color cBtnNormal = new Color ( 255 , 202 , 69 );
    public static Color cBtnOver = new Color ( 255 , 191 , 28 );
    public static Color cBtnPress = new Color ( 255 , 183 , 0 );

    public static Database database = new Database ();

    public static UsuarioEmpleado ue;

    public static Permisos permisos;

    DSLContext create;

    public static Mensajero mensajero = new Mensajero ();

    ServidorMensajes server = new ServidorMensajes ();

    boolean superuser = false;

    boolean conectada = false;

    public Principal ( int iduser ) {
        database.conectar ();
        create = DSL.using ( database.getConexion () , SQLDialect.POSTGRES_9_5 );
        ue = new UsuarioEmpleado ( iduser );
        permisos = new Permisos ( iduser );
        initComponents ();
        this.setTitle ( "PUNTO COLOR SYSTEM" );
        setIconImage ( Toolkit.getDefaultToolkit ().getImage ( this.getClass ().getResource ( "/images/icono.png" ) ) );
        this.setLocationRelativeTo ( null );
        guardarLogeo ();
        agregar.insertarPanelMain ( pBody , new PanelInicio () );
        itemCobros.setVisible ( false );
    }

    public Principal ( boolean superuser ) {
        database.conectar ();
        ue = new UsuarioEmpleado ( "Admin" );
        permisos = new Permisos ( superuser );
        initComponents ();
        this.setTitle ( "PUNTO COLOR SYSTEM" );
        setIconImage ( Toolkit.getDefaultToolkit ().getImage ( this.getClass ().getResource ( "/images/icono.png" ) ) );
        this.setLocationRelativeTo ( null );
        this.superuser = true;
        itemCobros.setVisible ( false );
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pPrincipal = new javax.swing.JPanel();
        pBody = new javax.swing.JPanel();
        pFooter = new javax.swing.JPanel();
        lblBienvenido = new javax.swing.JLabel();
        lblEmpleado = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        mSistema = new javax.swing.JMenu();
        itemInicio = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        itemCerrar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();
        mVentas = new javax.swing.JMenu();
        itemCatalogo = new javax.swing.JMenuItem();
        itemCotizaciones = new javax.swing.JMenuItem();
        itemPedidos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemControlCaja = new javax.swing.JMenuItem();
        smFacturacion = new javax.swing.JMenu();
        itemFactura = new javax.swing.JMenuItem();
        itemCreditoFiscal = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemCobros = new javax.swing.JMenuItem();
        itemClientes = new javax.swing.JMenuItem();
        mDisenio = new javax.swing.JMenu();
        itemDisenio = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        itemConfiguraciones = new javax.swing.JMenuItem();
        mProduccion = new javax.swing.JMenu();
        itemPedidoProduccion = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        itemProductoProduccion = new javax.swing.JMenuItem();
        mCompras = new javax.swing.JMenu();
        itemInventario = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        itemFacturas = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemProveedores = new javax.swing.JMenuItem();
        mAdmon = new javax.swing.JMenu();
        itemCajas = new javax.swing.JMenuItem();
        itemEmpleados = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        itemInformacion = new javax.swing.JMenuItem();
        itemImpuestos = new javax.swing.JMenuItem();
        itemCostos = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        itemRespaldos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        itemCajaxRango = new javax.swing.JMenuItem();
        itemReportes = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        itemCotxCliente = new javax.swing.JMenuItem();
        itemCotxRango = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        itemPedidoxCliente = new javax.swing.JMenuItem();
        itemPedidoxRango = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        itemVtasAnual = new javax.swing.JMenuItem();
        itemVtasxCliente = new javax.swing.JMenuItem();
        itemVtasxRango = new javax.swing.JMenuItem();
        itemCtasCobrar = new javax.swing.JMenuItem();
        mAyuda = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        itemDocumentacion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pPrincipal.setBackground(colorBG);
        pPrincipal.setLayout(new java.awt.GridBagLayout());

        pBody.setBackground(colorBG);
        pBody.setOpaque(false);
        pBody.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pPrincipal.add(pBody, gridBagConstraints);

        pFooter.setMinimumSize(new java.awt.Dimension(100, 50));
        pFooter.setOpaque(false);
        pFooter.setPreferredSize(new java.awt.Dimension(100, 50));
        pFooter.setLayout(new java.awt.GridBagLayout());

        lblBienvenido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBienvenido.setText("Bienvenido:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        pFooter.add(lblBienvenido, gridBagConstraints);

        lblEmpleado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmpleado.setText(ue.getNombre());
        lblEmpleado.setMaximumSize(new java.awt.Dimension(250, 14));
        lblEmpleado.setMinimumSize(new java.awt.Dimension(250, 14));
        lblEmpleado.setPreferredSize(new java.awt.Dimension(250, 14));
        pFooter.add(lblEmpleado, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pPrincipal.add(pFooter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pPrincipal, gridBagConstraints);

        Menu.setBorder(null);

        mSistema.setText("Sistema");
        mSistema.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemInicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemInicio.setText("Inicio");
        itemInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInicioActionPerformed(evt);
            }
        });
        mSistema.add(itemInicio);
        mSistema.add(jSeparator8);

        itemCerrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemCerrar.setText("Cerrar Sesion");
        itemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarActionPerformed(evt);
            }
        });
        mSistema.add(itemCerrar);

        itemSalir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        mSistema.add(itemSalir);

        Menu.add(mSistema);

        mVentas.setText("Ventas");
        mVentas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemCatalogo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemCatalogo.setText("Catálogo");
        itemCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCatalogoActionPerformed(evt);
            }
        });
        mVentas.add(itemCatalogo);
        itemCatalogo.setEnabled(permisos.isCATALOGO());

        itemCotizaciones.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemCotizaciones.setText("Cotizaciones");
        itemCotizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCotizacionesActionPerformed(evt);
            }
        });
        mVentas.add(itemCotizaciones);
        itemCotizaciones.setEnabled(permisos.isCOTIZACIONES());

        itemPedidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemPedidos.setText("Pedidos");
        itemPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPedidosActionPerformed(evt);
            }
        });
        mVentas.add(itemPedidos);
        itemPedidos.setEnabled(permisos.isPEDIDOS());
        mVentas.add(jSeparator1);

        itemControlCaja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemControlCaja.setText("Control de Caja");
        itemControlCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemControlCajaActionPerformed(evt);
            }
        });
        mVentas.add(itemControlCaja);
        itemControlCaja.setEnabled(permisos.isCONTROL_CAJA());

        smFacturacion.setText("Facturación");
        smFacturacion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemFactura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemFactura.setText("Consumidor Final");
        itemFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFacturaActionPerformed(evt);
            }
        });
        smFacturacion.add(itemFactura);
        itemFactura.setEnabled(permisos.isFACTURACION());

        itemCreditoFiscal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemCreditoFiscal.setText("Crédito Fiscal");
        itemCreditoFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreditoFiscalActionPerformed(evt);
            }
        });
        smFacturacion.add(itemCreditoFiscal);
        itemCreditoFiscal.setEnabled(permisos.isFACTURACION());

        mVentas.add(smFacturacion);
        mVentas.add(jSeparator2);

        itemCobros.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemCobros.setText("Cobros");
        itemCobros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCobrosActionPerformed(evt);
            }
        });
        mVentas.add(itemCobros);
        itemCobros.setEnabled(permisos.isCOBROS());

        itemClientes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemClientes.setText("Clientes");
        itemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClientesActionPerformed(evt);
            }
        });
        mVentas.add(itemClientes);
        itemClientes.setEnabled(permisos.isCLIENTES());

        Menu.add(mVentas);

        mDisenio.setText("Diseño");
        mDisenio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemDisenio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemDisenio.setText("Pedidos en Diseño");
        itemDisenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDisenioActionPerformed(evt);
            }
        });
        mDisenio.add(itemDisenio);
        itemDisenio.setEnabled(permisos.isPEDIDOS_DISENIO());
        mDisenio.add(jSeparator9);

        itemConfiguraciones.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemConfiguraciones.setText("Configuración de Diseño");
        itemConfiguraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConfiguracionesActionPerformed(evt);
            }
        });
        mDisenio.add(itemConfiguraciones);
        itemConfiguraciones.setEnabled(permisos.isCONFIGURACIONES());

        Menu.add(mDisenio);

        mProduccion.setText("Producción");
        mProduccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemPedidoProduccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemPedidoProduccion.setText("Pedidos en Produccion");
        itemPedidoProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPedidoProduccionActionPerformed(evt);
            }
        });
        mProduccion.add(itemPedidoProduccion);
        itemPedidoProduccion.setEnabled(permisos.isPEDIDOS_PRODUCCION());
        mProduccion.add(jSeparator7);

        itemProductoProduccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemProductoProduccion.setText("Productos");
        itemProductoProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProductoProduccionActionPerformed(evt);
            }
        });
        mProduccion.add(itemProductoProduccion);
        itemProductoProduccion.setEnabled(permisos.isPRODUCTOS());

        Menu.add(mProduccion);

        mCompras.setText("Compras");
        mCompras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemInventario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemInventario.setText("Inventario");
        itemInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInventarioActionPerformed(evt);
            }
        });
        mCompras.add(itemInventario);
        itemInventario.setEnabled(permisos.isINVENTARIOS());
        mCompras.add(jSeparator6);

        itemFacturas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemFacturas.setText("Facturas");
        itemFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFacturasActionPerformed(evt);
            }
        });
        mCompras.add(itemFacturas);
        itemFacturas.setEnabled(permisos.isFACTURAS());
        mCompras.add(jSeparator3);

        itemProveedores.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemProveedores.setText("Proveedores");
        itemProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProveedoresActionPerformed(evt);
            }
        });
        mCompras.add(itemProveedores);
        itemProveedores.setEnabled(permisos.isPROVEEDORES());

        Menu.add(mCompras);

        mAdmon.setText("Administración");
        mAdmon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemCajas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemCajas.setText("Cajas");
        itemCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCajasActionPerformed(evt);
            }
        });
        mAdmon.add(itemCajas);
        itemCajas.setEnabled(permisos.isCAJAS());

        itemEmpleados.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemEmpleados.setText("Empleados");
        itemEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEmpleadosActionPerformed(evt);
            }
        });
        mAdmon.add(itemEmpleados);
        itemEmpleados.setEnabled(permisos.isEMPLEADOS());
        mAdmon.add(jSeparator5);

        jMenu1.setText("Mi Empresa");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemInformacion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemInformacion.setText("Información");
        itemInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInformacionActionPerformed(evt);
            }
        });
        jMenu1.add(itemInformacion);
        itemInformacion.setEnabled(permisos.isINFORMACION());

        itemImpuestos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemImpuestos.setText("Impuestos");
        itemImpuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemImpuestosActionPerformed(evt);
            }
        });
        jMenu1.add(itemImpuestos);
        itemImpuestos.setEnabled(permisos.isCOSTOS());

        itemCostos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemCostos.setText("Costos");
        itemCostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCostosActionPerformed(evt);
            }
        });
        jMenu1.add(itemCostos);
        itemCostos.setEnabled(permisos.isCOSTOS());

        mAdmon.add(jMenu1);
        mAdmon.add(jSeparator4);

        jMenu4.setText("Respaldos");
        jMenu4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemRespaldos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemRespaldos.setText("Respaldar");
        itemRespaldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRespaldosActionPerformed(evt);
            }
        });
        jMenu4.add(itemRespaldos);
        itemRespaldos.setEnabled(permisos.isRESPALDOS());

        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem1.setText("Restaurar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        mAdmon.add(jMenu4);

        jMenu2.setText("Reportes");
        jMenu2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenu3.setText("Cajas");
        jMenu3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemCajaxRango.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemCajaxRango.setText("Rango de Fechas");
        itemCajaxRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCajaxRangoActionPerformed(evt);
            }
        });
        jMenu3.add(itemCajaxRango);
        itemCajaxRango.setEnabled(permisos.isREPORTES());

        jMenu2.add(jMenu3);

        itemReportes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemReportes.setText("Compras");
        itemReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReportesActionPerformed(evt);
            }
        });
        jMenu2.add(itemReportes);
        itemReportes.setEnabled(permisos.isREPORTES());

        jMenu5.setText("Cotizaciones");
        jMenu5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemCotxCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemCotxCliente.setText("Por Cliente");
        itemCotxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCotxClienteActionPerformed(evt);
            }
        });
        jMenu5.add(itemCotxCliente);
        itemCotxCliente.setEnabled(permisos.isREPORTES());

        itemCotxRango.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemCotxRango.setText("Rango de Fechas");
        itemCotxRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCotxRangoActionPerformed(evt);
            }
        });
        jMenu5.add(itemCotxRango);
        itemCotxRango.setEnabled(permisos.isREPORTES());

        jMenu2.add(jMenu5);

        jMenu6.setText("Pedidos");
        jMenu6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemPedidoxCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemPedidoxCliente.setText("Por Cliente");
        itemPedidoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPedidoxClienteActionPerformed(evt);
            }
        });
        jMenu6.add(itemPedidoxCliente);
        itemPedidoxCliente.setEnabled(permisos.isREPORTES());

        itemPedidoxRango.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemPedidoxRango.setText("Rango de Fechas");
        itemPedidoxRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPedidoxRangoActionPerformed(evt);
            }
        });
        jMenu6.add(itemPedidoxRango);
        itemPedidoxRango.setEnabled(permisos.isREPORTES());

        jMenu2.add(jMenu6);

        jMenu7.setText("Ventas");
        jMenu7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        itemVtasAnual.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemVtasAnual.setText("Anual");
        itemVtasAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVtasAnualActionPerformed(evt);
            }
        });
        jMenu7.add(itemVtasAnual);
        itemVtasAnual.setEnabled(permisos.isREPORTES());

        itemVtasxCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemVtasxCliente.setText("Por Cliente");
        itemVtasxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVtasxClienteActionPerformed(evt);
            }
        });
        jMenu7.add(itemVtasxCliente);
        itemVtasxCliente.setEnabled(permisos.isREPORTES());

        itemVtasxRango.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemVtasxRango.setText("Rango de Fechas");
        itemVtasxRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVtasxRangoActionPerformed(evt);
            }
        });
        jMenu7.add(itemVtasxRango);
        itemVtasxRango.setEnabled(permisos.isREPORTES());

        jMenu2.add(jMenu7);

        itemCtasCobrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemCtasCobrar.setText("Cuentas Por Cobrar");
        itemCtasCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCtasCobrarActionPerformed(evt);
            }
        });
        jMenu2.add(itemCtasCobrar);
        itemCtasCobrar.setEnabled(permisos.isREPORTES());

        mAdmon.add(jMenu2);

        Menu.add(mAdmon);

        mAyuda.setText("Ayuda");
        mAyuda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItem7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem7.setText("Acerca de");
        mAyuda.add(jMenuItem7);

        itemDocumentacion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemDocumentacion.setText("Documentación");
        itemDocumentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDocumentacionActionPerformed(evt);
            }
        });
        mAyuda.add(itemDocumentacion);

        Menu.add(mAyuda);

        setJMenuBar(Menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProveedoresActionPerformed
        // TODO add your handling code here:
        PanelProveedores p = new PanelProveedores ();
        agregar.insertarPanelMain ( pBody , p );
    }//GEN-LAST:event_itemProveedoresActionPerformed

    private void itemEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEmpleadosActionPerformed
        // TODO add your handling code here:
        agregar.insertarPanelMain ( pBody , new PanelEmpleados () );
    }//GEN-LAST:event_itemEmpleadosActionPerformed

    private void itemInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInformacionActionPerformed
        // TODO add your handling code here:
        /*PanelEmpresa p = new PanelEmpresa();
        agregar.insertarPanelMain(pBody, p);*/
        DialogMiEmpresa dialog = new DialogMiEmpresa ( new javax.swing.JFrame () ,
                                                       true ,
                                                       "Mi Empresa" );
        dialog.setVisible ( true );
    }//GEN-LAST:event_itemInformacionActionPerformed

    private void itemInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInventarioActionPerformed
        PanelInventario p = new PanelInventario ();
        agregar.insertarPanelMain ( pBody , p );
    }//GEN-LAST:event_itemInventarioActionPerformed

    private void itemProductoProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProductoProduccionActionPerformed
        // TODO add your handling code here:
        PanelProductos p = new PanelProductos ();
        agregar.insertarPanelMain ( pBody , p );
    }//GEN-LAST:event_itemProductoProduccionActionPerformed

    private void itemCostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCostosActionPerformed
        // TODO add your handling code here:
        PanelCostos p = new PanelCostos ();
        agregar.insertarPanelMain ( pBody , p );
    }//GEN-LAST:event_itemCostosActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        eliminarLogeo ();
        System.exit ( 0 );
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarActionPerformed
        // TODO add your handling code here:
        eliminarLogeo ();
        database.desconectar ();
        server.finalizarServer ();
        InicioSesion s = new InicioSesion ();
        this.dispose ();
        s.setVisible ( true );
    }//GEN-LAST:event_itemCerrarActionPerformed

    private void itemPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPedidosActionPerformed
        // TODO add your handling code here:
        PanelPedidos p = new PanelPedidos ();
        agregar.insertarPanelMain ( pBody , p );
    }//GEN-LAST:event_itemPedidosActionPerformed

    private void itemCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCajasActionPerformed
        // TODO add your handling code here:
        PanelCajas p = new PanelCajas ();
        agregar.insertarPanelMain ( pBody , p );
    }//GEN-LAST:event_itemCajasActionPerformed

    private void itemControlCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemControlCajaActionPerformed
        try {
            // TODO add your handling code here:
            if ( isCaja ( InetAddress.getLocalHost ().getHostAddress () ) ) {
                DialogCaja dialog = new DialogCaja ( new javax.swing.JFrame () ,
                                                     true ,
                                                     "Control de Caja" ,
                                                     InetAddress.getLocalHost ().getHostAddress () );
                dialog.setVisible ( true );
                if ( dialog.isGuardado () ) {
                    //new Mensajes().mensajeInfo("Registro Agregado Exitosamente");
                }
                dialog.dispose ();
            } else {
                new Mensajes ().mensajeError ( "Esta Maquina no es Caja" );
            }
        } catch ( UnknownHostException ex ) {
            Logger.getLogger ( Principal.class.getName () ).log ( Level.SEVERE , null , ex );
        }
    }//GEN-LAST:event_itemControlCajaActionPerformed

    private void itemDocumentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDocumentacionActionPerformed
        // TODO add your handling code here:
        Runtime run = Runtime.getRuntime ();
        String fileName = "Ayuda\\puntoColorHelp.chm";
        String[] commands = { "cmd" , "/c" , fileName };
        try {
            Process child = Runtime.getRuntime ().exec ( commands );
        } catch ( Exception ex ) {
            ex.printStackTrace ();
            System.out.println ( ex.getMessage () );
        }
    }//GEN-LAST:event_itemDocumentacionActionPerformed

    private void itemFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFacturasActionPerformed
        // TODO add your handling code here:
        agregar.insertarPanelMain ( pBody , new panels.compras.PanelFacturas () );
    }//GEN-LAST:event_itemFacturasActionPerformed

    private void itemCotizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCotizacionesActionPerformed
        // TODO add your handling code here:
        agregar.insertarPanelMain ( pBody , new PanelCotizaciones () );
    }//GEN-LAST:event_itemCotizacionesActionPerformed

    private void itemCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCatalogoActionPerformed
        agregar.insertarPanelMain ( pBody , new panels.ventas.PanelCatalogo () );
    }//GEN-LAST:event_itemCatalogoActionPerformed

    private void itemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClientesActionPerformed
        agregar.insertarPanelMain ( pBody , new PanelClientes () );
    }//GEN-LAST:event_itemClientesActionPerformed

    private void itemCobrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCobrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemCobrosActionPerformed

    private void itemDisenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDisenioActionPerformed
        // TODO add your handling code here:
        agregar.insertarPanelMain ( pBody , new panels.disenio.PanelPedidosDisenio () );
    }//GEN-LAST:event_itemDisenioActionPerformed

    private void itemConfiguracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConfiguracionesActionPerformed
        // TODO add your handling code here:
        DialogConfiguraciones dialog = new DialogConfiguraciones ( new javax.swing.JFrame () ,
                                                                   true ,
                                                                   "Configuraciones" );
        dialog.setVisible ( true );
    }//GEN-LAST:event_itemConfiguracionesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        eliminarLogeo ();
        server.finalizarServer ();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        consultarCaja ();
        if ( this.conectada ) {
            new Mensajes ().mensajeAlert ( "Esta caja esta abierta" );
        }
        server.iniciarServer ();
    }//GEN-LAST:event_formWindowOpened

    private void itemPedidoProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPedidoProduccionActionPerformed
        // TODO add your handling code here:
        agregar.insertarPanelMain ( pBody , new PanelPedidosProduccion () );
    }//GEN-LAST:event_itemPedidoProduccionActionPerformed

    private void itemInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInicioActionPerformed
        // TODO add your handling code here:
        agregar.insertarPanelMain ( pBody , new PanelInicio () );
    }//GEN-LAST:event_itemInicioActionPerformed

    private void itemFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFacturaActionPerformed
        // TODO add your handling code here:
        consultarCaja ();
        if ( this.conectada ) {
            try {
                if ( isCaja ( InetAddress.getLocalHost ().getHostAddress () ) ) {
                    DialogFacturacion dialog = new DialogFacturacion (
                            new javax.swing.JFrame () ,
                            true ,
                            "Consumidor Final" ,
                            1
                    );
                    dialog.setVisible ( true );
                    if ( dialog.isGuardado () ) {
                    }
                    dialog.dispose ();
                } else {
                    new Mensajes ().mensajeError ( "Esta Maquina no es Caja" );
                }
            } catch ( UnknownHostException ex ) {
                Logger.getLogger ( Principal.class.getName () ).log ( Level.SEVERE , null , ex );
            }
        } else {
            new Mensajes ().mensajeAlert ( "La caja esta cerrada" );
        }
    }//GEN-LAST:event_itemFacturaActionPerformed

    private void itemCreditoFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreditoFiscalActionPerformed
        // TODO add your handling code here:
        consultarCaja ();
        if ( this.conectada ) {
            try {
                if ( isCaja ( InetAddress.getLocalHost ().getHostAddress () ) ) {
                    DialogFacturacion dialog = new DialogFacturacion (
                            new javax.swing.JFrame () ,
                            true ,
                            "Crédito Fiscal" ,
                            2
                    );
                    dialog.setVisible ( true );
                    if ( dialog.isGuardado () ) {
                    }
                    dialog.dispose ();
                } else {
                    new Mensajes ().mensajeError ( "Esta Maquina no es Caja" );
                }
            } catch ( UnknownHostException ex ) {
                Logger.getLogger ( Principal.class.getName () ).log ( Level.SEVERE , null , ex );
            }
        } else {
            new Mensajes ().mensajeAlert ( "La caja esta cerrada" );
        }
    }//GEN-LAST:event_itemCreditoFiscalActionPerformed

    private void itemImpuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemImpuestosActionPerformed
        // TODO add your handling code here:
        DialogImpuestos dialog = new DialogImpuestos (
                new javax.swing.JFrame () ,
                true ,
                "Impuestos"
        );
        dialog.setVisible ( true );
    }//GEN-LAST:event_itemImpuestosActionPerformed

    private void itemCotxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCotxClienteActionPerformed
        // TODO add your handling code here:
        DialogXCliente dialog = new DialogXCliente (
                new javax.swing.JFrame () ,
                true ,
                "Cotizaciones por cliente" ,
                1
        );
        dialog.setVisible ( true );
    }//GEN-LAST:event_itemCotxClienteActionPerformed

    private void itemVtasAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVtasAnualActionPerformed
        // TODO add your handling code here:
        int year = Calendar.getInstance ().get ( Calendar.YEAR );
        Reportes.Reportes.reporteVentasAnuales ( "" + year );
    }//GEN-LAST:event_itemVtasAnualActionPerformed

    private void itemReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReportesActionPerformed
        // TODO add your handling code here:
        DialogXFecha dialog = new DialogXFecha (
                new javax.swing.JFrame () ,
                true ,
                "Compras por rango de fecha" ,
                2
        );
        dialog.setVisible ( true );
    }//GEN-LAST:event_itemReportesActionPerformed

    private void itemCajaxRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCajaxRangoActionPerformed
        // TODO add your handling code here:
        DialogXFecha dialog = new DialogXFecha (
                new javax.swing.JFrame () ,
                true ,
                "Compras por rango de fecha" ,
                1
        );
        dialog.setVisible ( true );
    }//GEN-LAST:event_itemCajaxRangoActionPerformed

    private void itemCotxRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCotxRangoActionPerformed
        // TODO add your handling code here:
        DialogXFecha dialog = new DialogXFecha (
                new javax.swing.JFrame () ,
                true ,
                "Compras por rango de fecha" ,
                3
        );
        dialog.setVisible ( true );
    }//GEN-LAST:event_itemCotxRangoActionPerformed

    private void itemPedidoxRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPedidoxRangoActionPerformed
        // TODO add your handling code here:
        DialogXFecha dialog = new DialogXFecha (
                new javax.swing.JFrame () ,
                true ,
                "Compras por rango de fecha" ,
                4
        );
        dialog.setVisible ( true );
    }//GEN-LAST:event_itemPedidoxRangoActionPerformed

    private void itemVtasxRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVtasxRangoActionPerformed
        // TODO add your handling code here:
        DialogXFecha dialog = new DialogXFecha (
                new javax.swing.JFrame () ,
                true ,
                "Compras por rango de fecha" ,
                5
        );
        dialog.setVisible ( true );
    }//GEN-LAST:event_itemVtasxRangoActionPerformed

    private void itemPedidoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPedidoxClienteActionPerformed
        // TODO add your handling code here:
        DialogXCliente dialog = new DialogXCliente (
                new javax.swing.JFrame () ,
                true ,
                "Pedidos por cliente" ,
                2
        );
        dialog.setVisible ( true );
    }//GEN-LAST:event_itemPedidoxClienteActionPerformed

    private void itemVtasxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVtasxClienteActionPerformed
        // TODO add your handling code here:
        DialogXCliente dialog = new DialogXCliente (
                new javax.swing.JFrame () ,
                true ,
                "Ventas por cliente" ,
                3
        );
        dialog.setVisible ( true );
    }//GEN-LAST:event_itemVtasxClienteActionPerformed

    private void itemRespaldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRespaldosActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser ();
        chooser.setCurrentDirectory ( new java.io.File ( "." ) );
        chooser.setDialogTitle ( "choosertitle" );
        chooser.setFileSelectionMode ( JFileChooser.DIRECTORIES_ONLY );
        chooser.setAcceptAllFileFilterUsed ( false );

        if ( chooser.showOpenDialog ( null ) == JFileChooser.APPROVE_OPTION ) {
            database.backup ( chooser.getSelectedFile ().toString () );
        } else {
            System.out.println ( "No Selection " );
        }
    }//GEN-LAST:event_itemRespaldosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Database d = new Database ();
        JFileChooser chooser = new javax.swing.JFileChooser ();
        chooser.setFileSelectionMode ( JFileChooser.FILES_ONLY );
        FileNameExtensionFilter filtro = new FileNameExtensionFilter ( "BACKUP" , "backup" );
        chooser.setFileFilter ( filtro );
        int res = chooser.showOpenDialog ( this );
        if ( res == JFileChooser.APPROVE_OPTION ) {
            File file = chooser.getSelectedFile ();
            System.out.println ( file.getAbsolutePath () );
            database.resetDB ( file.getAbsolutePath () );
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void itemCtasCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCtasCobrarActionPerformed
        // TODO add your handling code here:
        new Mensajes().mensajeAlert("Reporte no disponible!");
        //Reportes.Reportes.reporteCuentasCobrar();
    }//GEN-LAST:event_itemCtasCobrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem itemCajas;
    private javax.swing.JMenuItem itemCajaxRango;
    private javax.swing.JMenuItem itemCatalogo;
    private javax.swing.JMenuItem itemCerrar;
    private javax.swing.JMenuItem itemClientes;
    private javax.swing.JMenuItem itemCobros;
    private javax.swing.JMenuItem itemConfiguraciones;
    private javax.swing.JMenuItem itemControlCaja;
    private javax.swing.JMenuItem itemCostos;
    private javax.swing.JMenuItem itemCotizaciones;
    private javax.swing.JMenuItem itemCotxCliente;
    private javax.swing.JMenuItem itemCotxRango;
    private javax.swing.JMenuItem itemCreditoFiscal;
    private javax.swing.JMenuItem itemCtasCobrar;
    private javax.swing.JMenuItem itemDisenio;
    private javax.swing.JMenuItem itemDocumentacion;
    private javax.swing.JMenuItem itemEmpleados;
    private javax.swing.JMenuItem itemFactura;
    private javax.swing.JMenuItem itemFacturas;
    private javax.swing.JMenuItem itemImpuestos;
    private javax.swing.JMenuItem itemInformacion;
    private javax.swing.JMenuItem itemInicio;
    private javax.swing.JMenuItem itemInventario;
    private javax.swing.JMenuItem itemPedidoProduccion;
    private javax.swing.JMenuItem itemPedidos;
    private javax.swing.JMenuItem itemPedidoxCliente;
    private javax.swing.JMenuItem itemPedidoxRango;
    private javax.swing.JMenuItem itemProductoProduccion;
    private javax.swing.JMenuItem itemProveedores;
    private javax.swing.JMenuItem itemReportes;
    private javax.swing.JMenuItem itemRespaldos;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuItem itemVtasAnual;
    private javax.swing.JMenuItem itemVtasxCliente;
    private javax.swing.JMenuItem itemVtasxRango;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JMenu mAdmon;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JMenu mCompras;
    private javax.swing.JMenu mDisenio;
    private javax.swing.JMenu mProduccion;
    private javax.swing.JMenu mSistema;
    private javax.swing.JMenu mVentas;
    private javax.swing.JPanel pBody;
    private javax.swing.JPanel pFooter;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JMenu smFacturacion;
    // End of variables declaration//GEN-END:variables

    private boolean isCaja ( String ip ) {
        int contador = 0;
        try {
            contador = create.select ( count () )
                    .from ( CAJA )
                    .where ( CAJA.IPCAJA.equal ( ip ).and ( CAJA.BAJA.eq ( true ) ) )
                    .fetchOne ( count () );
        } catch ( Exception e ) {

        }
        return contador != 0;
    }

    private void guardarLogeo () {
        try {
            create.insertInto ( CONEXIONES )
                    .set ( CONEXIONES.EMPLEADO , ue.getNombre () )
                    .set ( CONEXIONES.IDEMPLEADO , ue.getIdempleado () )
                    .set ( CONEXIONES.PUESTO , ue.getCargo () )
                    .set ( CONEXIONES.IP , InetAddress.getLocalHost ().getHostAddress () )
                    .execute ();
        } catch ( UnknownHostException ex ) {
            Logger.getLogger ( Principal.class.getName () ).log ( Level.SEVERE , null , ex );
        }
        mensajero.enviarMensaje ( "Se ha Conectado " + ue.getNombre () , DesktopNotify.SUCCESS , 4 );
    }

    private void eliminarLogeo () {
        if ( !superuser ) {
            create.deleteFrom ( CONEXIONES )
                    .where ( CONEXIONES.IDEMPLEADO.equal ( ue.getIdempleado () ) )
                    .execute ();
        }
    }

    private void consultarCaja () {
        try {
            if ( isCaja ( InetAddress.getLocalHost ().getHostAddress () ) ) {
                this.conectada = create.select ( CAJA.ESTADO )
                        .from ( CAJA )
                        .where ( CAJA.IPCAJA.eq ( InetAddress.getLocalHost ().getHostAddress () ) )
                        .fetchOne ( CAJA.ESTADO , boolean.class );
            }
        } catch ( UnknownHostException ex ) {
            Logger.getLogger ( Principal.class.getName () ).log ( Level.SEVERE , null , ex );
        }
    }

}
