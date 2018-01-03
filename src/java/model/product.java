/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

public class product {
    private long masp;     
    private long maloai;     
    private String tensp;     
    private String hinhanh;     
    private double gia;     
    private String mota;
    private int soluong;
    

    public product() {
        
    }

    public product(long masp, long maloai, String tensp, String hinhanh, double gia, String mota, int soluong) {
        this.masp = masp;
        this.maloai = maloai;
        this.tensp = tensp;
        this.hinhanh = hinhanh;
        this.gia = gia;
        this.mota = mota;
        this.soluong = soluong;
    }

    public long getMasp() {
        return masp;
    }

    public void setMasp(long masp) {
        this.masp = masp;
    }

    public long getMaloai() {
        return maloai;
    }

    public void setMaloai(long maloai) {
        this.maloai = maloai;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    
}
