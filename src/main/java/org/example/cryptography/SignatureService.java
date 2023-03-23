package org.example.cryptography;


import java.security.KeyPair;
import java.util.Base64;

public class SignatureService {

    /**
     * sign()
     */
    public static String sign( String data, String username ) {
        try {
            KeyPair keyPair = new KeyPair(KeyPairService.getPublicKey(username), KeyPairService.getPrivateKey(username));
            java.security.Signature signature = java.security.Signature.getInstance( "SHA256WithRSA" );

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
    public static boolean verify( String data,String username, String signatureString ) {
        try {
            KeyPair keyPair = new KeyPair(KeyPairService.getPublicKey(username), KeyPairService.getPrivateKey(username));
            java.security.Signature signature = java.security.Signature.getInstance( "SHA256WithRSA" );

            signature.initVerify(keyPair.getPublic());
            signature.update( data.getBytes() );
            return signature.verify( Base64.getDecoder().decode(signatureString) );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




}
