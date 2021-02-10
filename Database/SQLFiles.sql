-- Database Creation File: dbCreation.sql
-- Select Single Task
"SELECT * FROM TASK WHERE TASKID = " + taskID + ";"

-- Select Root Tasks
"SELECT * FROM TASK WHERE PARENTID = NULL;"

-- Select Child Tasks
"SELECT * FROM TASK WHERE PARENTID = " + taskID + ";"

-- Select Reference
"SELECT * FROM " + tableName +
"WHERE REFID = " + refID + ";"

-- Select Tasks Where+Sort+Sort
-- THIS ONE IS GOING TO BE COMPLICATED

-- Select Reference Table
"SELECT * FROM " + tableName + ";"

-- Update Reference
"UPDATE " + tableName +
"SET TITLE = " + newTitle +
", DESCRIPTION = " + newDesc +
"WHERE REFID = " + refID + ";"

-- Delete Reference
"DELETE FROM " + tableName + "
WHERE REFID = " + idNum + ";"

-- Insert Into Reference
"INSERT INTO " + tableName + "(TITLE, DESCRIPTION)
VALUES (" + newTitle + ", " + newDesc + ");"

-- Update Task Function -- Updates all values at once, even if not changed.

-- Insert Into Task Function -- Updates all values at once, even if not changed.

-- Delete Task
"DELETE FROM TASK
WHERE TASKID = " + taskID + ";"
