package com.example.buoi3.dtos;

import com.example.buoi3.constant.ResponseMessageEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO<T> {
    private Integer status;
    private ResponseMessageEnum message;
    private T result;
}
