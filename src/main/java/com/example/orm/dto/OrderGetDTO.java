package com.example.orm.dto;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder(toBuilder = true)
public class OrderGetDTO {

    private String firstName;
    private String lastName;
    private Set<VoucherDTO> vouchers;

}
