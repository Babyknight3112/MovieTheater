package com.movietheater.controller;

import com.movietheater.entity.dto.promotion_management.PromotionCreation;
import com.movietheater.entity.dto.promotion_management.PromotionResponse;
import com.movietheater.service.PromotionManagementService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/PM")
public class PromotionManagementController {

    private final PromotionManagementService promotionManagementService;

    public PromotionManagementController(PromotionManagementService promotionManagementService) {
        this.promotionManagementService = promotionManagementService;
    }

    @GetMapping("/promotion/id/{id}")
    public PromotionResponse getByPromotionId(@PathVariable("id") int promotionId){
        return promotionManagementService.getByPromotionId(promotionId);
    }

    @GetMapping("/promotion/title/{title}")
    public List<PromotionResponse> getByTitleWildcard(@PathVariable("title") String title){
        return promotionManagementService.getByTitleWildcard(title);
    }

    @GetMapping("/promotion/detail/{detail}")
    public List<PromotionResponse> getByDetailWildcard(@PathVariable("detail") String detail){
        return promotionManagementService.getByDetailWildcard(detail);
    }

    @GetMapping("/promotion")
    public List<PromotionResponse> getAllPromotion(){
        return promotionManagementService.getAllPromotion();
    }

    @PostMapping("/add")
    public String addPromotion(@Valid @RequestBody PromotionCreation promotionCreation){
        return promotionManagementService.addPromotion(promotionCreation);
    }

    @PutMapping("/update/id/{id}")
    public String updatePromotion(@PathVariable("id") int promotionId, @Valid @RequestBody PromotionCreation promotionCreation){
        return promotionManagementService.updatePromotion(promotionId, promotionCreation);
    }

    @DeleteMapping("/delete/id/{id}")
    public String deletePromotion(@PathVariable("id") int promotionId){
        return promotionManagementService.deletePromotion(promotionId);
    }

}
