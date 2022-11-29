package set_availability;

/**
 * A model class for packaging the required info needed by the setAvailabilityPresenter.
 *
 * @author od-obas1187
 */
public class SetAvailabilityModel {

    private final String curriculumName;

    public SetAvailabilityModel(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    /**
     * Get curriculum w/ availabities newly set
     */
    public String getCurriculumName() {return this.curriculumName;}
}
