package com.example.mavenproject3.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhaXeDTO {
    private Integer maNhaXe;
    private String tenNhaXe;
    private String namThanhlap;
}
