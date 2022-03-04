package com.example.gym.controller;

import com.example.gym.domain.Gym;
import com.example.gym.dto.GymInsertDTO;
import com.example.gym.dto.GymUpdateDTO;
import com.example.gym.mapper.GymMapper;
import com.example.gym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Gym setGym(@Valid @RequestBody GymInsertDTO req){
        Gym gym = GymMapper.INSTANCE.insertRequestToGym(req);

        return gymService.saveGym(gym);
    }

    @PutMapping("/{id}")
    public Gym setGym(@PathVariable("id") int id, @Valid @RequestBody GymUpdateDTO req){
        Gym gym = gymService.findById(id);

//        gym.setName(gymService.findById(req.getId()));

        gymService.saveGym(gym);

        return gym;
    }

    @DeleteMapping
    public void deleteGym(@PathVariable("id") int id){
        gymService.deleteGym(id);
    }
}
