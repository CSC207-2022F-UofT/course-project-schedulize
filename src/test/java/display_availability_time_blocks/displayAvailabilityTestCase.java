package display_availability_time_blocks;

import entity_factories.CommonUserFactory;
import entity_factories.PrebuiltScheduleFactory;
import entity_layer.CommonUser;
import entity_layer.InMemoryUser;
import entity_layer.Schedule;
import entity_layer.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import use_cases.display_availability_timeblocks.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class displayAvailabilityTestCase {
    static DisplayAvailabilityTimeBlockController displayController;
    static DisplayAvailabilityTimeBlockInputBoundary displayInputBoundary;
    static DisplayAvailabilityTimeBlockOutputBoundary displayPresenter;
    static DisplayAvailabilityTimeBlockInteractor displayInteractor;
    static User user;
    static Schedule schedule;

    @BeforeAll
    public static void setup(){
        user = new CommonUserFactory().create("Alex Scott", "scottieAlex@gmail.com", "ozzyozbourne");
        schedule = new PrebuiltScheduleFactory().create();

        user.setSchedule(schedule);
        displayPresenter = new DisplayAvailabilityTimeBlockPresenter(new ArrayList<>());
        displayInputBoundary = new DisplayAvailabilityTimeBlockInteractor(displayPresenter);
        displayController = new DisplayAvailabilityTimeBlockController(displayInteractor);
    }

    @Test
    public void testDisplayUserAvailability(){
        InMemoryUser.setActiveUser(user);
        List<DisplayAvailabilityTimeBlockModel> list = new ArrayList<>();



    }

}
