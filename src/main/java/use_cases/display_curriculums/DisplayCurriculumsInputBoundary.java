package use_cases.display_curriculums;

/**
 * An input boundary that will collect necessary curriculum information from the entity layer
 */
public interface DisplayCurriculumsInputBoundary {
    /**
     * Access the required Schedule's curriculums for the View
     */
    void displayCurriculums();
}
