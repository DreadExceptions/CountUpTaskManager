Objects:

public class Task {
	int TaskID;
	int ParentID;
	String Title;
	String Description;
	String Progress;
	String Priority;
	String TaskType;
	String Genre;
	String Timeframe;
	String Created;
	String Started;
	String Completed;
	String DueDate;
	
	public Task (int tsk, int prnt, String ttl, String dscrpt
			String prgrss, String prrt, String tsktp, String gnr,
			String tmfrm, String crtd, String strtd, String cmpltd,
			String ddt) {
		this.TaskID = tsk;
		this.ParentID  = prnt;
		this.Title = ttl;
		this.Description = dscrpt;
		this.Progress = prgrss;
		this.Priority;
		this.TaskType;
		this.Genre;
		this.Timeframe;
		this.Created;
		this.Started;
		this.Completed;
		this.DueDate;
	}
	
}

public class Reference {
	
	int RefID;
	String Title;
	String Description;
	
	public Reference (int rfd, String ttl, String dscrpt) {
		this.RefID = rfd;
		this.Title = ttl;
		this.Description = dscrpt;
		}
	
	}
