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
import model.loaisp;


public class loaispDAO {
    //Lấy danh sách loại sản phẩm
     public ArrayList<loaisp> getListLoaiSP() throws SQLException {
         Connection connection = DBConnect.getConnecttion();         
         String sql = "SELECT * FROM loaisp";         
         PreparedStatement ps = connection.prepareCall(sql);         
         ResultSet rs = ps.executeQuery();         
         ArrayList<loaisp> list = new ArrayList<>();         
         while (rs.next()) {
             loaisp LoaiSP = new loaisp(); 
             LoaiSP.setmaloai(rs.getLong("maloai")); 
             LoaiSP.settenloai(rs.getString("tenloai"));
             LoaiSP.sethinhanh(rs.getString("hinhanh"));
             LoaiSP.setMota(rs.getString("mota"));
             list.add(LoaiSP);         
         }         
         return list;     
     }
     
     public loaisp get1loaisp(long maloai) throws SQLException {      
        Connection connection = DBConnect.getConnecttion();      
        String sql = "SELECT * FROM loaisp WHERE maloai ='" + maloai + "'";      
        PreparedStatement ps = connection.prepareCall(sql);      
        ResultSet rs = ps.executeQuery();      
        loaisp Product = new loaisp();      
        while (rs.next()) {           
            Product.setmaloai(rs.getLong("maloai"));           
            Product.settenloai(rs.getString("tenloai"));           
            Product.sethinhanh(rs.getString("hinhanh"));                      
            Product.setMota(rs.getString("mota"));        }      
        return Product; 
    }
     
     public boolean insert(loaisp c) throws SQLException {     
         try {          
             Connection connection = DBConnect.getConnecttion();          
             String sql = "INSERT INTO loaisp VALUE(?,?,?,?)";          
             PreparedStatement ps = connection.prepareCall(sql);          
             ps.setLong(1, c.getmaloai());          
             ps.setString(2, c.gettenloai());
             ps.setString(3, c.gethinhanh());
             ps.setString(4, c.getMota());
             int temp = ps.executeUpdate();          
             return temp == 1;     
         } catch (SQLException e) {          
             return false;     
         } 
     }
     
     public boolean update(loaisp c) throws SQLException { 
         try{
             Connection connection = DBConnect.getConnecttion();
              String sql = "UPDATE loaisp SET tenloai = ?, hinhanh = ?, mota = ? WHERE maloai = ?";          
              PreparedStatement ps = connection.prepareCall(sql);          
              ps.setLong(4, c.getmaloai());          
              ps.setString(1, c.gettenloai());
              ps.setString(2, c.gethinhanh());
              ps.setString(3, c.getMota());
              int temp = ps.executeUpdate();          
              return temp == 1;     
         } catch (Exception e) {          
             return false;     
         }          
     }
     public boolean delete(long maloai){  
         Connection connection = DBConnect.getConnecttion();         
         String sql = "DELETE FROM loaisp WHERE maloai = ?";
         try {         
                      
             PreparedStatement ps = connection.prepareCall(sql);         
             ps.setLong(1, maloai);         
             int temp = ps.executeUpdate();             
             return temp == 1;     
             } catch (SQLException e) {         
                      
             } 
         return false;
     } 
 
     public static void main(String[] args) throws SQLException {         
         loaispDAO dao = new loaispDAO();         
         System.out.println(dao.get1loaisp(165).gethinhanh());
     }
    
}
