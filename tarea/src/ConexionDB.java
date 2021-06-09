/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jimena
 */
public class ConexionDB {

    private Connection con = null;
    private static ConexionDB cx = null;

    private ConexionDB() {
        try {
            // TODO code application logic here
            String url = "jdbc:postgresql://localhost:5432/proyecto1";
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, "postgres", "jimenamota");
            Logger.getLogger(ConexionDB.class.getName()).log(Level.INFO, "Se conecto...");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public static ConexionDB getInstance() {
        if (cx == null) {
            cx = new ConexionDB();
        }
        return cx;
    }

    //implemtar funcionalidad de execute.
    public boolean execute(String sql) {
        boolean registrar = false;
        Statement stm = null;
     
        try {
            stm = ConexionDB.getInstance().con.createStatement();
            stm.execute(sql);
            registrar = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registrar;
    }

    public ResultSet select(String sql) {
      
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = ConexionDB.getInstance().con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        finally{
            try {
                stm.closeOnCompletion();
                rs.close();
                System.err.println("cerrado");
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rs;
    }

    public Connection getCon() {
        return con;
    }

}
