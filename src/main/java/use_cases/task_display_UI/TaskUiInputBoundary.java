package use_cases.task_display_UI;

/**
 * An input boundary interface implemented by the TaskUiInteractor class.
 * Created: 11/26/2022
 * Last updated: 11/28/2022
 *
 * @author Oswin Gan
 */
public interface TaskUiInputBoundary {
    /**
     * Prepares to display a task as retrieved by the entity layer
     *
     * @param curriculumID the ID of the curriculum the requisite task belongs to
     * @param taskID the ID of the requisite task
     */
    void displayTask(int curriculumID, int taskID);
}
