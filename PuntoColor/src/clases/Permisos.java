
package clases;

import conexion.Database;
import static db.clases.Tables.PERMISOS;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static puntocolor.Principal.database;

/*@author Jose Luis */
public class Permisos {
    private boolean CATALOGO;
    private boolean COTIZACIONES;
    private boolean PEDIDOS;
    private boolean FACTURACION;
    private boolean COBROS;
    private boolean CLIENTES;
    private boolean PEDIDOS_DISENIO;
    private boolean PEDIDOS_PRODUCCION;
    private boolean PRODUCTOS;
    private boolean INVENTARIOS;
    private boolean FACTURAS;
    private boolean PAGOS;
    private boolean PROVEEDORES;
    private boolean EMPLEADOS;
    private boolean INFORMACION;
    private boolean COSTOS;
    private boolean RESPALDOS;
    private boolean REPORTES;
    private boolean CONFIGURACIONES;
    private boolean CONTROL_CAJA;
    private boolean CAJAS;
    
    DSLContext create = DSL.using(database.getConexion(), SQLDialect.POSTGRES_9_5);   
    
    
    public Permisos(int idUsuario){
        obtenerPermisos(idUsuario);
    }
    
    public Permisos(boolean superuser){
        this.EMPLEADOS = superuser;
    }
    
    private void obtenerPermisos(int id){        
        Result<?> result = create.select()
                .from(PERMISOS)
                .where(PERMISOS.IDUSUARIO.equal(id))
                .fetch();
        for (Record r : result) {
            switch(r.getValue(PERMISOS.IDROL)){
                case 1:
                    setCATALOGO(r.getValue(PERMISOS.PERMISO));
                    break;
                case 2:
                    setCOTIZACIONES(r.getValue(PERMISOS.PERMISO));
                    break;
                case 3:
                    setPEDIDOS(r.getValue(PERMISOS.PERMISO));
                    break;
                case 4:
                    setFACTURACION(r.getValue(PERMISOS.PERMISO));
                    break;
                case 5:
                    setCOBROS(r.getValue(PERMISOS.PERMISO));
                    break;
                case 6:
                    setCLIENTES(r.getValue(PERMISOS.PERMISO));
                    break;
                case 7:
                    setPEDIDOS_DISENIO(r.getValue(PERMISOS.PERMISO));
                    break;
                case 8:
                    setPEDIDOS_PRODUCCION(r.getValue(PERMISOS.PERMISO));
                    break;
                case 9:
                    setPRODUCTOS(r.getValue(PERMISOS.PERMISO));
                    break;
                case 10:
                    setINVENTARIOS(r.getValue(PERMISOS.PERMISO));
                    break;
                case 11:
                    setFACTURAS(r.getValue(PERMISOS.PERMISO));
                    break;
                case 12:
                    setPAGOS(r.getValue(PERMISOS.PERMISO));
                    break;
                case 13:
                    setPROVEEDORES(r.getValue(PERMISOS.PERMISO));
                    break;
                case 14:
                    setEMPLEADOS(r.getValue(PERMISOS.PERMISO));
                    break;
                case 15:
                    setINFORMACION(r.getValue(PERMISOS.PERMISO));
                    break;
                case 16:
                    setCOSTOS(r.getValue(PERMISOS.PERMISO));
                    break;
                case 17:
                    setRESPALDOS(r.getValue(PERMISOS.PERMISO));
                    break;
                case 18:
                    setREPORTES(r.getValue(PERMISOS.PERMISO));
                    break;
                case 19:
                    setCONFIGURACIONES(r.getValue(PERMISOS.PERMISO));
                    break;
                case 20:
                    setCONTROL_CAJA(r.getValue(PERMISOS.PERMISO));
                    break;
                case 21:
                    setCAJAS(r.getValue(PERMISOS.PERMISO));
                    break;
            }
        }
    }

    /**
     * @return the CATALOGO
     */
    public boolean isCATALOGO() {
        return CATALOGO;
    }

    /**
     * @param CATALOGO the CATALOGO to set
     */
    public void setCATALOGO(boolean CATALOGO) {
        this.CATALOGO = CATALOGO;
    }

    /**
     * @return the COTIZACIONES
     */
    public boolean isCOTIZACIONES() {
        return COTIZACIONES;
    }

    /**
     * @param COTIZACIONES the COTIZACIONES to set
     */
    public void setCOTIZACIONES(boolean COTIZACIONES) {
        this.COTIZACIONES = COTIZACIONES;
    }

    /**
     * @return the PEDIDOS
     */
    public boolean isPEDIDOS() {
        return PEDIDOS;
    }

    /**
     * @param PEDIDOS the PEDIDOS to set
     */
    public void setPEDIDOS(boolean PEDIDOS) {
        this.PEDIDOS = PEDIDOS;
    }

    /**
     * @return the FACTURACION
     */
    public boolean isFACTURACION() {
        return FACTURACION;
    }

    /**
     * @param FACTURACION the FACTURACION to set
     */
    public void setFACTURACION(boolean FACTURACION) {
        this.FACTURACION = FACTURACION;
    }

    /**
     * @return the COBROS
     */
    public boolean isCOBROS() {
        return COBROS;
    }

    /**
     * @param COBROS the COBROS to set
     */
    public void setCOBROS(boolean COBROS) {
        this.COBROS = COBROS;
    }

