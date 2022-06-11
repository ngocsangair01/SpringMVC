package com.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "provinces")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_province")
    private Integer id;

    @Column(name = "name")
    @Nationalized
    private String name;

    @Column(name = "code")
    private String code;


    @OneToMany(mappedBy = "province",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<District> districts;
}
