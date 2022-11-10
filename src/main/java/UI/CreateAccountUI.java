package UI;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JFrame loginWindow;

    /**
     * Default constructor for the create account window
     */
    public CreateAccountUI() {
        super();
        this.setPasswordFieldSize();
        this.configureFrame();
        this.setVisible(false);
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
        this.loginListener();
    }

    /**
     * Set the login window used when toggling between this screen and the login screen
     * @param window a JFrame representing a login window
     */
    public void setLoginWindow(JFrame window) {
        this.loginWindow = window;
    }

    /**
     * Action Listener for login label clicked
     */
    private void loginListener() {
        JFrame createAccountWindow = this;
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createAccountWindow.setVisible(false);
                loginWindow.setVisible(true);
            }
        });
    }
}
