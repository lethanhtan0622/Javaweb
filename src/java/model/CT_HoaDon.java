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
public class CT_HoaDon {
    private long id;
    private long maddh;
    private long masp;
    private double gia;
    private int quantity;
    public CT_HoaDon(){
        
    }

    public CT_HoaDon(long id, long maddh, long masp, double gia, int quantity) {
        this.id = id;
        this.maddh = maddh;
        this.masp = masp;
        this.gia = gia;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMaddh() {
        return maddh;
    }

    public void setMaddh(long maddh) {
        this.maddh = maddh;
    }

    public long getMasp() {
        return masp;
    }

    public void setMasp(long masp) {
        this.masp = masp;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
