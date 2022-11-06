package entityLayer;

import java.time.LocalDateTime;

/**
 * A TimeBlock interface, implemented by the CommonTimeBlock class.
 * Created: 10/31/2022
 * Last updated: 11/5/2022
 *
 * @author MMachadoUofT
 */
public interface TimeBlock {
    /**
     * Returns true if this TimeBlock's start and end times are the same as other's start and end times
     *
     * @param other the TimeBlock this TimeBlock is being compared to
     * @return true if these TimeBlocks are equal, false otherwise
     */
    boolean equals(TimeBlock other);

    /**
     * Returns this TimeBlock's hashcode. This is primarily being implemented to allow the equals() method to adhere
     * to the hashCode requirements
     *
     * @return this TimeBlocks hashcode.
     */
    int hashCode();

    /**
     * Returns true if these TimeBlocks share common times, partially, or entirely
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if there is a time overlap, false otherwise
     */
    boolean overlapsWith(TimeBlock other);

    /**
     * Returns true if the entirety of this TimeBlock is contained between the start and end times of the other.
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if this TimeBlock lies within other, false otherwise
     */
    boolean isContainedWithin(TimeBlock other);

    /**
     * Returns true if the entirety of the other TimeBlock is contained between the start and end times of this.
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if the other TimeBlock lies within this, false otherwise
     */
    boolean contains(TimeBlock other);

    /**
     * Returns true if the other TimeBlock ends exactly when this one starts, or starts exactly when this one ends.
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if the other TimeBlock is adjacent to this one, false otherwise
     */
    boolean isAdjacentTo(TimeBlock other);

    /**
     * Return this TimeBlocks start time and date.
     *
     * @return this TimeBlock's startTime attribute
     */
    LocalDateTime getStartTime();

    /**
     * Return this TimeBlock's end time and date.
     *
     * @return this TimeBlock's endTime attribute
     */
    LocalDateTime getEndTime();

    /**
     * Set this TimeBlock's start time and date.
     *
     * @param startTime this TimeBlock's intended startTime
     */
    void setStartTime(LocalDateTime startTime);

    /**
     * Set this TimeBlock's end time and date.
     *
     * @param endTime this TimeBlock's intended endTime
     */
    void setEndTime(LocalDateTime endTime);

    /**
     * Get the total amount of minutes between this TimeBlock's start time and end time
     *
     * @return the duration of this TimeBlock, in minutes
     */
    int getDuration();
}
