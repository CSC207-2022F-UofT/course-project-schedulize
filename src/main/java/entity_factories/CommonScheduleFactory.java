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

    /* ********** *\
    *  Attributes  *
    \* ********** */
    private final TimeBlockManagerFactory blockManagerFactory;

    /* ************ *\
    *  Constructors  *
    \* ************ */
    /**
     * Constructs a CommonScheduleFactory
     *
     * @param blockManagerFactory The TimeBlockManager factory this will use to create an empty availabilities list
     */
    public CommonScheduleFactory(TimeBlockManagerFactory blockManagerFactory) {
        this.blockManagerFactory = blockManagerFactory;
    }

    /* ************* *\
    *  Functionality  *
    \* ************* */
    /**
     * Creates an empty CommonSchedule object.
     */
    @Override
    public Schedule create() {
        return new CommonSchedule(new ArrayList<>(), this.blockManagerFactory.createEmpty());
    }
}
