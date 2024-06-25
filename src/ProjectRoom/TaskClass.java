package ProjectRoom;

//these are all the imports needed for the panel creation, for saving and displaying information
//and for the arrays of information saved
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
//------------------------------------------------------------------------------------------------------------------------------------------------

/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */
//------------------------------------------------------------------------------------------------------------------------------------------------
//this class lets the user pick from a numeric menu for what they want to do 
//lets the user enter all the information for the tasks
public class TaskClass {
//---------------------------------------------------------------------------------------------------------------------------------------------
//Global Variables that are used throughout the class

    //all the information saved by the task creation
    public JTextField taskNameField;
    public JTextField taskDescriptionField;
    public JTextField taskDeveloperField;
    public JTextField taskDurationField;
    public JComboBox<String> taskStatusField;

    public String taskName;
    public String taskDescription;
    public String taskDeveloper;
    public int taskDuration;
    public String taskStatus;

    //used for the task number needed for displaying it and the task ID
    public int numTasks;

    //used for finding the total duation of the tasks combined
    public int totalDuration = 0;

    //used for seeing if certain buttons were pressed for the menu while loop
    private boolean quitButtonPressed = false;
    private boolean addTaskButtonPressed = false;
    private boolean taskOptionsButtonPressed = false;
    private boolean returnMenuButtonPressed = false;

    //creates the array list used to save all the information entered for the tasks
    private List<Task> tasks = new ArrayList<>();

    private JDialog taskMenuDialog;
    private JDialog taskOptionsDialog;
    private JDialog showReportDialog;
    private JDialog doneTasksDialog;
    private JDialog searchDeveloperDialog;

//---------------------------------------------------------------------------------------------------------------------------------------------
//method for the creation of the menu that the user can select from to decide if they want to add tasks, 
//show a report (which shows a coming soon page) and if they want to quit the program
//this method specifies the dimensions of the panels, the labels of the buttons,
//and adds action listeners for the menu while loop 
    public JPanel createTaskMenuPanel() {
        //creates the layout to be used on the panel
        JPanel taskMenuPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        taskMenuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //sets the custom dimensions of the panel
        taskMenuPanel.setPreferredSize(new Dimension(200, 150));

        //creates the 4 numeric buttons for the menu
        JButton addTaskButton = new JButton("1. Add Task");
        JButton taskOptionsButton = new JButton("2. Task Options");
        JButton showReportButton = new JButton("3. Show Report");
        JButton quitButton = new JButton("4. Quit");

        //adds action listeners for each button to check if they were pressed
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddTask();
            }
        });
        showReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleShowReport();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleQuit();
            }
        });
        taskOptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTaskOptions();
            }
        });

        //adds the buttons to the panel
        taskMenuPanel.add(addTaskButton);
        taskMenuPanel.add(taskOptionsButton);
        taskMenuPanel.add(showReportButton);
        taskMenuPanel.add(quitButton);

        return taskMenuPanel;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------
