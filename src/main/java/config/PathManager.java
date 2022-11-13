package config;

/**
 * A PathManager class, following a Singleton design pattern for flexibility in refactoring
 * Created: 11/08/2022
 * Last updated: 11/08/2022
 *
 * @author David Adler
 */
public class PathManager {

    private static PathManager instance = null;
    private final String baseDir;
    private final String iconDir;

    /**
     * Private constructor for setting directories for the program
     */
    private PathManager() {
        this.baseDir = System.getProperty("user.dir");
        this.iconDir = baseDir.concat("\\Icons");
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
}
