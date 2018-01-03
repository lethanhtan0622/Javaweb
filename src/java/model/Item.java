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
public class Item {
    private product Product;
    private int quantity;
    public Item(){
        
    }

    public Item(product Product, int quantity) {
        this.Product = Product;
        this.quantity = quantity;
    }

    public product getProduct() {
        return Product;
    }

    public void setProduct(product Product) {
        this.Product = Product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
