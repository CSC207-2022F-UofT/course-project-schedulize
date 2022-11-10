package UI;

import javax.swing.*;

/**
 * A class that contains the GUI for creating a new account
 * Created: 11/10/2022
 * Last updated: 11/10/2022
 *
 * @author David Adler
 */
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
    private JButton createAccountButton;
    private JLabel login;

    /**
     * Default constructor for the create account window
     */
    public CreateAccountUI() {
        super();
        this.setPasswordFieldSize();
        this.configureFrame();
        this.setVisible(true);
        this.centreWindow();
        this.setListeners();
    }

    /**
     * Set the password field's size so that it matches other components
     */
    private void setPasswordFieldSize() {
        // set the input field size
        this.passwordField.reconfigureFieldSize(190, 10);
        // set the label size
        this.passwordField.reconfigureLabelSize(130, 10);
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

    /**
     * Connects all action listeners for this window
     */
    private void setListeners() {
    }

    // TODO: Delete During Deployment
    public static void main(String[] args) {
        JFrame window = new CreateAccountUI();
    }
}
