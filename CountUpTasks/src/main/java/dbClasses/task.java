/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbClasses;

/**
 *
 * @author marquis
 */
public class task {
    
    private int taskID;
    private String title;
    private String description;
    private String created; //timestamp
    private String started; //timestamp
    private String ended; //timestamp
    private String dueDate; //timestamp
    private int category;
    private int completeness;
    private int priority;
    private int timeframe;

    public task(int taskID, String title, String description, String created, String started, String ended, String dueDate, int category, int completeness, int priority, int timeframe) {
        this.taskID = taskID;
        this.title = title;
        this.description = description;
        this.created = created;
        this.started = started;
        this.ended = ended;
        this.dueDate = dueDate;
        this.category = category;
        this.completeness = completeness;
        this.priority = priority;
        this.timeframe = timeframe;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getCompleteness() {
        return completeness;
    }

    public void setCompleteness(int completeness) {
        this.completeness = completeness;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(int timeframe) {
        this.timeframe = timeframe;
    }
    
    //public String updateTask() {}
    
    //public String deleteTask() {}
    
    //public static String selectTask() {}
    
    //public String insertTask() {}
    
}
