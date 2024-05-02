package com.profile.technicaltest.application.response;

import com.profile.technicaltest.domain.model.Price;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchPriceResponse {

    private Integer productId;
    private Integer brandId;
    private Integer priceList;
    private Float price;
    private String curr;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public static SearchPriceResponse fromDomain(Price price) {

        return SearchPriceResponse.builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .priceList(price.getPriceList())
                .price(price.getAmount().floatValue())
                .curr(price.getCurrency())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .build();
    }
}
