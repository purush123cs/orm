package com.example.orm.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "voucher")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoucherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "voucher_record_id")
    private Long voucherRecordId;

    @Column(name = "voucher_transaction_id")
    private Long voucherTransactionId;

    @Column(name = "purchase_transaction_id")
    private Long purchaseTransactionId;

    @Column(name = "voucher_transaction_number")
    private String voucherTransactionNumber;

    @Column(name = "original_price", precision = 11, scale = 3)
    private BigDecimal originalPrice;

    @Column(name = "sold_price", precision = 11, scale = 3)
    private BigDecimal soldPrice;

    @Column(name = "price_guarantee")
    private LocalDateTime priceGuarantee;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_currency")
    private String supplierCurrency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_record_id", referencedColumnName = "order_record_id")
    private OrderRecordEntity orderRecordEntity;

}
