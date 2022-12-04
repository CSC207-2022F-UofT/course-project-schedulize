package use_cases.display_curriculums;

import entity_factories.CommonUserFactory;
import entity_factories.CurriculumFactory;
import entity_factories.PrebuiltCurriculumFactory;
import entity_layer.InMemoryUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class that tests the display use case for curriculums on the dashboard
 * Created: 12/01/2022
 * Last updated: 12/01/2022
 *
 * @author David Adler
 */
public class DisplayCurriculumTests {
    static DisplayCurriculumsController controller;
    static TestView testView;

    /**
     * A test view class that tests whether its information has been updated since it is an observer that the presenter
     * updates
     */
    private static class TestView implements DisplayCurriculumsInterface {
        private HashMap<Integer, String> curriculums;

        @Override
        public void displayCurriculums(CurriculumsModel curriculumsModel) {
            this.curriculums = curriculumsModel.getCurriculums();
        }

        public HashMap<Integer, String> getCurriculums() {
            return this.curriculums;
        }
    }

    /**
     * Sets up necessary objects for testing this use case
     */
    @BeforeAll
    public static void setUp() {
        testView = new TestView();
        DisplayCurriculumsOutputBoundary presenter = new DisplayCurriculumsPresenter(new ArrayList<>());
        presenter.addViewObserver(testView);
        DisplayCurriculumsInputBoundary interactor = new DisplayCurriculumsInteractor(presenter);
        controller = new DisplayCurriculumsController(interactor);
    }

    /**
     * Tests the return information that will be displayed from a User with 3 curriculums is correct
     */
    @Test
    public void testDisplayInformation() {
        InMemoryUser.setActiveUser(new CommonUserFactory().create("username", "like@yaho.co",
                "password"));
        CurriculumFactory factory = new PrebuiltCurriculumFactory();

        InMemoryUser.getActiveUser().getSchedule().addCurriculum(factory.create("new_curriculum"));
        InMemoryUser.getActiveUser().getSchedule().addCurriculum(factory.create("new_curriculum"));
        InMemoryUser.getActiveUser().getSchedule().addCurriculum(factory.create("new_curriculum"));

        controller.openDashboard();
        assert testView.getCurriculums().size() == 3;
    }
}
