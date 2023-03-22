package org.example.cryptography.KeyCreator;

import org.example.cryptography.Configuration;
import org.example.cryptography.Hasher;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class KeyPairService {

    private KeyPairGenerator keygen;
    private KeyPair keyPair;

    public static void create(String userName) {
        try {
            String hashUserName = Hasher.hashSHA256(userName);
            KeyPairGenerator keygen = KeyPairGenerator.getInstance(Configuration.RSA_ALGORITHM);
            keygen.initialize(1024, new SecureRandom());

            KeyPair keyPair = keygen.generateKeyPair();

            PublicKey pubkey = keyPair.getPublic();
            PrivateKey prikey = keyPair.getPrivate();

            put( pubkey.getEncoded(), Configuration.KEY_PAIR_FILE_PATH + hashUserName + Configuration.PUBLICKEY );
            put( prikey.getEncoded(), Configuration.KEY_PAIR_FILE_PATH + hashUserName + Configuration.PRIVATEKEY );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void put( byte[] keyBytes, String location ) {
        File f = new File( location );
        f.getParentFile().mkdirs();
        try {
            Files.write(Paths.get(location), keyBytes, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PublicKey getPublicKey(String userName) throws Exception {
        String hashUserName = Hasher.hashSHA512(userName);
        byte[] keyBytes = Files.readAllBytes(Paths.get(Configuration.KEY_PAIR_FILE_PATH + hashUserName + Configuration.PUBLICKEY));
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance(Configuration.RSA_ALGORITHM).generatePublic(spec);
    }

    public static PrivateKey getPrivateKey(String userName) throws Exception {
        String hashUserName = Hasher.hashSHA512(userName);
        byte[] keyBytes = Files.readAllBytes(Paths.get(Configuration.KEY_PAIR_FILE_PATH + hashUserName + Configuration.PRIVATEKEY));
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance(Configuration.RSA_ALGORITHM).generatePrivate(spec);
    }
}
