package com.profile.technicaltest.infra.repository.entity;

import com.profile.technicaltest.domain.model.Price;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity(name = "Price")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceEntity implements DomainTranslatable<Price>{

    @Id
    @Column(name = "priceList")
    private Integer priceList;

    @Column(name = "brandId")
    private Integer brandId;

    @Column(name = "productId")
    private Integer productId;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency")
    private String currency;

    @Override
    public Price toDomain() {

        return Price.builder()
                .priceList(priceList)
                .brandId(brandId)
                .productId(productId)
                .priority(priority)
                .startDate(startDate)
                .endDate(endDate)
                .amount(amount)
                .currency(currency)
                .build();
    }
}

