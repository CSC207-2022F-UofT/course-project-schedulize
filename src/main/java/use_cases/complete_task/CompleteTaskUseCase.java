package use_cases.complete_task;
import entity_layer.*;

/**
 * Use Case for completing a task.
 *
 * Created: 11/11/2022
 * Last updated: 11/18/2022
 *
 * @author Bmguiler
 */

public class CompleteTaskUseCase implements CompleteTaskInputBoundary {
    private CompleteTaskOutputBoundary presenter;

    public CompleteTaskUseCase(CompleteTaskOutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     * Complete the task by setting the Task's completion to 100.
     * @param taskId the unique id of the task to be completed.
     * @param taskCurriculumId the unique id of the curriculum
     *                         that the task belongs to.
     */
    @Override
    public void completeTask(int taskCurriculumId, int taskId){
        Schedule schedule = InMemoryUser.getActiveUser().getSchedule();
        Curriculum taskCurriculum = schedule.getCurriculum(taskCurriculumId);
        TaskTree taskTree = taskCurriculum.getTaskTreeByID(taskId);
        taskTree.completeTask();

        String taskName = taskTree.getTask().getName();
        CompletedTaskModel completedTask = new CompletedTaskModel
                (taskCurriculum.getName(), taskName);

        presenter.taskCompleted(completedTask);
    }

}
