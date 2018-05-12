
package clases;

/* @author Jose Luis */
public class CargoEmpleado {
    private int idCargo;
    private String cargo;
    public CargoEmpleado(int idcargo, String cargo){
        this.idCargo = idcargo;
        this.cargo = cargo;
    }

    /**
     * @return the idCargo
     */
    public int getIdCargo() {
        return idCargo;
    }

    /**
     * @param idCargo the idCargo to set
     */
    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public String toString(){
        return cargo;
    }
    
}
