package com.example.gym.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GymUpsertDTO {

    @NotNull
    private String name;

    @NotNull
    private int phone;

    private String address;

    private double width;

    private double height;

    private String img;

}
