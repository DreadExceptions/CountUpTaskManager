/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqliteJDBC;

import java.util.ArrayList;

/**
 *
 * @author marquis
 */
public class InitialStart {
    
    public static void main( String args[] ) {      
      /*new GeneralJDBC().initializeDatabase();
      
      ArrayList<Reference> ref = Reference.referencesSQL("PRIORITY");
      for (Reference e : ref) {System.out.println(e.toString());}
      ref = Reference.referencesSQL("PROGRESS");
      for (Reference e : ref) {System.out.println(e.toString());}
      ref = Reference.referencesSQL("TIMEFRAME");
      for (Reference e : ref) {System.out.println(e.toString());}
      ref = Reference.referencesSQL("TASKTYPE");
      for (Reference e : ref) {System.out.println(e.toString());}
      ref = Reference.referencesSQL("GENRE");
      for (Reference e : ref) {System.out.println(e.toString());}*/
      
      Task prnt = new Task(1);
      
      prnt.findChildren().forEach(e -> {
          System.out.println(e.toStringMarkdown());
        });
      
      prnt.findChildrenWithChildren().forEach(e -> {
          System.out.println(e.toString());
      });
      //System.out.println("It should return true: " + prnt.findChildrenWithChildren().isEmpty());
      
      /*
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
      System.out.println("Initialized database.");*/
   }
}
