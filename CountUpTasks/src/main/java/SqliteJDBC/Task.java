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
public class Task {
    
    int TaskID;
    int ParentID;
    String Title;
    String Description;
    String Progress;
    int ProgressID;
    String Priority;
    int PrioityID;
    String TaskType;
    int TaskTypeID;
    String Genre;
    int GenreID;
    String Timeframe;
    int TimeframeID;
    String CreatedDate;
    String StartedDate;
    String Completed;
    String DueDate;
    
    public Task (int tsk, int prnt, String ttl, String dscrpt,
            String prgrss, String prrt, String tsktp, String gnr,
            String tmfrm, String crtd, String strtd, String cmpltd,
            String ddt) {
        this.TaskID = tsk;
        this.ParentID  = prnt;
        this.Title = ttl;
        this.Description = dscrpt;
        this.Progress = prgrss;
        this.Priority = prrt;
        this.TaskType = tsktp;
        this.Genre = gnr;
        this.Timeframe = tmfrm;
        this.CreatedDate = crtd;
        this.StartedDate = strtd;
        this.Completed = cmpltd;
        this.DueDate = ddt;
	}

    public Task (int TaskID, int ParentID, String Title, String Description, 
            String Progress, int ProgressID, String Priority, int PrioityID, 
            String TaskType, int TaskTypeID, String Genre, int GenreID, 
            String Timeframe, int TimeframeID, String CreatedDate, 
            String StartedDate, String Completed, String DueDate) {
        this.TaskID = TaskID;
        this.ParentID = ParentID;
        this.Title = Title;
        this.Description = Description;
        this.Progress = Progress;
        this.ProgressID = ProgressID;
        this.Priority = Priority;
        this.PrioityID = PrioityID;
        this.TaskType = TaskType;
        this.TaskTypeID = TaskTypeID;
        this.Genre = Genre;
        this.GenreID = GenreID;
        this.Timeframe = Timeframe;
        this.TimeframeID = TimeframeID;
        this.CreatedDate = CreatedDate;
        this.StartedDate = StartedDate;
        this.Completed = Completed;
        this.DueDate = DueDate;
    }

    public Task (int TaskID, int ParentID) {
        this.TaskID = TaskID;
        this.ParentID = ParentID;
    }
    
    public int getTaskID() {
        return TaskID;
    }
    public void setTaskID(int TaskID) {
        this.TaskID = TaskID;
    }
    public int getParentID() {
        return ParentID;
    }
    public void setParentID(int ParentID) {
        this.ParentID = ParentID;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }
    public String getProgress() {
        return Progress;
    }
    public void setProgress(String Progress) {
        this.Progress = Progress;
    }
    public int getProgressID() {
        return ProgressID;
    }
    public void setProgressID(int ProgressID) {
        this.ProgressID = ProgressID;
    }
    public String getPriority() {
        return Priority;
    }
    public void setPriority(String Priority) {
        this.Priority = Priority;
    }
    public int getPrioityID() {
        return PrioityID;
    }
    public void setPrioityID(int PrioityID) {
        this.PrioityID = PrioityID;
    }
    public String getTaskType() {
        return TaskType;
    }
    public void setTaskType(String TaskType) {
        this.TaskType = TaskType;
    }
    public int getTaskTypeID() {
        return TaskTypeID;
    }
    public void setTaskTypeID(int TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }
    public String getGenre() {
        return Genre;
    }
    public void setGenre(String Genre) {
        this.Genre = Genre;
    }
    public int getGenreID() {
        return GenreID;
    }
    public void setGenreID(int GenreID) {
        this.GenreID = GenreID;
    }
    public String getTimeframe() {
        return Timeframe;
    }
    public void setTimeframe(String Timeframe) {
        this.Timeframe = Timeframe;
    }
    public int getTimeframeID() {
        return TimeframeID;
    }
    public void setTimeframeID(int TimeframeID) {
        this.TimeframeID = TimeframeID;
    }
    public String getCreatedDate() {
        return CreatedDate;
    }
    public void setCreatedDate(String CreatedDate) {
        this.CreatedDate = CreatedDate;
    }
    public String getStartedDate() {
        return StartedDate;
    }
    public void setStartedDate(String StartedDate) {
        this.StartedDate = StartedDate;
    }
    public String getCompleted() {
        return Completed;
    }
    public void setCompleted(String Completed) {
        this.Completed = Completed;
    }
    public String getDueDate() {
        return DueDate;
    }
    public void setDueDate(String DueDate) {
        this.DueDate = DueDate;
    }

