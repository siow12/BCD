package org.example.model.transaction;

import lombok.*;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonationFromDonorTransactionData implements Serializable {
    private Double amount;
    private String donorName;
    private String organizerName;
    private String campaignName;
}
