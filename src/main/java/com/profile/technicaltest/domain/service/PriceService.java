package com.profile.technicaltest.domain.service;

import com.profile.technicaltest.domain.exception.NotFoundException;
import com.profile.technicaltest.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceService {

    Price searchPrice(LocalDateTime date, Integer productId, Integer brandId) throws NotFoundException;

}
