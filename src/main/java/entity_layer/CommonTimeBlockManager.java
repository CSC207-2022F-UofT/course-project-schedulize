package entity_layer;

import entity_factories.TimeBlockFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * A CommonTimeBlockManager class, implements the TimeBlockManager interface.
 * Created: 10/31/2022
 * Last updated: 11/5/2022
 *
 * @author MMachadoUofT
 */
public class CommonTimeBlockManager implements TimeBlockManager {

    /* ********** *\
    *  Attributes  *
    \* ********** */
    private List<TimeBlock> timeBlockList = new ArrayList<>();
    private TimeBlockFactory timeBlockFactory;

    /* ************ *\
    *  Constructors  *
    \* ************ */
    public CommonTimeBlockManager(List<TimeBlock> timeBlocks, TimeBlockFactory timeBlockFactory) {
        this.timeBlockFactory = timeBlockFactory;
        for (TimeBlock t : timeBlocks) {
            this.addTimeBlock(t);
        }
    }

    /* ************* *\
    *  Functionality  *
    \* ************* */
    // Public
    /**
     * Returns a shallow copy of all the TimeBlocks held by this CommonTimeBlockManager.
     *
     * @return a list of TimeBlocks
     */
    @Override
    public List<TimeBlock> getTimeBlocks() {
        return new ArrayList<>(this.timeBlockList);
    }

    /**
     * Adds the given TimeBlock to this CommonTimeBlockManager. If this TimeBlock is adjacent to or overlaps with an
     * existing TimeBlock, the existing one is mutated to contain the time that this TimeBlock has added
     *
     * @param timeBlock the TimeBlock to be added
     */
    @Override
    public void addTimeBlock(TimeBlock timeBlock) {

    }

    /**
     * Removes the provided TimeBlock from this CommonTimeBlockManager.
     * If this TimeBlock equals one already present in the manager, the original is simply deleted.
     * If this TimeBlock instead only overlaps with a part of an existing TimeBlock, the original is mutated to exclude
     * the TimeBlock provided.
     * Any time included by the provided TimeBlock, be it partial or entire, that is not already in this
     * CommonTimeBlockManager will have no effect (i.e. if we request 5PM - 7PM on a certain day to be removed when
     * this block was never here to begin with, nothing occurs.)
     *
     * @param timeBlock the TimeBlock to be removed
     */
    @Override
    public void removeTimeBlock(TimeBlock timeBlock) {

    }
}
