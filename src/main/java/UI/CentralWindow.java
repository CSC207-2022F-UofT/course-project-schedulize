package UI;

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
    /**
     * Centers the JFrame window on the screen
     */
    protected void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }
}
