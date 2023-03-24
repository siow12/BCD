package org.example.model.transaction;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonationFromOrgToBnfcyTransactionData implements Serializable {
    private Double amount;
    private String beneficiaryName;
    private String address;
    private String phone;
    private String status;

    public String getDetail(){
        return null;
    }
}
