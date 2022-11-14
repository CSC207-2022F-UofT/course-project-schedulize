package complete_task;
import entity_layer.Curriculum;

/**
 * An input boundary interface that is implemented by the completeTaskUseCase class.
 *
 * @author Bmguiler
 */
public interface completeTaskInputBoundary {

    int taskId = completeTaskController.taskId;
    Curriculum taskCurriculum = completeTaskController.taskCurriculum;
    void completeTask(int TaskId, Curriculum taskCurriculum);

}
