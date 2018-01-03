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
import model.product; 

public class ProductDAO {
    //lấy danh sách sản phẩm dựa vào mã sản phẩm
    public ArrayList<product> getListSanphamByLoaisp(long maloai)  throws SQLException {         
        Connection connection = DBConnect.getConnecttion();         
        String sql = "SELECT * FROM sanpham WHERE maloai = '" + maloai + "'";         
        PreparedStatement ps = connection.prepareCall(sql);         
        ResultSet rs = ps.executeQuery();        
        ArrayList<product> list = new ArrayList<>();        
        while (rs.next()) {             
            product Product = new product();             
            Product.setMasp(rs.getLong("masp"));             
            Product.setTensp(rs.getString("tensp"));             
            Product.setHinhanh(rs.getString("hinhanh"));             
            Product.setGia(rs.getDouble("gia"));             
            Product.setMota(rs.getString("mota"));             
            list.add(Product);         
        }         
        return list;     
    }   
    
    public product getProduct(long masp) throws SQLException {      
        Connection connection = DBConnect.getConnecttion();      
        String sql = "SELECT * FROM sanpham  WHERE masp = '" + masp + "'";      
        PreparedStatement ps = connection.prepareCall(sql);      
        ResultSet rs = ps.executeQuery();      
        product Product = new product();      
        while (rs.next()) {           
            Product.setMasp(rs.getLong("masp"));           
            Product.setTensp(rs.getString("tensp"));           
            Product.setHinhanh(rs.getString("hinhanh"));           
            Product.setGia(rs.getDouble("gia"));           
            Product.setMota(rs.getString("mota"));
            Product.setSoluong(rs.getInt("soluong"));            
        }      
        return Product; 
    } 
 
    public static void main(String[] args) throws SQLException {         
        ProductDAO dao = new ProductDAO();         
        for(product p : dao.getListSanphamByLoaisp(2)){             
            System.out.println(p.getMasp() + " - "+p.getTensp());         
        }     
        
    }
}
