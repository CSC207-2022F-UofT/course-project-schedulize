package entity_layer;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * A CommonTimeBlock class, implements the TimeBlock interface.
 * Created: 10/31/2022
 * Last updated: 11/5/2022
 *
 * @author MMachadoUofT
 */
public class CommonTimeBlock implements TimeBlock {

    /* ********** *\
    *  Attributes  *
    \* ********** */
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    /* ************ *\
    *  Constructors  *
    \* ************ */
    public CommonTimeBlock(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        // I'll have to include a check somewhere that doesn't allow start time to be before
        //  end time.
    }

    /* ************* *\
    *  Functionality  *
    \* ************* */
    // Public
    /**
     * Returns true if this CommonTimeBlock's start and end times are the same as other's start and end times
     *
     * @param other the TimeBlock this CommonTimeBlock is being compared to
     * @return true if these TimeBlocks are equal, false otherwise
     */
    @Override
    public boolean equals(TimeBlock other) {
        if (other == this)
            return true;
        if ((other == null) || (other.getClass() != this.getClass()))
            return false;
        return (this.startTime == other.getStartTime() && this.endTime == other.getEndTime());
    }

    /**
     * Returns this TimeBlock's hashcode. This is primarily being implemented to allow the equals() method to adhere
     * to the hashCode requirements
     *
     * @return this TimeBlocks hashcode.
     */
    @Override
    public int hashCode() {
        int startTimeInt = this.startTime.getDayOfMonth() + this.startTime.getDayOfYear() + this.startTime.getHour();
        int endTimeInt = this.endTime.getDayOfMonth() + this.endTime.getDayOfYear() + this.endTime.getHour();

        return startTimeInt + endTimeInt;
    }

    /**
     * Returns true if these CommonTimeBlocks share common times, partially, or entirely.
     * That is, if the two provided CommonTimeBlocks are equal, or one contains the other, this will return true.
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if there is a time overlap, false otherwise
     */
    @Override
    public boolean overlapsWith(TimeBlock other) {
        return dateTimeIsBetween(this.startTime, other.getStartTime(), other.getEndTime())
               || dateTimeIsBetween(this.endTime, other.getStartTime(), other.getEndTime());
    }

    /**
     * Returns true if the entirety of this CommonTimeBlock is contained between the start and end times of the other,
     * inclusive.
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if this CommonTimeBlock lies within other, false otherwise
     */
    @Override
    public boolean isContainedWithin(TimeBlock other) {
        return isAfterOrEqual(this.startTime, other.getStartTime())
                && isBeforeOrEqual(this.endTime, other.getEndTime());
    }

    /**
     * Returns true if the entirety of the other TimeBlock is contained between the start and end times of this.
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if the other TimeBlock lies within this, false otherwise
     */
    @Override
    public boolean contains(TimeBlock other) {
        return other.isContainedWithin(this);
    }

    /**
     * Returns true if the other TimeBlock ends exactly when this one starts, or starts exactly when this one ends.
     *
     * @param other the TimeBlock that this is being compared to
     * @return true if the other TimeBlock is adjacent to this one, false otherwise
     */
    @Override
    public boolean isAdjacentTo(TimeBlock other) {
        return (this.startTime.equals(other.getEndTime()) || this.endTime.equals(other.getStartTime()));
    }

    // Private
    /**
     * Returns true if the first provided LocalDateTime lies between the latter two provided LocalDateTimes, false
     * if otherwise.
     *
     * @param candidate the LocalDateTime to be tested
     * @param lowerBound the LocalDateTime candidate is meant to fall after
     * @param upperBound the LocalDateTime candidate is meant to fall before
     * @return true if the stipulations of lowerBound and upperBound are met
     */
    private static boolean dateTimeIsBetween(LocalDateTime candidate,
                                             LocalDateTime lowerBound, LocalDateTime upperBound) {
        return candidate.isAfter(lowerBound) && candidate.isBefore(upperBound);
    }

    /**
     * Returns true if t1 is after or at the same time as t2
     *
     * @param t1 the first LocalDateTime
     * @param t2 the second LocalDateTime
     * @return true if t1 is after or equal to t2
     */
    private static boolean isAfterOrEqual(LocalDateTime t1, LocalDateTime t2) {
        return t1.isAfter(t2) || t1.isEqual(t2);
    }

    /**
     * Returns true if t1 is before or at the same time as t2
     *
     * @param t1 the first LocalDateTime
     * @param t2 the second LocalDateTime
     * @return true if t1 is before or equal to t2
     */
    private static boolean isBeforeOrEqual(LocalDateTime t1, LocalDateTime t2) {
        return t1.isBefore(t2) || t1.isEqual(t2);
    }

    /* **************** *\
    *  Attribute Access  *
    \* **************** */
    /**
     * Return this CommonTimeBlocks start time and date.
     *
     * @return this CommonTimeBlock's startTime attribute
     */
    @Override
    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Return this CommonTimeBlock's end time and date.
     *
     * @return this CommonTimeBlock's endTime attribute
     */
    @Override
    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    /**
     * Set this CommonTimeBlock's start time and date.
     *
     * @param startTime this CommonTimeBlock's intended startTime
     */
    @Override
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Set this CommonTimeBlock's end time and date.
     *
     * @param endTime this CommonTimeBlock's intended endTime
     */
    @Override
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Get the total amount of minutes between this CommonTimeBlock's start time and end time
     *
     * @return the duration of this CommonTimeBlock, in minutes
     */
    @Override
    public int getDuration() {
        return Math.toIntExact(Duration.between(this.startTime, this.endTime).toMinutes());
    }
}
