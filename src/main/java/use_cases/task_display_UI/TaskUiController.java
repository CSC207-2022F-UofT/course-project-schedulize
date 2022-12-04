package use_cases.task_display_UI;

/**
 * Controller class for the display task use case; called by the tasktree UI
 * Created: 11/26/2022
 * Last updated: 11/29/2022
 *
 * @author Oswin Gan
 */
public class TaskUiController {
    private final TaskUiInputBoundary interactor;

    /**
     * Constructs a TaskUiController
     *
     * @param interactor the input boundary this controller uses to retrieve information from the entity layer
     */
    public TaskUiController(TaskUiInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * Displays a task with the given curriculum and task IDs
     * @param curriculumID the ID of the curriculum associated with the task
     * @param taskID the ID of the task
     */
    public void callInteractor(int curriculumID, int taskID) {
        this.interactor.displayTask(curriculumID, taskID);
    }
}
