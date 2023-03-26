package org.example.blockchain;

import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction implements Serializable{
    private long transactionId;
    private String from;
    private String to;
    private long timestamp;
    @ToString.Exclude
    private String signature;
    private Object data;
}
