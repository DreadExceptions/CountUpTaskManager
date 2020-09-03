-- drop database COUNTUP;
create database COUNTUP;
use COUNTUP;

-- Reference Tables

CREATE TABLE CATEGORY (
	CATID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT,
	PRIMARY KEY (CATID),
	UNIQUE KEY (NAME)
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
	COMPID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT,
	PRIMARY KEY (COMPID),
	UNIQUE KEY (NAME)
);

INSERT INTO COMPLETENESS (NAME, DESCRIPTION)
VALUES
	('Completed', "Done. Don't worry about it."),
	('Not Started', "Get moving, bud."),
	('In Progress', "Hey! I'm working on it!"),
	('Stalled', "Something is holding up this endeavor."),
	('Under Review', "We're suspicious of you're work, Carl.");

CREATE TABLE PRIORITY (
	PRIORID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT,
	PRIMARY KEY (PRIORID),
	UNIQUE KEY (NAME)
);

INSERT INTO PRIORITY (NAME, DESCRIPTION)
VALUES
	('Major', "GET IT DONE!"),
	('Medium', "This is kinda imperative."),
	('Minor', "Eh, get to it when you get to it");

CREATE TABLE TIMEFRAME (
	TERMID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT,
	PRIMARY KEY (TERMID),
	UNIQUE KEY (NAME)
);

INSERT INTO TIMEFRAME (NAME, DESCRIPTION)
VALUES
	('Short Term', "More immediate concerns."),
	('Medium Term', "Should be completed in this season."),
	('Long Term', "A year or more time may pass before this is completed.");

CREATE TABLE DETAIL_CATEGORY (
	DCID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(16) NOT NULL,
	DESCRIPTION TEXT,
	PRIMARY KEY (DCID),
	UNIQUE KEY (NAME)
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
	TASKID INT NOT NULL AUTO_INCREMENT,
	TITLE VARCHAR(32) NOT NULL,
	DESCRIPTION TEXT NOT NULL,
	CREATED TIMESTAMP,
	STARTED TIMESTAMP,
	COMPLETED TIMESTAMP,
	DUEDATE TIMESTAMP,
	CATEGORY INT,
	COMPLETENESS INT,
	PRIORITY INT,
	TIMEFRAME INT,
	PRIMARY KEY (TASKID),
	UNIQUE KEY (TITLE, STARTED, DUEDATE),
	FOREIGN KEY (CATEGORY) references CATEGORY(CATID),
	FOREIGN KEY (COMPLETENESS) references COMPLETENESS(COMPID),
	FOREIGN KEY (PRIORITY) references PRIORITY(PRIORID),
	FOREIGN KEY (TIMEFRAME) references TIMEFRAME(TERMID)
);

CREATE TABLE DETAIL (
	TASKID INT NOT NULL,
	DETAIL_CATEGORY INT NOT NULL,
	STEP_NUMBER INT,
	DESCRIPTION TEXT NOT NULL,
	CREATED TIMESTAMP,
	STEP_DUEDATE TIMESTAMP,
	STEP_STARTED TIMESTAMP,
	UNIQUE KEY (TASKID, STEP_NUMBER),
    FOREIGN KEY (DETAIL_CATEGORY) references DETAIL_CATEGORY(DCID),
    FOREIGN KEY (TASKID) references TASK(TASKID)
);
