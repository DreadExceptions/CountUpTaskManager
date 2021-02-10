DROP TABLE CATEGORY;

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
