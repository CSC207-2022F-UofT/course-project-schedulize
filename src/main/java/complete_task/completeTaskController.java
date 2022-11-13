package complete_task;
import entity_layer.Curriculum;

/**
 * Controller for the completeTask use case; receives user input in
 * the form of the id of the task to be completed and the curriculum
 * that the task belongs to.
 *
 * @author Bmguiler
 */
public class completeTaskController {
    public static int taskId;
    public static Curriculum taskCurriculum;

    public completeTaskController(int taskId, Curriculum taskCurriculum){
        this.taskId = taskId;
        this.taskCurriculum = taskCurriculum;

    }
}
