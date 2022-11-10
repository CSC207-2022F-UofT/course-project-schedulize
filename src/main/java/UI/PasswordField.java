package UI;

import Config.PathManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PasswordField extends JPanel {
    private JLabel passwordLabel;
    private JLabel pwVisibility;
    private JPasswordField passwordField;

    private boolean pwIsVisible;

    public PasswordField() {
        final int HORIZONTAL_COMPONENT_GAP = 10;
        final int VERTICAL_COMPONENT_GAP = 0;

        this.setLayout(new BorderLayout(HORIZONTAL_COMPONENT_GAP, VERTICAL_COMPONENT_GAP));
        this.configureSubComponents();
        this.pwVisibilityListener();
    }

    private void configureSubComponents() {
        this.configurePasswordField();
        this.configurePasswordVisibility();
        this.configurePasswordLabel();
    }

    private void configurePasswordLabel() {
        this.passwordLabel = new JLabel("Password");
        this.passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.passwordLabel.setPreferredSize(new Dimension(90, 20));

        this.add(passwordLabel, BorderLayout.WEST);
    }

    private void configurePasswordField() {
        this.passwordField = new JPasswordField();
        this.passwordField.setPreferredSize(new Dimension(175, 20));
        this.passwordField.setEchoChar('*');

        this.add(passwordField, BorderLayout.CENTER);
    }

    private void configurePasswordVisibility() {
        this.pwVisibility = new JLabel();

        String filePath = PathManager.getIconDirectory().concat("\\eye.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(filePath);
        pwVisibility.setIcon(new ImageIcon(icon));

        this.pwIsVisible = false;
        this.add(pwVisibility, BorderLayout.EAST);
    }

    /**
     * ActionListener for pwVisibility label clicked -- displays or hides user input password
     */
    private void pwVisibilityListener() {
        pwVisibility.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setPwVisibility(pwIsVisible);
            }
        });
    }

    public void setPwVisibility(boolean isVisible) {
        if (isVisible) {
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

    public void setText(String password) {
        this.passwordField.setText(password);
    }

    public String getText() {
        return new String(this.passwordField.getPassword());
    }

    public void reconfigureLabelSize(int width, int height) {
        this.passwordLabel.setPreferredSize(new Dimension(width, height));
    }

    public void reconfigureFieldSize(int width, int height) {
        this.passwordField.setPreferredSize(new Dimension(width, height));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new PasswordField(), BorderLayout.CENTER);
        frame.pack();
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
