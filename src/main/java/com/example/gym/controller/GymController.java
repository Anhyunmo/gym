package com.example.gym.controller;

import com.example.gym.domain.Gym;
import com.example.gym.dto.GymInsertDTO;
import com.example.gym.mapper.GymMapper;
import com.example.gym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gyms")
public class GymController {

    @Autowired
    GymService gymService;

    @GetMapping
    public List<Gym> getList(){
        return gymService.findAll();
    }

    @GetMapping("/{id}")
    public Gym getList(@PathVariable("id") int id){
        return gymService.findById(id);
    }


    @PostMapping
    public Gym setGym(@RequestBody GymInsertDTO req){
        Gym gym = GymMapper.INSTANCE.insertRequestToGym(req);

        return gymService.saveGym(gym);
    }

    public void deleteGym(@PathVariable("id") int id){
        gymService.deleteGym(id);
    }
}
