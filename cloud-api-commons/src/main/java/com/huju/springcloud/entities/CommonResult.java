package com.huju.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by huju on 2020/4/6.
 */
@Data
@AllArgsConstructor // 全参构造
@NoArgsConstructor  // 空参构造
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
