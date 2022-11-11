package UI;

import javax.swing.*;

public interface WindowManager {
    public JFrame getWindow(String key);
    public void addWindow(String key, JFrame window);
}
