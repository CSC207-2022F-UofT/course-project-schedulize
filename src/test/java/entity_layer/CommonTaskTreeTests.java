package entity_layer;

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

    @Test
    public void testAddSubtree() {
        TaskTree tree1 = new CommonTaskTree();
        TaskTree tree2 = new CommonTaskTree();

        tree1.addSubTaskTree(tree2);

        assertEquals(tree2, tree1.getSubTaskTrees().get(0));
        assertEquals(tree1, tree2.getSuperTaskTree());
    }

    @Test
    public void testSubTreeHierarchyValidParents() {
        assertEquals(4, 4);
    }

    @Test
    public void testNoSubtasksToList() {
        // TODO: Write this test
    }

    @Test
    public void testGetTaskTreeByIDThisTree() {
        // TODO: Write this test
    }

    @Test
    public void testGetTaskTreeByIDSubTree() {
        // TODO: Write this test
    }

    @Test
    public void testGetTaskTreeByIDNestedTree() {
        // TODO: Write this test
    }

    @Test
    public void testGetTaskTreeByIDNotFound() {
        // TODO: Write this test
    }

}
