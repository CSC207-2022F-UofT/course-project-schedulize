package UI.create_task_UI;

import UI.*;
import use_cases.add_task.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A UI class for inputting information to create a new task
 * Created: 12/01/2022
 * Last updated: 12/01/2022
 *
 * @author David Adler
 */
public class CreateTaskUI extends CentralWindow implements TaskDependentWindow, CurriculumDependentWindow {
    private final WindowManager programWindows;
    private final AddTaskController taskController;
    private JPanel mainPanel;
    private JTextField taskNameField;
    private JTextPane descriptionPane;
    private JButton confirmButton;
    private JButton cancelButton;

    private int parentTaskId;
    private int parentCurriculumId;

    /**
     * The constructor for this UI that configures this frame's defaults
     * @param programWindows the window manager for storing and toggling program windows
     * @param taskController the controller for adding this new task to a User's curriculum
     */
    public CreateTaskUI(WindowManager programWindows, AddTaskController taskController) {
        this.programWindows = programWindows;
        this.programWindows.addWindow(WindowManager.CREATE_TASK_REFERENCE_KEY, this);
        this.taskController = taskController;
        this.setContentPane(mainPanel);
        this.configureFrame();
        this.centreWindow();
        this.setListeners();
    }

    /**
     * Sets default aspects of the JFrame window, like size and title
     */
    private void configureFrame() {
        // set Frame title
        this.setTitle("Create a new Task");
        // set Frame window size
        this.setSize(400, 450);
        // disable resizability
        this.setResizable(false);
        // set content, configured in form file
        this.setContentPane(mainPanel);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        this.centreWindow();
        this.taskNameField.setText("");
        this.descriptionPane.setText("");
    }

    /**
     * Sets the parent task ID (the super task of this one in a hierarchy) of the new task that will be generated by
     * this window
     *
     * @param taskID the new parent task ID
     */
    @Override
    public void setTaskID(int taskID) {
        this.parentTaskId = taskID;
    }

    /**
     * Sets the parent curriculum ID of the new task that will be generated by this window
     * (i.e. which curriculum this new task is added to)
     *
     * @param curriculumID the new parent curriculum ID
     */
    @Override
    public void setCurriculumID(int curriculumID) {
        this.parentCurriculumId = curriculumID;
    }

    /**
     * Configures the event listeners for items on this window
     */
    private void setListeners() {
        this.cancelButtonListener();
        this.confirmButtonListener();
    }

    /**
     * Creates and configures the action listener for the confirm button -- when clicked, generates the new task
     */
    private void confirmButtonListener() {
        this.confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = taskNameField.getText();
                String description = descriptionPane.getText();
                if (!name.equals("")) {
                    taskController.addTask(name, description, parentTaskId, parentCurriculumId);
                    programWindows.openWindow(WindowManager.TASKTREE_REFERENCE_KEY);
                    programWindows.closeWindow(WindowManager.CREATE_TASK_REFERENCE_KEY);
                }
            }
        });
    }

    /**
     * Creates and configures the action listener for the cancel button -- closes this window
     */
    private void cancelButtonListener() {
        this.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                programWindows.openWindow(WindowManager.TASKTREE_REFERENCE_KEY);
                programWindows.closeWindow(WindowManager.CREATE_TASK_REFERENCE_KEY);
            }
        });
    }
}
