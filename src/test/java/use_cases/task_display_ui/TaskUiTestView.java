package use_cases.task_display_ui;

import use_cases.task_display_UI.TaskUiModel;
import use_cases.task_display_UI.TaskUiViewInterface;

public class TaskUiTestView implements TaskUiViewInterface {
    private TaskUiModel taskUiModel;
    @Override
    public void updateView(TaskUiModel taskUiModel) {
        this.taskUiModel = taskUiModel;
    }

    public TaskUiModel getTaskUiModel() {
        return taskUiModel;
    }
}
