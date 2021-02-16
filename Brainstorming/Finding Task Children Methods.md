# Finding Task Children Methods

These are pseudo-algorithms for finding children of tasks, both of which are recursive. Recursive was easier than Iterative in this case, as the manner that the tasks are linked to their parent tasks (i.e. the foreign key points up the tree, to the parent, rather than towards the fringes). 

The first task, Find Children, collects all offspring tasks from a given taskID. This can be used for deletion of tasks (but probably won't be) or, more importantly, for printing a task tree into a text document. Since all of the tasks will need to be in the document, all of the tasks need to be returned.

The second task, Find Children with Children, is necessary for deleting task trees. While the first method would suffice, it would also encourage writing DELETE statements for all tasks in a tree, or putting all of the taskIDs into an "WHERE TASKID IN (...)" statement. That SQL statement in particular would take longer to build, perhaps take longer to run, and requires more memory to run the process. Instead, the method only returns tasks that have children. Therefore, instead of running the first DELETE statement, we can run the second.

```SQL
DELETE FROM TASK WHERE TASKID in (...);
DELETE FROM TASK WHERE PARENTID IN (...);
```

Since the second option will catch more tasks, it will allow us to delete more with a single query. Furthermore, we *must* do it by individual queries, not by one big block. This is because the database constraints (foreign keys) will prevent the deletion of tasks that have children that exist within the TASK table.

## Find Children

Input: TaskID

Output: Array of Offspring

​	$Array Grandchildren = \phi$

​	$Array Children = (tasks where parentID = taskID)$

​		$If Children \neq \phi$

​			$\forall Children$

​				$Grandchildren += FindChildren(Child)$

​	$Return Children + Grandchildren$

## Find Children with Children

Input: TaskID

Output: Array of Offspring who are also Parents

​	$Array Parents = \phi$

​	$Array Children  (tasks where parentID = taskID)$

​		$If Children = \phi$

​			$return Parents (\phi)$

​		$If Children \neq \phi$

​			$Parents += TaskID $

​			$\forall Children$

​				$Parents += FindChildrenWithChildren(Child)$

​	$Return Parents$

