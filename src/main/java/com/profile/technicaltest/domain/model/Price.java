package com.profile.technicaltest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    private Integer priceList;

    private Integer brandId;

    private Integer productId;

    private Integer priority;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private BigDecimal amount;

    private String currency;

}
