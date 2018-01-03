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
import connect.DBConnect; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import model.product; 

public class SanphamDAO {
    public ArrayList<product> getListSanpham()  throws SQLException {         
        Connection connection = DBConnect.getConnecttion();         
        String sql = "SELECT * FROM sanpham";         
        PreparedStatement ps = connection.prepareCall(sql);         
        ResultSet rs = ps.executeQuery();        
        ArrayList<product> list = new ArrayList<>();        
        while (rs.next()) {             
            product Product = new product();             
            Product.setMasp(rs.getLong("masp"));
            Product.setMaloai(rs.getLong("maloai"));
            Product.setTensp(rs.getString("tensp"));             
            Product.setHinhanh(rs.getString("hinhanh"));             
            Product.setGia(rs.getDouble("gia"));             
            Product.setMota(rs.getString("mota"));
            Product.setSoluong(rs.getInt("soluong"));            
            list.add(Product);         
        }       
        return list;     
    }   
    
    public product getProduct(long masp) throws SQLException {      
        Connection connection = DBConnect.getConnecttion();      
        String sql = "SELECT * FROM sanpham WHERE masp ='" + masp + "'";      
        PreparedStatement ps = connection.prepareCall(sql);      
        ResultSet rs = ps.executeQuery();      
        product Product = new product();      
        while (rs.next()) {           
            Product.setMasp(rs.getLong("masp"));
            Product.setMaloai(rs.getLong("maloai"));
            Product.setTensp(rs.getString("tensp"));           
            Product.setHinhanh(rs.getString("hinhanh"));           
            Product.setGia(rs.getDouble("gia"));           
            Product.setMota(rs.getString("mota"));
            Product.setSoluong(rs.getInt("soluong"));            
        }      
        return Product; 
    } 
    
         public boolean insert(product c) throws SQLException {     
         try {          
             Connection connection = DBConnect.getConnecttion();          
             String sql = "INSERT INTO sanpham VALUE(?,?,?,?,?,?,?)";          
             PreparedStatement ps = connection.prepareCall(sql);          
             ps.setLong(1, c.getMasp());
             ps.setLong(2, c.getMaloai());
             ps.setString(3, c.getTensp());
             ps.setString(4, c.getHinhanh());
             ps.setDouble(5, c.getGia());
             ps.setString(6, c.getMota());
             ps.setInt(7, c.getSoluong());
             int temp = ps.executeUpdate();          
             return temp == 1;     
         } catch (SQLException e) {          
             return false;     
         } 
     }
     
     public boolean update(product c) throws SQLException { 
         try{
             Connection connection = DBConnect.getConnecttion();
              String sql = "UPDATE sanpham SET maloai=?, tensp = ?, hinhanh = ?,gia = ?, mota = ?, soluong = ? WHERE masp = ?";          
              PreparedStatement ps = connection.prepareCall(sql);          
              ps.setLong(7, c.getMasp());          
              ps.setLong(1, c.getMaloai());
              ps.setString(2, c.getTensp());
              ps.setString(3, c.getHinhanh());
              ps.setDouble(4, c.getGia());
              ps.setString(5, c.getMota());
              ps.setInt(6, c.getSoluong());
              int temp = ps.executeUpdate();          
              return temp == 1;     
         } catch (Exception e) {          
             return false;     
         }          
     }
     public boolean delete(long masp){  
         Connection connection = DBConnect.getConnecttion();         
         String sql = "DELETE FROM sanpham WHERE masp = ?";
         try {         
                      
             PreparedStatement ps = connection.prepareCall(sql);         
             ps.setLong(1, masp);         
             int temp = ps.executeUpdate();             
             return temp == 1;     
             } catch (SQLException e) {         
                      
             } 
         return false;
     } 
     public boolean deletelist(product c ){  
         try{
             Connection connection = DBConnect.getConnecttion();
              String sql = "UPDATE sanpham SET maloai = '0' WHERE maloai = ?";          
              PreparedStatement ps = connection.prepareCall(sql);          
              ps.setLong(1, c.getMaloai());          
              int temp = ps.executeUpdate();          
              return temp == 1;     
         } catch (Exception e) {          
             return false;     
         }          
     } 
 
    public static void main(String[] args) throws SQLException {         
        SanphamDAO dao = new SanphamDAO();         
        //System.out.println(dao.delete(5));
    }
}
