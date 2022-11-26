package entity_factories;

import entity_layer.CommonSchedule;
import entity_layer.Schedule;

import java.util.ArrayList;

/**
 * A concrete factory for creating CommonSchedules
 * Created: 11/26/2022
 * Last updated: 11/226/2022
 *
 * @author MMachadoUofT
 */
public class CommonScheduleFactory implements ScheduleFactory {

    TimeBlockManagerFactory blockManagerFactory;

    public CommonScheduleFactory(TimeBlockManagerFactory blockManagerFactory) {
        this.blockManagerFactory = blockManagerFactory;
    }

    /**
     * Creates an empty CommonSchedule object.
     */
    @Override
    public Schedule create() {
        return new CommonSchedule(new ArrayList<>(), this.blockManagerFactory.createEmpty());
    }
}
