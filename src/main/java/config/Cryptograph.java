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
    void encryptSave(Serializable object, OutputStream oStream, String password);
    Object decrypt(InputStream iStream, String password) throws IOException;
}
