package com.profile.technicaltest.infra.repository;

import com.profile.technicaltest.domain.model.Price;
import com.profile.technicaltest.domain.repository.PriceRepository;
import com.profile.technicaltest.infra.repository.entity.PriceEntity;
import com.profile.technicaltest.infra.repository.jpa.PriceJpaH2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Primary
public class PriceRepositoryImpl implements PriceRepository {


    private final PriceJpaH2Repository dataRepository;

    @Autowired
    public PriceRepositoryImpl(final PriceJpaH2Repository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public Optional<Price> findActiveByProduct(LocalDateTime date, Integer productId, Integer brandId) {

        return dataRepository.findActiveByProduct(date, productId, brandId)
                .stream()
                .map(PriceEntity::toDomain)
                .findFirst();
    }
}
