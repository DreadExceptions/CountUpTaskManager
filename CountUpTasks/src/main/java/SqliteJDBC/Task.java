/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqliteJDBC;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author marquis
 */
public class Task {
    
    final String tsfrmt = "yyyy-MM-dd HH:mm:ss";
    int TaskID;
    int ParentID;
    String Title;
    String Description;
    String Progress;
    int ProgressID;
    String Priority;
    int PriorityID;
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
        this.PriorityID = PrioityID;
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
        this.PriorityID = PrioityID;
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

    protected Task (int TaskID, int ParentID, String title) {
        this.TaskID = TaskID;
        this.ParentID = ParentID;
        this.Title = title;
    }
    
    public Task () {
        this.Title = "New Task";
        this.Description = "Aptly describe what you want to do.";
        this.ProgressID = 0;
        this.PriorityID = 0;
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
    public int getPriorityID() {
        return PriorityID;
    }
    public void setPriorityID(int PrioityID) {
        this.PriorityID = PrioityID;
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
        return "Task{" + "TaskID=" + TaskID + 
                ", ParentID=" + ParentID + ", Title=" + Title + ", Description=" + 
                Description + ", Progress=" + Progress + ", ProgressID=" + 
                ProgressID + ", Priority=" + Priority + ", PriorityID=" + 
                PriorityID + ", TaskType=" + TaskType + ", TaskTypeID=" + 
                TaskTypeID + ", Genre=" + Genre + ", GenreID=" + GenreID + 
                ", Timeframe=" + Timeframe + ", TimeframeID=" + TimeframeID + 
                ", CreatedDate=" + CreatedDate + ", StartedDate=" + StartedDate + 
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
    
    public void taskToMarkDown(){
        Date dt = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy.HH:mm:ss");
        String saveFile = GeneralJDBC.FOLDERWRITE + this.getTitle() + formatter.format(dt) + ".md";
        File md = new File(saveFile);
        try (FileWriter fw = new FileWriter(md)) {
            this.markDownCountUp("# ", fw);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame fr = new JFrame("Notification");
        JOptionPane.showMessageDialog(fr, "A file of tasks has been created at: " + saveFile);
    }
    
    public static void taskToMarkDown(String FileName){
        ArrayList<Task> tsks = selectRootTasks();
        Date dt = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy.HH:mm:ss");
        String saveFile = GeneralJDBC.FOLDERWRITE + "CountUpTasks" + formatter.format(dt) + ".md";
        System.out.println(formatter.format(dt));
        File md = new File(saveFile);
        try (FileWriter fw = new FileWriter(md)) {
            for (Task e : tsks) {
                e.markDownCountUp("# ", fw);
            }
        } catch (IOException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame fr = new JFrame("Notification");
        JOptionPane.showMessageDialog(fr, "A file of tasks has been created at: " + saveFile);
    }
    
    public boolean deleteTask() {
        //Will delete a specific task.
        //Will only be successful if the task has no children.
        GeneralJDBC jdbc = new GeneralJDBC();
        int sccss;
        
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getDELETETASK());
            pstmt.setInt(1, this.TaskID);
            sccss = pstmt.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, sccss + " Tasks were deleted");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "The following error was given: \n" + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteChildren() {
        //Deletes the children of a given task.
        //Will only be successful if the children of a task have no children.
        GeneralJDBC jdbc = new GeneralJDBC();
        int sccss;
        
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getDELETECHILDREN());
            pstmt.setInt(1, this.TaskID);
            sccss = pstmt.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, sccss + " Children Tasks were deleted");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "The following error was given: \n" + e.getMessage());
            return false;
        }
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
            
