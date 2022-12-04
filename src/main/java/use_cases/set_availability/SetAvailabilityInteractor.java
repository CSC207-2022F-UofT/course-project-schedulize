package use_cases.set_availability;
import entity_factories.*;
import entity_layer.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Class responsible for updating the User's TimeBlockManager entity with multiple TimeBlock items,
 * created based on the user's availability inputs
 *
 * @author ad-obas1187
 */
public class SetAvailabilityInteractor implements SetAvailabilityInputBoundary {

    SetAvailabilityOutputBoundary availabilityPresenter;
    TimeBlockFactory timeBlockFactory;

    /**
     * Sets this class's presenter to the one provided in the parameter,
     * sets its TimeBlockFactory to a new CommonTimeBlockFactory
     *
     * @param availabilityPresenter The presenter sent by the controller
     */
    public SetAvailabilityInteractor(SetAvailabilityOutputBoundary availabilityPresenter) {
        this.availabilityPresenter = availabilityPresenter;
        this.timeBlockFactory = new CommonTimeBlockFactory();
    }

    /**
     * 1. Take in (String[]) list of availabilities inputted by User
     * 2. Using that, update TimeBlockManager to have availabilityInputs as LocalDate times
     * 3. Create & return a SetAvailability Presenter
     *
     * @param availabilityInputs Array of availability inputs, sent from controller through its
     *                           create method
     */
    @Override
    public void create(String[] availabilityInputs) {

        //Update TimeBlockManager to have availabilityInputs as LocalDate times
        Schedule schedule = InMemoryUser.getActiveUser().getSchedule();
        TimeBlockManager timeBlockManager = schedule.getAvailability();
        timeBlockManager.clear();

        for (int i = 0; i < availabilityInputs.length; i++) {
//            int len = s.length();
            LocalDate now = LocalDate.now();
            LocalDate dayOf = now.plusDays(i);
            LocalDate startDate = LocalDate.of(dayOf.getYear(), dayOf.getMonth(),
                    dayOf.getDayOfWeek().getValue());
            LocalTime startTime = LocalTime.of(
                    Integer.parseInt(availabilityInputs[i].substring(0, 2)) % 24,
                    0, 0);

            LocalDate endDate = LocalDate.of(dayOf.getYear(), dayOf.getMonth(),
                    dayOf.getDayOfWeek().getValue());
            LocalTime endTime = LocalTime.of(
                    Integer.parseInt(availabilityInputs[i].substring(2, 4)) % 24,
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
