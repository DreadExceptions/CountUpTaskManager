/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqliteJDBC;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author marquis
 */
public class Task {
    
    final String tsfrmt = "YYYY-MM-DD HH:MM:SS";
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
    
    public Task (int tsk, String ttl, String dscrpt,
            String prgrss, String prrt, String tsktp, String gnr,
            String tmfrm, String crtd, String strtd, String cmpltd,
            String ddt) {
        this.TaskID = tsk;
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
    
    public Task(int ParentID, String Title, String Description, int ProgressID, 
            int PrioityID, int TaskTypeID, int GenreID, int TimeframeID, 
            String CreatedDate, String StartedDate, String Completed, String DueDate) {
        this.ParentID = ParentID;
        this.Title = Title;
        this.Description = Description;
        this.ProgressID = ProgressID;
        this.PrioityID = PrioityID;
        this.TaskTypeID = TaskTypeID;
        this.GenreID = GenreID;
        this.TimeframeID = TimeframeID;
        this.CreatedDate = CreatedDate;
        this.StartedDate = StartedDate;
        this.Completed = Completed;
        this.DueDate = DueDate;
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

    protected Task (int TaskID, int ParentID) {
        this.TaskID = TaskID;
        this.ParentID = ParentID;
    }
    
    public Task () {
        this.Title = "32 Characters or less.";
        this.Description = "Aptly describe what you want to do.";
        this.ProgressID = 0;
        this.PrioityID = 0;
        this.TaskTypeID = 0;
        this.GenreID = 0;
        this.TimeframeID = 0;
        this.StartedDate = tsfrmt;
        this.Completed = tsfrmt;
        this.DueDate = tsfrmt;
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

    public String toStringMarkdown(String heading) {
        String md = heading + Title;
            if (Priority != null) {md += "\n **Priority**: " + Priority;}
            if (Progress != null) {md += "\n **Progress**: " + Progress;}
            if (Timeframe != null) {md += "\n **Time-frame**: " + Timeframe;}
            if (Genre != null) {md += "\n **Genre**: " + Genre;}
            if (TaskType != null) {md += "\n **Task Type**: " + TaskType;}
            if (CreatedDate != null) {md += "\n **Created Date**: " + CreatedDate;}
            if (StartedDate != null) {md += "\n **Started Date**: " + StartedDate;}
            if (Completed != null) {md += "\n **Completed**: " + Completed;}
            if (DueDate != null) {md += "\n **Due Date**: " + DueDate;}
            md += "\n **Description**: \n  " + Description;
        return md;
    }
    
    public void markDownCountUp(String heading, FileWriter fw) throws IOException{
        ArrayList<Task> Children = this.selectChildren();
        String task = this.toStringMarkdown(heading) + "\n";
        fw.write(task);
        
        if (!Children.isEmpty()) {
            if ( (heading + "      ").substring(0, 5).equals("######") ) {
                for (Task e : Children) {
                    e.markDownCountUp(heading + ">", fw);
                }
            } else {
                for (Task e : Children) {
                    e.markDownCountUp("#" + heading + ">", fw);
                }
            } //end else
        }
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
    
    public static ArrayList<Task> selectAllTasks() {
        GeneralJDBC jdbc = new GeneralJDBC();
        ArrayList<Task> taskSet = new ArrayList();
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getSELECTALLTASK());
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                taskSet.add(new Task(
                        rs.getInt("TASKID"), rs.getInt("PARENTID"), rs.getString("TITLE"),
                        rs.getString("DESCRIPTION"), rs.getString("PROGRESS"), rs.getString("PRIORITY"),
                        rs.getString("TASKTYPE"), rs.getString("GENRE"),
                        rs.getString("TIMEFRAME"), rs.getString("CREATEDDATE"), rs.getString("STARTEDDATE"),
                        rs.getString("COMPLETED"), rs.getString("DUEDATE")
                ));
            }//end While Loop
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return taskSet;
    }
    
    public static Task selectTask(int task) throws SQLException {
        GeneralJDBC jdbc = new GeneralJDBC();
        Connection conn = jdbc.connect();
        PreparedStatement pstmt = conn.prepareStatement(jdbc.getSELECTTASK());
        pstmt.setInt(1, task);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        Task rtrn = new Task(
                        rs.getInt("TASKID"), rs.getInt("PARENTID"), rs.getString("TITLE"),
                        rs.getString("DESCRIPTION"), rs.getString("PROGRESS"), rs.getString("PRIORITY"),
                        rs.getString("TASKTYPE"), rs.getString("GENRE"),
                        rs.getString("TIMEFRAME"), rs.getString("CREATEDDATE"), rs.getString("STARTEDDATE"),
                        rs.getString("COMPLETED"), rs.getString("DUEDATE"));
        return rtrn;
    }
    
    public ArrayList<Task> selectChildren(){
        GeneralJDBC jdbc = new GeneralJDBC();
        ArrayList<Task> taskSet = new ArrayList();
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getSELECTCHILDREN());
            pstmt.setInt(1, TaskID);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                taskSet.add(new Task(
                        rs.getInt("TASKID"), this.TaskID, rs.getString("TITLE"),
                        rs.getString("DESCRIPTION"), rs.getString("PROGRESS"), rs.getString("PRIORITY"),
                        rs.getString("TASKTYPE"), rs.getString("GENRE"),
                        rs.getString("TIMEFRAME"), rs.getString("CREATEDDATE"), rs.getString("STARTEDDATE"),
                        rs.getString("COMPLETED"), rs.getString("DUEDATE")
                ));
            }//end While Loop
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return taskSet;
    }
    
