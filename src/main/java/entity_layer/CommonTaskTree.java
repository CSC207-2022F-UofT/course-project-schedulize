package entity_layer;

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

        // Remove the given TaskTree from its previous superTaskTree's subTaskTrees
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
        if (this.subTaskTrees.contains(taskTree)) {
            this.subTaskTrees.remove(taskTree);
            return true;
        } else {
            return false;
        }
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
        // Check if it's a direct subtree
        if (this.removeSubTaskTree(taskTree))
            return true;
        // Recurse on all subtrees
        else {
            for (TaskTree subTaskTree : this.subTaskTrees) {
                if (this.removeChildTaskTree(taskTree)) return true;
            }
            // If we never returned, then we never had a true removal of the taskTree, so it was not removed.
            return false;
        }
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
        // Check if this is the matching tree
        if (this.task == task)
            return this;
        // Next, check if any of the subtrees might have it
        else {
            for (TaskTree taskTree : this.subTaskTrees) {
                // Store this given subTree's candidate to be compared
                TaskTree candidate = taskTree.getChildTaskTreeByTask(task);
                if (candidate != null)
                    return candidate;
            }
            return null;
        }
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
        if (this.task.getId() == taskID)
            return this;
        else {
            for (TaskTree taskTree : this.subTaskTrees) {
                TaskTree candidate = taskTree.getChildTaskTreeByID(taskID);
                if (candidate != null)
                    return candidate;
            }
            return null;
        }
    }

    /**
     * Returns whether this CommonTaskTree has subTaskTrees
     *
     * @return true if this CommonTaskTrees subTaskTrees attribute has a size greater than 0, false otherwise
     */
    @Override
    public boolean hasSubTaskTrees() {
        return this.subTaskTrees.size() > 0;
    }

    /**
     * Returns whether this CommonTaskTree has a superTaskTree
     *
     * @return true if this CommonTaskTree's superTaskTree attribute is not null, false otherwise.
     */
    @Override
    public boolean hasSuperTaskTree() {
        return this.superTaskTree != null;
    }

    /**
     * Returns a pre-order traversal of this CommonTaskTree, the initial call being the root.
     *
     * @return a list of TaskTrees
     */
    @Override
    public List<TaskTree> toList() {
        List<TaskTree> taskTreeList = new ArrayList<>();
        taskTreeList.add(this);

        for (TaskTree taskTree : this.subTaskTrees) {
            taskTreeList.addAll(taskTree.toList());
        }
        return taskTreeList;
    }

    /**
     * Returns a pre-order traversal of this CommonTaskTree's tasks, the initial call being the root Task.
     *
     * @return a list of Tasks
     */
    @Override
    public List<Task> toListOfTasks() {
        List<TaskTree> taskTreeList = this.toList();
        List<Task> taskList = new ArrayList<>();

        for (TaskTree taskTree : taskTreeList) {
            taskList.add(taskTree.getTask());
        }

        return taskList;
    }

    /**
     * Sets this CommonTaskTree's Task's completion to 100, as well as setting any child TaskTrees Task's to 100,
     * and updating any superTaskTree's Task completion values
     */
    @Override
    public void completeTask() {
        // Root task completion
        this.getTask().setCompletion(100);

        // SubTask completion
        for (TaskTree taskTree : this.subTaskTrees) {
            taskTree.completeTask();
        }

        // SuperTask update
        this.superTaskTree.updateTask();

        // Now that I'm writing this, I'm realizing that the recursive call to this TaskTree's subTaskTrees will cause
        //  updateTask() to be called over and over again. I'll have to think of a way to optimize this.
    }

    /**
     * Re-calculates this CommonTaskTree's Task's completion according to the completion of its subTaskTrees' Tasks.
     */
    @Override
    public void updateTask() {
        // Get the total amount of subtasks
        double subTaskCount = this.subTaskTrees.size();
        double taskCompletionSum = 0.0;

        // Get a total of all subtask's completions
        for (TaskTree taskTree : this.subTaskTrees) {
            taskCompletionSum += taskTree.getTask().getCompletion();
        }

        // Set this task's completion to the average completion of all of its subtasks
        this.task.setCompletion((int) (taskCompletionSum / subTaskCount));
    }

    /**
     * Return this CommonTaskTree's superTaskTree object.
     *
     * @return this CommonTaskTree's superTaskTree.
     */
    @Override
    public TaskTree getSuperTaskTree() {
        return this.superTaskTree;
    }

    /**
     * Sets this CommonTaskTree's superTaskTree attribute to the provided CommonTaskTree.
     *
     * @param superTaskTree this CommonTaskTree's intended superTaskTree.
     */
    @Override
    public void setSuperTaskTree(TaskTree superTaskTree) {
        this.superTaskTree = superTaskTree;
    }

    /**
     * Returns a shallow copy of this CommonTaskTree's subTaskTrees.
     *
     * @return this CommonTaskTree's subTaskTrees.
     */
    @Override
    public List<TaskTree> getSubTaskTrees() {
        return new ArrayList<>(this.subTaskTrees);
    }

    /**
     * Returns the Task object belonging to this CommonTaskTree.
     *
     * @return this CommonTaskTree's Task object.
     */
    @Override
    public Task getTask() {
        return this.task;
    }

    /**
     * Sets this CommonTaskTree's Task object to the provided Task.
     *
     * @param task this CommonTaskTree's intended Task object.
     */
    @Override
    public void setTask(Task task) {
        this.task = task;
    }
}
