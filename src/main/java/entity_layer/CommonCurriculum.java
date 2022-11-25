package entity_layer;

/**
 * A CommonCurriculum class, implements the Curriculum interface.
 * Created: 10/31/2022
 * Last updated: 11/4/2022
 * 
 * @author MMachadoUofT
 */
public class CommonCurriculum implements Curriculum {
    // TODO: implement
    /* ********** *\
    *  Attributes  *
    \* ********** */
    // Instance
    private TaskTree goal;
    private TimeBlockManager workTimes;
    private TimeBlockManager weekSchedule;
    private String name;
    private final transient int id = getNextID();

    // Static
    private static int curriculumCount = 0;
    private static final int HOURS_IN_WEEK = 168;

    /* ************ *\
    *  Constructors  *
    \* ************ */
    public CommonCurriculum(TaskTree goal, TimeBlockManager workTimes, TimeBlockManager weekSchedule, String name) {
        this.goal = goal;
        this.workTimes = workTimes;
        this.weekSchedule = weekSchedule;
        this.name = name;
    }

    /* **************** *\
    *  Attribute Access  *
    \* **************** */
    // Public
    @Override
    public String getName() {
        return null;
    }

    /**
     * Get the highest-level TaskTree item within this CommonCurriculum. Note that this returns a TaskTree item, *not*
     * a Task item.
     *
     * @return this CommonCurriculums goal.
     */
    @Override
    public TaskTree getGoal() {
        return null;
    }

    /**
     * Return this CommonCurriculum's unique id number.
     *
     * @return this CommonCurriculum's id.
     */
    @Override
    public int getID() {
        return this.id;
    }

    /**
     * Get the TaskTree holding the Task with the corresponding ID, null if no such TaskTree was found.
     *
     * @param taskID the ID for the desired Task and subsequent TaskTree
     * @return the TaskTree holding the desired Task
     */
    @Override
    public TaskTree getTaskTreeByID(int taskID) {
        return null;
    }

    /**
     * Get a TimeBlockManager representing the times that the User will work on this CommonCurriculum for this week
     *
     * @return this week's TimeBlocks, held by a TimeBlockManager.
     */
    @Override
    public TimeBlockManager getThisWeekSchedule() {
        return null;
    }

    /**
     * Get the TimeBlockManager holding every TimeBlock where this User is intended to work on this CommonCurriculum
     *
     * @return this CommonCurriculum's workTimes attribute
     */
    @Override
    public TimeBlockManager getFullSchedule() {
        return null;
    }

    // Private
    private static int getNextID() {
        return curriculumCount++;
    }
}
