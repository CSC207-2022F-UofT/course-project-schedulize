package entity_layer;

import java.io.Serializable;

/**
 * A Task interface, implemented by the CommonTask class. Meant as a layer of abstraction.
 * Created: 10/31/22
 * Last updated: 11/10/2022
 *
 * @author MMachadoUofT
 */
public interface Task extends Serializable {

    /**
     * Get this Task's completion level.
     *
     * @return this Task's completion.
     */
    int getCompletion();

    /**
     * Get this Task's duration in minutes.
     *
     * @return this Task's duration
     */
    int getDuration();

    /**
     * Set this Task's duration in minutes. If a value less than 0 is passed, duration is set to 0.
     *
     * @param duration this Task's intended duration
     */
    void setDuration(int duration);

    /**
     * Get this Task's name.
     *
     * @return this Task's name.
     */
    String getName();

    /**
     * Get this Task's description.
     *
     * @return this Task's description.
     */
    String getDescription();

    /**
     * Get this Task's ID attribute.
     *
     * @return this Task's unique ID.
     */
    int getId();

    /**
     * Get the total amount of tasks there are.
     *
     * @return the static taskCount attribute
     */
    int getTaskCount();

    /**
     * Sets this Task's completion attribute to the passed number.
     * If the attempted value is out of bounds (i.e. less than 0, greater than 100) return false. True otherwise.
     *
     * @param completion this task's new completion level.
     * @return true if the completion level was valid, false otherwise.
     */
    boolean setCompletion(int completion);

    /**
     * Sets this Task's name.
     *
     * @param name this Task's intended name.
     */
    void setName(String name);

    /**
     * Sets this Task's description.
     *
     * @param description this Task's intended description.
     */
    void setDescription(String description);

    /**
     * Returns whether this Task's completion is set to 100.
     *
     * @return true if this Task is complete, false otherwise.
     */
    boolean isComplete();

}
