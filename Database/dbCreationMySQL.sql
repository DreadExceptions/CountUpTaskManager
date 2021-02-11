drop database COUNTUPLITE;
create database COUNTUPLITE;
use COUNTUPLITE;

CREATE TABLE PRIORITY (
	REFID INTEGER auto_increment KEY,
	TITLE VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT NOT NULL,
	UNIQUE KEY (TITLE)
);

INSERT INTO PRIORITY (TITLE, DESCRIPTION)
	VALUES
	('Major', "Mandates completion."),
	('Medium', "A regular to-do item."),
	('Minor', "Not immenently important.");

CREATE TABLE TIMEFRAME (
	REFID INTEGER auto_increment KEY,
	TITLE VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT NOT NULL,
	UNIQUE KEY (TITLE)
);

INSERT INTO TIMEFRAME (TITLE, DESCRIPTION)
	VALUES
	('Short Term', "A more immediate concern."),
	('Medium Term', "Should be completed within a season."),
	('Long Term', "A year or more may pass before this is completed.");

CREATE TABLE GENRE (
	REFID INTEGER auto_increment KEY,
	TITLE VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT NOT NULL,
	UNIQUE KEY (TITLE)
);

INSERT INTO GENRE (TITLE, DESCRIPTION)
	VALUES
	('Template', "Project outline to reference."),
	('Chores', "Daily tasks necessary for the upkeep of a homestead."),
	('Coding', "Anything for our computer overlords."),
	('Design', "Creating something, but only on paper."),
	('Entertainment', "Tasks? More like lounging on the couch."),
	('Handiwork', "Manly stuff, like making birdhouses."),
	('Learning', "Figure it out, bud."),
	('Random', "Where the misfits hangout."),
	('Vocation', "9 to 5? More like all my life, am I right?"),
	('Writing', "Alphanumerics conveyed on white space.");

CREATE TABLE TASKTYPE (
	REFID INTEGER auto_increment KEY,
	TITLE VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT NOT NULL,
	UNIQUE KEY (TITLE)
);

INSERT INTO TASKTYPE (TITLE, DESCRIPTION)
	VALUES
	('Requirement', "Something needed to complete the task."),
	('Step', "One thing to do on the way to finishing."),
	('Description', "Better explains the task."),
	('Reference', "Refer back to this for help."),
	('Unexpected', "Anything that was not expected before the task was begun.");

CREATE TABLE PROGRESS (
	REFID INTEGER auto_increment KEY,
	TITLE VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT NOT NULL,
	UNIQUE KEY (TITLE)
);

INSERT INTO PROGRESS (TITLE, DESCRIPTION)
	VALUES
	('Not Started', "Get moving, bud."),
	('In Progress', "Hey! I'm working on it!"),
	('Completed', "Done. Don't worry about it."),
	('Under Review', "We're suspicious of your work."),
	('Recurring', "This pesky task is very needy.");

-- default, unassigned values. Wanted to set as 0, but auto_increment
-- starts at 1.
INSERT INTO PROGRESS (REFID, TITLE, DESCRIPTION)
	VALUES (0, 'Unassigned', "Hasn't been determined.");
UPDATE PROGRESS SET REFID = 0
	WHERE TITLE = 'Unassigned';

INSERT INTO PRIORITY (REFID, TITLE, DESCRIPTION)
	VALUES (0, 'Unassigned', "Hasn't been determined.");
UPDATE PRIORITY SET REFID = 0
	WHERE TITLE = 'Unassigned';

INSERT INTO TIMEFRAME (REFID, TITLE, DESCRIPTION)
	VALUES (0, 'Unassigned', "Hasn't been determined.");
UPDATE TIMEFRAME SET REFID = 0
	WHERE TITLE = 'Unassigned';

INSERT INTO TASKTYPE (REFID, TITLE, DESCRIPTION)
	VALUES (0, 'Unassigned', "Hasn't been determined.");
UPDATE TASKTYPE SET REFID = 0
	WHERE TITLE = 'Unassigned';

INSERT INTO GENRE (REFID, TITLE, DESCRIPTION)
	VALUES (0, 'Unassigned', "Hasn't been determined.");
UPDATE GENRE SET REFID = 0
	WHERE TITLE = 'Unassigned';

