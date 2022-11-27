package entity_factories;

import entity_layer.TaskTree;

import java.io.Serializable;

/**
 * A TaskTreeFactory interface for creating TaskTrees, implemented by the CommonTaskTreeFactory class
 * Created: 11/14/2022
 * Last updated: 11/15/2022
 *
 * @author MMachadoUofT
 */
public interface TaskTreeFactory extends Serializable {

    /**
     * Creates an instance of a TaskTree object
     *
     * @return a new TaskTree object
     */
    TaskTree create();
}
