/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbClasses;

/**
CREATE TABLE DETAIL (
	TASKID INTEGER NOT NULL,
	DETAIL_CATEGORY INTEGER NOT NULL,
	STEP_NUMBER INTEGER,
	DESCRIPTION TEXT NOT NULL,
	CREATED TIMESTAMP,
	STEP_DUEDATE TIMESTAMP,
	STEP_STARTED TIMESTAMP,
	STEP_DONE TIMESTAMP,
	PRIMARY KEY (TASKID, DESCRIPTION),
	UNIQUE KEY (TASKID, STEP_NUMBER),
    FOREIGN KEY (DETAIL_CATEGORY) REFERENCES DETAIL_CATEGORY(DCID),
    FOREIGN KEY (TASKID) REFERENCES TASK(TASKID)
);
 */
public class detail {
    
    private int taskID;
    private int category;
    private int stepNumber;
    private String description;
    private String created;
    private String stepDueDate;
    private String stepStarted;
    private String stepDone;
    
    public detail (int tsk, int ctgr, int stpNmbr, String dsc, String crtd, String stpDDt, String stpStrtd, String stpDn) {
        this.taskID = tsk;
        this.category = ctgr;
        this.stepNumber = stpNmbr;
        this.description = dsc;
        this.created = crtd;
        this.stepDueDate = stpDDt;
        this.stepStarted = stpStrtd;
        this.stepDone = stpDn;
    }
    
    public int getTaskID() {
        return taskID;
    }

    public int getCategory() {
        return category;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getCreated() {
        return created;
    }

    public String getStepDueDate() {
        return stepDueDate;
    }

    public String getStepStarted() {
        return stepStarted;
    }

    public String getStepDone() {
        return stepDone;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setStepDueDate(String stepDueDate) {
        this.stepDueDate = stepDueDate;
    }

    public void setStepStarted(String stepStarted) {
        this.stepStarted = stepStarted;
    }

    public void setStepDone(String stepDone) {
        this.stepDone = stepDone;
    }
    
    //public String updateDetail() {}
    
    //public String deleteDetail() {}
    
    //public static String selectDetail(int id, String desc) {}
    
    //public static String selectMultipleDetails(int id) {}
    
    //public String insertDetail() {}
    
}
