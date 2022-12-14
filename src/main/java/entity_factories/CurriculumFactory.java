package entity_factories;

import entity_layer.Curriculum;

import java.io.Serializable;

/**
 * An abstract factory for creating Curriculum objects
 * Created: 11/25/2022
 * Last updated: 11/25/2022
 *
 * @author MMachadoUofT
 */
public interface CurriculumFactory extends Serializable {

    /**
     * Returns a new Curriculum object assigned the given name
     *
     * @param name this Curriculum's name
     * @return the newly created Curriculum object
     */
    Curriculum create(String name);
}
