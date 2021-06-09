/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.ResultSet;




/**
 *
 * @author Familia
 */
public class posgresCon {
    private static posgresCon myConn;
private Connection bdConn = null;
private posgresCon(){
   try{
      Class.forName("org.postgresql.Driver");
      bdConn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDagendaUV","postgres","Maldonado1");
      System.out.println(" CONECTADO");
      }catch(ClassNotFoundException | SQLException ex){
      Logger.getLogger(posgresCon.class.getName()).log(Level.SEVERE,null,ex);
      }
}
     public static posgresCon getInstance(){
      if(myConn == null){
      myConn = new posgresCon();
     }
      
    return myConn;
     }
     public boolean execute(String sql){
     boolean res = false;
     
     try{
       Statement st = bdConn.createStatement();
       st.execute(sql);
       res = true;
    }
    catch(SQLException ex){
      Logger.getLogger(posgresCon.class.getName()).log(Level.SEVERE,null,ex);
   }
   return res;
}
     public ResultSet executeQuery(String sql){
      ResultSet res = null;
 try{
     Statement st = bdConn.createStatement();
     res = st.executeQuery(sql);
  } catch(SQLException ex){
      Logger.getLogger(posgresCon.class.getName()).log(Level.SEVERE,null,ex);
   }
return res;
}
}
    
    

