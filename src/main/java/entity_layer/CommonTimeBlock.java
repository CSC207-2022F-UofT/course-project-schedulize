package entity_layer;

import java.time.LocalDateTime;

/**
 * A CommonTimeBlock class, implements the TimeBlock interface.
 * Created: 10/31/2022
 * Last updated: 11/5/2022
 *
 * @author MMachadoUofT
 */
public class CommonTimeBlock implements TimeBlock {

    /**
     * Returns true if this CommonTimeBlock's start and end times are the same as other's start and end times
     *
     * @param other the TimeBlock this CommonTimeBlock is being compared to
     * @return true if these TimeBlocks are equal, false otherwise
     */
    @Override
    public boolean equals(TimeBlock other) {
        return false;
    }

    /**
     * Returns true if these TimeBlocks share common times, partially, or entirely
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if there is a time overlap, false otherwise
     */
    @Override
    public boolean overlapsWith(TimeBlock other) {
        return false;
    }

    /**
     * Returns true if the entirety of this CommonTimeBlock is contained between the start and end times of the other.
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if this CommonTimeBlock lies within other, false otherwise
     */
    @Override
    public boolean isContainedWithin(TimeBlock other) {
        return false;
    }

    /**
     * Returns true if the entirety of the other TimeBlock is contained between the start and end times of this.
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if the other TimeBlock lies within this, false otherwise
     */
    @Override
    public boolean contains(TimeBlock other) {
        return false;
    }

    /**
     * Returns true if the other TimeBlock ends exactly when this one starts, or starts exactly when this one ends.
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if the other TimeBlock is adjacent to this one, false otherwise
     */
    @Override
    public boolean isAdjacentTo(TimeBlock other) {
        return false;
    }

    /**
     * Return this CommonTimeBlocks start time and date.
     *
     * @return this CommonTimeBlock's startTime attribute
     */
    @Override
    public LocalDateTime getStartTime() {
        return null;
    }

    /**
     * Return this CommonTimeBlock's end time and date.
     *
     * @return this CommonTimeBlock's endTime attribute
     */
    @Override
    public LocalDateTime getEndTime() {
        return null;
    }

    /**
     * Set this CommonTimeBlock's start time and date.
     *
     * @param startTime this CommonTimeBlock's intended startTime
     */
    @Override
    public void setStartTime(LocalDateTime startTime) {

    }

    /**
     * Set this CommonTimeBlock's end time and date.
     *
     * @param endTime this CommonTimeBlock's intended endTime
     */
    @Override
    public void setEndTime(LocalDateTime endTime) {

    }

    /**
     * Get the total amount of minutes between this CommonTimeBlock's start time and end time
     *
     * @return the duration of this CommonTimeBlock, in minutes
     */
    @Override
    public int getDuration() {
        return 0;
    }
}
