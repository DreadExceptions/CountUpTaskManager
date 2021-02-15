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
import java.util.ArrayList;

/**
 *
 * @author marquis
 */
public class InitialStart {
    
    public static void main( String args[] ) {
      String filePath = "/home/marquis/Code/CountUpTaskManager/Database/dbCreation.sql";
      String dbName = "CountUpLite.db";
      String url = "jdbc:sqlite:/home/marquis/Code/CountUpTaskManager/Database/" + dbName;
      
      Connection conn = null;
      
      try {
          conn = DriverManager.getConnection(url);
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      
      try {
        searchOptions tst = new searchOptions(url);
        System.out.println(tst.getReferenceDateTask(true, "DUEDATE"));
      } catch ( ClassNotFoundException | SQLException e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
      }
      System.out.println("Initialized database.");
   }
}
