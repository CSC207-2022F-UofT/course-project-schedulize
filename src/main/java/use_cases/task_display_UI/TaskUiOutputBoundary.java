package use_cases.task_display_UI;

/**
 * An output boundary interface implemented by the TaskUiModelPresenter class.*
 * Created: 11/26/2022
 * Last updated: 11/28/2022
 *
 * @author Oswin Gan
 */
public interface TaskUiOutputBoundary {

    /**
     * Passes the TaskUiModel through to the view interface
     *
     * @param taskUiModel the task model
     */
    void getTaskInfo(TaskUiModel taskUiModel);

    /**
     * Adds an observing view
     *
     * @param view the view
     */
    void addViewObserver(TaskUiViewInterface view);
}
