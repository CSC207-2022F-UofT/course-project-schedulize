package entity_factories;

import entity_layer.CommonCurriculum;
import entity_layer.Curriculum;
import entity_layer.Task;
import entity_layer.TaskTree;

/**
 * A concrete factory for creating CommonCurriculums
 * Created: 11/25/2022
 * Last updated: 11/25/2022
 *
 * @author MMachadoUofT
 */
public class CommonCurriculumFactory implements CurriculumFactory {

    private final TaskTreeFactory taskTreeFactory;
    private final TaskFactory taskFactory;
    private final TimeBlockManagerFactory timeBlockManagerFactory;

    public CommonCurriculumFactory(TaskTreeFactory taskTreeFactory, TaskFactory taskFactory,
                                   TimeBlockManagerFactory timeBlockManagerFactory) {
        this.taskTreeFactory = taskTreeFactory;
        this.taskFactory = taskFactory;
        this.timeBlockManagerFactory = timeBlockManagerFactory;
    }

    /**
     * Returns a new CommonCurriculum object assigned the given name
     *
     * @param name this Curriculum's name
     * @return the newly created Curriculum object
     */
    @Override
    public Curriculum create(String name) {
        TaskTree goal = taskTreeFactory.create();
        Task goalTask = taskFactory.create(name, String.format("The %s curriculum", name));
        goal.setTask(goalTask);

        return new CommonCurriculum(goal, timeBlockManagerFactory.createEmpty(), timeBlockManagerFactory.createEmpty(),
                name);
    }
}
