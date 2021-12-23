package com.movietheater.entity.dto.promotion_management;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PromotionCreation {

    @NotEmpty(message = "missing title")
    private String title;

    @NotNull(message = "missing start time")
    private LocalDate startTime;

    @NotNull(message = "missing end time")
    private LocalDate endTime;

    @NotNull(message = "missing discount level")
    @DecimalMin(value = "0", message = "must be greater than 0")
    @DecimalMax(value = "100", message = "must be lesser than 100")
    private  int discountLevel;

    @NotEmpty(message = "missing detail")
    private String detail;

    @NotEmpty(message = "missing image")
    private String image;
}
