package entity_layer;

import entity_factories.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A test suite for the CommonSchedule class
 * Created: 11/26/2022
 * Last updated: 11/26/2022
 *
 * @author MMachadoUofT
 */
public class CommonScheduleTests {

    private final ScheduleFactory scheduleFactory = new CommonScheduleFactory(new CommonTimeBlockManagerFactory());
    private final CurriculumFactory currFactory = new CommonCurriculumFactory(new CommonTaskTreeFactory(),
                                                                              new CommonTaskFactory(),
                                                                              new CommonTimeBlockManagerFactory());

    @Test
    public void testGetCurriculumByID() {
        Schedule schedule = scheduleFactory.create();
        Curriculum french = currFactory.create("French");
        Curriculum java = currFactory.create("Java");
        Curriculum spanish = currFactory.create("Spanish");
        schedule.addCurriculum(french);
        schedule.addCurriculum(java);
        schedule.addCurriculum(spanish);
        int expectedID = spanish.getID();

        assertEquals(spanish, schedule.getCurriculum(expectedID));
    }

}
