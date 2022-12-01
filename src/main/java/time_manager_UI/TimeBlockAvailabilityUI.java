package time_manager_UI;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import UI.CentralWindow;
import UI.WindowManager;
import use_cases.display_availability_timeblocks.DisplayAvailabilityTimeBlockController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;


/**
 * A TimeBlockManagerUi that uses JFrame to show a window that illustrates the Availability of a User.
 * Created:2022-11-14
 * Last updated:2022-11-16
 *
 * @author Amir Bare
 */
public class TimeBlockAvailabilityUI extends CentralWindow {
    private JPanel mainPanel;
    private JTable showTable;
    private JButton backbutton;
    private JButton setAvailabilityButton;
    private final WindowManager appWindows;

    /**
     * Default constructor for the view availability window
     */

    public TimeBlockAvailabilityUI(WindowManager existingWindows) {
        super();
        // store reference to existing windows in program
        this.appWindows = existingWindows;
        this.appWindows.addWindow(WindowManager.AVAILABILITY_REFERENCE_KEY, this);
        this.setTitle("User Availability");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.centreWindow();
        showTable.setEnabled(false);
        createTable();

        /**
         * Action Listeners for back button and set availability button clicked
         */
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appWindows.closeWindow(WindowManager.AVAILABILITY_REFERENCE_KEY);
            }
        });

        setAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appWindows.closeWindow(WindowManager.AVAILABILITY_REFERENCE_KEY);
                appWindows.openWindow(WindowManager.AVAILABILITY_REFERENCE_KEY);
            }
        });

        showTable.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {

            }
            @Override
            public void caretPositionChanged(InputMethodEvent event){
            }
        });
    }

    /**
     * Table of two columns; day of the week and times.
     */
    private void createTable(){
        Object[][] contents = {
                {"Monday"," From       to   "},
                {"Tuesday"," From      to   "},
                {"Wednesday"," From    to   "},
                {"Thursday"," From     to   "},
                {"Friday"," From       to   "},
                {"Saturday"," From     to   "},
                {"Sunday"," From       to   "},
        };
        showTable.setModel(new DefaultTableModel(contents, new String[]{"Day", "Available Times"}));
        TableColumnModel columns = showTable.getColumnModel();
        columns.getColumn(0).setMinWidth(200);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);
        columns.getColumn(1).setCellRenderer(centerRenderer);
    }

}
