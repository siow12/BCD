package org.example.cryptography.KeyCreator;

import org.example.cryptography.Configuration;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyAccess {

    /**
     * read the key
     */

    public static PublicKey getPublicKey(String hashUserName) throws Exception{
        byte[] keyBytes = Files.readAllBytes( Paths.get( Configuration.KEY_PAIR_FILE_PATH + hashUserName + Configuration.PUBLICKEY ) );
        X509EncodedKeySpec spec = new X509EncodedKeySpec( keyBytes );
        return KeyFactory.getInstance( Configuration.RSA_ALGORITHM).generatePublic(spec);
    }

    public static PrivateKey getPrivateKey(String hashUserName) throws Exception{
        byte[] keyBytes = Files.readAllBytes(Paths.get( Configuration.KEY_PAIR_FILE_PATH + hashUserName + Configuration.PRIVATEKEY ));
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec( keyBytes );
        return KeyFactory.getInstance(Configuration.RSA_ALGORITHM).generatePrivate(spec);
    }

}