    /**
     * @return the CLIENTES
     */
    public boolean isCLIENTES() {
        return CLIENTES;
    }

    /**
     * @param CLIENTES the CLIENTES to set
     */
    public void setCLIENTES(boolean CLIENTES) {
        this.CLIENTES = CLIENTES;
    }

    /**
     * @return the PEDIDOS_DISENIO
     */
    public boolean isPEDIDOS_DISENIO() {
        return PEDIDOS_DISENIO;
    }

    /**
     * @param PEDIDOS_DISENIO the PEDIDOS_DISENIO to set
     */
    public void setPEDIDOS_DISENIO(boolean PEDIDOS_DISENIO) {
        this.PEDIDOS_DISENIO = PEDIDOS_DISENIO;
    }

    /**
     * @return the PEDIDOS_PRODUCCION
     */
    public boolean isPEDIDOS_PRODUCCION() {
        return PEDIDOS_PRODUCCION;
    }

    /**
     * @param PEDIDOS_PRODUCCION the PEDIDOS_PRODUCCION to set
     */
    public void setPEDIDOS_PRODUCCION(boolean PEDIDOS_PRODUCCION) {
        this.PEDIDOS_PRODUCCION = PEDIDOS_PRODUCCION;
    }

    /**
     * @return the PRODUCTOS
     */
    public boolean isPRODUCTOS() {
        return PRODUCTOS;
    }

    /**
     * @param PRODUCTOS the PRODUCTOS to set
     */
    public void setPRODUCTOS(boolean PRODUCTOS) {
        this.PRODUCTOS = PRODUCTOS;
    }

    /**
     * @return the INVENTARIOS
     */
    public boolean isINVENTARIOS() {
        return INVENTARIOS;
    }

    /**
     * @param INVENTARIOS the INVENTARIOS to set
     */
    public void setINVENTARIOS(boolean INVENTARIOS) {
        this.INVENTARIOS = INVENTARIOS;
    }

    /**
     * @return the FACTURAS
     */
    public boolean isFACTURAS() {
        return FACTURAS;
    }

    /**
     * @param FACTURAS the FACTURAS to set
     */
    public void setFACTURAS(boolean FACTURAS) {
        this.FACTURAS = FACTURAS;
    }

    /**
     * @return the PAGOS
     */
    public boolean isPAGOS() {
        return PAGOS;
    }

    /**
     * @param PAGOS the PAGOS to set
     */
    public void setPAGOS(boolean PAGOS) {
        this.PAGOS = PAGOS;
    }

    /**
     * @return the PROVEEDORES
     */
    public boolean isPROVEEDORES() {
        return PROVEEDORES;
    }

    /**
     * @param PROVEEDORES the PROVEEDORES to set
     */
    public void setPROVEEDORES(boolean PROVEEDORES) {
        this.PROVEEDORES = PROVEEDORES;
    }

    /**
     * @return the EMPLEADOS
     */
    public boolean isEMPLEADOS() {
        return EMPLEADOS;
    }

    /**
     * @param EMPLEADOS the EMPLEADOS to set
     */
    public void setEMPLEADOS(boolean EMPLEADOS) {
        this.EMPLEADOS = EMPLEADOS;
    }

    /**
     * @return the INFORMACION
     */
    public boolean isINFORMACION() {
        return INFORMACION;
    }

    /**
     * @param INFORMACION the INFORMACION to set
     */
    public void setINFORMACION(boolean INFORMACION) {
        this.INFORMACION = INFORMACION;
    }

    /**
     * @return the COSTOS
     */
    public boolean isCOSTOS() {
        return COSTOS;
    }

    /**
     * @param COSTOS the COSTOS to set
     */
    public void setCOSTOS(boolean COSTOS) {
        this.COSTOS = COSTOS;
    }

    /**
     * @return the RESPALDOS
     */
    public boolean isRESPALDOS() {
        return RESPALDOS;
    }

    /**
     * @param RESPALDOS the RESPALDOS to set
     */
    public void setRESPALDOS(boolean RESPALDOS) {
        this.RESPALDOS = RESPALDOS;
    }

    /**
     * @return the REPORTES
     */
    public boolean isREPORTES() {
        return REPORTES;
    }

    /**
     * @param REPORTES the REPORTES to set
     */
    public void setREPORTES(boolean REPORTES) {
        this.REPORTES = REPORTES;
    }

    /**
     * @return the CONFIGURACIONES
     */
    public boolean isCONFIGURACIONES() {
        return CONFIGURACIONES;
    }

    /**
     * @param CONFIGURACIONES the CONFIGURACIONES to set
     */
    public void setCONFIGURACIONES(boolean CONFIGURACIONES) {
        this.CONFIGURACIONES = CONFIGURACIONES;
    }

    /**
     * @return the CONTROL_CAJA
     */
    public boolean isCONTROL_CAJA() {
        return CONTROL_CAJA;
    }

    /**
     * @param CONTROL_CAJA the CONTROL_CAJA to set
     */
    public void setCONTROL_CAJA(boolean CONTROL_CAJA) {
        this.CONTROL_CAJA = CONTROL_CAJA;
    }

    /**
     * @return the CAJAS
     */
    public boolean isCAJAS() {
        return CAJAS;
    }

    /**
     * @param CAJAS the CAJAS to set
     */
    public void setCAJAS(boolean CAJAS) {
        this.CAJAS = CAJAS;
    }

}
