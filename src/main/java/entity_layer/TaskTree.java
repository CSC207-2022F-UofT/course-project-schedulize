package entity_layer;

import java.util.List;

/**
 * A TaskTree interface, implemented by the CommonTaskTree class, used as a level of abstraction.
 * Created: 10/31/2022
 * Last updated: 11/5/2022
 *
 * @author MMachadoUofT
 */
public interface TaskTree {

    /**
     * Adds the given TaskTree to this TaskTree's list of subTaskTrees
     *
     * @param taskTree the TaskTree to be added
     */
    void addSubTaskTree(TaskTree taskTree);

    /**
     * Removes the passed TaskTree object from this TaskTree's list of subTaskTrees. Returns false if no such
     * TaskTree was found.
     *
     * @param taskTree the TaskTree to be deleted
     * @return true if the deletion was successful, false otherwise
     */
    boolean removeSubTaskTree(TaskTree taskTree);

    /**
     * Removes the passed TaskTree object from this TaskTree's descendant TaskTrees. Returns false if no such TaskTree
     * was found.
     *
     * @param taskTree the TaskTree to be deleted
     * @return true if the deletion was successful, false otherwise
     */
    boolean removeChildTaskTree(TaskTree taskTree);

    /**
     * Returns the TaskTree among this TaskTree and its descendants that holds the given Task, null if no such TaskTree
     * was found.
     *
     * @param task the Task held by the desired TaskTree
     * @return the TaskTree object in possession of the passed Task, null otherwise
     */
    TaskTree getChildTaskTreeByTask(Task task);

    /**
     * Returns the TaskTree among this TaskTree and its descendants that holds the Task with the given ID, null if no
     * such TaskTree was found.
     *
     * @param taskID the unique ID held by the Task, held by the desired TaskTree
     * @return the TaskTree object in possession of the intended Task, null otherwise
     */
    TaskTree getChildTaskTreeByID(int taskID);

    /**
     * Returns whether this TaskTree has subTaskTrees
     *
     * @return true if this TaskTrees subTaskTrees attribute has a size greater than 0, false otherwise
     */
    boolean hasSubTaskTrees();

    /**
     * Returns whether this TaskTree has a superTaskTree
     *
     * @return true if this TaskTree's superTaskTree attribute is not null, false otherwise.
     */
    boolean hasSuperTaskTree();

    /**
     * Returns a pre-order traversal of this TaskTree, the initial call being the root.
     *
     * @return a list of TaskTrees
     */
    List<TaskTree> toList();

    /**
     * Returns a pre-order traversal of this TaskTree's tasks, the initial call being the root Task.
     *
     * @return a list of Tasks
     */
    List<Task> toListOfTasks();

    /**
     * Sets this TaskTree's Task's completion to 100, as well as setting any child TaskTrees Task's to 100, and updating
     * any superTaskTree's Task completion values
     */
    void completeTask();

    /**
     * Re-calculates this TaskTree's Task's completion according to the completion of its subTaskTrees' Tasks.
     */
    void updateTask();

    /**
     * Return this TaskTree's superTaskTree object.
     *
     * @return this TaskTree's superTaskTree.
     */
    TaskTree getSuperTaskTree();

    /**
     * Sets this TaskTree's superTaskTree attribute to the provided TaskTree.
     *
     * @param superTaskTree this TaskTree's intended superTaskTree.
     */
    void setSuperTaskTree(TaskTree superTaskTree);

    /**
     * Returns a shallow copy of this TaskTree's subTaskTrees.
     *
     * @return this TaskTree's subTaskTrees.
     */
    List<TaskTree> getSubTaskTrees();

    /**
     * Returns the Task object belonging to this TaskTree.
     *
     * @return this TaskTree's Task object.
     */
    Task getTask();

    /**
     * Sets this TaskTree's Task object to the provided Task.
     *
     * @param task this TaskTree's intended Task object.
     */
    void setTask(Task task);

}
