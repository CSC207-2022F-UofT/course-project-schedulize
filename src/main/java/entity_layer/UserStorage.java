package entity_layer;

import config.PathManager;
import use_cases.user_registration.UserDataStoreGateway;

import java.io.File;
import java.util.HashSet;


public class UserStorage implements UserDataStoreGateway {
    private final HashSet<String> existingUsernames;

    UserStorage() {
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

    @Override
    public boolean usernameExists(String username) {
        return existingUsernames.contains(username);
    }

    @Override
    public void saveUser(User newUser) {
        return;
    }

    private String removeFileExtension(String filename) {
        int pos = filename.lastIndexOf(".");
        if (pos > 0) {
            return filename.substring(0, pos);
        } else {
            return filename;
        }
    }
}
