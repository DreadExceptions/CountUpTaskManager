INSERT INTO TASK (TITLE, DESCRIPTION, CREATED, STARTED, COMPLETED, DUEDATE, CATEGORY, COMPLETENESS, PRIORITY, TIMEFRAME)
VALUES
	('Count Up Creation', "The creation of the Count Up Task Manager App.", "2020-07-25", "2020-08-25", "2020-10-25", null, 2, 1, 3, 2);

INSERT INTO DETAIL (TASKID, DETAIL_CATEGORY, STEP_NUMBER, DESCRIPTION, CREATED, STEP_DUEDATE, STEP_STARTED)
VALUES
	(1, 1, 1, "Something of consequence that needs to be done/taken account of in order to complete the entire task", "2020-09-04", "2020-09-24", "2020-09-23"),
	(1, 8, null, "Life's gotten in the way.", "2020-09-04", "2020-09-25", null);
