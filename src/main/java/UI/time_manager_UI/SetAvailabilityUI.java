package UI.time_manager_UI;

import UI.CentralWindow;
import UI.WindowManager;
import use_cases.set_availability.SetAvailabilityController;
import use_cases.set_availability.SetAvailabilityViewInterface;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A SetAvailabilityUI that uses JFrame to allow a User to input their available time during the days of the week.
 * Created:2022-12-01
 * Last updated:2022-12-02
 *
 * @author Amir Bare
 */
public class SetAvailabilityUI extends CentralWindow implements SetAvailabilityViewInterface {

    private JTextField sundayFrom;
    private JTextField sundayTo;
    private JTextField saturdayFrom;
    private JTextField saturdayTo;
    private JTextField fridayFrom;
    private JTextField fridayTo;
    private JTextField thursdayFrom;
    private JTextField thursdayTo;
    private JTextField wednesdayFrom;
    private JTextField tuesdayFrom;
    private JTextField tuesdayTo;
    private JTextField mondayFrom;
    private JTextField mondayTo;
    private JButton confirmButton;
    private JTextField wednesdayTo;
    private JPanel panelMain;
    private JButton backButton;
    private JLabel errorLabel;
    private final SetAvailabilityController controller;
    private final WindowManager programWindows;

    /**
     * Default constructor for the SetAvailabilityUI
     *
     * @param existingWindows the reference to the window manager for opening and closing other windows
     * @param controller controller that gets info that the UI can then show to the user
     */
    public SetAvailabilityUI(WindowManager existingWindows, SetAvailabilityController controller) {
        super();
        this.programWindows = existingWindows;
        this.programWindows.addWindow(WindowManager.SET_AVAILABILITY_REFERENCE_KEY, this);
        this.controller = controller;
        this.uiSettings();
        this.confirmListener();
        this.setText();
        this.setBackButtonListener();
    }

    /**
     * Settings that allow the Frame of the set availability window to appear
     */
    private void uiSettings() {
        this.setTitle("Set Availability");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.centreWindow();
    }

    /**
     * Method that updates the textboxes upon user confirmation
     */
    private void setText() {
        mondayFrom.setText("");
        mondayTo.setText("");
        tuesdayFrom.setText("");
        tuesdayTo.setText("");
        wednesdayTo.setText("");
        wednesdayFrom.setText("");
        thursdayFrom.setText("");
        thursdayTo.setText("");
        fridayFrom.setText("");
        fridayTo.setText("");
        saturdayFrom.setText("");
        saturdayTo.setText("");
        sundayFrom.setText("");
        sundayTo.setText("");
    }

    /**
     * Action Listener for Back Button
     */
    private void setBackButtonListener() {
        backButton.addActionListener(e -> {
            errorLabel.setText("");
            programWindows.openWindow(WindowManager.AVAILABILITY_REFERENCE_KEY);
            programWindows.closeWindow(WindowManager.SET_AVAILABILITY_REFERENCE_KEY);
        });
    }

    /**
     * Method that creates a pop-up message to tell user of confirmation.
     *
     * @param message message confirmation
     */
    @Override
    public void successfullySet(String message) {
        JOptionPane.showMessageDialog(confirmButton, "Availability has been set");
    }

    /**
     * Action Listener for Confirm Button
     */
    private void confirmListener() {
        confirmButton.addActionListener(e -> {
            List<String> text = new ArrayList<>();
            text.add(mondayFrom.getText() + mondayTo.getText());
            text.add(tuesdayFrom.getText() + tuesdayTo.getText());
            text.add(wednesdayFrom.getText() + wednesdayTo.getText());
            text.add(thursdayFrom.getText() + thursdayTo.getText());
            text.add(fridayFrom.getText() + fridayTo.getText());
            text.add(saturdayFrom.getText() + saturdayTo.getText());
            text.add(sundayFrom.getText() + sundayTo.getText());
            String[] avaiabilityArray = new String[text.size()];
            text.toArray(avaiabilityArray);
            for (String availability: avaiabilityArray) {
                if (availability.length() != 4) {
                    errorLabel.setText("Must give two digits for hours");
                    return;
                }
            }
            errorLabel.setText("");
            controller.create(avaiabilityArray);
            programWindows.openWindow(WindowManager.SET_AVAILABILITY_REFERENCE_KEY);
        });
    }
}