package use_cases.set_availability;

import entity_factories.*;
import entity_layer.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class made to test everything related to the set_availability use case package:
 * 1. See if correct availabilities were set from Controller's create method for non-empty
 * 2. See if expected message is returned from Presenter's availabilitiesSet method
 *
 * @author od-obas1187
 */
public class SetAvailabilityTests {

    static SetAvailabilityController controller;
    static SetAvailabilityInputBoundary interactor;
    static SetAvailabilityOutputBoundary presenter;
    static SetAvailabilityTestingViewInterface testingViewInterface;
    static TimeBlockFactory timeBlockFactory;
    static User activeUser;
    static Schedule schedule;
    static Curriculum curriculum;
    static HashMap<Integer, Integer> timeBlockTimes = new HashMap<>();

    /**
     * Setting up the user's schedule with a curriculum called "CSC207", and creating instances of the
     * SetAvailability presenter, interactor and controller, in order to test as needed.
     */
    @BeforeAll
    public static void setUp() {
        testingViewInterface = new SetAvailabilityTestingViewInterface();
        List<SetAvailabilityViewInterface> testingViewInterfaceList = new ArrayList<>();
        testingViewInterfaceList.add(testingViewInterface);
        presenter = new SetAvailabilityPresenter(testingViewInterfaceList);
        interactor = new SetAvailabilityUseCase(presenter);
        controller = new SetAvailabilityController(interactor);

        timeBlockFactory = new CommonTimeBlockFactory();

        curriculum = new PrebuiltCurriculumFactory().create("CSC207");
        schedule = new PrebuiltScheduleFactory().create();
        activeUser = new CommonUserFactory().create("username", "email@email.com", "password");
    }

    /**
     * Testing that controller's created TimeBlocks are the same as expected, updated to User's TimeBlockManager
     * properly (checking for equality of TimeBlocks & size of TimeBlockManager's TimeBlock list)
     */
    @Test
    public void testControllerTimeBlockCreation() {
        //1. Set inMemoryUser, give it the availabilities, curriculum (for ID), schedule
        InMemoryUser.setActiveUser(activeUser);
        activeUser.setSchedule(schedule);
        schedule.addCurriculum(curriculum);

        //Also tests overlapping TimeBlocks
        String[] availabilities = new String[]{"1213", "0102", "0406", "1519", "2022"};
        controller.create(availabilities);

        //2. Create TimeBlockManager (using factory) to compare to inMemoryUser's availabilities
        Schedule schedule = InMemoryUser.getActiveUser().getSchedule();
        TimeBlockManager timeBlockManager = schedule.getAvailability();

        assertTrue(availabilities.length <= timeBlockManager.getTimeBlocks().size());

        for (TimeBlock t: timeBlockManager) {
            timeBlockTimes.put(t.getStartTime().getHour(), t.getEndTime().getHour());
        }

        for (String s : availabilities) {
            LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
                    LocalDate.now().getDayOfWeek().getValue());
            LocalTime startTime = LocalTime.of(
                    Integer.parseInt(s.substring(0, 2)) % 24,
                    0, 0);

            LocalDate endDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
                    LocalDate.now().getDayOfWeek().getValue());
            LocalTime endTime = LocalTime.of(
                    Integer.parseInt(s.substring(2, 4)) % 24,
                    0, 0);

            LocalDateTime start = LocalDateTime.of(startDate, startTime);
            LocalDateTime end = LocalDateTime.of(endDate, endTime);

            TimeBlock timeBlock = timeBlockFactory.create(start, end);

            assertEquals(timeBlockTimes.get(timeBlock.getStartTime().getHour()),
                    (timeBlock.getEndTime().getHour()));
        }

    }

    /**
     * Testing that expected message is returned from Presenter's availabilitiesSet method
     */
    @Test
    public void testPresenterAvailabilitiesSetMessage() {
        //1. Set inMemoryUser, give it the availabilities, curriculum (for ID), schedule
        InMemoryUser.setActiveUser(activeUser);
        activeUser.setSchedule(schedule);
        schedule.addCurriculum(curriculum);

        String[] availabilities = new String[]{"1213", "0102", "0406", "1519", "2022"};
        controller.create(availabilities);

        //2. See if expectedPresenter & actualPresenter messages are the same
        String expectedPresenter = "Availability has been set.";
        String actualPresenter = testingViewInterface.getReturnMessage();

        System.out.println(actualPresenter);

        assertEquals(expectedPresenter, actualPresenter);

    }
}
