package com.example.orm.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class VoucherDTO {

    private String productName;

}
