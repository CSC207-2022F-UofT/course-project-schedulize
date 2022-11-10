package UI;

import javax.swing.*;


public class CreateAccountUI extends CentralWindow {
    private JTextField emailField;
    private JLabel emailLabel;
    private JTextField usernameField;
    private JLabel usernameLabel;
    private PasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel repeatPasswordLabel;
    private JPanel mainPanel;
    private JLabel suggestPwLabel;
    private JLabel pwVisibility;

    public CreateAccountUI() {
        super();
        this.configureFrame();
        this.setVisible(true);
        this.centreWindow();
        this.setListeners();
    }

    /**
     * Sets default aspects of the JFrame window, like size and title
     */
    private void configureFrame() {
        // set Frame title
        this.setTitle("Schedulize New User Registration");
        // set Frame window size
        this.setSize(400, 300);
        // disable resizability
        this.setResizable(false);
        // set close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set content, configured in form file
        this.setContentPane(mainPanel);
    }

    private void setListeners() {
    }

    // TODO: Delete During Deployment
    public static void main(String[] args) {
        JFrame window = new CreateAccountUI();
    }
}
