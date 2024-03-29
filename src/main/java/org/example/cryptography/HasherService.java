package org.example.cryptography;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

public class HasherService {

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