//This method creates the panel for the form where the user adds all the information needed for the tasks
//it specifies the dimensions, labels, textboxes as well as a combo box used for the status of the task
    public JPanel createAddTaskPanel() {
        //creates the layout to be used on the panel
        JPanel addTaskPanel = new JPanel(new GridLayout(7, 2));

        //sets the custom dimensions of the panel
        addTaskPanel.setPreferredSize(new Dimension(400, 200));

        //sets the layout for the components on the panel
        BoxLayout layout = new BoxLayout(addTaskPanel, BoxLayout.Y_AXIS);
        addTaskPanel.setLayout(layout);

        //creates the variables for the textfields and labels for the task name
        //also adds them to the panel
        JLabel taskNameLabel = new JLabel("Task Name: ");
        taskNameField = new JTextField();
        addTaskPanel.add(taskNameLabel);
        addTaskPanel.add(taskNameField);

        //creates the variables for the textfields and labels for the task description
        //also adds them to the panel
        JLabel taskDescriptionLabel = new JLabel("Task Description: \n(Must be less than 50 characters)");
        taskDescriptionField = new JTextField();
        addTaskPanel.add(taskDescriptionLabel);
        addTaskPanel.add(taskDescriptionField);

        //creates the variables for the textfields and labels for the developer details
        //also adds them to the panel
        JLabel taskDeveloperLabel = new JLabel("Developer Details: \n(First and Last Name of Developer)");
        taskDeveloperField = new JTextField();
        addTaskPanel.add(taskDeveloperLabel);
        addTaskPanel.add(taskDeveloperField);

        //creates the variables for the textfields and labels for the task duration
        //also adds them to the panel
        JLabel taskDurationLabel = new JLabel("Task Duration: (In Hours)");
        taskDurationField = new JTextField();
        addTaskPanel.add(taskDurationLabel);
        addTaskPanel.add(taskDurationField);

        //creates the variables for the combox and labels for the task status
        //also adds them to the panel
        JLabel taskStatusLabel = new JLabel("Task Status: ");
        String[] status = {"To-Do", "Doing", "Done"};
        taskStatusField = new JComboBox<>(status);
        addTaskPanel.add(taskStatusLabel);
        addTaskPanel.add(taskStatusField);

        return addTaskPanel;
    }

//---------------------------------------------------------------------------------------------------------------------------------------------
    //This method creates the panel for the form where the user adds all the information needed for the tasks
//it specifies the dimensions, labels, textboxes as well as a combo box used for the status of the task
    public JPanel createTaskOptionsPanel() {
        //creates the layout to be used on the panel
        JPanel taskOptionsPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        taskOptionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //sets the custom dimensions of the panel
        taskOptionsPanel.setPreferredSize(new Dimension(200, 200));

        //creates the 4 numeric buttons for the menu
        JButton showDoneTasksButton = new JButton("Show Completed Tasks");
        JButton showLongestTaskButton = new JButton("Longest Task Duration");
        JButton searchTaskNameButton = new JButton("Search by Task Name");
        JButton searchTaskDeveloperButton = new JButton("Search by Developer");
        JButton deleteTaskButton = new JButton("Delete Task");
        JButton taskMenuButton = new JButton("Return to Task Menu");

        //adds action listeners for each button to check if they were pressed
        showDoneTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleShowDoneTasks();
            }
        });
        showLongestTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleShowLongestTask();
            }
        });
        searchTaskNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSearchTaskName();
            }
        });
        searchTaskDeveloperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSearchTaskDeveloper();
            }
        });
        deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDeleteTask();
            }
        });
        taskMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleReturnTaskMenu();
            }
        });

        //adds the buttons to the panel
        taskOptionsPanel.add(showDoneTasksButton);
        taskOptionsPanel.add(showLongestTaskButton);
        taskOptionsPanel.add(searchTaskNameButton);
        taskOptionsPanel.add(searchTaskDeveloperButton);
        taskOptionsPanel.add(deleteTaskButton);
        taskOptionsPanel.add(taskMenuButton);

        return taskOptionsPanel;
    }
//---------------------------------------------------------------------------------------------------------------------------------------------
//this method shows the user the task menu, then starts a while loop until the user has pressed quit, 
//the program will thus run until "quit" has been pressed
//during the while loop, it checks if the add task button was pressed or if the show report button 
//has been presed then calls the relevant methods

    public void TaskMenuScreen() {
        //custom image
        ImageIcon stardrop = new ImageIcon("Pics/stardrop.png");
        Image backgroundImage = new ImageIcon("Pics/background.jpg").getImage();

        taskMenuDialog = new JDialog((Frame) null, "Task Menu", true);

        taskMenuDialog.setLayout(new BorderLayout());
        taskMenuDialog.setIconImage(stardrop.getImage());
        taskMenuDialog.setSize(300, 200);
        taskMenuDialog.setLocationRelativeTo(null);
        taskMenuDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(new BorderLayout());

        JPanel taskMenuPanel = createTaskMenuPanel();
        JLabel imageLabel = new JLabel(new ImageIcon("Pics/plant.png"));

        backgroundPanel.add(taskMenuPanel, BorderLayout.CENTER);
        taskMenuDialog.setContentPane(backgroundPanel);
        taskMenuDialog.add(imageLabel, BorderLayout.WEST);

        //while loop for the menu
        while (!quitButtonPressed && !taskOptionsButtonPressed) {
            taskMenuDialog.setVisible(true);
        }

        //exits the program if the quit button was pressed
        if (quitButtonPressed) {
            System.exit(0);
        }
    }

