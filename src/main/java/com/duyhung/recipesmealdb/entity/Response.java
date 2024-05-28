package com.duyhung.recipesmealdb.entity;

import lombok.Data;

@Data
public class Response<T> {
    private Integer statusCode;
    private String errorMessage;
    private T data;

    public Response(Integer statusCode, String errorMessage, T data) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.data = data;
    }
}
