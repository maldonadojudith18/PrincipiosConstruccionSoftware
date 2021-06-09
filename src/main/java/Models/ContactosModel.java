/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Familia
 */
public class ContactosModel {
    private int id;
    private String Telefono;
    private String Nombre;
    private int idTipo;
   public void setId(int id){
     this.id = id;
   }
   public void setTelefono(String Telefono){
      this.Telefono = Telefono;
   }  
   public void setNombre (String Nombre){
      this.Nombre = Nombre; 
   }
   public void setIdTipo(int idTipo){
     this.idTipo = idTipo;
   }
    public int getId(){
      return id;
    }
    public String  getTelefono(){
        return Telefono;
    }
    public String  getNombre(){
      return Nombre;
    }
   public int getIdTipo(){
      return idTipo;
    }
}