CREATE TABLE TASK (
	TASKID INTEGER auto_increment PRIMARY KEY,
	TITLE VARCHAR(32),
	PARENTID INT,
	TIMEFRAME INT NOT NULL
		DEFAULT 0,
	GENRE INT NOT NULL
		DEFAULT 0,
	PRIORITY INT NOT NULL
		DEFAULT 0,
	PROGRESS INT NOT NULL
		DEFAULT 0,
	TASKTYPE INT NOT NULL
		DEFAULT 0,
	DESCRIPTION TEXT,
	CREATEDDATE DATETIME NOT NULL
		DEFAULT NOW(),
	STARTEDDATE DATE,
	COMPLETED DATE,
	DUEDATE DATE,
	UNIQUE KEY (TITLE, PARENTID),
	FOREIGN KEY (PARENTID) REFERENCES TASK(TASKID),
	FOREIGN KEY (TIMEFRAME) REFERENCES TIMEFRAME(REFID),
	FOREIGN KEY (PRIORITY) REFERENCES TIMEFRAME(REFID),
	FOREIGN KEY (PROGRESS) REFERENCES PROGRESS(REFID),
	FOREIGN KEY (TASKTYPE) REFERENCES TASKTYPE(REFID),
	FOREIGN KEY (GENRE) REFERENCES GENRE(REFID)
);

CREATE TABLE TASKHISTORY (
	TASKID INTEGER,
	UPDATEDDATE DATETIME,
	CHANGED_FIELD VARCHAR(16),
    ORIGINAL_VALUE TEXT,
	PRIMARY KEY (TASKID, UPDATEDDATE)
);

-- If option is deleted in reference table, these triggers
-- will update the tasks table to the default, "0"

CREATE TRIGGER updateTaskPriorityTrigger
	BEFORE DELETE ON PRIORITY
	FOR EACH ROW
		UPDATE TASK T
		SET T.PRIORITY = 0
		WHERE T.PRIORITY = old.REFID;

CREATE TRIGGER updateTaskTimeframeTrigger
	BEFORE DELETE ON TIMEFRAME
	FOR EACH ROW
		UPDATE TASK T
		SET T.TIMEFRAME = 0
		WHERE T.TIMEFRAME = old.REFID;
	
CREATE TRIGGER updateTaskGenreTrigger
	BEFORE DELETE ON GENRE
	FOR EACH ROW
		UPDATE TASK T
		SET T.GENRE = 0
		WHERE T.GENRE = old.REFID;
	
CREATE TRIGGER updateTaskTaskTypeTrigger
	BEFORE DELETE ON TASKTYPE
	FOR EACH ROW
		UPDATE TASK T
		SET T.TASKTYPE = 0
		WHERE T.TASKTYPE = old.REFID;
	
CREATE TRIGGER updateTaskProgressTrigger
	BEFORE DELETE ON PROGRESS
	FOR EACH ROW
		UPDATE TASK T
		SET T.PROGRESS = 0
		WHERE T.PROGRESS = old.REFID;

/* This Trigger is recursive, and as a result, many complications are arising.
Instead of implementing it with SQL, I will implement it with Java, and later
I may return to use this trigger in SQL.
CREATE TRIGGER reverseCascadeDeleteTasksTrigger
	BEFORE DELETE ON TASK
    FOR EACH ROW
		DELETE FROM TASK T
        WHERE T.PARENTID = old.TASKID; */

/* This Trigger needs the field name to update to the TASKHISTORY table.
I am unsure if that is possible, so I'm going to do it in Java instead.
I may return to use this trigger.
CREATE TRIGGER historicalTasksTrigger
	BEFORE UPDATE ON TASK
    FOR EACH ROW
		INSERT INTO TASKHISTORY
        VALUES
        (old.TASKID, NOW(), CHANGED_FIELD, CAST(old.VALUE AS TEXT);*/
        
INSERT INTO TASK (TITLE, PARENTID, TIMEFRAME, GENRE, PRIORITY, PROGRESS, TASKTYPE, DESCRIPTION)
VALUES
('Project Template', null, 0, 1, 0, 0, 0, "This is the root of a complex template for a project."),
('Simple Template', null, 0, 1, 0, 0, 0, "This is the root of a simple template for tasks.");

INSERT INTO TASK (TITLE, PARENTID, TIMEFRAME, GENRE, PRIORITY, PROGRESS, TASKTYPE, DESCRIPTION)
VALUES
('Purpose', 1, 0, 1, 0, 1, 3, "Why?"),
('Context', 1, 0, 1, 0, 1, 3, "Random tidbits for a bigger picture."),
('Minimum', 1, 0, 1, 1, 1, 2, "Minimum viable project objectives."),
('Extended Goals', 1, 0, 1, 3, 1, 1, "Things that would be cool to also have."),
('Resources', 1, 0, 1, 0, 1, 4, "Things to complete the project."),
('Milestones', 1, 0, 1, 0, 1, 1, "When?"),
('Training', 1, 0, 1, 0, 1, 4, "Things to learn for completion."),
('Objective', 2, 0, 1, 0, 1, 2, "This is something that needs to be done for this task."),
('Requirement', 2, 0, 1, 0, 1, 1, "This is what is needed for this task.");