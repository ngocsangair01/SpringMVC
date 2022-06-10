package com.example.buoi2.daos;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "brand")
    private String  brand;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "expire_date")
    private String expireDate;

    @ManyToOne
    @JoinColumn(name = "car_type_id")
    private CarType carType;


}
