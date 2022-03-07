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
public class MemberLoginDTO {

    @NotNull
    private String email;

    @NotNull
    private String password;
}
