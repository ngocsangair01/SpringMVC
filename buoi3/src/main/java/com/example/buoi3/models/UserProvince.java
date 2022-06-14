package com.example.buoi3.models;

import com.example.buoi3.models.ids.UserProvinceId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserProvince {

    @EmbeddedId
    private UserProvinceId userProvinceId;

    @ManyToOne
    @MapsId("idUser")
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;

    @ManyToOne
    @MapsId("idProvince")
    @JoinColumn(name = "id_province")
    @JsonIgnore
    private Province province;

    @Column(name = "family")
    private String family;
}
