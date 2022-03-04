package com.example.gym.mapper;

import com.example.gym.domain.Gym;
import com.example.gym.dto.GymInsertDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;

@Mapper
public interface GymMapper {

    GymMapper INSTANCE = Mappers.getMapper(GymMapper.class);



    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Gym insertRequestToGym(GymInsertDTO gymInsertDTO);

}
