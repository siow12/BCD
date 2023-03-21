package org.example.cryptography;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @author kimlee
 *
 * @implNote
 * To generate merkle root based on the given transaction-list.
 *
 */

public class MerkleTree {

    private List<Object> tranxLst;
    private String root = "0";

    public String getRoot() {
        return root;
    }

    /**
     * @implNote
     * Set the transaction list to the MerkleTree object.
     *
     * @param tranxLst
     */
    private MerkleTree(List<Object> tranxLst) {
        super();
        this.tranxLst = tranxLst;
    }
    /**
     * Design pattern: Singleton
     */
    private static MerkleTree instance;
    public static MerkleTree getInstance( List<Object> tranxLst ) {
        if( instance == null ) {
            return new MerkleTree(tranxLst);
        }
        return instance;
    }


    public void build() {

        List<Object> tempLst = new ArrayList<>();

        for (Object tranx : this.tranxLst) {
            tempLst.add(Hasher.hash(String.valueOf(tranx),"SHA-256"));
        }

        List<String> hashes = genTranxHashLst( tempLst );
        while(  hashes.size() != 1 ) {
            hashes = genTranxHashLst1( hashes );
        }
        this.root = hashes.get(0);
    }

    /**
     * @implNote
     * Generate hashes of transactions
     *
     * @implSpec
     * - genTranxHashLst(List<String>) : List<String>
     */
    private List<String> genTranxHashLst(List<Object> tranxLst) {
        List<String> hashLst = new ArrayList<>();
        int i = 0;
        while( i < tranxLst.size() ) {

            Object left = tranxLst.get(i);
            i++;

            Object right = "";
            if( i != tranxLst.size() ) right = tranxLst.get(i);

            String hash = Hasher.hash(String.valueOf(left).concat(String.valueOf(right)) , "SHA-256");
            hashLst.add(hash);
            i++;
        }
        return hashLst;
    }

    private List<String> genTranxHashLst1(List<String> tranxLst) {
        List<String> hashLst = new ArrayList<>();
        int i = 0;
        while( i < tranxLst.size() ) {

            String left = tranxLst.get(i);
            i++;

            String right = "";
            if( i != tranxLst.size() ) right = tranxLst.get(i);

            String hash = Hasher.hash(left.concat(right) , "SHA-256");
            hashLst.add(hash);
            i++;
        }
        return hashLst;
    }


}
