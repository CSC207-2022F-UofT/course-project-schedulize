package use_cases.display_curriculums;

import java.util.HashMap;

public class CurriculumsModel {
    private final HashMap<Integer, String> curriculums;

    public CurriculumsModel(HashMap<Integer, String> curriculums) {
        this.curriculums = curriculums;
    }

    public HashMap<Integer, String> getCurriculums() {
        return curriculums;
    }
}
