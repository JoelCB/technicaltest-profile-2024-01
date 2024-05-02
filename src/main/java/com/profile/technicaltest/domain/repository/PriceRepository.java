package com.profile.technicaltest.domain.repository;

import com.profile.technicaltest.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findActiveByProduct(LocalDateTime date, Integer productId, Integer brandId);

}
