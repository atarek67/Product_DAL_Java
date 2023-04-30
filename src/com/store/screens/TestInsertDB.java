package com.store.screens;

import com.store.entity.Product;
import com.store.repos.ProductRepo;
import javax.swing.JOptionPane;

public class TestInsertDB {

    public static void main(String[] args) {

        //Get all the data for addding a new product from a JOption frame
        String product_Id = JOptionPane.showInputDialog("Add the ID for a specific produce");
        String product_Name = JOptionPane.showInputDialog("Product Name");
        String product_Price = JOptionPane.showInputDialog("Product Price");
        String product_Qty = JOptionPane.showInputDialog("Product Qtuantity in the Store");

        /**
         * ************************************************
         */
        //Instance of Product Class to set the properties
        Product p = new Product();
        p.setProductId(Integer.parseInt(product_Id));//Convert from String type to a Integer type
        p.setProductName(product_Name);      
        p.setProductPrice(Integer.parseInt(product_Price));
        p.setProductQty(Integer.parseInt(product_Qty));

        /**
         * ************************************************
         */

        /*
         Create an Instance from ProductRepo Class to access Insert function to set the data
         for the product that The Admin had entered
         */
        ProductRepo pr = new ProductRepo();
        pr.insert(p);

    }

}
