package com.analytics.data.repository;

import com.analytics.data.entity.CarPriceAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarPriceAnalyticsRepository extends JpaRepository<CarPriceAnalyticsEntity, Long> {

    Optional<CarPriceAnalyticsEntity> findByPrice(Double price);
}
