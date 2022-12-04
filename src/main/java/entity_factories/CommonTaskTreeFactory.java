package entity_factories;

import entity_layer.CommonTaskTree;
import entity_layer.TaskTree;

/**
 * A CommonTaskTreeFactory for creating CommonTaskTree objects, implements the
 * TaskTreeFactory interface.
 * Created: 11/14/2022
 * Last updated: 11/15/2022
 *
 * @author MMachadoUofT
 */
public class CommonTaskTreeFactory implements TaskTreeFactory {

    /* ********** *\
    *  Attributes  *
    \* ********** */
    private final TaskFactory taskFactory = new CommonTaskFactory();

    /* ************* *\
    *  Functionality  *
    \* ************* */
    /**
     * Creates an instance of a CommonTaskTree object
     *
     * @return a new CommonTaskTree object
     */
    @Override
    public TaskTree create() {
        return new CommonTaskTree();
    }

    /**
     * Creates an instance of a TaskTree object with a preloaded Task.
     * This is primarily for testing purposes and includes a hard coupling to create new Tasks
     *
     * @param name the new Task's name
     * @param description the new Task's description
     * @return a new TaskTree object
     */
    @Override
    public TaskTree createWithTask(String name, String description) {
        TaskTree newTree = new CommonTaskTree();
        newTree.setTask(taskFactory.create(name, description));
        return newTree;
    }
}
