package time_manager_UI;

import UI.CentralWindow;
import UI.WindowManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetAvailabilityUI extends CentralWindow {

    private JComboBox dayCombobox;
    private JComboBox fromComboBox;
    private JComboBox toComboBox;
    private JButton confirmButton;
    private JButton backButton;
    private JPanel panelMain;
//    private final WindowManager programWindows;


    public SetAvailabilityUI() {
        super();
//        this.programWindows = existingWindows;
//        this.programWindows.addWindow(WindowManager.AVAILABILITY_REFERENCE_KEY, this);
        this.configureFrame();
        this.centreWindow();
        this.pack();
        this.setVisible(true);
    }

//    Sets default aspects of the JFrame window, like size and title

    private void configureFrame() {
        this.setTitle("Set Availability");
        this.setSize(350, 300);
        this.setResizable(false);
        this.setContentPane(panelMain);
    }

    private void setListeners(){
        this.dayComboListener();
    }

    private void dayComboListener(){
        dayCombobox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                programWindows.closeWindow(WindowManager.AVAILABILITY_REFERENCE_KEY);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SetAvailabilityUI");
        frame.setContentPane(new SetAvailabilityUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}




