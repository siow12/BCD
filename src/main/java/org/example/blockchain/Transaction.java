package org.example.blockchain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction implements Serializable{
    private String from;
    private String to;
    private long timestamp;
    private String signature;
    private Object data;
}
