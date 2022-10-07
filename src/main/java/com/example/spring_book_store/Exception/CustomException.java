package com.example.spring_book_store.Exception;

public class CustomException extends RuntimeException
{
    public CustomException(String message)
    {
        super(message);
    }
}