package config;

import entity_layer.CommonUser;
import entity_layer.User;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    private static final int KEY_LENGTH = 16;
    private static final char TRAILING_CHAR = '#';
    private static final String ENCRYPTION_TYPE = "AES";

    public static void encryptSave(Serializable object, OutputStream oStream, String password)
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

    public static Object decrypt(InputStream istream, String password) throws IOException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException {
        SecretKeySpec sks = new SecretKeySpec(createKeyFromPassword(password), ENCRYPTION_TYPE);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_TYPE);
        cipher.init(Cipher.DECRYPT_MODE, sks);

        CipherInputStream cipherInputStream = new CipherInputStream(istream, cipher);
        ObjectInputStream inputStream = new ObjectInputStream(cipherInputStream);
        SealedObject sealedObject;
        try {
            sealedObject = (SealedObject) inputStream.readObject();
            return sealedObject.getObject(cipher);
        } catch (ClassNotFoundException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] createKeyFromPassword(String password) {
        while (password.length() < KEY_LENGTH) {
            password = password.concat(String.valueOf(TRAILING_CHAR));
        }
        if (password.length() > KEY_LENGTH) {
            password = password.substring(0, KEY_LENGTH - 1);
        }
        return password.getBytes();
    }

    private static Cipher initializeCipher() {
        try {
            return Cipher.getInstance(ENCRYPTION_TYPE);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException error) {
            throw new DataStorageMalfunction("Cipher encryption failed");
        }
    }

    private static SealedObject sealObject(Serializable o, Cipher cipher) {
        try {
            return new SealedObject(o, cipher);
        } catch (IllegalBlockSizeException | IOException error) {
            throw new DataStorageMalfunction("Cipher encryption creation failed");
        }
    }

    private static void writeEncryptedObject(SealedObject sealedObj, Cipher cipher, OutputStream oStream) {
        try {
            CipherOutputStream cos = new CipherOutputStream(oStream, cipher);
            ObjectOutputStream outputStream = new ObjectOutputStream(cos);
            outputStream.writeObject(sealedObj);
            outputStream.close();
        } catch (IOException error) { throw new DataStorageMalfunction("Driver Malfunction"); }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        UserStorage storage = new UserStorage();
        User user = new CommonUser("userPerson","email@sample.com",  "password");
        storage.saveUser(user);
        User loadeduser = storage.loadUser("userPerson", "password");
        System.out.println(loadeduser.getEmail());
        System.out.println(loadeduser.getPassword());
        System.out.println(loadeduser.getUsername());
    }
}
