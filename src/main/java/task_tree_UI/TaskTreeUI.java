package task_tree_UI;

import UI.*;
import entity_factories.*;
import entity_layer.*;
import use_cases.display_task_tree.*;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * A TaskTree UI class, that implements the JFrame interface by making a list of tasks displayed by a tree.
 * Created: 11/15/2022
 * Last updated: 12/01/2022
 *
 * @author Aayush Bhan
 */
public class TaskTreeUI extends CentralWindow implements CurriculumDependentWindow {
    private JTree taskTree;
    private int displayId;
    private final String idDisplayText = " (ID n.o.: ";
    private JPanel mainPanel;
    private final JButton addTaskButton;
    private final JButton deleteTaskButton;
    private final DisplayTaskTreeController displayController;
    private final WindowManager programWindows;


    /**
     * Default constructor for TaskTree UI
     */
    public TaskTreeUI(WindowManager windowManager, DisplayTaskTreeController displayController) {
        this.programWindows = windowManager;
        this.programWindows.addWindow(WindowManager.TASKTREE_REFERENCE_KEY, this);
        this.displayController = displayController;
        JPanel p = new JPanel(new BorderLayout());
        this.mainPanel = p;
        this.configureFrame();
        JScrollPane s = new
                JScrollPane(this.taskTree);
        p.add(BorderLayout.CENTER, s);

        this.addTaskButton = new JButton("Add Task");
        p.add(BorderLayout.NORTH, this.addTaskButton);

        this.deleteTaskButton = new JButton("Delete Task");
        p.add(BorderLayout.SOUTH, this.deleteTaskButton);
        this.centreWindow();
        this.setListeners();
    }

    /**
     * Configure this JFrame
     */
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

    /**
     * Set up buttons
     */
    private void setListeners() {
        this.deleteTaskListener();
        this.addTaskListener();
    }

    /**
     * Set up the TaskTree for the desired curriculum to be displayed
     *
     * @param displayId the ID of the curriculum meant to be displayed
     */
    private void treeSetUp(int displayId) {
        DefaultMutableTreeNode rootNode;
        TaskTreeDisplayModel root = displayController.getRoot(this.displayId);
        rootNode = new DefaultMutableTreeNode(root.getName() +
                this.displayIDString(root.getId()));

        this.setUpSubtrees(rootNode, root.getId());

        DefaultTreeModel tree = new DefaultTreeModel(rootNode);
        this.taskTree = new JTree(tree);
        this.resetContent();
        this.treeClickListener();
    }

    /**
     * Clear the existing TaskTree from any previously viewed curriculums
     */
    private void resetContent() {
        JPanel p = new JPanel(new BorderLayout());
        this.mainPanel = p;
        this.setContentPane(p);
        JScrollPane s = new
                JScrollPane(this.taskTree);
        p.add(BorderLayout.CENTER, s);
        p.add(BorderLayout.NORTH, this.addTaskButton);
        p.add(BorderLayout.SOUTH, this.deleteTaskButton);
        this.revalidate();
        this.repaint();
    }

    /**
     * Prepare curriculum subtrees to be displayed under their respective parent tree.
     *
     * @param root The root tree node on the UI
     * @param rootId The ID for the root tree node
     */
    private void setUpSubtrees(DefaultMutableTreeNode root, int rootId) {
        for (TaskTreeDisplayModel subtree : displayController.getSubtrees(this.displayId, rootId)) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(subtree.getName()
                    + displayIDString(subtree.getId()));
            root.add(node);
            setUpSubtrees(node, subtree.getId());
        }
    }

    /**
     * Converts the passed id into a formatted string
     *
     * @param id the id to be presented
     * @return the formatted id
     */
    private String displayIDString(int id) {
        return this.idDisplayText + id + ")";
    }

    /**
     * Extracts the integer Task ID from the tree node's given text
     *
     * @param text the intended tree node's text name
     * @return the node's id
     */
    private int parseNodeTextForID(String text) {
        int length = this.idDisplayText.length();
        int index = text.indexOf(this.idDisplayText) + length;
        int last_index = text.lastIndexOf(')');
        return Integer.parseInt(text.substring(index, last_index));
    }

    /**
     * A button to open the TaskUI from a tree node
     */
    private void treeClickListener() {
        this.taskTree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 3) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                            taskTree.getLastSelectedPathComponent();
                    if (node == null) return;
                    String nodeInfo = (String) node.getUserObject();
                    // TODO: Connect to TASK WINDOW
                    // eg. programWindows.openWindow(WindowManager.referenceKey);
                    System.out.println(parseNodeTextForID(nodeInfo)); // THIS IS THE NEEDED TASK ID, Curriculum ID is on this window
                }
            }
        });
    }

    /**
     * A button to add tasks
     */
    private void addTaskListener() {
        this.addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Connect to Add Task window
                programWindows.closeWindow(WindowManager.LOGIN_REFERENCE_KEY);
            }
        });
    }

    /**
     * A button to delete tasks
     */
    private void deleteTaskListener() {
        this.deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: connect to delete task use case
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        taskTree.getLastSelectedPathComponent();
                if (node == null) return;
                String nodeInfo = (String) node.getUserObject();
                System.out.println(parseNodeTextForID(nodeInfo)); // THIS IS THE NEEDED TASK ID, Curriculum ID is on this window
                // e.g. controller.deleteTask(...)

                // trigger redraw
                treeSetUp(displayId);
            }
        });
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        this.treeSetUp(this.displayId);
    }

    /**
     * Set the id of the Tree window to the id of the displayed curiculum
     *
     * @param id the desired curriculum's id
     */
    @Override
    public void setWindowID(int id) {
        this.displayId = id;
    }

    //TODO Delete for Deployment

    /*public static void main(String[] args) {
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

        DisplayTaskTreeOutputBoundary presenter = new DisplayTaskTreePresenter();
        DisplayTaskTreeInputBoundary interactor = new DisplayTaskTreeInteractor(presenter);
        DisplayTaskTreeController displayController = new DisplayTaskTreeController(interactor);
        WindowManager manager = new CommonWindowManager();

        TaskTreeUI ui = new TaskTreeUI(manager, displayController);
        ui.setWindowID(0);
        ui.setVisible(true);

    }*/
}




