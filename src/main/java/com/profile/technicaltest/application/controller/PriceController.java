package com.profile.technicaltest.application.controller;

import com.profile.technicaltest.application.response.SearchPriceResponse;
import com.profile.technicaltest.domain.exception.NotFoundException;
import com.profile.technicaltest.domain.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/prices")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }


    @GetMapping
    public SearchPriceResponse search(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                                      @RequestParam Integer productId,
                                      @RequestParam Integer brandId) throws NotFoundException {

        return SearchPriceResponse.fromDomain(priceService.searchPrice(date, productId, brandId));
    }

}
