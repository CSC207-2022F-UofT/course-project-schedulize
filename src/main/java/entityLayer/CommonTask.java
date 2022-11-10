package entityLayer;

/**
 * A CommonTask class, implements the Task interface.
 * Created: 10/31/2022
 * Last updated: 11/4/2022
 * 
 * @author MMachadoUofT
 */
public class CommonTask implements Task {

    /* ********** *\
    *  Attributes  *
    \* ********** */
    // Static
    private static int taskCount = 0;
    private static final int COMPLETION_LOWER_BOUND = 0;
    private static final int COMPLETION_UPPER_BOUND = 100;

    // Instance
    private final int id;
    private String name;
    private String description;
    private int completion;

    /* ************ *\
    *  Constructors  *
    \* ************ */
    /**
     * Constructs a CommonTask object with the provided name and description, setting its completion to 0
     *
     * @param name this CommonTask's name
     * @param description this CommonTask's description
     */
    public CommonTask(String name, String description) {
        this(name, description, 0);
    }

    /**
     * Constructs a CommonTask object with the provided name, description, and completion.
     * If the passed completion is out of bounds, the completion is set to the nearest in-bounds value (i.e. an
     * argument of -3 will set the completion to 0, and an argument of 132 will set the completion to 100)
     *
     * @param name this CommonTask's name
     * @param description this CommonTask's description
     * @param completion this CommonTask's completion
     */
    public CommonTask(String name, String description, int completion) {
        this.name = name;
        this.description = description;
        if (completionWithinBounds(completion)) {
            this.completion = completion;
        } else {
            if (completion > COMPLETION_UPPER_BOUND) {
                this.completion = COMPLETION_UPPER_BOUND;
            } else if (completion < COMPLETION_LOWER_BOUND) {
                this.completion = COMPLETION_UPPER_BOUND;
            }
        }
        this.id = taskCount++;
    }

    /* ************* *\
    *  Functionality  *
    \* ************* */
    /**
     * Returns whether this CommonTask's completion is set to 100.
     *
     * @return true if this CommonTask is complete, false otherwise.
     */
    @Override
    public boolean isComplete() {
        return this.completion == COMPLETION_UPPER_BOUND;
    }

    /**
     * Returns true if the provided completion is within the valid bounds of a task's completion
     *
     * @param completion the completion to be judged
     * @return true if the completion value is valid, false otherwise
     */
    private static boolean completionWithinBounds(int completion) {
        return (completion >= COMPLETION_LOWER_BOUND && completion <= COMPLETION_UPPER_BOUND);
    }

    /* **************** *\
    *  Attribute Access  *
    \* **************** */

    // Getters
    /**
     * Get this CommonTask's completion level.
     *
     * @return this CommonTask's completion.
     */
    @Override
    public int getCompletion() {
        return this.completion;
    }

    /**
     * Get this CommonTask's name.
     *
     * @return this CommonTask's name.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Get this CommonTask's description.
     *
     * @return this CommonTask's description.
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Get this CommonTask's ID attribute.
     *
     * @return this CommonTask's unique ID.
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Get the total amount of tasks there are.
     *
     * @return the static taskCount attribute
     */
    @Override
    public int getTaskCount() {
        return taskCount;
    }

    // Setters
    /**
     * Sets this CommonTask's completion attribute to the passed number.
     * If the attempted value is out of bounds (i.e. less than 0, greater than 100) return false. True otherwise.
     *
     * @param completion this CommonTask's new completion level.
     * @return true if the completion level was valid, false otherwise.
     */
    @Override
    public boolean setCompletion(int completion) {
        if (!completionWithinBounds(completion)) {
            return false;
        }
        this.completion = completion;
        return true;
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
}
