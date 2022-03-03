package com.example.gym.controller;

import com.example.gym.domain.Gym;
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

    @PostMapping
    public Gym setGym(@RequestBody Gym gym){
        return gymService.saveGym(gym);
    }

    public void deleteGym(@PathVariable("id") int id){
        gymService.deleteGym(id);
    }
}
