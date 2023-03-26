package org.example.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.DB;
import org.example.DBSingleton;
import org.example.blockchain.Block;
import org.example.blockchain.Blockchain;
import org.example.blockchain.Transaction;
import org.example.cryptography.AsymmCryptoService;
import org.example.cryptography.SignatureService;
import org.example.exception.CryptographyException;
import org.example.exception.DataNotFoundException;
import org.example.model.User;
import org.example.model.transaction.CampaignStatementTransactionData;
import org.example.model.transaction.DonationFromDonorTransactionData;
import org.example.model.transaction.DonationFromOrgToBnfcyTransactionData;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionController {
    private static DB<Block> db = null;

    static {
        try {
            db = DBSingleton.getDb(Block.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getNewTransactionId(Block block) {
        if (block.getTransactions().size() == 0) {
            return 10000;
        }
        return block.getTransactions().get(block.getTransactions().size() - 1).getTransactionId() + 1;
    }

    //Collect donation from donor
    public static void addDonationFromDonor(User from, long toCampaignId, double amount) throws DataNotFoundException {
        Optional<Block> campaignOptional = Blockchain.findBlockByCampaignId(toCampaignId);
        if (campaignOptional.isEmpty()) {
            throw new DataNotFoundException("Campaign Not Found");
        }
        Block campaign = campaignOptional.get();

        Transaction transaction = Transaction.builder()
                .transactionId(getNewTransactionId(campaign))
                .from(from.getUserName())
                .to(String.valueOf(toCampaignId))
                .timestamp(Instant.now()
                        .toEpochMilli())
                .build();

        var transactionData = DonationFromDonorTransactionData.builder()
                .amount(amount)
                .campaignName(campaign.getHeader().getCampaignName())
                .donorName(from.getUserName())
                .organizerName(campaign.getHeader().getOrganizerName())
                .build();
        transaction.setData(transactionData);
        transaction.setSignature(SignatureService.sign(transaction.toString(), from.getUserName()));
        campaign.getTransactions().add(transaction);
        campaign.finalizeHeader();
        db.save();
    }

    //Give the donation to beneficiary
    public static void addDonationToBnfcy(User from, String beneficiary, String campaignId, double amount, String description, String address, String phone, String status) throws DataNotFoundException, JsonProcessingException, CryptographyException {
        Optional<Block> campaignOptional = Blockchain.findBlockByCampaignId(Long.parseLong(campaignId));
        if (campaignOptional.isEmpty()) {
            throw new DataNotFoundException("Campaign Not Found");
        }
        Block campaign = campaignOptional.get();

        Transaction transaction = Transaction.builder()
                .transactionId(getNewTransactionId(campaign))
                .from(from.getUserName())
                .to(beneficiary)
                .timestamp(Instant.now()
                        .toEpochMilli())
                .build();

        var transactionData = DonationFromOrgToBnfcyTransactionData.builder()//TODO NGO TO BNFCY
                .amount(amount)
                .beneficiaryName(campaign.getHeader().getBeneficiary())
                .description(description)
                .address(address)
                .status(status)
                .phone(phone)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String dataToEncrypt = mapper.writeValueAsString(transactionData);
        String encryptData = AsymmCryptoService.encrypt(dataToEncrypt, beneficiary);

        transaction.setData(encryptData);
        transaction.setSignature(SignatureService.sign(transaction.toString(), from.getUserName()));
        campaign.getTransactions().add(transaction);
        campaign.finalizeHeader();
        db.save();
    }

    public static void generateStatement(User from, Block campaign, CampaignStatementTransactionData transactionData){
        Transaction transaction = Transaction.builder()
                .transactionId(getNewTransactionId(campaign))
                .from(from.getUserName())
                .to(campaign.getHeader().getBeneficiary())
                .data(transactionData)
                .timestamp(Instant.now()
                        .toEpochMilli())
                .build();

        transaction.setSignature(SignatureService.sign(transaction.toString(), from.getUserName()));
        campaign.getTransactions().add(transaction);
        campaign.finalizeHeader();
        db.save();
    }


    public static List<Transaction> findAllTransactionByCampaignIdAndDonor(long campaignId, User donor) throws DataNotFoundException {
        Optional<Block> campaignOptional = Blockchain.findBlockByCampaignId(campaignId);
        if (campaignOptional.isEmpty()) {
            throw new DataNotFoundException("Campaign Not Found");
        }
        Block campaign = campaignOptional.get();

        return campaign.getTransactions()
                .stream()
                .filter(t -> t.getFrom().equals(donor.getUserName()))
                .filter(t -> t.getData() instanceof DonationFromDonorTransactionData)
                .toList();
    }

    public static List<Transaction> findAllTransactionFromDonor(long campaignId) throws DataNotFoundException {
        Optional<Block> campaignOptional = Blockchain.findBlockByCampaignId(campaignId);
        if (campaignOptional.isEmpty()) {
            throw new DataNotFoundException("Campaign Not Found");
        }
        Block campaign = campaignOptional.get();

        return campaign.getTransactions().stream().filter(t -> (t.getData() != null) && (t.getData() instanceof DonationFromDonorTransactionData)).toList();
    }

    public static Optional<Transaction> findTransactionByBlockAndId(long transactionId, Block block) {
        return block.getTransactions().stream().filter(t -> t.getTransactionId() == transactionId).findFirst();
    }

    public static List<Transaction> findAllTransactionToBnfcy(User to) {
        var block = Blockchain.getBlocks()
                .stream()
                .filter(t -> t.getHeader().getBeneficiary().equals(to.getUserName()))
                .toList();

        List<Transaction> transactions = new ArrayList<>();
        block.forEach(b -> {
            transactions.addAll(b.getTransactions());
        });
        return transactions.stream().filter(t -> (t.getTo() != null) && t.getTo().equals(to.getUserName()) && t.getData() instanceof String).toList();
    }

}
