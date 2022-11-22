package set_availability;
import entity_layer.*;

import java.util.function.Consumer;

/**
 * Class responsible for creating a TimeManager entity with multiple TimeBlock items, created with the
 * passed information
 *
 * @author ad-obas1187
 */
public class SetAvailabilityUseCase implements SetAvailabilityInputBoundary {

    SetAvailabilityOutputBoundary availabilityPresenter;

    public SetAvailabilityUseCase(SetAvailabilityOutputBoundary availabilityPresenter) {
        this.availabilityPresenter = availabilityPresenter;
    }

    /**
     * 1. Take in (String[]) list of availabilities inputted by User
     * 2. Using that, create a CommonTimeBlockManager factory that further creates a CommonTimeBlockManager
     * 3. Create a SetAvailability Presenter
     * 4. Return that presenter
     *
     * @param availabilityInputs an array...
     */
    @Override
    public void create(String[] availabilityInputs, int curriculumId) {

        //Create TimeBlockManager
        Schedule schedule = InMemoryUser.getActiveUser().getSchedule();
        TimeBlockManager timeBlockManager = schedule.getAvailability();
        timeBlockManager.getTimeBlocks().forEach(
                new Consumer<TimeBlock>() {
                    @Override
                    public void accept(TimeBlock timeBlock) {
                        timeBlockManager.addTimeBlock(timeBlock);
                    }
                }

        );

        //Send info as Presenter model through Presenter
        Curriculum curriculum = schedule.getCurriculum(curriculumId);
        SetAvailabilityModel availabilityModel = new SetAvailabilityModel(curriculum.getName());
        availabilityPresenter.availabilitiesSet(availabilityModel);
    }


}
