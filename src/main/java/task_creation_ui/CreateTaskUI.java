package task_creation_ui;

import UI.CentralWindow;
import use_cases.add_task.AddTaskController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateTaskUI extends CentralWindow{
    private JTextField nameField;
    private JTextField descField;
    private JTextField curriculumId;
    private JPanel mainPanel;
    private JButton doneButton;
    private JTextField parentTaskIdField;
    private AddTaskController controller;

    public CreateTaskUI(AddTaskController controller){
        super();
        // configure default frame attributes
        this.configureFrame();
        // show the window
        this.setVisible(true);

        this.controller = controller;
    }

    private void configureFrame() {
        // set Frame title
        this.setTitle("Create Task");
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

    private void createTaskListener() {
        this.doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.addTask(nameField.getText(), descField.getText(),
                        Integer.parseInt(parentTaskIdField.getText()), Integer.parseInt(curriculumId.getText()));
            }
        });
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        this.nameField.setText("");
        this.descField.setText("");
        this.curriculumId.setText("");
        this.parentTaskIdField.setText("");
        // recenter the window
        this.centreWindow();
    }
}