    @Override
    public String toString() {
        return "Task{" + "TaskID=" + TaskID + ", ParentID=" + ParentID + 
                ", Title=" + Title + ", Description=" + Description + ", Progress=" + Progress + 
                ", Priority=" + Priority + ", TaskType=" + TaskType + ", Genre=" + Genre + 
                ", Timeframe=" + Timeframe + ", CreatedDate=" + CreatedDate + ", StartedDate=" + StartedDate + 
                ", Completed=" + Completed + ", DueDate=" + DueDate + '}';
    }

    public String toStringMarkdown() {
        return  "# " + Title +
                "\n Priority: " + Priority + 
                "\n Progress: " + Progress + 
                "\n Timeframe: " + Timeframe +
                "\n Genre: " + Genre + 
                "\n TaskType: " + TaskType +
                "\n CreatedDate: " + CreatedDate +
                "\n StartedDate: " + StartedDate + 
                "\n Completed: " + Completed + 
                "\n DueDate: " + DueDate + 
                "\n #### Description \n" + Description;
    }
    
    public boolean deleteTask() {
        //Will delete a specific task.
        //Will only be successful if the task has no children.
        GeneralJDBC jdbc = new GeneralJDBC();
        boolean success = true;
        
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getDELETETASK());
            pstmt.setInt(1, this.TaskID);
            int sccss = pstmt.executeUpdate();
            if (sccss == 0) {success = false;}
        } catch (SQLException e) {
            return false;
        }
        return success;
    }
    
    public boolean deleteChildren() {
        //Deletes the children of a given task.
        //Will only be successful if the children of a task have no children.
        GeneralJDBC jdbc = new GeneralJDBC();
        boolean success = true;
        
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getDELETECHILDREN());
            pstmt.setInt(1, this.TaskID);
            int sccss = pstmt.executeUpdate();
            if (sccss == 0) {success = false;}
        } catch (SQLException e) {
            return false;
        }
        return success;
    }
    
    /*
    int tsk, int prnt, String ttl, String dscrpt,
            String prgrss, String prrt, String tsktp, String gnr,
            String tmfrm, String crtd, String strtd, String cmpltd,
            String ddt
    */
    
    public ArrayList<Task> selectChildren(){
        GeneralJDBC jdbc = new GeneralJDBC();
        ArrayList<Task> taskSet = new ArrayList();
        
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getSELECTREF() + tblNm + ";");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                taskSet.add(new Task(
                        rs.getInt("TASKID"), this.TaskID, rs.getString("TITLE"),
                        rs.getString("DESCRIPTION"), rs.getString("PROGRESS"), rs.getString("PRIORITY"),
                        rs.getString("TASKTYPE"), rs.getString("GENRE"),
                        rs.getString("TIMEFRAME"), rs.getString("CREATED"), rs.getString("STARTEDDATE"),
                        rs.getString("COMPLETED"), rs.getString("DUEDATE")
                ));
            }//end While Loop
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return taskSet;
    }
    
    public ArrayList<Task> recursiveChildrenFind(){
        
    }
    
    public boolean updateTask(ArrayList<FieldAccess> updts) {
        //UPDATETASK + WHERETASK
        GeneralJDBC jdbc = new GeneralJDBC();
        boolean success = true;
        String set = null;
        
        if (updts.isEmpty()) {return false;}
        
        set = updts.stream().map(updt -> updt.getFieldName() + " = " + updt.getFieldValue()).reduce(set, String::concat);
        
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getUPDATETASK() + set + jdbc.getWHERETASK());
            pstmt.setInt(1, this.TaskID);
            int sccss = pstmt.executeUpdate();
            if (sccss == 0) {success = false;}
        } catch (SQLException e) {
            return false;
        }
        return success;
        
    }
    
    public boolean insertIntoTask() {
        
    }
    
}
