package music.data;



import java.io.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;
import murach.sql.ConnectionPool;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import murach.sql.SQLUtil;

import music.business.*;

public class ProductDB {

    private static List<Product> products = null;
    private static List<Product> productsTEST = null;
    private static String filePath = null;

    // Called once from ProductAdminController based on servlet context
    public static void init(String filePath) {
        ProductDB.filePath = filePath;
    }

    public static List<Product> selectProducts() {
        products = new ArrayList<Product>();
        
        
        
         // get a connection
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            
            String sqlStatement = "SELECT * FROM product";

        
        try {
            // create a statement
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            
            
            
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            
            
            while(resultSet.next()){
                
                 Product p = new Product();
                 p.setCode(resultSet.getString(2));
                 p.setDescription(resultSet.getString(3));
                 p.setPrice(Double.parseDouble(resultSet.getString(4)));
                    
                    products.add(p);
            } 
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }finally {
            pool.freeConnection(connection);

        }
        return products;

}


    public static Product selectProduct(String productCode) {
        products = selectProducts();
        for (Product p : products) {
            if (productCode != null
                    && productCode.equalsIgnoreCase(p.getCode())) {
                return p;
            }
        }
        return null;
    }

    public static boolean exists(String productCode) {
        Product p = selectProduct(productCode);
        if (p != null) return true;
        else return false;
    }    
    
    private static void saveProducts(List<Product> products) {
        //Create an array to test against
        productsTEST = new ArrayList<Product>();
       
        productsTEST = selectProducts();
        
    //////////////////////////////////////////////////////////////    
        
        //Begin the Comparison of two arrays to add to SQL DB
       int TESTsize = products.size();
       
      

        
        for(int j=0;j<TESTsize;j++){
            if(!productsTEST.contains(products.get(j))){
            
                String Query = "INSERT INTO product(ProductCode, ProductDescription, ProductPrice)"+
                        " VALUES('"+products.get(j).getCode()+"','"+ products.get(j).getDescription()+"','"+products.get(j).getPrice()+"')";
                System.out.println(Query);
                
                // get a connection
                    ConnectionPool pool = ConnectionPool.getInstance();
                    Connection connection = pool.getConnection();
                
                try{
                    
                    
                 PreparedStatement ps = connection.prepareStatement(Query);
                 ps.executeUpdate();
                 
                 
                   
                    ps.close();
               
                    
                }catch(SQLException e){
                    System.out.println(e);
                }finally{
                    pool.freeConnection(connection);
                
                }
            }
                        
                
            }
        
        }
        
        
    

    public static void insertProduct(Product product) {
        // get a connection
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
        
        String Query = "INSERT INTO product(ProductCode, ProductDescription, ProductPrice)"+
                        " VALUES('"+product.getCode()+"','"+ product.getDescription()+"','"+product.getPrice()+"')";
                        System.out.println(Query);

                try{
                 PreparedStatement ps = connection.prepareStatement(Query);
                 ps.executeUpdate();
                 
                 
                   
                ps.close();
               
                
                connection.close();    
                }catch(SQLException e){
                    System.out.println(e);
                }finally{
                    pool.freeConnection(connection);
                
                }
    }

    public static void updateProduct(Product product) {
        
        // get a connection
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
        
         String Query = "UPDATE product SET ProductDescription= '"+ product.getDescription()+"', ProductPrice= '"+product.getPrice()+"' WHERE ProductCode= '"+product.getCode()+"'";
         System.out.println(Query);

                try{
                 PreparedStatement ps = connection.prepareStatement(Query);
                 ps.executeUpdate();
                 
                 
                   
                ps.close();
               
                
                connection.close();    
                }catch(SQLException e){
                    System.out.println(e);
                }finally{
                    pool.freeConnection(connection);
                
                }
        
    }

    public static void deleteProduct(Product product) {
        // get a connection
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            
        String Query = "DELETE FROM product WHERE ProductCode= '"+product.getCode()+"'";
         System.out.println(Query);

                try{
                 PreparedStatement ps = connection.prepareStatement(Query);
                 ps.executeUpdate();
                 
                 
                   
                ps.close();
               
                
                connection.close();    
                }catch(SQLException e){
                    System.out.println(e);
                }finally{
                    pool.freeConnection(connection);
                
                }
        
    }    
}