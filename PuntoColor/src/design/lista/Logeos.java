
package design.lista;

import javax.swing.ImageIcon;

/* @author JL Desk */
public class Logeos {
    private int id;
    private String nombre;
    private String cargo;
    private String ip;
    private ImageIcon imagen;
    
    public Logeos(int id, String nombre, String cargo, String ip, ImageIcon imagen ){
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.ip = ip;
        this.imagen = imagen;
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

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the imagen
     */
    public ImageIcon getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
}
