package dashboardUI;

import UI.CentralWindow;

import javax.swing.*;
/**
 * A TaskUI class, implements the JFrame interface which makes it a moveable window.
 * Created: 11/10/2022
 * Last updated: 11/10/2022
 *
 * @author Oswin Gan
 */
public class TaskUI extends CentralWindow {
    private JPanel mainPanel;
    private JProgressBar progressBar1;
    private JLabel durationLabel;
    private JCheckBox completeCheck;
    private JTextArea descriptionArea;
    private JButton deleteTaskButton;

    public TaskUI(){
        super();
        // configure default frame attributes
        this.configureFrame();
        // show the window
        this.setVisible(true);
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

    // TODO: Delete for Deployment
    public static void main(String[] args) {
        JFrame window = new TaskUI();
    }
}
