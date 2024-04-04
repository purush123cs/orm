package com.example.orm.service;

import com.example.orm.dto.OrderGetDTO;
import com.example.orm.dto.OrderPostDTO;
import com.example.orm.dto.VoucherDTO;
import com.example.orm.entity.OrderRecordEntity;
import com.example.orm.entity.VoucherEntity;
import com.example.orm.model.OrderRequest;
import com.example.orm.model.VoucherRequest;
import com.example.orm.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public OrderPostDTO createOrder(OrderRequest orderRequest){

        OrderRecordEntity orderEntityToBeSaved = OrderRecordEntity.builder()
                .firstName(orderRequest.getFirstName())
                .lastName(orderRequest.getLastName())
                .build();

        List<VoucherRequest> voucherRequestList = orderRequest.getVouchers();
        if (voucherRequestList != null && voucherRequestList.size() > 0) {
            voucherRequestList.forEach(voucherRequest -> {
                VoucherEntity voucherEntity = VoucherEntity.builder()
                        .productName(voucherRequest.getProductName())
                        .build();
                orderEntityToBeSaved.addVoucherRecord(voucherEntity);
            });
        }

        OrderRecordEntity savedOrderEntity =  orderRepository.save(orderEntityToBeSaved);

        OrderPostDTO orderPostDTO = OrderPostDTO.builder()
                .orderId(savedOrderEntity.getOrderRecordId())
                .message("Order saved successfully")
                .build();

        return orderPostDTO;

    }

    public OrderGetDTO getOrder(Long orderId) {

        OrderRecordEntity orderRecordEntity = null;
        Optional<OrderRecordEntity> orderRecordEntityOptional = orderRepository.findById(orderId);
        orderRecordEntity = orderRecordEntityOptional.get();

        Set<VoucherEntity> voucherEntityList = orderRecordEntity.getVoucherEntityList();
        Set<VoucherDTO> voucherDTOs = new HashSet<>();
        if (voucherEntityList != null && voucherEntityList.size() > 0) {
            voucherEntityList.forEach(voucherEntity -> {
                VoucherDTO voucherDTO = VoucherDTO.builder()
                        .productName(voucherEntity.getProductName())
                        .build();
                voucherDTOs.add(voucherDTO);
            });
        }

        OrderGetDTO orderGetDTO = OrderGetDTO.builder()
                .firstName(orderRecordEntity.getFirstName())
                .lastName(orderRecordEntity.getLastName())
                .vouchers(voucherDTOs)
                .build();


        return orderGetDTO;

    }
}
