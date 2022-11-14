package entityLayer;

/**
 * An interface for dealing with the CommonSchedule class, used as way to abstract our source files.
 * Created: 10/31/2022
 * Last updated: 11/4/2022
 *
 * @author MMachadoUofT
 */
public interface Schedule {

    /**
     * Adds the passed TimeBlock to the availability.
     * If the given TimeBlock is contained within an existing availability entirely, nothing occurs.
     * If the given TimeBlock is partially contained within - or is perfectly adjacent to - an existing
     * availability, the existing availability is extended to encapsulate the time provided by this block.
     *
     * @param availableBlock the TimeBlock to-be-added.
     */
    void addAvailabilityBlock(TimeBlock availableBlock);

    /**
     * Removes the given TimeBlock from this Schedule's available TimeBlocks.
     * If the given TimeBlock does not overlap with any existing available TimeBlocks, nothing occurs.
     * If the given TimeBlock overlaps with existing available TimeBlocks, the TimeBlocks in question are shortened to
     * exclude the time held by this TimeBlock.
     * If the given TimeBlock is entirely contained by an available TimeBlock, the TimeBlock in question is split into
     * two TimeBlocks, neither of which overlap with the TimeBlock passed as unavailable.
     *
     * @param unavailableBlock the newly unavailable block of time.
     */
    void removeAvailabilityBlock(TimeBlock unavailableBlock);

    /**
     * Returns the Curriculum holding the given Curriculum ID.
     *
     * @param curriculumID the ID belonging to the desired Curriculum object
     * @return the Curriculum object with the appropriate ID, null otherwise.
     */
    Curriculum getCurriculum(int curriculumID);

    /**
     * Returns the TimeBlockManager object representing this Schedule's available times.
     *
     * @return this Schedule's available blocks, held by a TimeBlockManager object.
     */
    TimeBlockManager getAvailability();
}
