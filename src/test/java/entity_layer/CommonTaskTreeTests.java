package entity_layer;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class for testing the methods implemented by CommonTaskTree.
 * Created: 11/3/2022
 * Last Updated: 11/14/2022
 *
 * @author MMachadoUofT
 */
public class CommonTaskTreeTests {

    /*
    private TaskTree setupTree() {
        TaskTree tree1 = new CommonTaskTree();
        TaskTree tree2 = new CommonTaskTree();
        TaskTree tree3 = new CommonTaskTree();
        TaskTree tree4 = new CommonTaskTree();
        TaskTree tree5 = new CommonTaskTree();
        TaskTree tree6 = new CommonTaskTree();
        TaskTree tree7 = new CommonTaskTree();

        Task task1 = new CommonTask("n", "d");
        Task task2 = new CommonTask("n", "d");
        Task task3 = new CommonTask("n", "d");
        Task task4 = new CommonTask("n", "d");
        Task task5 = new CommonTask("n", "d");
        Task task6 = new CommonTask("n", "d");
        Task task7 = new CommonTask("n", "d");

        tree1.setTask(task1);
        tree2.setTask(task2);
        tree3.setTask(task3);
        tree4.setTask(task4);
        tree5.setTask(task5);
        tree6.setTask(task6);
        tree7.setTask(task7);


    }*/

    private Task createTestTask() {
        return new CommonTask("n", "d");
    }

    private void populateTree(TaskTree root) {
        for (TaskTree tree : root.toList()) {
            tree.setTask(createTestTask());
        }
    }

    @Test
    public void testAddSubtree() {
        TaskTree tree1 = new CommonTaskTree();
        TaskTree tree2 = new CommonTaskTree();

        tree1.addSubTaskTree(tree2);

        assertEquals(tree2, tree1.getSubTaskTrees().get(0));
        assertEquals(tree1, tree2.getSuperTaskTree());
    }

    @Test
    public void testNoSubtasksToList() {
        TaskTree tree = new CommonTaskTree();
        List<TaskTree> expected = new ArrayList<>();
        expected.add(tree);
        List<TaskTree> actual = tree.toList();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetTaskTreeByIDThisTree() {
        Task task = createTestTask();
        int taskID = task.getId();
        TaskTree tree = new CommonTaskTree();
        tree.setTask(task);
        assertEquals(task, tree.getChildTaskTreeByID(taskID).getTask());
    }

    @Test
    public void testGetTaskTreeByIDSubTree() {
        TaskTree tree1 = new CommonTaskTree();
        TaskTree tree2 = new CommonTaskTree();
        TaskTree tree3 = new CommonTaskTree();

        Task task1 = createTestTask();
        Task task2 = createTestTask();
        Task task3 = createTestTask();

        tree1.addSubTaskTree(tree2);
        tree1.addSubTaskTree(tree3);

        tree1.setTask(task1);
        tree2.setTask(task2);
        tree3.setTask(task3);

        assertEquals(task2, tree1.getChildTaskTreeByID(task2.getId()).getTask());
    }

    @Test
    public void testGetTaskTreeByIDNestedTree() {
        // TODO: Write this test
    }

    @Test
    public void testGetTaskTreeByIDNotFound() {
        // TODO: Write this test
    }

    /**
     * Test that a Task(Tree) with two subTask(Trees) is 50% complete when one of its subTask(Tree)s is complete
     */
    @Test
    public void testOneSubtaskComplete() {
        TaskTree tree1 = new CommonTaskTree();
        TaskTree tree2 = new CommonTaskTree();
        TaskTree tree3 = new CommonTaskTree();

        Task task1 = createTestTask();
        Task task2 = createTestTask();
        Task task3 = createTestTask();

        tree1.addSubTaskTree(tree2);
        tree1.addSubTaskTree(tree3);

        tree1.setTask(task1);
        tree2.setTask(task2);
        tree3.setTask(task3);

        tree2.completeTask();

        assertEquals(50, tree1.getTask().getCompletion());
    }

    /**
     * Test a tree with 3 subtrees, where each of those has 3 subtrees.
     * One of the middle trees is completed.
     * The expected outcome is that all of its subtrees are also completed, and its parent tree is 33% completed.
     */
    @Test
    public void testCompleteTaskMiddleLayer() {
        // Create upper-level trees
        TaskTree root = new CommonTaskTree();
        TaskTree sub1 = new CommonTaskTree();
        TaskTree sub2 = new CommonTaskTree();
        TaskTree sub3 = new CommonTaskTree();

        root.addSubTaskTree(sub1);
        root.addSubTaskTree(sub2);
        root.addSubTaskTree(sub3);

        // Give each subtree 3 subTaskTrees
        for (TaskTree subTree : root.getSubTaskTrees()) {
            for (int i = 1; i <= 3; i++) {
                subTree.addSubTaskTree(new CommonTaskTree());
            }
        }

        // Populate all trees
        for (TaskTree tree : root.toList()) {
            tree.setTask(createTestTask());
        }

        // Complete a mid-level task
        sub2.completeTask();

        // Assert that neither sibling tree was affected
        assertEquals(0, sub1.getTask().getCompletion());
        assertEquals(0, sub3.getTask().getCompletion());

        // Assert children trees were completed
        for (TaskTree sub2Tree : sub2.getSubTaskTrees()) {
            assertEquals(100, sub2Tree.getTask().getCompletion());
        }

        // Assert that root was updated
        assertEquals(33, root.getTask().getCompletion());
    }

    /**
     * Test that higher-level superTaskTrees are updated
     */
    @Test
    public void testParentOfParentUpdated() {
        // Create TaskTrees
        TaskTree root = new CommonTaskTree();
        TaskTree sub1 = new CommonTaskTree();
        TaskTree sub2 = new CommonTaskTree();
        TaskTree sub11 = new CommonTaskTree();
        TaskTree sub12 = new CommonTaskTree();
        TaskTree sub21 = new CommonTaskTree();
        TaskTree sub22 = new CommonTaskTree();

        // Connect TaskTrees
        root.addSubTaskTree(sub1);
        root.addSubTaskTree(sub2);
        sub1.addSubTaskTree(sub11);
        sub1.addSubTaskTree(sub12);
        sub2.addSubTaskTree(sub21);
        sub2.addSubTaskTree(sub22);

        // Populate
        populateTree(root);

        // Update a low-level Task
        sub22.completeTask();

        // Assertions
        assertEquals(0, sub1.getTask().getCompletion());
        assertEquals(0, sub21.getTask().getCompletion());
        assertEquals(50, sub2.getTask().getCompletion());
        assertEquals(25, root.getTask().getCompletion());
    }

}
