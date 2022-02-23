package com.example.gym.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    private Timestamp startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "finish_date")
    private Timestamp finishDate;

    @ManyToOne
    @JoinColumn(name = "gym_id", foreignKey = @ForeignKey(name="FK_GYM_TB_ORDER"))
    private Gym gym;

    @ManyToOne
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name="FK_MEMBER_TB_ORDER"))
    private Member member;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Order(Gym gym, Member member, Timestamp startDate, Timestamp finishDate, Status status){
        setOrder(gym,member,startDate,finishDate,status);
    }

    public Order setOrder(Gym gym, Member member, Timestamp startDate, Timestamp finishDate, Status status){
        this.gym = gym;
        this.member = member;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.status = status;
        return this;
    }

    public enum Status{
        사용완료,
        사용중,
        취소완료;
    }

}
