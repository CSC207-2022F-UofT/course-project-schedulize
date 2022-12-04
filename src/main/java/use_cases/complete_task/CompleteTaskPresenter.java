package use_cases.complete_task;

import java.util.List;

/**
 * Presenter for the UI that confirms that the task was completed.
 * Created: 11/11/2022
 * Last updated: 11/18/2022
 *
 * @author Bmguiler
 */
public class CompleteTaskPresenter implements CompleteTaskOutputBoundary {

    private final List<CompleteTaskUiInterface> taskUI;

    /**
     * Constructs a CompleteTaskPresenter
     *
     * @param taskUI A list of observer Views. This list will never exceed a size of one
     */
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
        String viewMessage = "The task " + taskCompleted.getTaskName() + " from " +
                taskCompleted.getCurriculumName() + " was successfully completed.";
        for (CompleteTaskUiInterface taskUI : this.taskUI) {
            taskUI.updateView("The task " + taskCompleted.getTaskName() + " from " +
                    taskCompleted.getCurriculumName() + " was successfully completed.");
        }
        return viewMessage;
    }

}
