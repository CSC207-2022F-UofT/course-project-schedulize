package use_cases.display_task_tree;

import entity_factories.CommonUserFactory;
import entity_factories.CurriculumFactory;
import entity_factories.PrebuiltCurriculumFactory;
import entity_layer.Curriculum;
import entity_layer.InMemoryUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * A class that tests the display use case for TaskTrees on the TaskTreeUI
 * Created: 12/01/2022
 * Last updated: 12/01/2022
 *
 * @author David Adler
 */
public class DisplayTaskTreeTests {
    static DisplayTaskTreeController controller;

    /**
     * Set up use case objects
     */
    @BeforeAll
    public static void setUp() {
        DisplayTaskTreeOutputBoundary presenter = new DisplayTaskTreePresenter();
        DisplayTaskTreeInputBoundary interactor = new DisplayTaskTreeInteractor(presenter);
        controller = new DisplayTaskTreeController(interactor);
    }

    /**
     * Test finding a curriculum and task, using their IDs
     */
    @Test
    public void testDisplayTreeController() {
        InMemoryUser.setActiveUser(new CommonUserFactory().create("username", "like@yaho.co",
                "password"));
        CurriculumFactory factory = new PrebuiltCurriculumFactory();
        Curriculum testCurriculum = factory.create("new_curriculum");

        InMemoryUser.getActiveUser().getSchedule().addCurriculum(testCurriculum);

        // Test finding a task and curriculum using the controller -- if they cannot be found an exception will be
        // raised
        controller.getRoot(testCurriculum.getID());
        controller.getSubtrees(testCurriculum.getID(), testCurriculum.getGoal().getTask().getId());
    }
}
