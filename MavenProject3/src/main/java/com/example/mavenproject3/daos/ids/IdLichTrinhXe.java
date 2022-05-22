package com.example.mavenproject3.daos.ids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class IdLichTrinhXe implements Serializable {
    @Column(name = "ma_xe")
    private Integer maXe;

    @Column(name = "ngay_xuat_ben")
    private String ngayXuatBen;

    @Column(name = "gio_xuat_ben")
    private String gioXuatBen;
}
