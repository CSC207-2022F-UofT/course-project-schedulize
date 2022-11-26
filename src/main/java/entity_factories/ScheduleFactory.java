package entity_factories;

import entity_layer.Schedule;

/**
 * An abstract factory for creating objects of type Schedule
 * Created: 11/26/2022
 * Last updated: 11/26/2022
 *
 * @author MMachadoUofT
 */
public interface ScheduleFactory {

    /**
     * Creates an empty Schedule object.
     */
    Schedule create();

}
