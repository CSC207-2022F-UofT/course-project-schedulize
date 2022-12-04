package use_cases.task_display_UI;

/**
 * An output boundary interface implemented by the TaskUiModelPresenter class.
 *
 * Created: 11/26/2022
 * Last updated: 11/28/2022
 *
 * @author Oswin Gan
 */
public interface TaskUiOutputBoundary {
    void getTaskInfo(TaskUiModel taskUiModel);
    void addViewObserver(TaskUiViewInterface view);
}
