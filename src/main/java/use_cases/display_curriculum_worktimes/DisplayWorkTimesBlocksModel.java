package use_cases.display_curriculum_worktimes;

public class DisplayWorkTimesBlocksModel {
    private int curriculumId;

    public DisplayWorkTimesBlocksModel(int curriculumId){
        this.curriculumId = curriculumId;
    }

    public int getCurriculumId() {
        return curriculumId;
    }
}
