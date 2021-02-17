
package SqliteJDBC;
import java.sql.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marquis
 */
public class GeneralJDBC { //class cannot be used outside of it's own package
    
    private String DBNAME;
    
    protected GeneralJDBC(String dbnm) {
        this.DBNAME = dbnm;
    }
    
    public GeneralJDBC () {
        this.DBNAME = "CountUpLite.db";
    }

    protected String getSELECTTASK() {
        return SELECTTASK;
    }
    
    protected String getSELECTCHILDREN() {
        return SELECTCHILDREN;
    }
    
    protected String getSELECTCHILDRENSHORT() {
        return SELECTCHILDRENSHORT;
    }
    
    protected String getSELECTREF() {
        return SELECTREF;
    }
    
    protected String getUPDATETASK() {
        return UPDATETASK;
    }

    protected String getDELETETASK() {
        return DELETETASK;
    }

    protected String getDELETECHILDREN() {
        return DELETECHILDREN;
    }

    protected String getINSERTTASK() {
        return INSERTTASK;
    }
    
    protected String getWHERETASK() {
        return WHERETASK;
    }
    
    //JDBC Access variables
    private final String FILEPATH = "/home/marquis/Code/CountUpTaskManager/Database/dbCreation.sql";
    private final String URL = "jdbc:sqlite:/home/marquis/Code/CountUpTaskManager/Database/";
    
    //SQL Strings, General
    //Get reference variables
    private final String SELECTREF = "SELECT REFID, TITLE FROM ";// + table name + ";"
    //Get Specific task
    private final String SELECTTASK = "SELECT * FROM task WHERE taskID = ? ;";
    //Get Children Tasks
    private final String SELECTCHILDREN = "SELECT T.TASKID, T.TITLE, " + 
	"T.DESCRIPTION, " + 
        "TIMEFRAME.TITLE AS TIMEFRAME, " + 
        "GENRE.TITLE AS GENRE, " + 
        "PRIORITY.TITLE AS PRIORITY, " + 
        "PROGRESS.TITLE AS PROGRESS, " + 
        "TASKTYPE.TITLE AS TASKTYPE, " + 
	"T.CREATEDDATE, T.STARTEDDATE, T.COMPLETED, T.DUEDATE " +
        "FROM TASK T " + 
	"INNER JOIN TIMEFRAME ON T.TIMEFRAME = TIMEFRAME.REFID " + 
	"INNER JOIN GENRE ON T.GENRE = GENRE.REFID " + 
        "INNER JOIN PRIORITY ON T.PRIORITY = PRIORITY.REFID " + 
        "INNER JOIN PROGRESS ON T.PROGRESS = PROGRESS.REFID " +
        "INNER JOIN TASKTYPE ON T.TASKTYPE = TASKTYPE.REFID " +
        "WHERE PARENTID = ? ;";
    private final String SELECTCHILDRENSHORT = "SELECT TASKID FROM TASK WHERE PARENTID = ? ";
    //SQL Strings, Exclusive to AddEditPanel
    //Update Task
    private final String UPDATETASK = "UPDATE task SET ";
    private final String WHERETASK = " WHERE taskID = ? ;";
    //Delete Task
    private final String DELETETASK = "DELETE FROM task WHERE taskID = ? ;";
    //Delete Children Tasks
    private final String DELETECHILDREN = "DELETE FROM task WHERE parentID = ? ;";
    //Insert Tasks
    private final String INSERTTASK = "INSERT INTO TASK (TITLE, DESCRIPTION, PRIORITY, TIMEFRAME, " + 
            "PROGRESS, GENRE, TASKTYPE, STARTEDDATE, COMPLETED, DUEDATE) VALUES (" + 
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    //SQL Strings, Exclusive to SelectPanel
    //Select all root tasks
    private final String ROOTTASKS = "SELECT T.TITLE, " + 
	"T.DESCRIPTION, " + 
        "TIMEFRAME.TITLE AS TIMEFRAME, " + 
        "GENRE.TITLE AS GENRE, " + 
        "PRIORITY.TITLE AS PRIORITY, " + 
        "PROGRESS.TITLE AS PROGRESS, " + 
        "TASKTYPE.TITLE AS TASKTYPE, " + 
	"T.CREATEDDATE, T.STARTEDDATE, T.COMPLETED, T.DUEDATE " +
        "FROM TASK T " + 
	"INNER JOIN TIMEFRAME ON T.TIMEFRAME = TIMEFRAME.REFID " + 
	"INNER JOIN GENRE ON T.GENRE = GENRE.REFID " + 
        "INNER JOIN PRIORITY ON T.PRIORITY = PRIORITY.REFID " + 
        "INNER JOIN PROGRESS ON T.PROGRESS = PROGRESS.REFID " +
        "INNER JOIN TASKTYPE ON T.TASKTYPE = TASKTYPE.REFID " +
        "WHERE PARENTID IS NULL"; //+ ";"
    //Additions for the Where clause of ROOTTASKS
    private final String TIMEFRAME = "AND TIMEFRAME.TITLE = ?";
    private final String GENRE = "AND GENRE.TITLE = ?";
    private final String PRIORITY = "AND PRIORITY.TITLE = ?";
    private final String PROGRESS = "AND PROGRESS.TITLE = ?";
    private final String TASKTYPE = "AND TASKTYPE.TITLE = ?";
    private final String CMPLTNULL = "AND T.COMPLETED IS NULL";
    private final String CMPLTNOTNULL = "AND T.COMPLETED IS NOT NULL";
    private final String STRTDDTNULL = "AND T.STARTEDDATE IS NULL";
    private final String STRTDDTNOTNULL = "AND T.STARTEDDATE IS NOT NULL";
    
    public Connection connect() {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(URL+DBNAME);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
    public void initializeDatabase() {
        System.out.println(URL+DBNAME);
        try (Connection conn = DriverManager.getConnection(URL+DBNAME)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                System.out.println("A new Count Up Database has been created.");
                String sql = Files.readString(Path.of(FILEPATH));
                System.out.println(sql.substring(0, 20));
                //stmt.addBatch(sql);
                //stmt.executeBatch();
                stmt.executeUpdate(sql);
                System.out.println("A new Count Up Database has been initialized.");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(GeneralJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}