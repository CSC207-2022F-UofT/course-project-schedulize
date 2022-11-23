package entity_layer;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CommonTimeBlockTests {

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

    }

    @Test
    public void testEqualsSeparateObjectsTrue() {

    }

    @Test
    public void testEqualsSeparateObjectsFalse() {

    }
}
