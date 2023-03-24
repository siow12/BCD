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

        //Basic block header data
        private int index;
        private String currentHash;
        private String previousHash;
        private long timeStamp;
        private String merkleRootStr;

        //Campaign data
        private long campaignId;
        private String campaignName;
        private String description;
        private String address;
        private String organizerName;
        private String beneficiary;
        private long startDate;
        private long endDate;
        private Double expectedDonationAmount;

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
