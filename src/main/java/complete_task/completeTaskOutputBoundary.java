package complete_task;
import entityLayer.Curriculum;

/**
 * An output boundary interface that is implemented by the completeTaskPresenter class.
 *
 * @author Bmguiler
 */
public interface completeTaskOutputBoundary {

    int taskId = completeTaskController.taskId;
    boolean taskCompleted(int taskId, Curriculum taskCurriculum);
}
