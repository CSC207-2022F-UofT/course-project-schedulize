package complete_task;
import entity_layer.User;
import entity_layer.InMemoryUser;

/**
 * An output boundary interface that is implemented by the completeTaskPresenter class.
 *
 * @author Bmguiler
 */
public interface completeTaskOutputBoundary {

    int taskId = completeTaskController.taskId;
    int taskCurriculumId = completeTaskController.taskCurriculumId;
    User activeUser = InMemoryUser.loadedUser;
    boolean taskCompleted(int taskId, int taskCurriculumId, User activeUser);
}
