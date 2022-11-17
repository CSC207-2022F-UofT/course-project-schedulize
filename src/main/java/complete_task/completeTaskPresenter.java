package complete_task;
import entity_layer.Schedule;
import entity_layer.Curriculum;
import entity_layer.Task;
import entity_layer.TaskTree;
import entity_layer.User;
import entity_layer.InMemoryUser;

/**
 * Presenter for the completeTask use case that receives if the task
 * was successfully completed in order for the dashboard view to update.
 *
 * @author Bmguiler
 */
public class completeTaskPresenter implements completeTaskOutputBoundary{

    /**
     * Check if the task was successfully completed.
     *
     * @param taskId the unique id of the task to be completed.
     * @param taskCurriculumId the unique id of curriculum that the task belongs to.
     * @param activeUser the active user using the program right now.
     * @return true if the task's completion is 100, return false otherwise.
     */
    @Override
    public boolean taskCompleted(int taskId, int taskCurriculumId, User activeUser) {
        Schedule schedule = activeUser.getSchedule();
        Curriculum taskCurriculum = schedule.getCurriculum(taskCurriculumId);
        TaskTree taskTree = taskCurriculum.getTaskTreeByID(taskId);
        Task task = taskTree.getTask();
        return task.isComplete();
    }

    // if taskCompleted returns true, then UI changes
}
