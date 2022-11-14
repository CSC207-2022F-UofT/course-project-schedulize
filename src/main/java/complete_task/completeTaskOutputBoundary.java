package complete_task;
import entityLayer.User;

/**
 * An output boundary interface that is implemented by the completeTaskPresenter class.
 *
 * @author Bmguiler
 */
public interface completeTaskOutputBoundary {

    int taskId = completeTaskController.taskId;
    int taskCurriculumId = completeTaskController.taskCurriculumId;
    User activeUser = completeTaskController.activeUser;
    boolean taskCompleted(int taskId, int taskCurriculumId, User activeUser);
}
