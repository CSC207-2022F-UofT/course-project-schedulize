package entityLayer;

public interface Task {

    int getCompletion();
    String getName();
    String getDescription();
    int getId();

    boolean setCompletion(int completion);
    void setName(String name);
    void setDescription(String description);

}
