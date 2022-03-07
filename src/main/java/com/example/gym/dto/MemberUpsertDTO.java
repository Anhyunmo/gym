package com.example.gym.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberUpsertDTO {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private int phone;

    @NotNull
    private String password;


}
