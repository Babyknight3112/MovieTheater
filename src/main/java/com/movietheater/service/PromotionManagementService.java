package com.movietheater.service;

import com.movietheater.entity.Promotion;
import com.movietheater.entity.dto.promotion_management.PromotionCreation;
import com.movietheater.entity.dto.promotion_management.PromotionResponse;
import com.movietheater.entity.mapper.Mapper;
import com.movietheater.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionManagementService {

    private final PromotionRepository promotionRepository;

    private final Mapper mapper;

    @Autowired
    public PromotionManagementService(PromotionRepository promotionRepository, Mapper mapper) {
        this.promotionRepository = promotionRepository;
        this.mapper = mapper;
    }

    public PromotionResponse getByPromotionId(int promotionId){
        return mapper.toPromotionResponse(promotionRepository.findByPromotionId(promotionId));
    }

    public List<PromotionResponse> getByTitleWildcard(String title){
        return promotionRepository.findByTitleStartingWith(title).stream().map(mapper::toPromotionResponse).collect(Collectors.toList());
    }

    public List<PromotionResponse> getByDetailWildcard(String detail){
        return promotionRepository.findByDetailStartingWith(detail).stream().map(mapper::toPromotionResponse).collect(Collectors.toList());
    }

    public List<PromotionResponse> getAllPromotion(){
        return promotionRepository.findAll().stream().map(mapper::toPromotionResponse).collect(Collectors.toList());
    }

    public String addPromotion(PromotionCreation promotionCreation){
        promotionRepository.save(mapper.toPromotion(promotionCreation));
        return "Successfully add a promotion";
    }

    public String updatePromotion(int promotionId, PromotionCreation promotionCreation){
        Promotion promotion = promotionRepository.findByPromotionId(promotionId);
        mapper.mapPromotion(promotion, promotionCreation);
        promotionRepository.save(promotion);
        return "Successfully update the promotion has id:" + promotionId;
    }

    public String deletePromotion(int promotionId){
        promotionRepository.delete(promotionRepository.findByPromotionId(promotionId));
        return "Successfully delete the promotion has id: " + promotionId;
    }
}
