package com.example.gym.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int phone;

    @Column
    private String address;

    @Column
    private double width;

    @Column
    private double height;

    @Column
    private int price;

    @Column
    private String img;

    @OneToMany(mappedBy = "gym")
    private List<Order> orders;

//    public Gym setGym(String name, int phone, String address, double width, double height,
//                      int price, String img){
//        this.name = name;
//        this.phone = phone;
//        this.address = address;
//        this.width = width;
//        this.height = height;
//        this.price = price;
//        this.img = img;
//
//        return this;
//    }

}
