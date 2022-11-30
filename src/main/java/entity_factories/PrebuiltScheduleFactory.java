package entity_factories;

import entity_layer.CommonSchedule;
import entity_layer.Schedule;

import java.util.ArrayList;

/**
 * A concrete Factory for Schedules, coupled with CommonTimeBlockManagerFactory
 * Created: 11/28/2022
 * Last updated: 11/28/2022
 *
 * @author MMachadoUofT
 */
public class PrebuiltScheduleFactory implements ScheduleFactory {

    private final TimeBlockManagerFactory blockManagerFactory = new CommonTimeBlockManagerFactory();

    /**
     * Creates an empty Schedule object.
     */
    @Override
    public Schedule create() {
        return new CommonSchedule(new ArrayList<>(), this.blockManagerFactory.createEmpty());
    }
}
