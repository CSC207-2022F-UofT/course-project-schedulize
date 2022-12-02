package task_display_ui;

/**
 * Presenter that updates the task UI with the requisite information from the TaskUiModel
 *
 * Created: 11/26/2022
 * Last updated: 11/29/2022
 *
 * @author Oswin Gan
 */
public class TaskUiModelPresenter implements TaskUiOutputBoundary {
    private final TaskUiViewInterface view;

    /** Gets task info to update the view with
     *
     * @param view the view
     */
    public TaskUiModelPresenter(TaskUiViewInterface view) {
        this.view = view;
    }
    @Override
    public void getTaskInfo(TaskUiModel taskUiModel) {
        this.view.updateView(taskUiModel);
    }
}
