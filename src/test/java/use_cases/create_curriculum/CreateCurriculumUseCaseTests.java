package use_cases.create_curriculum;

import entity_factories.CommonUserFactory;
import entity_factories.CurriculumFactory;
import entity_factories.PrebuiltCurriculumFactory;
import entity_layer.InMemoryUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CreateCurriculumUseCaseTests {
    static CreateCurriculumController controller;

    @BeforeAll
    public static void setUp() {
        CurriculumFactory factory = new PrebuiltCurriculumFactory();
        CreateCurriculumInputBoundary interactor = new CreateCurriculumInteractor(factory);
        controller = new CreateCurriculumController(interactor);
    }

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
