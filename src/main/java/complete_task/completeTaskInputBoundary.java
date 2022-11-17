package complete_task;
import entity_layer.User;
import entity_layer.InMemoryUser;

/**
 * An input boundary interface that is implemented by the completeTaskUseCase class.
 *
 * @author Bmguiler
 */
public interface completeTaskInputBoundary {

    int taskId = completeTaskController.taskId;
    int taskCurriculumId = completeTaskController.taskCurriculumId;
    User activeUser = InMemoryUser.getActiveUser();
    void completeTask(int TaskId, int taskCurriculumId, User activeUser);

}
