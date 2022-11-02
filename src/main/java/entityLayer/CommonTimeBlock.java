package entityLayer;

import java.time.LocalDateTime;

public class CommonTimeBlock implements TimeBlock {
    @Override
    public boolean equals(TimeBlock other) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean overlapsWith(TimeBlock other) {
        return false;
    }

    @Override
    public boolean isContainedWithin(TimeBlock other) {
        return false;
    }

    @Override
    public boolean contains(TimeBlock other) {
        return false;
    }

    @Override
    public LocalDateTime getStartTime() {
        return null;
    }

    @Override
    public LocalDateTime getEndTime() {
        return null;
    }

    @Override
    public int getDuration() {
        return 0;
    }
}
