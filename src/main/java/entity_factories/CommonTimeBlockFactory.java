package entity_factories;

import entity_layer.CommonTimeBlock;
import entity_layer.TimeBlock;

import java.time.LocalDateTime;

/**
 * A factory for creating CommonTimeBlocks, implements the TimeBlockFactory interface.
 * Created: 11/20/2022
 * Last updated: 11/20/2022
 *
 * @author MMachadoUofT
 */
public class CommonTimeBlockFactory implements TimeBlockFactory {

    /**
     * Creates a TimeBlock with the provided start and end times.
     *
     * @param startTime the created TimeBlock's start time and date
     * @param endTime   the created TimeBlock's end time and date
     * @return the created TimeBlock
     */
    @Override
    public TimeBlock create(LocalDateTime startTime, LocalDateTime endTime) {
        return new CommonTimeBlock(startTime, endTime);
    }
}
