package entity_factories;

import entity_layer.Task;

import java.io.Serializable;

/**
 * An interface for creating Tasks, implemented by the CommonTaskFactory class
 * Created: 11/11/2022
 * Last updated: 11/13/2022
 *
 * @author MMachadoUofT
 */
public interface TaskFactory extends Serializable {

    /**
     * Create a Task object with the given name and description
     *
     * @param name the Task's name
     * @param description the Task's description
     * @return the created Task
     */
    Task create(String name, String description);

    /**
     * Create a Task object with the given name, description, and duration
     *
     * @param name this Task's name
     * @param description the Task's description
     * @param duration the Task's duration in minutes
     * @return the created Task
     */
    Task createWithDuration(String name, String description, int duration);
}
