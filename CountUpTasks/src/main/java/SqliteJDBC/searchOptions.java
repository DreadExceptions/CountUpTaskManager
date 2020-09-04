/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqliteJDBC;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author marquis
 */
public class searchOptions {
    
    String dbName;
    String url;
    
    public searchOptions(String filePath){
        this.url = filePath;
    }
    
    //String dbName = "CountUp.db";
    //String url = "jdbc:sqlite:/home/marquis/Code/CountUpTaskManager/Database/" + dbName;
    String reg = "SELECT NAME FROM ";
    String cnt = "SELECT COUNT(*) FROM ";
    Connection c;
    Statement stmt; 
    
    public String[] getReferenceNames(String table) throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection(url);
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(cnt + table + ";");
        int size = rs.getInt(1);
        System.out.println(size);
        rs = stmt.executeQuery(reg + table + ";");
        String[] options = new String[size+1];
        int i = 1;
        options[0] = "*";
        while (rs.next()) {
            options[i] = rs.getString("NAME");
            System.out.println(options[i]);
            i++;
        }
        rs.close();
        stmt.close();
        c.close();
        return options;
    }
    
}
