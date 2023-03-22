package org.example.cryptography;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

public class Hasher {


    public static String hashSHA256(String data)
    {
        String hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update( data.getBytes() );
            byte[] hashBytes = md.digest();
            hash = String.valueOf( Hex.encodeHex(hashBytes) );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    public static String hashSHA512(String data)
    {
        String hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update( data.getBytes() );
            byte[] hashBytes = md.digest();
            hash = String.valueOf( Hex.encodeHex(hashBytes) );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    //overloaded hash( String, String, String ) : String
    public static String hash( String data, String salt, String algorithm ) {
        String hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update( data.getBytes() );
            md.update( salt.getBytes() );
            //digest
            byte[] hashBytes = md.digest();
            hash = String.valueOf( Hex.encodeHex(hashBytes) );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }



    //overloaded hash() for hashing the block object
    public static String hash( byte[] blockBytes) {
        String hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest( blockBytes );
            hash = String.valueOf( Hex.encodeHex(hashBytes) );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

}