package use_cases.complete_task;


/**
 * An input boundary interface that is implemented by the completeTaskUseCase class.
 *
 * Created: 11/11/2022
 * Last updated: 11/18/2022
 *
 * @author Bmguiler
 */
public interface CompleteTaskInputBoundary {
    void completeTask(int curriculumId, int taskId);
    void uncompleteTask(int curriculumId, int taskId);
}
