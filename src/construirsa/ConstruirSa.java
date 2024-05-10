/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construirsa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConstruirSa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          try {
            // TODO code application logic here
            Class.forName("org.mariadb.jdbc.Driver");
            String bd="jdbc:mysql://localhost:3306/construirsa";
            String usuario="root";
            String password="";
            Connection con=  DriverManager.getConnection(bd,usuario,password);
    
// se cambia a estado 0 el id_empleado 1
String sql="UPDATE empleado SET  estado=0  WHERE id_empleado=1";
          PreparedStatement ps = con.prepareStatement(sql);
          int filas=ps.executeUpdate();
             if(filas >0){
                       JOptionPane.showMessageDialog(null, "Actualización correcta");
                }
  /*
  // Elimina fisicamente un empleado por dni
            String sql="DELETE  FROM empleado WHERE dni= 25123456";
            PreparedStatement ps = con.prepareStatement(sql);
              int filas = ps.executeUpdate();   // Devuelve un valor entero
              if (filas > 0) {
                  JOptionPane.showMessageDialog(null, "Empleado dado de baja");
              }
*/
  //    Ingreso de empleados          
//             String sql="INSERT INTO "
//                    + "empleado(dni, apellido, nombre, acceso, estado) "
//                    + "VALUES (25123456,'Marcico','Juan','1',true), "
//                    + "(35222111,'Acosta','Alberto','2',true), "                 
//                    +  "(41555666,'Alvarez','Pablo','1',false) ";          
//            PreparedStatement ps = con.prepareStatement(sql);
//             int filas=ps.executeUpdate();
//             if(filas >0){
//                       JOptionPane.showMessageDialog(null, "Empleado Agregado");
//                }

//      Ingreso de herramientas
//                String sql= "INSERT INTO " 
//                       +"herramienta(nombre, descripcion, stock, estado)" 
//                       +"VALUES('Taladro', 'taladro percutor sthill', 15, 1),"
//                       +"('Lima', 'lima plana',4 ,1 )";



//     Listado de herramientas donde el stock > 10
  /*            String sql = "SELECT * FROM `herramienta` WHERE stock > 10 ";
                  PreparedStatement ps = con.prepareStatement(sql);
                  ResultSet datos=ps.executeQuery();
              
              while (datos.next()){
                  int idherramienta=datos.getInt("id_herramienta");
                  String nombre=datos.getString("nombre");
                  String descripcion=datos.getString("descripcion");
                  int stock=datos.getInt("stock");
                  boolean estado=datos.getBoolean("estado");
                  
                  System.out.print("Id herramienta: "+ idherramienta + " | ");
                  System.out.print("Nombre: " + nombre + " | " );
                  System.out.print("Descripcion: " + descripcion + " | ");
                  System.out.print("Stock: " + stock + " | ");
                  System.out.print("Estado: "+ estado + " | ");
                  System.out.println(" ");
              }
*/
        
     } 
        catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargard driver");
        } catch (SQLException ex) {
            int codigoE=ex.getErrorCode();
            if(codigoE==1062){
                  JOptionPane.showMessageDialog(null, "Entrada Duplicada");
            } else if(codigoE==1049){
            JOptionPane.showMessageDialog(null, "BD Desconocida");
            }else{
                  JOptionPane.showMessageDialog(null, "Error ");
            }
            
            ex.printStackTrace();
            System.out.println("codigo de error "+ex.getErrorCode());
        }
    }
    
}
