package complete_task;
import entity_layer.User;

/**
 * Controller for the completeTask use case; receives user input in
 * the form of the id of the task to be completed, the id of the
 * curriculum that the task belongs to and the active user.
 *
 * @author Bmguiler
 */
public class completeTaskController {
    public static int taskId;
    public static int taskCurriculumId;

    public completeTaskController(int taskId, int taskCurriculumId){
        this.taskId = taskId;
        this.taskCurriculumId = taskCurriculumId;
    }
}
