package ProjectRoom;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amelia ST10439947@vcconnect.edu.za ST10439947
 */
public class TaskClass {

    //---------------------------------------------------------------------------------------------------------------------------------------------
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

    public int numTasks;

    public int totalDuration = 0;

    private boolean quitButtonPressed = false;
    private boolean addTaskButtonPressed = false;

    private List<Task> tasks = new ArrayList<>();

    //GLOBAL VARIABLES
    //---------------------------------------------------------------------------------------------------------------------------------------------
    public JPanel createTaskMenuPanel() {
        JPanel taskMenuPanel = new JPanel(new GridLayout(3, 1));

        taskMenuPanel.setPreferredSize(new Dimension(200, 150));

        JButton addTaskButton = new JButton("1. Add Task");
        JButton showReportButton = new JButton("2. Show Report");
        JButton quitButton = new JButton("3. Quit");

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

        taskMenuPanel.add(addTaskButton);
        taskMenuPanel.add(showReportButton);
        taskMenuPanel.add(quitButton);

        return taskMenuPanel;
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------

    public JPanel createAddTaskPanel() {
        JPanel taskPanel = new JPanel(new GridLayout(7, 2));

        taskPanel.setPreferredSize(new Dimension(400, 200));

        BoxLayout layout = new BoxLayout(taskPanel, BoxLayout.Y_AXIS);
        taskPanel.setLayout(layout);

        JLabel taskNameLabel = new JLabel("Task Name: ");
        taskNameField = new JTextField();
        taskPanel.add(taskNameLabel);
        taskPanel.add(taskNameField);

        JLabel taskDescriptionLabel = new JLabel("Task Description: \n(Must be less than 50 characters)");
        taskDescriptionField = new JTextField();
        taskPanel.add(taskDescriptionLabel);
        taskPanel.add(taskDescriptionField);

        JLabel taskDeveloperLabel = new JLabel("Developer Details: \n(First and Last Name of Developer)");
        taskDeveloperField = new JTextField();
        taskPanel.add(taskDeveloperLabel);
        taskPanel.add(taskDeveloperField);

        JLabel taskDurationLabel = new JLabel("Task Duration: (In Hours)");
        taskDurationField = new JTextField();
        taskPanel.add(taskDurationLabel);
        taskPanel.add(taskDurationField);

        JLabel taskStatusLabel = new JLabel("Task Status: ");
        String[] status = {"To-Do", "Doing", "Done"};
        taskStatusField = new JComboBox<>(status);
        taskPanel.add(taskStatusLabel);
        taskPanel.add(taskStatusField);

        return taskPanel;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------

    public void TaskScreen() {

        ImageIcon plant = new ImageIcon("Pics/plant.png");

        while (true) {
            JPanel taskMenu = createTaskMenuPanel();

            int result = JOptionPane.showConfirmDialog(null, taskMenu, "Please Select an Option",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, plant);

            if (result == JOptionPane.OK_OPTION) {

                if (addTaskButtonPressed) {
                    handleAddTask();

                    addTaskButtonPressed = false;
                }
            } else {
                System.exit(0);
            }
            if (quitButtonPressed) {
                System.exit(0);
            }
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------

    public void handleAddTask() {

        ImageIcon butterfly = new ImageIcon("Pics/butterfly.png");
        ImageIcon error = new ImageIcon("Pics/error.png");
        ImageIcon clock = new ImageIcon("Pics/clock.png");
        ImageIcon notepad = new ImageIcon("Pics/notepad.png");

        boolean validInput = false;
        
        numTasks = 0;

        while (!validInput) {
            String userInput = (String) JOptionPane.showInputDialog(null, "How many tasks would you "
                    + "like to add?", "Add Tasks", JOptionPane.DEFAULT_OPTION, butterfly, null, null);
            if (userInput == null) {
                return;
            }

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

        for (int i = 0; i < numTasks; i++) {

            JPanel addTask = createAddTaskPanel();

            int result = JOptionPane.showConfirmDialog(null, addTask, "Please enter task details.",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, notepad);

            if (result == JOptionPane.OK_OPTION) {
                taskName = taskNameField.getText();
                taskDescription = taskDescriptionField.getText();
                taskDeveloper = taskDeveloperField.getText();
                taskDuration = Integer.parseInt(taskDurationField.getText());
                taskStatus = (String) taskStatusField.getSelectedItem();

                if (!checkTaskDescription()) {
                    i--;
                    continue;
                }

                String taskID = createTaskID(taskName, taskDeveloper, tasks.size() + 1);

                Task task = new Task(taskID, taskName, taskDescription, taskDeveloper, taskDuration, taskStatus);
                tasks.add(task);

                showTaskSummary(task);

            }
        }
        int totalHours = returnTotalHours();

        JOptionPane.showMessageDialog(null, "Total Duration of All Tasks: " + totalHours + " hours.", "Duration Summary",
                JOptionPane.DEFAULT_OPTION, clock);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    private void handleShowReport() {
        ImageIcon clock = new ImageIcon("Pics/clock.png");

        JOptionPane.showMessageDialog(null, "Coming soon!", "Show Report",
                JOptionPane.DEFAULT_OPTION, clock);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    private void handleQuit() {
        quitButtonPressed = true;
        System.exit(0);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    public boolean checkTaskDescription() {
        ImageIcon error = new ImageIcon("Pics/error.png");

        String checkDesc = taskDescriptionField.getText();

        if (checkDesc.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than\n"
                    + "50 characters", "Incorrect Format", JOptionPane.DEFAULT_OPTION, error);
            return false;
        }

        return true;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------

    public String createTaskID(String taskName, String taskDeveloper, int numTasks) {
        String taskInitials = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase()
                : taskName.toUpperCase();
        String developerInitials = taskDeveloper.length() >= 3
                ? taskDeveloper.substring(taskDeveloper.length() - 3).toUpperCase()
                : taskDeveloper.toUpperCase();
        String taskID = String.format("%s:%d:%s", taskInitials, numTasks, developerInitials);
        return taskID;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    public void showTaskSummary(Task task) {
        ImageIcon pinkflower = new ImageIcon("Pics/pinkflower.png");

        String summary = printTaskDetails(task);
        JOptionPane.showMessageDialog(null, summary, "Task " + numTasks + " Summary",
                JOptionPane.OK_CANCEL_OPTION, pinkflower);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    public String printTaskDetails(Task task) {

        return String.format(
                "Task Status: %s\nTask Developer:  %s\nTask Number: %d\nTask Name: %s"
                + "\nTask Description: %s\nTask ID: %s\nTask Duration: %d hours\n", task.getTaskStatus(),
                task.getTaskDeveloper(), numTasks, task.getTaskName(), task.getTaskDescription(),
                task.getTaskID(), task.getTaskDuration());

    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    public int returnTotalHours() {
        totalDuration = 0;
        for (Task task : tasks) {
            totalDuration += (task.getTaskDuration());
        }
        return totalDuration;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    public class Task {

        String taskID;
        String taskName;
        String taskDescription;
        String taskDeveloper;
        int taskDuration;
        String taskStatus;

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

        public String getTaskID() {
            return taskID;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getTaskDescription() {
            return taskDescription;
        }

        public String getTaskDeveloper() {
            return taskDeveloper;
        }

        public int getTaskDuration() {
            return taskDuration;
        }

        public String getTaskStatus() {
            return taskStatus;
        }

    }
    //-------------------------------------------------------END---OF---FILE----------------------------------------------------------------
}
