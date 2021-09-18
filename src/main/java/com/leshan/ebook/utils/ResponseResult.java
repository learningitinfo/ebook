package com.leshan.ebook.utils;

import com.leshan.ebook.enums.Status;
import lombok.Data;

@Data
public class ResponseResult<T> {
    private int code;           //状态码
    private Status status;      //状态
    private String message;     //响应的消息
    private T data;             //返回的数据
}
