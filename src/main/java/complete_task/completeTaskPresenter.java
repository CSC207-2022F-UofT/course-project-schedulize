package complete_task;

/**
 * Presenter for the UI that confirms that the task was completed.
 *
 * Created: 11/11/2022
 * Last updated: 11/18/2022
 *
 * @author Bmguiler
 */
public class completeTaskPresenter implements completeTaskOutputBoundary{

    /**
     * Confirm that the task was completed.
     *
     * @param taskCompleted model containing completed task information.
     * @return a message confirming the task was completed.
     */
    @Override
    public String taskCompleted(CompletedTaskModel taskCompleted) {
        return "The task " + taskCompleted.getTaskName() + " from " +
                taskCompleted.getCurriculumName() + " was successfully completed.";
    }

}
