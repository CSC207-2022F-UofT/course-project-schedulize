package time_manager_UI;
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
public class TimeBlockManagerUI extends JFrame {


    private JPanel panelMain;
    private JLabel worktimeLabel;
    private JLabel starttimeLabel;
    private JLabel endtimeLabel;
    private JLabel dateLabel;
    private JButton DONEButton;


    TimeBlockManagerUI(){
        super("TimeBlock");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        DONEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });






    }
}
