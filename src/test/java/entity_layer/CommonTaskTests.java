package entity_layer;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CommonTaskTests {

    @Test
    public void testCompletionOutOfBounds() {
        Task t1 = new CommonTask("n", "d");
        Task t2 = new CommonTask("n", "d");
        t1.setCompletion(41);
        t1.setCompletion(103);
        assertEquals(41, t1.getCompletion());
        t2.setCompletion(-12);
        assertEquals(0, t2.getCompletion());
    }

    @Test
    public void testIsComplete() {
        Task t1 = new CommonTask("n", "d");
        t1.setCompletion(100);
        assertTrue(t1.isComplete());
        t1.setCompletion(30);
        assertFalse(t1.isComplete());
    }

}
