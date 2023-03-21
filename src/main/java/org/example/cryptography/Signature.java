package org.example.cryptography;


import org.example.cryptography.KeyCreator.KeyAccess;

import java.security.KeyPair;
import java.util.Base64;

public class Signature {


    private java.security.Signature signature;

    private KeyPair keyPair;

    public Signature(String hashUsername) {
        try {
          keyPair = new KeyPair(KeyAccess.getPublicKey(hashUsername), KeyAccess.getPrivateKey(hashUsername));
          signature = java.security.Signature.getInstance( "SHA256WithRSA" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * sign()
     */
    public String sign( String data ) {
        try {
            signature.initSign( keyPair.getPrivate() );
            signature.update( data.getBytes() );
            return Base64.getEncoder().encodeToString( signature.sign() );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * verify()
     */
    public boolean verify( String data, String signatureString ) {
        try {
            signature.initVerify(keyPair.getPublic());
            signature.update( data.getBytes() );
            return signature.verify( Base64.getDecoder().decode(signatureString) );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




}
