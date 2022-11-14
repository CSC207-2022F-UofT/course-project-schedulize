package complete_task;
import entityLayer.User;

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
    public static User activeUser;

    public completeTaskController(int taskId, int taskCurriculumId, User activeUser){
        this.taskId = taskId;
        this.taskCurriculumId = taskCurriculumId;
        this.activeUser = activeUser;
    }
}
