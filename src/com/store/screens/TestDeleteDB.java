package com.store.screens;

import com.store.entity.Product;
import com.store.repos.ProductRepo;
import javax.swing.JOptionPane;

public class TestDeleteDB {

    public static void main(String[] args) {

        
        String Product_Id = JOptionPane.showInputDialog("ID");
        
        Product p = new Product();
        p.setProductId(Integer.parseInt(Product_Id));
        
        ProductRepo pr = new ProductRepo();
//        pr.delete(Integer.parseInt(Product_Id));
        pr.delete(p);

    }
}
