
package SqliteJDBC;
import java.sql.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marquis
 */
public class GeneralJDBC { //class cannot be used outside of it's own package
    
    private final String DBNAME;
    
    protected GeneralJDBC(String dbnm) {
        this.DBNAME = dbnm;
    }
    
    public GeneralJDBC () {
        this.DBNAME = "CountUpLite.db";
    }

    //JDBC Access variables
    public final String FILEPATH = System.getProperty("user.home") + "/Code/CountUpTaskManager/Database/dbCreation.sql";
    public final String URL = "jdbc:sqlite:" + System.getProperty("user.home") + "/.config/";
    
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

    public String getROOTTASKS() {
        return ROOTTASKS;
    }

    public String getTIMEFRAME() {
        return TIMEFRAME;
    }

    public String getGENRE() {
        return GENRE;
    }

    public String getPRIORITY() {
        return PRIORITY;
    }

    public String getPROGRESS() {
        return PROGRESS;
    }

    public String getTASKTYPE() {
        return TASKTYPE;
    }

    public String getCMPLTNULL() {
        return CMPLTNULL;
    }

    public String getCMPLTNOTNULL() {
        return CMPLTNOTNULL;
    }

    public String getSTRTDDTNULL() {
        return STRTDDTNULL;
    }

    public String getSTRTDDTNOTNULL() {
        return STRTDDTNOTNULL;
    }
    
    public String getSELECTALLTASK() {
        return SELECTALLTASK;
    }
    
    //SQL Strings, General
    //Get reference variables
    private final String SELECTREF = "SELECT REFID, TITLE, DESCRIPTION FROM ";// + table name + ";"
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
    public final String SELECTALLTASK = "SELECT * FROM TASK;";
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
    private final String ROOTTASKS = "SELECT T.TASKID, T.TITLE, " + 
	"T.DESCRIPTION, " + 
        "TIMEFRAME.TITLE AS TIMEFRAME, " + 
        "GENRE.TITLE AS GENRE, " + 
        "PRIORITY.TITLE AS PRIORITY, " + 
        "PROGRESS.TITLE AS PROGRESS, " + 
        "TASKTYPE.TITLE AS TASKTYPE, " + 
	"CREATEDDATE, STARTEDDATE, COMPLETED, DUEDATE " +
        "FROM TASK T " + 
	"INNER JOIN TIMEFRAME ON T.TIMEFRAME = TIMEFRAME.REFID " + 
	"INNER JOIN GENRE ON T.GENRE = GENRE.REFID " + 
        "INNER JOIN PRIORITY ON T.PRIORITY = PRIORITY.REFID " + 
        "INNER JOIN PROGRESS ON T.PROGRESS = PROGRESS.REFID " +
        "INNER JOIN TASKTYPE ON T.TASKTYPE = TASKTYPE.REFID " +
        "WHERE PARENTID = 0"; //+ ";"
    //Additions for the Where clause of ROOTTASKS
    private final String TIMEFRAME = " AND TIMEFRAME = ?";
    private final String GENRE = " AND GENRE = ?";
    private final String PRIORITY = " AND PRIORITY = ?";
    private final String PROGRESS = " AND PROGRESS = ?";
    private final String TASKTYPE = " AND TASKTYPE = ?";
    private final String CMPLTNULL = " AND T.COMPLETED IS NULL";
    private final String CMPLTNOTNULL = " AND T.COMPLETED IS NOT NULL";
    private final String STRTDDTNULL = " AND T.STARTEDDATE IS NULL";
    private final String STRTDDTNOTNULL = " AND T.STARTEDDATE IS NOT NULL";
    
    protected Connection connect() {
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