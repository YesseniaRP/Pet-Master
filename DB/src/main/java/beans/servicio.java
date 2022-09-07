
package beans;


public class servicio {
    private int id_servicio;
    private int id_cliente_mascota;
    private String tipo_servicio;

    public servicio(int id_servicio, int id_cliente_mascota, String tipo_servicio) {
        this.id_servicio = id_servicio;
        this.id_cliente_mascota = id_cliente_mascota;
        this.tipo_servicio = tipo_servicio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_cliente_mascota() {
        return id_cliente_mascota;
    }

    public void setId_cliente_mascota(int id_cliente_mascota) {
        this.id_cliente_mascota = id_cliente_mascota;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    @Override
    public String toString() {
        return "servicio{" + "id_servicio=" + id_servicio + ", id_cliente_mascota=" + id_cliente_mascota + ", tipo_servicio=" + tipo_servicio + '}';
    }
    
    
}
