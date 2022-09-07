
package beans;

import java.sql.Blob;
import java.sql.Date;


public class cliente_mascota {
    private int id_cliente_mascota;
    private String nombre_mascota;
    private String correo;
    private String direccion;
    private Date fecha_nacimiento_mascota;
    private String nombre_cliente;
    private Blob imagen_mascota;
    private int telefono;

    public cliente_mascota(int id_cliente_mascota, String nombre_mascota, String correo, String direccion, Date fecha_nacimiento_mascota, String nombre_cliente, Blob imagen_mascota, int telefono) {
        this.id_cliente_mascota = id_cliente_mascota;
        this.nombre_mascota = nombre_mascota;
        this.correo = correo;
        this.direccion = direccion;
        this.fecha_nacimiento_mascota = fecha_nacimiento_mascota;
        this.nombre_cliente = nombre_cliente;
        this.imagen_mascota = imagen_mascota;
        this.telefono = telefono;
    }

    public int getId_cliente_mascota() {
        return id_cliente_mascota;
    }

    public void setId_cliente_mascota(int id_cliente_mascota) {
        this.id_cliente_mascota = id_cliente_mascota;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nacimiento_mascota() {
        return fecha_nacimiento_mascota;
    }

    public void setFecha_nacimiento_mascota(Date fecha_nacimiento_mascota) {
        this.fecha_nacimiento_mascota = fecha_nacimiento_mascota;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public Blob getImagen_mascota() {
        return imagen_mascota;
    }

    public void setImagen_mascota(Blob imagen_mascota) {
        this.imagen_mascota = imagen_mascota;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "cliente_mascota{" + "id_cliente_mascota=" + id_cliente_mascota + ", nombre_mascota=" + nombre_mascota + ", correo=" + correo + ", direccion=" + direccion + ", fecha_nacimiento_mascota=" + fecha_nacimiento_mascota + ", nombre_cliente=" + nombre_cliente + ", imagen_mascota=" + imagen_mascota + ", telefono=" + telefono + '}';
    }
    
    
    
}
