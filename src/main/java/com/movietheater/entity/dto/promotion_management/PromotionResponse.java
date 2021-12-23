package com.movietheater.entity.dto.promotion_management;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PromotionResponse {
    private  int promotionId;
    private String title;
    private LocalDate startTime;
    private LocalDate endTime;
    private  int discountLevel;
    private String detail;
}
