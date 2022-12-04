package UI.task_UI;

import UI.CentralWindow;
import UI.WindowManager;
import use_cases.task_display_UI.TaskUiController;
import use_cases.task_display_UI.TaskUiModel;
import use_cases.task_display_UI.TaskUiViewInterface;
import use_cases.complete_task.CompleteTaskController;

import javax.swing.*;

/**
 * A TaskUI class, implements the JFrame interface which makes it a movable window.
 * Created: 11/10/2022
 * Last updated: 12/01/2022
 *
 * @author Oswin Gan
 */

public class TaskUI extends CentralWindow implements TaskUiViewInterface {
    private JPanel mainPanel;
    private JProgressBar progressBar1;
    private JCheckBox completeCheck;
    private JButton deleteTaskButton;
    private JLabel descriptionLabel;
    private final CompleteTaskController controller;
    private TaskUiModel taskUiModel;
    private final TaskUiController displayController;
    private final WindowManager programWindows;

    /**
     * Constructs a TaskUI JPanel object
     *
     * @param existingWindows The WindowManager responsible for this window
     * @param controller A controller to initialize the complete task use case
     * @param displayController A controller to populate this view with relevant Task information
     */
    public TaskUI(WindowManager existingWindows, CompleteTaskController controller, TaskUiController displayController) {
        super();
        this.programWindows = existingWindows;
        this.programWindows.addWindow(WindowManager.TASK_REFERENCE_KEY, this);
        // configure default frame attributes
        this.configureFrame();
        this.setListeners();
        this.controller = controller;
        this.displayController = displayController;
    }

    /**
     * Sets default aspects of the JFrame window, like size and title
     */
    private void configureFrame() {
        // set Frame title
        this.setTitle("Task");
        // set Frame window size
        this.setSize(350, 250);
        // disable resizability
        this.setResizable(false);
        // set content, configured in form file
        this.setContentPane(mainPanel);
        // centres window
        this.centreWindow();
    }

    /**
     * Connects all action listeners for this window
     */
    private void setListeners() {
        this.setCompletionListener();
        this.setDeleteTaskListener();
    }

    /**
     * Updates the view with the requisite information
     *
     * @param taskUiModel Model containing task information
     */
    @Override
    public void updateView(TaskUiModel taskUiModel) {
        this.taskUiModel = taskUiModel;
        this.setTitle(taskUiModel.getName());
        this.descriptionLabel.setText(taskUiModel.getDescription());
        this.progressBar1.setValue(taskUiModel.getCompletion());
    }

    /**
     * Listener for setting the task as complete
     */
    private void setCompletionListener(){
        this.completeCheck.addActionListener(actionEvent -> {
            if (completeCheck.isSelected()) {
                controller.completeTask(taskUiModel.getCurriculumID(), taskUiModel.getTaskID());
            }
        });
    }

    /**
     * Listener for setting the task as complete
     */
    private void setDeleteTaskListener(){
        this.deleteTaskButton.addActionListener(actionEvent -> {
            programWindows.closeWindow(WindowManager.TASK_REFERENCE_KEY);
            programWindows.openWindow(WindowManager.TASKTREE_REFERENCE_KEY);
        });
    }

    /**
     * Populates the view with the current information
     * @param curriculumID ID of the curriculum
     * @param taskID ID of the task
     */
    public void populateView(int curriculumID, int taskID) {
        this.displayController.callInteractor(curriculumID, taskID);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        this.completeCheck.setSelected(false);
        // recenter the window
        this.centreWindow();
    }
}
