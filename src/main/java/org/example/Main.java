package org.example;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.out.println("Hello world!");
        Test t = new Test();
        t.setName("etst");
//
//        var db = DBSingleton.getDb(Test.class);
//
//        db.getEntityStore().add(t);
//
//        db.save();
//
//        System.out.println(db.getEntityStore());

        //Create Block


        //Add Transaction

        //Finalize Block
        System.out.println(t.getName());

    }
}

@Data
class Test implements Serializable {
    private String name;
}