
package design.combobox;

/* @author Jose Luis */
public class Unidad {
    private int id;
    private String nombre;
    private double equivalencia;
    
    public Unidad(int id, String nombre,double eq){
        this.id = id;
        this.nombre = nombre;
        this.equivalencia = eq;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return nombre;
    }

    /**
     * @return the equivalencia
     */
    public double getEquivalencia() {
        return equivalencia;
    }

    /**
     * @param equivalencia the equivalencia to set
     */
    public void setEquivalencia(double equivalencia) {
        this.equivalencia = equivalencia;
    }
    
}
