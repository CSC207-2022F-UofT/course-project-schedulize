package config;

/**
 * An Exception that wraps other Exceptions that deal with saving, loading, decryption, and encryption
 * Created: 11/14/2022
 * Last updated: 11/15/2022
 *
 * @author David Adler
 */
public class DataStorageMalfunction extends RuntimeException {
    public DataStorageMalfunction(String msg) {
        super(msg);
    }
}
