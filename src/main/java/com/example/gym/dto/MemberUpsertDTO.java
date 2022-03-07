package com.example.gym.dto;

import com.sun.istack.NotNull;

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
