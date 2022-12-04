package use_cases.complete_task;

/**
 * An output boundary interface that is implemented by the completeTaskPresenter class.
 * Created: 11/11/2022
 * Last updated: 11/18/2022
 *
 * @author Bmguiler
 */
public interface CompleteTaskOutputBoundary {
    /**
     * Returns a message regarding the success of the task completion
     *
     * @param completedTask A model of the completed task
     * @return A success message
     */
    String taskCompleted(CompletedTaskModel completedTask);
}
