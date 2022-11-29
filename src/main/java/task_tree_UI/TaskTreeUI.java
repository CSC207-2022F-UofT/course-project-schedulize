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


public class TaskTreeUI extends CentralWindow implements TaskDependentWindow, TaskTreeUIInterface {
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

    private void treeSetUp(int displayId) {
        DefaultMutableTreeNode rootNode;
        TaskTree root;
        try {
            root = InMemoryUser.getActiveUser().getSchedule().getCurriculum(this.displayId).getGoal();
            rootNode = new DefaultMutableTreeNode(root.getTask().getName() +
                    this.displayIDString(root.getTask().getId()));
        } catch (NullPointerException e) {
            return;
        }

        this.recurse(rootNode, root);


        //Making a root node

//        DefaultMutableTreeNode X = new DefaultMutableTreeNode("X");
//        DefaultMutableTreeNode Y = new DefaultMutableTreeNode("Y");
//
//        DefaultMutableTreeNode X1 = new DefaultMutableTreeNode("X1");
//        DefaultMutableTreeNode X2 = new DefaultMutableTreeNode("X2");
//
//        DefaultMutableTreeNode Y1 = new DefaultMutableTreeNode("Y1");
//        DefaultMutableTreeNode Y2 = new DefaultMutableTreeNode("Y2");
//        DefaultMutableTreeNode Y3 = new DefaultMutableTreeNode("Y3");
//
//        X.add(X1);
//        X.add(X2);
//
//        Y.add(Y1);
//        Y.add(Y2);
//        Y.add(Y3);

        //State the root nodes
//        rootNode.add(X);
//        rootNode.add(Y);

        DefaultTreeModel tree = new DefaultTreeModel(rootNode);
        System.out.println(rootNode);
        this.taskTree = new JTree(tree);
        JPanel p = new JPanel(new BorderLayout());
        this.mainPanel = p;
        this.setContentPane(p);
        JScrollPane s = new
                JScrollPane(this.taskTree);
        p.add(BorderLayout.CENTER, s);
        this.revalidate();
        this.repaint();
        System.out.println("reached");

    }

    private void recurse(DefaultMutableTreeNode root, TaskTree tree) {
        System.out.println(tree.getSubTaskTrees());
        for (TaskTree subtree : tree.getSubTaskTrees()) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(subtree.getTask().getName()
                    + displayIDString(subtree.getTask().getId()));
            root.add(node);
            System.out.println(subtree.getTask().getName());
            recurse(node, subtree);
        }
    }

    private String displayIDString(int id) {
        return " (ID n.o.: " + id + ")";
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        this.treeSetUp(this.displayId);
    }

    @Override
    public void setWindowID(int id) {
        this.displayId = id;
    }

    //TODO Delete for Deployment

    public static void main(String[] args) {
        User example = new CommonUser("ssssss", "s@yshao.com", "bhan");

        CurriculumFactory factory = new CommonCurriculumFactory(new CommonTaskTreeFactory(), new CommonTaskFactory(),
                new CommonTimeBlockManagerFactory());
        Curriculum curriculum = factory.create("Name");
        TaskTreeFactory treeFactory = new CommonTaskTreeFactory();
        TaskFactory taskFactory = new CommonTaskFactory();
        TaskTree tree1 = treeFactory.create();
        TaskTree tree2 = treeFactory.create();
        TaskTree tree3 = treeFactory.create();
        TaskTree tree4 = treeFactory.create();
        TaskTree tree5 = treeFactory.create();
        tree1.setTask(taskFactory.create("Name1", "description"));
        tree2.setTask(taskFactory.create("Name2", "description"));
        tree3.setTask(taskFactory.create("Name3", "description"));
        tree4.setTask(taskFactory.create("Name4", "description"));
        tree5.setTask(taskFactory.create("Name5", "description"));
        example.setSchedule(new CommonScheduleFactory(new CommonTimeBlockManagerFactory()).create());
        example.getSchedule().addCurriculum(curriculum);
        TaskTree goal = curriculum.getGoal();
        goal.addSubTaskTree(tree1);
        goal.addSubTaskTree(tree2);
        goal.addSubTaskTree(tree5);
        tree2.addSubTaskTree(tree3);
        tree2.addSubTaskTree(tree4);

        InMemoryUser.setActiveUser(example);
        // want curriculum id #0


        TaskTreeUI ui = new TaskTreeUI();
        ui.setWindowID(0);
        ui.setVisible(true);

        }
    }




