
package clases;

/* @author JL Desk */

public class CostoPromedio {
    double cantEntrada;
    double precioEntrada;
    double cantExistencia;
    double precioExistencia;
    private double totalStock;
    double totalCosto;
    
    public CostoPromedio(double cantEntrada, double precioEntrada, double cantExistencia, double precioExistencia){
        this.cantEntrada = cantEntrada;
        this.precioEntrada = precioEntrada;
        this.cantExistencia = cantExistencia;
        this.precioExistencia = precioExistencia;
    }
    
    private double costoEntrada(){
        double costoTotal;
        costoTotal = cantEntrada * precioEntrada;
        return costoTotal;
    }
    
    private double costoExistencia(){
        double costoTotal;
        costoTotal = cantExistencia * precioExistencia;
        return costoTotal;
    }
    
    public double calcularCosto(){
        double costo = (costoExistencia()+costoEntrada())/getTotalStock();
        return costo;
    }

    /**
     * @return the totalStock
     */
    public double getTotalStock() {
        return (cantEntrada+cantExistencia);
    }   
    
}
