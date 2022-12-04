package use_cases.task_display_ui;

import use_cases.task_display_UI.TaskUiModel;
import use_cases.task_display_UI.TaskUiOutputBoundary;
import use_cases.task_display_UI.TaskUiViewInterface;

public class TaskUiTestPresenter implements TaskUiOutputBoundary {

    private TaskUiModel taskUiModel;
    @Override
    public void getTaskInfo(TaskUiModel taskUiModel) {
        this.taskUiModel = taskUiModel;
    }

    @Override
    public void addViewObserver(TaskUiViewInterface view) {
        return;
    }

    public TaskUiModel getTaskUiModel() {
        return taskUiModel;
    }
}