//---------------------------------------------------------------------------------------------------------------------------------------------
    public void TaskOptionsScreen() {
        ImageIcon stardrop = new ImageIcon("Pics/stardrop.png");
        Image backgroundImage = new ImageIcon("Pics/background.jpg").getImage();

        taskOptionsDialog = new JDialog((Frame) null, "Task Options", true);

        taskOptionsDialog.setLayout(new BorderLayout());
        taskOptionsDialog.setIconImage(stardrop.getImage());
        taskOptionsDialog.setSize(400, 300);
        taskOptionsDialog.setLocationRelativeTo(null);
        taskOptionsDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(new BorderLayout());

        JPanel taskOptionsPanel = createTaskOptionsPanel();

        JLabel imageLabel = new JLabel(new ImageIcon("Pics/teapot.png"));

        backgroundPanel.add(taskOptionsPanel, BorderLayout.CENTER);
        taskOptionsDialog.setContentPane(backgroundPanel);
        taskOptionsDialog.add(imageLabel, BorderLayout.WEST);

        while (!returnMenuButtonPressed) {
            //calls and displays the custom menu panel
            taskOptionsDialog.setVisible(true);
        }

    }

//---------------------------------------------------------------------------------------------------------------------------------------------
//this asks the user how many tasks they would like to enter when they press the add task button, 
//it then makes a for loop that goes on for the same amount of times that they entered
//this method also checks that the user enters a number in the correct format 
//when they ask for how many tasks the user wants to ask
    public void handleAddTask() {
        //custom images
        ImageIcon butterfly = new ImageIcon("Pics/butterfly.png");
        ImageIcon error = new ImageIcon("Pics/error.png");
        ImageIcon clock = new ImageIcon("Pics/clock.png");
        ImageIcon notepad = new ImageIcon("Pics/notepad.png");

        //sets the boolean for if the user typed a number in the correct format 
        //when asked how many tasks they want to enter
        boolean validInput = false;

        //sets the task number to 0
        numTasks = 0;

        //while loop for the task amount entered that shows if it was correct or not
        while (!validInput) {
            String userInput = (String) JOptionPane.showInputDialog(null, "How many tasks would you "
                    + "like to add?", "Add Tasks", JOptionPane.DEFAULT_OPTION, butterfly, null, null);
            if (userInput == null) {
                return;
            }
            //tells the program how many tasks the user wants to add
            try {
                int tasksToAdd = Integer.parseInt(userInput);
                if (tasksToAdd > 0) {
                    numTasks += tasksToAdd;
                    validInput = true;
                } else {
                    JOptionPane.showInputDialog(null, "Please Enter a Positive Number.", "Incorrect Format",
                            JOptionPane.DEFAULT_OPTION, error, null, null);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showInputDialog(null, "Invalid Number. Please Enter a valid number.",
                        "Incorrect Format", JOptionPane.DEFAULT_OPTION, clock, null, null);
            }
        }

        //runs for loop that will run the same amount of times that the user entered, shwoing them the task form
        for (int i = 0; i < numTasks; i++) {
            //calls the add task form and saves the information entered in the form
            JPanel addTask = createAddTaskPanel();
            int result = JOptionPane.showConfirmDialog(null, addTask, "Please enter task details.",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, notepad);
            if (result == JOptionPane.OK_OPTION) {
                taskName = taskNameField.getText();
                taskDescription = taskDescriptionField.getText();
                taskDeveloper = taskDeveloperField.getText();
                taskDuration = Integer.parseInt(taskDurationField.getText());
                taskStatus = (String) taskStatusField.getSelectedItem();

                //calls the check task description to make sure the description is within the specifications
                if (!checkTaskDescription()) {
                    i--;
                    continue;
                }
                String taskID = createTaskID(taskName, taskDeveloper, tasks.size() + 1);
                Task task = new Task(taskID, taskName, taskDescription, taskDeveloper, taskDuration, taskStatus);
                tasks.add(task);

                //calls the method that shows the task details every time after the user enters the task details
                showTaskSummary(task);
            }
        }
        //retrives the total hours calculated for all the tasks added 
        //and outputs it by calling the returnTotalHours method
        int totalHours = returnTotalHours();
        JOptionPane.showMessageDialog(null, "Total Duration of All Tasks: " + totalHours + " hours.",
                "Duration Summary", JOptionPane.DEFAULT_OPTION, clock);
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------
    public void handleTaskOptions() {
        returnMenuButtonPressed = false;
        taskOptionsButtonPressed = true;
        taskMenuDialog.dispose();
        TaskOptionsScreen();
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------
    //shows the coming soon message for when the user presses the show report message
    public void handleShowReport() {
        ImageIcon stars = new ImageIcon("Pics/stars.png");
        Image backgroundImage = new ImageIcon("Pics/background.jpg").getImage();

        StringBuilder todoTaskBuilder = new StringBuilder();

        for (Task task : tasks) {
            if ("To-Do".equals(task.getTaskStatus())) {
                String taskDetails = "Task Name: " + task.getTaskName() + "\nTask Developer: "
                        + task.getTaskDeveloper() + "\nTask Description:  " + task.getTaskDescription()
                        + "\nTask ID: " + task.getTaskID() + "\nTask Duration: " + task.getTaskDuration() + " hours\n"
                        + "----------------------------------\n";
                todoTaskBuilder.append(taskDetails);
            }
        }

        JTextArea todoTaskArea = new JTextArea(todoTaskBuilder.toString());
        todoTaskArea.setBorder(BorderFactory.createTitledBorder("To-Do Tasks:"));
        todoTaskArea.setEditable(false);
        //------------------------------------------------------------
        StringBuilder doingTaskBuilder = new StringBuilder();

        for (Task task : tasks) {
            if ("Doing".equals(task.getTaskStatus())) {
                String taskDetails = "Task Name: " + task.getTaskName() + "\nTask Developer: "
                        + task.getTaskDeveloper() + "\nTask Description:  " + task.getTaskDescription()
                        + "\nTask ID: " + task.getTaskID() + "\nTask Duration: " + task.getTaskDuration() + " hours\n"
                        + "----------------------------------\n";
                doingTaskBuilder.append(taskDetails);
            }
        }

        JTextArea doingTaskArea = new JTextArea(doingTaskBuilder.toString());
        doingTaskArea.setBorder(BorderFactory.createTitledBorder("Doing Tasks:"));
        doingTaskArea.setEditable(false);
        //------------------------------------------------------------

        StringBuilder doneTaskBuilder = new StringBuilder();

        for (Task task : tasks) {
            if ("Done".equals(task.getTaskStatus())) {
                String taskDetails = "Task Name: " + task.getTaskName() + "\nTask Developer: "
                        + task.getTaskDeveloper() + "\nTask Description:  " + task.getTaskDescription()
                        + "\nTask ID: " + task.getTaskID() + "\nTask Duration: " + task.getTaskDuration() + " hours\n"
                        + "----------------------------------\n";
                doneTaskBuilder.append(taskDetails);
            }
        }

        JTextArea doneTaskArea = new JTextArea(doneTaskBuilder.toString());
        doneTaskArea.setBorder(BorderFactory.createTitledBorder("Doing Tasks:"));
        doneTaskArea.setEditable(false);
        //------------------------------------------------------------

        showReportDialog = new JDialog((Frame) null, "Full Report of Tasks", true);
        showReportDialog.setLayout(new GridLayout(1, 3));
        showReportDialog.setIconImage(stars.getImage());
        showReportDialog.setSize(600, 400);
        showReportDialog.setLocationRelativeTo(null);
        showReportDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(new BorderLayout());

        JPanel tasksPanel = new JPanel((new GridLayout(1, 3)));
        tasksPanel.setOpaque(false);
        tasksPanel.add(new JScrollPane(todoTaskArea));
        tasksPanel.add(new JScrollPane(doingTaskArea));
        tasksPanel.add(new JScrollPane(doneTaskArea));

        backgroundPanel.add(tasksPanel, BorderLayout.CENTER);

        showReportDialog.setContentPane(backgroundPanel);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> showReportDialog.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(okButton);
        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);

        showReportDialog.setVisible(true);

    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //method that quits the program when the quit button is pressed
    private void handleQuit() {
        quitButtonPressed = true;
        System.exit(0);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //this method checks that the task description entered is no longer than 50 characters 
    //and returns the corresponding output messages\
    //this method returns as a boolean
    public boolean checkTaskDescription() {
        //custom image
        ImageIcon error = new ImageIcon("Pics/error.png");

        //gets the text from the task description
        String checkDesc = taskDescriptionField.getText();

        //if statement that checks the length and outputs the right message
        if (checkDesc.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than\n"
                    + "50 characters", "Incorrect Format", JOptionPane.DEFAULT_OPTION, error);
            return false;
        }
        return true;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
//this method creates the task ID used for each task and returns as a string
    public String createTaskID(String taskName, String taskDeveloper, int numTasks) {
        //retrieves the first 2 letters of the task name and makes them uppercase
        String taskInitials = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase()
                : taskName.toUpperCase();

        //retrieves the last 3 letters of the developer name and makes them uppercase
        String developerInitials = taskDeveloper.length() >= 3
                ? taskDeveloper.substring(taskDeveloper.length() - 3).toUpperCase()
                : taskDeveloper.toUpperCase();

        //creates the task ID by putting the first 2 letters of the task, the task number, 
        //and the last 3 letters of the developers name and putting them together
        String taskID = String.format("%s:%d:%s", taskInitials, numTasks, developerInitials);
        return taskID;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //This Method displays the task summary per task
    public void showTaskSummary(Task task) {
        //custom image
        ImageIcon pinkflower = new ImageIcon("Pics/pinkflower.png");

        //displays task summary
        String summary = printTaskDetails(task);
        JOptionPane.showMessageDialog(null, summary, "Task " + numTasks + " Summary",
                JOptionPane.OK_CANCEL_OPTION, pinkflower);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //this method puts all the information together to display a summary
    public String printTaskDetails(Task task) {
        //formats the message summary
        return String.format(
                "Task Successfully Captured!\nTask Status: %s\nTask Developer:  %s"
                + "\nTask Number: %d\nTask Name: %s\nTask Description: %s\nTask ID: %s"
                + "\nTask Duration: %d hours\n", task.getTaskStatus(), task.getTaskDeveloper(),
                numTasks, task.getTaskName(), task.getTaskDescription(), task.getTaskID(),
                task.getTaskDuration());
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //this method calculates the total task duration and returns the amount
    public int returnTotalHours() {
        totalDuration = 0;
        for (Task task : tasks) {
            totalDuration += (task.getTaskDuration());
        }
        return totalDuration;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------
    public void handleShowDoneTasks() {
        ImageIcon stars = new ImageIcon("Pics/stars.png");

        List<String> doneTasks = new ArrayList<>();

        for (Task task : tasks) {
            if ("Done".equals(task.getTaskStatus())) {
                String taskDetails = "Developer: " + task.getTaskDeveloper() + " | Task Name: "
                        + task.getTaskName() + " | Task Duration: " + task.getTaskDuration() + " hours";
                doneTasks.add(taskDetails);
            }
        }

        JList<String> doneTaskList = new JList<>(doneTasks.toArray(new String[0]));

        doneTasksDialog = new JDialog((Frame) null, "Completed Tasks", true);
        doneTasksDialog.setLayout(new BorderLayout());
        doneTasksDialog.setIconImage(stars.getImage());
        doneTasksDialog.setSize(450, 200);
        doneTasksDialog.setLocationRelativeTo(null);
        doneTasksDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel imageLabel = new JLabel(new ImageIcon("Pics/pinkflower.png"));

        JScrollPane scrollDoneTasksPane = new JScrollPane();
        scrollDoneTasksPane.setViewportView(doneTaskList);

        doneTasksDialog.add(imageLabel, BorderLayout.WEST);
        doneTasksDialog.add(scrollDoneTasksPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");

        okButton.addActionListener(e -> doneTasksDialog.dispose());
        buttonPanel.add(okButton);

        doneTasksDialog.add(buttonPanel, BorderLayout.SOUTH);
        doneTasksDialog.setVisible(true);

    }

    //--------------------------------------------------------------------------------------------------------------------------------------------
    public void handleShowLongestTask() {
        ImageIcon clock = new ImageIcon("Pics/clock.png");
        ImageIcon error = new ImageIcon("Pics/error.png");

        Task longestTask = null;

        for (Task task : tasks) {
            if (longestTask == null || task.getTaskDuration() > longestTask.getTaskDuration()) {
                longestTask = task;
            }
        }

        if (longestTask != null) {
            String taskDetails = "Developer: " + longestTask.getTaskDeveloper() + " | Task Duration: "
                    + longestTask.getTaskDuration() + " hours";
            JOptionPane.showMessageDialog(null, taskDetails, "Longest Task",
                    JOptionPane.INFORMATION_MESSAGE, clock);
        } else {
            JOptionPane.showMessageDialog(null, "No Tasks Found.", "Error",
                    JOptionPane.ERROR_MESSAGE, error);
        }

    }
    //--------------------------------------------------------------------------------------------------------------------------------------------

    public void handleSearchTaskName() {
        ImageIcon stars = new ImageIcon("Pics/stars.png");
        ImageIcon error = new ImageIcon("Pics/error.png");

        String nameInput = (String) JOptionPane.showInputDialog(null, "Enter the Task Name:",
                "Search for a Task", JOptionPane.OK_OPTION, stars, null, "");

        if (nameInput == null || nameInput.trim().isEmpty()) {
            return;
        }

        Task foundTask = null;

        for (Task task : tasks) {
            if (nameInput.equals(task.getTaskName())) {
                foundTask = task;
                break;
            }
        }

        if (foundTask != null) {
            String taskDetails = "Task Name: " + foundTask.getTaskName() + " | Developer: "
                    + foundTask.getTaskDeveloper() + " | Task Status: " + foundTask.getTaskStatus();
            JOptionPane.showMessageDialog(null, taskDetails, "Task Found!",
                    JOptionPane.INFORMATION_MESSAGE, stars);
        } else {
            JOptionPane.showMessageDialog(null, "Task not found. Please try again", "Task Not Found",
                    JOptionPane.ERROR_MESSAGE, error);
        }

    }
    //--------------------------------------------------------------------------------------------------------------------------------------------

    public void handleSearchTaskDeveloper() {
        ImageIcon stars = new ImageIcon("Pics/stars.png");
        ImageIcon notepad = new ImageIcon("Pics/notepad.png");
        ImageIcon error = new ImageIcon("Pics/error.png");

        String developerTask = (String) JOptionPane.showInputDialog(null, "Enter the Developer of the Tasks:",
                "Search for a Developer's Tasks", JOptionPane.OK_OPTION, notepad, null, "");

        if (developerTask == null || developerTask.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No developer name entered. Please try again:", "Error",
                    JOptionPane.OK_OPTION, error);
            return;
        }

        List<String> developerList = new ArrayList<>();

        for (Task task : tasks) {
            if (developerTask.equals(task.getTaskDeveloper())) {
                String taskDetails = "Task Name: " + task.getTaskName() + " | Task Status: "
                        + task.getTaskStatus();
                developerList.add(taskDetails);
            }
        }

        JList<String> developerTasksList = new JList<>(developerList.toArray(new String[0]));

        searchDeveloperDialog = new JDialog((Frame) null, "Completed Tasks", true);
        searchDeveloperDialog.setLayout(new BorderLayout());
        searchDeveloperDialog.setIconImage(stars.getImage());
        searchDeveloperDialog.setSize(450, 300);
        searchDeveloperDialog.setLocationRelativeTo(null);
        searchDeveloperDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel developerLabel = new JLabel(developerTask);
        searchDeveloperDialog.add(developerLabel, BorderLayout.CENTER);

        JLabel imageLabel = new JLabel(new ImageIcon("Pics/notepad.png"));

        JScrollPane scrollSearchDeveloperPane = new JScrollPane();
        scrollSearchDeveloperPane.setViewportView(developerTasksList);

        searchDeveloperDialog.add(imageLabel, BorderLayout.WEST);
        searchDeveloperDialog.add(scrollSearchDeveloperPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");

        okButton.addActionListener(e -> searchDeveloperDialog.dispose());
        buttonPanel.add(okButton);

        searchDeveloperDialog.add(buttonPanel, BorderLayout.SOUTH);
        searchDeveloperDialog.setVisible(true);

    }
    //--------------------------------------------------------------------------------------------------------------------------------------------

    public void handleDeleteTask() {
        ImageIcon stars = new ImageIcon("Pics/stars.png");
        ImageIcon purple = new ImageIcon("Pics/purple.png");
        ImageIcon error = new ImageIcon("Pics/error.png");

        String deleteInput = (String) JOptionPane.showInputDialog(null,
                "Enter the Task Name of the Task you would like to Delete:", "Delete task",
                JOptionPane.OK_OPTION, stars, null, "");

        if (deleteInput == null || deleteInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Task Name Entered, Try Again.", "Try Again",
                    JOptionPane.INFORMATION_MESSAGE, error);
            return;
        }

        Task taskToDelete = null;

        for (Task task : tasks) {
            if (deleteInput.equals(task.getTaskName())) {
                taskToDelete = task;
                break;
            }
        }

        if (taskToDelete != null) {
            tasks.remove(taskToDelete);
            JOptionPane.showMessageDialog(null, "The Task has been deleted successfully. ", "Task Deleted",
                    JOptionPane.INFORMATION_MESSAGE, purple);
        } else {
            JOptionPane.showMessageDialog(null, "Task not found. Please try again", "Task Not Found",
                    JOptionPane.ERROR_MESSAGE, error);
        }

    }
    //--------------------------------------------------------------------------------------------------------------------------------------------

    public void handleReturnTaskMenu() {
        returnMenuButtonPressed = true;
        taskOptionsButtonPressed = false;
        taskOptionsDialog.dispose();
        TaskMenuScreen();
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------------------------------------------
    //this creates the task array list
    public class Task {

        //sets variables for array
        String taskID;
        String taskName;
        String taskDescription;
        String taskDeveloper;
        int taskDuration;
        String taskStatus;

        //assigns saved information to new variables
        Task(String taskID, String taskName, String taskDescription, String taskDeveloper, int taskDuration,
                String taskStatus) {
            this.taskID = taskID;
            this.taskName = taskName;
            this.taskDescription = taskDescription;
            this.taskDeveloper = taskDeveloper;
            this.taskDuration = taskDuration;
            this.taskStatus = taskStatus;
        }

        //------------------------------------------------------------------------------------------------------------------------------------------
        //gets the details of the task for the variables - GETTER
        public String getTaskID() {
            return taskID;
        }
        //----------------------------------------

        public String getTaskName() {
            return taskName;
        }
        //----------------------------------------

        public String getTaskDescription() {
            return taskDescription;
        }
        //----------------------------------------

        public String getTaskDeveloper() {
            return taskDeveloper;
        }
        //----------------------------------------

        public int getTaskDuration() {
            return taskDuration;
        }
        //----------------------------------------

        public String getTaskStatus() {
            return taskStatus;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------

    public class BackgroundPanel extends JPanel {

        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------------------------------------------
}

    //-----------------------------------------------------END OF FILE---------------------------------------------------------------------   
