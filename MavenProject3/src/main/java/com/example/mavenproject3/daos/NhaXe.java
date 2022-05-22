package com.example.mavenproject3.daos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nha_xe")
public class NhaXe {

    @Id
    @Column(name = "ma_nha_xe")
    private Integer maNhaXe;

    @Column(name = "ten_nha_xe")
    private String tenNhaXe;

    @Column(name = "nam_thanh_lap")
    private String namThanhLap;

    @OneToMany(mappedBy = "loaiXe")
    private Set<Xe> xes;
}
