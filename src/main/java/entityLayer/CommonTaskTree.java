package entityLayer;

import java.util.ArrayList;
import java.util.List;

/**
 * A CommonTaskTree class, implements the TaskTree interface
 * Created: 10/31/2022
 * Last updated: 11/14/2022
 *
 * @author MMachadoUofT
 */
public class CommonTaskTree implements TaskTree {

    /* ********** *\
    *  Attributes  *
    \* ********** */
    private Task task;
    private TaskTree superTaskTree;
    private List<TaskTree> subTaskTrees;

    /* ************ *\
    *  Constructors  *
    \* ************ */
    /**
     * Creates an empty CommonTaskTree with no superTaskTree, no subTaskTrees, and no Task.
     * For this TaskTree to hold a task and to belong to a hierarchy, it must be assigned the relevant attributes.
     */
    public CommonTaskTree() {
        this.task = null;
        this.superTaskTree = null;
        this.subTaskTrees = new ArrayList<>();
    }

    /* ************* *\
    *  Functionality  *
    \* ************* */
    /**
     * Adds the given TaskTree to this CommonTaskTree's list of subTaskTrees
     *
     * @param taskTree the TaskTree to be added
     */
    @Override
    public void addSubTaskTree(TaskTree taskTree) {
        this.subTaskTrees.add(taskTree);
        if (taskTree.getSuperTaskTree() != null)
            taskTree.getSuperTaskTree().removeSubTaskTree(taskTree);

        taskTree.setSuperTaskTree(this);
    }

    /**
     * Removes the passed TaskTree object from this CommonTaskTree's list of subTaskTrees. Returns false if no such
     * TaskTree was found.
     *
     * @param taskTree the TaskTree to be deleted
     * @return true if the deletion was successful, false otherwise
     */
    @Override
    public boolean removeSubTaskTree(TaskTree taskTree) {
        return false;
    }

    /**
     * Removes the passed TaskTree object from this CommonTaskTree's descendant TaskTrees. Returns false if no such
     * TaskTree was found.
     *
     * @param taskTree the TaskTree to be deleted
     * @return true if the deletion was successful, false otherwise
     */
    @Override
    public boolean removeChildTaskTree(TaskTree taskTree) {
        return false;
    }

    /**
     * Returns the TaskTree among this CommonTaskTree and its descendants that holds the given Task, null if no such
     * TaskTree was found.
     *
     * @param task the Task held by the desired TaskTree
     * @return the TaskTree object in possession of the passed Task, null otherwise
     */
    @Override
    public TaskTree getChildTaskTreeByTask(Task task) {
        return null;
    }

    /**
     * Returns the TaskTree among this CommonTaskTree and its descendants that holds the Task with the given ID, null
     * if no such TaskTree was found.
     *
     * @param taskID the unique ID held by the Task, held by the desired TaskTree
     * @return the TaskTree object in possession of the intended Task, null otherwise
     */
    @Override
    public TaskTree getChildTaskTreeByID(int taskID) {
        return null;
    }

    /**
     * Returns whether this CommonTaskTree has subTaskTrees
     *
     * @return true if this CommonTaskTrees subTaskTrees attribute has a size greater than 0, false otherwise
     */
    @Override
    public boolean hasSubTaskTrees() {
        return false;
    }

    /**
     * Returns whether this CommonTaskTree has a superTaskTree
     *
     * @return true if this CommonTaskTree's superTaskTree attribute is not null, false otherwise.
     */
    @Override
    public boolean hasSuperTaskTree() {
        return false;
    }

    /**
     * Returns a pre-order traversal of this CommonTaskTree, the initial call being the root.
     *
     * @return a list of TaskTrees
     */
    @Override
    public List<TaskTree> toList() {
        return null;
    }

    /**
     * Returns a pre-order traversal of this CommonTaskTree's tasks, the initial call being the root Task.
     *
     * @return a list of Tasks
     */
    @Override
    public List<Task> toListOfTasks() {
        return null;
    }

    /**
     * Sets this CommonTaskTree's Task's completion to 100, as well as setting any child TaskTrees Task's to 100,
     * and updating any superTaskTree's Task completion values
     */
    @Override
    public void completeTask() {

    }

    /**
     * Re-calculates this CommonTaskTree's Task's completion according to the completion of its subTaskTrees' Tasks.
     */
    @Override
    public void updateTask() {

    }

    /**
     * Return this CommonTaskTree's superTaskTree object.
     *
     * @return this CommonTaskTree's superTaskTree.
     */
    @Override
    public TaskTree getSuperTaskTree() {
        return null;
    }

    /**
     * Sets this CommonTaskTree's superTaskTree attribute to the provided CommonTaskTree.
     *
     * @param superTaskTree this CommonTaskTree's intended superTaskTree.
     */
    @Override
    public void setSuperTaskTree(TaskTree superTaskTree) {

    }

    /**
     * Returns a shallow copy of this CommonTaskTree's subTaskTrees.
     *
     * @return this CommonTaskTree's subTaskTrees.
     */
    @Override
    public List<TaskTree> getSubTaskTrees() {
        return null;
    }

    /**
     * Returns the Task object belonging to this CommonTaskTree.
     *
     * @return this CommonTaskTree's Task object.
     */
    @Override
    public Task getTask() {
        return null;
    }

    /**
     * Sets this CommonTaskTree's Task object to the provided Task.
     *
     * @param task this CommonTaskTree's intended Task object.
     */
    @Override
    public void setTask(Task task) {

    }
}
