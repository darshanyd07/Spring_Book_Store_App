package com.example.spring_book_store.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data
class EmailData
{
    private String to;
    private String subject;
    private String body;
}