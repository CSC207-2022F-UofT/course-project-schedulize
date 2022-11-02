package entityLayer;

public class CommonTask implements Task {

    @Override
    public int getCompletion() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public boolean setCompletion(int completion) {
        return false;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setDescription(String description) {

    }
}
