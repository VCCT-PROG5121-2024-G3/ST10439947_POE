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
//this class is where the user can enter their task details and select all the different task options available
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

    //all the JDialogs used for the custom pop ups for the task options
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

        //creates the 5 task options buttons as well as a return to menu button
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
        //custom images for the menu
        ImageIcon stardrop = new ImageIcon("Pics/stardrop.png");
        Image backgroundImage = new ImageIcon("Pics/background.jpg").getImage();

        //creates the JDialog used for the menu and sets up the layout, size and other options
        taskMenuDialog = new JDialog((Frame) null, "Task Menu", true);
        taskMenuDialog.setLayout(new BorderLayout());
        taskMenuDialog.setIconImage(stardrop.getImage());
        taskMenuDialog.setSize(300, 200);
        taskMenuDialog.setLocationRelativeTo(null);
        taskMenuDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        //calls and sets the layout of the background image
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(new BorderLayout());

        //calls the task menu panel and creates a spot for the custom image
        JPanel taskMenuPanel = createTaskMenuPanel();
        JLabel imageLabel = new JLabel(new ImageIcon("Pics/plant.png"));

        //adds the background image to the JDialog and sets up the layout
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
        //custom images for the options menu
        ImageIcon stardrop = new ImageIcon("Pics/stardrop.png");
        Image backgroundImage = new ImageIcon("Pics/background.jpg").getImage();

        //creates the JDialog used for the options menu and sets up the layout, size and other options
        taskOptionsDialog = new JDialog((Frame) null, "Task Options", true);
        taskOptionsDialog.setLayout(new BorderLayout());
        taskOptionsDialog.setIconImage(stardrop.getImage());
        taskOptionsDialog.setSize(400, 300);
        taskOptionsDialog.setLocationRelativeTo(null);
        taskOptionsDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        //calls and sets the layout of the background image
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(new BorderLayout());

        //calls the task options panel and creates a spot for the custom image
        JPanel taskOptionsPanel = createTaskOptionsPanel();
        JLabel imageLabel = new JLabel(new ImageIcon("Pics/teapot.png"));

        //adds the background image to the JDialog and sets up the layout
        backgroundPanel.add(taskOptionsPanel, BorderLayout.CENTER);
        taskOptionsDialog.setContentPane(backgroundPanel);
        taskOptionsDialog.add(imageLabel, BorderLayout.WEST);

        //while loop for the menu
        while (!returnMenuButtonPressed) {
            //keeps the options menu visible while the user doesn't press the "Return to menu" button
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
    //this resets and sets the flags for the buttons being pressed, closes the task menu dialog 
    //and calls the task options method
    public void handleTaskOptions() {
        returnMenuButtonPressed = false;
        taskOptionsButtonPressed = true;
        taskMenuDialog.dispose();
        TaskOptionsScreen();
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------
    //this method shows the user a full report of all the tasks the user added with all of its information
    //creates a custom JDialog with 3 sections (categorised by status) that shows the tasks
    //uses string builders to put info together
    public void handleShowReport() {
        //custom images used in the Dialog
        ImageIcon stars = new ImageIcon("Pics/stars.png");
        Image backgroundImage = new ImageIcon("Pics/background.jpg").getImage();

        //puts the string together for ease of displaying the "To-Do" tasks
        StringBuilder todoTaskBuilder = new StringBuilder();

        //puts all the details together for the tasks with the status "To-Do"
        for (Task task : tasks) {
            if ("To-Do".equals(task.getTaskStatus())) {
                String taskDetails = "Task Name: " + task.getTaskName() + "\nTask Developer: "
                        + task.getTaskDeveloper() + "\nTask Description:  " + task.getTaskDescription()
                        + "\nTask ID: " + task.getTaskID() + "\nTask Duration: " + task.getTaskDuration() + " hours\n"
                        + "----------------------------------\n";
                todoTaskBuilder.append(taskDetails);
            }
        }

        //creates a JTextArea where the To-Do tasks will be displayed
        JTextArea todoTaskArea = new JTextArea(todoTaskBuilder.toString());
        todoTaskArea.setBorder(BorderFactory.createTitledBorder("To-Do Tasks:"));
        todoTaskArea.setEditable(false);
        //------------------------------------------------------------

        //puts the string together for ease of displaying the "Doing" tasks
        StringBuilder doingTaskBuilder = new StringBuilder();

        //puts all the details together for the tasks with the status "Doing"
        for (Task task : tasks) {
            if ("Doing".equals(task.getTaskStatus())) {
                String taskDetails = "Task Name: " + task.getTaskName() + "\nTask Developer: "
                        + task.getTaskDeveloper() + "\nTask Description:  " + task.getTaskDescription()
                        + "\nTask ID: " + task.getTaskID() + "\nTask Duration: " + task.getTaskDuration() + " hours\n"
                        + "----------------------------------\n";
                doingTaskBuilder.append(taskDetails);
            }
        }

        //creates a JTextArea where the Doing tasks will be displayed
        JTextArea doingTaskArea = new JTextArea(doingTaskBuilder.toString());
        doingTaskArea.setBorder(BorderFactory.createTitledBorder("Doing Tasks:"));
        doingTaskArea.setEditable(false);
        //------------------------------------------------------------

        //puts the string together for ease of displaying the "Done" tasks
        StringBuilder doneTaskBuilder = new StringBuilder();

        //puts all the details together for the tasks with the status "Done"
        for (Task task : tasks) {
            if ("Done".equals(task.getTaskStatus())) {
                String taskDetails = "Task Name: " + task.getTaskName() + "\nTask Developer: "
                        + task.getTaskDeveloper() + "\nTask Description:  " + task.getTaskDescription()
                        + "\nTask ID: " + task.getTaskID() + "\nTask Duration: " + task.getTaskDuration() + " hours\n"
                        + "----------------------------------\n";
                doneTaskBuilder.append(taskDetails);
            }
        }

        //creates a JTextArea where the Done tasks will be displayed
        JTextArea doneTaskArea = new JTextArea(doneTaskBuilder.toString());
        doneTaskArea.setBorder(BorderFactory.createTitledBorder("Doing Tasks:"));
        doneTaskArea.setEditable(false);
        //------------------------------------------------------------

        //this creates and sets up the JDialog where the full report will be shown
        showReportDialog = new JDialog((Frame) null, "Full Report of Tasks", true);
        showReportDialog.setLayout(new GridLayout(1, 3));
        showReportDialog.setIconImage(stars.getImage());
        showReportDialog.setSize(600, 400);
        showReportDialog.setLocationRelativeTo(null);
        showReportDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        //calls and sets up the layout for the bacground image
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(new BorderLayout());

        //creates a panel where the 3 JTextAreas fir the 3 sections will be added to
        JPanel tasksPanel = new JPanel((new GridLayout(1, 3)));
        tasksPanel.setOpaque(false);
        tasksPanel.add(new JScrollPane(todoTaskArea));
        tasksPanel.add(new JScrollPane(doingTaskArea));
        tasksPanel.add(new JScrollPane(doneTaskArea));

        //adds the backghround image to the panel
        backgroundPanel.add(tasksPanel, BorderLayout.CENTER);
        showReportDialog.setContentPane(backgroundPanel);

        //creates an "OK" button that the user can press after viewing the report, adds it to the panel
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> showReportDialog.dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(okButton);
        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);

        //makes the Dialog visible
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
    //this method shows the user all tasks with the task status of Done
    public void handleShowDoneTasks() {
        //custom Image
        ImageIcon stars = new ImageIcon("Pics/stars.png");

        //creates a String List connected to the Array list to collect the done tasks
        List<String> doneTasks = new ArrayList<>();

        //goes through the whole array list to find the tasks with the status of done, then formats them 
        //and adds them to the string list for the done tasks
        for (Task task : tasks) {
            if ("Done".equals(task.getTaskStatus())) {
                String taskDetails = "Developer: " + task.getTaskDeveloper() + " | Task Name: "
                        + task.getTaskName() + " | Task Duration: " + task.getTaskDuration() + " hours";
                doneTasks.add(taskDetails);
            }
        }

        //Creates a JList for the done task list so the program can display the list
        JList<String> doneTaskList = new JList<>(doneTasks.toArray(new String[0]));

        //creates a JDialog for the display and configures all the settings
        doneTasksDialog = new JDialog((Frame) null, "Completed Tasks", true);
        doneTasksDialog.setLayout(new BorderLayout());
        doneTasksDialog.setIconImage(stars.getImage());
        doneTasksDialog.setSize(450, 200);
        doneTasksDialog.setLocationRelativeTo(null);
        doneTasksDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        //creates a label for the custom image
        JLabel imageLabel = new JLabel(new ImageIcon("Pics/pinkflower.png"));

        //adds a scrollbar for if the text goes longer than the JDialog dimensions, 
        //this scrollbar is specifically for the done task list
        JScrollPane scrollDoneTasksPane = new JScrollPane();
        scrollDoneTasksPane.setViewportView(doneTaskList);

        //adds the Image and scrollbar to the dialog
        doneTasksDialog.add(imageLabel, BorderLayout.WEST);
        doneTasksDialog.add(scrollDoneTasksPane, BorderLayout.CENTER);

        //creates an "OK" button for the user to press after viewing the list of done tasks, 
        //also configures the button
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> doneTasksDialog.dispose());
        buttonPanel.add(okButton);

        //adds the button to the dialog and makes the dialog visible
        doneTasksDialog.add(buttonPanel, BorderLayout.SOUTH);
        doneTasksDialog.setVisible(true);

    }

    //--------------------------------------------------------------------------------------------------------------------------------------------
    //this method finds the task with the largest task duration 
    //and displays it to the user when they press the button
    public void handleShowLongestTask() {
        //custom images
        ImageIcon clock = new ImageIcon("Pics/clock.png");
        ImageIcon error = new ImageIcon("Pics/error.png");

        //creates a variable for saving the longest task
        Task longestTask = null;

        //goes through the whole array list to find the task with the longest task duration
        for (Task task : tasks) {
            if (longestTask == null || task.getTaskDuration() > longestTask.getTaskDuration()) {
                longestTask = task;
            }
        }

        //displays the task detail for the task with the longest duration if it finds the task, 
        //shows an error message if it doesn't find a task
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
//this method lets the user type in the task name they are looking for and displays the tasks details
    public void handleSearchTaskName() {
        //custom images
        ImageIcon stars = new ImageIcon("Pics/stars.png");
        ImageIcon error = new ImageIcon("Pics/error.png");

        //prompts the user to type in the task name and saves their input
        String nameInput = (String) JOptionPane.showInputDialog(null, "Enter the Task Name:",
                "Search for a Task", JOptionPane.OK_OPTION, stars, null, "");

        //checks that the user inputted something and tells them to input again if they didnt enter anything
        if (nameInput == null || nameInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Input found, Please try again:",
                    "Error", JOptionPane.OK_OPTION, error);
            return;
        }

        //creates a variable to save the found task's details
        Task foundTask = null;

        //goes through whole array list and checks to see if they task name they entered 
        //matched a task that was enetered, and saves the task details
        for (Task task : tasks) {
            if (nameInput.equals(task.getTaskName())) {
                foundTask = task;
                break;
            }
        }

        //if a task was saved it then formats the task details to be used for displaying, 
        //shows the user a error message if the task was not found
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
    //this method lets the user type in the developer name they are looking for and displays 
    //the tasks details for all the tasks linked to that developer
    public void handleSearchTaskDeveloper() {
        //custom images
        ImageIcon stars = new ImageIcon("Pics/stars.png");
        ImageIcon notepad = new ImageIcon("Pics/notepad.png");
        ImageIcon error = new ImageIcon("Pics/error.png");

        //prompts the user to type in the task name and saves their input
        String developerTask = (String) JOptionPane.showInputDialog(null, "Enter the Developer of the Tasks:",
                "Search for a Developer's Tasks", JOptionPane.OK_OPTION, notepad, null, "");

        //checks that the user inputted something and tells them to input again if they didnt enter anything
        if (developerTask == null || developerTask.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No developer name entered. Please try again:", "Error",
                    JOptionPane.OK_OPTION, error);
            return;
        }

        //creates a string list to save the task details linked to the entered developer
        List<String> developerList = new ArrayList<>();

        //goes through whole array list and checks to see if they developer name they entered 
        //matched any tasks that were entered previously, and saves the task details
        for (Task task : tasks) {
            if (developerTask.equals(task.getTaskDeveloper())) {
                String taskDetails = "Task Name: " + task.getTaskName() + " | Task Status: "
                        + task.getTaskStatus();
                developerList.add(taskDetails);
            }
        }

        //creates a JList for the string list that saved the task details to be able to display them
        JList<String> developerTasksList = new JList<>(developerList.toArray(new String[0]));

        //creates the JDialog to display everythiung and configures everything
        searchDeveloperDialog = new JDialog((Frame) null, "Completed Tasks", true);
        searchDeveloperDialog.setLayout(new BorderLayout());
        searchDeveloperDialog.setIconImage(stars.getImage());
        searchDeveloperDialog.setSize(450, 300);
        searchDeveloperDialog.setLocationRelativeTo(null);
        searchDeveloperDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        //adds a label with the devlopers name
        JLabel developerLabel = new JLabel(developerTask);
        searchDeveloperDialog.add(developerLabel, BorderLayout.CENTER);

        //adds a custom image
        JLabel imageLabel = new JLabel(new ImageIcon("Pics/notepad.png"));

        //adds a scrollbar for the JList for the task details and sets the size
        JScrollPane scrollSearchDeveloperPane = new JScrollPane();
        scrollSearchDeveloperPane.setViewportView(developerTasksList);

        //adds everything to the dialog
        searchDeveloperDialog.add(imageLabel, BorderLayout.WEST);
        searchDeveloperDialog.add(scrollSearchDeveloperPane, BorderLayout.CENTER);

        //creates an "OK"  button for the user to press after they view the list with all of the devlopers tasks, 
        //and adds it to the dialog
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> searchDeveloperDialog.dispose());
        buttonPanel.add(okButton);
        searchDeveloperDialog.add(buttonPanel, BorderLayout.SOUTH);

        //sets the dialog visible
        searchDeveloperDialog.setVisible(true);

    }

    //--------------------------------------------------------------------------------------------------------------------------------------------
    //this method asks the user for the name of the task they would like to delete, 
    //then shows the corresponding message dispalying success or failure
    public void handleDeleteTask() {
        //custom images
        ImageIcon stars = new ImageIcon("Pics/stars.png");
        ImageIcon purple = new ImageIcon("Pics/purple.png");
        ImageIcon error = new ImageIcon("Pics/error.png");

        //prompts a user to type in the name of the task that they would like to delete and saves their input
        String deleteInput = (String) JOptionPane.showInputDialog(null,
                "Enter the Task Name of the Task you would like to Delete:", "Delete task",
                JOptionPane.OK_OPTION, stars, null, "");

        //checks that the user didnt leave it empty, if it did it shows them the corresponding message
        if (deleteInput == null || deleteInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Task Name Entered, Try Again.", "Try Again",
                    JOptionPane.INFORMATION_MESSAGE, error);
            return;
        }

        //creates a variable to save the task details
        Task taskToDelete = null;

        //goes through the whole array list to find the matching task then saves the task details
        for (Task task : tasks) {
            if (deleteInput.equals(task.getTaskName())) {
                taskToDelete = task;
                break;
            }
        }

        //deletes the task if a match was found and shows a success message, else shows a failure message
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
    //this method resets and sets the corresponding button flags, closes the task options menu, 
    //and then runs the task menu screen method
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
        //gets the details of the task for the variables - GETTERS
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
//this class helps call the background panel as it needs to customise the paint Component

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
