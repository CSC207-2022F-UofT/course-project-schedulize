package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A LoginUI class, implements the JFrame interface which makes it a moveable window.
 * Created: 11/08/2022
 * Last updated: 11/08/2022
 *
 * @author David Adler
 */
public class LoginUI extends JFrame {
    private JPanel mainPanel;
    private JTextField userInputField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JLabel createAccount;
    private JLabel pwVisibility;
    private JLabel errorLabel;
    private boolean pwIsVisible;

    /**
     * Default constructor for Login UI
     */
    public LoginUI() {
        super();
        // configure default frame attributes
        this.configureFrame();
        // set Icons
        this.setDefaultIcons();
        // center frame on screen
        this.centreWindow();
        // set event listeners
        this.setListeners();
        // show the window
        this.setVisible(true);
        this.pwIsVisible = false;
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
     * Sets the default icons for all aspects of this window
     */
    private void setDefaultIcons() {
        // set Frame icon
        String filePath = PathManager.getIconDirectory().concat("\\acorn.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(filePath);
        this.setIconImage(icon);

        // set password visibility icon
        filePath = PathManager.getIconDirectory().concat("\\eye.png");
        icon = Toolkit.getDefaultToolkit().getImage(filePath);
        pwVisibility.setIcon(new ImageIcon(icon));
    }

    /**
     * Centers the JFrame window on the screen
     */
    private void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }

    /**
     * Connects all action listeners for this window
     */
    private void setListeners() {
        loginListener();
        createAccountListener();
        pwVisibilityListener();
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
        createAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO: Connect to CreateAccount UI
                System.out.println("reached!");
            }
        });
    }

    /**
     * ActionListener for pwVisibility label clicked -- displays or hides user input password
     */
    private void pwVisibilityListener() {
        pwVisibility.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (pwIsVisible) {
                    String filePath = PathManager.getIconDirectory().concat("\\eye.png");
                    pwVisibility.setIcon(new ImageIcon(filePath));
                    passwordField.setEchoChar('*');
                    pwIsVisible = false;
                } else {
                    String filePath = PathManager.getIconDirectory().concat("\\eye-close.png");
                    pwVisibility.setIcon(new ImageIcon(filePath));
                    passwordField.setEchoChar((char) 0);
                    pwIsVisible = true;
                }
            }
        });
    }

    // TODO: Delete for Deployment
    public static void main(String[] args) {
        JFrame window = new LoginUI();
    }
}
