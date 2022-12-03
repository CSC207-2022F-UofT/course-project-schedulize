package entity_layer;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * A CommonCurriculum class, implements the Curriculum interface.
 * Created: 10/31/2022
 * Last updated: 11/4/2022
 * 
 * @author MMachadoUofT
 */
public class CommonCurriculum implements Curriculum {

    /* ********** *\
    *  Attributes  *
    \* ********** */
    // Instance
    private final TaskTree goal;
    private final TimeBlockManager workTimes;
    private final TimeBlockManager weekSchedule;
    private String name;
    private final int id = getNextID();

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

    /* ************* *\
    *  Functionality  *
    \* ************* */
    // Public
    /**
     * Add the given TimeBlock to this Curriculum's worktimes
     *
     * @param workTime the TimeBlock to be added.
     */
    @Override
    public void addWorkTime(TimeBlock workTime) {
        this.workTimes.addTimeBlock(workTime);
    }

    /**
     * Remove the given TimeBlock to this CommonCurriculum's worktimes
     *
     * @param workTime the TimeBlock to be removed.
     */
    @Override
    public void removeWorkTime(TimeBlock workTime) {
        this.workTimes.removeTimeBlock(workTime);
    }

    /**
     * Get a TimeBlockManager representing the times that the User will work on this CommonCurriculum for this week
     *
     * @return this week's TimeBlocks, held by a TimeBlockManager.
     */
    @Override
    public TimeBlockManager getThisWeekSchedule() {
        this.reduceWorkTimesToWeek();
        return this.weekSchedule;
    }

    /**
     * Get the TaskTree holding the Task with the corresponding ID, null if no such TaskTree was found.
     *
     * @param taskID the ID for the desired Task and subsequent TaskTree
     * @return the TaskTree holding the desired Task
     */
    @Override
    public TaskTree getTaskTreeByID(int taskID) {
        return this.goal.getChildTaskTreeByID(taskID);
    }

    /**
     * Return a unique ID to be assigned to the next constructed CommonCurriculum
     *
     * @return the next ID to be assigned
     */
    private static int getNextID() {
        return curriculumCount++;
    }

    // Private
    /**
     * Reset this.weekSchedule to only include work times within one week of now.
     */
    private void reduceWorkTimesToWeek() {
        LocalDateTime todayNow = LocalDateTime.now();
        this.weekSchedule.clear();

        for (TimeBlock t : this.workTimes) {
            if (Math.toIntExact(Duration.between(todayNow, t.getStartTime()).toHours()) < HOURS_IN_WEEK) {
                this.weekSchedule.addTimeBlock(t);
            } else {
                return;
            }
        }
    }

    /* **************** *\
    *  Attribute Access  *
    \* **************** */
    // Getters
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Get the highest-level TaskTree item within this CommonCurriculum. Note that this returns a TaskTree item, *not*
     * a Task item.
     *
     * @return this CommonCurriculums goal.
     */
    @Override
    public TaskTree getGoal() {
        return this.goal;
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
     * Get the TimeBlockManager holding every TimeBlock where this User is intended to work on this CommonCurriculum
     *
     * @return this CommonCurriculum's workTimes attribute
     */
    @Override
    public TimeBlockManager getFullSchedule() {
        return this.workTimes;
    }

    // Setters
    /**
     * Set this CommonCurriculum's name
     *
     * @param name this CommonCurriculum's new name
     */
    public void setName(String name) {
        this.name = name;
    }
}
