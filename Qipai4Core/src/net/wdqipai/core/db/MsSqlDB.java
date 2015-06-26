/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wdqipai.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static net.wdqipai.core.db.SqlLiteDB.DB_FILE_NAME;

/**
 *
 * @author ACER-FX
 */
public class MsSqlDB {
    
    /**
     * Example:
     * "jdbc:sqlserver://localhost:1433;" +
            "databaseName=AdventureWorks;integratedSecurity=true;";
            
            * Data Source=211.144.85.211;Initial Catalog=dudu;
Persist Security Info=True;
User ID=dudu;Password=zxc123456
     */
    public static String connectionString;
    
    public static int ExecuteNonQuery(String sql)
    {
         // Declare the JDBC objects.
      Connection c = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      
        try {
          
            // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         c = DriverManager.getConnection(connectionString);
         
          //System.out.println("Opened database successfully");

          stmt = c.createStatement();
          
          int rows = stmt.executeUpdate(sql);
          stmt.close();
          c.close();
          
          return rows;
          
        } catch ( ClassNotFoundException | SQLException e ) {
          
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          
        }
       
        return 0;
        

    }
}
