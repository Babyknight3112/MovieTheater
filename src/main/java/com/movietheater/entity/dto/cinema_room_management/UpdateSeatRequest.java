package com.movietheater.entity.dto.cinema_room_management;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateSeatRequest {

    @NotNull(message = "missing state")
    private int state;
}
