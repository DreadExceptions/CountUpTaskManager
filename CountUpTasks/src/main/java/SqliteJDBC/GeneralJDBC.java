
package SqliteJDBC;
import java.io.File;
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
    
    public final String DBSTART = System.getProperty("user.home") + 
            "/Code/CountUpTaskManager/CountUpTasks/src/main/java/SqliteJDBC/dbCreation.sql";
    public final String PATH = System.getProperty("user.home") + "/.config/";
    public final String URL = "jdbc:sqlite:" + System.getProperty("user.home") + "/.config/";
    public static final String FOLDERWRITE = System.getProperty("user.home") + "/Documents/";
    
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
    
    public String getTITLE() {
        return TITLE;
    }
    
    public String getSELECTTASKTITLE() {
        return SELECTTASKTITLE;
    }
    
    public String getINSERTINTOSELECT() {
        return INSERTINTOSELECT;
    }
    
    //SQL Strings, General
    //Get reference variables
    private final String SELECTREF = "SELECT REFID, TITLE, DESCRIPTION FROM ";// + table name + ";"
    //Get Specific task
    private final String SELECTTASK = "SELECT T.TASKID, T.TITLE, " + 
        "T.PARENTID, " +
	"T.DESCRIPTION, " + 
        //"T.TIMEFRAME AS TIMEFRAMEID" +
        "TIMEFRAME.TITLE AS TIMEFRAME, " + 
        //"T.GENRE AS GENREID" +
        "GENRE.TITLE AS GENRE, " + 
        //"T.PRIORITY AS PRIORITYID" +
        "PRIORITY.TITLE AS PRIORITY, " + 
        //"T.PROGRESS AS PROGRESSID" +
        "PROGRESS.TITLE AS PROGRESS, " + 
        //"T.TASKTYPE AS TASKTYPEID" +
        "TASKTYPE.TITLE AS TASKTYPE, " + 
	"T.CREATEDDATE, T.STARTEDDATE, T.COMPLETED, T.DUEDATE " +
        "FROM TASK T " + 
	"INNER JOIN TIMEFRAME ON T.TIMEFRAME = TIMEFRAME.REFID " + 
	"INNER JOIN GENRE ON T.GENRE = GENRE.REFID " + 
        "INNER JOIN PRIORITY ON T.PRIORITY = PRIORITY.REFID " + 
        "INNER JOIN PROGRESS ON T.PROGRESS = PROGRESS.REFID " +
        "INNER JOIN TASKTYPE ON T.TASKTYPE = TASKTYPE.REFID " +
        "WHERE T.TASKID = ? ;";
    private final String SELECTTASKTITLE = "SELECT TASKID, PARENTID, TITLE, " +
            "CREATEDDATE FROM TASK WHERE PARENTID = ? AND TITLE = ?;";
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
    private final String SELECTCHILDRENSHORT = "SELECT TASKID, TITLE FROM TASK WHERE PARENTID = ? ";
    public final String SELECTALLTASK = "SELECT * FROM TASK;";
    //SQL Strings, Exclusive to AddEditPanel
    //Update Task
    private final String UPDATETASK = "UPDATE TASK SET ";
    private final String WHERETASK = " WHERE TASKID = ? ;";
    //Delete Task
    private final String DELETETASK = "DELETE FROM task WHERE taskID = ? ;";
    //Delete Children Tasks
    private final String DELETECHILDREN = "DELETE FROM task WHERE parentID = ? ;";
    //Insert Tasks
    private final String INSERTTASK = "INSERT INTO TASK (TITLE, DESCRIPTION, PRIORITY, PROGRESS, " + 
            "TIMEFRAME, GENRE, TASKTYPE, STARTEDDATE, COMPLETED, DUEDATE) VALUES (" + 
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
    private final String TITLE = " AND T.TITLE LIKE ?";
    private final String TIMEFRAME = " AND T.TIMEFRAME = ?";
    private final String GENRE = " AND T.GENRE = ?";
    private final String PRIORITY = " AND T.PRIORITY = ?";
    private final String PROGRESS = " AND T.PROGRESS = ?";
    private final String TASKTYPE = " AND T.TASKTYPE = ?";
    private final String CMPLTNULL = " AND T.COMPLETED IS NULL";
    private final String CMPLTNOTNULL = " AND T.COMPLETED IS NOT NULL";
    private final String STRTDDTNULL = " AND T.STARTEDDATE IS NULL";
    private final String STRTDDTNOTNULL = " AND T.STARTEDDATE IS NOT NULL";
    
    //Insert Into Select for Duplicate
    private final String INSERTINTOSELECT = "INSERT INTO TASK " + 
            "(TITLE, PARENTID, TIMEFRAME, GENRE, PRIORITY, PROGRESS, " + 
            "TASKTYPE, DESCRIPTION)" +
            "SELECT ? AS TITLE, ? AS PARENTID, TIMEFRAME, GENRE, PRIORITY," + 
            "PROGRESS, TASKTYPE, DESCRIPTION " + 
            "FROM TASK WHERE TASKID = ? ;";
    
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
        File f = new File(PATH+DBNAME);
        if(!f.isFile()) {
            try (Connection conn = DriverManager.getConnection(URL+DBNAME)) {
                if (conn != null) {
                    Statement stmt = conn.createStatement();
                    String sql = Files.readString(Path.of(DBSTART));
                    stmt.executeUpdate(sql);
                }
                conn.close();
            } catch (SQLException | IOException ex) {
                Logger.getLogger(GeneralJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
    
    
    
}