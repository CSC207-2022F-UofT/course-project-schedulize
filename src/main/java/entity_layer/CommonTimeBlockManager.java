package entity_layer;

import entity_factories.TimeBlockFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

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
    private final List<TimeBlock> timeBlockList = new ArrayList<>();
    private final TimeBlockFactory timeBlockFactory;

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
        for (TimeBlock t : this.timeBlockList) {
            if (extendTimeBlock(t, timeBlock))
                return;
        }
        this.timeBlockList.add(timeBlock);
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
        for (TimeBlock t : this.timeBlockList) {
            if (timeBlock.equals(t) || timeBlock.contains(t)) {
                this.timeBlockList.remove(t);
                return;
            }
            TimeBlock reducedBlock = reduceTimeBlock(t, timeBlock);
            if (reducedBlock != null) {
                if (reducedBlock != timeBlock) {
                    addTimeBlockAfter(t, reducedBlock);
                }
            }
        }
    }

    /**
     * Clears all TimeBlocks from this TimeBlockManager.
     */
    @Override
    public void clear() {
        this.timeBlockList.clear();
    }

    // Private
    /**
     * Extend the first TimeBlock by the second TimeBlock's start and end times.
     *
     * @param block1 the TimeBlock to be extended
     * @param block2 the TimeBlock that block1 will be extended until
     * @return true if there was no gap between block1 and block2, false otherwise
     */
    private static boolean extendTimeBlock(TimeBlock block1, TimeBlock block2) {
        if (block1.contains(block2))
            return true;
        if (block1.isContainedWithin(block2)) {
            block1.setStartTime(block2.getStartTime());
            block1.setEndTime(block2.getEndTime());
            return true;
        }
        if (block1.isAdjacentBefore(block2) || block1.overlapsBefore(block2)) {
            block1.setEndTime(block2.getEndTime());
            return true;
        }
        if (block1.isAdjacentAfter(block2) || block1.overlapsAfter(block2)) {
            block1.setStartTime(block2.getStartTime());
            return true;
        }
        return false;
    }

    /**
     * Reduce the first TimeBlock by the second TimeBlock's start and end times.
     *
     * @param block1 the TimeBlock to be reduced
     * @param block2 the TimeBlock that block1 will be reduced by
     * @return Any necessary leftover timeBlock
     */
    private TimeBlock reduceTimeBlock(TimeBlock block1, TimeBlock block2) {
        if (block1.contains(block2)) {
            TimeBlock leftover = timeBlockFactory.create(block2.getEndTime(), block1.getEndTime());
            block1.setEndTime(block2.getStartTime());
            return leftover;
        }
        if (block1.overlapsAfter(block2)) {
            block1.setStartTime(block2.getEndTime());
            return block2;
        }
        if (block1.overlapsBefore(block2)) {
            block1.setEndTime(block2.getStartTime());
            return block2;
        }
        return null;
    }

    /**
     * Add the given TimeBlock to this.timeBlockList AFTER the TimeBlock passed
     * @param timeBlockBefore the TimeBlock that we want to place a block after
     * @param timeBlockAfter the TimeBlock that we want to place after timeBlockBefore
     */
    private void addTimeBlockAfter(TimeBlock timeBlockBefore, TimeBlock timeBlockAfter) {
        int indexToPlaceAt = this.timeBlockList.indexOf(timeBlockBefore) + 1;
        if (indexToPlaceAt == this.timeBlockList.size()) {
            this.timeBlockList.add(timeBlockAfter);
        } else {
            this.timeBlockList.add(indexToPlaceAt, timeBlockAfter);
        }
    }

    /* ********* *\
    *  Iteration  *
    \* ********* */
    /**
     * Returns an iterator for this TimeBlockManager.
     *
     * @return an iterator for this TimeBlockManager
     */
    @Override
    public Iterator<TimeBlock> iterator() {
        return new TimeBlockManagerIterator();
    }

    private class TimeBlockManagerIterator implements Iterator<TimeBlock> {
        private int currentTimeBlockIndex = 0;

        public boolean hasNext() {
            return currentTimeBlockIndex < timeBlockList.size();
        }

        public TimeBlock next() {
            TimeBlock currentTimeBlock;

            try {
                currentTimeBlock = timeBlockList.get(currentTimeBlockIndex);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
            currentTimeBlockIndex += 1;
            return currentTimeBlock;
        }
    }
}
