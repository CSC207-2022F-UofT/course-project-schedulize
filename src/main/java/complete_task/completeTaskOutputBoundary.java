package complete_task;

/**
 * An output boundary interface that is implemented by the completeTaskPresenter class.
 *
 * Created: 11/11/2022
 * Last updated: 11/18/2022
 *
 * @author Bmguiler
 */
public interface completeTaskOutputBoundary {
    String taskCompleted(CompletedTaskModel completedTask);
}
