### To Do List:

(update Github Projects with this)



GUI:

Initialize/check for DB in startClass

Get Start Panel Working: Point to Select Panel, Add Panel (new root task), add button to print all tasks to a file. View all root tasks button.

Get ViewPanel Working: Create a table from an ArrayList of Tasks. Point to Add Panel for a new root task. View all root tasks button.

Get TaskPanel Working: Make sure that all values are available for view. Don't hide fields if they are null, as in the app the users will probably want to see what is available. Create table (similar to ViewPanel's table) to view and select child tasks. Support functionality of returning to the parent. Point to AddEditPanel for edit of a task. Only place to access AddEditPanel for editing. Point to AddEditPanel for adding new child task.

Get AddEditPanel Working: Create logic to make sure the panel has different constructors for adding and editing tasks. Key difference is that Add will pass a parent (even if that id is null), while Edit will pass original values of the task. Add/Edit panel will not support the view of children tasks. Create a dialog for submit, delete, and delete children.

Get SelectPanel Working: Make sure all options for filters work and build the correct String - print string instead of calling at first to check if they are correct. Also, add a check box for overdue projects. Also, instead of check boxes, use three options "not null, null, ignore" for the completed fields (and overdue, etc.)



Extra:

Create CountUpTaskManager .css file for MarkDown formatting of tasks