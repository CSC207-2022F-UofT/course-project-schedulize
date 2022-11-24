package use_cases.display_curriculum_worktimes;

public class DisplayWorkTimeBlocksController {
    private DisplayWorkTimeBlocksInputBoundary workTimes;

    public DisplayWorkTimeBlocksController(DisplayWorkTimeBlocksInputBoundary workTimes){
        this.workTimes = workTimes;
    }

    public void displayWorkTimes(int curriculumId){
        this.workTimes.displayWorkTimes(curriculumId);
    }
}
