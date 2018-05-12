
package design.lista;

import javax.swing.ImageIcon;

/* @author JL Desk */
public class Empleado {
    
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String dui;
    private int idcargo;
    private String cargo;
    private ImageIcon imagen;
    
    public Empleado(int id, String nombre,String direccion, 
            String telefono, String email, String dui, 
            String cargo, int idcargo, ImageIcon imagen){
        //super();
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.dui = dui;
        this.idcargo = idcargo;
        this.cargo = cargo;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the dui
     */
    public String getDui() {
        return dui;
    }

    /**
     * @param dui the dui to set
     */
    public void setDui(String dui) {
        this.dui = dui;
    }

    /**
     * @return the idcargo
     */
    public int getIdcargo() {
        return idcargo;
    }

    /**
     * @param idcargo the idcargo to set
     */
    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
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
