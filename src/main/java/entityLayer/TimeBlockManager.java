package entityLayer;

import java.util.List;

public interface TimeBlockManager {
    List<TimeBlock> getTimeBlocks();
    void addTimeBlock(TimeBlock timeBlock);
    boolean removeTimeBlock(TimeBlock timeBlock);

}
