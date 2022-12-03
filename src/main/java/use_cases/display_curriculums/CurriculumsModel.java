package use_cases.display_curriculums;

import java.util.HashMap;

/**
 * A model class for packaging the required info needed by the DisplayCurriculumsPresenter
 *
 * Created: 11/30/2022
 * Last updated: 12/01/2022
 *
 * @author Oswin Gan
 */

public class CurriculumsModel {
    private final HashMap<Integer, String> curriculums;

    /**
     * Constructor
     * @param curriculums A HashMap containing existing curriculums
     */
    public CurriculumsModel(HashMap<Integer, String> curriculums) {
        this.curriculums = curriculums;
    }

    /**
     * getter for the local variable curriculums
     * @return the curriculums HashMap
     */
    public HashMap<Integer, String> getCurriculums() {
        return curriculums;
    }
}
