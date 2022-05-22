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
@Table(name = "tuyen_xe")
public class TuyenXe {

    @Id
    @Column(name = "ma_tuyen")
    private Integer maTuyen;

    @Column(name = "ten_tuyen")
    private String tenTuyen;

    @Column(name = "don_gia")
    private Double donGia;

    @OneToMany(mappedBy = "tuyenXe")
    private Set<LichTrinhXe> lichTrinhXes;
}
