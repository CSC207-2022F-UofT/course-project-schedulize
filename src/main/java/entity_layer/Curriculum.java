package entity_layer;

import java.io.Serializable;

/**
 * A Curriculum interface, implemented by the CommonCurriculum class as a level of abstraction.
 * Created: 10/31/2022
 * Last updated: 11/4/2022
 *
 * @author MMachadoUofT
 */
public interface Curriculum extends Serializable {

    /**
     * Add the given TimeBlock to this Curriculum's worktimes
     *
     * @param workTime the TimeBlock to be added.
     */
    void addWorkTime(TimeBlock workTime);

    /**
     * Get this curriculum's name.
     *
     * @return this Curriculum's name.
     */
    String getName();

    /**
     * Set this curriculum's name.
     *
     * @param name this Curriculum's new name.
     */
    void setName(String name);

    /**
     * Get the highest-level TaskTree item within this Curriculum. Note that this returns a TaskTree item, *not*
     * a Task item.
     *
     * @return this Curriculums goal.
     */
    TaskTree getGoal();

    /**
     * Return this Curriculum's unique id number.
     *
     * @return this Curriculum's id.
     */
    int getID();

    /**
     * Get the TaskTree holding the Task with the corresponding ID, null if no such TaskTree was found.
     *
     * @param taskID the ID for the desired Task and subsequent TaskTree
     * @return the TaskTree holding the desired Task
     */
    TaskTree getTaskTreeByID(int taskID);

    /**
     * Get a TimeBlockManager representing the times that the User will work on this Curriculum for this week
     *
     * @return this week's TimeBlocks, held by a TimeBlockManager.
     */
    TimeBlockManager getThisWeekSchedule();

    /**
     * Get the TimeBlockManager holding every TimeBlock where this User is intended to work on this Curriculum
     *
     * @return this Curriculum's workTimes attribute
     */
    TimeBlockManager getFullSchedule();

}
