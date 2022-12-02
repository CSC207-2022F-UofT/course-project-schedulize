package use_cases.set_availability;
import entity_factories.*;
import entity_layer.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Class responsible for creating a TimeManager entity with multiple TimeBlock items, created with the
 * passed information
 *
 * @author ad-obas1187
 */
public class SetAvailabilityUseCase implements SetAvailabilityInputBoundary {

    SetAvailabilityOutputBoundary availabilityPresenter;
    TimeBlockFactory timeBlockFactory;

    public SetAvailabilityUseCase(SetAvailabilityOutputBoundary availabilityPresenter) {
        this.availabilityPresenter = availabilityPresenter;
        this.timeBlockFactory = new CommonTimeBlockFactory();
    }

    /**
     * 1. Take in (String[]) list of availabilities inputted by User
     * 2. Using that, update TimeBlockManager to have availabilityInputs as LocalDate times
     * 3. Create & return a SetAvailability Presenter
     *
     * @param availabilityInputs an array...
     */
    @Override
    public void create(String[] availabilityInputs) {

        //Update TimeBlockManager to have availabilityInputs as LocalDate times
        Schedule schedule = InMemoryUser.getActiveUser().getSchedule();
        TimeBlockManager timeBlockManager = schedule.getAvailability();

        for (String s : availabilityInputs) {
//            int len = s.length();

            LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
                    LocalDate.now().getDayOfWeek().getValue());
            LocalTime startTime = LocalTime.of(
                    Integer.parseInt(s.substring(0, 1)) % 24,
                    0, 0);

            LocalDate endDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
                    LocalDate.now().getDayOfWeek().getValue());
            LocalTime endTime = LocalTime.of(
                    Integer.parseInt(s.substring(2, 3)) % 24,
                    0, 0);

            LocalDateTime start = LocalDateTime.of(startDate, startTime);
            LocalDateTime end = LocalDateTime.of(endDate, endTime);

//            LocalDateTime start = LocalDateTime.parse(s.substring(0, len/2));
//            LocalDateTime end = LocalDateTime.parse(s.substring(len/2, len));

            TimeBlock timeBlock = timeBlockFactory.create(start, end);
            timeBlockManager.addTimeBlock(timeBlock);
        }

        //Send info as Presenter model through Presenter
        availabilityPresenter.availabilitiesSet("Availability has been set.");
    }


}
