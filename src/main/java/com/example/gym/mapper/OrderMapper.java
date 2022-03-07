package com.example.gym.mapper;

import com.example.gym.domain.Order;
import com.example.gym.dto.OrderUpsertDTO;
import org.mapstruct.*;

@Mapper
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "gym.id", source = "gymId")
    @Mapping(target = "member.id", source = "memberId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Order orderInsertRequestToOrder(OrderUpsertDTO orderUpsertDTO);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "gym.id", source = "id")
    @Mapping(target = "gym.id", source = "gymId")
    @Mapping(target = "member.id", source = "memberId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Order orderUpdateRequestToOrder(OrderUpsertDTO orderUpsertDTO);
}
