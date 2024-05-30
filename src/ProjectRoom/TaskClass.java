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

    //creates the array list used to save all the information entered for the tasks
    private List<Task> tasks = new ArrayList<>();

//---------------------------------------------------------------------------------------------------------------------------------------------
//method for the creation of the menu that the user can select from to decide if they want to add tasks, 
//show a report (which shows a coming soon page) and if they want to quit the program
//this method specifies the dimensions of the panels, the labels of the buttons,
//and adds action listeners for the menu while loop 
    public JPanel createTaskMenuPanel() {
        //creates the layout to be used on the panel
        JPanel taskMenuPanel = new JPanel(new GridLayout(3, 1));

        //sets the custom dimensions of the panel
        taskMenuPanel.setPreferredSize(new Dimension(200, 150));

        //creates the 3 numeric buttons for the menu
        JButton addTaskButton = new JButton("1. Add Task");
        JButton showReportButton = new JButton("2. Show Report");
        JButton quitButton = new JButton("3. Quit");

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

        //adds the buttons to the panel
        taskMenuPanel.add(addTaskButton);
        taskMenuPanel.add(showReportButton);
        taskMenuPanel.add(quitButton);

        return taskMenuPanel;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------
//This method creates the panel for the form where the user adds all the information needed for the tasks
//it specifies the dimensions, labels, textboxes as well as a combo box used for the status of the task
    public JPanel createAddTaskPanel() {
        //creates the layout to be used on the panel
        JPanel taskPanel = new JPanel(new GridLayout(7, 2));

        //sets the custom dimensions of the panel
        taskPanel.setPreferredSize(new Dimension(400, 200));

        //sets the layout for the components on the panel
        BoxLayout layout = new BoxLayout(taskPanel, BoxLayout.Y_AXIS);
        taskPanel.setLayout(layout);

        //creates the variables for the textfields and labels for the task name
        //also adds them to the panel
        JLabel taskNameLabel = new JLabel("Task Name: ");
        taskNameField = new JTextField();
        taskPanel.add(taskNameLabel);
        taskPanel.add(taskNameField);

        //creates the variables for the textfields and labels for the task description
        //also adds them to the panel
        JLabel taskDescriptionLabel = new JLabel("Task Description: \n(Must be less than 50 characters)");
        taskDescriptionField = new JTextField();
        taskPanel.add(taskDescriptionLabel);
        taskPanel.add(taskDescriptionField);

        //creates the variables for the textfields and labels for the developer details
        //also adds them to the panel
        JLabel taskDeveloperLabel = new JLabel("Developer Details: \n(First and Last Name of Developer)");
        taskDeveloperField = new JTextField();
        taskPanel.add(taskDeveloperLabel);
        taskPanel.add(taskDeveloperField);

        //creates the variables for the textfields and labels for the task duration
        //also adds them to the panel
        JLabel taskDurationLabel = new JLabel("Task Duration: (In Hours)");
        taskDurationField = new JTextField();
        taskPanel.add(taskDurationLabel);
        taskPanel.add(taskDurationField);

        //creates the variables for the combox and labels for the task status
        //also adds them to the panel
        JLabel taskStatusLabel = new JLabel("Task Status: ");
        String[] status = {"To-Do", "Doing", "Done"};
        taskStatusField = new JComboBox<>(status);
        taskPanel.add(taskStatusLabel);
        taskPanel.add(taskStatusField);

        return taskPanel;
    }

//---------------------------------------------------------------------------------------------------------------------------------------------
//this method shows the user the task menu, then starts a while loop until the user has pressed quit, 
//the program will thus run until "quit" has been pressed
//during the while loop, it checks if the add task button was pressed or if the show report button 
//has been presed then calls the relevant methods
    public void TaskScreen() {
        //custom image
        ImageIcon plant = new ImageIcon("Pics/plant.png");

        //while loop for the menu
        while (true) {
            //calls and displays the custom menu panel
            JPanel taskMenu = createTaskMenuPanel();
            int result = JOptionPane.showConfirmDialog(null, taskMenu, "Please Select an Option",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, plant);

            //checks if the user has pressed the button to add tasks then runs the method to add tasks
            if (result == JOptionPane.OK_OPTION) {
                if (addTaskButtonPressed) {
                    handleAddTask();
                    addTaskButtonPressed = false;
                }
            } else {
                //exits the program if the quit button was pressed
                System.exit(0);
            }
            //exits the program if the quit button was pressed
            if (quitButtonPressed) {
                System.exit(0);
            }
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
    //shows the coming soon message for when the user presses the show report message
    private void handleShowReport() {
        //custom image
        ImageIcon clock = new ImageIcon("Pics/clock.png");

        //displays message
        JOptionPane.showMessageDialog(null, "Coming soon!", "Show Report",
                JOptionPane.DEFAULT_OPTION, clock);
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
}
    //-----------------------------------------------------END OF FILE---------------------------------------------------------------------   
