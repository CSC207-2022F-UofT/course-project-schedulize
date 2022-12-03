package task_display_ui;

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
