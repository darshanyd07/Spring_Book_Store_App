package com.example.spring_book_store.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ResponseDTO
{
    private String message;
    private Object data;
    private String token;

    public ResponseDTO(String message, Object data)
    {
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(String message, Object data, String token)
    {
        this.message = message;
        this.data = data;
        this.token = token;
    }
}