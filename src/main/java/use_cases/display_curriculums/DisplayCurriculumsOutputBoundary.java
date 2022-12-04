package use_cases.display_curriculums;

/**
 * An output boundary to relay display curriculums information to a View
 */
public interface DisplayCurriculumsOutputBoundary {
    /**
     * Prepare the curriculumsModel to be passed to and displayed by the View
     *
     * @param curriculumsModel the model of curriculums
     */
    void displayCurriculums(CurriculumsModel curriculumsModel);

    /**
     * Add an observer View to this output boundaries observers
     *
     * @param viewObserver an observing view
     */
    void addViewObserver(DisplayCurriculumsInterface viewObserver);
}
