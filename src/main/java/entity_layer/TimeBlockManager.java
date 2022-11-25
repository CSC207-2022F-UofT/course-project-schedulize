package entity_layer;

import java.util.List;

/**
 * A TimeBlockManager interface, implemented by the CommonTimeBlockManager class. Used as a level of abstraction.
 * Created: 10/31/2022
 * Last updated: 11/5/2022
 *
 * @author MMachadoUofT
 */
public interface TimeBlockManager {

    /**
     * Returns a shallow copy of all the TimeBlocks held by this TimeBlockManager.
     *
     * @return a list of TimeBlocks
     */
    List<TimeBlock> getTimeBlocks();

    /**
     * Adds the given TimeBlock to this TimeBlockManager. If this TimeBlock is adjacent to or overlaps with an existing
     * TimeBlock, the existing one is mutated to contain the time that this TimeBlock has added
     *
     * @param timeBlock the TimeBlock to be added
     */
    void addTimeBlock(TimeBlock timeBlock);

    /**
     * Removes the provided TimeBlock from this TimeBlockManager. If this TimeBlock equals one already present in the
     * manager, the original is simply deleted. If this TimeBlock instead only overlaps with a part of an existing
     * TimeBlock, the original is mutated to exclude the TimeBlock provided. Any time included by this TimeBlock, be it
     * partial or entire, that is not already in this TimeBlockManager will have no effect (i.e. if we request 5PM - 7PM
     * on a certain day to be removed when this block was never here to begin with, nothing occurs.)
     *
     * @param timeBlock the TimeBlock to be removed
     */
    void removeTimeBlock(TimeBlock timeBlock);

    /**
     * Clears all TimeBlocks from this TimeBlockManager.
     */
    void clear();

}
