package entityLayer;

public class CommonSchedule implements Schedule {
    @Override
    public boolean addAvailability(TimeBlock availableBlock) {
        return false;
    }

    @Override
    public boolean removeAvailability(TimeBlock unavailableBlock) {
        return false;
    }

    @Override
    public Curriculum getCurriculum(int curriculumID) {
        return null;
    }
}
