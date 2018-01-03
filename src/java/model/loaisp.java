/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SinoMax
 */
public class loaisp {
    private long maloai;
    private String tenloai;
    private String hinhanh;
    private String mota;
    public loaisp(){
        
    }
    public loaisp(long maloai, String tenloai, String hinhanh, String mota){
        this.maloai = maloai;
        this.tenloai = tenloai;
        this.hinhanh = hinhanh;
        this.mota = mota;
    }
    public long getmaloai(){
        return maloai;
    }
    public void setmaloai (long maloai){
        this.maloai = maloai;
    }
    
    public String gettenloai(){
        return tenloai;
    }
    public void settenloai (String tenloai){
        this.tenloai = tenloai;
    }
    
    public String gethinhanh(){
        return hinhanh;
    }
    public void sethinhanh (String hinhanh){
        this.hinhanh = hinhanh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
}
