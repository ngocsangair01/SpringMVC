package com.example.mavenproject3.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TuyenXeDTO {
    private Integer maTuyen;
    private String tenTuyen;
    private Double donGia;
}