            conn.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return taskSet;
    }
    
    public static Task selectTask(int task)  {
        GeneralJDBC jdbc = new GeneralJDBC();
        Task rtrn = new Task();
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getSELECTTASK());
            pstmt.setInt(1, task);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            rtrn = new Task(
                        rs.getInt("TASKID"), rs.getInt("PARENTID"), rs.getString("TITLE"),
                        rs.getString("DESCRIPTION"), rs.getString("PROGRESS"), //rs.getInt("PROGRESSID"),
                        rs.getString("PRIORITY"), //rs.getInt("PRIORITYID"),
                        rs.getString("TASKTYPE"), //rs.getInt("TASKTYPEID"), 
                        rs.getString("GENRE"), //rs.getInt("GENREID"),
                        rs.getString("TIMEFRAME"), //rs.getInt("TIMEFRAMEID"),
                        rs.getString("CREATEDDATE"), rs.getString("STARTEDDATE"),
                        rs.getString("COMPLETED"), rs.getString("DUEDATE"));
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rtrn;
    }
    
    public static Task selectTask(int parent, String task) {
        GeneralJDBC jdbc = new GeneralJDBC();
        Task rtrn = new Task();
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getSELECTTASKTITLE());
            pstmt.setInt(1, parent);
            pstmt.setString(2, task);
            ResultSet rs = pstmt.executeQuery();
            rtrn = new Task(rs.getInt("TASKID"), rs.getInt("PARENTID"), rs.getString("TITLE"));
            rtrn.setCreatedDate(rs.getString("CREATEDDATE"));
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
            
            conn.close();
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
                        rs.getInt("TASKID"), this.TaskID, rs.getString("TITLE")
                ));
            }//end While Loop
            conn.close();
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
    
    public boolean updateTask(Task update) {
        //UPDATETASK + WHERETASK
        GeneralJDBC jdbc = new GeneralJDBC();
        String set = "";
        ArrayList<FieldAccess> vals = new ArrayList();
        
        if (!update.getTitle().equals(this.getTitle())) {
            System.out.println("SUCCESS");
            set += "TITLE = ? , ";
            vals.add(new FieldAccess("String", update.getTitle()));
        }
        if (!update.getDescription().equals(this.getDescription())) {
            set += "DESCRIPTION = ? , ";
            vals.add(new FieldAccess("String", update.getDescription()));
        }
        if (!update.getPriority().equals(this.getPriority())) {
            set += "PRIORITY = ? , ";
            update.setPriorityID(
                Reference.findReferenceViaTitle(Reference.referencesSQL("PRIORITY"), 
                update.getPriority()).getRefID());
            vals.add(new FieldAccess("int", Integer.toString(update.getPriorityID())));
        }
        if (!update.getProgress().equals(this.getProgress())) {
            set += "PROGRESS = ? , ";
            update.setProgressID(
                Reference.findReferenceViaTitle(Reference.referencesSQL("PROGRESS"), 
                update.getProgress()).getRefID());
            vals.add(new FieldAccess("int", Integer.toString(update.getProgressID())));
        }
        if (!update.getTimeframe().equals(this.getTimeframe())) {
            set += "TIMEFRAME = ? , ";
            update.setTimeframeID(
                Reference.findReferenceViaTitle(Reference.referencesSQL("TIMEFRAME"), 
                update.getTimeframe()).getRefID());
            vals.add(new FieldAccess("int", Integer.toString(update.getTimeframeID())));
        }
        if (!update.getGenre().equals(this.getGenre())) {
            set += "GENRE = ? , ";
            update.setGenreID(
                Reference.findReferenceViaTitle(Reference.referencesSQL("GENRE"), 
                update.getGenre()).getRefID());
            vals.add(new FieldAccess("int", Integer.toString(update.getGenreID())));
        }
        if (!update.getTaskType().equals(this.getTaskType())) {
            set += "TASKTYPE = ? , ";
            update.setTaskTypeID(
                Reference.findReferenceViaTitle(Reference.referencesSQL("TASKTYPE"), 
                update.getTaskType()).getRefID());
            vals.add(new FieldAccess("int", Integer.toString(update.getTaskTypeID())));
        }

        if (update.getStartedDate()!= null && !update.getStartedDate().equals(this.getStartedDate())) {
            set += "STARTEDDATE = ? , ";
            vals.add(new FieldAccess("String", update.getStartedDate()));
        }
        if (update.getCompleted()!= null && !update.getCompleted().equals(this.getCompleted())) {
            set += "COMPLETED = ? , ";
            vals.add(new FieldAccess("String", update.getCompleted()));
        }
        if (update.getDueDate()!= null && !update.getDueDate().equals(this.getDueDate())) {
            set += "DUEDATE = ? , ";
            vals.add(new FieldAccess("String", update.getDueDate()));
        }
        
        if (!vals.isEmpty()) {//begin if for try-catch
        
            try {//begin try-catch
                Connection conn = jdbc.connect();
                set = set.substring(0, set.length()-2);
                PreparedStatement pstmt = conn.prepareStatement(jdbc.getUPDATETASK() + set + jdbc.getWHERETASK());
                vals.add(new FieldAccess("int", Integer.toString(this.TaskID)));
                for (int i = 0; i < vals.size(); i++) {
                    switch (vals.get(i).getFieldName()) {
                        case "String":
                            String vl = vals.get(i).getFieldValue();
                            if (vl.equals("null")) {
                                pstmt.setNull(i+1, java.sql.Types.TIMESTAMP);
                            } else {
                                pstmt.setString(i+1, vals.get(i).getFieldValue());
                            }
                            break;
                        case "int": pstmt.setInt(i+1, Integer.parseInt(vals.get(i).getFieldValue())); break;
                        default: return false;
                    }
                }                
                System.out.println(jdbc.getUPDATETASK() + set + jdbc.getWHERETASK());
                int sccss = pstmt.executeUpdate();
                conn.close();
                return sccss != 0;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println(jdbc.getUPDATETASK() + set + jdbc.getWHERETASK());
                return false;
            } //end try-catch
        }//end if for try-catch
        return false;
        
    }
    
    public boolean insertIntoTask() {
        GeneralJDBC jdbc = new GeneralJDBC();
        boolean success = true;        
        
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getINSERTTASK());
            pstmt.setString(1, this.Title);
            pstmt.setInt(2, this.ParentID);
            pstmt.setString(3, this.Description);
            pstmt.setInt(4, this.PriorityID);
            pstmt.setInt(5, this.TimeframeID);
            pstmt.setInt(6, this.ProgressID);
            pstmt.setInt(7, this.GenreID);
            pstmt.setInt(8, this.TaskTypeID);
            pstmt.setString(9, this.StartedDate);
            pstmt.setString(10, this.Completed);
            pstmt.setString(11, this.DueDate);
            int sccss = pstmt.executeUpdate();
            if (sccss == 0) {success = false;}
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return success;
    }
    
    public static ArrayList<Task> selectRootTasks(String title, int priority, int progress, int timeframe,
            int genre, int tasktype, int started, int completed) {
        
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
        
        if (!title.isBlank()) {
            sql += jdbc.getTITLE();
        }
        
        try {
            Connection conn = jdbc.connect();
            System.out.println(sql);
            PreparedStatement pstmt = conn.prepareStatement(sql + " ;");
            for (int i = 0; i < params.size(); i++){
                System.out.println((i+1) + " " + params.get(i));
                pstmt.setInt(i+1, params.get(i));
            }
            if (!title.isBlank()) {
                int z = params.size() + 1;
                System.out.println(z);
                pstmt.setString(z, "%" + title + "%");
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
            conn.close();
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
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return taskSet;
        
    }
    
    public static Task retreiveTaskFromList(ArrayList<Task> taskSet, String title){
        for (Task e : taskSet) {
            if (e.getTitle().equals(title)) {
                return e;
            }
        }
        return new Task();
    }
    
    public boolean duplicateTaskSQL(int newParentID) {
        String newTitle = this.getTitle();
        
        if (newTitle.length() > 27) {
            newTitle = this.Title.substring(0, 26);
        }
        newTitle = newTitle + " Copy";
        
        GeneralJDBC jdbc = new GeneralJDBC();
        
        try {
            Connection conn = jdbc.connect();
            PreparedStatement pstmt = conn.prepareStatement(jdbc.getINSERTINTOSELECT());
            pstmt.setString(1, newTitle);
            pstmt.setInt(2, newParentID);
            pstmt.setInt(3, this.TaskID);
            int sccss = pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "The following error was given: \n" + e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
        
        int newTaskID = Task.selectTask(newParentID, newTitle).getTaskID();
        
        ArrayList<Task> childTasks = this.findChildren();
        for (Task e : childTasks) {
            if (!e.duplicateTaskSQL(newTaskID)) {
                return false;
            }
        }
        
        return true;
    }
    
    public void copy(Task original) {
        this.TaskID = original.TaskID;
        this.ParentID = original.ParentID;
        this.Title = original.Title;
        this.Description = original.Description;
        this.Progress = original.Progress;
        this.ProgressID = original.ProgressID;
        this.Priority = original.Priority;
        this.PriorityID = original.PriorityID;
        this.TaskType = original.TaskType;
        this.TaskTypeID = original.TaskTypeID;
        this.Genre = original.Genre;
        this.GenreID = original.GenreID;
        this.Timeframe = original.Timeframe;
        this.TimeframeID = original.TimeframeID;
        this.CreatedDate = original.CreatedDate;
        this.StartedDate = original.StartedDate;
        this.Completed = original.Completed;
        this.DueDate = original.DueDate;
    }
    
}
