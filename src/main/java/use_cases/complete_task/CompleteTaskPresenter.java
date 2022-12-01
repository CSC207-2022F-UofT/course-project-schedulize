package use_cases.complete_task;

/**
 * Presenter for the UI that confirms that the task was completed.
 *
 * Created: 11/11/2022
 * Last updated: 11/18/2022
 *
 * @author Bmguiler
 */
public class CompleteTaskPresenter implements CompleteTaskOutputBoundary {

    /**
     * Display a message that the task was completed.
     *
     * @param taskCompleted model containing completed task information.
     * @return a message confirming the task was completed.
     */
    @Override
    public String taskCompleted(CompletedTaskModel taskCompleted) {
        return "The task " + taskCompleted.getTaskName() + " from " +
                taskCompleted.getCurriculumName() + " was successfully completed.";
    }

    @Override
    public String taskUncompleted(CompletedTaskModel taskUncompleted){
        return "The task " + taskUncompleted.getTaskName() + " from " +
                taskUncompleted.getCurriculumName() + " was successfully uncompleted.";
    }

}
