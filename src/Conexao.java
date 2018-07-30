
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 181710180
 */
public class Conexao {
   
    private static final String CONN = "jdbc:mysql://localhost:3306/loja_t171?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    
    public static ResultSet consultar(String sql){
        ResultSet rs = null;
        try{
            Class.forName( DRIVER );
            Connection conn = 
                    DriverManager.getConnection(CONN, USER, PASSWORD);
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, e.toString()); 
        }
        return rs;
    }  
    
    public static boolean executar(String sql){
        try{
            Class.forName( DRIVER );
            Connection conn = 
                    DriverManager.getConnection(CONN, USER, PASSWORD);
            Statement st = conn.createStatement();
            st.execute(sql);
            return true;
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
}
