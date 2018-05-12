
package clases;

import java.math.BigDecimal;

/* @author Jose Luis */
public class PrecioProducto {
    private int idprecio;
    private int idproducto;
    private String categoria;
    private BigDecimal precio;
    
    public PrecioProducto(int id, int idproducto, String categoria, BigDecimal precio){
        this.idprecio = id;
        this.idproducto = idproducto;
        this.categoria = categoria;
        this.precio = precio;
    }

    /**
     * @return the idprecio
     */
    public int getIdprecio() {
        return idprecio;
    }

    /**
     * @param idprecio the idprecio to set
     */
    public void setIdprecio(int idprecio) {
        this.idprecio = idprecio;
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

    /**
     * @return the precio
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    public String toString(){
        return ""+precio;
    }

    /**
     * @return the idproducto
     */
    public int getIdproducto() {
        return idproducto;
    }

    /**
     * @param idproducto the idproducto to set
     */
    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
    
}
