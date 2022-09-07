
package beans;

import java.sql.Date;


public class agenda {
    private int id_agenda;
    private int id_servicio;
    private Date fecha_agenda;

    public agenda(int id_agenda, int id_servicio, Date fecha_agenda) {
        this.id_agenda = id_agenda;
        this.id_servicio = id_servicio;
        this.fecha_agenda = fecha_agenda;
    }

    public int getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Date getFecha_agenda() {
        return fecha_agenda;
    }

    public void setFecha_agenda(Date fecha_agenda) {
        this.fecha_agenda = fecha_agenda;
    }

    @Override
    public String toString() {
        return "agenda{" + "id_agenda=" + id_agenda + ", id_servicio=" + id_servicio + ", fecha_agenda=" + fecha_agenda + '}';
    }
    
    
    
}
