package config;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * A class for saving encrypted and loading decrypting objects
 * Created: 11/14/2022
 * Last updated: 11/15/2022
 *
 * @author David Adler
 */
public class CommonCryptograph implements Cryptograph {
    private final int KEY_LENGTH;
    private final char TRAILING_CHAR;
    private final String ENCRYPTION_TYPE;

    /**
     * Constructor for encryption defaults
     */
    public CommonCryptograph() {
        KEY_LENGTH = 16;
        TRAILING_CHAR = '#';
        ENCRYPTION_TYPE = "AES";
    }

    /**
     * Encrypt and save object as byte stream
     * @param object Serializable object to save
     * @param oStream file to write object to
     * @param password password for encryption
     * @throws DataStorageMalfunction Saving and/or Encryption malfunction
     */
    @Override
    public void encryptSave(Serializable object, OutputStream oStream, String password)
            throws DataStorageMalfunction {
        // Length is 16 byte
        SecretKeySpec sks = new SecretKeySpec(createKeyFromPassword(password), ENCRYPTION_TYPE);

        // Create cipher
        Cipher cipher = initializeCipher();
        try {
            cipher.init(Cipher.ENCRYPT_MODE, sks);
        } catch (InvalidKeyException error) { throw new DataStorageMalfunction("Key Encryption failed"); }
        SealedObject sealedObj = sealObject(object, cipher);

        // Write output stream
        writeEncryptedObject(sealedObj, cipher, oStream);
    }

    /**
     * Decrypts bytes of file in input stream
     * @param iStream file input stream
     * @param password password for decryption
     * @return decrypted object
     * @throws IOException Decryption or Driver fail
     * @throws DataStorageMalfunction Decryption or Cipher failure
     */
    @Override
    public Object decrypt(InputStream iStream, String password) throws IOException, DataStorageMalfunction {
        SecretKeySpec sks = new SecretKeySpec(createKeyFromPassword(password), ENCRYPTION_TYPE);
        Cipher cipher = initializeCipher();
        try {
            cipher.init(Cipher.DECRYPT_MODE, sks);
        } catch (InvalidKeyException error) { throw new DataStorageMalfunction("Key Decryption failed"); }

        return loadDecryptedObject(iStream, cipher);
    }

    /**
     * Create valid byte array, encryption/decryption key from input password
     * @param password password to make key with
     * @return encryption/decryption key
     */
    private byte[] createKeyFromPassword(String password) {
        while (password.length() < KEY_LENGTH) {
            password = password.concat(String.valueOf(TRAILING_CHAR));
        }
        if (password.length() > KEY_LENGTH) {
            password = password.substring(0, KEY_LENGTH - 1);
        }
        return password.getBytes();
    }

    /**
     * Attempt to create a cipher
     * @return Created cipher
     * @throws DataStorageMalfunction Cipher initialization failure
     */
    private Cipher initializeCipher() {
        try {
            return Cipher.getInstance(ENCRYPTION_TYPE);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException error) {
            throw new DataStorageMalfunction("Cipher initialization failed");
        }
    }


    /**
     * Creates a sealed object from input object
     * @param o object to seal
     * @param cipher cipher to seal object with
     * @throws DataStorageMalfunction Loading sealed object failed
     * @return sealed object
     */
    private SealedObject sealObject(Serializable o, Cipher cipher) {
        try {
            return new SealedObject(o, cipher);
        } catch (IllegalBlockSizeException | IOException error) {
            throw new DataStorageMalfunction("Cipher encryption creation failed");
        }
    }

    /**
     * Writes Encrypted object to file
     * @param sealedObj encrypted object
     * @param cipher encryption cipher
     * @param oStream stream to write output file data to
     * @throws DataStorageMalfunction Writing to file failed
     */
    private void writeEncryptedObject(SealedObject sealedObj, Cipher cipher, OutputStream oStream) throws
            DataStorageMalfunction {
        try {
            CipherOutputStream cos = new CipherOutputStream(oStream, cipher);
            ObjectOutputStream outputStream = new ObjectOutputStream(cos);
            outputStream.writeObject(sealedObj);
            outputStream.close();
        } catch (IOException error) { throw new DataStorageMalfunction("Driver Malfunction"); }
    }

    /**
     * Loads Decrypted object from file
     * @param iStream file stream to read from
     * @param cipher cipher to decrypt object with
     * @return decrypted, unsealed object
     * @throws IOException failure to Decrypt object because of invalid key
     * @throws DataStorageMalfunction failure to Decrypt sealed object not due to incorrect key
     */
    private Object loadDecryptedObject(InputStream iStream, Cipher cipher) throws IOException, DataStorageMalfunction {
        CipherInputStream cipherInputStream = new CipherInputStream(iStream, cipher);
        try {
            ObjectInputStream inputStream = new ObjectInputStream(cipherInputStream);
            SealedObject sealedObject = (SealedObject) inputStream.readObject();
            return sealedObject.getObject(cipher);
        } catch (ClassNotFoundException | IllegalBlockSizeException | BadPaddingException error) {
            throw new DataStorageMalfunction("Decryption failed");
        }
    }
}
