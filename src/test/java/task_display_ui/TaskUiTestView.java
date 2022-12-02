package task_display_ui;

public class TaskUiTestView implements TaskUiViewInterface{
    private TaskUiModel taskUiModel;
    @Override
    public void updateView(TaskUiModel taskUiModel) {
        this.taskUiModel = taskUiModel;
    }

    public TaskUiModel getTaskUiModel() {
        return taskUiModel;
    }
}
