package UI;

import Config.PathManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateAccountUI extends CentralWindow {
    private JTextField emailField;
    private JLabel emailLabel;
    private JTextField usernameField;
    private JLabel usernameLabel;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel passwordLabel;
    private JLabel repeatPasswordLabel;
    private JPanel mainPanel;
    private JLabel suggestPwLabel;
    private JLabel pwVisibility;
    private boolean pwIsVisible;

    public CreateAccountUI() {
        super();
        this.configureFrame();
        this.setVisible(true);
        this.centreWindow();
        this.setListeners();
        pwIsVisible = false;
    }

    /**
     * Sets default aspects of the JFrame window, like size and title
     */
    private void configureFrame() {
        // set Frame title
        this.setTitle("Schedulize New User Registration");
        // set Frame window size
        this.setSize(400, 300);
        // set Icons
        this.setDefaultIcons();
        // disable resizability
        this.setResizable(false);
        // set close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set content, configured in form file
        this.setContentPane(mainPanel);
    }

    private void setListeners() {
        this.pwVisibilityListener();
    }

    /**
     * Sets the default icons for all UI components in this Frame
     */
    private void setDefaultIcons() {
        // set password visibility icon
        String filePath = PathManager.getIconDirectory().concat("\\eye.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(filePath);
        pwVisibility.setIcon(new ImageIcon(icon));
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

    // TODO: Delete During Deployment
    public static void main(String[] args) {
        JFrame window = new CreateAccountUI();
    }
}
