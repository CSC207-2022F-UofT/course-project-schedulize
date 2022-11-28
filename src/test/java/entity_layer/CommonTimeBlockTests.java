package entity_layer;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CommonTimeBlockTests {

    // TimeBlock.equals()
    @Test
    public void testEqualsNullComparison() {
        LocalDateTime start = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);

        TimeBlock t1 = new CommonTimeBlock(start, end);
        TimeBlock t2 = null;

        assertFalse(t1.equals(t2));
    }

    @Test
    public void testEqualsReflexive() {
        LocalDateTime start = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);

        TimeBlock t1 = new CommonTimeBlock(start, end);
        TimeBlock t2 = t1;

        assertTrue(t1.equals(t2));
    }

    @Test
    public void testEqualsSeparateObjectsTrue() {
        LocalDateTime start = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);

        TimeBlock t1 = new CommonTimeBlock(start, end);
        TimeBlock t2 = new CommonTimeBlock(start, end);

        assertTrue(t1.equals(t2));
    }

    @Test
    public void testEqualsSeparateObjectsFalse() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 15, 11, 30);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 15, 11, 30);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertFalse(t1.equals(t2));
    }

    @Test
    public void testEqualsWhenAdjacentIsFalse() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 15, 30);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertFalse(t1.equals(t2));
    }

    // TimeBlock.overlapsWith()
    @Test
    public void testOverlapsWithApartFalse() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 15, 11, 30);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 15, 11, 30);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertFalse(t1.overlapsWith(t2));
    }

    @Test
    public void testOverlapsWithAdjacent() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 15, 30);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertFalse(t1.overlapsWith(t2));
    }

    @Test
    public void testOverlapsWithThisStartsBefore() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 12, 30);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 15, 30);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertTrue(t1.overlapsWith(t2));
    }

    @Test
    public void testOverlapsWithThisEndsAfter() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 12, 30);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 15, 30);

        TimeBlock t2 = new CommonTimeBlock(start1, end1);
        TimeBlock t1 = new CommonTimeBlock(start2, end2);

        assertTrue(t1.overlapsWith(t2));
    }

    // TimeBlock.isContainedWithin()
    @Test
    public void testContainedTrue() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 15, 0);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 16, 0);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 12, 0);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 18, 0);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertTrue(t1.isContainedWithin(t2));
    }

    @Test
    public void testContainedThisContainsThat() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 15, 0);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 16, 0);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 12, 0);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 18, 0);

        TimeBlock t2 = new CommonTimeBlock(start1, end1);
        TimeBlock t1 = new CommonTimeBlock(start2, end2);

        assertFalse(t1.isContainedWithin(t2));
    }

    @Test
    public void testContainedThisStartTimeEquals() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 12, 0);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 16, 0);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 12, 0);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 18, 0);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertTrue(t1.isContainedWithin(t2));
    }

    @Test
    public void testContainedThisEndTimeEquals() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 15, 0);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 17, 0);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 14, 0);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 17, 0);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertTrue(t1.isContainedWithin(t2));
    }

    // TimeBlock.contains()
    @Test
    public void testContainsTrue() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 15, 0);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 16, 0);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 12, 0);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 18, 0);

        TimeBlock t2 = new CommonTimeBlock(start1, end1);
        TimeBlock t1 = new CommonTimeBlock(start2, end2);

        assertTrue(t1.contains(t2));
    }

    @Test
    public void testContainsThatContainsThis() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 15, 0);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 16, 0);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 12, 0);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 18, 0);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertFalse(t1.contains(t2));
    }

    // TimeBlock.isAdjacentTo()
    @Test
    public void testAdjacentThisBefore() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 15, 0);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 16, 0);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 16, 0);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 18, 0);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertTrue(t1.isAdjacentTo(t2));
    }

    @Test
    public void testAdjacentThisAfter() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 15, 0);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 16, 0);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 16, 0);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 18, 0);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertTrue(t2.isAdjacentTo(t1));
    }

    @Test
    public void testAdjacentApart() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 15, 0);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 16, 0);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 17, 0);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 18, 0);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertFalse(t1.isAdjacentTo(t2));
    }

    @Test
    public void testAdjacentOverlapping() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 14, 30);
        LocalDateTime start2 = LocalDateTime.of(2022, Month.JULY, 14, 12, 30);
        LocalDateTime end2 = LocalDateTime.of(2022, Month.JULY, 14, 15, 30);

        TimeBlock t1 = new CommonTimeBlock(start1, end1);
        TimeBlock t2 = new CommonTimeBlock(start2, end2);

        assertFalse(t1.isAdjacentTo(t2));
    }

    // TimeBlock.getDuration()
    @Test
    public void testDuration30Min() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 12, 0);

        TimeBlock t = new CommonTimeBlock(start1, end1);

        assertEquals(30, t.getDuration());
    }

    @Test
    public void testDurationOneHour() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 30);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 12, 30);

        TimeBlock t = new CommonTimeBlock(start1, end1);

        assertEquals(60, t.getDuration());
    }

    @Test
    public void testDurationThreeHours() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 0);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 14, 14, 0);

        TimeBlock t = new CommonTimeBlock(start1, end1);

        assertEquals(180, t.getDuration());
    }

    @Test
    public void testDurationFullDay() {
        LocalDateTime start1 = LocalDateTime.of(2022, Month.JULY, 14, 11, 0);
        LocalDateTime end1 = LocalDateTime.of(2022, Month.JULY, 15, 11, 0);

        TimeBlock t = new CommonTimeBlock(start1, end1);

        assertEquals(1440, t.getDuration());
    }
}
