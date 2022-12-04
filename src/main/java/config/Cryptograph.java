package config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * An interface for saving encrypted and loading decrypting objects
 * Created: 11/14/2022
 * Last updated: 11/15/2022
 *
 * @author David Adler
 */
public interface Cryptograph {

    /**
     * Encrypt and save object as byte stream
     * @param object Serializable object to save
     * @param oStream file to write object to
     * @param password password for encryption
     * @throws DataStorageMalfunction Saving and/or Encryption malfunction
     */
    void encryptSave(Serializable object, OutputStream oStream, String password);

    /**
     * Decrypts bytes of file in input stream
     * @param iStream file input stream
     * @param password password for decryption
     * @return decrypted object
     * @throws IOException Decryption or Driver fail
     * @throws DataStorageMalfunction Decryption or Cipher failure
     */
    Object decryptLoad(InputStream iStream, String password) throws IOException;
}
