package use_cases.display_curriculums;

import entity_layer.Curriculum;
import entity_layer.InMemoryUser;
import entity_layer.Schedule;

import java.util.HashMap;

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
