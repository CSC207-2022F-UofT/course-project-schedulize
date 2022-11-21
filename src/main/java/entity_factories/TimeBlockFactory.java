package entity_factories;

import entity_layer.TimeBlock;

import java.time.LocalDateTime;

/**
 * An abstract factory for creating TimeBlocks, implemented by the CommonTimeBlockFactory class
 * Created: 11/20/2022
 * Last updated: 11/20/2022
 *
 * @author MMachadoUofT
 */
public interface TimeBlockFactory {

    /**
     * Creates a TimeBlock with the provided start and end times.
     *
     * @param startTime the created TimeBlock's start time and date
     * @param endTime the created TimeBlock's end time and date
     * @return the created TimeBlock
     */
    TimeBlock create(LocalDateTime startTime, LocalDateTime endTime);
}
