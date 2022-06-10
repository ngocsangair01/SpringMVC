package com.example.buoi2.daos;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "car_type")
public class CarType {
    @Id
    @Column(name = "car_type_id")
    private Integer carTypeId;

    @Column(name = "car_description")
    private String carDescription;

    @Column(name = "seat_number")
    private String seatNumber;

    @OneToMany(mappedBy = "carType")
    private List<Car> cars;

}
