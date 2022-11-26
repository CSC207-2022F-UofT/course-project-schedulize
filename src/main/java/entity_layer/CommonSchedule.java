package entity_layer;

import java.util.List;

/**
 * A CommonSchedule class, implements the Schedule interface.
 * Created: 10/31/2022
 * Last updated: 11/26/2022
 *
 * @author MMachadoUofT
 */
public class CommonSchedule implements Schedule {

    /* ********** *\
    *  Attributes  *
    \* ********** */
    List<Curriculum> curriculums;
    TimeBlockManager availability;

    /* ************ *\
    *  Constructors  *
    \* ************ */
    public CommonSchedule(List<Curriculum> curriculums, TimeBlockManager availability) {
        this.curriculums = curriculums;
        this.availability = availability;
    }

    /**
     * Adds the passed TimeBlock to the availability.
     * If the given TimeBlock is contained within an existing availability entirely, nothing occurs.
     * If the given TimeBlock is partially contained within - or is perfectly adjacent to - an existing
     * availability, the existing availability is extended to encapsulate the time provided by this block.
     *
     * @param availableBlock the TimeBlock to-be-added.
     */
    @Override
    public void addAvailabilityBlock(TimeBlock availableBlock) {
        this.availability.addTimeBlock(availableBlock);
    }

    /**
     * Removes the given TimeBlock from this CommonSchedule's available TimeBlocks.
     * If the given TimeBlock does not overlap with any existing available TimeBlocks, nothing occurs.
     * If the given TimeBlock overlaps with existing available TimeBlocks, the TimeBlocks in question are shortened to
     * exclude the time held by this TimeBlock.
     * If the given TimeBlock is entirely contained by an available TimeBlock, the TimeBlock in question is split into
     * two TimeBlocks, neither of which overlap with the TimeBlock passed as unavailable.
     *
     * @param unavailableBlock the newly unavailable block of time.
     */
    @Override
    public void removeAvailabilityBlock(TimeBlock unavailableBlock) {
        this.availability.removeTimeBlock(unavailableBlock);
    }

    /**
     * Returns the Curriculum holding the given Curriculum ID.
     *
     * @param curriculumID the ID belonging to the desired Curriculum object
     * @return the Curriculum object with the appropriate ID, null otherwise.
     */
    @Override
    public Curriculum getCurriculum(int curriculumID) {
        for (Curriculum curriculum : this.curriculums) {
            if (curriculum.getID() == curriculumID)
                return curriculum;
        }
        return null;
    }

    /**
     * Returns the TimeBlockManager object representing this Schedule's available times.
     *
     * @return this Schedule's available blocks, held by a TimeBlockManager object.
     */
    @Override
    public TimeBlockManager getAvailability() {
        return this.availability;
    }
}
