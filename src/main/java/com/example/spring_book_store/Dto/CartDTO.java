package com.example.spring_book_store.Dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
 @Data
public class CartDTO
{
    @NotBlank(message = "User Id Can Not Empty")
    public int userId;
    @NotBlank(message = "Book Id Can Not Empty")
    public int bookId;
    @NotBlank(message = "Quantity Can Not Empty")
    public int quantity;

    public int price;
}
