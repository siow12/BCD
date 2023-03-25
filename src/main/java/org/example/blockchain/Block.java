package org.example.blockchain;

import lombok.Data;
import org.example.cryptography.HasherService;
import org.example.cryptography.MerkleTreeService;
import org.example.model.transaction.DonationFromDonorTransactionData;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

    public Block(int index, String previousHash, long campaignId, String campaignName, String description, String address, String organizerName, String beneficiary, Double expectedAmount, long startDate, long endDate, List<Transaction> transactions) {
        this.header = new Header();
        this.header.index = index;
        this.header.previousHash = previousHash;
        this.header.campaignId = campaignId;
        this.header.campaignName = campaignName;
        this.header.description = description;
        this.header.address = address;
        this.header.organizerName = organizerName;
        this.header.beneficiary = beneficiary;
        this.header.startDate = startDate;
        this.header.endDate = endDate;
        this.header.expectedDonationAmount = expectedAmount;
        this.header.timeStamp = Instant.now().toEpochMilli();
        this.transactions = transactions;
        this.header.finalizeHeader(transactions);
        finalizeBlock();
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

    public void finalizeBlock() {
        byte[] blockBytes = getBytes(this);
        this.header.currentHash = HasherService.hash(blockBytes);
    }

    public void finalizeHeader() {
        this.header.finalizeHeader(this.transactions);
    }

    public String getDetail() {
        StringBuilder builder = new StringBuilder();
        builder.append("Campaign Id: ").append(this.header.campaignId).append("\n")
                .append("Campaign Name: ").append(this.header.campaignName).append("\n")
                .append("Campaign Description: ").append(this.header.description).append("\n")
                .append("Organizer: ").append(this.header.organizerName).append("\n")
                .append("Address: ").append(this.header.address).append("\n")
                .append("Beneficiary: ").append(this.header.beneficiary).append("\n")
                .append("Expected Amount: ").append(this.header.expectedDonationAmount).append("\n")
                .append("Start Date: ").append(getLocalDate(this.header.startDate)).append("\n")
                .append("End Date: ").append(getLocalDate(this.header.endDate)).append("\n")
                .append("Total Collected Amount: ").append(getTotalCollectedAmount()).append("\n");
        return builder.toString();
    }

    public Double getTotalCollectedAmount() {
        return this.transactions.stream()
                .filter(t -> (t.getData() != null) && (t.getData() instanceof DonationFromDonorTransactionData))
                .mapToDouble(d -> ((DonationFromDonorTransactionData) d.getData()).getAmount())
                .sum();
    }

    private LocalDate getLocalDate(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp / 1000);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.toLocalDate();
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

}
