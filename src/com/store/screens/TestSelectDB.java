package com.store.screens;

import com.store.entity.Product;
import com.store.repos.ProductRepo;
import javax.swing.JOptionPane;

public class TestSelectDB {

    public static void main(String[] args) {

        //Take the specific Product ID from the admin to get the data 
        String productId = JOptionPane.showInputDialog("Enter the ID for the product to get all product's data");

        ProductRepo pr = new ProductRepo();
        Product p ;
        //Access getProductByPK in the Repo to get the ID
        p = pr.getProductByPK(Integer.parseInt(productId));

        //check for the instance for th eproduct class if it is not empty; get the data and print it
        if (p != null) {
            System.out.println("PRODUCT_ID: " + p.getProductId() + ", PRODUCT_NAME: " + p.getProductName()
                    + ", PRODUCT_PRICE: " + p.getProductPrice() + ", PRODUCT_QUANTITY: " + p.getProductQty());
        }
    }

}
