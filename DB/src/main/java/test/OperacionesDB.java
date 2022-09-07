
package test;
import beans.cliente_mascota;
import connection.DBConnection;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesDB {
    
    public static void main(String[] args) {
        listarCliente_Mascota();
        //actualizarCliente_Mascota(72425888, "");
        
    }
    
    public static void actualizarCliente_Mascota(int id_cliente_mascota, String correo) {
        
        DBConnection con = new DBConnection();
        String sql = "UPDATE cliente_mascota SET correo = '" +correo+ "' where id_cliente_mascota = " +id_cliente_mascota;
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            con.desconectar();
        }
    }
    
    public static void listarCliente_Mascota(){
        
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM cliente_mascota";
        
        try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            int id_cliente_mascota = rs.getInt("id_cliente_mascota");
            String nombre_mascota = rs.getString("nombre_mascota");
            String correo = rs.getString("correo");
            String direccion = rs.getString("direccion");
            Date fecha_nacimiento_mascota = rs.getDate("fecha_nacimiento_mascota");
            String nombre_cliente = rs.getString("nombre_cliente");
            Blob imagen_mascota = rs.getBlob("imagen_mascota");
            int telefono = rs.getInt("telefono");
            
            
            cliente_mascota cliente_mascotas = new cliente_mascota(id_cliente_mascota, nombre_mascota, correo, direccion, fecha_nacimiento_mascota, nombre_cliente, imagen_mascota, telefono);
            System.out.println(cliente_mascotas.toString());
        }
        st.executeQuery(sql);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        finally {
            con.desconectar();
        }
    }
    
}
