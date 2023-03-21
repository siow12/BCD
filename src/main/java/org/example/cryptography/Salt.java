package org.example.cryptography;

import org.apache.commons.codec.binary.Hex;

import java.security.SecureRandom;
import java.util.Base64;

public class Salt {

    public static void main(String[] args) {


        byte[] salt = Salt.get( 16 );
        System.out.println( "encoded:"+ Base64.getEncoder().encodeToString( salt ) );
        System.out.println( "hex:"+ String.valueOf(Hex.encodeHex(salt)) );
    }


    //get(int)
    public static byte[] get(int bit)
    {
        SecureRandom sr = new SecureRandom();
        byte[] b = new byte[ bit ];
        sr.nextBytes( b );
        return b;
    }
}

