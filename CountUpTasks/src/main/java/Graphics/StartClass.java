/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import SqliteJDBC.GeneralJDBC;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author marquis
 */
public class StartClass {
    
    
    
    public static void main( String args[] ) throws ClassNotFoundException, SQLException {
        new GeneralJDBC().initializeDatabase();
        JFrame fr = new JFrame("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartPanel strt = new StartPanel(fr);
        fr.add(strt);
        fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
}
