package com.example.mavenproject3.daos;

import com.example.mavenproject3.daos.ids.IdLichTrinhXe;
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
@Table(name = "lich_trinh_xe")
public class LichTrinhXe {
    @EmbeddedId
    private IdLichTrinhXe idLichTrinhXe;

    @ManyToOne
    @JoinColumn(name = "ma_xe")
    @MapsId("maXe")
    private Xe xe;

    @Column(name = "ten_tai_xe")
    private String tenTaiXe;

    @Column(name = "so_luong_hanh_khach")
    private Integer soLuongHanhKhach;

    @ManyToOne
    @JoinColumn(name = "ma_tuyen")
    private TuyenXe tuyenXe;
}
