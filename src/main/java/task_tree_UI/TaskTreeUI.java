package task_tree_UI;

import UI.CentralWindow;
import UI.TaskDependentWindow;
import entity_factories.*;
import entity_layer.*;
import use_cases.display_task_tree.CurriculumDisplayModel;
import use_cases.display_task_tree.TaskTreeDisplayModel;
import use_cases.display_task_tree.TaskTreeUIInterface;
import javax.swing.JButton;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.logging.Logger;


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
    private JPanel treePanel;
    private JPanel openTaskPanel;
    private JPanel addTaskPanel;
    private JButton button;

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


    //Buttons................................................
    public class TreeListener extends MouseAdapter{
        private JTree _Tree;
        private boolean singleClick  = true;
        private int doubleClickDelay = 300;
        private Timer timer;

        public TreeListener(JTree tree)
        {
            this._Tree = tree;
            ActionListener actionListener = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    timer.stop();
                    if (singleClick) {
                        singleClickHandler(e);
                    } else {
                        try {
                            doubleClickHandler(e);
                        } catch (ParseException ex) {
                            Logger.getLogger(ex.getMessage());
                        }
                    }
                }
            };
            timer = new javax.swing.Timer(doubleClickDelay, actionListener);
            timer.setRepeats(false);
        }

        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                singleClick = true;
                timer.start();
            } else {
                singleClick = false;
            }
        }

        private void singleClickHandler(ActionEvent e) {
            System.out.println("-- single click --");
        }

        private void doubleClickHandler(ActionEvent e) throws ParseException {
            System.out.println("-- double click -- id= ");

        }
    }
///....................







//TODODeleteforDeployment

    public static void main(String[]args){
        User example = new CommonUser("ssssss","s@yshao.com","bhan");

        CurriculumFactory factory= new CommonCurriculumFactory(new CommonTaskTreeFactory(),new CommonTaskFactory(),
                new CommonTimeBlockManagerFactory());
        Curriculum curriculum=factory.create("Name");
        TaskTreeFactory treeFactory=new CommonTaskTreeFactory();
        TaskFactory taskFactory= new CommonTaskFactory();
        TaskTree tree1 = treeFactory.create();
        TaskTree tree2= treeFactory.create();
        TaskTree tree3= treeFactory.create();
        TaskTree tree4= treeFactory.create();
        TaskTree tree5 = treeFactory.create();
        tree1.setTask(taskFactory.create("Name1","description"));
        tree2.setTask(taskFactory.create("Name2","description"));
        tree3.setTask(taskFactory.create("Name3","description"));
        tree4.setTask(taskFactory.create("Name4","description"));
        tree5.setTask(taskFactory.create("Name5","description"));
        example.setSchedule(new CommonScheduleFactory(new CommonTimeBlockManagerFactory()).create());
        example.getSchedule().addCurriculum(curriculum);
        TaskTree goal=curriculum.getGoal();
        goal.addSubTaskTree(tree1);
        goal.addSubTaskTree(tree2);
        goal.addSubTaskTree(tree5);
        tree2.addSubTaskTree(tree3);
        tree2.addSubTaskTree(tree4);

        InMemoryUser.setActiveUser(example);



        TaskTreeUI ui= new TaskTreeUI();

        ui.setVisible(true);

    }
}




