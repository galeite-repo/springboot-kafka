package com.analytics.data.service;

import com.analytics.data.dto.CarPostDTO;
import com.analytics.data.entity.BrandAnalyticsEntity;
import com.analytics.data.entity.CarModelAnalyticsEntity;
import com.analytics.data.entity.CarPriceAnalyticsEntity;
import com.analytics.data.repository.BrandAnalyticsRepository;
import com.analytics.data.repository.CarModelAnalyticsRepository;
import com.analytics.data.repository.CarPriceAnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService {

    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepository;

    @Autowired
    private CarModelAnalyticsRepository carModelAnalyticsRepository;

    @Autowired
    private CarPriceAnalyticsRepository carPriceAnalyticsRepository;

    @Override
    public void saveDataAnalytics(CarPostDTO carPostDTO) {
        saveBrandAnalytics(carPostDTO.getBrand());
        saveCarModelAnalytics(carPostDTO.getModel());
        saveCarPriceAnalytics(carPostDTO.getModel(), carPostDTO.getPrice());

    }

    private void saveCarPriceAnalytics(String model, Double price) {
        CarPriceAnalyticsEntity carPriceAnalyticsEntity = new CarPriceAnalyticsEntity();
        carPriceAnalyticsEntity.setModel(model);
        carPriceAnalyticsEntity.setPrice(price);
        carPriceAnalyticsRepository.save(carPriceAnalyticsEntity);
    }


    private void saveCarModelAnalytics(String model) {
        CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity();

        carModelAnalyticsRepository.findByModel(model).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts() + 1);
            carModelAnalyticsRepository.save(item);
        }, () -> {
            carModelAnalyticsEntity.setModel(model);
            carModelAnalyticsEntity.setPosts(1L);
            carModelAnalyticsRepository.save(carModelAnalyticsEntity);

        });
    }


    private void saveBrandAnalytics(String brand) {

        BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity();

        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item -> {
                    item.setPosts(item.getPosts() + 1);
                    brandAnalyticsRepository.save(item);
                }, () -> {
                    brandAnalyticsEntity.setBrand(brand);
                    brandAnalyticsEntity.setPosts(1L);
                    brandAnalyticsRepository.save(brandAnalyticsEntity);
                }
        );

    }

}
