package org.example.blockchain;

import org.example.cryptography.Hasher;
import org.example.cryptography.MerkleTree;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Block implements Serializable {

    private Header header;
    private Transaction tranx;

    public Block(String previousHash) {
        this.header = new Header();
        this.header.previousHash = previousHash;
        this.header.timeStamp = new Timestamp(System.currentTimeMillis()).getTime();
        this.header.batch_id = 10000;
        this.header.involvedPerson = null;
        this.header.merkleRootStr = null;
        byte[] blockBytes = getBytes(this);
        this.header.currentHash = Hasher.hash(blockBytes, "SHA-256");
    }

    public Block(int index, String previousHash, long batch_id, String username, String nextStepUser, Transaction tranx, String merkleRootStr) {
        this.header = new Header();
        this.header.index = index;
        this.header.previousHash = previousHash;
        this.header.batch_id = batch_id;
        this.header.involvedPerson = new ArrayList<>();
        this.header.involvedPerson.add(username);
        this.header.involvedPerson.add(nextStepUser);
        this.header.timeStamp = new Timestamp(System.currentTimeMillis()).getTime();
        this.header.merkleRootStr = merkleRootStr;
        this.tranx = tranx;
        byte[] blockBytes = getBytes(this);
        this.header.currentHash = Hasher.hash(blockBytes, "SHA-256");
    }

    public void setTranx(Transaction tranx) {
        this.tranx = tranx;
    }

    public Transaction getTranx() {
        return tranx;
    }

    public Header getHeader() {
        return header;
    }

    public class Header implements Serializable {

        // define properties
        private int index;
        private String currentHash;
        private String previousHash;
        private long timeStamp;
        private String merkleRootStr;

        //The order batch id and involved person are added to the header
        private long batch_id;
        private ArrayList<String> involvedPerson;

        //get set methods...
        public String getMerkleRootStr() {
            return merkleRootStr;
        }

        public void setMerkleRootStr(String merkleRootStr) {
            this.merkleRootStr = merkleRootStr;
        }

        public void setMerkleRootStr(List<Object> tranxLst) {
            MerkleTree mt = MerkleTree.getInstance(tranxLst);
            mt.build();
            this.merkleRootStr = mt.getRoot();
        }

        public long getBatch_id() {
            return batch_id;
        }

        public void setBatch_id(int batch_id) {
            this.batch_id = batch_id;
        }

        public ArrayList<String> getInvolvedPerson() {
            return involvedPerson;
        }

        public void setInvolvedPerson(ArrayList<String> involvedPerson) {
            this.involvedPerson = involvedPerson;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return "Header{" + "index=" + index + ", currentHash=" + currentHash + ", previousHash=" + previousHash + ", timeStamp=" + timeStamp + ", merkleRootStr=" + merkleRootStr + ", batch_id=" + batch_id + ", involvedPerson=" + involvedPerson + '}';
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getCurrentHash() {
            return currentHash;
        }

        public void setCurrentHash(String currentHash) {
            this.currentHash = currentHash;
        }

        public String getPreviousHash() {
            return previousHash;
        }

        public void setPreviousHash(String previousHash) {
            this.previousHash = previousHash;
        }

        public long getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
        }


    }


    private byte[] getBytes(Block block) {

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(baos);
        ) {
            out.writeObject(block);
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public String toString() {
        return "Block [header=" + header + ", tranx=" + tranx + "]";
    }

}
