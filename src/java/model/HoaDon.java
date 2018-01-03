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
import java.sql.Timestamp;

public class HoaDon {
    private long maddh;
    private long makh;
    private double tongtien;
    private String diachi;
    private Timestamp ngaydat;
    public HoaDon(){
        
    }

    public HoaDon(long maddh, long makh, double tongtien, String diachi, Timestamp ngaydat) {
        this.maddh = maddh;
        this.makh = makh;
        this.tongtien = tongtien;
        this.diachi = diachi;
        this.ngaydat = ngaydat;
    }

    public long getMaddh() {
        return maddh;
    }

    public void setMaddh(long maddh) {
        this.maddh = maddh;
    }

    public long getMakh() {
        return makh;
    }

    public void setMakh(long makh) {
        this.makh = makh;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Timestamp getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(Timestamp ngaydat) {
        this.ngaydat = ngaydat;
    }
    
}
