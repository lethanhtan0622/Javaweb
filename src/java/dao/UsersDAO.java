/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author SinoMax
 */
import model.Users;
import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersDAO {
    public boolean checkEmail(String email){
        Connection connection = DBConnect.getConnecttion();
        String sql = "SELECT * FROM khachhang WHERE email = '" + email + "'";         
        PreparedStatement ps;
        try{
            ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                connection.close();
                return true;
            }
        }catch(SQLException ex){
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     public boolean insertUser(Users u) {         
         Connection connection = DBConnect.getConnecttion();        
         
         String sql = "INSERT INTO khachhang VALUES (?,?,?,?,?,?)"; 
         try {             
             PreparedStatement ps = connection.prepareCall(sql); 
             ps.setLong(1, u.getMakh());
             ps.setString(2, u.getHoten());             
             ps.setString(3, u.getEmail());             
             ps.setString(4, u.getMatkhau());
             ps.setString(5, u.getDiachi());
             ps.setString(6, u.getSdt());             
             ps.executeUpdate();             
             return true;         
         } catch (SQLException ex) {             
             Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);         
         }         
         return false;     
     } 
      public Users login(String email, String password) {         
          Connection con = DBConnect.getConnecttion();         
          String sql = "select * from khachhang where email='" + email + "' and  matkhau='" + password + "'";         
          PreparedStatement ps;         
          try {             
              ps = (PreparedStatement) con.prepareStatement(sql);             
              ResultSet rs = ps.executeQuery();             
              if (rs.next()) {                 
                  Users u = new Users(); 
                  u.setMakh(rs.getLong("makh"));
                  u.setHoten(rs.getString("hoten"));                 
                  con.close();                 
                  return u;             
              }         
          } catch (SQLException e) {             
          }         
          return null;     
      } 
      public Users loginAdmin(String email, String password) {         
          Connection con = DBConnect.getConnecttion();         
          String sql = "select * from khachhang where email='" + email + "' and  matkhau='" + password + "'";         
          PreparedStatement ps;         
          try {             
              ps = (PreparedStatement) con.prepareStatement(sql);             
              ResultSet rs = ps.executeQuery();             
              if (rs.next()) {                 
                  Users u = new Users(); 
                  u.setMakh(rs.getLong("makh"));
                  u.setHoten(rs.getString("hoten"));
                  u.setEmail(rs.getString("email"));
                  u.setMatkhau(rs.getString("matkhau"));
                  con.close();                 
                  return u;             
              }         
          } catch (SQLException e) {             
          }         
          return null;     
      }
     public Users getUser(long makh) {         
         try {             
             Connection connection = DBConnect.getConnecttion();             
             String sql = "SELECT * FROM khachhang WHERE makh = ?";             
             PreparedStatement ps = connection.prepareCall(sql);             
             ps.setLong(1, makh);             
             ResultSet rs = ps.executeQuery();             
             Users u = new Users();             
             while (rs.next()) {                 
                 u.setEmail(rs.getString("email"));             
             }             
             return u;         
         } catch (SQLException ex) {             
             Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);         
         }         
         return null;     
     } 
 
}
