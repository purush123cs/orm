package com.example.orm.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "order_record")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_record_id")
    private Long orderRecordId;

    @Column(name = "purchase_transaction_id")
    private Long purchaseTransactionId;

    @Column(name = "purchase_date")
    private ZonedDateTime purchaseDate;

    @Column(name = "time_zone")
    private String timeZone;

    @Column(name = "total", precision = 11, scale = 3)
    private BigDecimal total;

    @Column(name = "total_without_charges", precision = 11, scale = 3)
    private BigDecimal totalWithoutCharges;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "total_without_discounts", precision = 11, scale = 3)
    private BigDecimal totalWithoutDiscounts;

    @OneToMany(mappedBy = "orderRecordEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private Set<VoucherEntity> voucherEntityList = new HashSet<>();

    public void addVoucherRecord(VoucherEntity voucherEntity) {
        voucherEntityList.add(voucherEntity);
        voucherEntity.setOrderRecordEntity(this);
    }

}
