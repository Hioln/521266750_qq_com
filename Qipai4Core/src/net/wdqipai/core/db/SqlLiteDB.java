/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wdqipai.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author ACER-FX
 */
public class SqlLiteDB {
    
    public static String connectionString;
    
    public static String DB_FILE_NAME = "www.wdqipai.net.db";
    
//    String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//                           "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
    
    public static int ExecuteInsert(String sql)
    {
        Connection c = null;
        Statement stmt = null;
        try
        {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE_NAME);
          //c.setAutoCommit(false);
          //System.out.println("Opened database successfully");

          int rows = 0;
          
          stmt = c.createStatement();
          rows += stmt.executeUpdate(sql);

          stmt.close();
          //c.commit();
          c.close();
          
          return rows;
          
        } catch ( ClassNotFoundException | SQLException e ) {
            
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }

      return 0;
    }
    
    /**
     * 
     * 
     * @param sql
     * @return 
     */
    public static int ExecuteInsert(List<String> sql)
    {
        Connection c = null;
        Statement stmt = null;
        
        try 
        {
            
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE_NAME);
          c.setAutoCommit(false);
          //System.out.println("Opened database successfully");

          stmt = c.createStatement();

          int rows = 0;

          for (String s : sql) {
                rows += stmt.executeUpdate(s);
          }

          stmt.close();
          c.commit();
          c.close();
          
          return rows;
          
        }
        catch ( ClassNotFoundException | SQLException e ){
            
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
              
        }
            
          return 0;
            
    }
    
    
//    
//    sql = "CREATE TABLE COMPANY " +
//                       "(ID INT PRIMARY KEY     NOT NULL," +
//                       " NAME           TEXT    NOT NULL, " + 
//                       " AGE            INT     NOT NULL, " + 
//                       " ADDRESS        CHAR(50), " + 
//                       " SALARY         REAL)"; 
    
    public static int ExecuteNonQuery(String sql)
    {
        Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE_NAME);
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
