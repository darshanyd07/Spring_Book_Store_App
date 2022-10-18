package com.example.spring_book_store.Dto;

import javax.validation.constraints.*;

public class BookDTO
{
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Book name is Invalid")
    @NotEmpty(message = "Book name cannot be null")
    public String bookName;


    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Author name is Invalid")
    @NotEmpty(message = "Author name cannot be null")
    public String authorName;

    @NotEmpty(message = "Description cannot be null")
    public String bookDescription;

    @NotEmpty(message = "Logo cannot be null")
    public String bookImg;
    @Min(value = 1000,message = "Plz Enter Book Value Minimum 1000........")
    @Max(value = 10000,message = "Plz Enter Book Value Minimum 1000........")
    @NotNull(message = "Price cannot be null")
    public int price;

    @NotNull(message = "Quantity cannot be null")
    public int quantity;
}
