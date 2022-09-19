/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
/**
 *
 * @author ramir
 */
public class ConexionBaseDeDatos {

    private final String url="jdbc:mysql://localhost:3306/universidad";//url de MySQL
    private final String usuario="root";
    private final String clave="MySQLServer_Rouss154!";
    Connection conexion=null;  
    public Connection conectar(){
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection( url, usuario,clave);
        }  catch (SQLException | ClassNotFoundException ex) {
           ex.printStackTrace();
        }         
        return conexion;        
    }

}
