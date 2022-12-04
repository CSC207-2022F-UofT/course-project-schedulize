package entity_factories;

import entity_layer.CommonCurriculum;
import entity_layer.Curriculum;
import entity_layer.TaskTree;

/**
 * A concrete factory that creates a Curriculum, instantiating other factories within itself.
 * Created: 11/28/2022
 * Last updated: 11/28/2022
 *
 * @author MMachadoUofT
 */
public class PrebuiltCurriculumFactory implements CurriculumFactory {

    /* ********** *\
    *  Attributes  *
    \* ********** */
    private final TaskTreeFactory taskTreeFactory = new CommonTaskTreeFactory();
    private final TimeBlockManagerFactory timeBlockManagerFactory = new CommonTimeBlockManagerFactory();

    /* ************* *\
    *  Functionality  *
    \* ************* */
    /**
     * Returns a new Curriculum object assigned the given name
     *
     * @param name this Curriculum's name
     * @return the newly created Curriculum object
     */
    @Override
    public Curriculum create(String name) {
        TaskTree goal = taskTreeFactory.createWithTask(name, String.format("The %s curriculum", name));

        return new CommonCurriculum(goal, timeBlockManagerFactory.createEmpty(), timeBlockManagerFactory.createEmpty(),
                name);
    }
}
