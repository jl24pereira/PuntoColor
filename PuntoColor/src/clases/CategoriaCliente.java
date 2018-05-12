
package clases;

/* @author Jose Luis */
public class CategoriaCliente {
    private int idcategoria;
    private String categoria;
    
    public CategoriaCliente(int id, String nombre){
        this.idcategoria = id;
        this.categoria = nombre;
    }

    /**
     * @return the idcategoria
     */
    public int getIdcategoria() {
        return idcategoria;
    }

    /**
     * @param idcategoria the idcategoria to set
     */
    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString(){
        return categoria;
    }
    
}
