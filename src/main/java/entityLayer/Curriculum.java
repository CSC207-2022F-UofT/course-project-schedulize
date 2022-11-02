package entityLayer;

public interface Curriculum {

    TaskTree getGoal();

    TaskTree getTask(int taskID);

    TimeBlockManager getThisWeekSchedule();

}