    public ArrayList<Task> selectChildrenShort(){
        GeneralJDBC jdbc = new GeneralJDBC();
        ArrayList<Task> taskSet = new ArrayList();
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getSELECTCHILDRENSHORT());
            pstmt.setInt(1, TaskID);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                taskSet.add(new Task(
                        rs.getInt("TASKID"), this.TaskID
                ));
            }//end While Loop
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return taskSet;
    }
    
    //might be able to make this function iterative:
    //If it is allowed to simply foreach and continue as it adds more
    //that might suffice instead of recursively calling
    public ArrayList<Task> findChildren(){
        ArrayList<Task> Children = this.selectChildren();
        ArrayList<Task> GrandChildren = new ArrayList();
        if (!Children.isEmpty()) {
            Children.forEach(e -> {
                GrandChildren.add(e);
                GrandChildren.addAll(e.findChildren());
            });
        }
        return GrandChildren;
    }
    
    public ArrayList<Task> findChildrenWithChildren(){
        ArrayList<Task> Parents = new ArrayList();
        ArrayList<Task> Children = this.selectChildrenShort();
        if (!Children.isEmpty()) {
            Parents.add(this);
            Children.forEach( e -> {
                Parents.addAll(e.findChildrenWithChildren());
            });
        }
        return Parents;
    }
    
    public boolean updateTask(ArrayList<FieldAccess> updts) {
        //UPDATETASK + WHERETASK
        GeneralJDBC jdbc = new GeneralJDBC();
        boolean success = true;
        String set = null;
        
        if (updts.isEmpty()) {return false;}
        
        for (FieldAccess updt : updts) {
            if (updt.getFieldName().equals("STARTEDDATE") || 
                    updt.getFieldName().equals("COMPLETED") || 
                    updt.getFieldName().equals("DUEDATE") ||
                    updt.getFieldName().equals("TITLE") ||
                    updt.getFieldName().equals("DESCRIPTION")) {
                set += updt.getFieldName() + " = \"" + updt.getFieldValue() + "\", ";
            } else {
                set += updt.getFieldName() + " = " + updt.getFieldValue() + " , ";
            }
        }
        
        set = set.substring(0, set.lastIndexOf(",")-2);
        
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
        GeneralJDBC jdbc = new GeneralJDBC();
        boolean success = true;        
        
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getINSERTTASK());
            pstmt.setString(1, this.Title);
            pstmt.setString(2, this.Description);
            pstmt.setInt(3, this.PrioityID);
            pstmt.setInt(4, this.TimeframeID);
            pstmt.setInt(5, this.ProgressID);
            pstmt.setInt(6, this.GenreID);
            pstmt.setInt(7, this.TaskTypeID);
            pstmt.setString(8, this.StartedDate);
            pstmt.setString(9, this.Completed);
            pstmt.setString(10, this.DueDate);
            int sccss = pstmt.executeUpdate();
            if (sccss == 0) {success = false;}
        } catch (SQLException e) {
            return false;
        }
        return success;
    }
    
    public static ArrayList<Task> selectRootTasks(int timeframe, int genre, int priority,
            int tasktype, int progress, int completed, int started) {
        
        GeneralJDBC jdbc = new GeneralJDBC();
        
        String sql = jdbc.getROOTTASKS();
        ArrayList<Integer> params = new ArrayList();
        ArrayList<Task> taskSet = new ArrayList();
                
        if (timeframe >= 0) {
            sql += jdbc.getTIMEFRAME();
            params.add(timeframe);
        }
        if (genre >= 0) {
            sql += jdbc.getGENRE();
            params.add(genre);
        }
        if (priority >= 0) {
            sql += jdbc.getPRIORITY();
            params.add(priority);
        }
        if (tasktype >= 0) {
            sql += jdbc.getTASKTYPE();
            params.add(tasktype);
        }
        if (progress >= 0) {
            sql += jdbc.getPROGRESS();
            params.add(progress);
        }
        if (completed == 1) {
            sql += jdbc.getCMPLTNOTNULL();
        } else if (completed == -1) {
            sql += jdbc.getCMPLTNULL();
        }
        if (started == 1) {
            sql += jdbc.getSTRTDDTNOTNULL();
        } else if (started == -1) {
            sql += jdbc.getSTRTDDTNULL();
        }
        
        try {
            Connection conn = jdbc.connect();
            System.out.println(sql);
            PreparedStatement pstmt = conn.prepareStatement(sql + " ;");
            for (int i = 0; i < params.size(); i++){
                System.out.println((i+1) + " " + params.get(i));
                pstmt.setInt(i+1, params.get(i));
            }
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                taskSet.add(new Task(
                        rs.getInt("TASKID"), rs.getString("TITLE"),
                        rs.getString("DESCRIPTION"), rs.getString("PROGRESS"), rs.getString("PRIORITY"),
                        rs.getString("TASKTYPE"), rs.getString("GENRE"),
                        rs.getString("TIMEFRAME"), rs.getString("CREATEDDATE"), rs.getString("STARTEDDATE"),
                        rs.getString("COMPLETED"), rs.getString("DUEDATE")
                ));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return taskSet;
        
    }
    
    public static ArrayList<Task> selectRootTasks() {
        
        GeneralJDBC jdbc = new GeneralJDBC();
        ArrayList<Task> taskSet = new ArrayList();
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getROOTTASKS() + ";");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                taskSet.add(new Task(
                        rs.getInt("TASKID"), rs.getString("TITLE"),
                        rs.getString("DESCRIPTION"), rs.getString("PROGRESS"), rs.getString("PRIORITY"),
                        rs.getString("TASKTYPE"), rs.getString("GENRE"),
                        rs.getString("TIMEFRAME"), rs.getString("CREATEDDATE"), rs.getString("STARTEDDATE"),
                        rs.getString("COMPLETED"), rs.getString("DUEDATE")
                ));
            }//end While Loop
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return taskSet;
        
    }
    
}
