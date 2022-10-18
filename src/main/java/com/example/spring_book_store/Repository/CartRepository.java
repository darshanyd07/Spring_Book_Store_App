package com.example.spring_book_store.Repository;

import com.example.spring_book_store.Entity.CartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartData, Integer>
{
}
