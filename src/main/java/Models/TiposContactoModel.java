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
public class TiposContactoModel {
       private int idTipo;
       private String Descripcion;
   public void setIdTipo(int idTipo){
     this.idTipo = idTipo;
   }
   public void setDescripcion(String Descripcion){
      this.Descripcion = Descripcion;
    }
   public int getIdTipo(){
      return idTipo;
    }
public String  getDescripcion(){
  return Descripcion;
}

}
