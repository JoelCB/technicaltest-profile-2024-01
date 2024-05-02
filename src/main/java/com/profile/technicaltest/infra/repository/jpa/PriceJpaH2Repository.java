package com.profile.technicaltest.infra.repository.jpa;

import com.profile.technicaltest.infra.repository.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface PriceJpaH2Repository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM Price p " +
            "WHERE p.startDate <= ?1 AND p.endDate >= ?1 AND p.productId = ?2 AND p.brandId = ?3 " +
            "ORDER BY priority DESC LIMIT 1")
    List<PriceEntity> findActiveByProduct(LocalDateTime date, Integer productId, Integer brandId);

}
