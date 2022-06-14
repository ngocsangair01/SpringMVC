package com.example.buoi3.models;

import com.example.buoi3.bases.BaseEntity;
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
public class Province extends BaseEntity {

    @Column(name = "name")
    @Nationalized
    private String name;

    @Column(name = "code")
    private String code;


    @OneToMany(mappedBy = "province",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<District> districts;

    @OneToMany(mappedBy = "province")
    private List<UserProvince> userProvinces;
}
