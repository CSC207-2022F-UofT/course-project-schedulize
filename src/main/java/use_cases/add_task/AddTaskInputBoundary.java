package use_cases.add_task;

/**
 * An input boundary interface that is implemented by the Add Task Use Case class.
 * Created: 11/20/2022
 * Last updated: 11/21/2022
 *
 * @author Bmguiler
 */
public interface AddTaskInputBoundary {
    /**
     * Adds a task to the relevant curriculum
     *
     * @param taskName The name of this task
     * @param taskDescription The description for this task
     * @param parentId The ID of this Task's parent
     * @param curriculumId The ID of the curriculum this new task will belong to
     */
    void addTask(String taskName, String taskDescription, int parentId,
                 int curriculumId);
}
