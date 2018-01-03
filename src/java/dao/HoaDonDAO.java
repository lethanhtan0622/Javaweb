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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import model.CT_HoaDon;

/**
 *
 * @author SinoMax
 */
public class HoaDonDAO {
    public ArrayList<HoaDon> getListBill() {         
        try {             
            Connection connection = DBConnect.getConnecttion();             
            String sql = "SELECT * FROM dondathang";             
            PreparedStatement ps = connection.prepareCall(sql);             
            ResultSet rs = ps.executeQuery();             
            ArrayList<HoaDon> list = new ArrayList<>();             
            while (rs.next()) {                 
                HoaDon bill = new HoaDon();                 
                bill.setMaddh(rs.getLong("maddh"));                 
                bill.setMakh(rs.getLong("makh"));                 
                bill.setTongtien(rs.getDouble("tongtien"));                               
                bill.setDiachi(rs.getString("diachi"));                 
                bill.setNgaydat(rs.getTimestamp("ngaydat"));                 
                list.add(bill);             
            }             
            return list;         
        } catch (SQLException ex) {             
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);         
        }         
        return null;     
    } 
    public HoaDon getHoaDon(long maddh) {         
        try {             
            Connection connection = DBConnect.getConnecttion();             
            String sql = "SELECT * FROM dondathang WHERE maddh='" + maddh + "'";             
            PreparedStatement ps = connection.prepareCall(sql);             
            ResultSet rs = ps.executeQuery();       
            HoaDon bill = new HoaDon();
            while (rs.next()) {  
                bill.setMaddh(rs.getLong("maddh"));
                bill.setMaddh(rs.getLong("maddh"));                 
                bill.setMakh(rs.getLong("makh"));                 
                bill.setTongtien(rs.getDouble("tongtien"));                               
                bill.setDiachi(rs.getString("diachi"));                 
                bill.setNgaydat(rs.getTimestamp("ngaydat"));        
            }             
            return bill;         
        } catch (SQLException ex) {             
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);         
        }         
        return null;     
    } 
 
     public void insertBill(HoaDon bill) throws SQLException {         
         Connection connection = DBConnect.getConnecttion();         
         String sql = "INSERT INTO dondathang VALUES(?,?,?,?,?)";         
         PreparedStatement ps = connection.prepareCall(sql);         
         ps.setLong(1, bill.getMaddh());         
         ps.setLong(2, bill.getMakh());         
         ps.setDouble(3, bill.getTongtien());         
         ps.setString(4, bill.getDiachi());                  
         ps.setTimestamp(5, bill.getNgaydat());         
         ps.executeUpdate();     
     }   
     public boolean delete(long maddh){  
         Connection connection = DBConnect.getConnecttion();         
         String sql = "DELETE FROM dondathang WHERE maddh = ?";
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
         HoaDonDAO dao = new HoaDonDAO();
         for(HoaDon p : dao.getListBill()){             
            System.out.println(p.getMaddh()+ " - "+p.getTongtien());         
        } 
     }
}
