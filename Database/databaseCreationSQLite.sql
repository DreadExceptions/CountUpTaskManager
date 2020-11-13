-- Reference Tables

CREATE TABLE CATEGORY (
	CATID INTEGER PRIMARY KEY AUTOINCREMENT,
	NAME VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT,
	UNIQUE(NAME)
);

INSERT INTO CATEGORY (NAME, DESCRIPTION)
VALUES
	('Chores', "Daily tasks necessary for the upkeep of a homestead."),
	('Coding', "Anything related to writing for our computer overlords."),
	('Continual', "Things that will never stop pestering."),
	('Handiwork', "Manly stuff, like making birdhouses."),
	('Perennial', "Happens once a year."),
	('Random', "Where the misfits hangout."),
	('Reading', "Tasks? More like lounging on the couch."),
	('Seasonal', "For a season, like plowing snow in winter."),
	('Watching', "Tasks? More like lounging on the couch."),
	('Writing', "Anything related to writing in alphanumerics.");

CREATE TABLE COMPLETENESS (
	COMPID INTEGER PRIMARY KEY AUTOINCREMENT,
	NAME VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT,
	UNIQUE(NAME)
);

INSERT INTO COMPLETENESS (NAME, DESCRIPTION)
VALUES
	('Completed', "Done. Don't worry about it."),
	('Not Started', "Get moving, bud."),
	('In Progress', "Hey! I'm working on it!"),
	('Stalled', "Something is holding up this endeavor."),
	('Under Review', "We're suspicious of you're work, Carl.");

CREATE TABLE PRIORITY (
	PRIORID INTEGER PRIMARY KEY AUTOINCREMENT,
	NAME VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT,
	UNIQUE(NAME)
);

INSERT INTO PRIORITY (NAME, DESCRIPTION)
VALUES
	('Major', "GET IT DONE!"),
	('Medium', "This is kinda imperative."),
	('Minor', "Eh, get to it when you get to it");

CREATE TABLE TIMEFRAME (
	TERMID INTEGER PRIMARY KEY AUTOINCREMENT,
	NAME VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT,
	UNIQUE(NAME)
);

INSERT INTO TIMEFRAME (NAME, DESCRIPTION)
VALUES
	('Short Term', "More immediate concerns."),
	('Medium Term', "Should be completed in this season."),
	('Long Term', "A year or more time may pass before this is completed.");

CREATE TABLE DETAIL_CATEGORY (
	DCID INTEGER PRIMARY KEY AUTOINCREMENT,
	NAME VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT,
	UNIQUE(NAME)
);

INSERT INTO DETAIL_CATEGORY (NAME, DESCRIPTION)
VALUES
	('Requirement', "Necessary for completion."),
	('Step Number', "A step in the grand scheme."),
	('Reference', "Something that might assist completion."),
	('Clarification', "An appendum to the description."),
	('Old Description', "This was a former description of the task."),
	('Old Due Date', "This was a former duedate timestamp."),
	('Old Start Date', "This used to be the start timestamp."),
	('Hindrance', "An unexpected obstacle has appeared in the wild!");

-- Dynamic Tables

CREATE TABLE TASK (
	TASKID INTEGER PRIMARY KEY AUTOINCREMENT,
	TITLE VARCHAR(32) NOT NULL,
	DESCRIPTION TEXT NOT NULL,
	CREATED TIMESTAMP,
	STARTED TIMESTAMP,
	COMPLETED TIMESTAMP,
	DUEDATE TIMESTAMP,
	CATEGORY INTEGER,
	COMPLETENESS INTEGER,
	PRIORITY INTEGER,
	TIMEFRAME INTEGER,
	UNIQUE(TITLE, STARTED, DUEDATE),
	FOREIGN KEY (CATEGORY) REFERENCES CATEGORY(CATID),
	FOREIGN KEY (COMPLETENESS) REFERENCES COMPLETENESS(COMPID),
	FOREIGN KEY (PRIORITY) REFERENCES PRIORITY(PRIORID),
	FOREIGN KEY (TIMEFRAME) REFERENCES TIMEFRAME(TERMID)
);

CREATE TABLE DETAIL (
	TASKID INTEGER NOT NULL,
	DETAIL_CATEGORY INTEGER NOT NULL,
	STEP_NUMBER INTEGER,
	DESCRIPTION TEXT NOT NULL,
	CREATED TIMESTAMP,
	STEP_DUEDATE TIMESTAMP,
	STEP_STARTED TIMESTAMP,
	PRIMARY KEY (TASKID, DESCRIPTION),
	UNIQUE KEY (TASKID, STEP_NUMBER),
    FOREIGN KEY (DETAIL_CATEGORY) REFERENCES DETAIL_CATEGORY(DCID),
    FOREIGN KEY (TASKID) REFERENCES TASK(TASKID)
);
