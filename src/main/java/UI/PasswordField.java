package UI;

import Config.PathManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A class that contains a custom Swing component, representing the GUI for a password input field
 * Created: 11/10/2022
 * Last updated: 11/10/2022
 *
 * @author David Adler
 */
public class PasswordField extends JPanel {
    private JLabel passwordLabel;
    private JLabel pwVisibility;
    private JPasswordField passwordField;
    private boolean pwIsVisible;

    /**
     * Default constructor for this component
     */
    public PasswordField() {
        // constants representing the gap between subcomponents in its layout
        final int HORIZONTAL_COMPONENT_GAP = 10;
        final int VERTICAL_COMPONENT_GAP = 0;

        // set layout
        this.setLayout(new BorderLayout(HORIZONTAL_COMPONENT_GAP, VERTICAL_COMPONENT_GAP));
        // configure subcomponent defaults
        this.configureSubComponents();
        // configure password visibility listener
        this.pwVisibilityListener();
    }

    /**
     * Configures defaults for all subComponents
     */
    private void configureSubComponents() {
        // configure the password input field
        this.configurePasswordField();
        // configure the visibility button
        this.configurePasswordVisibility();
        // configure the password label
        this.configurePasswordLabel();
    }

    /**
     * Configures the label for the password input field
     */
    private void configurePasswordLabel() {
        // initialize and set label text
        this.passwordLabel = new JLabel("Password");
        // set label alignment
        this.passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // set preferred size
        this.passwordLabel.setPreferredSize(new Dimension(90, 20));
        // add it to this component's layout
        this.add(passwordLabel, BorderLayout.WEST);
    }

    /**
     * Configure the password input field
     */
    private void configurePasswordField() {
        // initialize
        this.passwordField = new JPasswordField();
        // set preferred dimensions
        this.passwordField.setPreferredSize(new Dimension(175, 20));
        // set char that masks user input
        this.passwordField.setEchoChar('*');
        // add it to this component's layout
        this.add(passwordField, BorderLayout.CENTER);
    }

    /**
     * Configure the password visibility button
     */
    private void configurePasswordVisibility() {
        // initialize
        this.pwVisibility = new JLabel();
        // set default icon
        String filePath = PathManager.getIconDirectory().concat("\\eye.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(filePath);
        pwVisibility.setIcon(new ImageIcon(icon));
        // set visibility bool to false (defaults to invisible)
        this.pwIsVisible = false;
        // add it to this component's layout
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

    /**
     * Set this password to be visible or invisible
     * @param isVisible boolean which represents whether password is visible (True) or invisible (False)
     */
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

    /**
     * Sets the text in the password input field
     * @param password text to set in the password input field
     */
    public void setText(String password) {
        this.passwordField.setText(password);
    }

    /**
     * Gets the password from the password input field
     * @return String representing this password
     */
    public String getText() {
        return new String(this.passwordField.getPassword());
    }

    /**
     * Reconfigures password label size for given window
     * @param width new preferred label width
     * @param height new preferred label height
     */
    public void reconfigureLabelSize(int width, int height) {
        this.passwordLabel.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Reconfigures password input field size for given window
     * @param width new preferred field width
     * @param height new preferred field height
     */
    public void reconfigureFieldSize(int width, int height) {
        this.passwordField.setPreferredSize(new Dimension(width, height));
    }

    // TODO: REMOVE DURING DEPLOYMENT
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
