package use_cases.complete_task;

/**
 * An interface to be implemented by any View the CompletedTaskPresenter would like to present information to
 */
public interface CompleteTaskUiInterface {
    /**
     * Update the view incorporating the completion message
     *
     * @param completed the completion message
     */
    void updateView(String completed);
}
