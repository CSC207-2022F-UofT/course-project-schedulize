package use_cases.add_task;

/**
 * Controller for the Add Task use case; receives user input from the UI.
 *
 * Created: 11/20/2022
 * Last updated: 11/21/2022
 *
 * @author Bmguiler
 */
public class AddTaskController {
    private AddTaskInputBoundary userInput;

    /**
     * Controller constructor.
     *
     * @param userInput the user input passed from the UI.
     */
    public AddTaskController(AddTaskInputBoundary userInput){
        this.userInput = userInput;
    }

    /**
     * Add Task method for the UI to call when the user clicks to add a task on
     * the dashboard.
     *
     * @param taskName the name of the task to be added.
     * @param taskDescription the description of the task to be added.
     * @param parentId the id of the parent task of the task to be added.
     * @param curriculumId the id of the curriculum that the task is going
     *                     to be added to.
     */
    public void addTask(String taskName, String taskDescription, int parentId,
                        int curriculumId){
        this.userInput.addTask(taskName, taskDescription, parentId, curriculumId);
    }

    // TODO: what if there is no parent task?
}
