package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private String userName;
    private String passwordHash;
    private String role;

    public static class Role{
        public static final String DONOR = "DONOR";
        public static final String ORGANIZER = "ORGANIZER";
        public static final String BENEFICIARY = "BENEFICIARY";
    }
}
