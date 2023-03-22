package org.example.cryptography;

import org.example.blockchain.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MerkleTreeV2 {
    public static String getMerkleRoot(List<Transaction> transactions){
        List<Object> temp = new ArrayList<>();

        for (Object tranx : transactions) {
            temp.add(Hasher.hashSHA256(String.valueOf(tranx)));
        }

        List<String> hashes = genTranxHashLst( temp );
        while(  hashes.size() != 1 ) {
            hashes = genTranxHashLst1( hashes );
        }
        return hashes.get(0);
    }

    private static List<String> genTranxHashLst(List<Object> tranxLst) {
        List<String> hashLst = new ArrayList<>();
        int i = 0;
        while( i < tranxLst.size() ) {

            Object left = tranxLst.get(i);
            i++;

            Object right = "";
            if( i != tranxLst.size() ) right = tranxLst.get(i);

            String hash = Hasher.hashSHA256(String.valueOf(left).concat(String.valueOf(right)));
            hashLst.add(hash);
            i++;
        }
        return hashLst;
    }

    private static List<String> genTranxHashLst1(List<String> tranxLst) {
        List<String> hashLst = new ArrayList<>();
        int i = 0;
        while( i < tranxLst.size() ) {

            String left = tranxLst.get(i);
            i++;

            String right = "";
            if( i != tranxLst.size() ) right = tranxLst.get(i);

            String hash = Hasher.hashSHA256(left.concat(right));
            hashLst.add(hash);
            i++;
        }
        return hashLst;
    }
}
