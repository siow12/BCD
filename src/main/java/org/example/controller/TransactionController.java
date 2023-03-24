package org.example.controller;


import org.example.DB;
import org.example.DBSingleton;
import org.example.blockchain.Block;
import org.example.blockchain.Blockchain;
import org.example.blockchain.Transaction;
import org.example.cryptography.SignatureService;
import org.example.exception.DataNotFoundException;
import org.example.model.User;
import org.example.model.transaction.DonationFromDonorTransactionData;
import org.example.model.transaction.DonationFromOrgToBnfcyTransactionData;

import java.time.Instant;
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

    //Collect donation from donor
    public static void addDonationFromDonor(User from, String toCampaignId, double amount) throws DataNotFoundException{
        Optional<Block> campaignOptional = Blockchain.findBlockByCampaignId(Long.parseLong(toCampaignId));
        if (campaignOptional.isEmpty()) {
            throw new DataNotFoundException("Campaign Not Found");
        }
        Block campaign = campaignOptional.get();

        Transaction transaction = Transaction.builder()
                                             .from(from.getUserName())
                                             .to(toCampaignId)
                                             .timestamp(Instant.now()
                                                               .toEpochMilli())
                                             .build();

        var transactionData = DonationFromDonorTransactionData.builder()
                                                                                           .amount(amount)
                                                                                           .build();
        transaction.setData(transactionData);
        transaction.setSignature(SignatureService.sign(transaction.toString(), from.getUserName()));
        campaign.getTransactions().add(transaction);
        campaign.finalizeHeader();
        db.save();
    }

    //Give the donation to beneficiary
    public static void addDonationToBnfcy(User from, String beneficiary, String campaignId, double amount) throws DataNotFoundException{
        Optional<Block> campaignOptional = Blockchain.findBlockByCampaignId(Long.parseLong(campaignId));
        if (campaignOptional.isEmpty()) {
            throw new DataNotFoundException("Campaign Not Found");
        }
        Block campaign = campaignOptional.get();

        Transaction transaction = Transaction.builder()
                                             .from(from.getUserName())
                                             .to(beneficiary)
                                             .timestamp(Instant.now()
                                                               .toEpochMilli())
                                             .build();

        var transactionData = DonationFromOrgToBnfcyTransactionData.builder()//TODO NGO TO BNFCY
                                                                   .amount(amount)
                                                                   .build();
        transaction.setData(transactionData);
        transaction.setSignature(SignatureService.sign(transaction.toString(), from.getUserName()));
        campaign.getTransactions().add(transaction);
        campaign.finalizeHeader();
        db.save();
    }


    public static List<Transaction> findAllTransactionByCampaignIdAndDonor(long campaignId,User donor) throws DataNotFoundException {
        Optional<Block> campaignOptional = Blockchain.findBlockByCampaignId(campaignId);
        if (campaignOptional.isEmpty()) {
            throw new DataNotFoundException("Campaign Not Found");
        }
        Block campaign = campaignOptional.get();

        return campaign.getTransactions().stream().filter(t->t.getFrom().equals(donor.getUserName())).toList();
    }
}