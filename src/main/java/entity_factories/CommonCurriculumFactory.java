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

    /* ********** *\
    *  Attributes  *
    \* ********** */
    private final TaskTreeFactory taskTreeFactory;
    private final TaskFactory taskFactory;
    private final TimeBlockManagerFactory timeBlockManagerFactory;

    /* ************ *\
    *  Constructors  *
    \* ************ */
    /**
     * A constructor for the CommonCurriculumFactory
     *
     * @param taskTreeFactory The TaskTreeFactory this will use to build the root TaskTree
     * @param taskFactory The TaskFactory this will use to build the root Task in the TaskTree
     * @param timeBlockManagerFactory The TimeBlockManagerFactory this will use to create the default worktimes
     */
    public CommonCurriculumFactory(TaskTreeFactory taskTreeFactory, TaskFactory taskFactory,
                                   TimeBlockManagerFactory timeBlockManagerFactory) {
        this.taskTreeFactory = taskTreeFactory;
        this.taskFactory = taskFactory;
        this.timeBlockManagerFactory = timeBlockManagerFactory;
    }

    /* ************* *\
    *  Functionality  *
    \* ************* */
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
