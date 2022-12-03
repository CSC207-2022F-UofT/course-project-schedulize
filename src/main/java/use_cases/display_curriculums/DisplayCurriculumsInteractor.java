package use_cases.display_curriculums;

import entity_layer.Curriculum;
import entity_layer.InMemoryUser;
import entity_layer.Schedule;

import java.util.HashMap;

/**
 * Collects user schedule information to present to the Dashboard UI
 *
 * Created: 11/30/2022
 * Last updated: 12/01/2022
 *
 * @author Oswin Gan
 */
public class DisplayCurriculumsInteractor implements DisplayCurriculumsInputBoundary {

    private final DisplayCurriculumsOutputBoundary presenter;

    public DisplayCurriculumsInteractor(DisplayCurriculumsOutputBoundary presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayCurriculums() {
        Schedule schedule = InMemoryUser.getActiveUser().getSchedule();
        HashMap<Integer, String> curriculums = new HashMap<>();
        for (Curriculum curriculum : schedule.getCurriculums()) {
            curriculums.put(curriculum.getID(), curriculum.getName());
        }
        CurriculumsModel curriculumsModel = new CurriculumsModel(curriculums);
        this.presenter.displayCurriculums(curriculumsModel);
    }
}
