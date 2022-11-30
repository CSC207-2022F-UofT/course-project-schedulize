package task_creation_ui;

import UI.CentralWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateTaskUI extends CentralWindow{
    private JTextField nameField;
    private JTextField descField;
    private JTextField duraField;
    private JPanel mainPanel;
    private JButton doneButton;

    public CreateTaskUI(){
        super();
        // configure default frame attributes
        this.configureFrame();
        // show the window
        this.setVisible(true);
    }

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

    private void createTaskListener() {
        this.doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    // TODO: Delete for Deployment
    public static void main(String[] args) {
        JFrame window = new CreateTaskUI();
    }
}
