
package clases;

/* @author Jose Luis */
public class TamanioProducto {
    private int idTamanio;
    private String tamanio;
    
    public TamanioProducto(int id, String tamanio){
        this.idTamanio = id;
        this.tamanio = tamanio;
    }

    /**
     * @return the idTamanio
     */
    public int getIdTamanio() {
        return idTamanio;
    }

    /**
     * @param idTamanio the idTamanio to set
     */
    public void setIdTamanio(int idTamanio) {
        this.idTamanio = idTamanio;
    }

    /**
     * @return the tamanio
     */
    public String getTamanio() {
        return tamanio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
    
    @Override
    public String toString(){
        return tamanio;
    }
    
}
