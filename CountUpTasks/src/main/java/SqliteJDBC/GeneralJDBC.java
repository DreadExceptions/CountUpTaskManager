
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
public class GeneralJDBC { //class cannot be used outside of it's own package
    
    private String DBNAME;
    
    protected GeneralJDBC(String dbnm) {
        this.DBNAME = dbnm;
    }
    
    public GeneralJDBC () {
        this.DBNAME = "CountUpLite.db";
    }

    public String getSELECTREF() {
        return SELECTREF;
    }

    public String getSELECTTASK() {
        return SELECTTASK;
    }

    public String getSELECTCHILDREN() {
        return SELECTCHILDREN;
    }

    public String getUPDATETASK() {
        return UPDATETASK;
    }

    public String getDELETETASK() {
        return DELETETASK;
    }

    public String getDELETECHILDREN() {
        return DELETECHILDREN;
    }

    public String getINSERTTASK() {
        return INSERTTASK;
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
    
    public String getWHERETASK() {
        return WHERETASK;
    }
    
    //JDBC Access variables
    private final String FILEPATH = "/home/marquis/Code/CountUpTaskManager/Database/dbCreation.sql";
    //String DBNAME = "CountUpLite.db";
    private final String URL = "jdbc:sqlite:/home/marquis/Code/CountUpTaskManager/Database/" + DBNAME;
    
    //SQL Strings, General
    //Get reference variables
    private String SELECTREF = "SELECT REFID, TITLE FROM ";// + table name + ";"
    //Get Specific task
    private String SELECTTASK = "SELECT * FROM task WHERE taskID = ? ;";
    //Get Children Tasks
    private String SELECTCHILDREN = "SELECT T.TITLE, " + 
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
    //SQL Strings, Exclusive to AddEditPanel
    //Update Task
    private String UPDATETASK = "UPDATE task SET ";
    private String WHERETASK = " WHERE taskID = ? ;";
    //Delete Task
    private String DELETETASK = "DELETE FROM task WHERE taskID = ? ;";
    //Delete Children Tasks
    private String DELETECHILDREN = "DELETE FROM task WHERE parentID = ? ;";
    //Insert Tasks
    private String INSERTTASK = "INSERT INTO TASK (TITLE, DESCRIPTION, PRIORITY, TIMEFRAME, " + 
            "PROGRESS, GENRE, TASKTYPE, STARTEDDATE, COMPLETED, DUEDATE) VALUES (" + 
            ":TTLE, :DSCR, :PRRT, :TMFR, :PRGR, :GNRE, :TSKT, :STRT, :CMPL, :DDTE);";
    //SQL Strings, Exclusive to SelectPanel
    //Select all root tasks
    private String ROOTTASKS = "SELECT T.TITLE, " + 
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
    private String TIMEFRAME = "AND TIMEFRAME.TITLE = ?";
    private String GENRE = "AND GENRE.TITLE = ?";
    private String PRIORITY = "AND PRIORITY.TITLE = ?";
    private String PROGRESS = "AND PROGRESS.TITLE = ?";
    private String TASKTYPE = "AND TASKTYPE.TITLE = ?";
    private String CMPLTNULL = "AND T.COMPLETED IS NULL";
    private String CMPLTNOTNULL = "AND T.COMPLETED IS NOT NULL";
    private String STRTDDTNULL = "AND T.STARTEDDATE IS NULL";
    private String STRTDDTNOTNULL = "AND T.STARTEDDATE IS NOT NULL";
    
    public Connection connect() {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
}