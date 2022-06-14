package com.example.buoi3.models.ids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

// Buoc 1: Tao khoa chinh
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class UserProvinceId implements Serializable {

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_province")
    private Integer idProvince;
}
