package complete_task;
import entity_layer.Curriculum;
import entity_layer.Task;
import entity_layer.TaskTree;

/**
 * Use Case for completing a task.
 *
 * @author Bmguiler
 */

public class completeTaskUseCase implements completeTaskInputBoundary {

    /**
     * Complete the task by setting the Task's completion to 100.
     * @param taskId the unique id of the task to be completed.
     */
    @Override
    public void completeTask(int taskId, Curriculum taskCurriculum){
        TaskTree taskTree = taskCurriculum.getTaskTreeByID(taskId);
        Task task = taskTree.getTask();
        task.setCompletion(100);
    }

    // still need to implement a method to update the task's supertask completion
}
