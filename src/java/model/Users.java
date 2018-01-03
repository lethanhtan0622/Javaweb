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
public class Users {
    private long makh;
    private String hoten;
    private String email;
    private String matkhau;
    private String diachi;
    private String sdt;
    
    public Users(){
        
    }

    public Users(long makh, String hoten, String email, String matkhau, String diachi, String sdt) {
        this.makh = makh;
        this.hoten = hoten;
        this.email = email;
        this.matkhau = matkhau;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public long getMakh() {
        return makh;
    }

    public void setMakh(long makh) {
        this.makh = makh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
