/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author marquis
 */
public class StartClass {
    
    public static void main( String args[] ) throws ClassNotFoundException, SQLException {
        JFrame fr = new JFrame("CountUp Task Manager");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartPanel strt = new StartPanel(fr);
        fr.add(strt);
        fr.pack();
        fr.setVisible(true);
        //SqliteJDBC.searchOptions tester = new SqliteJDBC.searchOptions("jdbc:sqlite:/home/marquis/Code/CountUpTaskManager/Database/CountUp.db");
        //String[] prnt = tester.getReferenceNames("CATEGORY");
        
    }
}
