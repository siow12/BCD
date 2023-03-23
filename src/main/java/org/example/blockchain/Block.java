package org.example.blockchain;

import lombok.Data;
import org.example.cryptography.HasherService;
import org.example.cryptography.MerkleTreeService;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class Block implements Serializable {

    private Header header;
    private List<Transaction> transactions = new ArrayList<>();

    public Block(String previousHash) {
        this.header = new Header();
        this.header.previousHash = previousHash;
        this.header.timeStamp = Instant.now().toEpochMilli();
        this.header.campaignId = 10000;
        this.header.merkleRootStr = null;
        finalizeBlock();
    }

    public Block(int index, String previousHash, long campaignId, List<Transaction> transactions) {
        this.header = new Header();
        this.header.index = index;
        this.header.previousHash = previousHash;
        this.header.campaignId = campaignId;
        this.header.timeStamp = Instant.now().toEpochMilli();
        this.transactions = transactions;
        this.header.finalizeHeader(transactions);
        finalizeBlock();
    }


    @Data
    public static class Header implements Serializable {

        // define properties
        private int index;
        private String currentHash;
        private String previousHash;
        private long timeStamp;
        private String merkleRootStr;
        private long campaignId;
        private Double expectedDonationAmount;
        private Double actualDonationAmount;

        public void finalizeHeader(List<Transaction> transactions) {
            this.merkleRootStr = MerkleTreeService.getMerkleRoot(transactions);
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

    public void finalizeBlock(){
        byte[] blockBytes = getBytes(this);
        this.header.currentHash = HasherService.hash(blockBytes);
    }

    public void finalizeHeader(){
        this.header.finalizeHeader(this.transactions);
    }


}
