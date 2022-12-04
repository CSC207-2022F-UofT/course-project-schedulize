package use_cases.task_display_UI;

import entity_layer.Curriculum;
import entity_layer.InMemoryUser;
import entity_layer.Task;

/**
 * Interactor class for the display task use case
 *
 * Created: 11/26/2022
 * Last updated: 11/29/2022
 *
 * @author Oswin Gan
 */
public class TaskUiInteractor implements TaskUiInputBoundary {
    private final TaskUiOutputBoundary presenter;
    public TaskUiInteractor(TaskUiOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * creates a model of the task associated with the curriculum and task IDs and calls the presenter
     * @param curriculumID the ID of the curriculum associated with the task
     * @param taskID the ID of the task
     */
    public void displayTask(int curriculumID, int taskID) {
        Curriculum thisCurriculum = InMemoryUser.getActiveUser().getSchedule().getCurriculum(curriculumID);
        Task thisTask = thisCurriculum.getGoal().getChildTaskTreeByID(taskID).getTask();
        TaskUiModel taskUiModel = new TaskUiModel(thisTask.getName(), thisTask.getDescription(),
                thisTask.getCompletion(), curriculumID, taskID);
        this.presenter.getTaskInfo(taskUiModel);
    }
}
