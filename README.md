# ToDoList-project
# Description
It is ToDo List project. It allows user to add Task. User can update Task, Mark it as Done and can remove it. User can also sort the task and view it.
All task can be saved in file before quitting the application.
When restarting the project, It can restore the state from the file.

# How to Install
1. Download and Install Jdk software
2. Download code in specific folder
3. From terminal, Go to the Directory where code is downloaded
4. Run <code> javac ToDoList.java </code> to compile the code
5. Run <code> java ToDoList </code> to execute the code

# How to Use
It gives user below menu to choose some option like 1,2,3 for different operation

Welcome to ToDoList.Please choose some option
-----------------------------------------------
1. Add Task
2. Edit Task
3. Display Task sorted by date 
4. Display Task sorted by project
5. Save and Quit
-----------------------------------------------

If user choose 1, It asks for some information like
----------------------------------------------
Enter Task details
shopping
Enter Task Category
home
Enter Task status, Done-True/False
True
Enter Task due Date in format yyyy-MM-dd 
2018-04-20
Task is added in TODO List

If user choose 2, It asks for some information like
----------------------------------------------

Do you want to update by Index? Enter Yes / No
yes

Enter Task No to be updated
1
it shows existing task if any and gives option menu to edit it. 
home  shopping  2018-00-20  Done

If User select No at previous step, It asks for some information like
-----------------------------------------------

Enter Task details
shopping
Enter Task Category
home

it shows existing task if any and gives option menu to edit it. 
home  shopping  2018-00-20  Done

Welcome to ToDoList.Please choose some option
1. Edit Task
2. Mark Task as Done
3. Remove Task
4. Go back to ToDo List main menu
-----------------------------------------------

Now user can select any option to update it.

If user choose 6, It saves task in file and shows
below message
Thanks for using TodoList

Now when user runs it again, It restores the task details from the file.
