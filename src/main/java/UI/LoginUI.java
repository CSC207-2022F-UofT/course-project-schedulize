package UI;

import use_cases.login.LoginController;
import use_cases.login.LoginException;

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
    private final WindowManager programWindows;
    private final LoginController controller;

    /**
     * Default constructor for Login UI
     */
    public LoginUI(WindowManager existingWindows, LoginController controller) {
        super();
        this.controller = controller;
        // store reference to existing windows in program
        this.programWindows = existingWindows;
        this.programWindows.addWindow(WindowManager.LOGIN_REFERENCE_KEY, this);
        // configure default frame attributes
        this.configureFrame();
        this.centreWindow();
        this.setListeners();
        this.programWindows.openWindow(WindowManager.LOGIN_REFERENCE_KEY);
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
                try {
                    controller.login(userInputField.getText(), passwordField.getText());
                } catch (LoginException error){
                    errorLabel.setText(error.getMessage());
                    return;
                }
                errorLabel.setText("");
                // TODO: Connect to Dashboard
                programWindows.closeWindow(WindowManager.LOGIN_REFERENCE_KEY);
            }
        });
    }

    /**
     * Action Listener for createAccount label clicked that opens the login window and closes this window
     */
    private void createAccountListener() {
        createAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                programWindows.closeWindow(WindowManager.LOGIN_REFERENCE_KEY);
                programWindows.openWindow(WindowManager.REGISTRATION_REFERENCE_KEY);
            }
        });
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);

        // reset fields when opening or closing this window
        this.userInputField.setText("");
        this.passwordField.setText("");
        this.passwordField.setPwVisibility(true);
        this.errorLabel.setText("");

        // recenter the window
        this.centreWindow();
    }
}
