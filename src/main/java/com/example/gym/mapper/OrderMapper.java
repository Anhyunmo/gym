package com.example.gym.mapper;

import com.example.gym.domain.Order;
import com.example.gym.dto.OrderUpsertDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "gym.id", source = "gymId")
    @Mapping(target = "member.id", source = "memberId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Order orderInsertRequestToOrder(OrderUpsertDTO orderUpsertDTO);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "gym.id", source = "gymId")
    @Mapping(target = "member.id", source = "memberId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Order orderUpdateRequestToOrder(OrderUpsertDTO orderUpsertDTO);
}
