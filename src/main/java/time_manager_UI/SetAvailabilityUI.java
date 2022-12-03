package time_manager_UI;

/**
 * A SetAvailabilityUI that uses JFrame to allow a User to input their available time during the days of the week.
 * Created:2022-12-01
 * Last updated:2022-12-02
 *
 * @author Amir Bare
 */

import UI.CentralWindow;
import UI.WindowManager;
import set_availability.SetAvailabilityController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetAvailabilityUI extends CentralWindow {

    private JTextField sundayFrom;
    private JTextField sundayTo;
    private JTextField saturdayFrom;
    private JTextField saturdayTo;
    private JTextField fridayFrom;
    private JTextField fridayTo;
    private JTextField thursdayFrom;
    private JTextField thursdayTo;
    private JTextField wednesdayTo;
    private JTextField tuesdayFrom;
    private JTextField tuesdayTo;
    private JTextField mondayFrom;
    private JTextField mondayTo;
    private JButton confirmButton;
    private JTextField wednesdayFrom;
    private JPanel panelMain;
    private final SetAvailabilityController controller;
    private final WindowManager programWindows;

    /**
     * Constructor for the UI
     * @param existingWindows
     * @param controller
     */

    public SetAvailabilityUI(WindowManager existingWindows, SetAvailabilityController controller) {

        super();
        this.programWindows = existingWindows;
        this.programWindows.addWindow("availability", this);
        this.controller = controller;
        this.setTitle("User Availability");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.centreWindow();
        confirmButton.addActionListener(new ActionListener() {
            List<String> text = new ArrayList<>();
            @Override
            public void actionPerformed(ActionEvent e) {
                text.add(mondayFrom.getText() + mondayTo.getText());
                text.add(tuesdayFrom.getText() + tuesdayTo.getText());
                text.add(wednesdayFrom.getText() + wednesdayTo.getText());
                text.add(thursdayFrom.getText() + thursdayTo.getText());
                text.add(fridayFrom.getText() + fridayTo.getText());
                text.add(saturdayFrom.getText() + saturdayTo.getText());
                text.add(sundayFrom.getText() + sundayTo.getText());
                String[] avaiabilityArray = new String[text.size()];
                text.toArray(avaiabilityArray);
                controller.create(avaiabilityArray, 0);
                /**
                 * Setting the textbox to empty after user confirms their availability
                 *
                 */
                mondayFrom.setText("");
                mondayTo.setText("");
                tuesdayFrom.setText("");
                tuesdayTo.setText("");
                wednesdayFrom.setText("");
                wednesdayTo.setText("");
                thursdayFrom.setText("");
                thursdayTo.setText("");
                fridayFrom.setText("");
                fridayTo.setText("");
                saturdayFrom.setText("");
                saturdayTo.setText("");
                sundayFrom.setText("");
                sundayTo.setText("");
            }
        });
    }

    /** Method that creates a pop-up message to tell user of confirmation.
     *
     * @param message message confirmation
     */
    public void successfullySet(String message) {
        JOptionPane.showMessageDialog(confirmButton, "Availability has been set");
    }
}




