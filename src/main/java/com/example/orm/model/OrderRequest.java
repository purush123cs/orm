package com.example.orm.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private String firstName;
    private String lastName;
    private List<VoucherRequest> vouchers;

}
