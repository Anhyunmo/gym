package com.example.gym.service;

import com.example.gym.domain.Gym;
import com.example.gym.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GymService {

    @Autowired
    GymRepository gymRepository;

    //모든 헬스장 조회
    public List<Gym> findAll(){
        return gymRepository.findAll();
    }

    //특정 헬스장 조회
    public Gym findById(int id){
        return gymRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


    public Gym saveGym(Gym gym){
        return gymRepository.save(gym);
    }

    public void deleteGym(int id){
        gymRepository.deleteById(id);
    }


}
