package com.example.buoi2.daos;

import lombok.*;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @Nationalized
    private String name;

    @Column(name = "address")
    @Nationalized
    private String address;

    @Column(name = "age")
    private String age;
}
