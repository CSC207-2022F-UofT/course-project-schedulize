package entity_layer;

/**
 * A CommonTask class, implements the Task interface.
 * Created: 10/31/2022
 * Last updated: 11/10/2022
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
    private final int id = this.hashCode();
    private String name;
    private String description;
    private int completion;
    private int duration;

    /* ************ *\
    *  Constructors  *
    \* ************ */
    /**
     * Constructs a CommonTask object with the provided name and description, setting duration and completion to 0
     *
     * @param name this CommonTask's name
     * @param description this CommonTask's description
     */
    public CommonTask(String name, String description) {
        this(name, description, 0, 0);
    }

    /**
     * Constructs a CommonTask object with the provided name, description, and duration, setting its completion to 0
     *
     * @param name this CommonTask's name
     * @param description this CommonTask's description
     * @param duration this CommonTask's duration
     */
    public CommonTask(String name, String description, int duration) {
        this(name, description, duration, 0);
    }

    /**
     * Constructs a CommonTask object with the provided name, description, duration, setting completion to 0.
     * If the passed completion is out of bounds, the completion is set to the nearest in-bounds value (i.e. an
     * argument of -3 will set the completion to 0, and an argument of 132 will set the completion to 100)
     *
     * @param name this CommonTask's name
     * @param description this CommonTask's description
     * @param completion this CommonTask's completion
     */
    public CommonTask(String name, String description, int duration, int completion) {
        this.name = name;
        this.description = description;
        this.completion = completion;
        this.duration = duration;
    }

    /* ************* *\
    *  Functionality  *
    \* ************* */
    // Public
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

    //Private
    /**
     * Gets the ID for the next task in memory
     */
    private static int getNextID() {
        return taskCount++;
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

    /**
     * Return this CommonTask's duration.
     *
     * @return this CommonTask's duration.
     */
    public int getDuration() {
        return this.duration;
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
        this.name = name;
    }

    /**
     * Sets this CommonTask's description.
     *
     * @param description this CommonTask's intended description.
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set this CommonTask's duration
     *
     * @param duration this CommonTask's intended duration
     */
    @Override
    public void setDuration(int duration) {
        if (duration < 0) {
            this.duration = 0;
            return;
        }
        this.duration = duration;
    }
}
