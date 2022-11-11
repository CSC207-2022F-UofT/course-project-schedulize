package UI;

import javax.swing.*;
import java.util.Collection;
import java.util.HashMap;

public class CommonWindowManager implements WindowManager {
    private final HashMap<String, JFrame> existingWindows;

    public CommonWindowManager() {
         this.existingWindows = new HashMap<String, JFrame>();
    }

    @Override
    public JFrame getWindow(String key) {
        return this.existingWindows.get(key);
    }

    @Override
    public void addWindow(String key, JFrame window) {
        this.existingWindows.put(key, window);
    }

    public Collection<JFrame> getExistingWindows() {
        return this.existingWindows.values();
    }
}
