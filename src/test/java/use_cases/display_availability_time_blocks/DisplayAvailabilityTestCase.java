package use_cases.display_availability_time_blocks;

import entity_factories.CommonTimeBlockFactory;
import entity_factories.CommonUserFactory;
import entity_factories.PrebuiltScheduleFactory;
import entity_layer.InMemoryUser;
import entity_layer.Schedule;
import entity_layer.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import use_cases.display_availability_timeblocks.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * Class for testing the display availability use case
 * Created: 12/03/2022
 * Last updated: 12/03/2022
 *
 * @author amira, David Adler
 */
public class DisplayAvailabilityTestCase {
    static DisplayAvailabilityTimeBlockController displayController;
    static DisplayAvailabilityTimeBlockInputBoundary displayInputBoundary;
    static DisplayAvailabilityTimeBlockOutputBoundary displayPresenter;
    static User user;
    static Schedule schedule;

    /**
     * Sets up necessary entities
     */
    @BeforeAll
    public static void setup(){
        user = new CommonUserFactory().create("Alex Scott", "scottieAlex@gmail.com", "ozzyozbourne");
        schedule = new PrebuiltScheduleFactory().create();

        user.setSchedule(schedule);
        displayPresenter = new DisplayAvailabilityTimeBlockPresenter(new ArrayList<>());
        displayInputBoundary = new DisplayAvailabilityTimeBlockInteractor(displayPresenter);
        displayController = new DisplayAvailabilityTimeBlockController(displayInputBoundary);
    }

    /**
     * A test view to act as an observer for the output that the presenter returns
     */
    static class TestView implements AvailabilityUiInterface {

        List<DisplayAvailabilityTimeBlockModel> models = new ArrayList<>();

        @Override
        public void drawAvailabilities(List<DisplayAvailabilityTimeBlockModel> availability) {
            models = availability;
        }

        /**
         * @return array of start times from the model
         */
        public String[] getStartTimes() {
            String[] startTimes = new String[models.size()];
            for (int i = 0; i < models.size(); i++) {
                startTimes[i] = models.get(i).getStartTime().substring(0, 2);
            }
            return startTimes;
        }

        /**
         * @return array of end times from the model
         */
        public String[] getEndTimes() {
            String[] endTimes = new String[models.size()];
            for (int i = 0; i < models.size(); i++) {
                endTimes[i] = models.get(i).getEndTime().substring(0, 2);
            }
            return endTimes;
        }
    }

    /**
     * Tests that the return output from the presenter is the expected return output, based on an inputted test time
     */
    @Test
    public void testDisplayUserAvailability(){
        InMemoryUser.setActiveUser(user);

        // create the test view
        TestView view = new TestView();
        displayPresenter.addAvailabilityObserver(view);

        // add the 'now' time block to the user's availability
        CommonTimeBlockFactory factory = new CommonTimeBlockFactory();

        LocalDateTime testTime = LocalDateTime.of(2022, 10, 1, 10, 0);
        user.getSchedule().addAvailabilityBlock(factory.create(testTime, testTime));
        displayController.displayAvailabilityTimeBlock();

        // compare expected and actual start time
        for (String startBlock: view.getStartTimes()) {
            assert startBlock.equals(((Integer) (testTime.getHour())).toString());
        }

        // compare expected and actual end time
        for (String startBlock: view.getEndTimes()) {
            assert startBlock.equals(((Integer) (testTime.getHour())).toString());
        }
    }

}
