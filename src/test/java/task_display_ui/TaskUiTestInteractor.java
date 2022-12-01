package task_display_ui;

public class TaskUiTestInteractor implements TaskUiInputBoundary{

    private int curriculumID;
    private int taskID;
    @Override
    public void displayTask(int curriculumID, int taskID) {
        this.curriculumID = curriculumID;
        this.taskID = taskID;
    }

    public int getCurriculumID() {
        return curriculumID;
    }

    public int getTaskID() {
        return taskID;
    }
}
