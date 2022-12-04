package use_cases.task_display_ui;

import use_cases.task_display_UI.TaskUiInputBoundary;

public class TaskUiTestInteractor implements TaskUiInputBoundary {

    private int curriculumID;
    @Override
    public void displayTask(int curriculumID, int taskID) {
        this.curriculumID = curriculumID;
    }

    public int getCurriculumID() {
        return curriculumID;
    }
}
