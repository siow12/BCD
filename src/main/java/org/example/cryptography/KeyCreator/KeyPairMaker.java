package org.example.cryptography.KeyCreator;


import org.example.cryptography.Configuration;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.*;
import java.util.Base64;

public class KeyPairMaker {

    private KeyPairGenerator keygen;
    private KeyPair keyPair;

    //constructor
    public KeyPairMaker() {
        try {
            keygen = KeyPairGenerator.getInstance( Configuration.RSA_ALGORITHM);
            keygen.initialize( 1024 , new SecureRandom() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * create()
     */
    public static void create(String hashUserName) {
        try {
            //KeyPairMaker object
            KeyPairMaker maker = new KeyPairMaker();
            //generate keypair
            maker.keyPair = maker.keygen.generateKeyPair();
            //get publickey
            PublicKey pubkey = maker.keyPair.getPublic();
            //get privatekey
            PrivateKey prikey = maker.keyPair.getPrivate();

            //view
            System.out.println( "Public key: "+
                    Base64.getEncoder().encodeToString( pubkey.getEncoded() ) );
            System.out.println( "Private key: "+
                    Base64.getEncoder().encodeToString( prikey.getEncoded() ) );

            //keystore
            put( pubkey.getEncoded(), Configuration.KEY_PAIR_FILE_PATH + hashUserName + Configuration.PUBLICKEY );
            put( prikey.getEncoded(), Configuration.KEY_PAIR_FILE_PATH + hashUserName + Configuration.PRIVATEKEY );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * put()
     */
    private static void put( byte[] keyBytes, String location ) {
        File f = new File( location );
        f.getParentFile().mkdirs();
        try {
            Files.write(Paths.get(location), keyBytes, StandardOpenOption.CREATE);
            System.out.println( "Done..." );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}