package entity_layer;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A TimeBlock interface, implemented by the CommonTimeBlock class.
 * Created: 10/31/2022
 * Last updated: 11/5/2022
 *
 * @author MMachadoUofT
 */
public interface TimeBlock extends Serializable {
    /**
     * Returns true if this TimeBlock's start and end times are the same as other's start and end times
     *
     * @param other the TimeBlock this TimeBlock is being compared to
     * @return true if these TimeBlocks are equal, false otherwise
     */
    boolean equals(TimeBlock other);

    /**
     * Returns true if these TimeBlocks share common times, partially, or entirely.
     * That is, if the two provided TimeBlocks are equal, or one contains the other, this will return true.
     * This applies to the case where this ends *before* other
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if there is a time overlap, false otherwise
     */
    boolean overlapsBefore(TimeBlock other);

    /**
     * Returns true if these TimeBlocks share common times, partially, or entirely.
     * That is, if the two provided TimeBlocks are equal, or one contains the other, this will return true.
     * This applies to the case where this ends *after* other
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if there is a time overlap, false otherwise
     */
    boolean overlapsAfter(TimeBlock other);

    /**
     * Returns true if these TimeBlocks share common times, partially, or entirely.
     * That is, if the two provided TimeBlocks are equal, or one contains the other, this will return true.
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
     * Returns true if this TimeBlock is adjacent before, or after, the other.
     *
     * @param other the TimeBlock this is being compared to
     * @return true if either isAdjacentBefore is true, or isAdjacentAfter is true.
     */
    boolean isAdjacentTo(TimeBlock other);

    /**
     * Returns true if this TimeBlock ends just as the other begins.
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if the other TimeBlock is adjacent to this one, false otherwise
     */
    boolean isAdjacentBefore(TimeBlock other);

    /**
     * Returns true if this TimeBlock begins just as the other ends.
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if the other TimeBlock is adjacent to this one, false otherwise
     */
    boolean isAdjacentAfter(TimeBlock other);

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
