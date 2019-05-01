
package Reportes;

import clases.Mensajes;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static puntocolor.Principal.database;

/* @author JL Desk */
public class Reportes {
    
    public static void reporteProveedores(){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\proveedores.jasper");
            Map valores = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Proveedores");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteInventarios(){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\gral_materia.jasper");
            Map valores = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Inventario");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteInventariosBajoStock(){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\materia_baja.jasper");
            Map valores = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Inventario con Bajo Stock");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteEmpleados(){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\empleados.jasper");
            Map valores = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Empleados");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static void reporteCostos(){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\costosDirectos.jasper");
            Map valores = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Costos");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteCostosProducto(){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\productosCosteo.jasper");
            Map valores = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Costos por Producto");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteFacturasProveedor(int idproveedor, String nombre, Date fInicio, Date fFinal){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\comprasXrango.jasper");
            Map valores = new HashMap();
            valores.put("IDPROVEEDOR", idproveedor);
            valores.put("PROVEEDOR", nombre);
            valores.put("FINICIO", fInicio);
            valores.put("FFINAL", fFinal);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Facturas por Proveedor");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void cotizacionOnline(int transaccion){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\cotiza_online.jasper");
            Map valores = new HashMap();
            valores.put("NUMERO", transaccion);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Costos");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cotizacion(int transaccion){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\cotizacion_local.jasper");
            Map valores = new HashMap();
            valores.put("NUMERO", transaccion);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            JasperPrintManager.printReport(jasperPrint, false); 
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void pedido(int transaccion){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\pedidoLista.jasper");
            Map valores = new HashMap();
            valores.put("NUMPEDIDO", transaccion);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            JasperPrintManager.printReport(jasperPrint, false); 
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void consumidorFinal(int transaccion){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\doc_consum_final.jasper");
            Map valores = new HashMap();
            valores.put("IDVENTA", transaccion);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            JasperPrintManager.printReport(jasperPrint, false); 
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void creditoFiscal(int transaccion){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\doc_cred_fiscal.jasper");
            Map valores = new HashMap();
            valores.put("IDVENTA", transaccion);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            JasperPrintManager.printReport(jasperPrint, false); 
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cierreCaja(String empleado, java.sql.Timestamp fInicio, java.sql.Timestamp fFinal){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\CajaCerrar.jasper");
            Map valores = new HashMap();
            valores.put("CAJERO", empleado);
            valores.put("FECHAINICIAL", fInicio);
            valores.put("FECHAFINAL", fFinal);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            JasperPrintManager.printReport(jasperPrint, false); 
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void aperturaCaja(String empleado, BigDecimal saldo){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\CajaAbrir.jasper");
            Map valores = new HashMap();
            valores.put("CAJERO", empleado);
            valores.put("SALDOINICIAL", saldo);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            JasperPrintManager.printReport(jasperPrint, false); 
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteCatalogo(){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\catalogo.jasper");
            Map valores = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Catalogo");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteCatalogoXCodigo(String codigo){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\catalogo_codigo.jasper");
            Map valores = new HashMap();
            valores.put("CODIGO", codigo);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Catalogo");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteCatalogoXNombre(String nombre){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\catalogo_nombre.jasper");
            Map valores = new HashMap();
            valores.put("NOMBRE", nombre);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Catalogo");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteCatalogoXCategoria(String categoria){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\catalogo_categoria.jasper");
            Map valores = new HashMap();
            valores.put("CATEGORIA", categoria);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Catalogo");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteCajasXRango(java.sql.Timestamp fechaInicio, java.sql.Timestamp fechaFinal){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\cajaXfecha.jasper");
            Map valores = new HashMap();
            valores.put("FINICIO", fechaInicio);
            valores.put("FFINAL", fechaFinal);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Catalogo");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            //viewer
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteComprasXRango(java.sql.Date fechaInicio, java.sql.Date fechaFinal){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\comprasGralXrango.jasper");
            Map valores = new HashMap();
            valores.put("FINICIO", fechaInicio);
            valores.put("FFINAL", fechaFinal);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Catalogo");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            //viewer
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteVentasAnuales(String anio){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\ventaanual.jasper");
            Map valores = new HashMap();
            valores.put("ANIO", anio);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Catalogo");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    public static void reporteCotizacionesXCliente(int idcliente){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\cotizaciones_cliente.jasper");
            Map valores = new HashMap();
            valores.put("IDCLIENTE", idcliente);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Cotizaciones");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteCotizacionesXRango(java.sql.Date fechaInicio, java.sql.Date fechaFinal){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\cotizacionesXfecha.jasper");
            Map valores = new HashMap();
            valores.put("FINICIO", fechaInicio);
            valores.put("FFINAL", fechaFinal);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Catalogo");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            //viewer
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reportePedidoXCliente(int idcliente){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\pedidos_cliente.jasper");
            Map valores = new HashMap();
            valores.put("IDCLIENTE", idcliente);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Ventas");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reportePedidosXRango(java.sql.Date fechaInicio, java.sql.Date fechaFinal){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\pedidosXfechas.jasper");
            Map valores = new HashMap();
            valores.put("FINICIAL", fechaInicio);
            valores.put("FFINAL", fechaFinal);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Catalogo");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            //viewer
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteVentaXCliente(int idcliente){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\clientes_historico.jasper");
            Map valores = new HashMap();
            valores.put("IDCLIENTE", idcliente);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Ventas");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reporteVentasXRango(java.sql.Date fechaInicio, java.sql.Date fechaFinal){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\ventasXrango.jasper");
            Map valores = new HashMap();
            valores.put("FINICIAL", fechaInicio);
            valores.put("FFINAL", fechaFinal);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Catalogo");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            //viewer
        } catch (JRException ex) {            
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error con reporte");   
        }
    }
    
    public static void reporteCuentasCobrar(){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reportes\\cuentasXCobrar.jasper");
            Map valores = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, valores, database.getConexion());
            //JasperPrintManager.printReport(jasperPrint, false);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setTitle("Reporte de Cuentas Por Cobrar");
            //viewer.setDefaultCloseOperation();
            viewer.setSize(950, 600);
            viewer.setVisible(true);            
            
        } catch (JRException ex) {
            new Mensajes().mensajeAlert("Reporte no disponible!");
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
