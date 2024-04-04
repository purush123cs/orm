package com.example.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.orm.entity.OrderRecordEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderRecordEntity, Long>{

}