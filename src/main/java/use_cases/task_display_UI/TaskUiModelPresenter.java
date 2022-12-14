package use_cases.task_display_UI;

import java.util.List;

/**
 * Presenter that updates the task UI with the requisite information from the TaskUiModel
 * Created: 11/26/2022
 * Last updated: 11/29/2022
 *
 * @author Oswin Gan
 */
public class TaskUiModelPresenter implements TaskUiOutputBoundary {
    private final List<TaskUiViewInterface> view;

    /** Gets task info to update the view with
     *
     * @param view the view
     */
    public TaskUiModelPresenter(List<TaskUiViewInterface> view) {
        this.view = view;
    }

    /**
     * Passes the TaskUiModel through to the view interface
     *
     * @param taskUiModel the task model
     */
    @Override
    public void getTaskInfo(TaskUiModel taskUiModel) {
        this.view.get(0).updateView(taskUiModel);
    }

    /**
     * Adds an observing view
     *
     * @param view the view
     */
    @Override
    public void addViewObserver(TaskUiViewInterface view) {
        this.view.add(view);
    }


}
