package entity_layer;

import entity_factories.CommonTimeBlockFactory;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommonTimeBlockManagerTests {

    private TimeBlockManager createNew() {
        return new CommonTimeBlockManager(new ArrayList<>(), new CommonTimeBlockFactory());
    }
    @Test
    public void testAddTimeBlockToEmpty() {
        TimeBlockManager timeBlockManager = createNew();
        LocalDateTime start = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        TimeBlock t1 = new CommonTimeBlock(start, end);

        timeBlockManager.addTimeBlock(t1);

        List<TimeBlock> testList = new ArrayList<>();
        testList.add(t1);

        assertEquals(testList, timeBlockManager.getTimeBlocks());
    }

    @Test
    public void testAddTimeBlockWithGap() {
        TimeBlockManager timeBlockManager = createNew();

        LocalDateTime start = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 15, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 15, 14, 30);
        TimeBlock t1 = new CommonTimeBlock(start, end);
        TimeBlock t2 = new CommonTimeBlock(start1, end1);
        timeBlockManager.addTimeBlock(t1);
        timeBlockManager.addTimeBlock(t2);

        List<TimeBlock> testList = new ArrayList<>();
        testList.add(t1);
        testList.add(t2);

        assertEquals(testList, timeBlockManager.getTimeBlocks());
    }

    @Test
    public void testAddTimeBlockOverlap() {
        TimeBlockManager timeBlockManager = createNew();

        LocalDateTime start = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 13, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 15, 30);
        TimeBlock t1 = new CommonTimeBlock(start, end);
        TimeBlock t2 = new CommonTimeBlock(start1, end1);
        TimeBlock expected = new CommonTimeBlock(start, end1);
        timeBlockManager.addTimeBlock(t1);
        timeBlockManager.addTimeBlock(t2);

        List<TimeBlock> testList = new ArrayList<>();
        testList.add(expected);

        assertTrue(testList.get(0).equals(timeBlockManager.getTimeBlocks().get(0)));
    }
}
