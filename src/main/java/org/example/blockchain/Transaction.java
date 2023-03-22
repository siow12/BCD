package org.example.blockchain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


//Todo Transaction Structure
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction implements Serializable{
    private String from;
    private String to;
    private String amount;
    private long timestamp;
    private String signature;
}
