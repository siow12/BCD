package org.example.model.transaction;


import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampaignStatementTransactionData implements Serializable {
    private long campaignId;

    private Double totalAsset;
    private Double totalLiabilities;
    private Double totalNetAssets;
    private Double totalNetAssetsAndLiabilities;
    private Double totalDonationCollectionAmount;
    private Double finalBalance;

    public String getDetail() {

        return "\n" +
                "--Final Statement--" + "\n" +
                "Total Assets: " + totalAsset + "\n" +
                "Total Liabilities: " + totalLiabilities + "\n" +
                "Total Net Assets: " + totalNetAssets + "\n" +
                "Total Net Assess And Liabilities: " + totalNetAssetsAndLiabilities + "\n" +
                "Total Donation Collection Amount: " + totalDonationCollectionAmount + "\n" +
                "Final Balance: " + finalBalance + "\n";
    }


}
