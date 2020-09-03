/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqliteJDBC;
import java.sql.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author marquis
 */
public class InitialStart {
    
    public static void main( String args[] ) {
      String filePath = "/home/marquis/Code/CountUpTaskManager/Database/databaseCreationSQLite.sql";
      String SQLString;
      String dbName = "CountUp.db";
      String url = "jdbc:sqlite:/home/marquis/Code/CountUpTaskManager/Database/" + dbName;
      
      try {
        
        Path DBFile = Path.of(filePath);
        SQLString = Files.readString(DBFile);
        System.out.println("Read SQL.");
        
      
        Connection c;
        Statement stmt;
      
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection(url);
        System.out.println("Opened database.");
         
        stmt = c.createStatement();
        stmt.executeUpdate(SQLString);
        stmt.close();
        c.commit();
        c.close(); 
      } catch ( IOException | ClassNotFoundException | SQLException e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
      }
      System.out.println("Initialized database.");
   }
}
