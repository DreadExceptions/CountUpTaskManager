/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqliteJDBC;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marquis
 */
public class InitialStart {
    
    public static void main( String args[] ) throws IOException, SQLException {      
      /*new GeneralJDBC().initializeDatabase();*/
      
      String file = "/home/marquis/Desktop/template.md";
      File mdDoc = new File(file);
      mdDoc.createNewFile();
      
      FileWriter fw = new FileWriter(file);
      
      Task tmplt = Task.selectTask(1);      
      tmplt.markDownCountUp("# ", fw);
      
      fw.close();
      
   }
}
