package UI;

import javax.swing.*;
import java.awt.event.*;

/**
 * A LoginUI class, implements the JFrame interface which makes it a moveable window.
 * Created: 11/08/2022
 * Last updated: 11/10/2022
 *
 * @author David Adler
 */
public class LoginUI extends CentralWindow {
    private JPanel mainPanel;
    private JTextField userInputField;
    private JLabel usernameLabel;
    private JButton loginButton;
    private JLabel createAccount;
    private JLabel errorLabel;
    private PasswordField passwordField;
    private JFrame createAccountWindow;

    /**
     * Default constructor for Login UI
     */
    public LoginUI(JFrame createAccountWindow) {
        super();
        // connect the create account window
        this.createAccountWindow = createAccountWindow;
        // configure default frame attributes
        this.configureFrame();
        // center frame on screen
        this.centreWindow();
        // set event listeners
        this.setListeners();
        // show the window
        this.setVisible(true);
    }

    /**
     * Sets default aspects of the JFrame window, like size and title
     */
    private void configureFrame() {
        // set Frame title
        this.setTitle("Schedulize Login");
        // set Frame window size
        this.setSize(350, 300);
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
        this.createAccountListener();
    }

    /**
     * Action Listener for loginButton clicked
     */
    private void loginListener() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Connect to Login Use Case
                errorLabel.setText("Devs didn't connect this LOL");
                System.out.println("reached!");
            }
        });
    }

    /**
     * Action Listener for createAccount label clicked
     */
    private void createAccountListener() {
        JFrame loginWindow = this;
        createAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginWindow.setVisible(false);
                createAccountWindow.setVisible(true);
            }
        });
    }

    // TODO: Delete for Deployment
    public static void main(String[] args) {
        CreateAccountUI createAccountWindow = new CreateAccountUI();
        JFrame mainWindow = new LoginUI(createAccountWindow);

        createAccountWindow.setLoginWindow(mainWindow);
    }
}
