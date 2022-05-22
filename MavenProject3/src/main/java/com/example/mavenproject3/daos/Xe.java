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
@Table(name = "xe")
public class Xe {

    @Id
    @Column(name = "ma_xe")
    private Integer maXe;

    @Column(name = "hang_san_xuat")
    private String hangSanXuat;

    @Column(name = "bien_so")
    private String bienSo;

    @Column(name = "han_kiem_dinh")
    private String hanKiemDinh;

    @ManyToOne
    @JoinColumn(name = "ma_loai_xe")
    private LoaiXe loaiXe;

    @ManyToOne
    @JoinColumn(name = "ma_nha_xe")
    private NhaXe nhaXe;

    @OneToMany(mappedBy = "xe")
    private Set<LichTrinhXe> lichTrinhXes;

}
