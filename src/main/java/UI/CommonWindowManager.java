package UI;

import use_cases.save_user.SaveUserController;

import javax.management.openmbean.InvalidKeyException;
import javax.swing.*;
import java.awt.event.WindowEvent;
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
    private final SaveUserController saveController;

    private int numOpenWindows;

    /**
     * Default class constructor that initializes the window map
     */
    public CommonWindowManager(SaveUserController saveController) {
        this.saveController = saveController;
        this.existingWindows = new HashMap<String, JFrame>();
        this.numOpenWindows = 0;
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
        if (window.isVisible()) this.numOpenWindows += 1;
        this.setCloseListener(window);
        this.existingWindows.put(key, window);
    }

    @Override
    public void openWindow(String key) {
        this.existingWindows.get(key).setVisible(true);
        this.numOpenWindows += 1;
    }

    /**
     * Closes the given window
     * @param key String reference to the requested window
     */
    @Override
    public void closeWindow(String key) {
        this.existingWindows.get(key).setVisible(false);
        this.saveController.saveInMemoryUser();
        this.numOpenWindows -= 1;
    }

    /**
     * Opens the given window
     * @param key String reference to the requested window
     */
    @Override
    public void removeWindow(String key) {
        JFrame frame = this.existingWindows.get(key);
        this.existingWindows.remove(key);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    private void setCloseListener(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (frame.getDefaultCloseOperation() == JFrame.HIDE_ON_CLOSE) {
                    numOpenWindows -= 1;
                    if (numOpenWindows == 0) {
                        for (String reference : existingWindows.keySet()) {
                            removeWindow(reference);
                        }
                    }
                }
                else {
                    saveController.saveInMemoryUser();
                    super.windowClosing(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
    }
}
