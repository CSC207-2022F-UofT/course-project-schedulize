package task_display_ui;

import UI.CentralWindow;
import use_cases.complete_task.CompleteTaskController;
import use_cases.complete_task.CompleteTaskPresenter;
import use_cases.complete_task.CompleteTaskUseCase;

import javax.swing.*;
import java.util.ArrayList;

/**
 * A TaskUI class, implements the JFrame interface which makes it a moveable window.
 * Created: 11/10/2022
 * Last updated: 11/10/2022
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

    public TaskUI(CompleteTaskController controller) {
        super();
        // configure default frame attributes
        this.configureFrame();
        this.setListeners();
        this.controller = controller;
    }

    /**
     * Sets default aspects of the JFrame window, like size and title
     */
    private void configureFrame() {
        // set Frame title
        this.setTitle("taskNameLabelTemp");
        // set Frame window size
        this.setSize(350, 250);
        // disable resizability
        this.setResizable(false);
        // set close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    }

    /**
     * Updates the view with the requisite information
     *
     * @param taskUiModel
     */
    public void updateView(TaskUiModel taskUiModel) {
        this.taskUiModel = taskUiModel;
        this.setTitle(taskUiModel.getName());
        this.descriptionLabel.setText(taskUiModel.getDescription());
        this.progressBar1.setValue(taskUiModel.getCompletion());
    }

    /**
     * Listener for setting the task as complete
     */
    public void setCompletionListener(){
        this.completeCheck.addActionListener(actionEvent -> {
            if (completeCheck.isSelected()) {
                controller.completeTask(taskUiModel.getCurriculumID(), taskUiModel.getTaskID());
            }
        });
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        this.completeCheck.setSelected(false);
        // recenter the window
        this.centreWindow();
    }

    // TODO: Delete task use case

    // TODO: Delete for Deployment
    public static void main(String[] args) {
        JFrame window = new TaskUI(new CompleteTaskController(new CompleteTaskUseCase(new CompleteTaskPresenter(new ArrayList<>()))));
    }
}
