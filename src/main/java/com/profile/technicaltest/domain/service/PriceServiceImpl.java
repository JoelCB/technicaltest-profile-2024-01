package com.profile.technicaltest.domain.service;

import com.profile.technicaltest.domain.exception.NotFoundException;
import com.profile.technicaltest.domain.model.Price;
import com.profile.technicaltest.domain.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price searchPrice(LocalDateTime date, Integer productId, Integer brandId) throws NotFoundException {

        return priceRepository.findActiveByProduct(date, productId, brandId)
                .orElseThrow(NotFoundException::new);
    }
}
