package com.rms.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Table(name = "rms_user")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @SequenceGenerator(
            name = "user_sequence_generator",
            sequenceName = "user_sequence_generator",
            allocationSize = 1   // optional: controls how many ids Hibernate pre-fetches
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence_generator"
    )
    @Column(name = "id")
    Long userId;


    @Version
    private Integer version;  // Hibernate will manage versioning
    @Column(name = "USER_NAME", length = 20, nullable = false)
    String userName;
    @Column(name = "PASS_WORD", length = 50, nullable = false)
    String password;
    @Column(name = "EMAIL", length = 20, nullable = false)
    String email;
    @Column(name = "PHONE_NUMBER", length = 10, nullable = false)
    String phoneNumber;
    @Column(name = "ADDRESS", length = 80, nullable = false)
    String address;
    @Column(name = "CITY", length = 10, nullable = false)
    String city;
    @Column(name = "STATE", length = 10, nullable = false)
    String state;
    @Column(name = "COUNTRY", length = 2, nullable = false)
    String country;
    @Column(name = "POSTAL_CODE", length = 10, nullable = false)
    String postalCode;
}
