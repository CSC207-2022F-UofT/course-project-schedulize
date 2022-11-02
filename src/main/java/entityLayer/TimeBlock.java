package entityLayer;

import java.time.LocalDateTime;

public interface TimeBlock {
    // Overriden equals method to simplify finding equal TimeBlocks
    boolean equals(TimeBlock other);

    boolean overlapsWith(TimeBlock other);
    boolean isContainedWithin(TimeBlock other);
    boolean contains(TimeBlock other);
    LocalDateTime getStartTime();
    LocalDateTime getEndTime();
    int getDuration();
}
