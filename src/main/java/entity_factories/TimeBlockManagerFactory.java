package entity_factories;

import entity_layer.TimeBlock;
import entity_layer.TimeBlockManager;

import java.util.List;

/**
 * An abstract factory for creating TimeBlockManagers.
 * Created: 11/25/2022
 * Last updated: 11/25/2022
 *
 * @author MMachadoUofT
 */
public interface TimeBlockManagerFactory {

    /**
     * Returns a newly created object of type TimeBlockManager with no TimeBlocks
     *
     * @return a TimeBlockManager
     */
    TimeBlockManager createEmpty();

    /**
     * Returns a newly created object of type TimeBlockManager with the given TimeBlocks
     *
     * @param timeBlocks this TimeBlockManager's initial timeblocks
     * @return a TimeBlockManager
     */
    TimeBlockManager createWithTimeBlocks(List<TimeBlock> timeBlocks);
}
