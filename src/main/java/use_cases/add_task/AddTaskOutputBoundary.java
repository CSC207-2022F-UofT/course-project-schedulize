package use_cases.add_task;

/**
 * An output boundary interface that is implemented by the addTaskPresenter class.
 * Created: 11/20/2022
 * Last updated: 11/21/2022
 *
 * @author Bmguiler
 */

public interface AddTaskOutputBoundary {

    /**
     * Provides the View with information regarding a newly created task
     *
     * @param newTask A model for a newly created Task
     * @return A message regarding the success of a newly added task
     */
    String taskAdded(AddTaskModel newTask);
}
