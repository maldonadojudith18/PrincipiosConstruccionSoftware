/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestConn {
    public static void main(String[] args){
     insertarRegistro();
    consultarTabla();
  }
  static void insertarRegistro(){
     String strQuery = "INSERT INTO public.\"tbTiposContacto\" (\"Descripcion\") VALUES ('prueba')";
     if(posgresCon.getInstance().execute(strQuery)){
        System.out.println("registro Guardado");
     }
     else{
        System.out.println("ocurrio un error");
     }
  }
     static void consultarTabla(){
      try{
     String strQuery = "select * from \"tbTiposContacto\"";
     ResultSet rs=  posgresCon.getInstance().executeQuery(strQuery);
     while(rs.next()){
           System.out.println("id: " + rs.getInt("idTipo") + 
                   "  Descripcion: " + rs.getString("Descripcion"));
  
       }
     }catch(SQLException ex){
      Logger.getLogger(posgresCon.class.getName()).log(Level.SEVERE,null,ex);
   }
     
     }
  
   }
  
  
  

 
