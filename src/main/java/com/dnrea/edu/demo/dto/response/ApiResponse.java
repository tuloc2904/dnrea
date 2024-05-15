package com.dnrea.edu.demo.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// ko hien thi cac du lieu null khi tra ve
@JsonInclude(JsonInclude.Include.NON_NULL)
// chuan hoa api
public class ApiResponse<T> {
    // thanh cong
    private int code;
    private List<String> message;
    private T result;
}
