/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.program01cc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Itzel Rios
 */
public class ConexionBD {
      private static ConexionBD conexionBD=null;
    
    public static ConexionBD getInstance(){
        if(conexionBD==null)
            conexionBD = new ConexionBD ();  
        
        return conexionBD;
    }
    
    private  String url="jdbc:postgresql://localhost:7000/emple";
    private Connection con = null;
    private String usr="postgres";
    private String psw="postgres";
     
     private ConexionBD (){
          try {
            con = DriverManager.getConnection(url,usr,psw);
            Logger.getLogger(ConexionBD.class.getName()).log(
            Level.INFO,"Se conecto a la Base de Datos ");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
     } 
     
     public boolean execute(String sql){
         Statement st=null;
         try{
         st = con.createStatement();
         st.execute(sql);
         return true;
         }catch(SQLException ex){
              Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
              return false;
         } 
         finally{
             if(st!=null){
                 try {
                     st.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
     }
    
}
