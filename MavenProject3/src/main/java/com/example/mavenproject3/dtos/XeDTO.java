package com.example.mavenproject3.dtos;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class XeDTO {
    private Integer maXe;
    private String hangSanXuat;
//    xxYx-xxxxx;
    @Pattern(regexp = "[0-9]{2}[A-Z][0-9]-[0-9]{5}",message = "Khong dung dinh dang")
    private String bienSo;

    private String hanKiemDinh;
    private Integer maLoaiXe;
    private Integer maNhaXe;
}
