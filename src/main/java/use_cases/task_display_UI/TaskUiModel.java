package use_cases.task_display_UI;

/**
 * Model class that packages the required information used by TaskUiModelPresenter
 * Created: 11/26/2022
 * Last updated: 11/29/2022
 *
 * @author Oswin Gan
 */
public class TaskUiModel {
    String name;
    String description;
    int completion;
    int curriculumID;
    int taskID;

    /**
     * Constructs a model of a Task for the TaskUI
     *
     * @param name the model task's name
     * @param description the model task's description
     * @param completion the model task's completion
     * @param curriculumID the id of the curriculum the original task belonged to
     * @param taskID the id of the original task entity
     */
    public TaskUiModel(String name, String description, int completion, int curriculumID, int taskID) {
        this.name = name;
        this.description = description;
        this.completion = completion;
        this.curriculumID = curriculumID;
        this.taskID = taskID;
    }

    /** get the task's name
     *
     * @return the task's name
     */
    public String getName() {
        return name;
    }

    /** get the task's  description
     *
     * @return the task's  description
     */
    public String getDescription() {
        return description;
    }

    /** get the task's completion level
     *
     * @return the task's completion level
     */
    public int getCompletion() {
        return completion;
    }

    /** get the task's curriculum ID
     *
     * @return the task's curriculum ID
     */
    public int getCurriculumID() {
        return curriculumID;
    }

    /** get the task's ID
     *
     * @return the task's ID
     */
    public int getTaskID() {
        return taskID;
    }
}
