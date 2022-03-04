package com.example.gym.dto;

import com.example.gym.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderUpsertDTO {

    @NotNull
    private Date startDate;

    @NotNull
    private Date finishDate;

    @NotNull
    private Order.Status status;

    private List<MemberUpsertDTO> members;

    private List<GymUpsertDTO> gyms;
}
