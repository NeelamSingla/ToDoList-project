# ToDoList-project
# Description
It is ToDo List project. It allows user to add Task. User can update Task, Mark it as Done and can remove it. User can also sort the task and view it.
All task can be saved in file before quitting the application.
When restarting the project, It can restore the state from the file.
It sends notification to user via email and sms for tasks having Due Date of tomorrow and not done yet.

# How to Install
1. Download and Install Jdk software
2. Download code in specific folder
3. From terminal, Go to the Directory where code is downloaded
4. Run <code> javac ToDoList.java </code> to compile the code
5. Run <code> java ToDoList </code> to execute the code

# How to Use
It shows user Total tasks, ToDo and done tasks, Task list and then shows below menu to choose some option like 1,2,3 for different operation

Total tasks in your bucket:3!
You have 3 tasks todo and 0 tasks are done!
Here goes the Tasks list
1. NewTitle           Home          Fri,30 Mar 2018         To DO
2. Exercise           Fitness          Sat,31 Mar 2018         To DO
3. Shopping           Home          Sat,7 Apr 2018         To DO

Welcome to ToDoList.Please choose some option
-----------------------------------------------
1. Add Task
2. Edit Task
3. Display Task sorted by date
4. Display Task sorted by project
5. Display Task filtered by project
6. Save and Quit 
-----------------------------------------------

If user choose 1, It allows to enter task details
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

If user choose 2, It allows to update. It gives two option to find existing task. By Task No
Or By Task title and Category
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

Shopping           Home          Fri,30 Mar 2018         To DO

-----------------------------------------------
Welcome to To Do List.Please choose some option
1. Edit Task
2. Edit Task's Title
3. Edit Task's Category
4. Edit Task's Due Date
5. Mark Task as Done
6. Remove Task
7. Go back to ToDo List main menu
-----------------------------------------------

Now user can select any option to update it.

If User select 2,It allows to update only Title
-----------------------------------------------

2
Enter Task Title

newTitle

Updated Task:NewTitle           Home          Fri,30 Mar 2018         To DO

-----------------------------------------------
Welcome to To Do List.Please choose some option
1. Edit Task
2. Edit Task's Title
3. Edit Task's Category
4. Edit Task's Due Date
5. Mark Task as Done
6. Remove Task
7. Go back to ToDo List main menu
-----------------------------------------------

If User select 7,It takes user to previous menu
-----------------------------------------------
7

-----------------------------------------------
Welcome to To Do List.Please choose some option
-----------------------------------------------
1. Add Task
2. Edit Task
3. Display Task sorted by date
4. Display Task sorted by project
5. Display Task filtered by project
6. Save and Quit
--------------------------------------------------------

If user choose 5, It asks the project category to filter tasks and show only tasks of that category
---------------------------------------------------------
5

Enter project category to filter tasks

Enter Task category

home

NewTitle           Home          Fri,30 Mar 2018         To DO

Shopping           Home          Sat,7 Apr 2018         To DO

If user choose 6, It saves task in file and shows
-------------------------------------------------
below message
Thanks for using TodoList

Now when user runs it again, It restores the task details from the file.
