package use_cases.create_curriculum;

import entity_factories.CurriculumFactory;
import entity_factories.PrebuiltCurriculumFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import use_cases.display_curriculums.CurriculumsModel;
import use_cases.display_curriculums.DisplayCurriculumsInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateCurriculumUseCaseTests {
    static CreateCurriculumController controller;

    @BeforeAll
    public static void setUp() {
        CurriculumFactory factory = new PrebuiltCurriculumFactory();
        CreateCurriculumInputBoundary interactor = new CreateCurriculumInteractor(factory);
        controller = new CreateCurriculumController(interactor);
    }

    static class TestView implements DisplayCurriculumsInterface {

        private HashMap<Integer, String> curriculums;

        @Override
        public void displayCurriculums(CurriculumsModel curriculumsModel) {
            this.curriculums = curriculumsModel.getCurriculums();
        }

        public HashMap<Integer, String> getCurriculums() {
            return this.curriculums;
        }
    }

    @Test
    private void testCurriculumCreation() {

    }
}
