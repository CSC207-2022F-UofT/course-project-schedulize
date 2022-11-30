package use_cases.add_task;

/**
 * Presenter for the UI that confirms that the task was added to the correct
 * curriculum and correct parent task.
 *
 * Created: 11/20/2022
 * Last updated: 11/21/2022
 *
 * @author Bmguiler
 */

public class AddTaskPresenter implements AddTaskOutputBoundary {

    /**
     * Display a message that the task was added.
     *
     * @param newTask model containing the added task's information.
     * @return a message confirming the task was added.
     */
    @Override
    public String taskAdded(AddTaskModel newTask) {
        return "New task with name: " + newTask.getTaskName() + " and description: "
                + newTask.getTaskDescription()
                + " was successfully added to the curriculum: "
                + newTask.getCurriculumName()
                + " as a subtask of: "
                + newTask.getParentTaskName()
                + ".";
    }
}
