package com.example.buoi3.models;

import com.example.buoi3.bases.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "name")
    @Nationalized
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "user")
    private Set<UserProvince> userProvinces;
}
