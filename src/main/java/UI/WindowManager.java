package UI;

import javax.swing.*;

/**
 * An interface for managing the existing UI windows in the program
 * Created: 11/10/2022
 * Last updated: 11/11/2022
 *
 * @author David Adler
 */
public interface WindowManager {
    JFrame getWindow(String key);
    void addWindow(String key, JFrame window);
    void openWindow(String key);
    void closeWindow(String key);
    void removeWindow(String key);

    // reference constants for types of windows
    String REGISTRATION_REFERENCE_KEY = "userRegistration";
    String LOGIN_REFERENCE_KEY = "login";
    String AVAILABILITY_REFERENCE_KEY = "availability";


}
