package com.example.spring_book_store.Repository;

import com.example.spring_book_store.Entity.BookData;
import com.example.spring_book_store.Entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookData, Integer>
{

//    Optional<BookData> findByBookName(String bookName);
//
//    @Query(value = "select * from book_details b where b.book_name like %:keyword%", nativeQuery = true)
//    List<BookData> findByKeyWord(@Param("keyword") String keyword);
    @Query("select u from BookData u where u.bookName =:c")
    List<BookData> getByBookName(@Param("c") String bookName);

    @Query(value = "select * from book_data order by  price desc",nativeQuery = true)
    List<BookData> getByBookPrice();

    @Query(value = "select * from book_data order by  price ",nativeQuery = true)
    List<BookData> getByBookPriceLowToHigh();



}