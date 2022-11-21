package time_manager_UI;
import UI.CentralWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * A TimeBlockManagerUi that uses JFrame to implement a time block window.
 * Created:2022-11-14
 * Last updated:2022-11-16
 *
 * @author Amir Bare
 */
public class TimeBlockManagerUI extends CentralWindow {


    private JPanel panelMain;
    private JLabel worktimeLabel;
    private JLabel starttimeLabel;
    private JLabel endtimeLabel;
    private JLabel dateLabel;
    private JButton DONEButton;

    TimeBlockManagerUI(){
        super();
        this.setTitle("TimeBlock");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.centreWindow();
        DONEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    //TODO Delete for Deployment
    public static void main(String[] args) {
        JFrame ui = new TimeBlockManagerUI();
        ui.setVisible(true);
    }
}
