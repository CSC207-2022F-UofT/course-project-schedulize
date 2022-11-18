package complete_task;

/**
 * Controller for the completeTask use case; receives user input
 * from the UI.
 *
 * Created: 11/11/2022
 * Last updated: 11/18/2022
 *
 * @author Bmguiler
 */
public class completeTaskController {
    private completeTaskInputBoundary userInput;

    public completeTaskController(completeTaskInputBoundary userInput){
        this.userInput = userInput;
    }

    public void completeTask(int curriculumId, int taskId){
        this.userInput.completeTask(curriculumId, taskId);
    }
}
