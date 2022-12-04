package use_cases.create_curriculum;

import entity_factories.CommonUserFactory;
import entity_factories.CurriculumFactory;
import entity_factories.PrebuiltCurriculumFactory;
import entity_layer.InMemoryUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * A class that tests the creation use case for a new curriculum
 * Created: 12/01/2022
 * Last updated: 12/01/2022
 *
 * @author David Adler
 */
public class CreateCurriculumUseCaseTests {
    static CreateCurriculumController controller;

    /**
     * Sets up the create curriculum controller
     */
    @BeforeAll
    public static void setUp() {
        CurriculumFactory factory = new PrebuiltCurriculumFactory();
        CreateCurriculumInputBoundary interactor = new CreateCurriculumInteractor(factory);
        controller = new CreateCurriculumController(interactor);
    }

    /**
     * Tests the creation of 3 curriculums for the InMemoryUser
     */
    @Test
    public void testCurriculumCreation() {
        InMemoryUser.setActiveUser(new CommonUserFactory().create("username", "like@yaho.co",
                "password"));
        controller.createCurriculum("new_curriculum");
        controller.createCurriculum("new_curriculum");
        controller.createCurriculum("new_curriculum");

        assert InMemoryUser.getActiveUser().getSchedule().getCurriculums().size() == 3;
    }
}
