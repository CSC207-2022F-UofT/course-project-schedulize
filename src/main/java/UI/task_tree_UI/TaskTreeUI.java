package UI.task_tree_UI;

import UI.*;
import UI.task_UI.TaskUI;
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
    private final JButton backButton;
    private final DisplayTaskTreeController displayController;
    private final WindowManager programWindows;


    /**
     * Default constructor for TaskTree UI
     *
     * @param windowManager The WindowManager responsible for this window
     * @param displayController The controller responsible for beginning the display task tree use case
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

        this.backButton = new JButton("Back");
        p.add(BorderLayout.SOUTH, this.backButton);
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
        this.backButtonListener();
        this.addTaskListener();
    }

    /**
     * Set up the TaskTree for the desired curriculum to be displayed
     */
    private void treeSetUp() {
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
        p.add(BorderLayout.SOUTH, this.backButton);
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
                    TaskUI taskUI = (TaskUI) programWindows.getWindow(WindowManager.TASK_REFERENCE_KEY);
                    taskUI.populateView(displayId, parseNodeTextForID(nodeInfo));
                    programWindows.openWindow(WindowManager.TASK_REFERENCE_KEY);
                }
            }
        });
    }

    /**
     * A button listener to add tasks
     */
    private void addTaskListener() {
        this.addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame createTaskWindow = programWindows.getWindow(WindowManager.CREATE_TASK_REFERENCE_KEY);
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        taskTree.getLastSelectedPathComponent();
                if (node == null) {
                    ((TaskDependentWindow) createTaskWindow).setTaskID(displayController.getRoot(displayId).getId());
                } else {
                    String nodeInfo = (String) node.getUserObject();
                    ((TaskDependentWindow) createTaskWindow).setTaskID(parseNodeTextForID(nodeInfo));
                }
                ((CurriculumDependentWindow) createTaskWindow).setCurriculumID(displayId);
                programWindows.openWindow(WindowManager.CREATE_TASK_REFERENCE_KEY);
                programWindows.closeWindow(WindowManager.TASKTREE_REFERENCE_KEY);
                programWindows.closeWindow(WindowManager.TASK_REFERENCE_KEY);
            }
        });
    }

    /**
     * A button listener to go back to the dashboard
     */
    private void backButtonListener() {
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                programWindows.openWindow(WindowManager.DASHBOARD_REFERENCE_KEY);
                programWindows.closeWindow(WindowManager.TASKTREE_REFERENCE_KEY);
                programWindows.closeWindow(WindowManager.TASK_REFERENCE_KEY);
            }
        });
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        this.treeSetUp();
    }

    /**
     * Set the id of the Tree window to the id of the displayed curiculum
     *
     * @param id the desired curriculum's id
     */
    @Override
    public void setCurriculumID(int id) {
        this.displayId = id;
        this.treeSetUp();
    }
}




