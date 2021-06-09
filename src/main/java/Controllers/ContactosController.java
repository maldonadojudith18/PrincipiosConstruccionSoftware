/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import DAL.posgresCon;
import Models.ContactosModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ContactosController {
      private List<ContactosModel> lstContactos;
    public List<ContactosModel> obtenerContactos(){
    lstContactos = new ArrayList<>();
    String strQuery = "Select * from \"tbContactos\" ORDER BY \"id\"";
    ResultSet rs = posgresCon.getInstance().executeQuery(strQuery);
    try{
      while(rs.next()){
        ContactosModel contact = new ContactosModel();
         contact.setId(rs.getInt("id"));
         contact.setTelefono(rs.getString("Telefono"));
         contact.setNombre(rs.getString("Nombre"));
         contact.setIdTipo(rs.getInt("idTipo"));
         
     
        lstContactos.add(contact);
      }
    }catch(SQLException ex){
      Logger.getLogger(posgresCon.class.getName()).log(Level.SEVERE,null,ex);
   }
    
    return lstContactos;
    
}
     public boolean guardarContacto(String tel,String nom,int idTip){
     String strQuery = "INSERT INTO \"tbContactos\" (\"Telefono\",\"Nombre\",\"idTipo\") VALUES ('"+tel+"','"+nom+"','"+idTip+"')";
     return posgresCon.getInstance().execute(strQuery);
     
    }
      public boolean modificarContacto(int id,String tel,String nom, int idTip){
     String strQuery = "UPDATE  \"tbContactos\" SET \"Telefono\" = '"+tel+"' ,\"Nombre\" = '"+nom+"',\"idTipo\" = '"+idTip+"'  WHERE \"id\" = "+id;
     return posgresCon.getInstance().execute(strQuery);
     }
    public boolean eliminarContacto(int id){
     String strQuery ="DELETE FROM \"tbContactos\" WHERE \"id\" = "+id; 
     return posgresCon.getInstance().execute(strQuery);
     }
     
}
