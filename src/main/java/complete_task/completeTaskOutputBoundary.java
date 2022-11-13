package complete_task;
import entity_layer.Curriculum;

/**
 * An output boundary interface that is implemented by the completeTaskPresenter class.
 *
 * @author Bmguiler
 */
public interface completeTaskOutputBoundary {

    int taskId = completeTaskController.taskId;
    boolean taskCompleted(int taskId, Curriculum taskCurriculum);
}
