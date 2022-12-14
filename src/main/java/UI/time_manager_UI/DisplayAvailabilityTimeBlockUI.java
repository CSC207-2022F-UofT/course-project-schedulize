package UI.time_manager_UI;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import UI.CentralWindow;
import UI.WindowManager;
import use_cases.display_availability_timeblocks.*;

import java.util.List;


/**
 * A TimeBlockManagerUi that uses JFrame to show a window that illustrates the Availability of a User.
 * Created:2022-11-26
 * Last updated:2022-12-02
 *
 * @author Amir Bare
 */
public class DisplayAvailabilityTimeBlockUI extends CentralWindow implements AvailabilityUiInterface {
    private final DisplayAvailabilityTimeBlockController displayController;
    private JPanel mainPanel;
    private JTable showTable;
    private JButton backbutton;
    private JButton setAvailabilityButton;
    private final WindowManager programWindows;

    /**
     * Default constructor for the view availability window
     *
     * @param existingWindows The WindowManager responsible for this window
     * @param displayController The controller reponsible for providing the view with relevent entity information
     */
    public DisplayAvailabilityTimeBlockUI(WindowManager existingWindows,
                                          DisplayAvailabilityTimeBlockController displayController) {
        super();
        this.programWindows = existingWindows;
        this.programWindows.addWindow(WindowManager.AVAILABILITY_REFERENCE_KEY, this);
        this.displayController = displayController;
        this.uiSettings();
        this.backbuttonListener();
        this.setAvailabilityButtonListener();
    }

    /**
     * Action Listener for the set availability button
     */
    private void setAvailabilityButtonListener() {
        setAvailabilityButton.addActionListener(e -> {
            programWindows.closeWindow(WindowManager.AVAILABILITY_REFERENCE_KEY);
            programWindows.openWindow(WindowManager.SET_AVAILABILITY_REFERENCE_KEY);
        });
    }

    /**
     * Action Listener for the back button
     */
    private void backbuttonListener() {
        backbutton.addActionListener(e -> {
            programWindows.closeWindow(WindowManager.AVAILABILITY_REFERENCE_KEY);
            programWindows.openWindow(WindowManager.DASHBOARD_REFERENCE_KEY);
        });
    }

    /**
     * Settings that allow the Frame of the user's availability window to appear
     */
    private void uiSettings() {
        this.setTitle("User Availability");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.centreWindow();
        showTable.setEnabled(false);
    }

    /**
     * Generates the table of available times per this Schedule's availability
     */
    private void createTable(List<DisplayAvailabilityTimeBlockModel> availabilities){
        String[][] times = new String[7][2];
        for (int i = 0; i < 7; i++) {
            if (i < availabilities.size()) {
                times[i][0] = availabilities.get(i).getStartTime() + "0";
                times[i][1] = availabilities.get(i).getEndTime() + "0";
            } else {
                times[i][0] = "";
                times[i][1] = "";
            }
        }
        Object[][] contents = {
                {"Monday", String.format(" From   %s    to  %s ", times[0][0], times[0][1])},
                {"Tuesday", String.format(" From   %s    to  %s ", times[1][0], times[1][1])},
                {"Wednesday", String.format(" From   %s    to  %s ", times[2][0], times[2][1])},
                {"Thursday", String.format(" From   %s    to  %s ", times[3][0], times[3][1])},
                {"Friday", String.format(" From   %s    to  %s ", times[4][0], times[4][1])},
                {"Saturday", String.format(" From   %s    to  %s ", times[5][0], times[5][1])},
                {"Sunday", String.format(" From   %s    to  %s ", times[6][0], times[6][1])},
        };
        showTable.setModel(new DefaultTableModel(contents, new String[]{"Day", "Available Times"}));
        TableColumnModel columns = showTable.getColumnModel();
        columns.getColumn(0).setMinWidth(200);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);
        columns.getColumn(1).setCellRenderer(centerRenderer);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        this.displayController.displayAvailabilityTimeBlock();
    }

    /**
     * Populate this screen's availabilities with information from the availability model
     *
     * @param availability the availability model
     */
    @Override
    public void drawAvailabilities(List<DisplayAvailabilityTimeBlockModel> availability) {
        this.createTable(availability);
    }
}
