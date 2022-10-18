package com.example.spring_book_store.Service;

import com.example.spring_book_store.Dto.BookDTO;
import com.example.spring_book_store.Dto.UserDTO;
import com.example.spring_book_store.Entity.BookData;
import com.example.spring_book_store.Entity.UserData;

import java.util.List;
import java.util.Optional;

public interface IBookService
{
    BookData addBook(BookData book);

    List<BookData> getAllDetiles();

    Optional<BookData> getById(int id);

    String deleteById(int id);

    String editEmployee(BookDTO bookDTO, int id);
    List<BookData> getByBookName(String bookName);

    List<BookData>getByBookPrice();

    List<BookData> getByBookPriceLowToHigh();
}
