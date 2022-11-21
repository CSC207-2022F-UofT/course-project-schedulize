package setavailability;

/**
 * Class responsible for creating a TimeManager entity with multiple TimeBlock items, created with the
 * passed information
 *
 * @author ad-obas1187
 */
public class SetAvailabilityUseCase implements SetAvailabilityInputBoundary {

    SetAvailabilityPresenter availabilityPresenter;

    //ALL INTERACTORS WILL USE inMemoryUser in constructor (inMemoryUser.getActiveUser())
    // - Not touched by controllers or presenters; only used by interactors to do fancy stuff

    //public static TimeManager availabilities

    /**
     * 1. Take in (String[]) list of availabities inputted by User
     * 2. Using that, create a CommonTimeBlockManager factory that further creates a CommonTimeBlockManager
     * 3. Create a SetAvailability Presenter
     * 4. Return that presenter
     *
     * @param availabilityInputs an array...
     * @return availabilityPresenter a presenter...
     */
    @Override
    public SetAvailabilityPresenter create(String[] availabilityInputs) {


        return null;
    }
}
