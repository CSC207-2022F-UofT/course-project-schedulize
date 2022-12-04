package use_cases.complete_task;

/**
 * Controller for the completeTask use case; receives user input
 * from the UI.
 * Created: 11/11/2022
 * Last updated: 11/18/2022
 *
 * @author Bmguiler
 */
public class CompleteTaskController {
    private final CompleteTaskInputBoundary userInput;

    /**
     * Constructs a CompleteTaskController
     * @param userInput The input boundary this controller will ask to access the entity layer
     */
    public CompleteTaskController(CompleteTaskInputBoundary userInput){
        this.userInput = userInput;
    }

    /**
     * Completes the task with the given ID information
     *
     * @param curriculumId The ID for the curriculum this Task belongs to
     * @param taskId The ID of the task to be completed
     */
    public void completeTask(int curriculumId, int taskId){
        this.userInput.completeTask(curriculumId, taskId);
    }
}
