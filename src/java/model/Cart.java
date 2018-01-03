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
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private HashMap<Long, Item> cartItems;
    public Cart(){
        cartItems = new HashMap<>();
    }

    public Cart(HashMap<Long, Item> cartItems) {
        this.cartItems = cartItems;
    }

    public HashMap<Long, Item> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<Long, Item> cartItems) {
        this.cartItems = cartItems;
    }
    
    //insert
     public void plusToCart(Long key, Item item) {        
         boolean bln = cartItems.containsKey(key);        
         if (bln) {             
             int quantity_old = item.getQuantity();             
             item.setQuantity(quantity_old + 1);             
             cartItems.put(item.getProduct().getMasp(), item);        
         } else {             
             cartItems.put(item.getProduct().getMasp(), item);        
         }     
     } 
     //sub
      public void subToCart(Long key, Item item) {         
          boolean check = cartItems.containsKey(key);
          int quantity_old = item.getQuantity();
          if (check) {             
              
              if (quantity_old <= 1) {                 
                  cartItems.remove(key);
              }             
          } else {                 
              item.setQuantity(quantity_old - 1);                 
              cartItems.put(key, item);             
          }         
      }
      //phương thức xóa sp ở giỏ hàng
      public void removeToCart(Long product) {         
          boolean bln = cartItems.containsKey(product);         
          if (bln) {             
              cartItems.remove(product);         
          } 
      } 
      // phương thức đếm số sp
      public int countItem() {         
          int count;
          count = cartItems.size();
          return count; 
      } 
      //phương thức tính tổng tình
      public double total() {         
          int count = 0;         
          for (Map.Entry<Long, Item> list : cartItems.entrySet()) {             
              count += list.getValue().getProduct().getGia()*list.getValue().getQuantity(); 
          }         
          return count; 
      } 
}
