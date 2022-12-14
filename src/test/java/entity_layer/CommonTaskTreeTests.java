package entity_layer;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class for testing the methods implemented by CommonTaskTree.
 * Created: 11/3/2022
 * Last Updated: 11/14/2022
 *
 * @author MMachadoUofT
 */
public class CommonTaskTreeTests {

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
    public void testHasSuperTaskTree() {
        TaskTree tree1 = new CommonTaskTree();
        TaskTree tree2 = new CommonTaskTree();

        assertFalse(tree1.hasSuperTaskTree());
        assertFalse(tree2.hasSuperTaskTree());

        tree1.addSubTaskTree(tree2);

        assertTrue(tree2.hasSuperTaskTree());
    }

    @Test
    public void testHasSubtrees() {
        TaskTree tree1 = new CommonTaskTree();
        TaskTree tree2 = new CommonTaskTree();

        assertFalse(tree1.hasSubTaskTrees());
        assertFalse(tree2.hasSubTaskTrees());

        tree1.addSubTaskTree(tree2);

        assertTrue(tree1.hasSubTaskTrees());
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

        // Get expected id
        int expectedID = sub21.getTask().getId();

        // Assertion
        assertEquals(sub21, root.getChildTaskTreeByID(expectedID));
    }

    @Test
    public void testGetTaskTreeByIDNotFound() {
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

        // Assert null for an unfound Tree
        assertNull(root.getChildTaskTreeByID(-1));
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

    /**
     * Tests that we can succesfully remove a child TaskTree that is *not* a direct subTaskTree
     */
    @Test
    public void testRemoveChildTaskTree() {
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

        // Assert that sub12 can be deleted
        assertTrue(root.removeChildTaskTree(sub12));
        assertEquals(1, sub1.getSubTaskTrees().size());
    }

    @Test
    public void testGetChildTreeByTask() {
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

        Task expectedTask = sub12.getTask();

        // Assertion
        assertEquals(sub12, root.getChildTaskTreeByTask(expectedTask));
    }

    @Test
    public void testToListOfTasks() {
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

        // Set up expected list
        List<Task> expectedList = new ArrayList<>();
        expectedList.add(root.getTask());
        expectedList.add(sub1.getTask());
        expectedList.add(sub11.getTask());
        expectedList.add(sub12.getTask());
        expectedList.add(sub2.getTask());
        expectedList.add(sub21.getTask());
        expectedList.add(sub22.getTask());

        // Assertion
        assertEquals(expectedList, root.toListOfTasks());
    }

    @Test
    public void testCompletionAfterRemoval() {
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

        // Complete a lowest-level tree
        sub11.completeTask();
        assertEquals(50, sub1.getTask().getCompletion());

        // Delete the sibling tree
        root.removeChildTaskTree(sub12);

        // Assert that the upper tree is properly updated
        assertTrue(sub1.getTask().isComplete());

        // Repeat
        root.removeChildTaskTree(sub11);
        assertTrue(sub1.getTask().isComplete());

        // Repeat once more
        root.removeChildTaskTree(sub21);
        root.removeChildTaskTree(sub22);
        assertEquals(0, sub2.getTask().getCompletion());
    }

    @Test
    public void testResetTaskMiddle() {
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

        sub1.completeTask();
        assertEquals(50, root.getTask().getCompletion());

        root.resetTask();
        assertEquals(0, sub12.getTask().getCompletion());
        assertEquals(0, sub11.getTask().getCompletion());
    }

    @Test
    public void testGetSubTaskTrees() {
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

        // Compare and contrast baby
        List<TaskTree> expected = new ArrayList<>();
        expected.add(sub1);
        expected.add(sub2);
        List<TaskTree> actual = root.getSubTaskTrees();

        assertEquals(expected, actual);

    }

    @Test
    public void testResetTask() {
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

        // Complete all tasks
        root.completeTask();
        assertEquals(100, sub22.getTask().getCompletion());
        assertEquals(100, sub1.getTask().getCompletion());

        // Reset a middle task
        sub1.resetTask();

        // Assert correct completions
        assertEquals(50, root.getTask().getCompletion());
        assertEquals(0, sub11.getTask().getCompletion());
        assertEquals(100, sub21.getTask().getCompletion());

    }

    @Test
    public void testResetTaskSmallTree() {
        // Create TaskTrees
        TaskTree root = new CommonTaskTree();
        TaskTree sub1 = new CommonTaskTree();
        TaskTree sub2 = new CommonTaskTree();

        // Connect TaskTrees
        root.addSubTaskTree(sub1);
        root.addSubTaskTree(sub2);

        // Populate
        populateTree(root);

        // Complete all tasks
        root.completeTask();

        // Reset a bottom task
        sub1.resetTask();

        // Assertions
        assertEquals(0, sub1.getTask().getCompletion());
        assertEquals(100, sub2.getTask().getCompletion());
        assertEquals(50, root.getTask().getCompletion());

    }
}
