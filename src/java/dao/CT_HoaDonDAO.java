/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CT_HoaDon;


/**
 *
 * @author SinoMax
 */
public class CT_HoaDonDAO {
     public void insertBillDetail(CT_HoaDon bd) throws SQLException {         
         Connection connection = DBConnect.getConnecttion();         
         String sql = "INSERT INTO ct_ddh VALUES(?,?,?,?,?)";         
         PreparedStatement ps = connection.prepareCall(sql);         
         ps.setLong(1, bd.getId());         
         ps.setLong(2, bd.getMaddh());         
         ps.setLong(3, bd.getMasp());         
         ps.setDouble(4, bd.getGia());         
         ps.setInt(5, bd.getQuantity());         
         ps.executeUpdate();     
     }
     public ArrayList<CT_HoaDon> getListHoadon(long maddh)  throws SQLException {         
        Connection connection = DBConnect.getConnecttion();         
        String sql = "SELECT * FROM ct_ddh WHERE maddh = '" + maddh + "'";         
        PreparedStatement ps = connection.prepareCall(sql);         
        ResultSet rs = ps.executeQuery();        
        ArrayList<CT_HoaDon> list = new ArrayList<>();        
        while (rs.next()) {             
            CT_HoaDon Product = new CT_HoaDon();             
            Product.setMasp(rs.getLong("masp"));
            Product.setMaddh(rs.getLong("maddh"));                
            Product.setGia(rs.getDouble("gia"));             
            Product.setId(rs.getLong("id"));
            Product.setQuantity(rs.getInt("quantity"));            
            list.add(Product);         
        }       
        return list;     
    } 
     public ArrayList<CT_HoaDon> getListHoadon()  throws SQLException {         
        Connection connection = DBConnect.getConnecttion();         
        String sql = "SELECT * FROM ct_ddh";         
        PreparedStatement ps = connection.prepareCall(sql);         
        ResultSet rs = ps.executeQuery();        
        ArrayList<CT_HoaDon> list = new ArrayList<>();        
        while (rs.next()) {             
            CT_HoaDon Product = new CT_HoaDon();             
            Product.setMasp(rs.getLong("masp"));
            Product.setMaddh(rs.getLong("maddh"));                
            Product.setGia(rs.getDouble("gia"));             
            Product.setId(rs.getLong("id"));
            Product.setQuantity(rs.getInt("quantity"));            
            list.add(Product);         
        }       
        return list;     
    } 
     public boolean delete(long maddh){  
         Connection connection = DBConnect.getConnecttion();         
         String sql = "DELETE FROM ct_ddh WHERE maddh = ?";
         try {         
                      
             PreparedStatement ps = connection.prepareCall(sql);         
             ps.setLong(1, maddh);         
             int temp = ps.executeUpdate();             
             return temp == 1;     
             } catch (SQLException e) {         
                      
             } 
         return false;
     }
     public static void main(String[] args) throws SQLException {         
         new CT_HoaDonDAO().insertBillDetail(new CT_HoaDon(0, 0, 0, 0, 0));     }
}
