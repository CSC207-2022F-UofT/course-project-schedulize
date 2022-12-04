package use_cases.add_task;

/**
 * A model class for packaging the required info needed by the AddTaskPresenter.
 * Created: 11/20/2022
 * Last updated: 11/21/2022
 *
 * @author Bmguiler
 */

public class AddTaskModel {
    private final String taskName;
    private final String taskDescription;
    private final String curriculumName;
    private final String parentTaskName;

    /**
     * Add Task Model Constructor method.
     *
     * @param taskName the name of the task being added.
     * @param taskDescription the description of the task being added.
     * @param curriculumName the name of the curriculum that the task is being added to.
     * @param parentTaskName the name of the parent task of the task being added.
     */
    public AddTaskModel(String taskName, String taskDescription,
                        String curriculumName, String parentTaskName){
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.curriculumName = curriculumName;
        this.parentTaskName = parentTaskName;
    }

    /**
     * Get the task's name.
     *
     * @return the task's name.
     */
    public String getTaskName(){
        return this.taskName;
    }

    /**
     * Get the task's description.
     *
     * @return the task's description.
     */
    public String getTaskDescription(){
        return this.taskDescription;
    }

    /**
     * Get the curriculum's name.
     *
     * @return the curriculum's name.
     */
    public String getCurriculumName(){
        return this.curriculumName;
    }

    /**
     * Get the parent task's name.
     *
     * @return the parent task's name.
     */
    public String getParentTaskName() { return this.parentTaskName;}


}
