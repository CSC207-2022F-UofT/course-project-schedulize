package UI;

import config.PathManager;

import javax.swing.*;
import java.awt.*;

/**
 * An abstract class that has a method for centering a window
 * Created: 11/10/2022
 * Last updated: 11/10/2022
 *
 * @author David Adler
 */
public abstract class CentralWindow extends JFrame {

    public CentralWindow() {
        this.setFrameIcon();
        this.setTitle("Schedulize");
        // set close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Centers the JFrame window on the screen
     */
    protected void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }

    /**
     * Sets the icon for this Frame
     */
    private void setFrameIcon() {
        // set Frame icon
        String filePath = PathManager.getIconDirectory().concat("\\acorn.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(filePath);
        this.setIconImage(icon);
    }
}
