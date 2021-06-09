/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import DAL.posgresCon;
import Models.TiposContactoModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;


public class TiposContactoController {
     private List<TiposContactoModel> lstTipoContacto;
    public List<TiposContactoModel> obtenerTiposContacto(){
    lstTipoContacto = new ArrayList<>();
    String strQuery = "Select * from \"tbTiposContacto\" ORDER BY \"idTipo\"";
    ResultSet rs = posgresCon.getInstance().executeQuery(strQuery);
    try{
      while(rs.next()){
        TiposContactoModel tipoC = new TiposContactoModel();
         tipoC.setIdTipo(rs.getInt("idTipo"));
         tipoC.setDescripcion(rs.getString("Descripcion"));
     
        lstTipoContacto.add(tipoC);
      }
    }catch(SQLException ex){
      Logger.getLogger(posgresCon.class.getName()).log(Level.SEVERE,null,ex);
   }
    
    return lstTipoContacto;
    }
    public void llenarCombo(JComboBox CBoxIdTipo){
        String strQuery = "Select * from \"tbTiposContacto\" ORDER BY \"idTipo\"";
        ResultSet rs = posgresCon.getInstance().executeQuery(strQuery);
        
         CBoxIdTipo.addItem("Seleccione una opcion");
         try {
             while(rs.next()){
                 CBoxIdTipo.addItem(rs.getString("idTipo"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(TiposContactoController.class.getName()).log(Level.SEVERE, null, ex);
         }
      
    
    }
    
    public boolean guardarTipoContactos(String tipo){
     String strQuery = "INSERT INTO \"tbTiposContacto\" (\"Descripcion\") VALUES ('"+tipo+"')";
     return posgresCon.getInstance().execute(strQuery);
     
    }
    public boolean modificarTipoContactos(int id,String tipo){
     String strQuery = "UPDATE  \"tbTiposContacto\" SET \"Descripcion\" = '"+tipo+"' WHERE \"idTipo\" = "+id; 
     return posgresCon.getInstance().execute(strQuery);
     }
    public boolean eliminarTipoContactos(int id){
     String strQuery ="DELETE FROM \"tbTiposContacto\" WHERE \"idTipo\" = "+ id; 
     return posgresCon.getInstance().execute(strQuery);
     }
}
