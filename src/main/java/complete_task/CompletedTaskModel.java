package complete_task;

/**
 * A model class for packaging the required info needed by the completeTaskPresenter.
 *
 * Created: 11/18/2022
 * Last updated: 11/18/2022
 *
 * @author Bmguiler
 */

public class CompletedTaskModel {
    private final String curriculumName;
    private final String taskName;

    public CompletedTaskModel(String curriculumName, String taskName){
        this.curriculumName = curriculumName;
        this.taskName = taskName;
    }

    /**
     * Get the completed task's name.
     *
     * @return the completed task's name
     */
    public String getTaskName(){
        return this.taskName;
    }

    /**
     * Get the completed task's curriculum's name.
     *
     * @return the curriculum's name.
     */
    public String getCurriculumName(){
        return this.curriculumName;
    }
}
