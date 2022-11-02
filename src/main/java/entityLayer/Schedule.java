package entityLayer;

public interface Schedule {
    boolean addAvailability(TimeBlock availableBlock);
    boolean removeAvailability(TimeBlock unavailableBlock);
    Curriculum getCurriculum(int curriculumID);
}
