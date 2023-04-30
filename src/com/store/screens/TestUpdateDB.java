package com.store.screens;

import com.store.entity.Product;
import com.store.repos.ProductRepo;
import javax.swing.JOptionPane;

public class TestUpdateDB {

    public static void main(String[] args) {
        
        //Get all the data for addding a new product from a JOption frame
        String product_Id = JOptionPane.showInputDialog("Which Product Id you want to update the quantity of");
        String product_Qty = JOptionPane.showInputDialog("The updated quantity");

        /**
         * ************************************************
         */
        //Instance of Product Class to set the properties
        Product p = new Product();
        p.setProductId(Integer.parseInt(product_Id));
        p.setProductQty(Integer.parseInt(product_Qty));

        /**
         * ************************************************
         */

        /*
         Create an Instance from ProductRepo Class to access Insert function to update the data
         for the product that The Admin had entered
         */
        ProductRepo pr = new ProductRepo();
        pr.update(p);

    }
}
