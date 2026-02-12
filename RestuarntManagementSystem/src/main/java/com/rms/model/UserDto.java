package com.rms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    Long userId;
    String userName;
    String password;
    String email;
    String phoneNumber;
    String address;
    String city;
    String state;
    String country;
    String postalCode;

}
