/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteArray {
    
    ClientModell[] clientTable;
    int indexArray;
    
    private ConexionBaseDeDatos conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public ClienteArray(){
        clientTable = new ClientModell[100];
        this.indexArray = 0;
    }
    
public void saveClient(ClientModell client){
        this.clientTable[this.indexArray] = client;
        this.indexArray = this.indexArray + 1;
    }
    
    public ClientModell[] getClient(){
        return clientTable;
    }

    public void deleteClient(String position){
          int pos = Integer.parseInt(position);
          this.clientTable[pos] = null;
          for(int i = pos; i < indexArray - 1; i++) {
                this.clientTable[i] = this.clientTable[i + 1];
          }
          this.clientTable[indexArray - 1] = null;
          indexArray --;
    }
    
    public void abrirConexion(){
        conectorBD= new ConexionBaseDeDatos();
        conexion=conectorBD.conectar();
    }

    public boolean guardarAlumno2(ClientModell client){        
        String sql = "INSERT INTO universidad.cliente(numero_carne, nombre, apellido, direccion, correo, telefono, genero_idgenero)  ";
             sql += " VALUES(  ?,?,?,?,?,?,?)"; 
        try{
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            statement.setInt(1, client.getCode());
            statement.setString(2, client.getName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getAddress());
            statement.setString(5, client.getEmail());
            statement.setInt(6, client.getPhone());
            statement.setInt(7, client.getOption());
            int resultado = statement.executeUpdate(); 
            
                if(resultado > 0){
                    return true;
                }else{
                    return false;
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            return false;
        }    
    }
    public void getAlumnos2(StringBuffer respuesta){   
        String sql="select * from universidad.cliente";
        try{
        abrirConexion();
        statement= conexion.prepareStatement(sql);                        
        result = statement.executeQuery();            
            if (result!=null){
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("numero_carne")).append("</td>");
                respuesta.append("<td >").append(result.getString("nombre")).append("</td>");
                respuesta.append("<td >").append(result.getString("correo")).append("</td>");
                respuesta.append("<td >").append(result.getString("telefono")).append("</td>");
                respuesta.append("<td id=\"").append(result.getString("numero_carne"))
                        .append("\"  onclick=\"edit(this.id);\">") 
                        .append(" <a class=\"btn btn-warning\"'><i class=\"fas fa-edit\"></i>  </a>"
                                +" <a class=\"btn btn-danger\"'> <i class=\"fas fa-trash-alt\"></i> </a>"
                                + " <td></tr>");
                }
            }else{
                respuesta.append("error al consultar");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
