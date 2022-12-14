package entity_factories;

import entity_layer.CommonTimeBlockManager;
import entity_layer.TimeBlock;
import entity_layer.TimeBlockManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for creating CommonTimeBlockManagers.
 * Created: 11/25/2022
 * Last updated: 11/25/2022
 *
 * @author MMachadoUofT
 */
public class CommonTimeBlockManagerFactory implements TimeBlockManagerFactory {

    /* ************* *\
    *  Functionality  *
    \* ************* */
    /**
     * Returns a newly created object of type CommonTimeBlockManager with no TimeBlocks
     *
     * @return a CommonTimeBlockManager
     */
    @Override
    public TimeBlockManager createEmpty() {
        return new CommonTimeBlockManager(new ArrayList<>(), new CommonTimeBlockFactory());
    }

    /**
     * Returns a newly created object of type CommonTimeBlockManager with the given TimeBlocks
     *
     * @param timeBlocks this CommonTimeBlockManager's initial timeblocks
     * @return a CommonTimeBlockManager
     */
    @Override
    public TimeBlockManager createWithTimeBlocks(List<TimeBlock> timeBlocks) {
        return new CommonTimeBlockManager(timeBlocks, new CommonTimeBlockFactory());
    }
}
