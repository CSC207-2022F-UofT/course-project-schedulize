package UI;

import javax.swing.*;

/**
 * An interface for managing the existing UI windows in the program
 * Created: 11/11/2022
 * Last updated: 11/10/2022
 *
 * @author David Adler
 */
public interface WindowManager {
    public JFrame getWindow(String key);
    public void addWindow(String key, JFrame window);
}
