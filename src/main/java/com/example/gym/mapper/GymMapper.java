package com.example.gym.mapper;

import com.example.gym.domain.Gym;
import com.example.gym.dto.GymUpsertDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GymMapper {

    GymMapper INSTANCE = Mappers.getMapper(GymMapper.class);



    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Gym insertRequestToGym(GymUpsertDTO gymInsertDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "gym", ignore = true)
    @Mapping(target = "member", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Gym updateRequestToGym(GymUpsertDTO gymInsertDTO, @MappingTarget Gym gym);

}
