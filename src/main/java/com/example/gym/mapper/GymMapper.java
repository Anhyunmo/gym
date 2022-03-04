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
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "width" , ignore = true)
    @Mapping(target = "height", ignore = true)
    @Mapping(target = "price", ignore = true)
    @Mapping(target = "img", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Gym insertRequestToGym(GymInsertDTO gymInsertDTO);

}
