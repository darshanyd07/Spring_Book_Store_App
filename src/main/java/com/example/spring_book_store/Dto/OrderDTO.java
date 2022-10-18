package com.example.spring_book_store.Dto;
import lombok.Data;

import java.time.LocalDate;
@Data
public  class OrderDTO
{
    public int cartId;
    public String address;
}