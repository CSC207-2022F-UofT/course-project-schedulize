package config;

public class DataStorageMalfunction extends RuntimeException {

    public DataStorageMalfunction(String msg) {
        super(msg);
    }
}
