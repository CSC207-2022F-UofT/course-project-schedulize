package task_display_ui;

public class TaskUiTestPresenter implements TaskUiOutputBoundary {

    private TaskUiModel taskUiModel;
    @Override
    public void getTaskInfo(TaskUiModel taskUiModel) {
        this.taskUiModel = taskUiModel;
    }

    public TaskUiModel getTaskUiModel() {
        return taskUiModel;
    }
}
