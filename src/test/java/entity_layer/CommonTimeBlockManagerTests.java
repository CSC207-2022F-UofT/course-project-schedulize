package entity_layer;

import entity_factories.CommonTimeBlockFactory;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
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

    @Test
    public void testRemoveTimeBlockEmpty() {
        TimeBlockManager timeBlockManager = createNew();
        LocalDateTime start = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        TimeBlock t1 = new CommonTimeBlock(start, end);

        List<TimeBlock> expected = timeBlockManager.getTimeBlocks();

        timeBlockManager.removeTimeBlock(t1);

        assertEquals(expected, timeBlockManager.getTimeBlocks());
    }

    @Test
    public void testRemoveTimeBlockEquals() {
        TimeBlockManager timeBlockManager = createNew();
        LocalDateTime start = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        TimeBlock t1 = new CommonTimeBlock(start, end);
        TimeBlock t2 = new CommonTimeBlock(start, end);

        List<TimeBlock> expected = timeBlockManager.getTimeBlocks();

        timeBlockManager.addTimeBlock(t1);
        timeBlockManager.removeTimeBlock(t2);

        assertEquals(expected, timeBlockManager.getTimeBlocks());
    }

    @Test
    public void testRemoveTimeBlockOverlap() {
        TimeBlockManager timeBlockManager = createNew();

        LocalDateTime start = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 13, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 15, 30);
        TimeBlock t1 = new CommonTimeBlock(start, end);
        TimeBlock t2 = new CommonTimeBlock(start1, end1);
        TimeBlock expected = new CommonTimeBlock(start, start1);

        timeBlockManager.addTimeBlock(t1);
        timeBlockManager.removeTimeBlock(t2);

        List<TimeBlock> expectedList = new ArrayList<>();
        expectedList.add(expected);

        assertTrue(expectedList.get(0).equals(timeBlockManager.getTimeBlocks().get(0)));
    }

    @Test
    public void testRemoveTimeBlockContainedInMiddle() {
        TimeBlockManager timeBlockManager = createNew();

        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 15, 11, 30);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 15, 14, 30);
        LocalDateTime start3 = LocalDateTime.of(2022, Month.JULY, 16, 11, 30);
        LocalDateTime end3 = LocalDateTime.of(2022, Month.JULY, 16, 14, 30);
        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);
        TimeBlock t3 = new CommonTimeBlock(start3, end3);

        LocalDateTime start = LocalDateTime.of(2022, Month.JULY, 15, 12, 30);
        LocalDateTime end = LocalDateTime.of(2022, Month.JULY, 15, 13, 30);
        TimeBlock remover = new CommonTimeBlock(start, end);
        TimeBlock first = new CommonTimeBlock(start2, start);
        TimeBlock second = new CommonTimeBlock(end, end2);

        timeBlockManager.addTimeBlock(t1);
        timeBlockManager.addTimeBlock(t2);
        timeBlockManager.addTimeBlock(t3);
        timeBlockManager.removeTimeBlock(remover);

        List<TimeBlock> expectedList = new ArrayList<>();
        expectedList.add(t1);
        expectedList.add(first);
        expectedList.add(second);
        expectedList.add(t3);

        assertEquals(expectedList.size(), timeBlockManager.getTimeBlocks().size());
        assertTrue(expectedList.get(1).equals(timeBlockManager.getTimeBlocks().get(1)));
        assertTrue(expectedList.get(2).equals(timeBlockManager.getTimeBlocks().get(2)));
    }

    @Test
    public void testRemoveTimeBlockContainedAtEnd() {
        TimeBlockManager timeBlockManager = createNew();

        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 15, 11, 30);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 15, 14, 30);
        LocalDateTime start3 = LocalDateTime.of(2022, Month.JULY, 16, 11, 30);
        LocalDateTime end3 = LocalDateTime.of(2022, Month.JULY, 16, 14, 30);
        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);
        TimeBlock t3 = new CommonTimeBlock(start3, end3);

        LocalDateTime start = LocalDateTime.of(2022, Month.JULY, 16, 12, 30);
        LocalDateTime end = LocalDateTime.of(2022, Month.JULY, 16, 13, 30);
        TimeBlock remover = new CommonTimeBlock(start, end);
        TimeBlock first = new CommonTimeBlock(start3, start);
        TimeBlock second = new CommonTimeBlock(end, end3);

        timeBlockManager.addTimeBlock(t1);
        timeBlockManager.addTimeBlock(t2);
        timeBlockManager.addTimeBlock(t3);
        timeBlockManager.removeTimeBlock(remover);

        List<TimeBlock> expectedList = new ArrayList<>();
        expectedList.add(t1);
        expectedList.add(t2);
        expectedList.add(first);
        expectedList.add(second);

        assertEquals(expectedList.size(), timeBlockManager.getTimeBlocks().size());
        assertTrue(expectedList.get(2).equals(timeBlockManager.getTimeBlocks().get(2)));
        assertTrue(expectedList.get(3).equals(timeBlockManager.getTimeBlocks().get(3)));
    }

    @Test
    public void testTimeBlockManagerIterator() {
        TimeBlockManager timeBlockManager = createNew();

        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 15, 11, 30);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 15, 14, 30);
        LocalDateTime start3 = LocalDateTime.of(2022, Month.JULY, 16, 11, 30);
        LocalDateTime end3 = LocalDateTime.of(2022, Month.JULY, 16, 14, 30);
        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);
        TimeBlock t3 = new CommonTimeBlock(start3, end3);

        timeBlockManager.addTimeBlock(t1);
        timeBlockManager.addTimeBlock(t2);
        timeBlockManager.addTimeBlock(t3);

        List<TimeBlock> expectedList = new ArrayList<>();
        expectedList.add(t1);
        expectedList.add(t2);
        expectedList.add(t3);

        List<TimeBlock> actualList = new ArrayList<>();

        for (TimeBlock t : timeBlockManager) {
            actualList.add(t);
        }

        assertEquals(expectedList.get(0), actualList.get(0));
        assertEquals(expectedList.get(1), actualList.get(1));
        assertEquals(expectedList.get(2), actualList.get(2));

    }
}
