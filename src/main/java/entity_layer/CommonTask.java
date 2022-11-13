package entity_layer;

/**
 * A CommonTask class, implements the Task interface.
 * Created: 10/31/2022
 * Last updated: 11/4/2022
 * 
 * @author MMachadoUofT
 */
public class CommonTask implements Task {

    /**
     * Get this CommonTask's completion level.
     *
     * @return this CommonTask's completion.
     */
    @Override
    public int getCompletion() {
        return 0;
    }

    /**
     * Get this CommonTask's name.
     *
     * @return this CommonTask's name.
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * Get this CommonTask's description.
     *
     * @return this CommonTask's description.
     */
    @Override
    public String getDescription() {
        return null;
    }

    /**
     * Get this CommonTask's ID attribute.
     *
     * @return this CommonTask's unique ID.
     */
    @Override
    public int getId() {
        return 0;
    }

    /**
     * Sets this CommonTask's completion attribute to the passed number.
     * If the attempted value is out of bounds (i.e. less than 0, greater than 100) return false. True otherwise.
     *
     * @param completion this CommonTask's new completion level.
     * @return true if the completion level was valid, false otherwise.
     */
    @Override
    public boolean setCompletion(int completion) {
        return false;
    }

    /**
     * Sets this CommonTask's name.
     *
     * @param name this CommonTask's intended name.
     */
    @Override
    public void setName(String name) {

    }

    /**
     * Sets this CommonTask's description.
     *
     * @param description this CommonTask's intended description.
     */
    @Override
    public void setDescription(String description) {

    }

    /**
     * Returns whether this CommonTask's completion is set to 100.
     *
     * @return true if this CommonTask is complete, false otherwise.
     */
    @Override
    public boolean isComplete() {
        return false;
    }
}
