package task_tree_UI;

import UI.CentralWindow;
import UI.TaskDependentWindow;
import entity_factories.*;
import entity_layer.*;
import use_cases.display_task_tree.TaskTreeUIInterface;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.*;



/**
 * A TaskTree UI class, that implements the JFrame interface by making a list of tasks displayed by a tree.
 * Created: 11/15/2022
 * Last updated: 11/26/2022
 *
 * @author Aayush Bhan
 */


public class TaskTreeUI extends CentralWindow {
    private JTree taskTree;
    private int displayId;
    private JPanel mainPanel;


    /**
     * Default constructor for TaskTree UI
     */
    public TaskTreeUI() {
        JPanel p = new JPanel(new BorderLayout());
        this.mainPanel = p;
        this.configureFrame();
        JScrollPane s = new
                JScrollPane(this.taskTree);
        p.add(BorderLayout.CENTER, s);
        this.centreWindow();
    }

    private void configureFrame() {
        // set Frame title
        this.setTitle("Schedulize");
        // set Frame window size
        this.setSize(350, 300);
        // disable resizability
        this.setResizable(false);
        // set content, configured in form file
        this.setContentPane(mainPanel);
    }
}



