package use_cases.display_curriculums;

import java.util.Map;

/**
 * A model class for packaging the required info needed by the DisplayCurriculumsPresenter
 * Created: 11/30/2022
 * Last updated: 12/01/2022
 *
 * @author Oswin Gan
 */

public class CurriculumsModel {
    private final Map<Integer, String> curriculums;

    /**
     * Constructor
     * @param curriculums A HashMap containing existing curriculums
     */
    public CurriculumsModel(Map<Integer, String> curriculums) {
        this.curriculums = curriculums;
    }

    /**
     * getter for the local variable curriculums
     * @return the curriculums HashMap
     */
    public Map<Integer, String> getCurriculums() {
        return curriculums;
    }
}
