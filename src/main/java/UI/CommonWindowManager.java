package UI;

import javax.management.openmbean.InvalidKeyException;
import javax.swing.*;
import java.security.KeyException;
import java.util.Collection;
import java.util.HashMap;

/**
 * A class for storing references to existing windows
 * Created: 11/11/2022
 * Last updated: 11/11/2022
 *
 * @author David Adler
 */
public class CommonWindowManager implements WindowManager {
    private final HashMap<String, JFrame> existingWindows;

    /**
     * Default class constructor that initializes the window map
     */
    public CommonWindowManager() {
         this.existingWindows = new HashMap<String, JFrame>();
    }

    /**
     * Gets the requested window from the window hash map
     * @param key String reference to the requested window
     * @return Linked window if key is in hashmap
     */
    @Override
    public JFrame getWindow(String key) {
        return this.existingWindows.get(key);
    }

    /**
     * Adds requested window to the window hash map at the given key
     * @param key String reference to the requested window
     * @param window window to link to key in hashmap
     */
    @Override
    public void addWindow(String key, JFrame window) {
        this.existingWindows.put(key, window);
    }

    public void openWindow(String key) {
        this.existingWindows.get(key).setVisible(true);
    }

    /**
     * Closes the given window
     * @param key String reference to the requested window
     */
    public void closeWindow(String key) {
        this.existingWindows.get(key).setVisible(false);
    }

    /**
     * Opens the given window
     * @param key String reference to the requested window
     */
    public void removeWindow(String key) {
        JFrame frame = this.existingWindows.get(key);
        this.existingWindows.remove(key);
        frame = null;
    }
}
