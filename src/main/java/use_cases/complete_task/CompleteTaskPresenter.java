package use_cases.complete_task;

import java.util.List;

/**
 * Presenter for the UI that confirms that the task was completed.
 *
 * Created: 11/11/2022
 * Last updated: 11/18/2022
 *
 * @author Bmguiler
 */
public class CompleteTaskPresenter implements CompleteTaskOutputBoundary {

    private final List<CompleteTaskUiInterface> taskUI;

    public CompleteTaskPresenter(List<CompleteTaskUiInterface> taskUI){
        this.taskUI = taskUI;
    }

    /**
     * Display a message that the task was completed.
     *
     * @param taskCompleted model containing completed task information.
     * @return a message confirming the task was completed.
     */
    @Override
    public String taskCompleted(CompletedTaskModel taskCompleted) {
        this.taskUI.get(0).updateView("The task " + taskCompleted.getTaskName() + " from " +
                taskCompleted.getCurriculumName() + " was successfully completed.");
    }

}
