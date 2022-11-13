package config;

/**
 * A PathManager class, following a Singleton design pattern for flexibility in refactoring
 * Created: 11/08/2022
 * Last updated: 11/13/2022
 *
 * @author David Adler
 */
public class PathManager {

    private static PathManager instance = null;
    private final String baseDir;
    private final String iconDir;
    private final String userDir;

    /**
     * Private constructor for setting directories for the program
     */
    private PathManager() {
        this.baseDir = System.getProperty("user.dir");
        this.iconDir = baseDir.concat("\\Icons");
        this.userDir = baseDir.concat("\\src\\main\\stored_users");
    }

    /**
     * gets an existing instance of the PathManager, or creates one if it has not been instantiated yet
     * @return instance of the PathManager
     */
    public static PathManager getInstance() {
        if (instance == null) {
            instance = new PathManager();
        }
        return instance;
    }

    /**
     * gets the project base directory
     * @return String representing base directory path
     */
    public static String getBaseDirectory() {
        return getInstance().baseDir;
    }

    /**
     * gets the project's icon directory
     * @return String representing the icon directory path
     */
    public static String getIconDirectory() {
        return getInstance().iconDir;
    }

    /**
     * gets the project's User Storage directory
     * @return String representing the user storage directory path
     */
    public static String getUserDirectory() {
        return getInstance().userDir;
    }
}
