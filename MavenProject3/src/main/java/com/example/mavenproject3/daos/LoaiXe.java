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
@Table(name = "loai_xe")
public class LoaiXe {

    @Id
    @Column(name = "ma_loai_xe")
    private Integer maLoaiXe;

    @Column(name = "mo_ta_loai_xe")
    private String moTaLoaiXe;

    @Column(name = "so_luong_cho_ngoi")
    private Integer soLuongChoNgoi;

    @OneToMany(mappedBy = "loaiXe")
    private Set<Xe> xes;
}
