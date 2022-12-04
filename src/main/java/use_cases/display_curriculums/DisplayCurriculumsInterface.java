package use_cases.display_curriculums;

/**
 * An interface to allow the DisplayCurriculumsPresenter to pass curriculum list information to the View
 */
public interface DisplayCurriculumsInterface {
    /**
     * Display the passed curriculum models on the View
     *
     * @param curriculumsModel A model list of the curriculums
     */
    void displayCurriculums(CurriculumsModel curriculumsModel);
}
