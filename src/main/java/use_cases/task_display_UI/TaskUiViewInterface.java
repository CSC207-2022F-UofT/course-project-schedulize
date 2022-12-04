package use_cases.task_display_UI;

/**
 * An interface implemented by the TaskUI class.
 * Created: 11/26/2022
 * Last updated: 11/28/2022
 *
 * @author Oswin Gan
 */
public interface TaskUiViewInterface {

    /**
     * Update the view with information from the TaskUiModel
     *
     * @param taskUiModel the model task
     */
    void updateView(TaskUiModel taskUiModel);
}
