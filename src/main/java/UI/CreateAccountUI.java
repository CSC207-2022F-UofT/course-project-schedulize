package UI;

import javax.swing.*;

public class CreateAccountUI extends JFrame {
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

    public CreateAccountUI() {
        super();
        this.setContentPane(this.mainPanel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame window = new CreateAccountUI();
    }
}
