package create_task_UI;

import UI.*;
import entity_factories.CommonTaskFactory;
import entity_factories.CommonTaskTreeFactory;
import entity_factories.TaskFactory;
import entity_factories.TaskTreeFactory;
import use_cases.add_task.*;
import use_cases.login.LoginException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    @Override
    public void setTaskID(int taskID) {
        this.parentTaskId = taskID;
    }

    @Override
    public void setCurriculumID(int curriculumID) {
        this.parentCurriculumId = curriculumID;
    }

    private void setListeners() {
        this.cancelButtonListener();
        this.confirmButtonListener();
    }

    private void confirmButtonListener() {
        this.confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = taskNameField.getText();
                String description = descriptionPane.getText();
                if (!name.equals("")) {
                    taskController.addTask(name, description, parentTaskId, parentCurriculumId);
                }
            }
        });
    }

    private void cancelButtonListener() {
        this.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                programWindows.closeWindow(WindowManager.CREATE_TASK_REFERENCE_KEY);
            }
        });
    }

    // TODO: Delete for deployment
    public static void main(String[] args) {
        WindowManager manager = new CommonWindowManager();
        TaskFactory taskFactory = new CommonTaskFactory();
        TaskTreeFactory treeFactory = new CommonTaskTreeFactory();
        AddTaskOutputBoundary presenter = new AddTaskPresenter();
        AddTaskInputBoundary interactor = new AddTaskUseCase(presenter, taskFactory, treeFactory);
        AddTaskController taskController = new AddTaskController(interactor);

        JFrame ui = new CreateTaskUI(manager, taskController);
        ui.setVisible(true);
    }
}
