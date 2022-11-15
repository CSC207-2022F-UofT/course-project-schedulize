package config;

import entity_layer.User;
import use_cases.user_registration.UserDataStoreGateway;

import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;


/**
 * A Data Storage class for accessing existing user data and saving new users
 * Created: 11/13/2022
 * Last updated: 11/14/2022
 *
 * @author David Adler
 */
public class UserStorage implements UserDataStoreGateway {
    private final HashSet<String> existingUsernames;

    /**
     * Default constructor that gets all existing usernames
     */
    public UserStorage() {
        existingUsernames = new HashSet<String>();
        File userDir = new File(PathManager.getUserDirectory());
        File[] directoryListing = userDir.listFiles();

        if (!userDir.mkdirs() && directoryListing != null) {
            for (File user : directoryListing) {
                String extendedUsername = user.getName();
                existingUsernames.add(removeFileExtension(extendedUsername));
            }
        } else {
            // TODO: invalid file structure and directory does not exist
            // throw new RuntimeException();
        }
    }

    /**
     * Check if the username exists
     * @param username the username that you want to check whether exists
     * @return boolean, true if the username exists, false otherwise
     */
    @Override
    public boolean usernameExists(String username) {
        return existingUsernames.contains(username);
    }

    /**
     * Saves a user to .ser file
     * @param newUser User object to save
     * @throws DataStorageMalfunction for when Saving at any lower level malfunctions
     */
    @Override
    public void saveUser(User newUser) {
        String filepath = PathManager.getUserDirectory().concat("\\" + newUser.getUsername() + ".ser");
        File saveFile = new File(filepath);
        ObjectOutputStream oStream;
        try {
            oStream = new ObjectOutputStream(new FileOutputStream(saveFile));
        } catch (FileNotFoundException error) {
            throw new DataStorageMalfunction("User Data corrupted");
        } catch (IOException error) {
            throw new DataStorageMalfunction("Driver Malfunction");
        }
        Encryption.encryptSave(newUser, oStream, newUser.getPassword());
        existingUsernames.add(newUser.getUsername());
    }

    public User loadUser(String username, String password) throws IOException, ClassNotFoundException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String filepath = PathManager.getUserDirectory().concat("\\" + username + ".ser");
        File loadFile = new File(filepath);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(loadFile));
        Object object = Encryption.decrypt(in, password);
        return (User) object;
    }

    /**
     * Removes an existing user using the username
     * @param username username of User to remove
     */
    public void removeUser(String username) {
        if (this.usernameExists(username)) {
            String filepath = PathManager.getUserDirectory().concat("\\" + username + ".ser");
            File saveFile = new File(filepath);
            saveFile.delete();
        }
    }

    /**
     * Removes stored user, using User object
     * @param existingUser The existing user object to remove data for
     */
    public void removeUser(User existingUser) {
        if (this.usernameExists(existingUser.getUsername())) {
            String filepath = PathManager.getUserDirectory().concat("\\" + existingUser.getUsername() + ".ser");
            File saveFile = new File(filepath);
            saveFile.delete();
        }
    }

    /**
     * Gets the name of the user's data file without the .ser extension
     * @param filename a String representing the requested filename
     * @return a String, filename without extension
     */
    private String removeFileExtension(String filename) {
        int pos = filename.lastIndexOf(".");
        if (pos > 0) {
            return filename.substring(0, pos);
        } else {
            // TODO: INVALID FILES IN DIRECTORY
            return filename;
        }
    }
}
