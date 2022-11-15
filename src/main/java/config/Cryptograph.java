package config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public interface Cryptograph {
    void encryptSave(Serializable object, OutputStream oStream, String password);
    Object decrypt(InputStream iStream, String password) throws IOException;
}
