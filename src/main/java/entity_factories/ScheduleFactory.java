package entity_factories;

import entity_layer.Schedule;

import java.io.Serializable;

/**
 * An abstract factory for creating objects of type Schedule
 * Created: 11/26/2022
 * Last updated: 11/26/2022
 *
 * @author MMachadoUofT
 */
public interface ScheduleFactory extends Serializable {

    /**
     * Creates an empty Schedule object.
     */
    Schedule create();

}
