package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JLabel errorLabel;
    private final WindowManager programWindows;
    public static final String WINDOW_REFERENCE_KEY = "userRegistration";

    /**
     * Default constructor for the create account window
     */
    public CreateAccountUI(WindowManager existingWindows) {
        super();
        // store reference to existing windows in program
        this.programWindows = existingWindows;
        this.programWindows.addWindow(WINDOW_REFERENCE_KEY, this);
        // configure default frame attributes
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
        this.setSize(400, 300);
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
        this.passwordSuggestionListener();
    }

    /**
     * Action Listener for login label clicked
     */
    private void loginListener() {
        JFrame createAccountWindow = this;
        this.login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createAccountWindow.setVisible(false);
                programWindows.getWindow(LoginUI.WINDOW_REFERENCE_KEY).setVisible(true);
            }
        });
    }

    /**
     * Action Listener for clicking the suggest password label
     */
    private void passwordSuggestionListener() {
        this.suggestPwLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO: Implement password suggester
                System.out.println("reached!");
            }
        });
    }

    /**
     * Action Listener for loginButton clicked
     */
    private void createAccountListener() {
        this.createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Connect to createAccount Use Case
                errorLabel.setText("Devs didn't connect this LOL");
                System.out.println("reached!");
            }
        });
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);

        // reset fields when opening or closing this window
        this.usernameField.setText("");
        this.confirmPasswordField.setText("");
        this.emailField.setText("");
        this.passwordField.setText("");
        this.passwordField.setPwVisibility(true);
        this.errorLabel.setText("");

        // recenter the window
        this.centreWindow();
    }
}
