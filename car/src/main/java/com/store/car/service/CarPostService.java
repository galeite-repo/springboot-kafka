package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    void newPostDetails(CarPostDTO carPostDTO);
    void changeCarSale(CarPostDTO carPostDTO, Long postId);
    void removeCarSale(Long postId);
    List<CarPostDTO> getCarSales();



}
