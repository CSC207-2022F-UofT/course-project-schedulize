package entity_layer;

import entity_factories.*;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class CommonCurriculumTests {

    private final CurriculumFactory factory = new CommonCurriculumFactory(new CommonTaskTreeFactory(), new CommonTaskFactory(),
            new CommonTimeBlockManagerFactory());

    @Test
    public void testAddWorkTime() {
        Curriculum curriculum = factory.create("Test");
        LocalDateTime start = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        TimeBlock t1 = new CommonTimeBlock(start, end);
        curriculum.addWorkTime(t1);

        for (TimeBlock t : curriculum.getFullSchedule()) {
            assertEquals(t, t1);
        }
    }

    @Test
    public void testReduceToWeek() {
        Curriculum curriculum = factory.create("Test");
        LocalDateTime start1 = LocalDateTime.now();
        LocalDateTime end1 = LocalDateTime.now().plusHours(3);
        LocalDateTime start2 = LocalDateTime.now().plusDays(1);
        LocalDateTime end2 = LocalDateTime.now().plusDays(1).plusHours(3);
        LocalDateTime start3 = LocalDateTime.now().plusDays(2);
        LocalDateTime end3 = LocalDateTime.now().plusDays(2).plusHours(3);
        LocalDateTime start4 = LocalDateTime.now().plusDays(3);
        LocalDateTime end4 = LocalDateTime.now().plusDays(3).plusHours(3);
        LocalDateTime start5 = LocalDateTime.now().plusDays(4);
        LocalDateTime end5 = LocalDateTime.now().plusDays(4).plusHours(3);
        LocalDateTime start6 = LocalDateTime.now().plusDays(5);
        LocalDateTime end6 = LocalDateTime.now().plusDays(5).plusHours(3);
        LocalDateTime start7 = LocalDateTime.now().plusDays(6);
        LocalDateTime end7 = LocalDateTime.now().plusDays(6).plusHours(3);
        LocalDateTime start8 = LocalDateTime.now().plusDays(7);
        LocalDateTime end8 = LocalDateTime.now().plusDays(7).plusHours(3);
        LocalDateTime start9 = LocalDateTime.now().plusDays(8);
        LocalDateTime end9 = LocalDateTime.now().plusDays(8).plusHours(3);
        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);
        TimeBlock t3 = new CommonTimeBlock(start3, end3);
        TimeBlock t4 = new CommonTimeBlock(start4, end4);
        TimeBlock t5 = new CommonTimeBlock(start5, end5);
        TimeBlock t6 = new CommonTimeBlock(start6, end6);
        TimeBlock t7 = new CommonTimeBlock(start7, end7);
        TimeBlock t8 = new CommonTimeBlock(start8, end8);
        TimeBlock t9 = new CommonTimeBlock(start9, end9);
        curriculum.addWorkTime(t1);
        curriculum.addWorkTime(t2);
        curriculum.addWorkTime(t3);
        curriculum.addWorkTime(t4);
        curriculum.addWorkTime(t5);
        curriculum.addWorkTime(t6);
        curriculum.addWorkTime(t7);
        curriculum.addWorkTime(t8);
        curriculum.addWorkTime(t9);
        TimeBlockManager manager = curriculum.getThisWeekSchedule();
        for (TimeBlock t : manager) {
            assertFalse(t.equals(t9));
        }

    }
}
