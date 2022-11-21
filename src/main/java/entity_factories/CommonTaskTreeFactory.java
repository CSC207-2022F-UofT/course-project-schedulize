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

    /**
     * Creates an instance of a CommonTaskTree object
     *
     * @return a new CommonTaskTree object
     */
    @Override
    public TaskTree create() {
        return new CommonTaskTree();
    }
}
