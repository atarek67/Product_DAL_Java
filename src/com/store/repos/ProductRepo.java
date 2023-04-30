package com.store.repos;

import com.store.entity.Product;
import com.store.managers.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductRepo {

    Connection conn = null;
    PreparedStatement stmt = null;

    public void insert(Product p) {
        try {

            conn = DatabaseManager.getConnection();

            stmt = conn.prepareStatement("INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QTY) \n"
                    + "	VALUES (?, ? , ?, ?)");
            stmt.setInt(1, p.getProductId());
            stmt.setString(2, p.getProductName());
            stmt.setInt(3, p.getProductPrice());
            stmt.setInt(4, p.getProductQty());

            int rows = stmt.executeUpdate();
            System.out.println("Rows = " + rows + " AFFECTED");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("***************************");
            System.out.println(ex.getMessage());
            System.out.println("***************************");
        } finally {
            DatabaseManager.closeStatment(stmt);
            DatabaseManager.closeConnection(conn);
        }
    }

    public void update(Product p) {
        try {

            conn = DatabaseManager.getConnection();

            stmt = conn.prepareStatement("UPDATE PRODUCT "
                    + "SET PRODUCT_QTY = ? "
                    + "WHERE PRODUCT_ID = ? ");

            stmt.setInt(2, p.getProductId());
            stmt.setInt(1, p.getProductQty());

            int rows = stmt.executeUpdate();
            System.out.println("Rows = " + rows + " AFFECTED");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DatabaseManager.closeStatment(stmt);
            DatabaseManager.closeConnection(conn);
        }
    }

    public void delete(Product p) {
        try {

            conn = DatabaseManager.getConnection();

            stmt = conn.prepareStatement("DELETE FROM PRODUCT WHERE PRODUCT_ID = ?");

            stmt.setInt(1, p.getProductId());

            int rows = stmt.executeUpdate();
            System.out.println("Rows = " + rows + " AFFECTED");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DatabaseManager.closeStatment(stmt);
            DatabaseManager.closeConnection(conn);
        }
    }

    public Product getProductByPK(int PRODUCT_ID) {
        Product p = null;
        ResultSet rs = null;
        try {
            conn = DatabaseManager.getConnection();

            stmt = conn.prepareStatement("SELECT PRODUCT_ID , PRODUCT_NAME , PRODUCT_PRICE , "
                    + "PRODUCT_QTY FROM PRODUCT WHERE PRODUCT_ID = ? ");
            stmt.setInt(1, PRODUCT_ID);

            rs = stmt.executeQuery();

            //If there is data then make an instance from product and get ready to set the data in the Product entity class
            if (rs.next()) {
                p = new Product();
                p.setProductId(rs.getInt("PRODUCT_ID"));
                p.setProductName(rs.getString("PRODUCT_NAME"));
                p.setProductPrice(rs.getInt("PRODUCT_PRICE"));
                p.setProductQty(rs.getInt("PRODUCT_QTY"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("*************");
            System.out.println(ex.getMessage());
            System.out.println("*************");

        } finally {
            DatabaseManager.closeStatment(stmt);
            DatabaseManager.closeConnection(conn);
        }
        return p;
    }
}
