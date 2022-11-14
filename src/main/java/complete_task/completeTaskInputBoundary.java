package complete_task;
import entityLayer.User;

/**
 * An input boundary interface that is implemented by the completeTaskUseCase class.
 *
 * @author Bmguiler
 */
public interface completeTaskInputBoundary {

    int taskId = completeTaskController.taskId;
    int taskCurriculumId = completeTaskController.taskCurriculumId;
    User activeUser = completeTaskController.activeUser;
    void completeTask(int TaskId, int taskCurriculumId, User activeUser);

}
