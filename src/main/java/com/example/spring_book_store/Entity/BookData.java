package com.example.spring_book_store.Entity;

import com.example.spring_book_store.Dto.BookDTO;
import com.example.spring_book_store.Dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookID;


    private String bookName;
    private String authorName;
    private String bookDescription;
    private String bookImg;
    private int price;
    private int quantity;

    public BookData(int bookID, BookDTO bookDTO)
    {
        this.bookID = bookID;
        this.bookName = bookDTO.bookName;
        this.authorName = bookDTO.authorName;
        this.bookDescription = bookDTO.bookDescription;
        this.bookImg = bookDTO.bookImg;
        this.price = bookDTO.price;
        this.quantity = bookDTO.quantity;

    }
    public BookData(BookDTO bookDTO)
    {

        this.bookName = bookDTO.bookName;
        this.authorName = bookDTO.authorName;
        this.bookDescription = bookDTO.bookDescription;
        this.bookImg = bookDTO.bookImg;
        this.price = bookDTO.price;
        this.quantity = bookDTO.quantity;
    }
}