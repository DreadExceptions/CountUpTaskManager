/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.SQLException;

/**
 *
 * @author marquis
 */
public class StartClass {
    public static void main( String args[] ) throws ClassNotFoundException, SQLException {
        //StartUpFrame begin = new StartUpFrame();
        SqliteJDBC.searchOptions tester = new SqliteJDBC.searchOptions("jdbc:sqlite:/home/marquis/Code/CountUpTaskManager/Database/CountUp.db");
        String[] prnt = tester.getReferenceNames("CATEGORY");
    }
}
