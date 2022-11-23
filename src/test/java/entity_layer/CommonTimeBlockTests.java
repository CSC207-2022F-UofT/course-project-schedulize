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
    public void testOverlapsWithApart() {

    }

    @Test
    public void testOverlapsWithAdjacent() {

    }

    @Test
    public void testOverlapsWithThisStartsBefore() {

    }

    @Test
    public void testOverlapsWithThisEndsAfter() {

    }

    // TimeBlock.isContainedWithin()
    @Test
    public void testContainedTrue() {

    }

    @Test
    public void testContainedThisContainsThat() {

    }

    @Test
    public void testContainedThisStartTimeEquals() {

    }

    @Test
    public void testContainedThisEndTimeEquals() {

    }

    // TimeBlock.contains()
    @Test
    public void testContainsTrue() {

    }

    @Test
    public void testContainsThatContainsThis() {

    }

    // TimeBlock.isAdjacentTo()
    @Test
    public void testAdjacentThisBefore() {

    }

    @Test
    public void testAdjacentThisAfter() {

    }

    @Test
    public void testAdjacentApart() {

    }

    @Test
    public void testAdjacentOverlapping() {

    }

    // TimeBlock.getDuration()
    @Test
    public void testDuration() {

    }
}
