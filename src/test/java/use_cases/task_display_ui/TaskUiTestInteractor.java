package use_cases.task_display_ui;

import UI.task_display_UI.TaskUiInputBoundary;

public class TaskUiTestInteractor implements TaskUiInputBoundary {

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
