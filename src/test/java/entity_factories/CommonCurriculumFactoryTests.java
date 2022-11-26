package entity_factories;

import entity_layer.Curriculum;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A testing module to test the CommonCurriculumFactory
 * Created: 11/25/2022
 * Last updated: 11/26/2022
 *
 * @author MMachadoUofT
 */
public class CommonCurriculumFactoryTests {

    @Test
    public void testCreateCurriculumFactory() {
        TaskTreeFactory treeFact = new CommonTaskTreeFactory();
        TaskFactory taskFact = new CommonTaskFactory();
        TimeBlockManagerFactory mngrFact = new CommonTimeBlockManagerFactory();

        CurriculumFactory curriculumFactory = new CommonCurriculumFactory(treeFact, taskFact, mngrFact);
        Curriculum curriculum = curriculumFactory.create("Test");

        assertEquals("Test", curriculum.getName());
        assertEquals("Test", curriculum.getGoal().getTask().getName());
        assertEquals("The Test curriculum", curriculum.getGoal().getTask().getDescription());
        assertTrue(curriculum.getThisWeekSchedule().isEmpty());
        assertTrue(curriculum.getFullSchedule().isEmpty());
    }
}
