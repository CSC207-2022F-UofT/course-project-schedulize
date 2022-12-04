package entity_factories;

import entity_layer.Task;
import entity_layer.CommonTask;

/**
 * A CommonTaskFactory for creating CommonTask objects, implements the TaskFactory interface
 * Created: 11/11/2022
 * Last updated: 11/13/2022
 *
 * @author MMachadoUofT
 */
public class CommonTaskFactory implements TaskFactory {

    /* ************* *\
    *  Functionality  *
    \* ************* */
    /**
     * Create a CommonTask object with the given name and description
     *
     * @param name the CommonTask's name
     * @param description the CommonTask's description
     * @return the created CommonTask
     */
    @Override
    public Task create(String name, String description) {
        return new CommonTask(name, description);
    }

    /**
     * Create a CommonTask object with the given name, description, and duration
     *
     * @param name this CommonTask's name
     * @param description the CommonTask's description
     * @param duration the CommonTask's duration in minutes
     * @return the created CommonTask
     */
    @Override
    public Task createWithDuration(String name, String description, int duration) {
        return new CommonTask(name, description, duration);
    }
}
